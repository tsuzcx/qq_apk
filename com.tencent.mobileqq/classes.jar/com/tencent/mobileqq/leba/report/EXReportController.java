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
      ExceptionTracker.trackException("EXReportController", "[EXReport runtime] Tag(" + paramString + ") report item is null");
      if (QLog.isColorLevel()) {}
    }
    do
    {
      return;
      QLog.d("EXReportController", 2, "[EXReport runtime] tag = " + paramString + "  report item is null");
      return;
      if ((!TextUtils.isEmpty(paramEXBaseReportItem.i)) && (!TextUtils.isEmpty(paramEXBaseReportItem.k)) && (!TextUtils.isEmpty(paramEXBaseReportItem.j))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EXReportController", 2, "[EXReport runtime] tag = " + paramString + " item.sopType must not empty");
    return;
    paramEXBaseReportItem.b = NetConnInfoCenter.getServerTime();
    if (!QLog.isColorLevel()) {}
    while (paramAppRuntime == null)
    {
      paramAppRuntime = a(paramEXBaseReportItem, 1);
      Intent localIntent = new Intent();
      localIntent.setClassName(BaseApplication.getContext(), "com.tencent.mobileqq.statistics.ReportReceiver");
      localIntent.putExtra("reporting_tag", paramString);
      localIntent.putExtra("reporting_detail", paramAppRuntime);
      localIntent.putExtra("reporting_count", paramEXBaseReportItem.c);
      localIntent.putExtra("is_runtime", 1);
      BaseApplication.getContext().sendBroadcast(localIntent);
      return;
      QLog.d("EXReportController", 2, "[EXReport runtime] tag = " + paramString + ", content = " + paramEXBaseReportItem.toString());
    }
    a(paramString, paramAppRuntime, a(paramEXBaseReportItem, 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.report.EXReportController
 * JD-Core Version:    0.7.0.1
 */