package com.tencent.qapmsdk.dns.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import com.tencent.qapmsdk.common.logger.Logger;

public class b
{
  private static WifiManager a;
  private static ConnectivityManager b;
  
  public static b.a a()
  {
    try
    {
      NetworkInfo localNetworkInfo = b.getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return b.a.a;
      }
      if (!localNetworkInfo.isConnected()) {
        return b.a.a;
      }
      int i = localNetworkInfo.getType();
      if (i == 1) {
        return b.a.c;
      }
      if (i == 0) {
        return b.a.b;
      }
      return b.a.d;
    }
    catch (Exception localException)
    {
      label52:
      break label52;
    }
    return b.a.a;
  }
  
  public static void a(Context paramContext)
  {
    if (a == null) {
      try
      {
        a = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.exception("QAPM_DNS_NetworkUtils", "get WifiManager failed", localException);
      }
    }
    if (b == null) {
      try
      {
        b = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
        return;
      }
      catch (Exception paramContext)
      {
        Logger.INSTANCE.exception("QAPM_DNS_NetworkUtils", "get ConnectivityManager failed", paramContext);
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
    Object localObject;
    if (b()) {
      localObject = a;
    }
    try
    {
      localObject = NetworkMonitor.getConnectionInfo((WifiManager)localObject);
      if (localObject == null) {
        break label46;
      }
      localObject = ((WifiInfo)localObject).getSSID();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      label26:
      label46:
      break label26;
    }
    Logger.INSTANCE.w(new String[] { "QAPM_DNS_NetworkUtils", "get wifi connection info failed" });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.network.b
 * JD-Core Version:    0.7.0.1
 */