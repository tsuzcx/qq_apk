package com.tencent.mobileqq.statistics;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker;
import com.tencent.mobileqq.statistics.exreportitem.DC03309ReportItem;
import com.tencent.mobileqq.statistics.exreportitem.EXBaseReportItem;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class EXReportController
{
  private static String a(QQAppInterface paramQQAppInterface, EXBaseReportItem paramEXBaseReportItem, int paramInt)
  {
    if (paramEXBaseReportItem == null) {
      return null;
    }
    return paramEXBaseReportItem.a(paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, DC03309ReportItem paramDC03309ReportItem)
  {
    a("dc03309", paramQQAppInterface, paramDC03309ReportItem);
  }
  
  private static void a(String paramString, QQAppInterface paramQQAppInterface, EXBaseReportItem paramEXBaseReportItem)
  {
    if (paramEXBaseReportItem == null)
    {
      ExceptionTracker.trackException("EXReportController", "EXReport not runtime Tag(" + paramString + ") report item is null");
      if (!QLog.isColorLevel()) {}
    }
    do
    {
      return;
      if ((!TextUtils.isEmpty(paramEXBaseReportItem.i)) && (!TextUtils.isEmpty(paramEXBaseReportItem.k)) && (!TextUtils.isEmpty(paramEXBaseReportItem.j))) {
        break;
      }
    } while (!QLog.isColorLevel());
    return;
    paramEXBaseReportItem.b = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel()) {}
    Object localObject = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localObject = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        localObject = paramQQAppInterface;
        if (localAppRuntime != null)
        {
          localObject = paramQQAppInterface;
          if ((localAppRuntime instanceof QQAppInterface)) {
            localObject = (QQAppInterface)localAppRuntime;
          }
        }
      }
    }
    if (localObject == null)
    {
      paramQQAppInterface = a((QQAppInterface)localObject, paramEXBaseReportItem, 0);
      localObject = new Intent();
      ((Intent)localObject).setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      ((Intent)localObject).putExtra("reporting_tag", paramString);
      ((Intent)localObject).putExtra("reporting_detail", paramQQAppInterface);
      ((Intent)localObject).putExtra("reporting_count", paramEXBaseReportItem.c);
      ((Intent)localObject).putExtra("is_runtime", 0);
      BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
      return;
    }
    a(paramString, (QQAppInterface)localObject, a((QQAppInterface)localObject, paramEXBaseReportItem, 0));
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramString1, paramString2, 1);
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, DC03309ReportItem paramDC03309ReportItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EXReportController", 2, "0339:" + paramDC03309ReportItem);
    }
    a(paramQQAppInterface, paramDC03309ReportItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.EXReportController
 * JD-Core Version:    0.7.0.1
 */