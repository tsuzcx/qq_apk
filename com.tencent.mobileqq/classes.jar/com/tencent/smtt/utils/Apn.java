package com.tencent.smtt.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;

public class Apn
{
  public static final int APN_2G = 1;
  public static final int APN_3G = 2;
  public static final int APN_4G = 4;
  public static final int APN_UNKNOWN = 0;
  public static final int APN_WIFI = 3;
  
  public static String getApnInfo(Context paramContext)
  {
    String str = "unknown";
    for (;;)
    {
      try
      {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        paramContext = str;
        if (localNetworkInfo != null)
        {
          paramContext = str;
          if (localNetworkInfo.isConnectedOrConnecting())
          {
            int i = localNetworkInfo.getType();
            if (i != 0)
            {
              if (i == 1) {
                break label59;
              }
              return "unknown";
            }
            paramContext = localNetworkInfo.getExtraInfo();
          }
        }
        return paramContext;
      }
      catch (Exception paramContext)
      {
        return "unknown";
      }
      label59:
      paramContext = "wifi";
    }
  }
  
  public static int getApnType(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    int i = 1;
    if ((paramContext != null) && (paramContext.isConnectedOrConnecting()))
    {
      int j = paramContext.getType();
      if (j != 0)
      {
        if (j != 1) {
          break label131;
        }
        return 3;
      }
    }
    switch (paramContext.getSubtype())
    {
    default: 
      break;
    case 13: 
      return 4;
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      return 2;
      label131:
      i = 0;
    }
    return i;
  }
  
  public static String getWifiSSID(Context paramContext)
  {
    Object localObject = null;
    try
    {
      WifiInfo localWifiInfo = NetworkMonitor.getConnectionInfo((WifiManager)paramContext.getSystemService("wifi"));
      paramContext = localObject;
      if (localWifiInfo != null) {
        paramContext = localWifiInfo.getBSSID();
      }
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext == null) {
      return false;
    }
    return (paramContext.isConnected()) || (paramContext.isAvailable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.Apn
 * JD-Core Version:    0.7.0.1
 */