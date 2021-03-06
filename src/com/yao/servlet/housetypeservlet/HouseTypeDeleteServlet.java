package com.yao.servlet.housetypeservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.housetypedao.HouseTypeDao;

public class HouseTypeDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("houseTypeId")!=null){
			HouseTypeDao htd=new HouseTypeDao();
			int houseTypeId=Integer.valueOf(req.getParameter("houseTypeId"));
			int i=0;
			try {
				i=htd.delete(houseTypeId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==1)
				req.setAttribute("info", "删除成功");
			else
				req.setAttribute("info", "删除失败");
		}else{
			req.setAttribute("info", "删除失败");
		}
		req.getRequestDispatcher("/view/houseType/houseType_save.jsp").forward(req, resp);
	}
	
}
