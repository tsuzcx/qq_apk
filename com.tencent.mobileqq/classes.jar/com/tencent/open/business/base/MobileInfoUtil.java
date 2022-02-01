package com.tencent.open.business.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.util.QQDeviceInfo;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

public class MobileInfoUtil
{
  public static final int APP_VERSION = 1;
  private static final String BUSINESS_ID_IMEI = "52b7f2";
  private static final String BUSINESS_ID_IMSI = "ea6862";
  private static final String BUSINESS_ID_MAC_ADDRESS = "7ef1aa";
  public static final String IMEI = "imei";
  public static final String IMSI = "imsi";
  protected static final String MOBILE_INFO = "appcenter_mobileinfo";
  public static final String WIFI_MAC_ADDRESS = "wifi_mac_address";
  protected static String imei;
  protected static String imsi;
  protected static String localMacAddress;
  protected static String location;
  protected static String resolution;
  
  public static String getCity()
  {
    return "";
  }
  
  public static String getDeviceinfoForCgiReport(boolean paramBoolean)
  {
    try
    {
      localBaseApplication = BaseApplication.getContext();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("imei=");
      String str2 = "";
      if (paramBoolean) {
        str1 = "";
      } else {
        str1 = getImei();
      }
      localStringBuilder.append(str1);
      localStringBuilder.append('&');
      localStringBuilder.append("model=");
      localStringBuilder.append(Build.MODEL);
      localStringBuilder.append('&');
      localStringBuilder.append("os=");
      localStringBuilder.append(Build.VERSION.RELEASE);
      localStringBuilder.append('&');
      localStringBuilder.append("apilevel=");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      localStringBuilder.append('&');
      str1 = APNUtil.b(localBaseApplication);
      if (str1 != null) {
        break label289;
      }
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        BaseApplication localBaseApplication;
        StringBuilder localStringBuilder;
        String str1;
        continue;
        label289:
        continue;
        int i = 0;
      }
    }
    localStringBuilder.append("network=");
    localStringBuilder.append(str1);
    localStringBuilder.append('&');
    localStringBuilder.append("sdcard=");
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      i = 1;
      localStringBuilder.append(i);
      localStringBuilder.append('&');
      localStringBuilder.append("display=");
      localStringBuilder.append(getResolution());
      localStringBuilder.append('&');
      localStringBuilder.append("manu=");
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append("&");
      localStringBuilder.append("wifi=");
      localStringBuilder.append(APNUtil.e(localBaseApplication));
      str1 = localStringBuilder.toString();
      return str1;
      return null;
    }
  }
  
  public static String getImei()
  {
    Object localObject;
    if (TextUtils.isEmpty(imei))
    {
      imei = "";
      localObject = BaseApplication.getContext();
      if (localObject != null)
      {
        imei = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 4).getString("imei", "");
        if (!TextUtils.isEmpty(imei)) {}
      }
    }
    try
    {
      imei = QQDeviceInfo.getIMEI("52b7f2");
      label58:
      if (imei != null)
      {
        localObject = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 4).edit();
        ((SharedPreferences.Editor)localObject).putString("imei", imei);
        ((SharedPreferences.Editor)localObject).commit();
      }
      return imei;
    }
    catch (Exception localException)
    {
      break label58;
    }
  }
  
  public static String getImsi()
  {
    Object localObject;
    if (TextUtils.isEmpty(imsi))
    {
      imsi = "";
      localObject = BaseApplication.getContext();
      if (localObject != null)
      {
        imsi = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 4).getString("imsi", "");
        if (!TextUtils.isEmpty(imsi)) {}
      }
    }
    try
    {
      imsi = QQDeviceInfo.getIMSI("ea6862");
      label58:
      if (imsi != null)
      {
        localObject = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 4).edit();
        ((SharedPreferences.Editor)localObject).putString("imsi", imsi);
        ((SharedPreferences.Editor)localObject).commit();
      }
      return imsi;
    }
    catch (Exception localException)
    {
      break label58;
    }
  }
  
  public static String getLanguage()
  {
    return Locale.getDefault().getLanguage();
  }
  
  public static String getLocalMacAddress()
  {
    if (TextUtils.isEmpty(localMacAddress))
    {
      localMacAddress = "";
      try
      {
        Object localObject = BaseApplication.getContext();
        if (localObject != null)
        {
          localMacAddress = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 4).getString("wifi_mac_address", "");
          if (TextUtils.isEmpty(localMacAddress))
          {
            localMacAddress = QQDeviceInfo.getMAC("7ef1aa");
            if (localMacAddress != null)
            {
              localObject = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 4).edit();
              ((SharedPreferences.Editor)localObject).putString("wifi_mac_address", localMacAddress);
              ((SharedPreferences.Editor)localObject).commit();
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return localMacAddress;
  }
  
  public static String getLocation()
  {
    if (!TextUtils.isEmpty(location)) {
      return location;
    }
    Object localObject1 = BaseApplication.getContext();
    if (localObject1 == null) {
      return "";
    }
    try
    {
      localObject1 = (LocationManager)((Context)localObject1).getSystemService("location");
      Object localObject2 = new Criteria();
      ((Criteria)localObject2).setCostAllowed(false);
      ((Criteria)localObject2).setAccuracy(2);
      localObject2 = ((LocationManager)localObject1).getBestProvider((Criteria)localObject2, true);
      if (localObject2 != null)
      {
        localObject1 = ((LocationManager)localObject1).getLastKnownLocation((String)localObject2);
        if (localObject1 == null) {
          return "";
        }
        double d1 = ((Location)localObject1).getLatitude();
        double d2 = ((Location)localObject1).getLongitude();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(d1);
        ((StringBuilder)localObject1).append("*");
        ((StringBuilder)localObject1).append(d2);
        localObject1 = ((StringBuilder)localObject1).toString();
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      LogUtility.c("getLocation", "getLocation>>>", localException);
    }
    return "";
  }
  
  public static String getMobileInfo()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("qua", CommonDataAdapter.a().f());
      localJSONObject.put("longitude", getLocation());
      localJSONObject.put("platform", CommonDataAdapter.a().g());
      localJSONObject.put("uin", CommonDataAdapter.a().a());
      localJSONObject.put("imei", getImei());
      localJSONObject.put("imei", getImei());
      localJSONObject.put("resolution", getResolution());
      localJSONObject.put("network", APNUtil.a(CommonDataAdapter.a().a()));
      localJSONObject.put("wifimac", getLocalMacAddress());
      localJSONObject.put("mobile_pf", "1");
      localJSONObject.put("os_ver", Build.VERSION.RELEASE);
      localJSONObject.put("lang", getLanguage());
      localJSONObject.put("device", Build.DEVICE);
      localJSONObject.put("model_name", Build.MODEL);
      localJSONObject.put("sdk_ver", "1.5");
      localJSONObject.put("timezone", TimeZone.getDefault().getID());
      localJSONObject.put("city", getCity());
      localJSONObject.put("longitude", getLocation());
      localJSONObject.put("ret_code", "0");
      localJSONObject.put("qua", CommonDataAdapter.a().f());
      localJSONObject.put("qz_ver", CommonDataAdapter.a().c());
      localJSONObject.put("imsi", getImsi());
      localJSONObject.put("androidID", Settings.Secure.getString(CommonDataAdapter.a().a().getContentResolver(), "android_id"));
      localJSONObject.put("os_api_level", Build.VERSION.SDK_INT);
      localJSONObject.put("sdkVersionCode", 1);
      localJSONObject.put("QVersionCode", CommonDataAdapter.a().a());
      localJSONObject.put("brand", GlobalUtil.getInstance().getBrand());
      localJSONObject.put("manufacture", GlobalUtil.getInstance().getManufacture());
      localJSONObject.put("product", GlobalUtil.getInstance().getProduct());
    }
    catch (Exception localException)
    {
      label371:
      break label371;
    }
    LogUtility.e("getMobileInfo", "gather mobile info exception.");
    return localJSONObject.toString();
  }
  
  public static String getResolution()
  {
    try
    {
      if (!TextUtils.isEmpty(resolution)) {
        return resolution;
      }
      Object localObject = (WindowManager)BaseApplication.getContext().getSystemService("window");
      int i = ((WindowManager)localObject).getDefaultDisplay().getWidth();
      int j = ((WindowManager)localObject).getDefaultDisplay().getHeight();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(j);
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      label81:
      break label81;
    }
    LogUtility.e("getResolution", "gather width height exception.");
    return "0x0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.business.base.MobileInfoUtil
 * JD-Core Version:    0.7.0.1
 */