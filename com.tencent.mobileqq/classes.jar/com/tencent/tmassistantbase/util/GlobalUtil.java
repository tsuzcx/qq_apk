package com.tencent.tmassistantbase.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemProperties;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.tmassistant.common.jce.BoutiqueGameConfig;
import java.io.File;
import java.io.IOException;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GlobalUtil
{
  public static final String DEFAULT_MAC_ADDRESS = "02:00:00:00:00:00";
  public static final int DEF_INT = 0;
  public static final String DEF_STRING = "empty";
  protected static final String SharedPreferencesName = "TMAssistantSDKSharedPreference";
  protected static final String TAG = "GlobalUtil";
  protected static final String UN_DEFINED = "NA";
  protected static String mDevicedId = "";
  protected static GlobalUtil mInstance;
  protected static int mMemUUID = 0;
  private static String mQImei = "";
  private static String mQadid = "";
  private static long sUin;
  public static ThreadLocal<SimpleDateFormat> yyyyMMddHHTimeFormat = new j();
  public static ThreadLocal<SimpleDateFormat> yyyyMMddTimeFormat = new i();
  protected Context mContext;
  private String mMACAdress = null;
  public String mQUA = "";
  
  protected GlobalUtil()
  {
    try
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isMIUI:");
      localStringBuilder.append(isMIUI());
      ab.c(str, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static ArrayList<String> String2List(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(",");
      int i = 0;
      while (i < paramString.length)
      {
        CharSequence localCharSequence = paramString[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          localArrayList.add(localCharSequence);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static int assistantErrorCode2SDKErrorCode(int paramInt)
  {
    int j = 604;
    int i = j;
    if (paramInt != -1000)
    {
      if (paramInt != -16) {
        if (paramInt != -15) {
          if (paramInt != -1) {
            if (paramInt != 0) {
              i = j;
            }
          }
        }
      }
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          return 604;
        case -11: 
          return 708;
        case -12: 
          return 730;
        }
        return 703;
      case -21: 
        return 700;
      case -22: 
        return 732;
      case -23: 
        return 601;
      case -25: 
        return 602;
      case -27: 
        return 606;
      case -28: 
        return 701;
        return 0;
        return 709;
        return 1;
        i = 731;
      }
    }
    return i;
  }
  
  public static int assistantState2SDKState(int paramInt)
  {
    int i = 6;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 6)
            {
              if (paramInt != 9) {
                return 0;
              }
            }
            else {
              return 1;
            }
          }
          else {
            return 4;
          }
        }
        else {
          return 5;
        }
      }
      else {
        return 3;
      }
    }
    else {
      i = 2;
    }
    return i;
  }
  
  public static String calcMD5AsString(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.getBytes();
      try
      {
        Object localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).reset();
        int j = paramString.length;
        int i = 0;
        ((MessageDigest)localObject).update(paramString, 0, j);
        paramString = ((MessageDigest)localObject).digest();
        localObject = new StringBuffer();
        while (i < paramString.length)
        {
          ((StringBuffer)localObject).append(Integer.toHexString(paramString[i] & 0xFF));
          i += 1;
        }
        paramString = ((StringBuffer)localObject).toString();
        return paramString;
      }
      catch (NoSuchAlgorithmException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return "";
  }
  
  public static void deleteOldDB(String paramString)
  {
    if (getInstance().getContext() != null)
    {
      paramString = getInstance().getContext().getDatabasePath(paramString);
      if (paramString.exists() != true) {}
    }
    try
    {
      paramString.delete();
      ab.c("GlobalUtil", "deleteDB");
      return;
    }
    catch (Exception paramString)
    {
      label41:
      break label41;
    }
    ab.c("GlobalUtil", "deleteDB failed");
  }
  
  private String filter(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (TextUtils.isEmpty(paramString))
    {
      localStringBuffer.append("NA");
      return localStringBuffer.toString();
    }
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length)
    {
      if ((paramString[i] > ' ') && (paramString[i] != '/') && (paramString[i] != '_') && (paramString[i] != '&') && (paramString[i] != '|') && (paramString[i] != '-')) {
        localStringBuffer.append(paramString[i]);
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String getAppPackageName(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getPackageName();
    }
    return "";
  }
  
  public static int getAppVersionCode(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
        return i;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return 0;
  }
  
  public static String getCurrentDay()
  {
    Date localDate = new Date();
    return ((SimpleDateFormat)yyyyMMddTimeFormat.get()).format(localDate);
  }
  
  public static String getDay(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return ((SimpleDateFormat)yyyyMMddTimeFormat.get()).format(localDate);
  }
  
  public static String getDayAndHour(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return ((SimpleDateFormat)yyyyMMddHHTimeFormat.get()).format(localDate);
  }
  
  public static GlobalUtil getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new GlobalUtil();
      }
      GlobalUtil localGlobalUtil = mInstance;
      return localGlobalUtil;
    }
    finally {}
  }
  
  public static int getInt(Integer paramInteger)
  {
    if (paramInteger == null) {
      return 0;
    }
    return paramInteger.intValue();
  }
  
  private String getMacAddressNew()
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
            return null;
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
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private String getMacAddressOld()
  {
    if (this.mContext == null) {
      return null;
    }
    if (!TextUtils.isEmpty(this.mMACAdress)) {
      return this.mMACAdress;
    }
    try
    {
      Object localObject = ((WifiManager)getContext().getSystemService("wifi")).getConnectionInfo();
      if (localObject != null)
      {
        this.mMACAdress = ((WifiInfo)localObject).getMacAddress();
        return this.mMACAdress;
      }
      this.mMACAdress = "EMPTY";
      localObject = this.mMACAdress;
      return localObject;
    }
    catch (Exception localException)
    {
      ab.c(TAG, "getMacAddress Exception:", localException);
    }
    return "";
  }
  
  public static int getMemUUID()
  {
    try
    {
      int i = mMemUUID;
      mMemUUID = i + 1;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String getNetStatus()
  {
    Object localObject1;
    Object localObject3;
    String str;
    StringBuilder localStringBuilder;
    label154:
    try
    {
      localObject1 = getInstance().getContext();
      if (localObject1 == null) {
        return "";
      }
    }
    finally {}
    try
    {
      if (((Context)localObject1).checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
        return "";
      }
      localObject3 = (ConnectivityManager)((Context)localObject1).getSystemService("connectivity");
      localObject1 = null;
      try
      {
        localObject3 = ((ConnectivityManager)localObject3).getActiveNetworkInfo();
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        ab.e(TAG, localException2.getMessage());
      }
      if (localObject1 == null) {
        return "";
      }
      if (((NetworkInfo)localObject1).getType() == 1) {
        return "wifi";
      }
      localObject1 = ((NetworkInfo)localObject1).getExtraInfo();
      if (localObject1 == null) {
        return "";
      }
      localObject1 = ((String)localObject1).toLowerCase();
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("netInfo  =  ");
      localStringBuilder.append((String)localObject1);
      ab.a(str, localStringBuilder.toString());
      return localObject1;
    }
    catch (Exception localException1)
    {
      break label154;
    }
    return "";
  }
  
  public static String getString(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "empty";
    }
    return str;
  }
  
  public static String getSystemVersion()
  {
    int i = Build.VERSION.SDK_INT;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public static long getUin()
  {
    long l = sUin;
    if (l != 0L) {
      return l;
    }
    try
    {
      sUin = Long.valueOf((String)w.a(w.a(w.a("com.tencent.common.app.BaseApplicationImpl").b("sApplication")).d("getRuntime").a()).d("getAccount").a()).longValue();
      l = sUin;
      return l;
    }
    catch (Throwable localThrowable)
    {
      ab.e(TAG, localThrowable.getMessage());
    }
    return 0L;
  }
  
  public static String getUserId(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "supersdk_nulluser";
    }
    return str;
  }
  
  public static boolean isDBExist(String paramString)
  {
    return (getInstance().getContext() != null) && (getInstance().getContext().getDatabasePath(paramString).exists());
  }
  
  public static boolean isMIUI()
  {
    boolean bool = false;
    try
    {
      if (!TextUtils.isEmpty(SystemProperties.get("ro.miui.ui.version.name", null))) {
        return true;
      }
      if (Build.MANUFACTURER != null) {
        bool = replaceBlank(Build.MANUFACTURER).toLowerCase().contains("xiaomi");
      }
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static boolean isNetworkConncted()
  {
    Object localObject1 = getInstance().getContext();
    boolean bool = false;
    if (localObject1 == null)
    {
      ab.d(TAG, "GlobalUtil.getInstance().getContext() == null.");
      return false;
    }
    Object localObject2 = (ConnectivityManager)((Context)localObject1).getSystemService("connectivity");
    localObject1 = null;
    try
    {
      localObject2 = ((ConnectivityManager)localObject2).getActiveNetworkInfo();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      ab.e(TAG, localException.getMessage());
    }
    if (localObject1 != null) {
      bool = ((NetworkInfo)localObject1).isAvailable();
    }
    return bool;
  }
  
  public static boolean isOppo()
  {
    try
    {
      String str = Build.MANUFACTURER;
      boolean bool = TextUtils.isEmpty(str);
      if ((!bool) && (str.toLowerCase().contains("oppo"))) {
        return true;
      }
      str = Build.FINGERPRINT;
      if (!TextUtils.isEmpty(str))
      {
        bool = str.toLowerCase().contains("oppo");
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      Log.e("DeviceUtils", localException.getMessage(), localException);
    }
    return false;
  }
  
  public static boolean isRecommendGame(String paramString)
  {
    Object localObject = (BoutiqueGameConfig)com.tencent.tmdownloader.internal.storage.b.a().a("key_recommend_games_config", BoutiqueGameConfig.class);
    if ((localObject != null) && (((BoutiqueGameConfig)localObject).pkgList != null) && (((BoutiqueGameConfig)localObject).pkgList.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<isRecommendGame> CONFIG_RECOMMEND_GAMES  size = ");
      localStringBuilder.append(((BoutiqueGameConfig)localObject).pkgList.size());
      localStringBuilder.append("\ncontent=");
      localStringBuilder.append(((BoutiqueGameConfig)localObject).pkgList);
      ab.c("nemo_bgg", localStringBuilder.toString());
      boolean bool = ((BoutiqueGameConfig)localObject).pkgList.contains(paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<isRecommendGame> ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" is bgg：");
      ((StringBuilder)localObject).append(bool);
      ab.c("nemo_bgg", ((StringBuilder)localObject).toString());
      return bool;
    }
    ab.e("nemo_bgg", "<isRecommendGame> CONFIG_RECOMMEND_GAMES error, boutiqueGameConfig is null!");
    return false;
  }
  
  public static boolean isVivo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("-");
    localStringBuilder.append(Build.MODEL);
    return replaceBlank(localStringBuilder.toString().toLowerCase()).contains("vivo");
  }
  
  public static String replaceBlank(String paramString)
  {
    String str = "";
    if (paramString != null) {
      str = Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
    }
    return str;
  }
  
  public static void setClipboardCMD(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("setClipboardCMD taskTmast:");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(", startTime=");
    ((StringBuilder)localObject2).append(paramLong1);
    ((StringBuilder)localObject2).append(", endTime=");
    ((StringBuilder)localObject2).append(paramLong2);
    com.tencent.tmassistantbase.util.b.b.a((String)localObject1, ((StringBuilder)localObject2).toString());
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    localObject1 = Uri.parse(paramString);
    paramString = ((Uri)localObject1).buildUpon();
    paramLong2 -= paramLong1;
    if (paramLong2 < 300000L) {
      paramLong2 = 1800000L;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramLong1);
    paramString.appendQueryParameter("clipboard_start_time", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramLong2);
    paramString.appendQueryParameter("clipboard_expiry_time", ((StringBuilder)localObject2).toString());
    try
    {
      if (TextUtils.isEmpty(((Uri)localObject1).getQueryParameter("hostpname")))
      {
        localObject1 = getAppPackageName(paramContext);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(getAppVersionCode(paramContext));
        localObject2 = ((StringBuilder)localObject2).toString();
        paramString.appendQueryParameter("hostpname", (String)localObject1);
        paramString.appendQueryParameter("hostversioncode", (String)localObject2);
      }
    }
    catch (Throwable localThrowable)
    {
      com.tencent.tmassistantbase.util.b.b.a(TAG, "setClipboardCMD hostpname set failed.", localThrowable);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("$");
    localStringBuilder.append(paramString.build().toString());
    localStringBuilder.append("$");
    setPlainTextToClipboard(paramContext, localStringBuilder.toString());
  }
  
  public static void setPlainTextToClipboard(Context paramContext, String paramString)
  {
    paramContext = (ClipboardManager)paramContext.getSystemService("clipboard");
    if (paramContext == null)
    {
      com.tencent.tmassistantbase.util.b.b.b(TAG, "cm is null!");
      return;
    }
    Object localObject = ClipData.newPlainText("", paramString);
    ClipboardMonitor.setPrimaryClip(paramContext, (ClipData)localObject);
    paramContext.setPrimaryClip((ClipData)localObject);
    paramContext = TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setPlainTextToClipboard plainText:");
    ((StringBuilder)localObject).append(paramString);
    com.tencent.tmassistantbase.util.b.b.a(paramContext, ((StringBuilder)localObject).toString());
  }
  
  public static void updateFilePathAuthorized(String paramString)
  {
    Object localObject3 = new File(paramString);
    Object localObject2 = ((File)localObject3).getParent();
    Object localObject1 = new File((String)localObject2).getParent();
    paramString = new File((String)localObject1).getParent();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("chmod 777 ");
      localStringBuilder.append(((File)localObject3).getAbsolutePath());
      localObject3 = localStringBuilder.toString();
      Runtime.getRuntime().exec((String)localObject3);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("chmod 777 ");
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject2 = ((StringBuilder)localObject3).toString();
      Runtime.getRuntime().exec((String)localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("chmod 777 ");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      Runtime.getRuntime().exec((String)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("chmod 777");
      ((StringBuilder)localObject1).append(paramString);
      paramString = ((StringBuilder)localObject1).toString();
      Runtime.getRuntime().exec(paramString);
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean canReportValue()
  {
    return "wifi".equals(getNetStatus());
  }
  
  public void destroy()
  {
    this.mContext = null;
    mInstance = null;
  }
  
  public String getAndroidIdInPhone()
  {
    try
    {
      if (this.mContext == null) {
        return null;
      }
      String str = Settings.Secure.getString(getContext().getContentResolver(), "android_id");
      return str;
    }
    catch (Exception localException)
    {
      ab.c(TAG, "getAndroidIdInPhone Exception:", localException);
    }
    return "";
  }
  
  public int getAppVersionCode()
  {
    Object localObject = this.mContext;
    if (localObject == null) {
      return 0;
    }
    localObject = ((Context)localObject).getPackageName();
    try
    {
      int i = this.mContext.getPackageManager().getPackageInfo((String)localObject, 0).versionCode;
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public String getBrand()
  {
    return filter(Build.BRAND);
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public String getImei()
  {
    try
    {
      if (TextUtils.isEmpty(mDevicedId)) {
        mDevicedId = (String)w.a("com.tencent.open.appcommon.js.AppInterface").d("getImei").a();
      }
      String str = mDevicedId;
      return str;
    }
    catch (Exception localException)
    {
      ab.c(TAG, "getImei Exception:", localException);
    }
    return null;
  }
  
  public String getImsi()
  {
    try
    {
      if (this.mContext == null) {
        return null;
      }
      String str = (String)w.a("com.tencent.open.appcommon.js.AppInterface").d("getImsi").a();
      return str;
    }
    catch (Exception localException)
    {
      ab.c(TAG, "getImsi Exception:", localException);
    }
    return null;
  }
  
  public String getMacAddress()
  {
    String str2 = getMacAddressOld();
    String str1;
    if ((!TextUtils.isEmpty(str2)) && (!"02:00:00:00:00:00".equalsIgnoreCase(str2)))
    {
      str1 = str2;
      if (!"EMPTY".equalsIgnoreCase(str2)) {}
    }
    else
    {
      str1 = getMacAddressNew();
    }
    str2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("address:");
    localStringBuilder.append(str1);
    ab.c(str2, localStringBuilder.toString());
    return str1;
  }
  
  public String getManufacture()
  {
    return filter(Build.MANUFACTURER);
  }
  
  public String getModel()
  {
    return filter(Build.MODEL);
  }
  
  public String getNetworkOperator()
  {
    try
    {
      if (this.mContext == null) {
        return "";
      }
      String str = ((TelephonyManager)this.mContext.getSystemService("phone")).getNetworkOperator();
      return str;
    }
    catch (Exception localException)
    {
      ab.c(TAG, "getNetworkOperator Exception:", localException);
    }
    return "";
  }
  
  public int getNetworkType()
  {
    try
    {
      if (this.mContext == null) {
        return 0;
      }
      int i = ((TelephonyManager)this.mContext.getSystemService("phone")).getNetworkType();
      return i;
    }
    catch (Exception localException)
    {
      ab.c(TAG, "getNetworkType Exception:", localException);
    }
    return 0;
  }
  
  public String getPhoneGuid()
  {
    Object localObject = this.mContext;
    if (localObject == null) {
      return "";
    }
    localObject = ((Context)localObject).getSharedPreferences("TMAssistantSDKSharedPreference", 4);
    if (localObject != null) {
      return ((SharedPreferences)localObject).getString("TMAssistantSDKPhoneGUID", "");
    }
    return "";
  }
  
  public String getProduct()
  {
    return filter(Build.PRODUCT);
  }
  
  public int getQQDownloaderAPILevel()
  {
    if (this.mContext == null)
    {
      ab.c("SelfUpdateSDK", "context == null");
      return 0;
    }
    ab.c("SelfUpdateSDK", "getQQDownloaderAPILevel");
    try
    {
      Object localObject = this.mContext.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("appInfo:");
      localStringBuilder.append(localObject);
      ab.c("SelfUpdateSDK", localStringBuilder.toString());
      if ((localObject != null) && (((ApplicationInfo)localObject).metaData != null))
      {
        int i = ((ApplicationInfo)localObject).metaData.getInt("com.tencent.android.qqdownloader.sdk.apilevel");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("apiLevel:");
        ((StringBuilder)localObject).append(i);
        ab.c("SelfUpdateSDK", ((StringBuilder)localObject).toString());
        return i;
      }
      return 0;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public int getQQDownloaderConnectLevel()
  {
    if (this.mContext == null)
    {
      ab.c("SelfUpdateSDK", "context == null");
      return 0;
    }
    ab.c("SelfUpdateSDK", "getQQDownloaderConnectLevel");
    try
    {
      Object localObject = this.mContext.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("appInfo:");
      localStringBuilder.append(localObject);
      ab.c("SelfUpdateSDK", localStringBuilder.toString());
      if ((localObject != null) && (((ApplicationInfo)localObject).metaData != null))
      {
        int i = ((ApplicationInfo)localObject).metaData.getInt("com.tencent.android.qqdownloader.sdk.connectlevel");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("apiLevel:");
        ((StringBuilder)localObject).append(i);
        ab.c("SelfUpdateSDK", ((StringBuilder)localObject).toString());
        return i;
      }
      return 0;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public int getQQDownloaderVersionCode()
  {
    Object localObject1;
    label57:
    try
    {
      localObject1 = this.mContext;
      if (localObject1 == null) {
        return 0;
      }
    }
    finally {}
    try
    {
      localObject1 = this.mContext.getPackageManager();
      if (localObject1 != null)
      {
        localObject1 = ((PackageManager)localObject1).getPackageInfo("com.tencent.android.qqdownloader", 0);
        if (localObject1 == null) {
          return 0;
        }
        int i = ((PackageInfo)localObject1).versionCode;
        return i;
      }
      return 0;
    }
    catch (Exception localException)
    {
      break label57;
    }
    return 0;
  }
  
  public String getQadid()
  {
    if (TextUtils.isEmpty(mQadid))
    {
      localObject = this.mContext;
      if (localObject != null)
      {
        mQadid = t.a(((Context)localObject).getApplicationContext());
        localObject = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(">getQadid ");
        localStringBuilder.append(mQadid);
        ab.c((String)localObject, localStringBuilder.toString());
        return mQadid;
      }
    }
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">getQadid ");
    localStringBuilder.append(mQadid);
    ab.c((String)localObject, localStringBuilder.toString());
    return mQadid;
  }
  
  public String getQimei()
  {
    if ((TextUtils.isEmpty(mQImei)) && (this.mContext != null))
    {
      try
      {
        w.a("com.tencent.beacon.event.UserAction").a("initUserAction", new Object[] { this.mContext.getApplicationContext() });
        mQImei = (String)w.a("com.tencent.beacon.event.UserAction").d("getQIMEI").a();
      }
      catch (Throwable localThrowable)
      {
        localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(">getQimei");
        localStringBuilder.append(localThrowable.getMessage());
        ab.e((String)localObject, localStringBuilder.toString());
      }
      str = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(">getQimei");
      ((StringBuilder)localObject).append(mQImei);
      ab.c(str, ((StringBuilder)localObject).toString());
      return mQImei;
    }
    String str = TAG;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(">getQimei");
    ((StringBuilder)localObject).append(mQImei);
    ab.c(str, ((StringBuilder)localObject).toString());
    return mQImei;
  }
  
  public int getScreenHeight()
  {
    Context localContext = this.mContext;
    if (localContext != null) {
      return localContext.getResources().getDisplayMetrics().heightPixels;
    }
    return 0;
  }
  
  public int getScreenWidth()
  {
    Context localContext = this.mContext;
    if (localContext != null) {
      return localContext.getResources().getDisplayMetrics().widthPixels;
    }
    return 0;
  }
  
  public SharedPreferences getSharedPreferences()
  {
    if (getInstance().getContext() == null)
    {
      ab.d(TAG, "GlobalUtil.getInstance().getContext() == null.");
      return null;
    }
    return getInstance().getContext().getSharedPreferences("TMAssistantSDKSharedPreference", 4);
  }
  
  public void setContext(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext != null) {
      localContext = paramContext.getApplicationContext();
    }
    this.mContext = localContext;
    this.mQUA = new v(localContext).a();
    k.a().post(new h(this));
  }
  
  public void setNetTypeValue(byte paramByte) {}
  
  public void setPhoneGuid(String paramString)
  {
    if (this.mContext == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      SharedPreferences localSharedPreferences = this.mContext.getSharedPreferences("TMAssistantSDKSharedPreference", 4);
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putString("TMAssistantSDKPhoneGUID", paramString).commit();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.GlobalUtil
 * JD-Core Version:    0.7.0.1
 */