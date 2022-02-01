package com.tencent.qqmini.sdk.core.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class NetworkUtil
{
  public static final String TAG = "NetworkUtil";
  
  public static int getActiveNetworkType(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
      {
        int i = localNetworkInfo.getType();
        if (i != 9) {}
        switch (i)
        {
        case 0: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
          i = getMobileNetworkType(paramContext);
          return i;
          return 5;
        }
      }
    }
    catch (Throwable paramContext)
    {
      QMLog.e("NetworkUtil", "fail to get active network info", paramContext);
    }
    return 0;
    return 0;
    return 1;
  }
  
  public static String getCurrentWifiSSID(Context paramContext)
  {
    try
    {
      paramContext = NetworkMonitor.getConnectionInfo((WifiManager)paramContext.getSystemService("wifi"));
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
      QMLog.e("NetworkUtil", "fail to get active network info", paramContext);
    }
    return null;
  }
  
  private static int getMobileNetworkType(Context paramContext)
  {
    switch (((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType())
    {
    case 4: 
    case 7: 
    case 11: 
    default: 
      return 2;
    case 13: 
      return 4;
    }
    return 3;
  }
  
  public static String getNetWorkTypeByStr(Context paramContext)
  {
    int i = getActiveNetworkType(paramContext);
    paramContext = "UNKNOWN";
    switch (i)
    {
    default: 
      return "UNKNOWN";
    case 5: 
      return "CABLE";
    case 4: 
      return "4G";
    case 3: 
      return "3G";
    case 2: 
      return "2G";
    case 1: 
      return "WIFI";
    case 0: 
      paramContext = "NONE";
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */