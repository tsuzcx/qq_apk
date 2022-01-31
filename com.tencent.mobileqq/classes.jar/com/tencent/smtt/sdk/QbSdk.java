package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebViewDatabase;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.sdk.ui.dialog.TBSActivityPicker;
import com.tencent.smtt.sdk.ui.dialog.TBSResources;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.ReflectionUtils;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"NewApi"})
public class QbSdk
{
  private static final int CAN_LOAD_X5_FALSE = -1;
  protected static final int ERRORCODE_MINIQBREADER_CONTEXTISNULL = -100;
  protected static final int ERRORCODE_MINIQBREADER_ISOVERSEA = -103;
  protected static final int ERRORCODE_MINIQBREADER_REFLECTFAILED = -104;
  protected static final int ERRORCODE_MINIQBREADER_REFUSE = -101;
  protected static final int ERRORCODE_MINIQBREADER_X5COREINITFAILED = -102;
  private static final String EXTENSION_DEX_FILE = "tbs_sdk_extension_dex.jar";
  private static final String EXTENSION_IMPL_CLASS = "com.tencent.tbs.sdk.extension.TbsSDKExtension";
  public static final int EXTENSION_INIT_FAILURE = -99999;
  public static final String FILERADER_MENUDATA = "menuData";
  private static final int IS_X5ENABLE_DEFAULT = 0;
  private static final int IS_X5ENABLE_FALSE = -2;
  private static final String KEY_RESULT_CODE = "result_code";
  public static String KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
  private static final String KEY_TBS_CORE_VERSION = "tbs_core_version";
  private static final String KEY_TBS_JARFILES = "tbs_jarfiles";
  private static final String KEY_TBS_LIBRARYPATH = "tbs_librarypath";
  public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
  public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
  private static final String MIDPAGEEXTURL = "mttbrowser://miniqb/ch=icon?";
  private static final String MINIQB_HOME_PAGE = "miniqb://home";
  private static final String MINIQB_HOME_PAGE_JUMPQB_URL = "qb://navicard/addCard?cardId=168&cardName=168";
  private static final int MSG_CORE_INITED = 3;
  private static final int MSG_INIT_SYSCORE = 2;
  private static final int MSG_INIT_X5CORE = 1;
  public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
  public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
  public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
  private static final int PRELOAD_X5_COUNTER_MAX = 3;
  public static final int QBMODE = 2;
  public static final String SVNVERSION = "jnizz";
  private static final String TAG = "QbSdk";
  public static final int TBSMODE = 1;
  private static final String TBS_CFG_FILE = "tbs_extension.conf";
  private static final String TBS_FUSION_DEX_FILE_NAME = "tbs_jars_fusion_dex.jar";
  static final int TBS_OLD_CORE_VERSION = 25442;
  static final String TBS_PRELOAD_X5_COUNTER = "tbs_preload_x5_counter";
  static final String TBS_PRELOAD_X5_RECORDER = "tbs_preload_x5_recorder";
  static final String TBS_PRELOAD_X5_VERSION = "tbs_preload_x5_version";
  public static final String TID_QQNumber_Prefix = "QQ:";
  public static final int VERSION = 1;
  private static int X5_ENABLE_BOUNDS;
  public static boolean isDefaultDialog;
  private static boolean isPreloadX5Checking;
  private static boolean mDownloadWithoutWifi;
  static boolean mIsBuglyEnabled;
  private static boolean mIsPreInitialized;
  static boolean mIsSysWebViewForced;
  static boolean mIsSysWebViewForcedByOuter;
  static boolean mNeedCreateX5webviewAfterInit;
  static boolean mOnlyDownload;
  private static String mQQBuildNumber;
  static Map<String, Object> mSettings = null;
  private static String mSysWebViewForcedByOuterInfo;
  private static String mSysWebViewForcedInnerInfo;
  private static boolean mTBSInstalling;
  private static String mTID;
  private static TbsListener mTbsListener;
  private static TbsListener mTbsListenerForInit;
  static TbsListener mTbsListenerWrapper;
  static volatile boolean mTmpIsSysWebViewForced;
  static boolean sAllowThirdPartyAppDownload;
  static Object sApnLock;
  static long sApnRecordTime;
  private static Class<?> sExtensionClass;
  private static Object sExtensionObj;
  static boolean sIsApnWifi;
  public static boolean sIsVersionPrinted = false;
  private static String[] sJarFiles;
  static String sLibraryPath;
  private static int sTbsVersion = 0;
  private static String sTbsVersionString = "";
  private static int sTotalRAM;
  static long sWifiConnectedTime;
  
  static
  {
    mIsSysWebViewForced = false;
    mIsSysWebViewForcedByOuter = false;
    sAllowThirdPartyAppDownload = true;
    mIsPreInitialized = false;
    mSysWebViewForcedByOuterInfo = "NULL";
    mSysWebViewForcedInnerInfo = "UNKNOWN";
    sIsApnWifi = false;
    sApnRecordTime = 0L;
    sWifiConnectedTime = 0L;
    sApnLock = new Object();
    isDefaultDialog = false;
    mIsBuglyEnabled = true;
    mNeedCreateX5webviewAfterInit = true;
    mOnlyDownload = false;
    sTotalRAM = 0;
    X5_ENABLE_BOUNDS = 170;
    mTID = null;
    mQQBuildNumber = null;
    mTmpIsSysWebViewForced = mIsSysWebViewForced;
    isPreloadX5Checking = true;
    mTbsListener = null;
    mTbsListenerForInit = null;
    mDownloadWithoutWifi = false;
    mTBSInstalling = false;
    mTbsListenerWrapper = new TbsListener()
    {
      public void onDownloadFinish(int paramAnonymousInt)
      {
        if (TbsDownloader.needDownloadDecoupleCore())
        {
          TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
          TbsDownloader.mIsDownloading = true;
        }
        do
        {
          return;
          TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
          TbsDownloader.mIsDownloading = false;
          if ((paramAnonymousInt != 100) || (QbSdk.mTbsListener != null)) {
            QbSdk.mTbsListener.onDownloadFinish(paramAnonymousInt);
          }
        } while (QbSdk.mTbsListenerForInit == null);
        QbSdk.mTbsListenerForInit.onDownloadFinish(paramAnonymousInt);
      }
      
      public void onDownloadProgress(int paramAnonymousInt)
      {
        if (QbSdk.mTbsListenerForInit != null) {
          QbSdk.mTbsListenerForInit.onDownloadProgress(paramAnonymousInt);
        }
        if (QbSdk.mTbsListener != null) {
          QbSdk.mTbsListener.onDownloadProgress(paramAnonymousInt);
        }
      }
      
      public void onInstallFinish(int paramAnonymousInt)
      {
        if ((paramAnonymousInt != 200) && (paramAnonymousInt == 220)) {}
        QbSdk.setTBSInstallingStatus(false);
        TbsDownloader.mIsDownloading = false;
        if (TbsDownloader.startDecoupleCoreIfNeeded()) {}
        for (TbsDownloader.mIsDownloading = true;; TbsDownloader.mIsDownloading = false)
        {
          if (QbSdk.mTbsListener != null) {
            QbSdk.mTbsListener.onInstallFinish(paramAnonymousInt);
          }
          if (QbSdk.mTbsListenerForInit != null) {
            QbSdk.mTbsListenerForInit.onInstallFinish(paramAnonymousInt);
          }
          return;
        }
      }
    };
  }
  
  public static boolean canLoadVideo(Context paramContext)
  {
    Object localObject = ReflectionUtils.invokeInstance(sExtensionObj, "canLoadVideo", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) });
    if (localObject != null) {
      if (!((Boolean)localObject).booleanValue()) {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 313);
      }
    }
    while (localObject == null)
    {
      return false;
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 314);
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public static boolean canLoadX5(Context paramContext)
  {
    return canLoadX5(paramContext, false, false);
  }
  
  static boolean canLoadX5(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 1;
    paramBoolean2 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    if ((TbsShareManager.isThirdPartyApp(paramContext)) && (!TbsShareManager.isShareTbsCoreAvailableInner(paramContext)))
    {
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 302);
      paramBoolean1 = bool2;
    }
    for (;;)
    {
      label38:
      return paramBoolean1;
      if (!init(paramContext, paramBoolean1))
      {
        TbsLog.e("QbSdk", "QbSdk.init failure!");
        return false;
      }
      Object localObject3 = ReflectionUtils.invokeInstance(sExtensionObj, "canLoadX5Core", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(43609) });
      int i;
      if (localObject3 != null)
      {
        if ((localObject3 instanceof String))
        {
          paramBoolean1 = bool2;
          if (((String)localObject3).equalsIgnoreCase("AuthenticationFail")) {
            continue;
          }
        }
        if (!(localObject3 instanceof Bundle))
        {
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 330, new Throwable("" + localObject3));
          TbsLog.e("loaderror", "ret not instance of bundle");
          return false;
        }
        Bundle localBundle = (Bundle)localObject3;
        if (localBundle.isEmpty())
        {
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 331, new Throwable("" + localObject3));
          TbsLog.e("loaderror", "empty bundle");
          return false;
        }
        try
        {
          i = localBundle.getInt("result_code", -1);
          if (i == 0)
          {
            paramBoolean1 = true;
            if (!TbsShareManager.isThirdPartyApp(paramContext)) {
              break label432;
            }
            SDKEngine.setTbsCoreVersion(TbsShareManager.getAvailableTbsCoreVersion(paramContext));
            sTbsVersionString = String.valueOf(TbsShareManager.getAvailableTbsCoreVersion(paramContext));
            if (sTbsVersionString.length() == 5) {
              sTbsVersionString = "0" + sTbsVersionString;
            }
            if (sTbsVersionString.length() != 6) {
              sTbsVersionString = "";
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            try
            {
              sJarFiles = localBundle.getStringArray("tbs_jarfiles");
              if ((sJarFiles instanceof String[])) {
                break label679;
              }
              TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 307, new Throwable("sJarFiles not instanceof String[]: " + sJarFiles));
              return false;
            }
            catch (Throwable localThrowable)
            {
              label432:
              TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 329, localThrowable);
              return false;
            }
            localException2 = localException2;
            TbsLog.e("QbSdk", "bundle.getInt(KEY_RESULT_CODE) error : " + localException2.toString());
            i = -1;
            continue;
            paramBoolean1 = false;
            continue;
            try
            {
              if (Build.VERSION.SDK_INT >= 12) {
                sTbsVersionString = localBundle.getString("tbs_core_version", "0");
              }
            }
            catch (Exception localException3)
            {
              try
              {
                sTbsVersion = Integer.parseInt(sTbsVersionString);
                SDKEngine.setTbsCoreVersion(sTbsVersion);
                if (sTbsVersion == 0)
                {
                  TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 307, new Throwable("sTbsVersion is 0"));
                  return false;
                  sTbsVersionString = localBundle.getString("tbs_core_version");
                  if (sTbsVersionString != null) {
                    continue;
                  }
                  sTbsVersionString = "0";
                  continue;
                  localException3 = localException3;
                  sTbsVersionString = "0";
                }
              }
              catch (NumberFormatException localNumberFormatException)
              {
                sTbsVersion = 0;
                continue;
                int j;
                if (sTbsVersion > 0)
                {
                  j = k;
                  if (sTbsVersion <= 25442) {}
                }
                else
                {
                  if (sTbsVersion != 25472) {
                    continue;
                  }
                  j = k;
                }
                if (j != 0)
                {
                  TbsLog.e("TbsDownload", "is_obsolete --> delete old core:" + sTbsVersion);
                  FileUtil.delete(TbsInstaller.getInstance().getTbsCoreShareDir(paramContext));
                  TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 307, new Throwable("is_obsolete --> delete old core:" + sTbsVersion));
                  return false;
                  j = 0;
                }
              }
            }
          }
        }
      }
      try
      {
        label679:
        sLibraryPath = localThrowable.getString("tbs_librarypath");
        Class localClass = null;
        Object localObject1 = localClass;
        if (i != 0) {}
        for (;;)
        {
          try
          {
            localObject1 = ReflectionUtils.invokeInstance(sExtensionObj, "getErrorCodeForLogReport", new Class[0], new Object[0]);
            switch (i)
            {
            default: 
              TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 415, new Throwable("detail: " + localObject1 + "errcode" + i));
            case 0: 
              paramBoolean2 = paramBoolean1;
              paramBoolean1 = paramBoolean2;
              if (paramBoolean2) {
                break label38;
              }
              TbsLog.e("loaderror", "319");
              return paramBoolean2;
            }
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            localObject2 = localClass;
            continue;
            if ((localObject2 instanceof Integer))
            {
              TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, ((Integer)localObject2).intValue(), new Throwable("detail: " + localObject2));
              continue;
            }
            TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 307, new Throwable("detail: " + localObject2));
            continue;
            if ((localObject2 instanceof Integer))
            {
              TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, ((Integer)localObject2).intValue(), new Throwable("detail: " + localObject2));
              continue;
            }
            TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 404, new Throwable("detail: " + localObject2));
            continue;
          }
          Object localObject2 = sExtensionObj;
          localClass = Integer.TYPE;
          i = DeviceInfo.getTotalRAM();
          localObject2 = ReflectionUtils.invokeInstance(localObject2, "canLoadX5", new Class[] { localClass }, new Object[] { Integer.valueOf(i) });
          if (localObject2 != null)
          {
            if ((localObject2 instanceof String))
            {
              paramBoolean1 = bool2;
              if (((String)localObject2).equalsIgnoreCase("AuthenticationFail")) {
                break;
              }
            }
            if (!(localObject2 instanceof Boolean)) {
              continue;
            }
            sTbsVersion = SDKEngine.getTbsCoreVersion();
            bool2 = isX5Disabled(paramContext, SDKEngine.getTbsCoreVersion());
            paramBoolean2 = bool1;
            if (((Boolean)localObject2).booleanValue())
            {
              paramBoolean2 = bool1;
              if (!bool2) {
                paramBoolean2 = true;
              }
            }
            paramBoolean1 = paramBoolean2;
            if (paramBoolean2) {
              break;
            }
            TbsLog.e("loaderror", "318");
            TbsLog.w("loaderror", "isX5Disable:" + bool2);
            TbsLog.w("loaderror", "(Boolean) ret:" + (Boolean)localObject2);
            return paramBoolean2;
          }
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 308);
        }
        return false;
      }
      catch (Exception paramContext) {}
    }
  }
  
  public static boolean canLoadX5FirstTimeThirdApp(Context paramContext)
  {
    try
    {
      if ((paramContext.getApplicationInfo().packageName.contains("com.moji.mjweather")) && (Build.VERSION.SDK_INT == 19)) {
        return true;
      }
      if (sExtensionClass == null)
      {
        Object localObject = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
        if (localObject == null)
        {
          TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
          return false;
        }
        File localFile = new File(TbsShareManager.getAvailableTbsCorePath(paramContext), "tbs_sdk_extension_dex.jar");
        if (!localFile.exists())
        {
          TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
          return false;
        }
        if (TbsShareManager.getHostCorePathAppDefined() != null) {}
        for (localObject = TbsShareManager.getHostCorePathAppDefined();; localObject = ((File)localObject).getAbsolutePath())
        {
          TbsLog.i("QbSdk", "QbSdk init optDirExtension #2 is " + (String)localObject);
          TbsLog.i("QbSdk", "new DexLoader #2 dexFile is " + localFile.getAbsolutePath());
          sExtensionClass = new DexLoader(localFile.getParent(), paramContext, new String[] { localFile.getAbsolutePath() }, (String)localObject, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
          if (sExtensionObj != null) {
            break label235;
          }
          if ((TbsShareManager.getAvailableTbsCoreHostContext(paramContext) != null) || (TbsShareManager.getHostCorePathAppDefined() != null)) {
            break;
          }
          TbsLogReport.getInstance(paramContext.getApplicationContext()).setLoadErrorCode(227, "host context is null!");
          return false;
        }
        loadTBSSDKExtension(paramContext, localFile.getParent());
      }
      label235:
      paramContext = ReflectionUtils.invokeInstance(sExtensionObj, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
      if ((paramContext != null) && ((paramContext instanceof Boolean)))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(paramContext));
    }
    return false;
  }
  
  public static void canOpenFile(Context paramContext, final String paramString, final ValueCallback<Boolean> paramValueCallback)
  {
    new Thread()
    {
      public void run()
      {
        X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
        localX5CoreEngine.init(this.val$context, null);
        final boolean bool = false;
        if (localX5CoreEngine.isX5Core()) {
          bool = localX5CoreEngine.wizard().canOpenFile(this.val$context, paramString);
        }
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            QbSdk.1.this.val$callback.onReceiveValue(Boolean.valueOf(bool));
          }
        });
      }
    }.start();
  }
  
  public static boolean canOpenMimeFileType(Context paramContext, String paramString)
  {
    if (!init(paramContext, false)) {}
    return false;
  }
  
  /* Error */
  public static boolean canOpenWebPlus(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_1
    //   4: istore 4
    //   6: getstatic 223	com/tencent/smtt/sdk/QbSdk:sTotalRAM	I
    //   9: ifne +9 -> 18
    //   12: invokestatic 460	com/tencent/smtt/sdk/DeviceInfo:getTotalRAM	()I
    //   15: putstatic 223	com/tencent/smtt/sdk/QbSdk:sTotalRAM	I
    //   18: ldc 112
    //   20: new 337	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 338	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 589
    //   30: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: getstatic 223	com/tencent/smtt/sdk/QbSdk:sTotalRAM	I
    //   36: invokevirtual 424	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 526	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: getstatic 404	android/os/Build$VERSION:SDK_INT	I
    //   48: bipush 7
    //   50: if_icmplt +12 -> 62
    //   53: getstatic 223	com/tencent/smtt/sdk/QbSdk:sTotalRAM	I
    //   56: getstatic 225	com/tencent/smtt/sdk/QbSdk:X5_ENABLE_BOUNDS	I
    //   59: if_icmpge +5 -> 64
    //   62: iconst_0
    //   63: ireturn
    //   64: aload_0
    //   65: ifnull -3 -> 62
    //   68: new 591	java/io/BufferedInputStream
    //   71: dup
    //   72: new 593	java/io/FileInputStream
    //   75: dup
    //   76: new 504	java/io/File
    //   79: dup
    //   80: invokestatic 429	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   83: aload_0
    //   84: invokevirtual 433	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   87: ldc_w 595
    //   90: invokespecial 598	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   93: invokespecial 600	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   96: invokespecial 603	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   99: astore 6
    //   101: new 605	java/util/Properties
    //   104: dup
    //   105: invokespecial 606	java/util/Properties:<init>	()V
    //   108: astore 8
    //   110: aload 8
    //   112: aload 6
    //   114: invokevirtual 609	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   117: aload 8
    //   119: ldc_w 611
    //   122: invokevirtual 614	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   125: astore 9
    //   127: aload 8
    //   129: ldc_w 616
    //   132: invokevirtual 614	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 10
    //   137: aload 9
    //   139: invokestatic 412	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   142: istore_1
    //   143: aload 10
    //   145: invokestatic 412	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   148: istore_2
    //   149: getstatic 619	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   152: invokestatic 412	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   155: istore_3
    //   156: iload_3
    //   157: iload_1
    //   158: if_icmpgt +8 -> 166
    //   161: iload_3
    //   162: iload_2
    //   163: if_icmpge +43 -> 206
    //   166: ldc 112
    //   168: new 337	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 338	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 621
    //   178: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: iload_3
    //   182: invokevirtual 424	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 526	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload 6
    //   193: ifnull -131 -> 62
    //   196: aload 6
    //   198: invokevirtual 624	java/io/BufferedInputStream:close	()V
    //   201: iconst_0
    //   202: ireturn
    //   203: astore_0
    //   204: iconst_0
    //   205: ireturn
    //   206: aload 8
    //   208: ldc 68
    //   210: invokevirtual 614	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   213: invokestatic 412	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   216: istore_1
    //   217: aload 6
    //   219: ifnull +8 -> 227
    //   222: aload 6
    //   224: invokevirtual 624	java/io/BufferedInputStream:close	()V
    //   227: new 593	java/io/FileInputStream
    //   230: dup
    //   231: new 504	java/io/File
    //   234: dup
    //   235: aload_0
    //   236: invokestatic 627	com/tencent/smtt/sdk/TbsInstaller:getTbsCorePrivateDir	(Landroid/content/Context;)Ljava/io/File;
    //   239: ldc 116
    //   241: invokespecial 598	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   244: invokespecial 600	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   247: astore 6
    //   249: new 605	java/util/Properties
    //   252: dup
    //   253: invokespecial 606	java/util/Properties:<init>	()V
    //   256: astore 7
    //   258: aload 7
    //   260: aload 6
    //   262: invokevirtual 609	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   265: aload 7
    //   267: ldc_w 629
    //   270: invokevirtual 614	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   273: invokestatic 412	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   276: istore_2
    //   277: aload 7
    //   279: ldc_w 631
    //   282: invokevirtual 614	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   285: invokestatic 412	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   288: istore_3
    //   289: iload_1
    //   290: ldc_w 632
    //   293: if_icmpeq +10 -> 303
    //   296: iload_2
    //   297: ldc_w 632
    //   300: if_icmpne +72 -> 372
    //   303: iconst_0
    //   304: istore_1
    //   305: iload_1
    //   306: istore_2
    //   307: aload 6
    //   309: ifnull +10 -> 319
    //   312: aload 6
    //   314: invokevirtual 635	java/io/InputStream:close	()V
    //   317: iload_1
    //   318: istore_2
    //   319: iload_2
    //   320: ifne +181 -> 501
    //   323: iload 4
    //   325: ireturn
    //   326: astore 6
    //   328: aconst_null
    //   329: astore_0
    //   330: aload 6
    //   332: invokevirtual 636	java/lang/Throwable:printStackTrace	()V
    //   335: ldc 112
    //   337: ldc_w 638
    //   340: invokestatic 526	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: aload_0
    //   344: ifnull -282 -> 62
    //   347: aload_0
    //   348: invokevirtual 624	java/io/BufferedInputStream:close	()V
    //   351: iconst_0
    //   352: ireturn
    //   353: astore_0
    //   354: iconst_0
    //   355: ireturn
    //   356: astore_0
    //   357: aconst_null
    //   358: astore 6
    //   360: aload 6
    //   362: ifnull +8 -> 370
    //   365: aload 6
    //   367: invokevirtual 624	java/io/BufferedInputStream:close	()V
    //   370: aload_0
    //   371: athrow
    //   372: iload_1
    //   373: iload_2
    //   374: if_icmple +8 -> 382
    //   377: iconst_0
    //   378: istore_1
    //   379: goto -74 -> 305
    //   382: iload_1
    //   383: iload_2
    //   384: if_icmpne +193 -> 577
    //   387: iload_3
    //   388: ifle +16 -> 404
    //   391: iload_3
    //   392: aload_0
    //   393: invokestatic 643	com/tencent/smtt/utils/AppUtil:getAppVersionCode	(Landroid/content/Context;)I
    //   396: if_icmpeq +8 -> 404
    //   399: iconst_0
    //   400: istore_1
    //   401: goto -96 -> 305
    //   404: aload 7
    //   406: ldc_w 645
    //   409: invokevirtual 614	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   412: invokestatic 648	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   415: ifeq +34 -> 449
    //   418: aload_0
    //   419: invokevirtual 551	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   422: invokestatic 653	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   425: getfield 657	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   428: ldc_w 659
    //   431: iconst_0
    //   432: invokeinterface 665 3 0
    //   437: istore 5
    //   439: iload 5
    //   441: ifne +8 -> 449
    //   444: iconst_1
    //   445: istore_1
    //   446: goto -141 -> 305
    //   449: iconst_0
    //   450: istore_1
    //   451: goto -146 -> 305
    //   454: astore_0
    //   455: aload 7
    //   457: astore_0
    //   458: ldc 112
    //   460: ldc_w 667
    //   463: invokestatic 526	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: aload_0
    //   467: ifnull +7 -> 474
    //   470: aload_0
    //   471: invokevirtual 635	java/io/InputStream:close	()V
    //   474: iconst_1
    //   475: istore_2
    //   476: goto -157 -> 319
    //   479: astore_0
    //   480: iconst_1
    //   481: istore_2
    //   482: goto -163 -> 319
    //   485: astore_0
    //   486: aconst_null
    //   487: astore 6
    //   489: aload 6
    //   491: ifnull +8 -> 499
    //   494: aload 6
    //   496: invokevirtual 635	java/io/InputStream:close	()V
    //   499: aload_0
    //   500: athrow
    //   501: iconst_0
    //   502: istore 4
    //   504: goto -181 -> 323
    //   507: astore 6
    //   509: goto -282 -> 227
    //   512: astore 6
    //   514: goto -144 -> 370
    //   517: astore_0
    //   518: iload_1
    //   519: istore_2
    //   520: goto -201 -> 319
    //   523: astore 6
    //   525: goto -26 -> 499
    //   528: astore_0
    //   529: goto -40 -> 489
    //   532: astore 7
    //   534: aload_0
    //   535: astore 6
    //   537: aload 7
    //   539: astore_0
    //   540: goto -51 -> 489
    //   543: astore_0
    //   544: aload 6
    //   546: astore_0
    //   547: goto -89 -> 458
    //   550: astore_0
    //   551: goto -191 -> 360
    //   554: astore 7
    //   556: aload_0
    //   557: astore 6
    //   559: aload 7
    //   561: astore_0
    //   562: goto -202 -> 360
    //   565: astore 7
    //   567: aload 6
    //   569: astore_0
    //   570: aload 7
    //   572: astore 6
    //   574: goto -244 -> 330
    //   577: iconst_0
    //   578: istore_1
    //   579: goto -274 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	paramContext	Context
    //   142	437	1	i	int
    //   148	372	2	j	int
    //   155	242	3	k	int
    //   4	499	4	bool1	boolean
    //   437	3	5	bool2	boolean
    //   99	214	6	localObject1	Object
    //   326	5	6	localThrowable1	Throwable
    //   358	137	6	localObject2	Object
    //   507	1	6	localException1	Exception
    //   512	1	6	localException2	Exception
    //   523	1	6	localException3	Exception
    //   535	38	6	localObject3	Object
    //   1	455	7	localProperties1	java.util.Properties
    //   532	6	7	localObject4	Object
    //   554	6	7	localObject5	Object
    //   565	6	7	localThrowable2	Throwable
    //   108	99	8	localProperties2	java.util.Properties
    //   125	13	9	str1	String
    //   135	9	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   196	201	203	java/lang/Exception
    //   68	101	326	java/lang/Throwable
    //   347	351	353	java/lang/Exception
    //   68	101	356	finally
    //   227	249	454	java/lang/Throwable
    //   470	474	479	java/lang/Exception
    //   227	249	485	finally
    //   222	227	507	java/lang/Exception
    //   365	370	512	java/lang/Exception
    //   312	317	517	java/lang/Exception
    //   494	499	523	java/lang/Exception
    //   249	289	528	finally
    //   391	399	528	finally
    //   404	439	528	finally
    //   458	466	532	finally
    //   249	289	543	java/lang/Throwable
    //   391	399	543	java/lang/Throwable
    //   404	439	543	java/lang/Throwable
    //   101	156	550	finally
    //   166	191	550	finally
    //   206	217	550	finally
    //   330	343	554	finally
    //   101	156	565	java/lang/Throwable
    //   166	191	565	java/lang/Throwable
    //   206	217	565	java/lang/Throwable
  }
  
  public static boolean canUseVideoFeatrue(Context paramContext, int paramInt)
  {
    paramContext = ReflectionUtils.invokeInstance(sExtensionObj, "canUseVideoFeatrue", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    if ((paramContext != null) && ((paramContext instanceof Boolean))) {
      return ((Boolean)paramContext).booleanValue();
    }
    return false;
  }
  
  public static boolean checkApkExist(Context paramContext, String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return false;
    }
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static void clear(Context paramContext) {}
  
  public static void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    int j = 1;
    TbsLog.i("QbSdk", "clearAllWebViewCache(" + paramContext + ", " + paramBoolean + ")");
    int k = 0;
    i = 0;
    for (;;)
    {
      try
      {
        Object localObject = new WebView(paramContext).getWebViewClientExtension();
        i = k;
        if (localObject != null) {
          TbsLog.e("QbSdk", "clearAllWebViewCache exception 2 -- " + Log.getStackTraceString(localThrowable1));
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localObject = X5CoreEngine.getInstance();
          i = j;
          if (localObject != null)
          {
            i = j;
            if (((X5CoreEngine)localObject).isX5Core())
            {
              ((X5CoreEngine)localObject).wizard().clearAllX5Cache(paramContext, paramBoolean);
              i = j;
            }
          }
          if (i == 0) {
            break;
          }
          TbsLog.i("QbSdk", "is_in_x5_mode --> no need to clear system webview!");
          return;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            android.webkit.WebView localWebView;
            i = 1;
          }
        }
        localThrowable1 = localThrowable1;
      }
    }
    try
    {
      localWebView = new android.webkit.WebView(paramContext);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        localWebView.removeJavascriptInterface("accessibility");
        localWebView.removeJavascriptInterface("accessibilityTraversal");
      }
      localWebView.clearCache(true);
      if (paramBoolean)
      {
        CookieSyncManager.createInstance(paramContext);
        CookieManager.getInstance().removeAllCookie();
      }
      WebViewDatabase.getInstance(paramContext).clearUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearHttpAuthUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearFormData();
      WebStorage.getInstance().deleteAllData();
      WebIconDatabase.getInstance().removeAllIcons();
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(paramContext));
      return;
    }
  }
  
  static boolean clearPluginConfigFile(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      if (paramContext.getApplicationInfo().packageName.contains("com.tencent.portfolio"))
      {
        TbsLog.i("QbSdk", "clearPluginConfigFile #1");
        String str1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getString("app_versionname", null);
        String str2 = paramContext.getPackageManager().getPackageInfo("com.tencent.portfolio", 0).versionName;
        TbsLog.i("QbSdk", "clearPluginConfigFile oldAppVersionName is " + str1 + " newAppVersionName is " + str2);
        if ((str1 != null) && (!str1.contains(str2)))
        {
          paramContext = paramContext.getSharedPreferences("plugin_setting", 0);
          if (paramContext != null)
          {
            paramContext = paramContext.edit();
            paramContext.clear();
            paramContext.commit();
            TbsLog.i("QbSdk", "clearPluginConfigFile done");
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      TbsLog.i("QbSdk", "clearPluginConfigFile error is " + paramContext.getMessage());
      return false;
    }
    return true;
  }
  
  public static void closeFileReader(Context paramContext)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    localX5CoreEngine.init(paramContext, null);
    if (localX5CoreEngine.isX5Core()) {
      localX5CoreEngine.wizard().closeFileReader();
    }
  }
  
  public static boolean createMiniQBShortCut(Context paramContext, String paramString1, String paramString2, Drawable paramDrawable)
  {
    if (paramContext == null) {
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    if (isMiniQBShortCutExist(paramContext, paramString1, paramString2) == true) {
      return false;
    }
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      Bitmap localBitmap = null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
      }
      paramDrawable = localX5CoreEngine.wizard().dexLoader();
      TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
      paramContext = paramDrawable.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[] { Context.class, String.class, String.class, Bitmap.class }, new Object[] { paramContext, paramString1, paramString2, localBitmap });
      TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + paramContext);
      return paramContext != null;
    }
    return false;
  }
  
  public static boolean deleteMiniQBShortCut(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {}
    X5CoreEngine localX5CoreEngine;
    do
    {
      do
      {
        do
        {
          return false;
        } while (TbsDownloader.getOverSea(paramContext));
        localX5CoreEngine = X5CoreEngine.getInstance();
      } while ((localX5CoreEngine == null) || (!localX5CoreEngine.isX5Core()));
    } while (localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[] { Context.class, String.class, String.class }, new Object[] { paramContext, paramString1, paramString2 }) == null);
    return true;
  }
  
  public static void disAllowThirdAppDownload()
  {
    sAllowThirdPartyAppDownload = false;
  }
  
  public static void disableAutoCreateX5Webview()
  {
    mNeedCreateX5webviewAfterInit = false;
  }
  
  public static void fileInfoDetect(Context paramContext, String paramString, android.webkit.ValueCallback<String> paramValueCallback)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {}
    try
    {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[] { Context.class, String.class, android.webkit.ValueCallback.class }, new Object[] { paramContext, paramString, paramValueCallback });
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void forceSysWebView()
  {
    mIsSysWebViewForcedByOuter = true;
    mSysWebViewForcedByOuterInfo = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
    TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
  }
  
  /* Error */
  static void forceSysWebViewInner(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 188	com/tencent/smtt/sdk/QbSdk:mIsSysWebViewForced	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 188	com/tencent/smtt/sdk/QbSdk:mIsSysWebViewForced	Z
    //   19: new 337	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 338	java/lang/StringBuilder:<init>	()V
    //   26: ldc_w 890
    //   29: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: putstatic 202	com/tencent/smtt/sdk/QbSdk:mSysWebViewForcedInnerInfo	Ljava/lang/String;
    //   42: ldc 112
    //   44: new 337	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 338	java/lang/StringBuilder:<init>	()V
    //   51: ldc_w 892
    //   54: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: getstatic 202	com/tencent/smtt/sdk/QbSdk:mSysWebViewForcedInnerInfo	Ljava/lang/String;
    //   60: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 322	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: invokestatic 288	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   72: aload_0
    //   73: sipush 401
    //   76: new 300	java/lang/Throwable
    //   79: dup
    //   80: getstatic 202	com/tencent/smtt/sdk/QbSdk:mSysWebViewForcedInnerInfo	Ljava/lang/String;
    //   83: invokespecial 352	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   86: invokevirtual 355	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   89: goto -78 -> 11
    //   92: astore_0
    //   93: ldc 2
    //   95: monitorexit
    //   96: aload_0
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramContext	Context
    //   0	98	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	92	finally
    //   15	89	92	finally
  }
  
  public static long getApkFileSize(Context paramContext)
  {
    long l = 0L;
    if (paramContext != null) {
      l = TbsDownloadConfig.getInstance(paramContext.getApplicationContext()).mPreferences.getLong("tbs_apkfilesize", 0L);
    }
    return l;
  }
  
  public static String[] getDexLoaderFileList(Context paramContext1, Context paramContext2, String paramString)
  {
    int i = 0;
    if ((sJarFiles instanceof String[]))
    {
      int j = sJarFiles.length;
      paramContext2 = new String[j];
      for (;;)
      {
        paramContext1 = paramContext2;
        if (i >= j) {
          break;
        }
        paramContext2[i] = (paramString + sJarFiles[i]);
        i += 1;
      }
    }
    paramContext1 = ReflectionUtils.invokeInstance(sExtensionObj, "getJarFiles", new Class[] { Context.class, Context.class, String.class }, new Object[] { paramContext1, paramContext2, paramString });
    if ((paramContext1 instanceof String[])) {}
    for (;;)
    {
      paramContext1 = (String[])paramContext1;
      return paramContext1;
      paramContext1 = new String[1];
      paramContext1[0] = "";
    }
  }
  
  public static boolean getDownloadWithoutWifi()
  {
    return mDownloadWithoutWifi;
  }
  
  protected static String getGuid()
  {
    Object localObject = X5CoreEngine.getInstance();
    if ((localObject != null) && (((X5CoreEngine)localObject).isX5Core()))
    {
      localObject = ((X5CoreEngine)localObject).wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
      if ((localObject != null) && ((localObject instanceof String))) {
        return (String)localObject;
      }
    }
    return null;
  }
  
  public static boolean getIsSysWebViewForcedByOuter()
  {
    return mIsSysWebViewForcedByOuter;
  }
  
  public static String getMiniQBVersion(Context paramContext)
  {
    Object localObject = null;
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    localX5CoreEngine.init(paramContext, null);
    paramContext = localObject;
    if (localX5CoreEngine != null)
    {
      paramContext = localObject;
      if (localX5CoreEngine.isX5Core()) {
        paramContext = localX5CoreEngine.wizard().getMiniQBVersion();
      }
    }
    return paramContext;
  }
  
  public static boolean getOnlyDownload()
  {
    return mOnlyDownload;
  }
  
  public static String getQQBuildNumber()
  {
    return mQQBuildNumber;
  }
  
  public static Map<String, Object> getSettings()
  {
    return mSettings;
  }
  
  public static boolean getTBSInstalling()
  {
    return mTBSInstalling;
  }
  
  public static String getTID()
  {
    return mTID;
  }
  
  static String getTbsCoreVersionString()
  {
    return sTbsVersionString;
  }
  
  public static String getTbsResourcesPath(Context paramContext)
  {
    return TbsShareManager.getTbsResourcesPath(paramContext);
  }
  
  public static int getTbsVersion(Context paramContext)
  {
    int i;
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      i = TbsShareManager.getAvailableTbsCoreVersion(paramContext, false);
    }
    int j;
    do
    {
      do
      {
        return i;
        j = TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext);
        i = j;
      } while (j != 0);
      i = j;
    } while (TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallStatus() != 3);
    reset(paramContext);
    return j;
  }
  
  public static int getTbsVersionForCrash(Context paramContext)
  {
    int i;
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      i = TbsShareManager.getAvailableTbsCoreVersion(paramContext, false);
    }
    int j;
    do
    {
      do
      {
        return i;
        j = TbsInstaller.getInstance().getTbsCoreInstalledVerInNolockForCrash(paramContext);
        i = j;
      } while (j != 0);
      i = j;
    } while (TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallStatus() != 3);
    reset(paramContext);
    return j;
  }
  
  static Bundle incrUpdate(Context paramContext, Bundle paramBundle)
    throws Exception
  {
    if (!initExtension(paramContext))
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(216, "initForPatch return false!");
      return null;
    }
    paramBundle = ReflectionUtils.invokeInstance(sExtensionObj, "incrUpdate", new Class[] { Context.class, Bundle.class }, new Object[] { paramContext, paramBundle });
    if (paramBundle != null) {
      return (Bundle)paramBundle;
    }
    TbsLogReport.getInstance(paramContext).setInstallErrorCode(216, "incrUpdate return null!");
    return null;
  }
  
  @SuppressLint({"NewApi"})
  private static boolean init(Context paramContext, boolean paramBoolean)
  {
    TbsLog.initIfNeed(paramContext);
    if (!sIsVersionPrinted)
    {
      TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43609; SDK_VERSION_NAME: 3.6.0.1236");
      sIsVersionPrinted = true;
    }
    if ((mIsSysWebViewForced) && (!paramBoolean))
    {
      TbsLog.e("QbSdk", "QbSdk init: " + mSysWebViewForcedInnerInfo, false);
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 414, new Throwable(mSysWebViewForcedInnerInfo));
      return false;
    }
    if (mIsSysWebViewForcedByOuter)
    {
      TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 402, new Throwable(mSysWebViewForcedByOuterInfo));
      return false;
    }
    if (!isPreloadX5Checking) {
      preloadX5Check(paramContext);
    }
    for (;;)
    {
      try
      {
        localObject2 = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
        if (localObject2 == null)
        {
          TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
          return false;
        }
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          if ((sTbsVersion != 0) && (sTbsVersion != TbsShareManager.getAvailableTbsCoreVersion(paramContext)))
          {
            sExtensionClass = null;
            sExtensionObj = null;
            TbsLog.e("QbSdk", "QbSdk init (false) ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY!");
            TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 302, new Throwable("sTbsVersion: " + sTbsVersion + "; AvailableTbsCoreVersion: " + TbsShareManager.getAvailableTbsCoreVersion(paramContext)));
            return false;
          }
          sTbsVersion = TbsShareManager.getAvailableTbsCoreVersion(paramContext);
          if (sExtensionClass != null) {
            return true;
          }
        }
        else
        {
          if (sTbsVersion == 0) {
            break label1005;
          }
          int j = TbsInstaller.getInstance().getTbsCoreInstalledVerWithNew(true, paramContext);
          i = j;
          if (sTbsVersion != j)
          {
            sExtensionClass = null;
            sExtensionObj = null;
            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + j, true);
            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + sTbsVersion, true);
            TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 303, new Throwable("sTbsVersion: " + sTbsVersion + "; tbsCoreInstalledVer: " + j));
            return false;
          }
          sTbsVersion = i;
          continue;
        }
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {
          break label610;
        }
      }
      catch (Throwable localThrowable1)
      {
        TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(localThrowable1));
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 306, localThrowable1);
        return false;
      }
      File localFile;
      if (TbsShareManager.isShareTbsCoreAvailable(paramContext))
      {
        localFile = new File(TbsShareManager.getAvailableTbsCorePath(paramContext), "tbs_sdk_extension_dex.jar");
        paramBoolean = localFile.exists();
        if (paramBoolean) {}
      }
      else
      {
        for (;;)
        {
          try
          {
            TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
            i = TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext);
            if (!new File(localFile.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
              continue;
            }
            if (i <= 0) {
              continue;
            }
            TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
          }
          catch (Throwable localThrowable2)
          {
            label610:
            localThrowable2.printStackTrace();
            continue;
            if (i <= 0) {
              continue;
            }
            TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
            continue;
            TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
            continue;
          }
          return false;
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 304, new Throwable("isShareTbsCoreAvailable false!"));
          return false;
          localFile = new File(TbsInstaller.getInstance().getTbsCoreShareDir(paramContext), "tbs_sdk_extension_dex.jar");
          break;
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
        }
      }
      if (TbsShareManager.getHostCorePathAppDefined() != null) {}
      for (Object localObject2 = TbsShareManager.getHostCorePathAppDefined();; localObject2 = ((File)localObject2).getAbsolutePath())
      {
        TbsLog.i("QbSdk", "QbSdk init optDirExtension #1 is " + (String)localObject2);
        TbsLog.i("QbSdk", "new DexLoader #1 dexFile is " + localThrowable2.getAbsolutePath());
        sExtensionClass = new DexLoader(localThrowable2.getParent(), paramContext, new String[] { localThrowable2.getAbsolutePath() }, (String)localObject2, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
        loadTBSSDKExtension(paramContext, localThrowable2.getParent());
        Object localObject1 = sExtensionObj;
        localObject2 = AppUtil.mImei;
        String str1 = AppUtil.mImsi;
        String str2 = AppUtil.mCpu;
        String str3 = AppUtil.mMac;
        ReflectionUtils.invokeInstance(localObject1, "putInfo", new Class[] { String.class, String.class, String.class, String.class }, new Object[] { localObject2, str1, str2, str3 });
        ReflectionUtils.invokeInstance(sExtensionObj, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
        return true;
      }
      label1005:
      int i = 0;
    }
  }
  
  public static void initBuglyAsync(boolean paramBoolean)
  {
    mIsBuglyEnabled = paramBoolean;
  }
  
  static boolean initExtension(Context paramContext)
  {
    try
    {
      if (sExtensionClass != null) {
        return true;
      }
      Object localObject = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
      if (localObject == null)
      {
        TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
        return false;
      }
      File localFile = new File((File)localObject, "tbs_sdk_extension_dex.jar");
      if (!localFile.exists())
      {
        TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
        return false;
      }
      TbsLog.i("QbSdk", "new DexLoader #3 dexFile is " + localFile.getAbsolutePath());
      String str1 = localFile.getParent();
      String str2 = localFile.getAbsolutePath();
      localObject = ((File)localObject).getAbsolutePath();
      sExtensionClass = new DexLoader(str1, paramContext, new String[] { str2 }, (String)localObject, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      loadTBSSDKExtension(paramContext, localFile.getParent());
      return true;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(paramContext));
    }
    return false;
  }
  
  private static boolean initForX5DisableConfig(Context paramContext)
  {
    try
    {
      if (sExtensionClass != null) {
        return true;
      }
      Object localObject2 = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
      if (localObject2 == null)
      {
        TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
        return false;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        if (!TbsShareManager.isShareTbsCoreAvailable(paramContext)) {}
      }
      for (Object localObject1 = new File(TbsShareManager.getAvailableTbsCorePath(paramContext), "tbs_sdk_extension_dex.jar"); !((File)localObject1).exists(); localObject1 = new File(TbsInstaller.getInstance().getTbsCoreShareDir(paramContext), "tbs_sdk_extension_dex.jar"))
      {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
        return false;
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 304);
        return false;
      }
      if (TbsShareManager.getHostCorePathAppDefined() != null) {}
      for (localObject2 = TbsShareManager.getHostCorePathAppDefined();; localObject2 = ((File)localObject2).getAbsolutePath())
      {
        TbsLog.i("QbSdk", "QbSdk init optDirExtension #3 is " + (String)localObject2);
        TbsLog.i("QbSdk", "new DexLoader #4 dexFile is " + ((File)localObject1).getAbsolutePath());
        sExtensionClass = new DexLoader(((File)localObject1).getParent(), paramContext, new String[] { ((File)localObject1).getAbsolutePath() }, (String)localObject2, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
        loadTBSSDKExtension(paramContext, ((File)localObject1).getParent());
        paramContext = sExtensionObj;
        localObject1 = AppUtil.mImei;
        localObject2 = AppUtil.mImsi;
        String str1 = AppUtil.mCpu;
        String str2 = AppUtil.mMac;
        ReflectionUtils.invokeInstance(paramContext, "putInfo", new Class[] { String.class, String.class, String.class, String.class }, new Object[] { localObject1, localObject2, str1, str2 });
        ReflectionUtils.invokeInstance(sExtensionObj, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
        return true;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(paramContext));
    }
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    if (mSettings == null)
    {
      mSettings = paramMap;
      return;
    }
    try
    {
      mSettings.putAll(paramMap);
      return;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  public static void initX5Environment(Context paramContext, final PreInitCallback paramPreInitCallback)
  {
    if (paramContext == null) {
      return;
    }
    clearPluginConfigFile(paramContext);
    mTbsListenerForInit = new TbsListener()
    {
      public void onDownloadFinish(int paramAnonymousInt) {}
      
      public void onDownloadProgress(int paramAnonymousInt) {}
      
      public void onInstallFinish(int paramAnonymousInt)
      {
        QbSdk.preInit(this.val$context, paramPreInitCallback);
      }
    };
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      TbsInstaller.getInstance().installTbsCoreIfNeeded(paramContext, true);
    }
    TbsDownloader.needDownload(paramContext, false, false, new TbsDownloader.TbsDownloaderCallback()
    {
      public void onNeedDownloadFinish(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        if ((TbsShareManager.findCoreForThirdPartyApp(this.val$context) == 0) && (!TbsShareManager.getCoreDisabled()))
        {
          TbsShareManager.forceToLoadX5ForThirdApp(this.val$context, false);
          if ((QbSdk.mIsBuglyEnabled) && (TbsShareManager.isThirdPartyApp(this.val$context))) {
            TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(this.val$context);
          }
          return;
        }
        if ((QbSdk.mIsBuglyEnabled) && (TbsShareManager.isThirdPartyApp(this.val$context))) {
          TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(this.val$context);
        }
        QbSdk.preInit(this.val$context, paramPreInitCallback);
      }
    });
  }
  
  public static boolean installLocalQbApk(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    boolean bool2 = false;
    SDKEngine localSDKEngine = SDKEngine.getInstance(true);
    localSDKEngine.init(paramContext, false, false, null);
    boolean bool1 = bool2;
    if (localSDKEngine != null)
    {
      bool1 = bool2;
      if (localSDKEngine.isTbsAvailable()) {
        bool1 = localSDKEngine.wizard().installLocalQbApk(paramContext, paramString1, paramString2, paramBundle);
      }
    }
    return bool1;
  }
  
  public static boolean intentDispatch(WebView paramWebView, Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramWebView == null) {
      return false;
    }
    Context localContext;
    int i;
    if (paramString1.startsWith("mttbrowser://miniqb/ch=icon?"))
    {
      localContext = paramWebView.getContext();
      i = paramString1.indexOf("url=");
      if (i <= 0) {
        break label180;
      }
    }
    label180:
    for (paramIntent = paramString1.substring(i + 4);; paramIntent = null)
    {
      HashMap localHashMap = new HashMap();
      paramString1 = "unknown";
      try
      {
        String str = localContext.getApplicationInfo().packageName;
        paramString1 = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        paramWebView.loadUrl(paramIntent);
      }
      localHashMap.put("ChannelID", paramString1);
      localHashMap.put("PosID", "14004");
      if ("miniqb://home".equals(paramIntent)) {}
      for (paramString1 = "qb://navicard/addCard?cardId=168&cardName=168";; paramString1 = paramIntent)
      {
        if (MttLoader.loadUrl(localContext, paramString1, localHashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0)
        {
          paramString1 = X5CoreEngine.getInstance();
          if ((paramString1 != null) && (paramString1.isX5Core()) && (paramString1.wizard().startMiniQB(localContext, paramIntent, null, paramString2, null) == 0)) {
            return true;
          }
        }
        for (;;)
        {
          return false;
          paramWebView.loadUrl(paramString1);
        }
      }
    }
  }
  
  public static boolean isMiniQBShortCutExist(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    paramString2 = X5CoreEngine.getInstance();
    if ((paramString2 != null) && (paramString2.isX5Core()))
    {
      paramContext = paramString2.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString1 });
      if (paramContext != null) {
        if (!(paramContext instanceof Boolean)) {
          break label100;
        }
      }
    }
    label100:
    for (paramContext = (Boolean)paramContext;; paramContext = Boolean.valueOf(false))
    {
      return paramContext.booleanValue();
      return false;
      return false;
    }
  }
  
  private static boolean isQBSupport(Context paramContext, String paramString1, String paramString2)
  {
    return isSuportOpenFile(paramString2, 2);
  }
  
  public static boolean isSuportOpenFile(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      return Arrays.asList(new String[] { "doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub" }).contains(paramString.toLowerCase());
    }
    return Arrays.asList(new String[] { "rar", "zip", "tar", "bz2", "gz", "7z", "doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub", "chm", "html", "htm", "xml", "mht", "url", "ini", "log", "bat", "php", "js", "lrc", "jpg", "jpeg", "png", "gif", "bmp", "tiff", "webp", "mp3", "m4a", "aac", "amr", "wav", "ogg", "mid", "ra", "wma", "mpga", "ape", "flac", "RTSP", "RTP", "SDP", "RTMP", "mp4", "flv", "avi", "3gp", "3gpp", "webm", "ts", "ogv", "m3u8", "asf", "wmv", "rmvb", "rm", "f4v", "dat", "mov", "mpg", "mkv", "mpeg", "mpeg1", "mpeg2", "xvid", "dvd", "vcd", "vob", "divx" }).contains(paramString.toLowerCase());
  }
  
  public static boolean isTbsCoreInited()
  {
    boolean bool2 = false;
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    boolean bool1 = bool2;
    if (localSDKEngine != null)
    {
      bool1 = bool2;
      if (localSDKEngine.isInited()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  static boolean isX5Disabled(Context paramContext, int paramInt)
  {
    return isX5Disabled(paramContext, paramInt, 20000);
  }
  
  static boolean isX5Disabled(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((mSettings != null) && (mSettings.containsKey(KEY_SET_SENDREQUEST_AND_UPLOAD)) && (mSettings.get(KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")))
    {
      TbsLog.i("QbSdk", "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
      return true;
    }
    if (!initForX5DisableConfig(paramContext)) {
      return true;
    }
    paramContext = ReflectionUtils.invokeInstance(sExtensionObj, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(43609), Integer.valueOf(paramInt2) });
    if (paramContext != null) {
      return ((Boolean)paramContext).booleanValue();
    }
    paramContext = ReflectionUtils.invokeInstance(sExtensionObj, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(43609) });
    if (paramContext != null) {
      return ((Boolean)paramContext).booleanValue();
    }
    return true;
  }
  
  public static boolean isX5DisabledSync(Context paramContext)
  {
    if (TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallStatus() == 2) {}
    for (int i = 1; i != 0; i = 0) {
      return false;
    }
    if (!initForX5DisableConfig(paramContext)) {
      return true;
    }
    i = TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext);
    paramContext = ReflectionUtils.invokeInstance(sExtensionObj, "isX5DisabledSync", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(i), Integer.valueOf(43609) });
    if (paramContext != null) {
      return ((Boolean)paramContext).booleanValue();
    }
    return true;
  }
  
  private static void loadTBSSDKExtension(Context paramContext, String paramString)
  {
    int i = 1;
    try
    {
      localConstructor = sExtensionClass.getConstructor(new Class[] { Context.class, Context.class, String.class, String.class, String.class });
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          Constructor localConstructor;
          if (TbsShareManager.isThirdPartyApp(paramContext))
          {
            Context localContext = TbsShareManager.getAvailableTbsCoreHostContext(paramContext);
            if ((localContext == null) && (TbsShareManager.getHostCorePathAppDefined() == null))
            {
              TbsLogReport.getInstance(paramContext.getApplicationContext()).setLoadErrorCode(227, "host context is null!");
              return;
            }
            if (i == 0)
            {
              if (localContext == null)
              {
                sExtensionObj = sExtensionClass.getConstructor(new Class[] { Context.class, Context.class, String.class }).newInstance(new Object[] { paramContext, localContext, TbsShareManager.getHostCorePathAppDefined() });
                return;
              }
              sExtensionObj = sExtensionClass.getConstructor(new Class[] { Context.class, Context.class }).newInstance(new Object[] { paramContext, localContext });
              return;
            }
            sExtensionObj = localConstructor.newInstance(new Object[] { paramContext, localContext, TbsShareManager.getHostCorePathAppDefined(), paramString, null });
            return;
          }
          if (i == 0)
          {
            sExtensionObj = sExtensionClass.getConstructor(new Class[] { Context.class, Context.class }).newInstance(new Object[] { paramContext, paramContext });
            return;
          }
          sExtensionObj = localConstructor.newInstance(new Object[] { paramContext, paramContext, null, paramString, null });
          return;
        }
        catch (Throwable paramContext) {}
        localThrowable = localThrowable;
        i = 0;
        Object localObject = null;
      }
    }
  }
  
  static Object onMiscCallExtension(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (!initExtension(paramContext)) {
      paramContext = Integer.valueOf(-99999);
    }
    do
    {
      return paramContext;
      paramString = ReflectionUtils.invokeInstance(sExtensionObj, "miscCall", new Class[] { String.class, Bundle.class }, new Object[] { paramString, paramBundle });
      paramContext = paramString;
    } while (paramString != null);
    return null;
  }
  
  public static void openBrowserList(Context paramContext, String paramString, ValueCallback<String> paramValueCallback)
  {
    if (paramContext == null) {}
    do
    {
      String str;
      do
      {
        return;
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.addCategory("android.intent.category.DEFAULT");
        localIntent.setData(Uri.parse(paramString));
        paramString = TBSResources.getMIMEType(paramString);
        isDefaultDialog = false;
        paramString = new TBSActivityPicker(paramContext, "选择其它应用打开", localIntent, paramValueCallback, paramString);
        str = paramString.getTBSPickedDefaultBrowser();
        if ((str == null) || (TextUtils.isEmpty(str))) {
          break;
        }
        if ("com.tencent.mtt".equals(str))
        {
          localIntent.putExtra("ChannelID", paramContext.getApplicationContext().getPackageName());
          localIntent.putExtra("PosID", "4");
        }
        localIntent.setPackage(str);
        paramContext.startActivity(localIntent);
      } while (paramValueCallback == null);
      paramValueCallback.onReceiveValue("default browser:" + str);
      return;
      if (!isDefaultDialog) {
        break;
      }
      new AlertDialog.Builder(paramContext).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }).show();
    } while (paramValueCallback == null);
    paramValueCallback.onReceiveValue("can not open");
    return;
    paramString.show();
    paramString.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        if (this.val$callback != null) {
          this.val$callback.onReceiveValue("TbsReaderDialogClosed");
        }
      }
    });
  }
  
  public static int openFileReader(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 505);
    if (paramString != null)
    {
      Object localObject = paramString.substring(paramString.lastIndexOf(".") + 1, paramString.length());
      if ("apk".equalsIgnoreCase((String)localObject))
      {
        paramHashMap = new Intent("android.intent.action.VIEW");
        paramHashMap.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
        paramContext.startActivity(paramHashMap);
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 506);
        Log.e("QbSdk", "open openFileReader ret = 4");
        return 4;
      }
      if (MttLoader.isBrowserInstalled(paramContext))
      {
        if (!isQBSupport(paramContext, paramString, (String)localObject))
        {
          Log.e("QbSdk", "openFileReader open in QB isQBSupport: false  ret = 3");
          openFileReaderListWithQBDownload(paramContext, paramString, paramValueCallback);
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 507);
          return 3;
        }
        if (startQBForDoc(paramContext, paramString, 4, 0, (String)localObject, parseMenuData(paramContext, paramHashMap)))
        {
          if (paramValueCallback != null) {
            paramValueCallback.onReceiveValue("open QB");
          }
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 507);
          Log.e("QbSdk", "open openFileReader open QB ret = 1");
          return 1;
        }
        Log.d("QbSdk", "openFileReader startQBForDoc return false");
      }
      for (;;)
      {
        localObject = paramHashMap;
        if (paramHashMap == null) {
          localObject = new HashMap();
        }
        ((HashMap)localObject).put("local", "true");
        TbsLog.setWriteLogJIT(true);
        int i = startMiniQBToLoadUrl(paramContext, paramString, (HashMap)localObject, paramValueCallback);
        if (i == 0) {
          break;
        }
        openFileReaderListWithQBDownload(paramContext, paramString, paramValueCallback);
        TbsLogReport.getInstance(paramContext).setLoadErrorCode(511, "" + i);
        return 3;
        Log.d("QbSdk", "openFileReader QQ browser not installed");
      }
    }
    if (paramValueCallback != null) {
      paramValueCallback.onReceiveValue("filepath error");
    }
    TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 509);
    Log.e("QbSdk", "open openFileReader filepath error ret -1");
    return -1;
    TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 510);
    return 2;
  }
  
  public static void openFileReaderListWithQBDownload(Context paramContext, String paramString, ValueCallback<String> paramValueCallback)
  {
    if ((paramContext == null) || (paramContext.getApplicationInfo().packageName.equals("com.tencent.qim")) || (paramContext.getApplicationInfo().packageName.equals("com.tencent.tim")) || (paramContext.getApplicationInfo().packageName.equals("com.tencent.androidqqmail"))) {}
    do
    {
      String str;
      do
      {
        return;
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.addCategory("android.intent.category.DEFAULT");
        str = TBSResources.getMIMEType(paramString);
        localIntent.setDataAndType(Uri.fromFile(new File(paramString)), str);
        isDefaultDialog = false;
        paramString = new TBSActivityPicker(paramContext, "选择其它应用打开", localIntent, paramValueCallback, str);
        str = paramString.getTBSPickedDefaultBrowser();
        if ((str == null) || (TextUtils.isEmpty(str)) || (!checkApkExist(paramContext, str))) {
          break;
        }
        if ("com.tencent.mtt".equals(str))
        {
          localIntent.putExtra("ChannelID", paramContext.getApplicationContext().getPackageName());
          localIntent.putExtra("PosID", "4");
        }
        localIntent.setPackage(str);
        paramContext.startActivity(localIntent);
      } while (paramValueCallback == null);
      paramValueCallback.onReceiveValue("default browser:" + str);
      return;
      if (("com.tencent.rtxlite".equalsIgnoreCase(paramContext.getApplicationContext().getPackageName())) && (isDefaultDialog))
      {
        new AlertDialog.Builder(paramContext).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }).show();
        return;
      }
      if (!isDefaultDialog) {
        break;
      }
    } while (paramValueCallback == null);
    paramValueCallback.onReceiveValue("can not open");
    return;
    try
    {
      paramString.show();
      paramString.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          if (this.val$callback != null) {
            this.val$callback.onReceiveValue("TbsReaderDialogClosed");
          }
        }
      });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramValueCallback.onReceiveValue("TbsReaderDialogClosed");
    }
  }
  
  /* Error */
  private static Bundle parseMenuData(Context paramContext, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 335	android/os/Bundle
    //   9: dup
    //   10: invokespecial 1535	android/os/Bundle:<init>	()V
    //   13: astore 5
    //   15: aload_1
    //   16: ldc_w 1537
    //   19: invokeinterface 1323 2 0
    //   24: ifnonnull +167 -> 191
    //   27: ldc_w 387
    //   30: astore 4
    //   32: aload 5
    //   34: ldc_w 1537
    //   37: aload 4
    //   39: invokevirtual 1540	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload 5
    //   44: ldc_w 1542
    //   47: aload_1
    //   48: ldc_w 1542
    //   51: invokeinterface 1323 2 0
    //   56: checkcast 327	java/lang/String
    //   59: invokestatic 1547	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   62: invokevirtual 1551	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   65: aload_1
    //   66: ifnull +163 -> 229
    //   69: aload_1
    //   70: ldc 57
    //   72: invokeinterface 1319 2 0
    //   77: ifeq +152 -> 229
    //   80: new 1553	org/json/JSONObject
    //   83: dup
    //   84: aload_1
    //   85: ldc 57
    //   87: invokeinterface 1323 2 0
    //   92: checkcast 327	java/lang/String
    //   95: invokespecial 1554	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   98: astore_1
    //   99: aload_1
    //   100: ldc_w 1556
    //   103: invokevirtual 1560	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   106: astore 4
    //   108: aload 4
    //   110: ifnull +108 -> 218
    //   113: new 1562	java/util/ArrayList
    //   116: dup
    //   117: invokespecial 1563	java/util/ArrayList:<init>	()V
    //   120: astore 6
    //   122: iconst_0
    //   123: istore_2
    //   124: aload 4
    //   126: invokevirtual 1566	org/json/JSONArray:length	()I
    //   129: istore_3
    //   130: iload_2
    //   131: iload_3
    //   132: if_icmpge +76 -> 208
    //   135: iload_2
    //   136: iconst_5
    //   137: if_icmpge +71 -> 208
    //   140: aload 4
    //   142: iload_2
    //   143: invokevirtual 1569	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   146: checkcast 1553	org/json/JSONObject
    //   149: astore 7
    //   151: aload 7
    //   153: ldc_w 1571
    //   156: invokevirtual 1573	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   159: istore_3
    //   160: aload 6
    //   162: iload_2
    //   163: aload_0
    //   164: invokevirtual 1577	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   167: iload_3
    //   168: invokestatic 1583	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   171: invokevirtual 1587	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   174: aload 7
    //   176: ldc_w 1571
    //   179: iload_2
    //   180: invokevirtual 1590	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   183: pop
    //   184: iload_2
    //   185: iconst_1
    //   186: iadd
    //   187: istore_2
    //   188: goto -64 -> 124
    //   191: aload_1
    //   192: ldc_w 1537
    //   195: invokeinterface 1323 2 0
    //   200: checkcast 327	java/lang/String
    //   203: astore 4
    //   205: goto -173 -> 32
    //   208: aload 5
    //   210: ldc_w 1592
    //   213: aload 6
    //   215: invokevirtual 1596	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   218: aload 5
    //   220: ldc 57
    //   222: aload_1
    //   223: invokevirtual 1597	org/json/JSONObject:toString	()Ljava/lang/String;
    //   226: invokevirtual 1540	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload 5
    //   231: areturn
    //   232: astore_0
    //   233: aload_0
    //   234: invokevirtual 452	java/lang/Exception:printStackTrace	()V
    //   237: aconst_null
    //   238: areturn
    //   239: astore 7
    //   241: goto -57 -> 184
    //   244: astore 4
    //   246: goto -181 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramContext	Context
    //   0	249	1	paramMap	Map<String, String>
    //   123	65	2	i	int
    //   129	39	3	j	int
    //   30	174	4	localObject	Object
    //   244	1	4	localException1	Exception
    //   13	217	5	localBundle	Bundle
    //   120	94	6	localArrayList	java.util.ArrayList
    //   149	26	7	localJSONObject	org.json.JSONObject
    //   239	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   6	27	232	java/lang/Exception
    //   32	42	232	java/lang/Exception
    //   69	108	232	java/lang/Exception
    //   113	122	232	java/lang/Exception
    //   124	130	232	java/lang/Exception
    //   191	205	232	java/lang/Exception
    //   208	218	232	java/lang/Exception
    //   218	229	232	java/lang/Exception
    //   140	184	239	java/lang/Exception
    //   42	65	244	java/lang/Exception
  }
  
  public static void preInit(Context paramContext)
  {
    try
    {
      preInit(paramContext, null);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void preInit(final Context paramContext, final PreInitCallback paramPreInitCallback)
  {
    try
    {
      TbsLog.initIfNeed(paramContext);
      TbsLog.i("QbSdk", "preInit -- stack: " + Log.getStackTraceString(new Throwable("#")));
      mTmpIsSysWebViewForced = mIsSysWebViewForced;
      if (!mIsPreInitialized)
      {
        paramContext = new Thread()
        {
          public void handleMessage(Message paramAnonymousMessage)
          {
            switch (paramAnonymousMessage.what)
            {
            }
            do
            {
              return;
              if (paramPreInitCallback != null) {
                paramPreInitCallback.onViewInitFinished(false);
              }
              TbsLog.writeLogToDisk();
              return;
              if (QbSdk.mNeedCreateX5webviewAfterInit)
              {
                paramAnonymousMessage = X5CoreEngine.getInstance().wizard();
                if (paramAnonymousMessage != null) {
                  paramAnonymousMessage.createSDKWebview(paramContext);
                }
              }
              if (paramPreInitCallback != null) {
                paramPreInitCallback.onViewInitFinished(true);
              }
              TbsLog.writeLogToDisk();
              return;
            } while (paramPreInitCallback == null);
            paramPreInitCallback.onCoreInitFinished();
          }
        }
        {
          public void run()
          {
            if (TbsInstaller.getInstance().getTbsCoreInstalledVerWithNew(true, this.val$context) == 0) {
              TbsInstaller.getInstance().installTbsCoreIfNeeded(this.val$context, true);
            }
            SDKEngine.getInstance(true).init(this.val$context, false, false, null);
            X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
            localX5CoreEngine.init(this.val$context, null);
            boolean bool = localX5CoreEngine.isX5Core();
            this.val$handler.sendEmptyMessage(3);
            if (!bool)
            {
              this.val$handler.sendEmptyMessage(2);
              return;
            }
            this.val$handler.sendEmptyMessage(1);
          }
        };
        paramContext.setName("tbs_preinit");
        paramContext.setPriority(10);
        paramContext.start();
        mIsPreInitialized = true;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static void preloadX5Check(Context paramContext)
  {
    int i1 = -1;
    isPreloadX5Checking = true;
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          k = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_recorder", -1);
          if (k < 0) {
            continue;
          }
          i = k + 1;
          if (i > 4)
          {
            return;
            localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
            continue;
          }
          k = i;
        }
        catch (Throwable localThrowable2)
        {
          Object localObject1;
          int j;
          int n;
          Object localObject2;
          int m;
          Object localObject3;
          int k = -1;
          int i = -1;
          continue;
          i = -1;
          continue;
        }
        try
        {
          j = TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext);
          if (j <= 0) {
            continue;
          }
          if (k > 4) {}
        }
        catch (Throwable localThrowable3)
        {
          j = -1;
          k = i;
          i = j;
          continue;
        }
        try
        {
          ((SharedPreferences)localObject1).edit().putInt("tbs_preload_x5_recorder", k).commit();
          n = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_counter", -1);
          k = i;
          localObject2 = localObject1;
          m = j;
          if (n < 0) {
            continue;
          }
          localObject2 = ((SharedPreferences)localObject1).edit();
          n += 1;
          ((SharedPreferences.Editor)localObject2).putInt("tbs_preload_x5_counter", n).commit();
          if (n <= 3) {
            continue;
          }
          try
          {
            i = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_version", -1);
            localObject1 = ((SharedPreferences)localObject1).edit();
            if (i != j) {
              continue;
            }
            FileUtil.delete(TbsInstaller.getInstance().getTbsCoreShareDir(paramContext), false);
            paramContext = TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallFile();
            if (paramContext != null) {
              FileUtil.delete(paramContext, false);
            }
            TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + j + " is deleted!");
            ((SharedPreferences.Editor)localObject1).putInt("tbs_precheck_disable_version", i);
            ((SharedPreferences.Editor)localObject1).commit();
            return;
          }
          catch (Throwable paramContext)
          {
            TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(paramContext));
            return;
          }
          localThrowable1 = localThrowable1;
          k = -1;
          localObject1 = null;
          i = -1;
        }
        catch (Throwable localThrowable4)
        {
          k = i;
          i = j;
          continue;
        }
        TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(localThrowable1));
        m = i;
        localObject3 = localObject1;
        n = -1;
        i = k;
        localObject1 = localObject3;
        j = m;
        continue;
        TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + j + "; value:" + i);
      }
      j = i1;
      if (i > 0)
      {
        j = i1;
        if (i <= 3)
        {
          TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
          X5CoreEngine.getInstance().init(paramContext, null);
          TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
          j = 0;
        }
      }
      try
      {
        i = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_counter", -1);
        if (i > 0) {
          ((SharedPreferences)localObject1).edit().putInt("tbs_preload_x5_counter", i - 1).commit();
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(paramContext));
        }
      }
      TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + j);
      return;
    }
  }
  
  public static void reset(Context paramContext)
  {
    reset(paramContext, false);
  }
  
  public static void reset(Context paramContext, boolean paramBoolean)
  {
    int i = 1;
    TbsLog.e("QbSdk", "QbSdk reset!", true);
    for (;;)
    {
      try
      {
        TbsDownloader.stopDownload();
        if ((paramBoolean) && (!TbsShareManager.isThirdPartyApp(paramContext)))
        {
          int j = TbsInstaller.getInstance().getTbsCoreShareDecoupleCoreVersion(paramContext);
          int k = TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext);
          if ((j > 43300) && (j != k))
          {
            TbsDownloader.clearAllCache(paramContext);
            FileUtil.delete(paramContext.getDir("tbs", 0), false, "core_share_decouple");
            TbsLog.i("QbSdk", "delete downloaded apk success", true);
            TbsInstaller.mTbsCoreInstalledVer.set(Integer.valueOf(0));
            File localFile = new File(paramContext.getFilesDir(), "bugly_switch.txt");
            if ((localFile != null) && (localFile.exists())) {
              localFile.delete();
            }
            if (i != 0)
            {
              FileUtil.copyFiles(TbsInstaller.getInstance().getCoreShareDecoupleDir(paramContext), TbsInstaller.getInstance().getTmpTbsCoreUnzipDir(paramContext));
              TbsInstaller.getInstance().setFallBackStatus(paramContext);
            }
            return;
          }
        }
      }
      catch (Throwable paramContext)
      {
        TbsLog.e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(paramContext));
        return;
      }
      i = 0;
    }
  }
  
  public static void resetDecoupleCore(Context paramContext)
  {
    TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
    try
    {
      FileUtil.delete(TbsInstaller.getInstance().getCoreShareDecoupleDir(paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "QbSdk resetDecoupleCore exception:" + Log.getStackTraceString(paramContext));
    }
  }
  
  public static void setCurrentID(String paramString)
  {
    if (paramString == null) {}
    while (!paramString.startsWith("QQ:")) {
      return;
    }
    paramString = paramString.substring("QQ:".length());
    mTID = "0000000000000000".substring(paramString.length()) + paramString;
  }
  
  public static void setDeviceInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppUtil.mImei = paramString1;
    AppUtil.mImsi = paramString2;
    AppUtil.mCpu = paramString3;
    AppUtil.mMac = paramString4;
  }
  
  public static void setDownloadWithoutWifi(boolean paramBoolean)
  {
    mDownloadWithoutWifi = paramBoolean;
  }
  
  public static void setOnlyDownload(boolean paramBoolean)
  {
    mOnlyDownload = paramBoolean;
  }
  
  public static void setQQBuildNumber(String paramString)
  {
    mQQBuildNumber = paramString;
  }
  
  public static void setTBSInstallingStatus(boolean paramBoolean)
  {
    mTBSInstalling = paramBoolean;
  }
  
  public static void setTbsListener(TbsListener paramTbsListener)
  {
    mTbsListener = paramTbsListener;
  }
  
  public static void setTbsLogClient(TbsLogClient paramTbsLogClient)
  {
    TbsLog.setTbsLogClient(paramTbsLogClient);
  }
  
  public static int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, android.webkit.ValueCallback<String> paramValueCallback)
  {
    TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 501);
    if (paramContext == null) {
      return -100;
    }
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    localX5CoreEngine.init(paramContext, null);
    if (localX5CoreEngine.isX5Core())
    {
      int i;
      if ((paramContext == null) || (!paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) || (getTbsVersion(paramContext) >= 25487))
      {
        i = localX5CoreEngine.wizard().startMiniQB(paramContext, paramString, paramHashMap, null, paramValueCallback);
        if (i != 0) {
          break label130;
        }
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 503);
      }
      for (;;)
      {
        Log.e("QbSdk", "startMiniQBToLoadUrl  ret = " + i);
        return i;
        return -101;
        label130:
        TbsLogReport.getInstance(paramContext).setLoadErrorCode(504, "" + i);
      }
    }
    TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 502);
    Log.e("QbSdk", "startMiniQBToLoadUrl  ret = -102");
    return -102;
  }
  
  public static boolean startQBForDoc(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationContext().getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt1));
    return MttLoader.openDocWithQb(paramContext, paramString1, paramInt2, paramString2, localHashMap, paramBundle);
  }
  
  public static boolean startQBForVideo(Context paramContext, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    return MttLoader.openVideoWithQb(paramContext, paramString, localHashMap);
  }
  
  public static boolean startQBToLoadurl(Context paramContext, String paramString, int paramInt, WebView paramWebView)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    WebView localWebView1 = paramWebView;
    if (paramWebView == null) {}
    try
    {
      Object localObject = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      if (localObject != "com.tencent.mm")
      {
        localWebView1 = paramWebView;
        if (localObject != "com.tencent.mobileqq") {}
      }
      else
      {
        localObject = X5CoreEngine.getInstance();
        localWebView1 = paramWebView;
        if (localObject != null)
        {
          localWebView1 = paramWebView;
          if (((X5CoreEngine)localObject).isX5Core())
          {
            localObject = ((X5CoreEngine)localObject).wizard().dexLoader().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
            localWebView1 = paramWebView;
            if (localObject != null)
            {
              localObject = (IX5WebViewBase)localObject;
              localWebView1 = paramWebView;
              if (localObject != null) {
                localWebView1 = (WebView)((IX5WebViewBase)localObject).getView().getParent();
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        WebView localWebView2 = paramWebView;
      }
    }
    return MttLoader.loadUrl(paramContext, paramString, localHashMap, "QbSdk.startQBToLoadurl", localWebView1) == 0;
  }
  
  public static boolean startQBWithBrowserlist(Context paramContext, String paramString, int paramInt)
  {
    boolean bool = startQBToLoadurl(paramContext, paramString, paramInt, null);
    if (!bool) {
      openBrowserList(paramContext, paramString, null);
    }
    return bool;
  }
  
  public static boolean startQbOrMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    if (paramContext == null) {
      return false;
    }
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    localX5CoreEngine.init(paramContext, null);
    if (((paramHashMap == null) || (!"5".equals(paramHashMap.get("PosID"))) || (!localX5CoreEngine.isX5Core()) || ((Bundle)localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]) == null)) || (MttLoader.loadUrl(paramContext, paramString, paramHashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0))
    {
      if (localX5CoreEngine.isX5Core()) {
        if ((paramContext == null) || (!paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) || (getTbsVersion(paramContext) >= 25487))
        {
          if (localX5CoreEngine.wizard().startMiniQB(paramContext, paramString, paramHashMap, null, paramValueCallback) == 0) {
            return true;
          }
        }
        else {
          return false;
        }
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public static void unForceSysWebView()
  {
    mIsSysWebViewForcedByOuter = false;
    TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
  }
  
  public static boolean useSoftWare()
  {
    if (sExtensionObj == null) {
      return false;
    }
    Object localObject2 = ReflectionUtils.invokeInstance(sExtensionObj, "useSoftWare", new Class[0], new Object[0]);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = sExtensionObj;
      localObject2 = Integer.TYPE;
      int i = DeviceInfo.getTotalRAM();
      localObject1 = ReflectionUtils.invokeInstance(localObject1, "useSoftWare", new Class[] { localObject2 }, new Object[] { Integer.valueOf(i) });
    }
    if (localObject1 == null) {}
    for (boolean bool = false;; bool = ((Boolean)localObject1).booleanValue()) {
      return bool;
    }
  }
  
  public static abstract interface PreInitCallback
  {
    public abstract void onCoreInitFinished();
    
    public abstract void onViewInitFinished(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk
 * JD-Core Version:    0.7.0.1
 */