package com.tencent.qapmsdk.dns.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;

public class b
{
  private static WifiManager a;
  private static ConnectivityManager b;
  
  public static b.a a()
  {
    int i;
    try
    {
      NetworkInfo localNetworkInfo = b.getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return b.a.a;
      }
      if (!localNetworkInfo.isConnected()) {
        return b.a.a;
      }
      i = localNetworkInfo.getType();
      if (i == 1) {
        return b.a.c;
      }
    }
    catch (Exception localException)
    {
      return b.a.a;
    }
    if (i == 0) {
      return b.a.b;
    }
    return b.a.d;
  }
  
  public static void a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      a = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (b != null) {}
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          b = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
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
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"<unknown ssid>".equals(paramString));
  }
  
  public static boolean b()
  {
    return a() == b.a.c;
  }
  
  public static String c()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (b()) {
      localObject1 = a;
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
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.w(new String[] { "QAPM_DNS_NetworkUtils", "get wifi connection info failed" });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.network.b
 * JD-Core Version:    0.7.0.1
 */