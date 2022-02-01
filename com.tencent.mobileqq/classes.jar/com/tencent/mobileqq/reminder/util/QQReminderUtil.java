package com.tencent.mobileqq.reminder.util;

import Wallet.AcsMsg;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.ipc.IComIPCUtils;
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
    catch (Exception paramString)
    {
      label25:
      break label25;
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAcsMsg.msg_id);
    localStringBuilder.append("-");
    localStringBuilder.append(paramAcsMsg.sub_time);
    return localStringBuilder.toString();
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
    }
    catch (Exception paramAppRuntime)
    {
      label39:
      break label39;
    }
    a = "getVersionException";
    return a;
  }
  
  public static void a(AcsMsg paramAcsMsg)
  {
    ((IComIPCUtils)QRoute.api(IComIPCUtils.class)).cancelAlarmNotifaction(paramAcsMsg);
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
    ((IComIPCUtils)QRoute.api(IComIPCUtils.class)).removeMessageRecord(paramAcsMsg);
  }
  
  public static void c(AcsMsg paramAcsMsg)
  {
    ((IComIPCUtils)QRoute.api(IComIPCUtils.class)).setAlarmNotifaction(paramAcsMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.util.QQReminderUtil
 * JD-Core Version:    0.7.0.1
 */