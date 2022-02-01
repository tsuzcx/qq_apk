package com.tencent.qapmsdk.socket.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.qapmsdk.socket.TrafficMonitor;
import com.tencent.qapmsdk.socket.TrafficMonitor.a;

public class c
{
  public static String a()
  {
    Object localObject = TrafficMonitor.a().d();
    if (localObject == null) {
      return "undefined";
    }
    try
    {
      localObject = ((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
      {
        if (((NetworkInfo)localObject).getType() == 1) {
          return "wifi";
        }
      }
      else {
        throw new RuntimeException();
      }
    }
    catch (Throwable localThrowable)
    {
      return "undefined";
    }
    return "mobile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.d.c
 * JD-Core Version:    0.7.0.1
 */