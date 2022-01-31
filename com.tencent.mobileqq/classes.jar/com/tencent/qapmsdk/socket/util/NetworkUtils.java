package com.tencent.qapmsdk.socket.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.qapmsdk.socket.TrafficMonitor;
import com.tencent.qapmsdk.socket.TrafficMonitor.TrafficConfig;

public class NetworkUtils
{
  public static String getNetworkType()
  {
    Object localObject = TrafficMonitor.config().getApplicationContext();
    if (localObject == null) {
      return "undefined";
    }
    try
    {
      localObject = ((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localObject == null) || (!((NetworkInfo)localObject).isConnected())) {
        throw new RuntimeException();
      }
    }
    catch (Throwable localThrowable)
    {
      return "undefined";
    }
    if (localThrowable.getType() == 1) {
      return "wifi";
    }
    return "mobile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.util.NetworkUtils
 * JD-Core Version:    0.7.0.1
 */