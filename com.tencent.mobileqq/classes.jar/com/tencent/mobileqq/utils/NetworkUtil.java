package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;

public class NetworkUtil
{
  public static int a()
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      return 0;
      if (AppNetConnInfo.isWifiConn()) {
        return 1;
      }
    } while (!AppNetConnInfo.isMobileConn());
    switch (AppNetConnInfo.getMobileInfo())
    {
    case -1: 
    default: 
      return -1;
    case 0: 
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 4;
    }
    return 4;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 2;
    case 1: 
    case 4: 
    case 5: 
      return 4;
    }
    return 3;
  }
  
  public static int a(Context paramContext)
  {
    int j = a();
    int i = j;
    if (j == -1) {
      i = 2;
    }
    return i;
  }
  
  public static String a(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt & 0xFF).append(".").append(paramInt >> 8 & 0xFF).append(".").append(paramInt >> 16 & 0xFF).append(".").append(paramInt >> 24 & 0xFF);
    return localStringBuffer.toString();
  }
  
  public static String a(Context paramContext)
  {
    if (AppNetConnInfo.isWifiConn()) {
      paramContext = "wifi";
    }
    String str;
    do
    {
      return paramContext;
      str = AppNetConnInfo.getCurrentAPN();
      paramContext = str;
    } while (!TextUtils.isEmpty(str));
    return "unknown";
  }
  
  public static boolean a()
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public static boolean a(Context paramContext)
  {
    return AppNetConnInfo.isWifiConn();
  }
  
  public static boolean a(NetworkInfo paramNetworkInfo)
  {
    return HwNetworkUtil.isMobileNetworkInfo(paramNetworkInfo);
  }
  
  public static int b(Context paramContext)
  {
    int j = -1;
    int i = j;
    if (AppNetConnInfo.isNetSupport())
    {
      paramContext = AppNetConnInfo.getRecentNetworkInfo();
      i = j;
      if (paramContext != null) {
        i = paramContext.getType();
      }
    }
    return i;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if ((paramContext != null) && (paramContext.getSSID() != null))
      {
        paramContext = paramContext.getSSID().replaceAll("\"", "");
        boolean bool = paramContext.equals("<unknown ssid>");
        if (!bool) {
          return paramContext;
        }
        return null;
      }
    }
    catch (Throwable paramContext)
    {
      QLog.e("NetworkUtil", 1, "fail to get active network info", paramContext);
      return null;
    }
    paramContext = null;
    return paramContext;
  }
  
  public static boolean b(Context paramContext)
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean c(Context paramContext)
  {
    int i = a();
    return (i == 4) || (i == 3);
  }
  
  public static boolean d(Context paramContext)
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public static boolean e(Context paramContext)
  {
    return HwNetworkUtil.isNetSupport(paramContext);
  }
  
  @TargetApi(13)
  public static boolean f(Context paramContext)
  {
    return (Build.VERSION.SDK_INT >= 13) && (b(paramContext) == 7);
  }
  
  public static boolean g(Context paramContext)
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public static boolean h(Context paramContext)
  {
    return AppNetConnInfo.isWifiConn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */