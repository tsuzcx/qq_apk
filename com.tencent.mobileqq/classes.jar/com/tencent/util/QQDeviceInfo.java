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
      if (mDeviceIDCache.indexOfKey(paramInt) < 0) {
        mDeviceIDCache.put(paramInt, getIMEIFromSp("device_id_cache_" + paramInt));
      }
      String str = (String)mDeviceIDCache.get(paramInt);
      return str;
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
    if (!TextUtils.isEmpty(mHuaweiOaid)) {
      localObject = mHuaweiOaid;
    }
    for (;;)
    {
      reportGetHuaweiOaid();
      return localObject;
      String str = getAndroidID();
      localObject = str;
      if (QLog.isColorLevel())
      {
        QLog.i(TAG, 2, "getHuaweiOaid, but huawei oaid is null, so use android id instead");
        localObject = str;
      }
    }
  }
  
  private static String getIMEI()
  {
    
    if (!TextUtils.isEmpty(mImei)) {
      return mImei;
    }
    for (;;)
    {
      try
      {
        localTelephonyManager = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
        if (Build.VERSION.SDK_INT >= 26) {
          continue;
        }
        mImei = localTelephonyManager.getDeviceId();
        saveIMEI2Sp("imei", mImei);
      }
      catch (SecurityException localSecurityException)
      {
        TelephonyManager localTelephonyManager;
        mImei = "";
        continue;
      }
      catch (Throwable localThrowable)
      {
        mImei = "";
        continue;
      }
      return mImei;
      mImei = localTelephonyManager.getImei();
    }
  }
  
  public static String getIMEI(String paramString)
  {
    return getIMEI(paramString, -1);
  }
  
  public static String getIMEI(String paramString, int paramInt)
  {
    int j = getLevelByBIdAndVerify(paramString);
    int i = paramInt;
    if (paramInt == -1) {
      i = j;
    }
    String str2 = getDeviceIDCache(i);
    if (!TextUtils.isEmpty(str2))
    {
      paramString = str2;
      return paramString;
    }
    initIMEI();
    initHuaweiOaid(true);
    if (((Build.VERSION.SDK_INT > 28) || ((Build.VERSION.SDK_INT >= 23) && (BaseApplication.getContext().checkSelfPermission("android.permission.READ_PHONE_STATE") != 0))) && (TextUtils.isEmpty(mImei))) {
      if (i >= 5) {
        paramString = getQIMEI();
      }
    }
    for (;;)
    {
      String str1 = paramString;
      if (paramString == null) {
        str1 = "";
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getIMEI, level = " + i + "; result = " + str1);
      }
      paramString = str1;
      if (str1.equals(str2)) {
        break;
      }
      saveIMEI2Sp("device_id_cache_" + i, str1);
      return str1;
      if (("huawei".equalsIgnoreCase(Build.MANUFACTURER)) && (!TextUtils.isEmpty(mHuaweiOaid)))
      {
        paramString = mHuaweiOaid;
      }
      else
      {
        paramString = getAndroidID();
        continue;
        paramString = getIMEI();
      }
    }
  }
  
  private static String getIMEIFromSp(String paramString)
  {
    String str = BaseApplication.getContext().getSharedPreferences("authority", 4).getString(paramString, "");
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "";
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
    catch (SecurityException paramString)
    {
      return "";
    }
    catch (Throwable paramString) {}
    return "";
  }
  
  public static String getIMSI(String paramString, int paramInt)
  {
    return getIMSI(paramString);
  }
  
  private static int getLevelByBIdAndVerify(String paramString)
  {
    if (mBusiIdCache == null) {}
    do
    {
      synchronized (mCacheOj)
      {
        if (mBusiIdCache == null) {
          initBusiIdData();
        }
        if (mBusiIdCache == null) {
          return 4;
        }
      }
      if (mBusiIdCache.containsKey(paramString)) {
        break;
      }
    } while (!mSwitch);
    throw new IllegalArgumentException("busiId not registed ,please first regist");
    paramString = (Integer)mBusiIdCache.get(paramString);
    if (paramString == null) {}
    for (int i = 4;; i = paramString.intValue()) {
      return i;
    }
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
    catch (Exception localException)
    {
      do
      {
        paramString = "";
      } while (!QLog.isDevelopLevel());
      QLog.d(TAG, 2, " getMacAddr exception = " + localException);
    }
    return "";
  }
  
  public static String getNoLoginUserId()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str2 = (String)BaseSharedPreUtil.a(localBaseApplication, "0", "key_no_login_user_id", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    try
    {
      str2 = Settings.Secure.getString(localBaseApplication.getContentResolver(), "android_id");
      str1 = str2;
    }
    catch (Exception localException)
    {
      label43:
      break label43;
    }
    str2 = UUID.randomUUID().toString();
    str1 = MD5.toMD5(str1 + str2);
    BaseSharedPreUtil.a(localBaseApplication, "0", false, "key_no_login_user_id", str1);
    return str1;
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
    if ((Build.VERSION.SDK_INT <= 28) || (paramActivity == null)) {
      return "unknown";
    }
    if (paramActivity.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
      paramActivity.requestPermissions(new String[] { "android.permission.READ_PHONE_STATE" }, 1);
    }
    for (;;)
    {
      return "unknown";
      try
      {
        paramActivity = Build.getSerial();
        return paramActivity;
      }
      catch (SecurityException paramActivity)
      {
        QLog.e(TAG, 2, paramActivity, new Object[0]);
      }
    }
  }
  
  private static void initBusiIdData()
  {
    localHashMap = new HashMap();
    Object localObject = BaseApplication.getContext();
    for (;;)
    {
      try
      {
        localObject = ((Context)localObject).getResources().getAssets().open("SensiveAuthorityFile.xml");
        localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setInput((InputStream)localObject, "utf-8");
        i = localXmlPullParser.getEventType();
      }
      catch (IOException localIOException)
      {
        XmlPullParser localXmlPullParser;
        String str1;
        String str2;
        localIOException.printStackTrace();
        mBusiIdCache = localHashMap;
        return;
        localIOException.close();
        continue;
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        localXmlPullParserException.printStackTrace();
        continue;
        int i = 4;
        continue;
        if (i == 1) {
          continue;
        }
        switch (i)
        {
        }
        continue;
      }
      i = localXmlPullParser.next();
      continue;
      if (localXmlPullParser.getName().equalsIgnoreCase("business"))
      {
        str1 = localXmlPullParser.getAttributeValue(null, "id");
        str2 = localXmlPullParser.getAttributeValue(null, "level");
        if (TextUtils.isEmpty(str2)) {
          continue;
        }
        i = stringToInt(str2, 4);
        localHashMap.put(str1, Integer.valueOf(i));
        if (QLog.isDevelopLevel()) {
          QLog.d(TAG, 4, "init sensitive au, busiId = " + str1 + "; level = " + i);
        }
      }
    }
  }
  
  public static void initHuaweiOaid()
  {
    initHuaweiOaid(false);
  }
  
  public static void initHuaweiOaid(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT <= 28) || (!"huawei".equalsIgnoreCase(Build.MANUFACTURER))) {}
    do
    {
      return;
      mHuaweiOaid = getIMEIFromSp("huawei_oaid");
    } while ((paramBoolean) || (!TextUtils.isEmpty(mHuaweiOaid)));
    ThreadManager.getFileThreadHandler().post(new QQDeviceInfo.1());
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
    String str = TAG + "_getHuaweiOaid";
    localHashMap.put("huawei_oaid", mHuaweiOaid);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, 0L, 0L, localHashMap, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.util.QQDeviceInfo
 * JD-Core Version:    0.7.0.1
 */