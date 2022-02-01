package com.tencent.mobileqq.reminder.util;

import Wallet.AcsMsg;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.api.IQQComIPC;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import mqq.app.AppRuntime;

public class QQReminderUtil
{
  private static String a;
  
  public static long a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    localCalendar.setTimeInMillis(paramLong);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static String a(long paramLong, String paramString)
  {
    try
    {
      paramString = new SimpleDateFormat(paramString, Locale.SIMPLIFIED_CHINESE).format(new Date(paramLong));
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static String a(AcsMsg paramAcsMsg)
  {
    if (paramAcsMsg == null) {
      return null;
    }
    if (paramAcsMsg.type == 0) {
      return paramAcsMsg.msg_id;
    }
    return paramAcsMsg.msg_id + "-" + paramAcsMsg.sub_time;
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    try
    {
      paramAppRuntime = paramAppRuntime.getApplicationContext();
      a = paramAppRuntime.getPackageManager().getPackageInfo(paramAppRuntime.getPackageName(), 0).versionName;
      return a;
    }
    catch (Exception paramAppRuntime)
    {
      for (;;)
      {
        a = "getVersionException";
      }
    }
  }
  
  public static void a(AcsMsg paramAcsMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("req_param", paramAcsMsg);
    ((IQQComIPC)QRoute.api(IQQComIPC.class)).cancelAlarmNotifaction(localBundle);
  }
  
  public static boolean a(long paramLong)
  {
    return a(paramLong, "yyyy-MM-dd");
  }
  
  private static boolean a(long paramLong, String paramString)
  {
    Date localDate = new Date(paramLong);
    paramString = new SimpleDateFormat(paramString, Locale.SIMPLIFIED_CHINESE);
    return paramString.format(localDate).equals(paramString.format(new Date(NetConnInfoCenter.getServerTimeMillis())));
  }
  
  public static void b(AcsMsg paramAcsMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("req_param", paramAcsMsg);
    ((IQQComIPC)QRoute.api(IQQComIPC.class)).removeMessageRecord(localBundle);
  }
  
  public static void c(AcsMsg paramAcsMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("req_param", paramAcsMsg);
    ((IQQComIPC)QRoute.api(IQQComIPC.class)).setAlarmNotifaction(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.util.QQReminderUtil
 * JD-Core Version:    0.7.0.1
 */