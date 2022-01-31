package com.tencent.mobileqq.statistics;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.mobileqq.statistics.reportitem.QIMBaseReportItem;
import com.tencent.mobileqq.statistics.reportitem.QIMMsgReportItem;
import com.tencent.mobileqq.statistics.reportitem.QIMNewReportItem;
import com.tencent.mobileqq.statistics.reportitem.QIMReadWriteReportItem;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class QIMReportController
{
  private static String a(QQAppInterface paramQQAppInterface)
  {
    switch (NetworkUtil.b(paramQQAppInterface.getApp()))
    {
    default: 
      return "unknown";
    case 0: 
      return "none";
    case 1: 
      return "Wi-Fi";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    case 4: 
      return "4G";
    }
    return "5G";
  }
  
  private static String a(QQAppInterface paramQQAppInterface, QIMBaseReportItem paramQIMBaseReportItem, int paramInt)
  {
    if (paramQIMBaseReportItem == null) {
      return null;
    }
    paramQIMBaseReportItem.a = DeviceInfoUtil.e();
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.b();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null)) {
      paramQIMBaseReportItem.c = localSosoLbsInfo.a.e;
    }
    if (paramQQAppInterface == null) {}
    for (paramQIMBaseReportItem.b = "${network_unknown}";; paramQIMBaseReportItem.b = a(paramQQAppInterface)) {
      return paramQIMBaseReportItem.a(paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, QIMMsgReportItem paramQIMMsgReportItem)
  {
    a("dc01982", paramQQAppInterface, paramQIMMsgReportItem);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, QIMReadWriteReportItem paramQIMReadWriteReportItem)
  {
    a("dc01983", paramQQAppInterface, paramQIMReadWriteReportItem);
  }
  
  private static void a(String paramString, QQAppInterface paramQQAppInterface, QIMBaseReportItem paramQIMBaseReportItem)
  {
    if (paramQIMBaseReportItem == null)
    {
      ExceptionTracker.trackException("QIMReportController", "[QIM Report runtime] Tag(" + paramString + ") report item is null");
      if (!QLog.isColorLevel()) {}
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramQIMBaseReportItem.d)) {
        break;
      }
    } while (!QLog.isColorLevel());
    return;
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
      paramQQAppInterface = a((QQAppInterface)localObject, paramQIMBaseReportItem, 1);
      localObject = new Intent();
      ((Intent)localObject).setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      ((Intent)localObject).putExtra("reporting_tag", paramString);
      ((Intent)localObject).putExtra("reporting_detail", paramQQAppInterface);
      if ((paramQIMBaseReportItem instanceof QIMNewReportItem)) {
        ((Intent)localObject).putExtra("reporting_count", 0);
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("is_runtime", 1);
        BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
        return;
        if ((paramQIMBaseReportItem instanceof QIMMsgReportItem)) {
          ((Intent)localObject).putExtra("reporting_count", ((QIMMsgReportItem)paramQIMBaseReportItem).a);
        } else if ((paramQIMBaseReportItem instanceof QIMReadWriteReportItem)) {
          ((Intent)localObject).putExtra("reporting_count", ((QIMReadWriteReportItem)paramQIMBaseReportItem).a);
        }
      }
    }
    a(paramString, (QQAppInterface)localObject, a((QQAppInterface)localObject, paramQIMBaseReportItem, 1));
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      Object localObject = paramString2;
      if (paramQQAppInterface != null)
      {
        localObject = paramString2;
        if (paramString2.contains("${network_unknown}")) {
          localObject = paramString2.replace("${network_unknown}", a(paramQQAppInterface));
        }
      }
      paramString2 = (String)localObject;
      if (((String)localObject).contains("${count_unknown}")) {
        paramString2 = ((String)localObject).replace("${count_unknown}", "1");
      }
      localObject = new NewIntent(paramQQAppInterface.getApplication(), ReportServlet.class);
      ((NewIntent)localObject).putExtra("sendType", 2);
      ((NewIntent)localObject).putExtra("tag", paramString1);
      ((NewIntent)localObject).putExtra("content", paramString2);
      ((NewIntent)localObject).setWithouLogin(true);
      paramQQAppInterface.startServlet((NewIntent)localObject);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, QIMMsgReportItem paramQIMMsgReportItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMReportController", 2, "1982:" + paramQIMMsgReportItem);
    }
    a(paramQQAppInterface, paramQIMMsgReportItem);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, QIMReadWriteReportItem paramQIMReadWriteReportItem)
  {
    b("dc01983", paramQQAppInterface, paramQIMReadWriteReportItem);
  }
  
  private static void b(String paramString, QQAppInterface paramQQAppInterface, QIMBaseReportItem paramQIMBaseReportItem)
  {
    if (paramQIMBaseReportItem == null)
    {
      ExceptionTracker.trackException("QIMReportController", "QIM Report not runtime Tag(" + paramString + ") report item is null");
      if (!QLog.isColorLevel()) {}
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramQIMBaseReportItem.d)) {
        break;
      }
    } while (!QLog.isColorLevel());
    return;
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
      paramQQAppInterface = a((QQAppInterface)localObject, paramQIMBaseReportItem, 0);
      localObject = new Intent();
      ((Intent)localObject).setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      ((Intent)localObject).putExtra("reporting_tag", paramString);
      ((Intent)localObject).putExtra("reporting_detail", paramQQAppInterface);
      if ((paramQIMBaseReportItem instanceof QIMNewReportItem)) {
        ((Intent)localObject).putExtra("reporting_count", 0);
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("is_runtime", 0);
        BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
        return;
        if ((paramQIMBaseReportItem instanceof QIMMsgReportItem)) {
          ((Intent)localObject).putExtra("reporting_count", ((QIMMsgReportItem)paramQIMBaseReportItem).a);
        } else if ((paramQIMBaseReportItem instanceof QIMReadWriteReportItem)) {
          ((Intent)localObject).putExtra("reporting_count", ((QIMReadWriteReportItem)paramQIMBaseReportItem).a);
        }
      }
    }
    b(paramString, (QQAppInterface)localObject, a((QQAppInterface)localObject, paramQIMBaseReportItem, 0));
  }
  
  public static void b(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      String str = paramString2;
      if (paramQQAppInterface != null)
      {
        str = paramString2;
        if (paramString2.contains("${network_unknown}")) {
          str = paramString2.replace("${network_unknown}", a(paramQQAppInterface));
        }
      }
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramString1, str, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.QIMReportController
 * JD-Core Version:    0.7.0.1
 */