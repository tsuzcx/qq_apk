package com.tencent.qapmsdk.dns.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;

public class NetworkUtils
{
  private static final String TAG = "QAPM_DNS_NetworkUtils";
  private static ConnectivityManager sConnectivityManager;
  private static WifiManager sWifiManager;
  
  public static NetworkUtils.NetworkType getActiveNetworkType()
  {
    int i;
    try
    {
      NetworkInfo localNetworkInfo = sConnectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return NetworkUtils.NetworkType.DISCONNECTED;
      }
      if (!localNetworkInfo.isConnected()) {
        return NetworkUtils.NetworkType.DISCONNECTED;
      }
      i = localNetworkInfo.getType();
      if (i == 1) {
        return NetworkUtils.NetworkType.WIFI;
      }
    }
    catch (Exception localException)
    {
      return NetworkUtils.NetworkType.DISCONNECTED;
    }
    if (i == 0) {
      return NetworkUtils.NetworkType.MOBILE;
    }
    return NetworkUtils.NetworkType.OTHER;
  }
  
  public static String getWifiSsid()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (isWifi()) {
      localObject1 = sWifiManager;
    }
    try
    {
      WifiInfo localWifiInfo = ((WifiManager)localObject1).getConnectionInfo();
      localObject1 = localObject2;
      if (localWifiInfo != null) {
        localObject1 = localWifiInfo.getSSID();
      }
      return localObject1;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static void init(Context paramContext)
  {
    if (sWifiManager == null) {}
    try
    {
      sWifiManager = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (sConnectivityManager != null) {}
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          sConnectivityManager = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
          return;
        }
        catch (Exception paramContext)
        {
          Logger.INSTANCE.exception("QAPM_DNS_NetworkUtils", "get ConnectivityManager failed", paramContext);
        }
        localException = localException;
        Logger.INSTANCE.exception("QAPM_DNS_NetworkUtils", "get WifiManager failed", localException);
      }
    }
  }
  
  public static boolean isValidSSID(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"<unknown ssid>".equals(paramString));
  }
  
  public static boolean isWifi()
  {
    return getActiveNetworkType() == NetworkUtils.NetworkType.WIFI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.network.NetworkUtils
 * JD-Core Version:    0.7.0.1
 */