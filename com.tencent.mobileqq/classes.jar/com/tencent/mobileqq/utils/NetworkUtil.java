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
  public static final String APN_UNKNOWN = "unknown";
  public static final String APN_WIFI = "wifi";
  
  public static String getApn(Context paramContext)
  {
    if (AppNetConnInfo.isWifiConn()) {
      return "wifi";
    }
    String str = AppNetConnInfo.getCurrentAPN();
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = "unknown";
    }
    return paramContext;
  }
  
  public static int getConnRetryTimes(int paramInt)
  {
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if ((paramInt != 4) && (paramInt != 5)) {
            return 2;
          }
        }
        else {
          return 3;
        }
      }
      else {
        return 2;
      }
    }
    return 4;
  }
  
  public static String getCurrentWifiSSID(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext != null)
      {
        if (paramContext.getSSID() == null) {
          return null;
        }
        paramContext = paramContext.getSSID().replaceAll("\"", "");
        boolean bool = paramContext.equals("<unknown ssid>");
        if (bool) {
          return null;
        }
        return paramContext;
      }
      return null;
    }
    catch (Throwable paramContext)
    {
      QLog.e("NetworkUtil", 1, "fail to get active network info", paramContext);
    }
    return null;
  }
  
  public static int getNetWorkType()
  {
    boolean bool = AppNetConnInfo.isNetSupport();
    int j = 0;
    if (!bool) {
      return 0;
    }
    if (AppNetConnInfo.isWifiConn()) {
      return 1;
    }
    int i = j;
    if (AppNetConnInfo.isMobileConn())
    {
      int k = AppNetConnInfo.getMobileInfo();
      i = j;
      if (k != -1)
      {
        j = 2;
        i = j;
        if (k != 0)
        {
          i = j;
          if (k != 1)
          {
            if (k != 2)
            {
              if ((k != 3) && (k != 4)) {
                return -1;
              }
              return 4;
            }
            return 3;
          }
        }
      }
    }
    return i;
  }
  
  public static int getNetworkType(Context paramContext)
  {
    if (AppNetConnInfo.isNetSupport())
    {
      paramContext = AppNetConnInfo.getRecentNetworkInfo();
      if (paramContext != null) {
        return paramContext.getType();
      }
    }
    return -1;
  }
  
  public static int getSystemNetwork(Context paramContext)
  {
    int j = getNetWorkType();
    int i = j;
    if (j == -1) {
      i = 2;
    }
    return i;
  }
  
  public static String intAddr2Ip(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt & 0xFF);
    localStringBuffer.append(".");
    localStringBuffer.append(paramInt >> 8 & 0xFF);
    localStringBuffer.append(".");
    localStringBuffer.append(paramInt >> 16 & 0xFF);
    localStringBuffer.append(".");
    localStringBuffer.append(paramInt >> 24 & 0xFF);
    return localStringBuffer.toString();
  }
  
  public static boolean is3Gor4G(Context paramContext)
  {
    int i = getNetWorkType();
    return (i == 4) || (i == 3);
  }
  
  public static boolean is4G(Context paramContext)
  {
    return getNetWorkType() == 4;
  }
  
  public static boolean is5G(Context paramContext)
  {
    return getNetWorkType() == 4;
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
    return AppNetConnInfo.isWifiConn();
  }
  
  public static boolean isWifiEnabled(Context paramContext)
  {
    return AppNetConnInfo.isWifiConn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */