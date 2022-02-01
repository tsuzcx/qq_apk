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
  protected static final String TAG = GlobalUtil.class.getSimpleName();
  protected static final String UN_DEFINED = "NA";
  protected static String mDevicedId;
  protected static GlobalUtil mInstance = null;
  protected static int mMemUUID = 0;
  private static String mQImei;
  private static String mQadid;
  private static long sUin;
  public static ThreadLocal<SimpleDateFormat> yyyyMMddHHTimeFormat = new j();
  public static ThreadLocal<SimpleDateFormat> yyyyMMddTimeFormat;
  protected Context mContext;
  private String mMACAdress = null;
  public String mQUA = "";
  
  static
  {
    mDevicedId = "";
    sUin = 0L;
    mQImei = "";
    mQadid = "";
    yyyyMMddTimeFormat = new i();
  }
  
  protected GlobalUtil()
  {
    try
    {
      ab.c(TAG, "isMIUI:" + isMIUI());
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
    switch (paramInt)
    {
    case -1000: 
    case -26: 
    case -24: 
    default: 
      return 604;
    case 0: 
      return 0;
    case -1: 
      return 709;
    case -11: 
      return 708;
    case -12: 
      return 730;
    case -13: 
      return 703;
    case -15: 
      return 1;
    case -16: 
      return 731;
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
    }
    return 701;
  }
  
  public static int assistantState2SDKState(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 7: 
    case 8: 
    default: 
      return 0;
    case 1: 
      return 2;
    case 6: 
      return 1;
    case 2: 
      return 3;
    case 4: 
      return 4;
    case 3: 
      return 5;
    }
    return 6;
  }
  
  public static String calcMD5AsString(String paramString)
  {
    int i = 0;
    Object localObject = "";
    if (!TextUtils.isEmpty(paramString)) {
      paramString = paramString.getBytes();
    }
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).reset();
      ((MessageDigest)localObject).update(paramString, 0, paramString.length);
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      while (i < paramString.length)
      {
        ((StringBuffer)localObject).append(Integer.toHexString(paramString[i] & 0xFF));
        i += 1;
      }
      localObject = ((StringBuffer)localObject).toString();
      return localObject;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
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
      ab.c("GlobalUtil", "deleteDB failed");
    }
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
    int i = 0;
    if (paramContext != null) {}
    try
    {
      i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
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
  
  /* Error */
  public static String getNetStatus()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 183	com/tencent/tmassistantbase/util/GlobalUtil:getInstance	()Lcom/tencent/tmassistantbase/util/GlobalUtil;
    //   6: invokevirtual 187	com/tencent/tmassistantbase/util/GlobalUtil:getContext	()Landroid/content/Context;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnonnull +11 -> 22
    //   14: ldc 53
    //   16: astore_0
    //   17: ldc 2
    //   19: monitorexit
    //   20: aload_0
    //   21: areturn
    //   22: aload_0
    //   23: ldc_w 355
    //   26: invokevirtual 359	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   29: ifeq +16 -> 45
    //   32: ldc 53
    //   34: astore_0
    //   35: goto -18 -> 17
    //   38: astore_0
    //   39: ldc 53
    //   41: astore_0
    //   42: goto -25 -> 17
    //   45: aload_0
    //   46: ldc_w 361
    //   49: invokevirtual 333	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   52: checkcast 363	android/net/ConnectivityManager
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 367	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   60: astore_0
    //   61: aload_0
    //   62: ifnonnull +25 -> 87
    //   65: ldc 53
    //   67: astore_0
    //   68: goto -51 -> 17
    //   71: astore_0
    //   72: getstatic 47	com/tencent/tmassistantbase/util/GlobalUtil:TAG	Ljava/lang/String;
    //   75: aload_0
    //   76: invokevirtual 370	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   79: invokestatic 373	com/tencent/tmassistantbase/util/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aconst_null
    //   83: astore_0
    //   84: goto -23 -> 61
    //   87: aload_0
    //   88: invokevirtual 378	android/net/NetworkInfo:getType	()I
    //   91: iconst_1
    //   92: if_icmpne +10 -> 102
    //   95: ldc_w 329
    //   98: astore_0
    //   99: goto -82 -> 17
    //   102: aload_0
    //   103: invokevirtual 381	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   106: astore_0
    //   107: aload_0
    //   108: ifnonnull +9 -> 117
    //   111: ldc 53
    //   113: astore_0
    //   114: goto -97 -> 17
    //   117: aload_0
    //   118: invokevirtual 384	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   121: astore_0
    //   122: getstatic 47	com/tencent/tmassistantbase/util/GlobalUtil:TAG	Ljava/lang/String;
    //   125: new 83	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   132: ldc_w 386
    //   135: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_0
    //   139: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 389	com/tencent/tmassistantbase/util/ab:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: goto -131 -> 17
    //   151: astore_0
    //   152: ldc 2
    //   154: monitorexit
    //   155: aload_0
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	26	0	localObject1	Object
    //   38	1	0	localException1	Exception
    //   41	27	0	localObject2	Object
    //   71	5	0	localException2	Exception
    //   83	56	0	str	String
    //   151	5	0	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   22	32	38	java/lang/Exception
    //   56	61	71	java/lang/Exception
    //   3	10	151	finally
    //   22	32	151	finally
    //   45	56	151	finally
    //   56	61	151	finally
    //   72	82	151	finally
    //   87	95	151	finally
    //   102	107	151	finally
    //   117	148	151	finally
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
    return i + "";
  }
  
  public static long getUin()
  {
    if (sUin != 0L) {
      return sUin;
    }
    try
    {
      sUin = Long.valueOf((String)w.a(w.a(w.a("com.tencent.common.app.BaseApplicationImpl").b("sApplication")).d("getRuntime").a()).d("getAccount").a()).longValue();
      long l = sUin;
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
    try
    {
      if (!TextUtils.isEmpty(SystemProperties.get("ro.miui.ui.version.name", null))) {
        return true;
      }
      if (Build.MANUFACTURER != null)
      {
        boolean bool = replaceBlank(Build.MANUFACTURER).toLowerCase().contains("xiaomi");
        return bool;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static boolean isNetworkConncted()
  {
    Object localObject1 = getInstance().getContext();
    if (localObject1 == null)
    {
      ab.d(TAG, "GlobalUtil.getInstance().getContext() == null.");
      return false;
    }
    localObject1 = (ConnectivityManager)((Context)localObject1).getSystemService("connectivity");
    try
    {
      localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
      if (localObject1 != null)
      {
        bool = ((NetworkInfo)localObject1).isAvailable();
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e(TAG, localException.getMessage());
        Object localObject2 = null;
        continue;
        boolean bool = false;
      }
    }
  }
  
  public static boolean isOppo()
  {
    try
    {
      String str = Build.MANUFACTURER;
      if ((!TextUtils.isEmpty(str)) && (str.toLowerCase().contains("oppo"))) {
        return true;
      }
      str = Build.FINGERPRINT;
      if (!TextUtils.isEmpty(str))
      {
        boolean bool = str.toLowerCase().contains("oppo");
        if (bool) {
          break label70;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("DeviceUtils", localException.getMessage(), localException);
      }
    }
    return false;
    label70:
    return true;
  }
  
  public static boolean isRecommendGame(String paramString)
  {
    BoutiqueGameConfig localBoutiqueGameConfig = (BoutiqueGameConfig)com.tencent.tmdownloader.internal.storage.b.a().a("key_recommend_games_config", BoutiqueGameConfig.class);
    if ((localBoutiqueGameConfig != null) && (localBoutiqueGameConfig.pkgList != null) && (localBoutiqueGameConfig.pkgList.size() != 0))
    {
      ab.c("nemo_bgg", "<isRecommendGame> CONFIG_RECOMMEND_GAMES  size = " + localBoutiqueGameConfig.pkgList.size() + "\ncontent=" + localBoutiqueGameConfig.pkgList);
      boolean bool = localBoutiqueGameConfig.pkgList.contains(paramString);
      ab.c("nemo_bgg", "<isRecommendGame> " + paramString + " is bgg：" + bool);
      return bool;
    }
    ab.e("nemo_bgg", "<isRecommendGame> CONFIG_RECOMMEND_GAMES error, boutiqueGameConfig is null!");
    return false;
  }
  
  public static boolean isVivo()
  {
    return replaceBlank((Build.MANUFACTURER + "-" + Build.MODEL).toLowerCase()).contains("vivo");
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
    com.tencent.tmassistantbase.util.b.b.a(TAG, "setClipboardCMD taskTmast:" + paramString + ", startTime=" + paramLong1 + ", endTime=" + paramLong2);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = Uri.parse(paramString);
    paramString = ((Uri)localObject).buildUpon();
    paramLong2 -= paramLong1;
    if (paramLong2 >= 300000L) {}
    for (;;)
    {
      paramString.appendQueryParameter("clipboard_start_time", "" + paramLong1);
      paramString.appendQueryParameter("clipboard_expiry_time", "" + paramLong2);
      try
      {
        if (TextUtils.isEmpty(((Uri)localObject).getQueryParameter("hostpname")))
        {
          localObject = getAppPackageName(paramContext);
          String str = "" + getAppVersionCode(paramContext);
          paramString.appendQueryParameter("hostpname", (String)localObject);
          paramString.appendQueryParameter("hostversioncode", str);
        }
        setPlainTextToClipboard(paramContext, "$" + paramString.build().toString() + "$");
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          com.tencent.tmassistantbase.util.b.b.a(TAG, "setClipboardCMD hostpname set failed.", localThrowable);
        }
      }
      paramLong2 = 1800000L;
    }
  }
  
  public static void setPlainTextToClipboard(Context paramContext, String paramString)
  {
    paramContext = (ClipboardManager)paramContext.getSystemService("clipboard");
    if (paramContext == null)
    {
      com.tencent.tmassistantbase.util.b.b.b(TAG, "cm is null!");
      return;
    }
    paramContext.setPrimaryClip(ClipData.newPlainText("", paramString));
    com.tencent.tmassistantbase.util.b.b.a(TAG, "setPlainTextToClipboard plainText:" + paramString);
  }
  
  public static void updateFilePathAuthorized(String paramString)
  {
    Object localObject = new File(paramString);
    String str2 = ((File)localObject).getParent();
    String str1 = new File(str2).getParent();
    paramString = new File(str1).getParent();
    try
    {
      localObject = "chmod 777 " + ((File)localObject).getAbsolutePath();
      Runtime.getRuntime().exec((String)localObject);
      str2 = "chmod 777 " + str2;
      Runtime.getRuntime().exec(str2);
      str1 = "chmod 777 " + str1;
      Runtime.getRuntime().exec(str1);
      paramString = "chmod 777" + paramString;
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
    if (this.mContext == null) {
      return 0;
    }
    String str = this.mContext.getPackageName();
    try
    {
      int i = this.mContext.getPackageManager().getPackageInfo(str, 0).versionCode;
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
    ab.c(TAG, "address:" + str1);
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
    if (this.mContext == null) {
      return "";
    }
    SharedPreferences localSharedPreferences = this.mContext.getSharedPreferences("TMAssistantSDKSharedPreference", 4);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString("TMAssistantSDKPhoneGUID", "");
    }
    return "";
  }
  
  public String getProduct()
  {
    return filter(Build.PRODUCT);
  }
  
  public int getQQDownloaderAPILevel()
  {
    if (this.mContext == null) {
      ab.c("SelfUpdateSDK", "context == null");
    }
    for (;;)
    {
      return 0;
      ab.c("SelfUpdateSDK", "getQQDownloaderAPILevel");
      try
      {
        ApplicationInfo localApplicationInfo = this.mContext.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
        ab.c("SelfUpdateSDK", "appInfo:" + localApplicationInfo);
        if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null))
        {
          int i = localApplicationInfo.metaData.getInt("com.tencent.android.qqdownloader.sdk.apilevel");
          ab.c("SelfUpdateSDK", "apiLevel:" + i);
          return i;
        }
      }
      catch (Exception localException) {}
    }
    return 0;
  }
  
  public int getQQDownloaderConnectLevel()
  {
    if (this.mContext == null) {
      ab.c("SelfUpdateSDK", "context == null");
    }
    for (;;)
    {
      return 0;
      ab.c("SelfUpdateSDK", "getQQDownloaderConnectLevel");
      try
      {
        ApplicationInfo localApplicationInfo = this.mContext.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
        ab.c("SelfUpdateSDK", "appInfo:" + localApplicationInfo);
        if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null))
        {
          int i = localApplicationInfo.metaData.getInt("com.tencent.android.qqdownloader.sdk.connectlevel");
          ab.c("SelfUpdateSDK", "apiLevel:" + i);
          return i;
        }
      }
      catch (Exception localException) {}
    }
    return 0;
  }
  
  public int getQQDownloaderVersionCode()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        localObject1 = this.mContext;
        if (localObject1 != null) {
          continue;
        }
        i = j;
      }
      finally
      {
        try
        {
          Object localObject1 = this.mContext.getPackageManager();
          i = j;
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((PackageManager)localObject1).getPackageInfo("com.tencent.android.qqdownloader", 0);
          i = j;
          if (localObject1 == null) {
            continue;
          }
          i = ((PackageInfo)localObject1).versionCode;
        }
        catch (Exception localException)
        {
          int i = j;
        }
        localObject2 = finally;
      }
      return i;
    }
  }
  
  public String getQadid()
  {
    if ((!TextUtils.isEmpty(mQadid)) || (this.mContext == null))
    {
      ab.c(TAG, ">getQadid " + mQadid);
      return mQadid;
    }
    mQadid = t.a(this.mContext.getApplicationContext());
    ab.c(TAG, ">getQadid " + mQadid);
    return mQadid;
  }
  
  public String getQimei()
  {
    if ((!TextUtils.isEmpty(mQImei)) || (this.mContext == null))
    {
      ab.c(TAG, ">getQimei" + mQImei);
      return mQImei;
    }
    try
    {
      w.a("com.tencent.beacon.event.UserAction").a("initUserAction", new Object[] { this.mContext.getApplicationContext() });
      mQImei = (String)w.a("com.tencent.beacon.event.UserAction").d("getQIMEI").a();
      ab.c(TAG, ">getQimei" + mQImei);
      return mQImei;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ab.e(TAG, ">getQimei" + localThrowable.getMessage());
      }
    }
  }
  
  public int getScreenHeight()
  {
    if (this.mContext != null) {
      return this.mContext.getResources().getDisplayMetrics().heightPixels;
    }
    return 0;
  }
  
  public int getScreenWidth()
  {
    if (this.mContext != null) {
      return this.mContext.getResources().getDisplayMetrics().widthPixels;
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
    if (this.mContext == null) {}
    SharedPreferences localSharedPreferences;
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString));
      localSharedPreferences = this.mContext.getSharedPreferences("TMAssistantSDKSharedPreference", 4);
    } while (localSharedPreferences == null);
    localSharedPreferences.edit().putString("TMAssistantSDKPhoneGUID", paramString).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.GlobalUtil
 * JD-Core Version:    0.7.0.1
 */