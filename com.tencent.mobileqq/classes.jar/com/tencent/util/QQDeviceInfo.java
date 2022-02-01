package com.tencent.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.Xml;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import mqq.os.MqqHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class QQDeviceInfo
{
  public static final int DEFAULT_LEVEL = 4;
  private static final String KEY_ANDROID_ID = "android_id";
  private static final String KEY_DEVICE_ID_CACHE_PREFIX = "device_id_cache_";
  private static final String KEY_HUAWEI_OAID = "huawei_oaid";
  private static final String KEY_IMEI = "imei";
  public static final String KEY_NO_LOGIN_USER_ID = "key_no_login_user_id";
  public static final int LEVEL_CROSS_APP = 5;
  private static final int LEVEL_INVALID = -1;
  public static final int LEVEL_NEW_INSTALL = 2;
  public static final int LEVEL_OVER_INSTALL = 3;
  public static final int LEVEL_REBOOT = 1;
  public static final int LEVEL_SYSTEM_UPGRADE = 4;
  private static final String SP_AUTHORITY = "authority";
  public static String TAG = "QQDeviceInfo";
  private static String mAndroidId;
  private static volatile Map<String, Integer> mBusiIdCache;
  private static final Object mCacheOj = new Object();
  private static final SparseArray<String> mDeviceIDCache = new SparseArray();
  private static String mHuaweiOaid;
  private static String mImei;
  private static boolean mSwitch = false;
  
  private static String getAndroidID()
  {
    if (!TextUtils.isEmpty(mAndroidId)) {
      return mAndroidId;
    }
    mAndroidId = getIMEIFromSp("android_id");
    if (TextUtils.isEmpty(mAndroidId))
    {
      mAndroidId = Settings.System.getString(BaseApplication.getContext().getContentResolver(), "android_id");
      saveIMEI2Sp("android_id", mAndroidId);
    }
    return mAndroidId;
  }
  
  private static String getDeviceIDCache(int paramInt)
  {
    synchronized (mDeviceIDCache)
    {
      if (mDeviceIDCache.indexOfKey(paramInt) < 0)
      {
        localObject1 = mDeviceIDCache;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("device_id_cache_");
        localStringBuilder.append(paramInt);
        ((SparseArray)localObject1).put(paramInt, getIMEIFromSp(localStringBuilder.toString()));
      }
      Object localObject1 = (String)mDeviceIDCache.get(paramInt);
      return localObject1;
    }
  }
  
  public static QQDeviceInfo.Entity getDeviceInfo(String paramString)
  {
    getLevelByBIdAndVerify(paramString);
    return new QQDeviceInfo.Entity(getIMEI(), getQIMEI(), getAndroidID());
  }
  
  private static String getHuaweiOaid()
  {
    Object localObject;
    if (!TextUtils.isEmpty(mHuaweiOaid))
    {
      localObject = mHuaweiOaid;
    }
    else
    {
      String str = getAndroidID();
      localObject = str;
      if (QLog.isColorLevel())
      {
        QLog.i(TAG, 2, "getHuaweiOaid, but huawei oaid is null, so use android id instead");
        localObject = str;
      }
    }
    reportGetHuaweiOaid();
    return localObject;
  }
  
  private static String getIMEI()
  {
    
    if (!TextUtils.isEmpty(mImei)) {
      return mImei;
    }
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
      if (Build.VERSION.SDK_INT < 26) {
        mImei = localTelephonyManager.getDeviceId();
      } else {
        mImei = localTelephonyManager.getImei();
      }
      saveIMEI2Sp("imei", mImei);
    }
    catch (SecurityException localSecurityException)
    {
      break label72;
    }
    catch (Throwable localThrowable)
    {
      label64:
      break label64;
    }
    mImei = "";
    break label77;
    label72:
    mImei = "";
    label77:
    return mImei;
  }
  
  public static String getIMEI(String paramString)
  {
    return getIMEI(paramString, -1);
  }
  
  public static String getIMEI(String paramString, int paramInt)
  {
    int i = getLevelByBIdAndVerify(paramString);
    if (paramInt == -1) {
      paramInt = i;
    }
    String str2 = getDeviceIDCache(paramInt);
    if (!TextUtils.isEmpty(str2)) {
      return str2;
    }
    initIMEI();
    initHuaweiOaid(true);
    if (((Build.VERSION.SDK_INT > 28) || ((Build.VERSION.SDK_INT >= 23) && (BaseApplication.getContext().checkSelfPermission("android.permission.READ_PHONE_STATE") != 0))) && (TextUtils.isEmpty(mImei)))
    {
      if (paramInt >= 5) {
        paramString = getQIMEI();
      } else if (("huawei".equalsIgnoreCase(Build.MANUFACTURER)) && (!TextUtils.isEmpty(mHuaweiOaid))) {
        paramString = mHuaweiOaid;
      } else {
        paramString = getAndroidID();
      }
    }
    else {
      paramString = getIMEI();
    }
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    if (QLog.isColorLevel())
    {
      paramString = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIMEI, level = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("; result = ");
      localStringBuilder.append(str1);
      QLog.d(paramString, 2, localStringBuilder.toString());
    }
    if (!str1.equals(str2))
    {
      paramString = new StringBuilder();
      paramString.append("device_id_cache_");
      paramString.append(paramInt);
      saveIMEI2Sp(paramString.toString(), str1);
    }
    return str1;
  }
  
  private static String getIMEIFromSp(String paramString)
  {
    paramString = BaseApplication.getContext().getSharedPreferences("authority", 4).getString(paramString, "");
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString;
  }
  
  public static String getIMSI(String paramString)
  {
    getLevelByBIdAndVerify(paramString);
    paramString = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
    try
    {
      paramString = paramString.getSubscriberId();
      return paramString;
    }
    catch (SecurityException|Throwable paramString) {}
    return "";
  }
  
  public static String getIMSI(String paramString, int paramInt)
  {
    return getIMSI(paramString);
  }
  
  private static int getLevelByBIdAndVerify(String paramString)
  {
    if (mBusiIdCache == null) {
      synchronized (mCacheOj)
      {
        if (mBusiIdCache == null) {
          initBusiIdData();
        }
      }
    }
    if (mBusiIdCache == null) {
      return 4;
    }
    if (!mBusiIdCache.containsKey(paramString))
    {
      if (!mSwitch) {
        return 4;
      }
      throw new IllegalArgumentException("busiId not registed ,please first regist");
    }
    paramString = (Integer)mBusiIdCache.get(paramString);
    if (paramString == null) {
      return 4;
    }
    return paramString.intValue();
  }
  
  public static String getMAC(String paramString)
  {
    getLevelByBIdAndVerify(paramString);
    paramString = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    try
    {
      paramString = paramString.getConnectionInfo().getMacAddress();
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isDevelopLevel())
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" getMacAddr exception = ");
        localStringBuilder.append(paramString);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
    return "";
  }
  
  public static String getNoLoginUserId()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str2 = "";
    Object localObject2 = (String)BaseSharedPreUtil.a(localBaseApplication, "0", "key_no_login_user_id", "");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      localObject1 = Settings.Secure.getString(localBaseApplication.getContentResolver(), "android_id");
      str2 = UUID.randomUUID().toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(str2);
      localObject1 = MD5.toMD5(((StringBuilder)localObject2).toString());
      BaseSharedPreUtil.a(localBaseApplication, "0", false, "key_no_login_user_id", localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1 = str2;
      }
    }
  }
  
  public static String getQIMEI()
  {
    return UserAction.getQIMEI();
  }
  
  @SuppressLint({"HardwareIds"})
  public static String getSerial(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return Build.SERIAL;
    }
    int i = Build.VERSION.SDK_INT;
    if (paramActivity == null) {
      return "unknown";
    }
    if (paramActivity.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0)
    {
      paramActivity.requestPermissions(new String[] { "android.permission.READ_PHONE_STATE" }, 1);
      return "unknown";
    }
    try
    {
      paramActivity = Build.getSerial();
      return paramActivity;
    }
    catch (SecurityException paramActivity)
    {
      QLog.e(TAG, 2, paramActivity, new Object[0]);
    }
    return "unknown";
  }
  
  private static void initBusiIdData()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = BaseApplication.getContext();
    int i;
    try
    {
      localObject = ((Context)localObject).getResources().getAssets().open("SensiveAuthorityFile.xml");
      localXmlPullParser = Xml.newPullParser();
      localXmlPullParser.setInput((InputStream)localObject, "utf-8");
      i = localXmlPullParser.getEventType();
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      XmlPullParser localXmlPullParser;
      String str1;
      String str2;
      localXmlPullParserException.printStackTrace();
      break label214;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    if (localXmlPullParser.getName().equalsIgnoreCase("business"))
    {
      str1 = localXmlPullParser.getAttributeValue(null, "id");
      str2 = localXmlPullParser.getAttributeValue(null, "level");
      if (TextUtils.isEmpty(str2)) {
        break label236;
      }
      i = stringToInt(str2, 4);
    }
    for (;;)
    {
      localHashMap.put(str1, Integer.valueOf(i));
      if (QLog.isDevelopLevel())
      {
        str2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("init sensitive au, busiId = ");
        localStringBuilder.append(str1);
        localStringBuilder.append("; level = ");
        localStringBuilder.append(i);
        QLog.d(str2, 4, localStringBuilder.toString());
      }
      for (;;)
      {
        i = localXmlPullParser.next();
        label214:
        while (i == 1)
        {
          ((InputStream)localObject).close();
          mBusiIdCache = localHashMap;
          return;
        }
        if (i != 0) {
          if (i == 2) {
            break;
          }
        }
      }
      label236:
      i = 4;
    }
  }
  
  public static void initHuaweiOaid()
  {
    initHuaweiOaid(false);
  }
  
  public static void initHuaweiOaid(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT > 28)
    {
      if (!"huawei".equalsIgnoreCase(Build.MANUFACTURER)) {
        return;
      }
      mHuaweiOaid = getIMEIFromSp("huawei_oaid");
      if (!paramBoolean)
      {
        if (!TextUtils.isEmpty(mHuaweiOaid)) {
          return;
        }
        ThreadManager.getFileThreadHandler().post(new QQDeviceInfo.1());
      }
    }
  }
  
  private static void initIMEI()
  {
    if (!TextUtils.isEmpty(mImei)) {
      return;
    }
    mImei = getIMEIFromSp("imei");
  }
  
  private static void reportGetHuaweiOaid()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(TAG);
    ((StringBuilder)localObject).append("_getHuaweiOaid");
    localObject = ((StringBuilder)localObject).toString();
    localHashMap.put("huawei_oaid", mHuaweiOaid);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, (String)localObject, true, 0L, 0L, localHashMap, null);
  }
  
  private static void saveIMEI2Sp(String paramString1, String paramString2)
  {
    BaseApplication.getContext().getSharedPreferences("authority", 4).edit().putString(paramString1, paramString2).apply();
  }
  
  private static int stringToInt(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.QQDeviceInfo
 * JD-Core Version:    0.7.0.1
 */