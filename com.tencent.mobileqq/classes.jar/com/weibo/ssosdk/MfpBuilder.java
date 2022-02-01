package com.weibo.ssosdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MfpBuilder
{
  public static final String AID_TAG = "weibo_aid_value";
  private static final String TAG = "MfpBuilder";
  
  private static void LogD(String paramString) {}
  
  private static void LogE(String paramString) {}
  
  private static String bytesToString(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
  
  private static String genMfpString(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject = getOS();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("os", localObject);
      }
      localObject = getImei(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("imei", localObject);
      }
      localObject = getMeid(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("meid", localObject);
      }
      localObject = getImsi(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("imsi", localObject);
      }
      localObject = getMac(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("mac", localObject);
      }
      localObject = getIccid(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("iccid", localObject);
      }
      localObject = getSerialNo();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("serial", localObject);
      }
      localObject = getAndroidId(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("androidid", localObject);
      }
      localObject = getCpu();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("cpu", localObject);
      }
      localObject = getModel();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("model", localObject);
      }
      localObject = getSdSize();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("sdcard", localObject);
      }
      localObject = getResolution(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("resolution", localObject);
      }
      localObject = getSsid(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("ssid", localObject);
      }
      localObject = getWifiBssid(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("bssid", localObject);
      }
      localObject = getDeviceName();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("deviceName", localObject);
      }
      localObject = getConnectType(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("connecttype", localObject);
      }
      localObject = "";
      try
      {
        String str = generateUAAid(paramContext);
        localObject = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          double d;
          localException.printStackTrace();
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("ua", localObject);
      }
      d = getBatteryCapacity(paramContext);
      localJSONObject.put("batterymaxcapacity", String.valueOf(d));
      localJSONObject.put("batterycurrentcapacity", String.valueOf(d));
      paramContext = new MfpBuilder.BatteryInfo(paramContext, null);
      localJSONObject.put("batterycurrentvoltage", MfpBuilder.BatteryInfo.access$100(paramContext));
      localJSONObject.put("batterycurrenttemperature", MfpBuilder.BatteryInfo.access$200(paramContext));
      localJSONObject.put("batterycurrentcapacity", d * MfpBuilder.BatteryInfo.access$300(paramContext) / MfpBuilder.BatteryInfo.access$400(paramContext));
      return localJSONObject.toString();
    }
    catch (JSONException paramContext) {}
    return "";
  }
  
  private static String generateUAAid(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = paramContext.getPackageName();
    String str1 = "ssosdk";
    paramContext = str1;
    if (!TextUtils.isEmpty(str2))
    {
      paramContext = str1;
      if (str2.contains("com.sina.weibo")) {
        paramContext = "weibo";
      }
    }
    localStringBuilder.append(Build.MANUFACTURER).append("-").append(Build.MODEL);
    localStringBuilder.append("__");
    localStringBuilder.append(paramContext);
    localStringBuilder.append("__");
    try
    {
      localStringBuilder.append("1.0".replaceAll("\\s+", "_"));
      localStringBuilder.append("__android__android").append(Build.VERSION.RELEASE);
      return localStringBuilder.toString();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        localStringBuilder.append("unknown");
      }
    }
  }
  
  private static String getAndroidId(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private static double getBatteryCapacity(Context paramContext)
  {
    Object localObject = null;
    try
    {
      paramContext = Class.forName("com.android.internal.os.PowerProfile").getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
      try
      {
        double d = ((Double)Class.forName("com.android.internal.os.PowerProfile").getMethod("getAveragePower", new Class[] { String.class }).invoke(paramContext, new Object[] { "battery.capacity" })).doubleValue();
        return d;
      }
      catch (Exception paramContext)
      {
        return 0.0D;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  private static String getConnectType(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        if (paramContext.getType() == 0) {}
        switch (paramContext.getSubtype())
        {
        default: 
          if (paramContext.getType() == 1) {
            return "wifi";
          }
          break;
        }
      }
    }
    catch (Exception paramContext) {}
    return "none";
    return "none";
    return "2G";
    return "3G";
    return "4G";
  }
  
  private static String getCpu()
  {
    try
    {
      String str = Build.CPU_ABI;
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private static String getDeviceName()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private static String getIccid(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSimSerialNumber();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private static String getImei(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private static String getImsi(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private static String getMac(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return getMacAddr();
    }
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext == null) {
        return "";
      }
      paramContext = paramContext.getConnectionInfo();
      if (paramContext != null) {
        return paramContext.getMacAddress();
      }
      return "";
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private static String getMacAddr()
  {
    try
    {
      Object localObject1 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (NetworkInterface)((Iterator)localObject1).next();
        if (((NetworkInterface)localObject2).getName().equalsIgnoreCase("wlan0"))
        {
          localObject1 = ((NetworkInterface)localObject2).getHardwareAddress();
          if (localObject1 == null) {
            return "";
          }
          localObject2 = new StringBuilder();
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            ((StringBuilder)localObject2).append(String.format("%02X:", new Object[] { Byte.valueOf(localObject1[i]) }));
            i += 1;
          }
          if (((StringBuilder)localObject2).length() > 0) {
            ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
          }
          localObject1 = ((StringBuilder)localObject2).toString();
          return localObject1;
        }
      }
    }
    catch (Exception localException) {}
    return "";
  }
  
  private static String getMeid(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static String getMfp(Context paramContext)
  {
    paramContext = genMfpString(paramContext);
    try
    {
      paramContext = new String(paramContext.getBytes(), "UTF-8");
      return paramContext;
    }
    catch (UnsupportedEncodingException paramContext) {}
    return "";
  }
  
  private static String getModel()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private static String getOS()
  {
    try
    {
      String str = "Android " + Build.VERSION.RELEASE;
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private static PublicKey getPublicKey(String paramString)
  {
    paramString = new X509EncodedKeySpec(Base64.decode(paramString.getBytes(), 2));
    return KeyFactory.getInstance("RSA").generatePublic(paramString);
  }
  
  private static String getResolution(Context paramContext)
  {
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      paramContext = String.valueOf(localDisplayMetrics.widthPixels) + "*" + String.valueOf(localDisplayMetrics.heightPixels);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private static String getSdSize()
  {
    try
    {
      Object localObject = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = ((StatFs)localObject).getBlockSize();
      localObject = Long.toString(((StatFs)localObject).getBlockCount() * l);
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private static String getSerialNo()
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return getSerialNoForO();
    }
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject, new Object[] { "ro.serialno", "unknown" });
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  @TargetApi(26)
  private static String getSerialNoForO()
  {
    try
    {
      String str = Build.getSerial();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  private static String getSsid(Context paramContext)
  {
    paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    try
    {
      paramContext = paramContext.getConnectionInfo();
      if (paramContext != null)
      {
        paramContext = paramContext.getSSID();
        return paramContext;
      }
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static String getWifiBssid(Context paramContext)
  {
    paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    try
    {
      paramContext = paramContext.getConnectionInfo();
      if (paramContext != null)
      {
        paramContext = paramContext.getBSSID();
        return paramContext;
      }
    }
    catch (SecurityException paramContext) {}
    return "";
  }
  
  public static void init(Context paramContext) {}
  
  private static int splite(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramArrayOfByte.length) {
      return -1;
    }
    return Math.min(paramArrayOfByte.length - paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.weibo.ssosdk.MfpBuilder
 * JD-Core Version:    0.7.0.1
 */