package com.tencent.mobileqq.servlet;

import NS_USER_ACTION_REPORT.QQSchemaInfo;
import NS_USER_ACTION_REPORT.QQStayTimeInfo;
import NS_USER_ACTION_REPORT.UserActionReport;
import NS_USER_ACTION_REPORT.UserActionReportRsp;
import NS_USER_ACTION_REPORT.UserCommReport;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportRequest;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class MobileReportServlet
  extends MSFServlet
{
  public static void a(int paramInt, AppRuntime paramAppRuntime, UserCommReport paramUserCommReport, ArrayList<UserActionReport> paramArrayList)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), MobileReportServlet.class);
    localNewIntent.putExtra("userCommReport", paramUserCommReport);
    localNewIntent.putExtra("reportInfos", paramArrayList);
    localNewIntent.putExtra("type", paramInt);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public static void a(int paramInt, AppRuntime paramAppRuntime, UserCommReport paramUserCommReport, ArrayList<UserActionReport> paramArrayList, ArrayList<QQStayTimeInfo> paramArrayList1, ArrayList<QQSchemaInfo> paramArrayList2)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), MobileReportServlet.class);
    localNewIntent.putExtra("userCommReport", paramUserCommReport);
    localNewIntent.putExtra("reportInfos", paramArrayList);
    localNewIntent.putExtra("type", paramInt);
    localNewIntent.putExtra("qqStayTimeInfo", paramArrayList1);
    localNewIntent.putExtra("qqSchemaInfo", paramArrayList2);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public static void a(int paramInt, AppRuntime paramAppRuntime, ArrayList<QQStayTimeInfo> paramArrayList, UserCommReport paramUserCommReport)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), MobileReportServlet.class);
    localNewIntent.putExtra("type", paramInt);
    localNewIntent.putExtra("userCommReport", paramUserCommReport);
    localNewIntent.putExtra("qqStayTimeInfo", paramArrayList);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public static void a(AppRuntime paramAppRuntime, UserCommReport paramUserCommReport, ArrayList<UserActionReport> paramArrayList)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), MobileReportServlet.class);
    localNewIntent.putExtra("userCommReport", paramUserCommReport);
    localNewIntent.putExtra("reportInfos", paramArrayList);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {}
    for (int i = paramFromServiceMsg.getResultCode();; i = -1)
    {
      new Bundle().putString("msg", "servlet result code is " + i);
      QLog.d("MobileReport.Servlet", 2, "report onReceive onSend");
      if (i == 1000)
      {
        paramIntent = MobileReportRequest.onResponse(paramFromServiceMsg.getWupBuffer());
        if ((paramIntent != null) && (paramIntent.report_interval > 0L))
        {
          com.tencent.mobileqq.vastrash.uec.UECPageStayReportManager.a = paramIntent.report_interval;
          QLog.d("MobileReport.Servlet", 2, "get onReceive onSend sReportTime = " + paramIntent.report_interval);
        }
      }
      return;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = new MobileReportRequest(paramIntent.getIntExtra("type", 1), (UserCommReport)paramIntent.getSerializableExtra("userCommReport"), (ArrayList)paramIntent.getSerializableExtra("reportInfos"), (ArrayList)paramIntent.getSerializableExtra("qqStayTimeInfo"), (ArrayList)paramIntent.getSerializableExtra("qqSchemaInfo"));
    paramPacket.setTimeout(10000L);
    paramPacket.setSSOCommand(paramIntent.getCmdString());
    paramPacket.putSendData(paramIntent.encode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.MobileReportServlet
 * JD-Core Version:    0.7.0.1
 */