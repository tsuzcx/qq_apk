package org.xwalk.core;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView;
import com.tencent.xweb.ISharedPreferenceProvider;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.ae;
import com.tencent.xweb.b;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import com.tencent.xweb.util.c;
import com.tencent.xweb.util.f;
import com.tencent.xweb.v;
import java.io.Closeable;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URI;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class XWalkEnvironment
{
  private static final String APK_DIR = "apk";
  public static final String[] DEFAULT_MANDATORY_RESOURCES;
  public static final String DOWNLOAD_CONFIG_URL = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig.xml";
  public static final String DOWNLOAD_CONFIG_URL_THIRD_PARD = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_public.xml";
  public static final String DOWNLOAD_PLUGIN_UPDATE_CONFIG_URL = "https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig.xml";
  public static final String DOWNLOAD_PLUGIN_UPDATE_CONFIG_URL_THIRD_PARD = "https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_public.xml";
  public static final String DOWNLOAD_PLUGIN_UPDATE_TEST_CONFIG_DEFAULT_URL = "https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml";
  public static final String DOWNLOAD_X86_CONFIG_URL = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86.xml";
  public static final String LOCAL_TEST_ZIP_NAME = "runtime_package.zip";
  private static final String META_XWALK_DOWNCONFIG_URL = "xwalk_downconfig_url";
  public static final String MM_PACKAGE_NAME = "com.tencent.mm";
  private static final String OPTIMIZED_DEX_DIR = "dex";
  private static final String PACKAGE_RE = "[a-z]+\\.[a-z0-9]+\\.[a-z0-9]+.*";
  private static final String PATCH_ZIP_TEMP_DECOMPRESS_DIR = "patch_temp_decompress";
  public static final String RUNTIME_ABI_ARM32_STR = "armeabi-v7a";
  public static final String RUNTIME_ABI_ARM64_STR = "arm64-v8a";
  public static final int SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION = 153;
  public static final int SDK_SUPPORT_INVOKE_RUNTIME_MIN_APKVERSION = 255;
  public static final int SDK_SUPPORT_MIN_APKVERSION = 49;
  public static final int SDK_VERSION = 201201;
  private static final int SPECIAL_TEST_USER_ID = 10001;
  public static final String SP_KEY_DEVICE_RD = "sNDeviceRd";
  public static final String SP_KEY_FILE_READER_POSTFIX_COUNT = "_count";
  public static final String SP_KEY_FILE_READER_POSTFIX_REPORT_UV_DATE = "_report_uv_date";
  public static final String SP_KEY_FILE_READER_POSTFIX_TIME = "_time";
  private static final String SP_KEY_GRAY_VALUE = "GRAY_VALUE";
  private static final String SP_KEY_GRAY_VALUE_TEST = "TEST_GRAY_VALUE";
  private static final String SP_KEY_IP_TYPE = "IP_TYPE";
  public static final String SP_KEY_PLUGIN_AVAILABLE_VERSION = "availableVersion";
  public static final String SP_KEY_PLUGIN_LAST_REPORT_DATE = "lastReportDate";
  public static final String SP_KEY_PLUGIN_LAST_REPORT_VERSION = "lastReportVersion";
  public static final String SP_KEY_PLUGIN_PATCH_DOWNLOAD_COUNT_PREFIX = "patchDownloadCount_";
  public static final String SP_KEY_PLUGIN_SUPPORT_FORMATS = "supportFormats";
  private static final String SP_KEY_PLUGIN_TEST_CONFIG_URL = "XWEB_PLUGIN_TEST_CONFIG_URL";
  public static final String SP_KEY_PLUGIN_UPDATE_CONFIG_LAST_FETCH_TIME = "nLastFetchPluginConfigTime";
  public static final String SP_KEY_PLUGIN_UPDATE_PROCESS_ID = "nUpdatingProcessId";
  public static final String SP_NAME_FILE_READER_RECORD = "xwalk_reader_record";
  private static final String SP_NAME_PLUGIN_UPDATE_INFO = "xwalk_plugin_update_info";
  private static final String SP_NAME_PLUGIN_VERSION_INFO_PREFIX = "xwalk_plugin_version_info_";
  public static final String SP_NAME_VERSION_INFO = "XWALKINFOS";
  private static final String TAG = "XWalkEnvironment";
  public static final int TEST_APK_START_VERSION = 100000000;
  public static String UPDATEINFOTAG = "xwalk_update_info";
  public static final String XWALK_CORE_APK_NAME = "base.apk";
  public static final String XWALK_CORE_CLASSES_DEX = "classes.dex";
  private static final String XWALK_CORE_EXTRACTED_DIR = "extracted_xwalkcore";
  public static final String XWALK_CORE_FILELIST_CONFIG_NAME = "filelist.config";
  private static final String XWALK_CORE_NAME_PREFIX = "xwalk_";
  private static final String XWALK_CORE_PATCH_CONFIG_NAME = "patch.config";
  private static final String XWALK_CORE_PATCH_NAME = "patch.zip";
  public static final String[] XWALK_CORE_PROVIDER_LIST;
  private static final String XWALK_CORE_RES_FILELIST_CONFIG_NAME = "reslist.config";
  private static final String XWALK_CORE_ZIP_NAME = "base.zip";
  public static final String XWALK_ENV_MAP_KEY_ISGPVERSION = "isgpversion";
  public static final String XWALK_ENV_MAP_KEY_PROCESSNAME = "processname";
  public static final int XWALK_GET_FROM_PROVIDER_MAX_COUNT = 2;
  private static final String XWALK_PLUGIN_BASE_DIR = "xwalkplugin";
  public static final String XWALK_PLUGIN_NAME_EXCEL = "XFilesExcelReader";
  public static final String XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO = "FullScreenVideo";
  public static final String XWALK_PLUGIN_NAME_OFFICE = "XFilesOfficeReader";
  public static final String XWALK_PLUGIN_NAME_PDF = "XFilesPDFReader";
  public static final String XWALK_PLUGIN_NAME_PPT = "XFilesPPTReader";
  public static final String XWALK_PLUGIN_NAME_WORD = "XFilesWordReader";
  private static final String XWALK_PLUGIN_UPDATE_CONFIG_NAME = "pluginUpdateConfig.xml";
  public static final int XWALK_PLUGIN_UPDATE_PERIOD_DEFAULT = 90000000;
  private static final String XWALK_UPDATE_CONFIG_DIR = "xwalkconfig";
  private static final String ZIP_DIR = "zip";
  private static boolean isTurnOnKVLog;
  private static int sAppClientVersion = 0;
  private static Set<String> sAppInfos;
  private static Context sApplicationContext;
  private static String sApplicationName;
  static boolean sBHasInitedSafePsProvider;
  static boolean sBIsIpTypeChanged;
  static long sConfigPerios;
  private static String sDeviceAbi;
  private static int sForceDarkBehavior;
  private static Boolean sIsDownloadMode;
  private static Boolean sIsDownloadModeUpdate;
  private static boolean sIsForceDarkMode;
  private static boolean sIsPluginInited;
  private static Boolean sIsXWalkVerify;
  static Method sMMKVMethod;
  static int sNChromiuVersion;
  public static int sNDeviceRd;
  static int sPid;
  private static String sRuntimeAbi;
  static ISharedPreferenceProvider sSPProvider;
  static String sStrCurentProcessName;
  static String sStrDeviceId;
  private static String sStrTempPluginUpdateConfigUrl;
  private static String sStrTempUpdateConfigUrl;
  private static int sTempPluginUpdatePeriod;
  private static boolean sUsingCustomContext;
  private static String sXWalkApkUrl;
  private static String sXWalkDownConfigUrl;
  static HashMap<String, Object> sXWebArgs;
  private static XWebCoreInfo sXWebCoreInfo;
  static int s_grayValue;
  static String s_todayDate;
  static int s_todayGrayValue;
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(true);
    XWALK_CORE_PROVIDER_LIST = new String[] { "com.tencent.mm" };
    sIsPluginInited = false;
    sIsDownloadMode = localBoolean;
    sIsDownloadModeUpdate = localBoolean;
    sTempPluginUpdatePeriod = -1;
    sUsingCustomContext = false;
    sIsForceDarkMode = false;
    sForceDarkBehavior = 2;
    isTurnOnKVLog = false;
    sBHasInitedSafePsProvider = false;
    sSPProvider = null;
    sPid = Process.myPid();
    s_grayValue = 0;
    s_todayGrayValue = 0;
    s_todayDate = "";
    sNChromiuVersion = -1;
    sNDeviceRd = 0;
    sBIsIpTypeChanged = false;
    sStrDeviceId = null;
    DEFAULT_MANDATORY_RESOURCES = new String[] { "classes.dex", "icudtl.dat", "xwalk.pak", "xwalk_100_percent.pak", "xweb_fullscreen_video.js" };
    sConfigPerios = 0L;
    sAppInfos = new HashSet();
  }
  
  static int _getChromiunVersion()
  {
    Object localObject1 = getApplicationContext().getPackageManager();
    try
    {
      localObject1 = ((PackageManager)localObject1).getPackageInfo("com.google.android.webview", 0);
      if (localObject1 == null) {
        break label42;
      }
      i = getVerFromVersionName(((PackageInfo)localObject1).versionName);
      if (i <= 0) {
        break label42;
      }
      return i;
    }
    catch (Exception localException2)
    {
      int i;
      label34:
      break label34;
    }
    Log.e("XWalkEnvironment", "Android System WebView is not found");
    try
    {
      label42:
      if (!runnintOnUiThread())
      {
        Log.e("XWalkEnvironment", "_getChromiunVersion NOT IN UI THREAD");
        return 0;
      }
      localObject1 = new DtWebView(getApplicationContext()).getSettings().getUserAgentString();
      if (localObject1 != null)
      {
        localObject2 = ((String)localObject1).split("Chrome/");
        if ((localObject2 != null) && (localObject2.length != 0))
        {
          if ((localObject2.length == 1) && (localObject2[0].length() == ((String)localObject1).length())) {
            return 0;
          }
          i = getVerFromVersionName(localObject2[1]);
          return i;
        }
        return 0;
      }
    }
    catch (Exception localException1)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Android System WebView is not found ");
      ((StringBuilder)localObject2).append(localException1.getMessage());
      Log.e("XWalkEnvironment", ((StringBuilder)localObject2).toString());
    }
    return 0;
  }
  
  public static Activity activityFromContext(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      return (Activity)paramContext;
    }
    if ((paramContext instanceof ContextWrapper))
    {
      Context localContext = ((ContextWrapper)paramContext).getBaseContext();
      if (localContext != paramContext) {
        return activityFromContext(localContext);
      }
    }
    return null;
  }
  
  public static void addXWalkInitializeLog(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return;
      }
      Log.i("XWalkUpdater", paramString);
      if (!isTurnOnKVLog) {
        return;
      }
      String str = new SimpleDateFormat("MM-dd hh:mm:ss").format(new Date());
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(sPid);
      ((StringBuilder)localObject).append(getModuleName());
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" : ");
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      localObject = getSharedPreferencesForLog();
      str = ((SharedPreferences)localObject).getString("log", "");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n");
      localStringBuilder.append(str);
      str = localStringBuilder.toString();
      paramString = str;
      if (str.length() > 10240) {
        paramString = str.substring(0, 5120);
      }
      ((SharedPreferences)localObject).edit().putString("log", paramString).apply();
    }
  }
  
  public static void addXWalkInitializeLog(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramString2);
    addXWalkInitializeLog(localStringBuilder.toString());
  }
  
  public static void appendAppInfo(String paramString)
  {
    try
    {
      if (!sAppInfos.contains(paramString)) {
        sAppInfos.add(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean checkApiVersionBaseApkExist(int paramInt)
  {
    return new File(getDownloadApkPath(paramInt)).exists();
  }
  
  public static void clearAllVersion(Context paramContext)
  {
    if ((paramContext != null) && (paramContext.getApplicationInfo() != null))
    {
      if (paramContext.getApplicationInfo().dataDir == null) {
        return;
      }
      paramContext = new File(paramContext.getApplicationInfo().dataDir).listFiles();
      if (paramContext == null) {
        return;
      }
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramContext[i];
        if ((localObject.getName().startsWith("app_xwalk_")) && (localObject.isDirectory())) {
          c.b(localObject.getAbsolutePath());
        }
        i += 1;
      }
      setAvailableVersion(-1, "", "armeabi-v7a");
      setAvailableVersion(-1, "", "arm64-v8a");
    }
  }
  
  public static boolean containsAppInfo(String paramString)
  {
    try
    {
      paramString = paramString.split("&");
      if ((paramString != null) && (paramString.length != 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          CharSequence localCharSequence = paramString[i];
          if (!TextUtils.isEmpty(localCharSequence))
          {
            boolean bool = sAppInfos.contains(localCharSequence.trim());
            if (!bool) {
              return false;
            }
          }
          i += 1;
        }
        return true;
      }
      return true;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static boolean delApiVersion(int paramInt)
  {
    return c.b(getVesionDir(paramInt));
  }
  
  public static String dumpAppInfo()
  {
    Iterator localIterator = sAppInfos.iterator();
    StringBuilder localStringBuilder;
    for (String str1 = ""; localIterator.hasNext(); str1 = localStringBuilder.toString())
    {
      String str2 = (String)localIterator.next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localStringBuilder.append(";");
    }
    return str1;
  }
  
  public static int getAppClientVersion()
  {
    try
    {
      int i = sAppClientVersion;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static Context getApplicationContext()
  {
    return sApplicationContext;
  }
  
  private static String getApplicationMetaData(String paramString)
  {
    try
    {
      paramString = sApplicationContext.getPackageManager().getApplicationInfo(sApplicationContext.getPackageName(), 128).metaData.get(paramString).toString();
      return paramString;
    }
    catch (PackageManager.NameNotFoundException|NullPointerException paramString)
    {
      label31:
      break label31;
    }
    return null;
  }
  
  public static String getApplicationName()
  {
    if (sApplicationName == null) {}
    try
    {
      Object localObject = sApplicationContext.getPackageManager();
      sApplicationName = (String)((PackageManager)localObject).getApplicationLabel(((PackageManager)localObject).getApplicationInfo(sApplicationContext.getPackageName(), 0));
      label34:
      localObject = sApplicationName;
      if ((localObject == null) || (((String)localObject).isEmpty()) || (sApplicationName.matches("[a-z]+\\.[a-z0-9]+\\.[a-z0-9]+.*"))) {
        sApplicationName = "this application";
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Crosswalk application name: ");
      ((StringBuilder)localObject).append(sApplicationName);
      Log.d("XWalkEnvironment", ((StringBuilder)localObject).toString());
      return sApplicationName;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label34;
    }
  }
  
  public static int getAvailableVersion()
  {
    XWebCoreInfo localXWebCoreInfo = sXWebCoreInfo;
    if (localXWebCoreInfo == null) {
      return -1;
    }
    return localXWebCoreInfo.ver;
  }
  
  public static String getAvailableVersionDetail()
  {
    XWebCoreInfo localXWebCoreInfo = sXWebCoreInfo;
    if (localXWebCoreInfo != null) {
      return localXWebCoreInfo.verDetail;
    }
    return "";
  }
  
  public static int getChromiunVersion()
  {
    if (sNChromiuVersion < 0) {
      sNChromiuVersion = _getChromiunVersion();
    }
    return sNChromiuVersion;
  }
  
  public static String getClassDexFilePath(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getExtractedCoreDir(paramInt));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("classes.dex");
    return localStringBuilder.toString();
  }
  
  public static long getConfigFetchPeriod()
  {
    return sConfigPerios;
  }
  
  public static ContentResolver getContentResolver()
  {
    Context localContext = sApplicationContext;
    if (localContext == null)
    {
      Log.e("XWalkEnvironment", "getContentResolver sApplicationContext is null");
      return null;
    }
    return localContext.getContentResolver();
  }
  
  /* Error */
  public static String getDeviceAbi()
  {
    // Byte code:
    //   0: getstatic 652	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   3: ifnonnull +300 -> 303
    //   6: getstatic 657	android/os/Build$VERSION:SDK_INT	I
    //   9: bipush 21
    //   11: if_icmplt +90 -> 101
    //   14: getstatic 662	android/os/Build:SUPPORTED_ABIS	[Ljava/lang/String;
    //   17: iconst_0
    //   18: aaload
    //   19: invokevirtual 665	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   22: putstatic 652	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   25: goto +76 -> 101
    //   28: astore_0
    //   29: new 391	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   36: astore_1
    //   37: aload_1
    //   38: ldc_w 667
    //   41: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_1
    //   46: aload_0
    //   47: invokevirtual 668	java/lang/NoSuchFieldError:getMessage	()Ljava/lang/String;
    //   50: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: ldc 123
    //   56: aload_1
    //   57: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 357	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: goto +38 -> 101
    //   66: astore_0
    //   67: new 391	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   74: astore_1
    //   75: aload_1
    //   76: ldc_w 670
    //   79: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_1
    //   84: aload_0
    //   85: invokevirtual 401	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   88: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: ldc 123
    //   94: aload_1
    //   95: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 357	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: getstatic 652	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   104: ifnonnull +166 -> 270
    //   107: aconst_null
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_3
    //   111: new 672	java/io/InputStreamReader
    //   114: dup
    //   115: invokestatic 678	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   118: ldc_w 680
    //   121: invokevirtual 684	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   124: invokevirtual 690	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   127: invokespecial 693	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   130: astore_0
    //   131: new 695	java/io/BufferedReader
    //   134: dup
    //   135: aload_0
    //   136: invokespecial 698	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   139: astore_1
    //   140: aload_1
    //   141: invokevirtual 701	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   144: invokevirtual 665	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   147: putstatic 652	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   150: aload_0
    //   151: invokestatic 705	org/xwalk/core/XWalkEnvironment:tryClose	(Ljava/io/Closeable;)V
    //   154: aload_1
    //   155: invokestatic 705	org/xwalk/core/XWalkEnvironment:tryClose	(Ljava/io/Closeable;)V
    //   158: goto +112 -> 270
    //   161: astore 4
    //   163: aload_0
    //   164: astore_2
    //   165: aload_1
    //   166: astore_3
    //   167: aload 4
    //   169: astore_0
    //   170: aload_2
    //   171: astore_1
    //   172: aload_3
    //   173: astore_2
    //   174: goto +86 -> 260
    //   177: astore_2
    //   178: goto +30 -> 208
    //   181: astore_3
    //   182: aconst_null
    //   183: astore_2
    //   184: aload_0
    //   185: astore_1
    //   186: aload_3
    //   187: astore_0
    //   188: goto +72 -> 260
    //   191: astore_2
    //   192: aconst_null
    //   193: astore_1
    //   194: goto +14 -> 208
    //   197: astore_0
    //   198: aconst_null
    //   199: astore_2
    //   200: goto +60 -> 260
    //   203: astore_2
    //   204: aconst_null
    //   205: astore_1
    //   206: aload_3
    //   207: astore_0
    //   208: new 391	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   215: astore_3
    //   216: aload_3
    //   217: ldc_w 707
    //   220: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_3
    //   225: aload_2
    //   226: invokevirtual 401	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   229: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: ldc 123
    //   235: aload_3
    //   236: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 357	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: aload_0
    //   243: invokestatic 705	org/xwalk/core/XWalkEnvironment:tryClose	(Ljava/io/Closeable;)V
    //   246: aload_1
    //   247: invokestatic 705	org/xwalk/core/XWalkEnvironment:tryClose	(Ljava/io/Closeable;)V
    //   250: goto +20 -> 270
    //   253: astore_3
    //   254: aload_1
    //   255: astore_2
    //   256: aload_0
    //   257: astore_1
    //   258: aload_3
    //   259: astore_0
    //   260: aload_1
    //   261: invokestatic 705	org/xwalk/core/XWalkEnvironment:tryClose	(Ljava/io/Closeable;)V
    //   264: aload_2
    //   265: invokestatic 705	org/xwalk/core/XWalkEnvironment:tryClose	(Ljava/io/Closeable;)V
    //   268: aload_0
    //   269: athrow
    //   270: new 391	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   277: astore_0
    //   278: aload_0
    //   279: ldc_w 707
    //   282: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_0
    //   287: getstatic 652	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   290: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: ldc 123
    //   296: aload_0
    //   297: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 617	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: getstatic 652	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   306: astore_1
    //   307: aload_1
    //   308: astore_0
    //   309: aload_1
    //   310: ifnonnull +7 -> 317
    //   313: ldc_w 286
    //   316: astore_0
    //   317: aload_0
    //   318: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   28	19	0	localNoSuchFieldError	java.lang.NoSuchFieldError
    //   66	19	0	localException1	Exception
    //   130	58	0	localObject1	Object
    //   197	1	0	localObject2	Object
    //   207	111	0	localObject3	Object
    //   36	274	1	localObject4	Object
    //   164	10	2	localObject5	Object
    //   177	1	2	localException2	Exception
    //   183	1	2	localObject6	Object
    //   191	1	2	localException3	Exception
    //   199	1	2	localObject7	Object
    //   203	23	2	localException4	Exception
    //   255	10	2	localObject8	Object
    //   110	63	3	localObject9	Object
    //   181	26	3	localObject10	Object
    //   215	21	3	localStringBuilder	StringBuilder
    //   253	6	3	localObject11	Object
    //   161	7	4	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   6	25	28	java/lang/NoSuchFieldError
    //   6	25	66	java/lang/Exception
    //   140	150	161	finally
    //   140	150	177	java/lang/Exception
    //   131	140	181	finally
    //   131	140	191	java/lang/Exception
    //   111	131	197	finally
    //   111	131	203	java/lang/Exception
    //   208	242	253	finally
  }
  
  public static String getDeviceId()
  {
    if (sStrDeviceId == null) {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)getApplicationContext().getSystemService("phone");
        if (localTelephonyManager == null) {
          sStrDeviceId = "";
        } else {
          sStrDeviceId = PhoneInfoMonitor.getDeviceId(localTelephonyManager);
        }
      }
      catch (Exception localException)
      {
        sStrDeviceId = "";
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDeviceId failed ");
        localStringBuilder.append(localException.getMessage());
        Log.e("XWalkEnvironment", localStringBuilder.toString());
      }
    }
    return sStrDeviceId;
  }
  
  public static int getDeviceRd()
  {
    if (sNDeviceRd <= 0)
    {
      sNDeviceRd = getSharedPreferences().getInt("sNDeviceRd", -1);
      if (sNDeviceRd <= 0)
      {
        sNDeviceRd = new Random().nextInt(10000000) + 1;
        getSharedPreferences().edit().putInt("sNDeviceRd", sNDeviceRd).apply();
      }
    }
    return sNDeviceRd % 10000 + 1;
  }
  
  public static String getDownloadApkDir(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getVesionDir(paramInt));
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("apk");
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localObject;
  }
  
  public static String getDownloadApkPath(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getVesionDir(paramInt));
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("apk");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("base.apk");
    return ((StringBuilder)localObject2).toString();
  }
  
  public static String getDownloadApkPath(Context paramContext, int paramInt)
  {
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "getDownloadApkPath with context, context is null");
      return "";
    }
    paramContext = getVesionDir(paramContext, paramInt);
    if (paramContext.isEmpty())
    {
      Log.e("XWalkEnvironment", "getDownloadApkPath with context, versionDir is empty");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("apk");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("base.apk");
    return localStringBuilder.toString();
  }
  
  public static String getDownloadPatchPath(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getVesionDir(paramInt));
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("apk");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("patch.zip");
    return ((StringBuilder)localObject2).toString();
  }
  
  public static String getDownloadResFileListConfig(int paramInt)
  {
    return getExtractedCoreFile(paramInt, "reslist.config");
  }
  
  public static String getDownloadZipDir(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getVesionDir(paramInt));
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("zip");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("base.zip");
    return ((StringBuilder)localObject2).toString();
  }
  
  public static String getDownloadZipFileListConfig(int paramInt)
  {
    return getExtractedCoreFile(paramInt, "filelist.config");
  }
  
  public static String getDownloadZipFileListConfig(Context paramContext, int paramInt)
  {
    return getExtractedCoreFile(paramContext, paramInt, "filelist.config");
  }
  
  public static String getExtractedCoreDir(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getVesionDir(paramInt));
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("extracted_xwalkcore");
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localObject;
  }
  
  public static String getExtractedCoreFile(int paramInt, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getVesionDir(paramInt));
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("extracted_xwalkcore");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append(paramString);
    return ((StringBuilder)localObject2).toString();
  }
  
  public static String getExtractedCoreFile(Context paramContext, int paramInt, String paramString)
  {
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "getExtractedCoreFile with context, context is null");
      return "";
    }
    paramContext = getVesionDir(paramContext, paramInt);
    if (paramContext.isEmpty())
    {
      Log.e("XWalkEnvironment", "getExtractedCoreFile with context, versionDir is empty");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("extracted_xwalkcore");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static boolean getFeatureSupport(int paramInt)
  {
    return ((Boolean)l.a(WebView.c.b).excute("STR_CMD_FEATURE_SUPPORT", new Object[] { Integer.valueOf(paramInt) })).booleanValue();
  }
  
  public static int getForceDarkBehavior()
  {
    return sForceDarkBehavior;
  }
  
  public static boolean getForceDarkMode()
  {
    return sIsForceDarkMode;
  }
  
  public static int getGrayValue()
  {
    int i = s_grayValue;
    if (i != 0) {
      return i;
    }
    try
    {
      s_grayValue = getSharedPreferences().getInt("TEST_GRAY_VALUE", -1);
      if (s_grayValue <= 0) {
        s_grayValue = getSharedPreferences().getInt("GRAY_VALUE", -1);
      }
      if (s_grayValue <= 0) {
        s_grayValue = getDeviceRd();
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("match gray rate exception: ");
      localStringBuilder.append(localException.getMessage());
      Log.e("XWalkEnvironment", localStringBuilder.toString());
    }
    return s_grayValue;
  }
  
  public static int getInstalledNewstVersion(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    return XWebCoreInfo.getCurAbiInstalledNewestVersion(paramContext);
  }
  
  public static int getInstalledNewstVersion(String paramString)
  {
    return XWebCoreInfo.getBackupCoreInfo(paramString).ver;
  }
  
  public static int getInstalledNewstVersionForCurAbi()
  {
    return getInstalledNewstVersion(getRuntimeAbi());
  }
  
  public static int getInstalledNewstVersionForPredownAbi()
  {
    String str2 = getRuntimeAbi();
    String str1 = "armeabi-v7a";
    if ("armeabi-v7a".equalsIgnoreCase(str2)) {
      str1 = "arm64-v8a";
    }
    return getInstalledNewstVersion(str1);
  }
  
  public static int getInstalledPluginVersion(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "getInstalledPluginVersion, context is null");
      return -2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("xwalk_plugin_version_info_");
    localStringBuilder.append(paramString);
    paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 4);
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "getInstalledPluginVersion, sp is null");
      return -3;
    }
    return paramContext.getInt("availableVersion", -1);
  }
  
  public static int getIpType()
  {
    return getSharedPreferences().getInt("IP_TYPE", -2);
  }
  
  public static SharedPreferences getMMKVSharedPreferences(String paramString)
  {
    return getMMKVSharedPreferencesEx(paramString, 4, false);
  }
  
  public static SharedPreferences getMMKVSharedPreferencesEx(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = sSPProvider;
    if (localObject1 != null)
    {
      try
      {
        localObject1 = ((ISharedPreferenceProvider)localObject1).a(getApplicationContext(), paramString, paramInt, paramBoolean);
      }
      catch (Exception localException1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("got sp from mmkv callback failed ");
        localStringBuilder.append(localException1.getMessage());
        Log.e("XWalkEnvironment", localStringBuilder.toString());
        localObject2 = null;
      }
      if (localObject2 != null) {
        return localObject2;
      }
      com.tencent.xweb.util.h.a(176L, 1);
    }
    else
    {
      com.tencent.xweb.util.h.a(177L, 1);
    }
    initSafePsProvider();
    Object localObject2 = sMMKVMethod;
    if (localObject2 == null) {
      return sApplicationContext.getSharedPreferences(paramString, paramInt);
    }
    try
    {
      localObject2 = ((Method)localObject2).invoke(null, new Object[] { getApplicationContext(), paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      if ((localObject2 != null) && ((localObject2 instanceof SharedPreferences))) {
        return (SharedPreferences)localObject2;
      }
      Log.e("XWalkEnvironment", "get mmmkv from reflection failed");
    }
    catch (Exception localException2)
    {
      label169:
      break label169;
    }
    com.tencent.xweb.util.h.a(179L, 1);
    return sApplicationContext.getSharedPreferences(paramString, paramInt);
  }
  
  public static SharedPreferences getMMKVSharedTransportOld(String paramString)
  {
    return getMMKVSharedPreferencesEx(paramString, 4, true);
  }
  
  public static String getModuleName()
  {
    String str2 = getProcessName();
    if (str2 == null) {
      return "";
    }
    if (str2.contains(":")) {
      return str2.substring(str2.lastIndexOf(":") + 1).toLowerCase();
    }
    String str1 = str2;
    if (str2.contains(".")) {
      str1 = str2.substring(str2.lastIndexOf(".") + 1).toLowerCase();
    }
    return str1;
  }
  
  public static String getOptimizedDexDir(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getVesionDir(paramInt));
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("dex");
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localObject;
  }
  
  public static Context getPackageContext(String paramString)
  {
    Context localContext = sApplicationContext;
    if (localContext == null)
    {
      Log.e("XWalkEnvironment", "getTargetPackageContext sApplicationContext is null");
      return null;
    }
    try
    {
      paramString = localContext.createPackageContext(paramString, 2);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("XWalkEnvironment", paramString.getMessage());
    }
    return null;
  }
  
  public static String getPackageName()
  {
    Context localContext = sApplicationContext;
    if (localContext == null)
    {
      Log.e("XWalkEnvironment", "getPackageName sApplicationContext is null");
      return "";
    }
    return localContext.getPackageName();
  }
  
  public static String getPatchConfig(int paramInt)
  {
    return getPatchZipTempDecompressFilePath(paramInt, "patch.config");
  }
  
  public static String getPatchFileListConfig(int paramInt)
  {
    return getPatchZipTempDecompressFilePath(paramInt, "filelist.config");
  }
  
  public static String getPatchFileListConfig(Context paramContext, int paramInt)
  {
    return getPatchZipTempDecompressFilePath(paramContext, paramInt, "filelist.config");
  }
  
  public static String getPatchZipTempDecompressFilePath(int paramInt, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getVesionDir(paramInt));
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("patch_temp_decompress");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append(paramString);
    return ((StringBuilder)localObject2).toString();
  }
  
  public static String getPatchZipTempDecompressFilePath(Context paramContext, int paramInt, String paramString)
  {
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "getPatchZipTempDecompressFilePath with context, context is null");
      return "";
    }
    paramContext = getVesionDir(paramContext, paramInt);
    if (paramContext.isEmpty())
    {
      Log.e("XWalkEnvironment", "getPatchZipTempDecompressFilePath with context, versionDir is empty");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("patch_temp_decompress");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String getPatchZipTempDecompressPath(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getVesionDir(paramInt));
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("patch_temp_decompress");
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localObject;
  }
  
  public static String getPluginBaseDir()
  {
    Context localContext = sApplicationContext;
    if (localContext == null) {
      return "";
    }
    return localContext.getDir("xwalkplugin", 0).getAbsolutePath();
  }
  
  public static String getPluginConfigUrl()
  {
    Object localObject = getPluginTestConfigUrl();
    StringBuilder localStringBuilder;
    if (isValidConfigHost((String)localObject))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("plugin use test config url: ");
      localStringBuilder.append((String)localObject);
      addXWalkInitializeLog(localStringBuilder.toString());
      return localObject;
    }
    localObject = getTempPluginUpdateConfigUrl();
    if (isValidConfigHost((String)localObject))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("plugin use temp config url: ");
      localStringBuilder.append((String)localObject);
      addXWalkInitializeLog(localStringBuilder.toString());
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("plugin use release config url: ");
    ((StringBuilder)localObject).append("https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_public.xml");
    addXWalkInitializeLog(((StringBuilder)localObject).toString());
    return "https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_public.xml";
  }
  
  public static String getPluginTestConfigUrl()
  {
    Object localObject = getSharedPreferencesForTestXWeb();
    if (localObject == null)
    {
      Log.e("XWalkEnvironment", "hasPluginTestConfigUrl sp is null");
      return "";
    }
    localObject = ((SharedPreferences)localObject).getString("XWEB_PLUGIN_TEST_CONFIG_URL", "");
    if (localObject == null) {
      return "";
    }
    localObject = ((String)localObject).trim();
    if (((String)localObject).isEmpty()) {
      return "";
    }
    return localObject;
  }
  
  public static String getPluginUpdateConfigFilePath()
  {
    if (sApplicationContext == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getUpdateConfigDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("pluginUpdateConfig.xml");
    return localStringBuilder.toString();
  }
  
  public static int getPluginUpdatePeriod()
  {
    int i = getTempPluginUpdatePeriod();
    StringBuilder localStringBuilder;
    if (i > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPluginUpdatePeriod use tempPeriod = ");
      localStringBuilder.append(i);
      addXWalkInitializeLog(localStringBuilder.toString());
      return i;
    }
    i = b.o();
    if (i > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPluginUpdatePeriod use cmdPeriod = ");
      localStringBuilder.append(i);
      addXWalkInitializeLog(localStringBuilder.toString());
      return i;
    }
    addXWalkInitializeLog("getPluginUpdatePeriod use defaultPeriod = 90000000");
    return 90000000;
  }
  
  public static String getProcessName()
  {
    if (!TextUtils.isEmpty(sStrCurentProcessName)) {
      return sStrCurentProcessName;
    }
    Object localObject = getXWebInitArgs("processname");
    if (localObject != null)
    {
      sStrCurentProcessName = localObject.toString();
      return sStrCurentProcessName;
    }
    sStrCurentProcessName = f.a(getApplicationContext());
    return sStrCurentProcessName;
  }
  
  public static SharedPreferences getProcessSafePreferences(String paramString, int paramInt)
  {
    return sApplicationContext.getSharedPreferences(paramString, paramInt);
  }
  
  public static String getRuntimeAbi()
  {
    int i;
    StringBuilder localStringBuilder2;
    if (sRuntimeAbi == null)
    {
      int j = 0;
      try
      {
        String str1 = Build.CPU_ABI.toLowerCase();
        switch (str1.hashCode())
        {
        case 1431565292: 
          if (!str1.equals("arm64-v8a")) {
            break label776;
          }
          i = 2;
          break;
        case 145444210: 
          if (!str1.equals("armeabi-v7a")) {
            break label776;
          }
          i = 1;
          break;
        case 117110: 
          if (!str1.equals("x86")) {
            break label776;
          }
          i = 3;
          break;
        case -738963905: 
          if (!str1.equals("armeabi")) {
            break label776;
          }
          i = 0;
          break;
        case -806050265: 
          if (!str1.equals("x86_64")) {
            break label776;
          }
          i = 4;
          if ((i != 0) && (i != 1))
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i != 4) {
                  sRuntimeAbi = str1;
                } else {
                  sRuntimeAbi = "x86_64";
                }
              }
              else {
                sRuntimeAbi = "x86";
              }
            }
            else {
              sRuntimeAbi = "arm64-v8a";
            }
          }
          else {
            sRuntimeAbi = "armeabi-v7a";
          }
          break;
        }
      }
      catch (Exception localException1)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("get abi from cpu_abi failed , err = ");
        localStringBuilder2.append(localException1.getMessage());
        Log.e("XWalkEnvironment", localStringBuilder2.toString());
      }
      if (TextUtils.isEmpty(sRuntimeAbi))
      {
        try
        {
          str2 = System.getProperty("os.arch").toLowerCase();
          switch (str2.hashCode())
          {
          case 145444210: 
            if (!str2.equals("armeabi-v7a")) {
              break label781;
            }
            i = 8;
          }
        }
        catch (Exception localException2)
        {
          String str2;
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("get abi from os.arch failed , err = ");
          localStringBuilder2.append(localException2.getMessage());
          Log.e("XWalkEnvironment", localStringBuilder2.toString());
        }
        if (!str2.equals("armv8")) {
          break label781;
        }
        i = 10;
        break label783;
        if (!str2.equals("arm64")) {
          break label781;
        }
        i = 11;
        break label783;
        if (!str2.equals("ia32")) {
          break label781;
        }
        i = 3;
        break label783;
        if (!str2.equals("i686")) {
          break label781;
        }
        i = 1;
        break label783;
        if (!str2.equals("i386")) {
          break label781;
        }
        i = 2;
        break label783;
        if (!str2.equals("x86")) {
          break label781;
        }
        i = j;
        break label783;
        if (!str2.equals("x64")) {
          break label781;
        }
        i = 4;
        break label783;
        if (!str2.equals("armeabi")) {
          break label781;
        }
        i = 7;
        break label783;
        if (!str2.equals("x86_64")) {
          break label781;
        }
        i = 5;
        break label783;
        if (!str2.equals("aarch64")) {
          break label781;
        }
        i = 9;
        break label783;
        if (!str2.equals("armv7l")) {
          break label781;
        }
        i = 6;
        break label783;
      }
    }
    for (;;)
    {
      if (is64bitDevice())
      {
        sRuntimeAbi = "arm64-v8a";
      }
      else
      {
        sRuntimeAbi = "armeabi-v7a";
        break label690;
        sRuntimeAbi = "armeabi-v7a";
        break label690;
        if (is64bitDevice())
        {
          sRuntimeAbi = "x86_64";
        }
        else
        {
          sRuntimeAbi = "x86";
          break label690;
          sRuntimeAbi = "x86";
          break label690;
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("arch:");
          localStringBuilder2.append(str2);
          sRuntimeAbi = localStringBuilder2.toString();
        }
      }
      label690:
      if (sRuntimeAbi.equals("armeabi-v7a"))
      {
        if (isIaDevice()) {
          sRuntimeAbi = "x86";
        }
      }
      else if ((sRuntimeAbi.equals("arm64-v8a")) && (isIaDevice())) {
        sRuntimeAbi = "x86_64";
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Runtime ABI: ");
      localStringBuilder1.append(sRuntimeAbi);
      Log.i("XWalkEnvironment", localStringBuilder1.toString());
      return sRuntimeAbi;
      label776:
      i = -1;
      break;
      label781:
      i = -1;
      label783:
      switch (i)
      {
      }
    }
  }
  
  public static String getSafeModuleForCommand(String paramString)
  {
    try
    {
      String str = getModuleName();
      if ((!"tools".equalsIgnoreCase(str)) && (!"toolsmp".equalsIgnoreCase(str)) && (!"mm".equalsIgnoreCase(str)) && (!"support".equalsIgnoreCase(str)))
      {
        if (str.startsWith("appbrand"))
        {
          Log.i("XWalkEnvironment", "getSafeModuleForCommand appbrand");
          return "appbrand";
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSafeModuleForCommand unknown ");
        localStringBuilder.append(str);
        localStringBuilder.append(", use defaultVal ");
        localStringBuilder.append(paramString);
        Log.i("XWalkEnvironment", localStringBuilder.toString());
        return paramString;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSafeModuleForCommand ");
      localStringBuilder.append(str);
      Log.i("XWalkEnvironment", localStringBuilder.toString());
      return str;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSafeModuleForCommand error, use defaultVal ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", error info: ");
      Log.e("XWalkEnvironment", localStringBuilder.toString(), localException);
    }
    return paramString;
  }
  
  public static SharedPreferences getSharedPreferences()
  {
    return sApplicationContext.getSharedPreferences("libxwalkcore", 4);
  }
  
  public static SharedPreferences getSharedPreferencesForFileReaderRecord()
  {
    if (sApplicationContext == null) {
      return null;
    }
    return getProcessSafePreferences("xwalk_reader_record", 4);
  }
  
  public static SharedPreferences getSharedPreferencesForLog()
  {
    if (sApplicationContext == null) {
      return null;
    }
    return getMMKVSharedPreferencesEx("UPDATELOG", 4, true);
  }
  
  public static SharedPreferences getSharedPreferencesForPluginUpdateInfo()
  {
    if (sApplicationContext == null) {
      return null;
    }
    return getProcessSafePreferences("xwalk_plugin_update_info", 4);
  }
  
  public static SharedPreferences getSharedPreferencesForPluginVersionInfo(String paramString)
  {
    if (sApplicationContext == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("xwalk_plugin_version_info_");
    localStringBuilder.append(paramString);
    return getProcessSafePreferences(localStringBuilder.toString(), 4);
  }
  
  public static SharedPreferences getSharedPreferencesForTestXWeb()
  {
    Context localContext = sApplicationContext;
    if (localContext == null)
    {
      Log.e("XWalkEnvironment", "getSharedPreferencesForTestXWeb context is null");
      return null;
    }
    return localContext.getSharedPreferences("TESTXWEB", 4);
  }
  
  public static SharedPreferences getSharedPreferencesForUpdateConfig()
  {
    return getProcessSafePreferences("UPDATEINFOTAG", 4);
  }
  
  public static SharedPreferences getSharedPreferencesForVersionInfo()
  {
    return sApplicationContext.getSharedPreferences("XWALKINFOS", 4);
  }
  
  public static SharedPreferences getSharedPreferencesForXWEBUpdater()
  {
    return getMMKVSharedPreferencesEx("XWEB_UPDATER", 4, false);
  }
  
  public static String getTempPluginUpdateConfigUrl()
  {
    try
    {
      String str = sStrTempPluginUpdateConfigUrl;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int getTempPluginUpdatePeriod()
  {
    try
    {
      int i = sTempPluginUpdatePeriod;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String getTempUpdateConfigUrl()
  {
    try
    {
      String str = sStrTempUpdateConfigUrl;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String getTestDownLoadUrl(Context paramContext)
  {
    return getMMKVSharedTransportOld("TESTXWEB").getString("XWEB_TEST_CONFIG_URL", "");
  }
  
  public static int getTodayGrayValue()
  {
    Object localObject = new SimpleDateFormat("yyyyMMdd").format(new Date());
    if ((s_todayGrayValue != 0) && (((String)localObject).equals(s_todayDate))) {
      return s_todayGrayValue;
    }
    s_todayDate = (String)localObject;
    int i = getUserId();
    if (i == 0) {
      i = getGrayValue();
    }
    long l = i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(0xFFFFFFFF & l);
    localStringBuilder.append("@");
    localStringBuilder.append((String)localObject);
    localObject = localStringBuilder.toString();
    try
    {
      localObject = MessageDigest.getInstance("MD5").digest(((String)localObject).getBytes());
      if ((localObject != null) && (localObject.length > 3))
      {
        int j = localObject[3];
        int k = localObject[2];
        int m = localObject[1];
        j = (localObject[0] & 0x7F) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
        if (j == 0)
        {
          s_todayGrayValue = i;
          return i;
        }
        s_todayGrayValue = j % 10000 + 1;
        break label226;
      }
      s_todayGrayValue = i;
      return i;
    }
    catch (Exception localException)
    {
      label222:
      break label222;
    }
    s_todayGrayValue = i;
    label226:
    return s_todayGrayValue;
  }
  
  public static int getTodayGrayValueByKey(String paramString)
  {
    String str = new SimpleDateFormat("yyyyMMdd").format(new Date());
    int i = getUserId();
    if (i == 0) {
      i = getGrayValue();
    }
    long l = i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(0xFFFFFFFF & l);
    localStringBuilder.append("@");
    localStringBuilder.append(str);
    localStringBuilder.append("key=");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    try
    {
      paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
      if ((paramString != null) && (paramString.length > 3))
      {
        i = paramString[3];
        int j = paramString[2];
        int k = paramString[1];
        i = (paramString[0] & 0x7F) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
        if (i != 0) {
          break label196;
        }
        return s_todayGrayValue;
      }
      i = s_todayGrayValue;
      return i;
    }
    catch (Exception paramString)
    {
      label188:
      break label188;
    }
    return s_todayGrayValue;
    label196:
    return i % 10000 + 1;
  }
  
  public static String getUpdateConfigDir()
  {
    return sApplicationContext.getDir("xwalkconfig", 0).getAbsolutePath();
  }
  
  public static String getUpdateConfigFullPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getUpdateConfigDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("updateConfg.xml");
    return localStringBuilder.toString();
  }
  
  public static int getUserId()
  {
    return getMMKVSharedPreferences("XWEB_USER_INFO").getInt("USER_ID", 0);
  }
  
  public static int getUserType()
  {
    return getIpType();
  }
  
  public static boolean getUsingCustomContext()
  {
    return sUsingCustomContext;
  }
  
  static int getVerFromVersionName(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return 0;
      }
      localObject = paramString.split("\\.");
    }
    try
    {
      int i = Integer.parseInt(localObject[0]);
      return i;
    }
    catch (Exception localException)
    {
      label30:
      break label30;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parse to int error str is :");
    ((StringBuilder)localObject).append(paramString);
    Log.e("XWalkEnvironment", ((StringBuilder)localObject).toString());
    return 0;
  }
  
  public static String getVesionDir(int paramInt)
  {
    Object localObject1 = sApplicationContext;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("xwalk_");
    ((StringBuilder)localObject2).append(paramInt);
    localObject1 = ((Context)localObject1).getDir(((StringBuilder)localObject2).toString(), 0).getAbsolutePath();
    localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    return localObject1;
  }
  
  public static String getVesionDir(Context paramContext, int paramInt)
  {
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "getVersionDir with context, context is null");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("xwalk_");
    localStringBuilder.append(paramInt);
    return paramContext.getDir(localStringBuilder.toString(), 0).getAbsolutePath();
  }
  
  public static String getXWalkInitializeLog()
  {
    SharedPreferences localSharedPreferences = getSharedPreferencesForLog();
    if (localSharedPreferences == null) {
      return "";
    }
    return localSharedPreferences.getString("log", "");
  }
  
  public static String getXWalkUpdateConfigUrl()
  {
    sXWalkDownConfigUrl = getTestDownLoadUrl(getApplicationContext());
    if (isValidConfigHost(sXWalkDownConfigUrl))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("use test config url : ");
      localStringBuilder.append(sXWalkDownConfigUrl);
      addXWalkInitializeLog(localStringBuilder.toString());
    }
    else
    {
      sXWalkDownConfigUrl = getTempUpdateConfigUrl();
      if (isValidConfigHost(sXWalkDownConfigUrl))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("use temp config url : ");
        localStringBuilder.append(sXWalkDownConfigUrl);
        addXWalkInitializeLog(localStringBuilder.toString());
      }
      else if (isIaDevice())
      {
        sXWalkDownConfigUrl = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86.xml";
      }
      else
      {
        sXWalkDownConfigUrl = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_public.xml";
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("use update config url = ");
    localStringBuilder.append(sXWalkDownConfigUrl);
    Log.i("XWalkEnvironment", localStringBuilder.toString());
    return sXWalkDownConfigUrl;
  }
  
  public static Object getXWebInitArgs(String paramString)
  {
    try
    {
      if ((sXWebArgs != null) && (sXWebArgs.containsKey(paramString)))
      {
        paramString = sXWebArgs.get(paramString);
        return paramString;
      }
      return null;
    }
    finally {}
  }
  
  public static String getXWebInitArgs(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = getXWebInitArgs(paramString1);
      if ((paramString1 != null) && ((paramString1 instanceof String)))
      {
        paramString1 = (String)paramString1;
        return paramString1;
      }
      return paramString2;
    }
    finally {}
  }
  
  public static boolean getXWebInitArgs(String paramString, boolean paramBoolean)
  {
    boolean bool;
    label33:
    try
    {
      paramString = getXWebInitArgs(paramString);
      if (paramString == null) {
        return paramBoolean;
      }
    }
    finally {}
    try
    {
      bool = Boolean.valueOf(paramString.toString()).booleanValue();
      return bool;
    }
    catch (Exception paramString)
    {
      break label33;
    }
    Log.e("XWalkEnvironment", "getXWebInitArgs boolean parse failed");
    return paramBoolean;
  }
  
  public static boolean hasAvailableVersion()
  {
    return 49 <= getAvailableVersion();
  }
  
  public static boolean hasInstalledAvailableVersion()
  {
    return 49 <= getInstalledNewstVersionForCurAbi();
  }
  
  public static void init(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        if (sApplicationContext == null)
        {
          sApplicationContext = paramContext.getApplicationContext();
          String str1 = getRuntimeAbi();
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("current abi is ");
          ((StringBuilder)localObject).append(str1);
          Log.i("XWalkEnvironment", ((StringBuilder)localObject).toString());
          localObject = XWebCoreInfo.getBackupCoreInfo(str1);
          if (((XWebCoreInfo)localObject).ver <= 0)
          {
            if (!getSharedPreferencesForVersionInfo().getBoolean("transported_version", false))
            {
              int i = getSharedPreferencesForVersionInfo().getInt("availableVersion", -1);
              String str2 = getSharedPreferencesForVersionInfo().getString("versionDetail", "");
              ((XWebCoreInfo)localObject).strAbi = str1;
              ((XWebCoreInfo)localObject).ver = i;
              ((XWebCoreInfo)localObject).verDetail = str2;
            }
            if (XWebCoreInfo.setVersionForAbi((XWebCoreInfo)localObject)) {
              getSharedPreferencesForVersionInfo().edit().putBoolean("transported_version", true).commit();
            }
          }
          sXWebCoreInfo = (XWebCoreInfo)localObject;
          if (!sIsPluginInited) {
            sIsPluginInited = initXWalkPlugins();
          }
          v.a(paramContext);
          initTurnOnKVLog();
          return;
        }
      }
      finally {}
    }
  }
  
  static void initSafePsProvider()
  {
    if (sBHasInitedSafePsProvider) {
      return;
    }
    try
    {
      sMMKVMethod = Class.forName("com.tencent.mm.xwebutil.XWebMMkvWrapper").getMethod("getMMKV", new Class[] { Context.class, String.class, Integer.TYPE, Boolean.TYPE });
      label49:
      if (sMMKVMethod == null)
      {
        com.tencent.xweb.util.h.a(178L, 1);
        Log.e("XWalkEnvironment", "initSafePsProvider failed");
      }
      else
      {
        Log.i("XWalkEnvironment", "initSafePsProvider suscsess");
      }
      sBHasInitedSafePsProvider = true;
      return;
    }
    catch (Exception localException)
    {
      break label49;
    }
  }
  
  public static void initTurnOnKVLog()
  {
    try
    {
      isTurnOnKVLog = v.a().n();
      return;
    }
    catch (Exception localException)
    {
      label10:
      break label10;
    }
    Log.e("XWalkEnvironment", "init log failed");
  }
  
  private static boolean initXWalkPlugins()
  {
    return com.tencent.luggage.wxa.su.h.a();
  }
  
  public static boolean is64BitRuntime()
  {
    String str = getRuntimeAbi();
    return ("arm64-v8a".equalsIgnoreCase(str)) || ("x86_64".equalsIgnoreCase(str)) || ("mips64".equalsIgnoreCase(str));
  }
  
  public static boolean is64bitApp()
  {
    String str = getRuntimeAbi();
    return (str.equals("arm64-v8a")) || (str.equals("x86_64"));
  }
  
  public static boolean is64bitDevice()
  {
    String str = getDeviceAbi();
    return (str.equals("arm64-v8a")) || (str.equals("x86_64"));
  }
  
  public static boolean isCurrentVersionSupportCustomContext()
  {
    return (hasAvailableVersion()) && (getFeatureSupport(1020));
  }
  
  public static boolean isCurrentVersionSupportCustomTextAreaForAppbrand()
  {
    return (hasAvailableVersion()) && (getFeatureSupport(1012));
  }
  
  public static boolean isCurrentVersionSupportExtendPluginForAppbrand()
  {
    return (hasAvailableVersion()) && (getAvailableVersion() >= 300);
  }
  
  public static boolean isCurrentVersionSupportForceDarkMode()
  {
    return (hasAvailableVersion()) && (getFeatureSupport(1021));
  }
  
  public static boolean isCurrentVersionSupportMapExtendPluginForAppbrand()
  {
    return (hasAvailableVersion()) && (getFeatureSupport(1011));
  }
  
  public static boolean isCurrentVersionSupportNativeView()
  {
    return (hasAvailableVersion()) && (getFeatureSupport(1013));
  }
  
  public static boolean isCurrentVersionSupportScreenshotForSameLayer()
  {
    return (hasAvailableVersion()) && (getFeatureSupport(2010));
  }
  
  public static boolean isDownloadMode()
  {
    return sIsDownloadMode.booleanValue();
  }
  
  public static boolean isDownloadModeUpdate()
  {
    return sIsDownloadModeUpdate.booleanValue();
  }
  
  public static boolean isForbidDownloadCode()
  {
    return ae.b();
  }
  
  public static boolean isIaDevice()
  {
    String str = getDeviceAbi();
    return (str.equals("x86")) || (str.equals("x86_64"));
  }
  
  public static boolean isInTestMode()
  {
    String str = getTestDownLoadUrl(getApplicationContext());
    return (str != null) && (!str.isEmpty());
  }
  
  public static boolean isProvider(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      String[] arrayOfString = XWALK_CORE_PROVIDER_LIST;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    Log.e("XWalkEnvironment", "isProvider packageName is null or empty");
    return false;
  }
  
  public static boolean isSelfProvider()
  {
    Context localContext = sApplicationContext;
    if (localContext == null)
    {
      Log.e("XWalkEnvironment", "isSelfProvider sApplicationContext is null");
      return true;
    }
    return isProvider(localContext.getPackageName());
  }
  
  public static boolean isTestVersion(int paramInt)
  {
    return paramInt >= 100000000;
  }
  
  public static boolean isValidConfigHost(String paramString)
  {
    if ((paramString != null) && (!TextUtils.isEmpty(paramString))) {
      if (TextUtils.isEmpty(paramString.trim())) {
        return false;
      }
    }
    try
    {
      paramString = new URI(paramString.trim());
      if (!paramString.getScheme().equals("https")) {
        return false;
      }
      boolean bool = paramString.getHost().equals("dldir1.qq.com");
      return bool;
    }
    catch (Exception paramString)
    {
      label69:
      break label69;
    }
    Log.e("XWalkEnvironment", "java.net.URI new crashed ");
    return false;
  }
  
  public static int readAvailableVersionFromSP(Context paramContext)
  {
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "readAvailableVersionFromSP context is null");
      return -1;
    }
    return XWebCoreInfo.getCurAbiInstalledNewestVersion(paramContext);
  }
  
  public static void refreshAvailableVersion()
  {
    sXWebCoreInfo = XWebCoreInfo.getBackupCoreInfo(getRuntimeAbi());
    if (sXWebCoreInfo.ver != -1) {
      getSharedPreferences().edit().putString("XWALK_CORE_EXTRACTED_DIR", getExtractedCoreDir(sXWebCoreInfo.ver)).commit();
    }
  }
  
  public static void refreshVerInfo()
  {
    sXWebCoreInfo = XWebCoreInfo.getBackupCoreInfo(getRuntimeAbi());
  }
  
  public static void resetForDebug()
  {
    sApplicationContext = null;
    sXWebCoreInfo = null;
    sIsPluginInited = false;
  }
  
  static boolean runnintOnUiThread()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public static int safeGetChromiunVersion()
  {
    if (sNChromiuVersion < 0) {}
    try
    {
      PackageInfo localPackageInfo = getApplicationContext().getPackageManager().getPackageInfo("com.google.android.webview", 0);
      if (localPackageInfo == null) {
        break label50;
      }
      int i = getVerFromVersionName(localPackageInfo.versionName);
      if (i <= 0) {
        break label50;
      }
      sNChromiuVersion = i;
      return i;
    }
    catch (Exception localException)
    {
      label42:
      label50:
      break label42;
    }
    Log.e("XWalkEnvironment", "Android System WebView is not found");
    return sNChromiuVersion;
  }
  
  public static void setAppClientVersion(int paramInt)
  {
    try
    {
      sAppClientVersion = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean setAvailableVersion(int paramInt, String paramString1, String paramString2)
  {
    return XWebCoreInfo.setVersionForAbi(paramInt, paramString1, paramString2);
  }
  
  public static void setConfigFetchPeriod(long paramLong)
  {
    sConfigPerios = paramLong;
  }
  
  public static void setForceDarkBehavior(XWalkEnvironment.ForceDarkBehavior paramForceDarkBehavior)
  {
    int i = XWalkEnvironment.1.$SwitchMap$org$xwalk$core$XWalkEnvironment$ForceDarkBehavior[paramForceDarkBehavior.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          sForceDarkBehavior = 2;
        }
      }
      else {
        sForceDarkBehavior = 1;
      }
    }
    else {
      sForceDarkBehavior = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setForceDarkMode forceDarkBehavior:");
    localStringBuilder.append(paramForceDarkBehavior);
    Log.i("XWalkEnvironment", localStringBuilder.toString());
    l.a(WebView.c.b).excute("STR_CMD_FORCE_DARK_MODE_BEHAVIOR_COMMAND", new Object[] { Integer.valueOf(sForceDarkBehavior) });
  }
  
  public static void setForceDarkMode(boolean paramBoolean)
  {
    sIsForceDarkMode = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setForceDarkMode forceDarkMode:");
    localStringBuilder.append(paramBoolean);
    Log.i("XWalkEnvironment", localStringBuilder.toString());
    l.a(WebView.c.b).excute("STR_CMD_FORCE_DARK_MODE_COMMAND", new Object[] { Boolean.valueOf(sIsForceDarkMode) });
  }
  
  public static void setGrayValueByUserId(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    setUserId(paramInt);
    long l = paramInt;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("xweb_gray_value");
    ((StringBuilder)localObject).append(0xFFFFFFFF & l);
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      localObject = MessageDigest.getInstance("MD5").digest(((String)localObject).getBytes());
      if (localObject == null) {
        break label90;
      }
      if (localObject.length > 3) {
        break label197;
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        break label91;
        paramInt = localException[3];
        int i = localException[2];
        int j = localException[1];
        paramInt = (localException[0] & 0x7F) << 24 | paramInt & 0xFF | (i & 0xFF) << 8 | (j & 0xFF) << 16;
      } while (paramInt != 0);
    }
    s_grayValue = paramInt % 10000 + 1;
    break label95;
    label90:
    return;
    label91:
    s_grayValue = 0;
    label95:
    paramInt = getSharedPreferences().getInt("GRAY_VALUE", -1);
    getSharedPreferences().edit().putInt("GRAY_VALUE", s_grayValue).commit();
    if (paramInt != s_grayValue)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gray value changed to ");
      ((StringBuilder)localObject).append(s_grayValue);
      Log.i("XWalkEnvironment", ((StringBuilder)localObject).toString());
      l.a(WebView.c.b).excute("STR_CMD_SET_RECHECK_COMMAND", null);
    }
    return;
    label197:
  }
  
  public static void setGrayValueForTest(int paramInt)
  {
    if (paramInt != 10001) {
      s_grayValue = paramInt % 10000;
    }
    getSharedPreferences().edit().putInt("TEST_GRAY_VALUE", s_grayValue).commit();
  }
  
  public static void setIpType(int paramInt)
  {
    int i = getIpType();
    if (paramInt != i)
    {
      getSharedPreferences().edit().putInt("IP_TYPE", paramInt).commit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" to  ");
      localStringBuilder.append(paramInt);
      addXWalkInitializeLog("setIpType", localStringBuilder.toString());
      if ((i == 0) && (paramInt == 1)) {
        com.tencent.xweb.util.h.a(197L, 1);
      } else if ((i == 1) && (paramInt == 0)) {
        com.tencent.xweb.util.h.a(198L, 1);
      }
      if ((i > 0) || (paramInt > 0))
      {
        sBIsIpTypeChanged = true;
        l.a(WebView.c.b).excute("STR_CMD_SET_RECHECK_COMMAND", null);
      }
    }
  }
  
  public static void setIsForbidDownloadCode(boolean paramBoolean)
  {
    ae.a(paramBoolean);
  }
  
  public static boolean setPluginTestConfigUrl(String paramString)
  {
    Object localObject = getSharedPreferencesForTestXWeb();
    if (localObject == null)
    {
      Log.e("XWalkEnvironment", "setPluginTestConfigUrl sp is null");
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if ((paramString != null) && (!paramString.trim().isEmpty())) {
      ((SharedPreferences.Editor)localObject).putString("XWEB_PLUGIN_TEST_CONFIG_URL", paramString.trim());
    } else {
      ((SharedPreferences.Editor)localObject).remove("XWEB_PLUGIN_TEST_CONFIG_URL");
    }
    return ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static void setSharedPreferenceProvider(ISharedPreferenceProvider paramISharedPreferenceProvider)
  {
    if (paramISharedPreferenceProvider != null) {}
    try
    {
      sSPProvider = paramISharedPreferenceProvider;
    }
    finally {}
  }
  
  public static void setTempPluginUpdateConfigUrl(String paramString)
  {
    try
    {
      sStrTempPluginUpdateConfigUrl = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean setTempPluginUpdateConfigUrl(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat;
    label54:
    try
    {
      if (!TextUtils.isEmpty(paramString2)) {
        localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
      }
    }
    finally {}
    try
    {
      paramString2 = localSimpleDateFormat.parse(paramString2);
      if (!new Date().after(paramString2)) {
        break label67;
      }
      Log.i("XWalkEnvironment", "today is after enddate set tempConfig failed ");
      return false;
    }
    catch (Exception paramString1)
    {
      break label54;
    }
    Log.e("XWalkEnvironment", "parse strEndDate failed , set url failed  ");
    return false;
    label67:
    sStrTempPluginUpdateConfigUrl = paramString1;
    return true;
  }
  
  public static void setTempPluginUpdatePeriod(int paramInt)
  {
    try
    {
      sTempPluginUpdatePeriod = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setTempUpdateConfigUrl(String paramString)
  {
    try
    {
      sStrTempUpdateConfigUrl = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean setTempUpdateConfigUrl(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat;
    label54:
    try
    {
      if (!TextUtils.isEmpty(paramString2)) {
        localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
      }
    }
    finally {}
    try
    {
      paramString2 = localSimpleDateFormat.parse(paramString2);
      if (!new Date().after(paramString2)) {
        break label67;
      }
      Log.i("XWalkEnvironment", "today is after enddate set tempConfig failed ");
      return false;
    }
    catch (Exception paramString1)
    {
      break label54;
    }
    Log.e("XWalkEnvironment", "parse strEndDate failed , set url failed  ");
    return false;
    label67:
    sStrTempUpdateConfigUrl = paramString1;
    return true;
  }
  
  public static void setTestDownLoadUrl(Context paramContext, String paramString)
  {
    sXWalkDownConfigUrl = null;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      getMMKVSharedTransportOld("TESTXWEB").edit().putString("XWEB_TEST_CONFIG_URL", paramString).commit();
      getXWalkUpdateConfigUrl();
      return;
    }
    getMMKVSharedTransportOld("TESTXWEB").edit().putString("XWEB_TEST_CONFIG_URL", "").commit();
    getXWalkUpdateConfigUrl();
  }
  
  public static void setTodayGrayValueForTest(int paramInt)
  {
    s_todayGrayValue = paramInt;
    s_todayDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
  }
  
  public static void setUserId(int paramInt)
  {
    getMMKVSharedPreferences("XWEB_USER_INFO").edit().putInt("USER_ID", paramInt).commit();
  }
  
  public static void setUsingCustomContext(boolean paramBoolean)
  {
    sUsingCustomContext = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setUsingCustomContext usingCustomContext:");
    localStringBuilder.append(paramBoolean);
    Log.i("XWalkEnvironment", localStringBuilder.toString());
  }
  
  public static void setXWebInitArgs(HashMap paramHashMap)
  {
    try
    {
      sXWebArgs = paramHashMap;
      return;
    }
    finally
    {
      paramHashMap = finally;
      throw paramHashMap;
    }
  }
  
  static void tryClose(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (Exception paramCloseable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("closeable close  failed ");
        localStringBuilder.append(paramCloseable.getMessage());
        Log.e("XWalkEnvironment", localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkEnvironment
 * JD-Core Version:    0.7.0.1
 */