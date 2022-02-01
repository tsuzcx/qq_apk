package com.tencent.mobileqq.kandian.base.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.NetworkUtil;

public class RIJNetworkUtils
{
  private static String a = "";
  private static String b = "";
  private static volatile boolean c = false;
  
  public static String a(Context paramContext)
  {
    h(paramContext);
    return a;
  }
  
  public static String b(Context paramContext)
  {
    h(paramContext);
    return b;
  }
  
  public static String c(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext != null)
        {
          paramContext = paramContext.getConnectionInfo().getBSSID();
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "";
  }
  
  public static int d(Context paramContext)
  {
    int j = NetworkUtil.getSystemNetwork(paramContext);
    int i;
    if (j >= 1)
    {
      i = j;
      if (j <= 4) {}
    }
    else
    {
      i = 5;
    }
    return i;
  }
  
  public static boolean e(Context paramContext)
  {
    return NetworkUtil.isNetworkAvailable(paramContext);
  }
  
  public static int f(Context paramContext)
  {
    return NetworkUtil.getNetworkType(paramContext);
  }
  
  private static void h(Context paramContext)
  {
    if ((!c) && (paramContext != null))
    {
      paramContext = paramContext.getApplicationContext();
      c = true;
      AppNetConnInfo.registerNetChangeReceiver(paramContext, new RIJNetworkUtils.1(paramContext));
      i(paramContext);
    }
  }
  
  private static void i(Context paramContext)
  {
    if (paramContext != null)
    {
      WifiInfo localWifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (localWifiInfo != null)
      {
        boolean bool = TextUtils.isEmpty(localWifiInfo.getBSSID());
        String str = "";
        if (bool) {
          paramContext = "";
        } else {
          paramContext = localWifiInfo.getBSSID();
        }
        a = paramContext;
        if (TextUtils.isEmpty(a)) {
          paramContext = str;
        } else {
          paramContext = localWifiInfo.getSSID();
        }
        b = paramContext;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.RIJNetworkUtils
 * JD-Core Version:    0.7.0.1
 */