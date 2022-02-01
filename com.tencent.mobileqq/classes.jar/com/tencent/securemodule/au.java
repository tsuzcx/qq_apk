package com.tencent.securemodule;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;

public final class au
{
  public static String a()
  {
    return Build.MODEL;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    try
    {
      paramContext = paramContext.getDeviceId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label17:
      break label17;
    }
    return "0000000000";
  }
  
  public static String b()
  {
    return Build.PRODUCT;
  }
  
  public static String b(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    try
    {
      paramContext = paramContext.getSubscriberId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label17:
      break label17;
    }
    return "0000000000";
  }
  
  public static int c()
  {
    return Integer.parseInt(Build.VERSION.SDK);
  }
  
  public static String c(Context paramContext)
  {
    Object localObject = null;
    try
    {
      WifiInfo localWifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      paramContext = localObject;
      if (localWifiInfo != null) {
        paramContext = localWifiInfo.getMacAddress();
      }
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String d()
  {
    return "android_id";
  }
  
  public static String d(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSimSerialNumber();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label15:
      break label15;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securemodule.au
 * JD-Core Version:    0.7.0.1
 */