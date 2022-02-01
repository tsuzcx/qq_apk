package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.net.Proxy;
import android.os.Build.VERSION;
import java.net.HttpURLConnection;

public class default
{
  public HttpURLConnection Cc = null;
  public boolean Dc = false;
  
  public static String p(Context paramContext)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 14) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return System.getProperty("http.proxyHost");
    }
    return Proxy.getHost(paramContext);
  }
  
  public static int q(Context paramContext)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 14) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {}
    try
    {
      i = Integer.parseInt(System.getProperty("http.proxyPort"));
      return i;
    }
    catch (NumberFormatException paramContext)
    {
      label30:
      break label30;
    }
    return -1;
    return Proxy.getPort(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.default
 * JD-Core Version:    0.7.0.1
 */