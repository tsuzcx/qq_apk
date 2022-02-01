package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.net.Proxy;
import android.os.Build.VERSION;
import java.net.HttpURLConnection;

public class boolean
{
  public HttpURLConnection Sf = null;
  public boolean Tf = false;
  
  public static String j(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    for (int i = 1; i != 0; i = 0) {
      return System.getProperty("http.proxyHost");
    }
    return Proxy.getHost(paramContext);
  }
  
  public static int k(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    for (int i = 1; i != 0; i = 0) {
      try
      {
        i = Integer.parseInt(System.getProperty("http.proxyPort"));
        return i;
      }
      catch (NumberFormatException paramContext)
      {
        return -1;
      }
    }
    return Proxy.getPort(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.boolean
 * JD-Core Version:    0.7.0.1
 */