package com.tencent.weiyun.utils;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;

public class NetworkUtils
{
  public static final int NETWORK_TYPE_2G = 1;
  public static final int NETWORK_TYPE_3G = 2;
  public static final int NETWORK_TYPE_UNKNOWN = 0;
  public static final int NETWORK_TYPE_WIFI = 3;
  private static final String TAG = "NetworkUtils";
  private static NetworkUtils.INetworkInfoProvider sNetworkInfoProvider;
  
  public static String convert2IP(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt & 0xFF);
    localStringBuffer.append('.');
    paramInt >>>= 8;
    localStringBuffer.append(paramInt & 0xFF);
    localStringBuffer.append('.');
    paramInt >>>= 8;
    localStringBuffer.append(paramInt & 0xFF);
    localStringBuffer.append('.');
    localStringBuffer.append(paramInt >>> 8 & 0xFF);
    return localStringBuffer.toString();
  }
  
  private static int convertNetworkType(int paramInt)
  {
    int i = 3;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if ((paramInt != 3) && (paramInt != 4)) {
          return 0;
        }
        return 2;
      }
      i = 1;
    }
    return i;
  }
  
  public static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    NetworkUtils.INetworkInfoProvider localINetworkInfoProvider = sNetworkInfoProvider;
    if (localINetworkInfoProvider == null) {
      return null;
    }
    return localINetworkInfoProvider.getNetworkInfo(paramContext);
  }
  
  public static String getDnsInfo(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getDhcpInfo();
    if (paramContext == null) {
      return "none";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(convert2IP(paramContext.dns1));
    localStringBuilder.append(';');
    localStringBuilder.append(convert2IP(paramContext.dns2));
    return localStringBuilder.toString();
  }
  
  public static int getNetworkType(Context paramContext)
  {
    paramContext = getActiveNetworkInfo(paramContext);
    if ((paramContext != null) && (paramContext.isConnected())) {
      return convertNetworkType(getNetworkType(paramContext));
    }
    return 0;
  }
  
  private static int getNetworkType(NetworkInfo paramNetworkInfo)
  {
    int j = paramNetworkInfo.getType();
    int i = 1;
    if (j != 0)
    {
      if (j == 1) {
        return i;
      }
    }
    else {
      switch (paramNetworkInfo.getSubtype())
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
        return 3;
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        return 2;
      }
    }
    i = 0;
    return i;
  }
  
  public static int getNetworkTypeDiff4G(Context paramContext)
  {
    paramContext = getActiveNetworkInfo(paramContext);
    if ((paramContext != null) && (paramContext.isConnected())) {
      return getNetworkType(paramContext);
    }
    return 0;
  }
  
  public static String getWifiBSSID(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = getWifiInfo(paramContext);
    if (paramContext == null) {
      return null;
    }
    return paramContext.getBSSID();
  }
  
  public static WifiInfo getWifiInfo(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext == null) {
      return null;
    }
    return NetworkMonitor.getConnectionInfo(paramContext);
  }
  
  public static String getWifiMacAddress(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = getWifiInfo(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.getMacAddress();
      if (paramContext != null) {
        return paramContext.toLowerCase().replaceAll(":", "-");
      }
      Log.w("NetworkUtils", "mac address is null!");
      return null;
    }
    Log.w("NetworkUtils", "can *NOT* get connect info when get mac address!");
    return null;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = getActiveNetworkInfo(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static boolean isWifiAvailable(Context paramContext)
  {
    paramContext = getActiveNetworkInfo(paramContext);
    return (paramContext != null) && (paramContext.isConnected()) && (paramContext.getType() == 1);
  }
  
  public static void setNetworkInfoProvider(NetworkUtils.INetworkInfoProvider paramINetworkInfoProvider)
  {
    if ((sNetworkInfoProvider == null) && (paramINetworkInfoProvider != null)) {
      sNetworkInfoProvider = paramINetworkInfoProvider;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.utils.NetworkUtils
 * JD-Core Version:    0.7.0.1
 */