package com.tencent.mobileqq.statistics;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.mobileqq.statistics.reportitem.CaptureBaseReportItem;
import com.tencent.mobileqq.statistics.reportitem.CaptureMsgReportItem;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class CaptureReportController
{
  private static String a(CaptureBaseReportItem paramCaptureBaseReportItem)
  {
    if (paramCaptureBaseReportItem == null) {
      return null;
    }
    return paramCaptureBaseReportItem.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, CaptureMsgReportItem paramCaptureMsgReportItem)
  {
    a("dc02181", paramQQAppInterface, paramCaptureMsgReportItem);
  }
  
  private static void a(String paramString, QQAppInterface paramQQAppInterface, CaptureBaseReportItem paramCaptureBaseReportItem)
  {
    if (paramCaptureBaseReportItem == null)
    {
      ExceptionTracker.trackException("CaptureReportController", "Capture Report not runtime Tag(" + paramString + ") report item is null");
      if (!QLog.isColorLevel()) {}
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramCaptureBaseReportItem.c)) {
        break;
      }
    } while (!QLog.isColorLevel());
    return;
    if (QLog.isColorLevel()) {}
    QQAppInterface localQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localQQAppInterface = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        localQQAppInterface = paramQQAppInterface;
        if (localAppRuntime != null)
        {
          localQQAppInterface = paramQQAppInterface;
          if ((localAppRuntime instanceof QQAppInterface)) {
            localQQAppInterface = (QQAppInterface)localAppRuntime;
          }
        }
      }
    }
    if (localQQAppInterface == null)
    {
      paramQQAppInterface = a(paramCaptureBaseReportItem);
      paramCaptureBaseReportItem = new Intent();
      paramCaptureBaseReportItem.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramCaptureBaseReportItem.putExtra("reporting_tag", paramString);
      paramCaptureBaseReportItem.putExtra("reporting_detail", paramQQAppInterface);
      paramCaptureBaseReportItem.putExtra("reporting_count", 1);
      paramCaptureBaseReportItem.putExtra("is_runtime", 0);
      BaseApplicationImpl.getApplication().sendBroadcast(paramCaptureBaseReportItem);
      return;
    }
    b(paramString, localQQAppInterface, a(paramCaptureBaseReportItem));
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (paramQQAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureReportController", 2, "app or detail invalid. app : " + paramQQAppInterface + "  detail : " + paramString2);
      }
      return;
    }
    String str = paramString2;
    if (paramString2.contains("${count_unknown}")) {
      str = paramString2.replace("${count_unknown}", "1");
    }
    paramString2 = new NewIntent(paramQQAppInterface.getApplication(), ReportServlet.class);
    paramString2.putExtra("sendType", 2);
    paramString2.putExtra("tag", paramString1);
    paramString2.putExtra("content", str);
    paramString2.setWithouLogin(true);
    paramQQAppInterface.startServlet(paramString2);
  }
  
  public static void b(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (paramQQAppInterface == null)) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a(paramString1, paramString2, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.CaptureReportController
 * JD-Core Version:    0.7.0.1
 */