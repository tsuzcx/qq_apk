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
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
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
    return null;
  }
  
  private static String genMfpString(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      String str1 = getOS();
      if (!TextUtils.isEmpty(str1)) {
        localJSONObject.put("os", str1);
      }
      str1 = getImei(paramContext);
      if (!TextUtils.isEmpty(str1)) {
        localJSONObject.put("imei", str1);
      }
      str1 = getMeid(paramContext);
      if (!TextUtils.isEmpty(str1)) {
        localJSONObject.put("meid", str1);
      }
      str1 = getImsi(paramContext);
      if (!TextUtils.isEmpty(str1)) {
        localJSONObject.put("imsi", str1);
      }
      str1 = getMac(paramContext);
      if (!TextUtils.isEmpty(str1)) {
        localJSONObject.put("mac", str1);
      }
      str1 = getIccid(paramContext);
      if (!TextUtils.isEmpty(str1)) {
        localJSONObject.put("iccid", str1);
      }
      str1 = getSerialNo();
      if (!TextUtils.isEmpty(str1)) {
        localJSONObject.put("serial", str1);
      }
      str1 = getAndroidId(paramContext);
      if (!TextUtils.isEmpty(str1)) {
        localJSONObject.put("androidid", str1);
      }
      str1 = getCpu();
      if (!TextUtils.isEmpty(str1)) {
        localJSONObject.put("cpu", str1);
      }
      str1 = getModel();
      if (!TextUtils.isEmpty(str1)) {
        localJSONObject.put("model", str1);
      }
      str1 = getSdSize();
      if (!TextUtils.isEmpty(str1)) {
        localJSONObject.put("sdcard", str1);
      }
      str1 = getResolution(paramContext);
      if (!TextUtils.isEmpty(str1)) {
        localJSONObject.put("resolution", str1);
      }
      str1 = getSsid(paramContext);
      if (!TextUtils.isEmpty(str1)) {
        localJSONObject.put("ssid", str1);
      }
      str1 = getWifiBssid(paramContext);
      if (!TextUtils.isEmpty(str1)) {
        localJSONObject.put("bssid", str1);
      }
      str1 = getDeviceName();
      if (!TextUtils.isEmpty(str1)) {
        localJSONObject.put("deviceName", str1);
      }
      str1 = getConnectType(paramContext);
      if (!TextUtils.isEmpty(str1)) {
        localJSONObject.put("connecttype", str1);
      }
      String str2;
      try
      {
        str1 = generateUAAid(paramContext);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        str2 = "";
      }
      if (!TextUtils.isEmpty(str2)) {
        localJSONObject.put("ua", str2);
      }
      double d1 = getBatteryCapacity(paramContext);
      localJSONObject.put("batterymaxcapacity", String.valueOf(d1));
      localJSONObject.put("batterycurrentcapacity", String.valueOf(d1));
      paramContext = new MfpBuilder.BatteryInfo(paramContext, null);
      localJSONObject.put("batterycurrentvoltage", MfpBuilder.BatteryInfo.access$100(paramContext));
      localJSONObject.put("batterycurrenttemperature", MfpBuilder.BatteryInfo.access$200(paramContext));
      int i = MfpBuilder.BatteryInfo.access$300(paramContext);
      double d2 = i;
      Double.isNaN(d2);
      i = MfpBuilder.BatteryInfo.access$400(paramContext);
      double d3 = i;
      Double.isNaN(d3);
      d1 = d1 * d2 / d3;
      localJSONObject.put("batterycurrentcapacity", d1);
      paramContext = localJSONObject.toString();
      return paramContext;
    }
    catch (JSONException paramContext) {}
    return "";
  }
  
  private static String generateUAAid(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramContext = paramContext.getPackageName();
    if ((!TextUtils.isEmpty(paramContext)) && (paramContext.contains("com.sina.weibo"))) {
      paramContext = "weibo";
    } else {
      paramContext = "ssosdk";
    }
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("-");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("__");
    localStringBuilder.append(paramContext);
    localStringBuilder.append("__");
    try
    {
      localStringBuilder.append("1.0".replaceAll("\\s+", "_"));
    }
    catch (Exception paramContext)
    {
      label98:
      break label98;
    }
    localStringBuilder.append("unknown");
    localStringBuilder.append("__android__android");
    localStringBuilder.append(Build.VERSION.RELEASE);
    return localStringBuilder.toString();
  }
  
  private static String getAndroidId(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label13:
      break label13;
    }
    return "";
  }
  
  private static double getBatteryCapacity(Context paramContext)
  {
    try
    {
      paramContext = Class.forName("com.android.internal.os.PowerProfile").getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
    }
    catch (Exception paramContext)
    {
      label33:
      label79:
      break label33;
    }
    paramContext = null;
    try
    {
      double d = ((Double)Class.forName("com.android.internal.os.PowerProfile").getMethod("getAveragePower", new Class[] { String.class }).invoke(paramContext, new Object[] { "battery.capacity" })).doubleValue();
      return d;
    }
    catch (Exception paramContext)
    {
      break label79;
    }
    return 0.0D;
  }
  
  private static String getConnectType(Context paramContext)
  {
    String str = "none";
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      paramContext = str;
      if (localNetworkInfo != null) {
        if (localNetworkInfo.getType() != 0) {}
      }
      switch (localNetworkInfo.getSubtype())
      {
      default: 
        paramContext = str;
        if (localNetworkInfo.getType() == 1) {
          paramContext = "wifi";
        }
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      return "none";
    }
    return "none";
    return "4G";
    return "3G";
    return "2G";
  }
  
  private static String getCpu()
  {
    try
    {
      String str = Build.CPU_ABI;
      return str;
    }
    catch (Exception localException)
    {
      label6:
      break label6;
    }
    return "";
  }
  
  private static String getDeviceName()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    catch (Exception localException)
    {
      label6:
      break label6;
    }
    return "";
  }
  
  private static String getIccid(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSimSerialNumber();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label16:
      break label16;
    }
    return "";
  }
  
  private static String getImei(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label16:
      break label16;
    }
    return "";
  }
  
  private static String getImsi(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label16:
      break label16;
    }
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
      if (paramContext != null)
      {
        paramContext = paramContext.getMacAddress();
        return paramContext;
      }
      return "";
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private static String getMacAddr()
  {
    Object localObject2 = "";
    try
    {
      Iterator localIterator = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (NetworkInterface)localIterator.next();
      } while (!((NetworkInterface)localObject1).getName().equalsIgnoreCase("wlan0"));
      Object localObject1 = ((NetworkInterface)localObject1).getHardwareAddress();
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
    catch (Exception paramContext)
    {
      label16:
      break label16;
    }
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
    catch (UnsupportedEncodingException paramContext)
    {
      label22:
      break label22;
    }
    return "";
  }
  
  private static String getModel()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Exception localException)
    {
      label6:
      break label6;
    }
    return "";
  }
  
  private static String getOS()
  {
    try
    {
      Object localObject = new StringBuilder("Android ");
      ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      label26:
      break label26;
    }
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
      paramContext = new StringBuilder();
      paramContext.append(String.valueOf(localDisplayMetrics.widthPixels));
      paramContext.append("*");
      paramContext.append(String.valueOf(localDisplayMetrics.heightPixels));
      paramContext = paramContext.toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label74:
      break label74;
    }
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
    catch (Exception localException)
    {
      label33:
      break label33;
    }
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
    catch (Exception localException)
    {
      label68:
      break label68;
    }
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
    catch (Exception paramContext)
    {
      label30:
      break label30;
    }
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
    catch (SecurityException paramContext)
    {
      label30:
      break label30;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.weibo.ssosdk.MfpBuilder
 * JD-Core Version:    0.7.0.1
 */