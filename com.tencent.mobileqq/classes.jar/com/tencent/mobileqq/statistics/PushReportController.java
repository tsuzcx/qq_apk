package com.tencent.mobileqq.statistics;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class PushReportController
{
  public static boolean a = false;
  
  private static String a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return "unknown";
    }
    int i = NetworkUtil.getNetworkType(paramQQAppInterface.getApp());
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return "unknown";
              }
              return "5G";
            }
            return "4G";
          }
          return "3G";
        }
        return "2G";
      }
      return "Wi-Fi";
    }
    return "none";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, PushReportController.PushReportItem paramPushReportItem)
  {
    paramPushReportItem = b(paramQQAppInterface, paramPushReportItem);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportPushEvent detail=");
      localStringBuilder.append(paramPushReportItem);
      QLog.i("PushReportController", 1, localStringBuilder.toString());
    }
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushReportController", 1, "not Rumtime");
      }
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramQQAppInterface.putExtra("reporting_tag", "dc03266");
      paramQQAppInterface.putExtra("reporting_detail", paramPushReportItem);
      paramQQAppInterface.putExtra("reporting_count", 1);
      paramQQAppInterface.putExtra("is_runtime", 0);
      BaseApplicationImpl.getApplication().sendBroadcast(paramQQAppInterface);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PushReportController", 1, " Rumtime");
    }
    ReportController.b(paramQQAppInterface, "dc03266", paramPushReportItem, 1);
  }
  
  public static void a(String paramString, PushReportController.PushReportItem paramPushReportItem)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("&")))
    {
      paramString = paramString.split("&");
      int i = 0;
      while (i < paramString.length)
      {
        if (paramString[i].contains("pushfrom"))
        {
          String[] arrayOfString = paramString[i].split("=");
          if ((arrayOfString != null) && (arrayOfString.length >= 2)) {
            paramPushReportItem.g = arrayOfString[1];
          }
        }
        i += 1;
      }
    }
  }
  
  private static String b(QQAppInterface paramQQAppInterface, PushReportController.PushReportItem paramPushReportItem)
  {
    paramPushReportItem.a = DeviceInfoUtil.f();
    SosoLbsInfo localSosoLbsInfo = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getSosoInfo();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null)) {
      paramPushReportItem.c = localSosoLbsInfo.mLocation.city;
    }
    paramPushReportItem.b = a(paramQQAppInterface);
    return paramPushReportItem.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.PushReportController
 * JD-Core Version:    0.7.0.1
 */