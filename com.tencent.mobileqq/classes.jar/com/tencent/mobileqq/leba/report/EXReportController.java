package com.tencent.mobileqq.leba.report;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class EXReportController
{
  private static String a(EXBaseReportItem paramEXBaseReportItem, int paramInt)
  {
    if (paramEXBaseReportItem == null) {
      return null;
    }
    return paramEXBaseReportItem.a(paramInt);
  }
  
  public static void a(String paramString1, AppRuntime paramAppRuntime, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      String str = paramString2;
      if (paramString2.contains("${count_unknown}")) {
        str = paramString2.replace("${count_unknown}", "1");
      }
      paramString2 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString2.putExtra("sendType", 2);
      paramString2.putExtra("tag", paramString1);
      paramString2.putExtra("content", str);
      paramString2.setWithouLogin(true);
      paramAppRuntime.startServlet(paramString2);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, DC03309ReportItem paramDC03309ReportItem)
  {
    a(paramAppRuntime, "dc03309", paramDC03309ReportItem);
  }
  
  private static void a(AppRuntime paramAppRuntime, String paramString, EXBaseReportItem paramEXBaseReportItem)
  {
    if (paramEXBaseReportItem == null)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("[EXReport runtime] Tag(");
      paramAppRuntime.append(paramString);
      paramAppRuntime.append(") report item is null");
      ExceptionTracker.trackException("EXReportController", paramAppRuntime.toString());
      if (!QLog.isColorLevel()) {
        return;
      }
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("[EXReport runtime] tag = ");
      paramAppRuntime.append(paramString);
      paramAppRuntime.append("  report item is null");
      QLog.d("EXReportController", 2, paramAppRuntime.toString());
      return;
    }
    if ((!TextUtils.isEmpty(paramEXBaseReportItem.k)) && (!TextUtils.isEmpty(paramEXBaseReportItem.m)) && (!TextUtils.isEmpty(paramEXBaseReportItem.l)))
    {
      paramEXBaseReportItem.j = NetConnInfoCenter.getServerTime();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[EXReport runtime] tag = ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(", content = ");
        ((StringBuilder)localObject).append(paramEXBaseReportItem.toString());
        QLog.d("EXReportController", 2, ((StringBuilder)localObject).toString());
      }
      if (paramAppRuntime == null)
      {
        paramAppRuntime = a(paramEXBaseReportItem, 1);
        localObject = new Intent();
        ((Intent)localObject).setClassName(BaseApplication.getContext(), "com.tencent.mobileqq.statistics.ReportReceiver");
        ((Intent)localObject).putExtra("reporting_tag", paramString);
        ((Intent)localObject).putExtra("reporting_detail", paramAppRuntime);
        ((Intent)localObject).putExtra("reporting_count", paramEXBaseReportItem.p);
        ((Intent)localObject).putExtra("is_runtime", 1);
        BaseApplication.getContext().sendBroadcast((Intent)localObject);
        return;
      }
      a(paramString, paramAppRuntime, a(paramEXBaseReportItem, 1));
      return;
    }
    if (!QLog.isColorLevel()) {
      return;
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("[EXReport runtime] tag = ");
    paramAppRuntime.append(paramString);
    paramAppRuntime.append(" item.sopType must not empty");
    QLog.d("EXReportController", 2, paramAppRuntime.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.report.EXReportController
 * JD-Core Version:    0.7.0.1
 */