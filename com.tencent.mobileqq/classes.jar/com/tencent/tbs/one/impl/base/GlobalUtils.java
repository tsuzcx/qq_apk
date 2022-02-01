package com.tencent.tbs.one.impl.base;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class GlobalUtils
{
  private static String sAndroidID;
  private static String sDefaultUserAgent;
  private static String sImei;
  private static String sImsi;
  
  public static String bytesToHexString(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      if ((k & 0xFF) < 16) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(Long.toString(k & 0xFF, 16));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String formatDateTime(long paramLong)
  {
    return String.format(Locale.getDefault(), "%d(%s)", new Object[] { Long.valueOf(paramLong), new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(paramLong)) });
  }
  
  public static List<ActivityManager.RunningAppProcessInfo> getAllRunningProcesses(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null) {
      return null;
    }
    return paramContext.getRunningAppProcesses();
  }
  
  public static String getAndroidID(Context paramContext)
  {
    if (TextUtils.isEmpty(sAndroidID)) {
      sAndroidID = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    }
    return sAndroidID;
  }
  
  public static String getCpuAbi(Context paramContext)
  {
    return Build.CPU_ABI;
  }
  
  public static String getDefaultUserAgent(Context paramContext)
  {
    if (!TextUtils.isEmpty(sDefaultUserAgent)) {
      return sDefaultUserAgent;
    }
    Locale localLocale = Locale.getDefault();
    localStringBuilder = new StringBuilder();
    paramContext = Build.VERSION.RELEASE;
    try
    {
      localObject = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = (Context)localObject;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject;
        continue;
        localStringBuilder.append("en");
      }
    }
    localObject = paramContext;
    if (TextUtils.isEmpty(paramContext)) {
      localObject = "1.0";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("; ");
    paramContext = localLocale.getLanguage();
    if (paramContext != null)
    {
      localStringBuilder.append(paramContext.toLowerCase());
      paramContext = localLocale.getCountry();
      if (paramContext != null)
      {
        localStringBuilder.append("-");
        localStringBuilder.append(paramContext.toLowerCase());
      }
      if ("REL".equals(Build.VERSION.CODENAME)) {
        paramContext = Build.MODEL;
      }
    }
    try
    {
      localObject = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = (Context)localObject;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        continue;
        paramContext = Build.ID.replaceAll("[一-龥]", "");
      }
    }
    localStringBuilder.append("; ");
    localObject = paramContext;
    if (TextUtils.isEmpty(paramContext)) {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    if (Build.ID == null)
    {
      paramContext = null;
      localStringBuilder.append(" Build/");
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        localObject = "00";
      }
      localStringBuilder.append((String)localObject);
      paramContext = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[] { localStringBuilder });
      sDefaultUserAgent = paramContext;
      return paramContext;
    }
  }
  
  public static String getImei(Context paramContext)
  {
    if (TextUtils.isEmpty(sImei)) {
      initializeTelephonyInfo(paramContext);
    }
    return sImei;
  }
  
  public static String getImsi(Context paramContext)
  {
    if (TextUtils.isEmpty(sImsi)) {
      initializeTelephonyInfo(paramContext);
    }
    return sImsi;
  }
  
  private static void initializeTelephonyInfo(Context paramContext)
  {
    if (paramContext.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0)
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      sImei = paramContext.getDeviceId();
      sImsi = paramContext.getSubscriberId();
    }
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      return (paramContext != null) && (paramContext.isConnectedOrConnecting());
    }
    return false;
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      return (paramContext != null) && (paramContext.isConnected()) && (paramContext.getType() == 1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.GlobalUtils
 * JD-Core Version:    0.7.0.1
 */