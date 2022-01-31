package com.tencent.stat.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class Util
{
  public static boolean checkPermission(Context paramContext, String paramString)
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
  
  public static String decode(String paramString)
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
      str = new String(d.b(e.a(paramString.getBytes("UTF-8"), 0)), "UTF-8");
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MtaSDK", "decode error", localThrowable);
    }
    return paramString;
  }
  
  public static String encode(String paramString)
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
      str = new String(e.b(d.a(paramString.getBytes("UTF-8")), 0), "UTF-8");
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MtaSDK", "encode error", localThrowable);
    }
    return paramString;
  }
  
  public static JSONObject getConnecetedWifiInfo(Context paramContext)
  {
    paramContext = getWifiInfo(paramContext);
    if (paramContext != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("bs", paramContext.getBSSID());
        localJSONObject.put("ss", paramContext.getSSID());
        localJSONObject.put("dBm", paramContext.getRssi());
        return localJSONObject;
      }
      catch (Throwable paramContext) {}
    }
    return null;
  }
  
  public static String getDeviceID(Context paramContext)
  {
    try
    {
      if (checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))
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
  
  public static String getDeviceModel()
  {
    return Build.MODEL;
  }
  
  public static DisplayMetrics getDisplayMetrics(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static String getExternalStorageInfo(Context paramContext)
  {
    try
    {
      if (checkPermission(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE"))
      {
        paramContext = Environment.getExternalStorageState();
        if ((paramContext != null) && (paramContext.equals("mounted")))
        {
          paramContext = Environment.getExternalStorageDirectory().getPath();
          if (paramContext != null)
          {
            paramContext = new StatFs(paramContext);
            long l1 = paramContext.getBlockCount() * paramContext.getBlockSize() / 1000000L;
            long l2 = paramContext.getAvailableBlocks();
            l2 = paramContext.getBlockSize() * l2 / 1000000L;
            return String.valueOf(l2) + "/" + String.valueOf(l1);
          }
        }
      }
      else
      {
        Log.e("MtaSDK", "can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
        return null;
      }
    }
    catch (Throwable paramContext)
    {
      Log.e("MtaSDK", "", paramContext);
    }
    return null;
  }
  
  public static String getLinkedWay(Context paramContext)
  {
    Object localObject;
    try
    {
      if ((checkPermission(paramContext, "android.permission.INTERNET")) && (checkPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
      {
        localObject = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
        {
          paramContext = ((NetworkInfo)localObject).getTypeName();
          localObject = ((NetworkInfo)localObject).getExtraInfo();
          if (paramContext != null)
          {
            if (paramContext.equalsIgnoreCase("WIFI")) {
              return "WIFI";
            }
            if (!paramContext.equalsIgnoreCase("MOBILE")) {
              break label112;
            }
            if (localObject != null) {
              break label110;
            }
            return "MOBILE";
          }
        }
      }
      else
      {
        Log.e("MtaSDK", "can not get the permission of android.permission.ACCESS_WIFI_STATE");
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Log.e("MtaSDK", "", paramContext);
      }
    }
    return null;
    label110:
    label112:
    while (localObject != null) {
      return localObject;
    }
    return paramContext;
  }
  
  public static String getSimOperator(Context paramContext)
  {
    try
    {
      if (checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null) {
          return paramContext.getSimOperator();
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
        Log.e("MtaSDK", "", paramContext);
      }
    }
    return null;
  }
  
  public static Integer getTelephonyNetworkType(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        int i = paramContext.getNetworkType();
        return Integer.valueOf(i);
      }
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static String getWiFiBBSID(Context paramContext)
  {
    try
    {
      paramContext = getWifiInfo(paramContext);
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
  
  public static String getWiFiSSID(Context paramContext)
  {
    try
    {
      paramContext = getWifiInfo(paramContext);
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
  
  public static WifiInfo getWifiInfo(Context paramContext)
  {
    if (checkPermission(paramContext, "android.permission.ACCESS_WIFI_STATE"))
    {
      paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (paramContext != null) {
        return paramContext.getConnectionInfo();
      }
    }
    return null;
  }
  
  public static String getWifiMacAddress(Context paramContext)
  {
    if (checkPermission(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
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
  
  public static JSONArray getWifiTopN(Context paramContext, int paramInt)
  {
    JSONArray localJSONArray;
    try
    {
      if ((checkPermission(paramContext, "android.permission.INTERNET")) && (checkPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext != null)
        {
          paramContext = paramContext.getScanResults();
          if ((paramContext != null) && (paramContext.size() > 0))
          {
            Collections.sort(paramContext, new m());
            localJSONArray = new JSONArray();
            int i = 0;
            while ((i < paramContext.size()) && (i < paramInt))
            {
              ScanResult localScanResult = (ScanResult)paramContext.get(i);
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("bs", localScanResult.BSSID);
              localJSONObject.put("ss", localScanResult.SSID);
              localJSONObject.put("dBm", localScanResult.level);
              localJSONArray.put(localJSONObject);
              i += 1;
            }
          }
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
        Log.e("MtaSDK", "isWifiNet error", paramContext);
      }
    }
    return null;
    return localJSONArray;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    try
    {
      if ((checkPermission(paramContext, "android.permission.INTERNET")) && (checkPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
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
  
  public static boolean isWifiNet(Context paramContext)
  {
    try
    {
      if ((checkPermission(paramContext, "android.permission.INTERNET")) && (checkPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext != null)
        {
          paramContext = paramContext.getActiveNetworkInfo();
          if ((paramContext == null) || (!paramContext.isAvailable()) || (!paramContext.getTypeName().equalsIgnoreCase("WIFI"))) {
            break label87;
          }
          return true;
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
        Log.e("MtaSDK", "isWifiNet error", paramContext);
      }
    }
    return false;
    label87:
    return false;
  }
  
  public static void jsonPut(JSONObject paramJSONObject, String paramString1, String paramString2)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.stat.common.Util
 * JD-Core Version:    0.7.0.1
 */