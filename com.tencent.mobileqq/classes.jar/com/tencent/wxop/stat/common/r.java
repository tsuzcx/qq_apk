package com.tencent.wxop.stat.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public class r
{
  private static String a = "";
  
  public static String a(Context paramContext)
  {
    try
    {
      if (a(paramContext, "android.permission.READ_PHONE_STATE"))
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
        if (paramContext != null) {
          return paramContext;
        }
      }
      else
      {
        Log.e("MtaSDK", "Could not get permission of android.permission.READ_PHONE_STATE");
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Log.e("MtaSDK", "get device id error", paramContext);
      }
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (Build.VERSION.SDK_INT < 8);
    try
    {
      str = new String(f.b(h.a(paramString.getBytes("UTF-8"), 0)), "UTF-8");
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MtaSDK", "decode error", localThrowable);
    }
    return paramString;
  }
  
  public static JSONArray a(Context paramContext, int paramInt)
  {
    return null;
  }
  
  public static void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (paramString2 != null) {}
    try
    {
      if (paramString2.length() > 0) {
        paramJSONObject.put(paramString1, paramString2);
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      Log.e("MtaSDK", "jsonPut error", paramJSONObject);
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      int i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramContext)
    {
      Log.e("MtaSDK", "checkPermission error", paramContext);
    }
    return false;
  }
  
  public static String b(Context paramContext)
  {
    if (a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext == null) {
          return "";
        }
        paramContext = paramContext.getConnectionInfo().getMacAddress();
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("MtaSDK", "get wifi address error", paramContext);
        return "";
      }
    }
    Log.e("MtaSDK", "Could not get permission of android.permission.ACCESS_WIFI_STATE");
    return "";
  }
  
  public static String b(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (Build.VERSION.SDK_INT < 8);
    try
    {
      str = new String(h.b(f.a(paramString.getBytes("UTF-8")), 0), "UTF-8");
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MtaSDK", "encode error", localThrowable);
    }
    return paramString;
  }
  
  public static WifiInfo c(Context paramContext)
  {
    if (a(paramContext, "android.permission.ACCESS_WIFI_STATE"))
    {
      paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (paramContext != null) {
        return paramContext.getConnectionInfo();
      }
    }
    return null;
  }
  
  public static String d(Context paramContext)
  {
    try
    {
      paramContext = c(paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.getBSSID();
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      Log.e("MtaSDK", "encode error", paramContext);
    }
    return null;
  }
  
  public static String e(Context paramContext)
  {
    try
    {
      paramContext = c(paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.getSSID();
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      Log.e("MtaSDK", "encode error", paramContext);
    }
    return null;
  }
  
  public static boolean f(Context paramContext)
  {
    try
    {
      if ((a(paramContext, "android.permission.INTERNET")) && (a(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext != null)
        {
          paramContext = paramContext.getActiveNetworkInfo();
          if ((paramContext != null) && (paramContext.isAvailable())) {
            return true;
          }
          Log.w("MtaSDK", "Network error");
          return false;
        }
      }
      else
      {
        Log.e("MtaSDK", "can not get the permisson of android.permission.INTERNET");
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Log.e("MtaSDK", "isNetworkAvailable error", paramContext);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.common.r
 * JD-Core Version:    0.7.0.1
 */