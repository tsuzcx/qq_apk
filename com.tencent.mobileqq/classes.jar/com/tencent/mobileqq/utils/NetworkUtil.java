package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import bizo;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;

public class NetworkUtil
{
  public static String IntAddr2Ip(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt & 0xFF).append(".").append(paramInt >> 8 & 0xFF).append(".").append(paramInt >> 16 & 0xFF).append(".").append(paramInt >> 24 & 0xFF);
    return localStringBuffer.toString();
  }
  
  public static String getApn(Context paramContext)
  {
    return NetworkState.getAPN();
  }
  
  public static int getConnRetryTimes(int paramInt)
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
  
  public static String getCurrentWifiSSID(Context paramContext)
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
  
  public static int getNetworkType(Context paramContext)
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
  
  public static int getSystemNetwork(Context paramContext)
  {
    int j = HttpUtil.getNetWorkType();
    int i = j;
    if (j == -1) {
      i = 2;
    }
    return i;
  }
  
  public static boolean is3Gor4G(Context paramContext)
  {
    int i = bizo.a(paramContext);
    return (i == 4) || (i == 3);
  }
  
  public static boolean isAirplaneModeOn(Context paramContext)
  {
    return HwNetworkUtil.isAirplaneModeOn(paramContext);
  }
  
  @TargetApi(13)
  public static boolean isBluetoothSharedNetwork(Context paramContext)
  {
    return (Build.VERSION.SDK_INT >= 13) && (getNetworkType(paramContext) == 7);
  }
  
  public static boolean isMobileNetWork(Context paramContext)
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean isMobileNetworkInfo(NetworkInfo paramNetworkInfo)
  {
    return HwNetworkUtil.isMobileNetworkInfo(paramNetworkInfo);
  }
  
  public static boolean isNetSupport(Context paramContext)
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public static boolean isNetSupportHw(Context paramContext)
  {
    return HwNetworkUtil.isNetSupport(paramContext);
  }
  
  public static boolean isNetworkAvailable()
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    return NetworkState.isWifiConn();
  }
  
  public static boolean isWifiEnabled(Context paramContext)
  {
    return AppNetConnInfo.isWifiConn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */