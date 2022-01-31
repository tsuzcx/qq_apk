package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.ApkUtil;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class TbsShareManager
{
  static final String APP_VERSION = "app_version";
  static final String CORE_DISABLED = "core_disabled";
  static final String CORE_PACKAGENAME = "core_packagename";
  static final String CORE_PATH = "core_path";
  static final String CORE_VERSION = "core_version";
  static final int ENU_NEW_TBS_BACKUP_PATH = 4;
  private static final String TAG = "TbsShareManager";
  static final String TBS_PRIVATE_FOLDER_NAME = "core_private";
  private static boolean core_from_own = false;
  private static boolean core_info_already_read = false;
  private static boolean core_info_shared;
  private static String mAppVersion;
  private static String mAvailableCorePath;
  private static int mAvailableCoreVersion;
  private static boolean mCoreDiabled;
  public static boolean mHasQueryed;
  private static String mHostCorePathAppDefined = null;
  private static boolean mIsApkVersionSynced;
  private static String mSrcPackageName;
  private static Context sAppContext;
  private static boolean sIsThirdPartyApp;
  
  static
  {
    mHasQueryed = false;
    mAvailableCorePath = null;
    mAvailableCoreVersion = 0;
    mSrcPackageName = null;
    mCoreDiabled = false;
    mIsApkVersionSynced = false;
    core_info_shared = false;
    mAppVersion = null;
  }
  
  private static boolean checkCoreInOthers(Context paramContext)
  {
    if (QbSdk.getOnlyDownload()) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = getCoreProviderAppList();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((mAvailableCoreVersion > 0) && (mAvailableCoreVersion == getSharedTbsCoreVersion(paramContext, str)))
        {
          Context localContext = getPackageContext(paramContext, str, true);
          if (TbsInstaller.getInstance().vertificateApp(paramContext))
          {
            mAvailableCorePath = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext, localContext).getAbsolutePath();
            mSrcPackageName = str;
            return true;
          }
        }
        i += 1;
      }
    }
  }
  
  private static boolean checkCoreInfo(Context paramContext)
  {
    if (mSrcPackageName == null) {}
    while (mAvailableCoreVersion != getSharedTbsCoreVersion(paramContext, mSrcPackageName)) {
      return false;
    }
    return true;
  }
  
  private static boolean closeX5(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    writeProperties(paramContext, Integer.toString(0), "", "", Integer.toString(0));
    return true;
  }
  
  public static int findCoreForThirdPartyApp(Context paramContext)
  {
    loadProperties(paramContext);
    TbsLog.i("TbsShareManager", "core_info mAvailableCoreVersion is " + mAvailableCoreVersion + " mAvailableCorePath is " + mAvailableCorePath + " mSrcPackageName is " + mSrcPackageName);
    if (mSrcPackageName == null) {
      TbsLog.e("TbsShareManager", "mSrcPackageName is null !!!");
    }
    int i;
    if ((mSrcPackageName != null) && (mSrcPackageName.equals("AppDefined")))
    {
      if (mAvailableCoreVersion != TbsInstaller.getInstance().getTbsCoreVersionAppDefined(mHostCorePathAppDefined))
      {
        mAvailableCoreVersion = 0;
        mAvailableCorePath = null;
        mSrcPackageName = null;
        TbsLog.i("TbsShareManager", "check AppDefined core is error src is " + mAvailableCoreVersion + " dest is " + TbsInstaller.getInstance().getTbsCoreVersionAppDefined(mHostCorePathAppDefined));
      }
      if (mAvailableCoreVersion > 0)
      {
        ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
        if ((!"com.tencent.android.qqdownloader".equals(localApplicationInfo.packageName)) && (!"com.jd.jrapp".equals(localApplicationInfo.packageName))) {
          break label270;
        }
        i = 1;
        label189:
        if (i != 0) {
          break label275;
        }
      }
    }
    label270:
    label275:
    for (boolean bool = QbSdk.isX5Disabled(paramContext, mAvailableCoreVersion);; bool = false)
    {
      if ((bool) || (mCoreDiabled))
      {
        mAvailableCoreVersion = 0;
        mAvailableCorePath = null;
        mSrcPackageName = null;
        TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
      }
      return mAvailableCoreVersion;
      if ((checkCoreInfo(paramContext)) || (checkCoreInOthers(paramContext))) {
        break;
      }
      mAvailableCoreVersion = 0;
      mAvailableCorePath = null;
      mSrcPackageName = null;
      TbsLog.i("TbsShareManager", "core_info error checkCoreInfo is false and checkCoreInOthers is false ");
      break;
      i = 0;
      break label189;
    }
  }
  
  public static boolean forceLoadX5FromTBSDemo(Context paramContext)
  {
    return false;
  }
  
  public static void forceToLoadX5ForThirdApp(Context paramContext, boolean paramBoolean) {}
  
  static String getAvailableCorePath()
  {
    return mAvailableCorePath;
  }
  
  static Context getAvailableTbsCoreHostContext(Context paramContext)
  {
    Object localObject2 = null;
    isShareTbsCoreAvailable(paramContext);
    Object localObject1 = localObject2;
    if (mSrcPackageName != null)
    {
      localObject1 = getPackageContext(paramContext, mSrcPackageName, true);
      if (TbsInstaller.getInstance().vertificateApp((Context)localObject1)) {
        break label48;
      }
      localObject1 = localObject2;
    }
    label48:
    for (;;)
    {
      if (mHostCorePathAppDefined != null) {
        localObject1 = sAppContext;
      }
      return localObject1;
    }
  }
  
  static String getAvailableTbsCorePath(Context paramContext)
  {
    isShareTbsCoreAvailable(paramContext);
    return mAvailableCorePath;
  }
  
  static int getAvailableTbsCoreVersion(Context paramContext)
  {
    return getAvailableTbsCoreVersion(paramContext, true);
  }
  
  static int getAvailableTbsCoreVersion(Context paramContext, boolean paramBoolean)
  {
    isShareTbsCoreAvailable(paramContext, paramBoolean);
    return mAvailableCoreVersion;
  }
  
  public static File getBackupCoreFile(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new File(new File(FileUtil.getTBSSdcardFilePath(getPackageContext(paramContext, paramString, false), 4)), TbsDownloader.getBackupFileName(false));
      boolean bool = paramContext.exists();
      if (bool) {
        return paramContext;
      }
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static int getBackupCoreVersion(Context paramContext, String paramString)
  {
    int i = 0;
    try
    {
      paramContext = new File(new File(FileUtil.getTBSSdcardFilePath(getPackageContext(paramContext, paramString, false), 4)), TbsDownloader.getBackupFileName(false));
      if (paramContext.exists()) {
        i = ApkUtil.getApkVersionByReadFile(paramContext);
      }
      return i;
    }
    catch (Throwable paramContext) {}
    return 0;
  }
  
  public static File getBackupDecoupleCoreFile(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new File(new File(FileUtil.getTBSSdcardFilePath(getPackageContext(paramContext, paramString, true), 4)), TbsDownloader.getBackupFileName(true));
      boolean bool = paramContext.exists();
      if (bool) {
        return paramContext;
      }
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static int getBackupDecoupleCoreVersion(Context paramContext, String paramString)
  {
    int i = 0;
    try
    {
      paramContext = new File(new File(FileUtil.getTBSSdcardFilePath(getPackageContext(paramContext, paramString, false), 4)), TbsDownloader.getBackupFileName(true));
      if (paramContext.exists()) {
        i = ApkUtil.getApkVersionByReadFile(paramContext);
      }
      return i;
    }
    catch (Throwable paramContext) {}
    return 0;
  }
  
  public static boolean getCoreDisabled()
  {
    return mCoreDiabled;
  }
  
  public static boolean getCoreFormOwn()
  {
    return core_from_own;
  }
  
  public static String[] getCoreProviderAppList()
  {
    return new String[] { "com.tencent.tbs", "com.tencent.mm", "com.tencent.mobileqq", "com.qzone", "com.tencent.qqlite" };
  }
  
  public static int getCoreShareDecoupleCoreVersion(Context paramContext, String paramString)
  {
    return 0;
  }
  
  public static String getHostCorePathAppDefined()
  {
    return mHostCorePathAppDefined;
  }
  
  public static long getHostCoreVersions(Context paramContext)
  {
    String[] arrayOfString = getCoreProviderAppList();
    int j = arrayOfString.length;
    long l2 = 0L;
    int i = 0;
    if (i < j)
    {
      String str = arrayOfString[i];
      long l1;
      if (str.equalsIgnoreCase("com.tencent.mm")) {
        l1 = l2 + getSharedTbsCoreVersion(paramContext, str) * 10000000000L;
      }
      for (;;)
      {
        i += 1;
        l2 = l1;
        break;
        if (str.equalsIgnoreCase("com.tencent.mobileqq"))
        {
          l1 = l2 + getSharedTbsCoreVersion(paramContext, str) * 100000L;
        }
        else
        {
          l1 = l2;
          if (str.equalsIgnoreCase("com.qzone")) {
            l1 = l2 + getSharedTbsCoreVersion(paramContext, str);
          }
        }
      }
    }
    return l2;
  }
  
  public static Context getPackageContext(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if ((!paramContext.getPackageName().equals(paramString)) && (TbsPVConfig.getInstance(paramContext).isEnableNoCoreGray()))
      {
        TbsLog.i("TbsShareManager", "gray no core app,skip get context");
        return null;
      }
      paramContext = paramContext.createPackageContext(paramString, 2);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static int getSharedTbsCoreVersion(Context paramContext, String paramString)
  {
    paramContext = getPackageContext(paramContext, paramString, true);
    if (paramContext != null) {
      return TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext);
    }
    return 0;
  }
  
  private static String[] getSrcPackageNames(Context paramContext, boolean paramBoolean)
  {
    String[] arrayOfString;
    if (QbSdk.getOnlyDownload())
    {
      arrayOfString = new String[1];
      arrayOfString[0] = paramContext.getApplicationContext().getPackageName();
    }
    do
    {
      return arrayOfString;
      arrayOfString = getCoreProviderAppList();
    } while (!paramBoolean);
    return new String[] { paramContext.getApplicationContext().getPackageName() };
  }
  
  static String getTbsResourcesPath(Context paramContext)
  {
    try
    {
      loadProperties(paramContext);
      if (mAvailableCorePath != null)
      {
        if (TextUtils.isEmpty(mAvailableCorePath)) {
          return null;
        }
        paramContext = new StringBuilder(mAvailableCorePath);
        paramContext.append(File.separator);
        paramContext.append("res.apk");
        return paramContext.toString();
      }
    }
    catch (Throwable paramContext)
    {
      Log.e("", "getTbsResourcesPath exception: " + Log.getStackTraceString(paramContext));
    }
    return null;
  }
  
  public static File getTbsShareFile(Context paramContext, String paramString)
  {
    paramContext = TbsInstaller.getInstance().getTbsShareDir(paramContext);
    if (paramContext == null) {
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if ((paramContext != null) && (paramContext.exists())) {
      return paramContext;
    }
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private static void installCoreWithUnzip(Context paramContext, int paramInt)
  {
    String str;
    Object localObject;
    if ((!TbsPVConfig.getInstance(sAppContext).isDisableHostBackupCore()) && (TbsInstaller.getInstance().getTbsInstallingFileLock(paramContext)))
    {
      String[] arrayOfString = new String[5];
      arrayOfString[0] = "com.tencent.tbs";
      arrayOfString[1] = "com.tencent.mm";
      arrayOfString[2] = "com.tencent.mobileqq";
      arrayOfString[3] = "com.qzone";
      arrayOfString[4] = paramContext.getPackageName();
      TbsLog.i("TbsShareManager", "find host backup core to unzip #1" + Log.getStackTraceString(new Throwable()));
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        str = arrayOfString[i];
        if (paramInt != getBackupCoreVersion(paramContext, str)) {
          break label225;
        }
        localObject = getPackageContext(paramContext, str, false);
        if (!TbsInstaller.getInstance().vertificateApp((Context)localObject)) {}
        do
        {
          i += 1;
          break;
          localObject = getBackupCoreFile(paramContext, str);
        } while (!ApkUtil.verifyTbsApk(paramContext, (File)localObject, 0L, paramInt));
        TbsLog.i("TbsShareManager", "find host backup core to unzip normal coreVersion is " + paramInt + " packageName is " + str);
        TbsInstaller.getInstance().unzipTbsCoreToThirdAppTmpInThread(paramContext, (File)localObject, paramInt);
      }
    }
    for (;;)
    {
      TbsInstaller.getInstance().releaseTbsInstallingFileLock();
      return;
      label225:
      if (paramInt != getBackupDecoupleCoreVersion(paramContext, str)) {
        break;
      }
      localObject = getPackageContext(paramContext, str, false);
      if (!TbsInstaller.getInstance().vertificateApp((Context)localObject)) {
        break;
      }
      localObject = getBackupDecoupleCoreFile(paramContext, str);
      if (!ApkUtil.verifyTbsApk(paramContext, (File)localObject, 0L, paramInt)) {
        break;
      }
      TbsLog.i("TbsShareManager", "find host backup core to unzip decouple coreVersion is " + paramInt + " packageName is " + str);
      TbsInstaller.getInstance().unzipTbsCoreToThirdAppTmpInThread(paramContext, (File)localObject, paramInt);
    }
  }
  
  static boolean isShareTbsCoreAvailable(Context paramContext)
  {
    return isShareTbsCoreAvailable(paramContext, true);
  }
  
  static boolean isShareTbsCoreAvailable(Context paramContext, boolean paramBoolean)
  {
    if (isShareTbsCoreAvailableInner(paramContext)) {
      return true;
    }
    if (paramBoolean) {
      QbSdk.forceSysWebViewInner(paramContext, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
    }
    return false;
  }
  
  static boolean isShareTbsCoreAvailableInner(Context paramContext)
  {
    try
    {
      if (mAvailableCoreVersion == 0) {
        findCoreForThirdPartyApp(paramContext);
      }
      if (mAvailableCoreVersion == 0)
      {
        TbsLog.addLog(994, null, new Object[0]);
        return false;
      }
      if (mHostCorePathAppDefined == null)
      {
        if ((mAvailableCoreVersion != 0) && (getSharedTbsCoreVersion(paramContext, mSrcPackageName) == mAvailableCoreVersion)) {
          return true;
        }
      }
      else if ((mAvailableCoreVersion != 0) && (TbsInstaller.getInstance().getTbsCoreVersionAppDefined(mHostCorePathAppDefined) == mAvailableCoreVersion)) {
        return true;
      }
      if (checkCoreInOthers(paramContext)) {
        return true;
      }
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 418, new Throwable("mAvailableCoreVersion=" + mAvailableCoreVersion + "; mSrcPackageName=" + mSrcPackageName + "; getSharedTbsCoreVersion(ctx, mSrcPackageName) is " + getSharedTbsCoreVersion(paramContext, mSrcPackageName) + "; getHostCoreVersions is " + getHostCoreVersions(paramContext)));
      mAvailableCorePath = null;
      mAvailableCoreVersion = 0;
      TbsLog.addLog(993, null, new Object[0]);
      QbSdk.forceSysWebViewInner(paramContext, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
      return false;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      TbsLog.addLog(992, null, new Object[0]);
    }
    return false;
  }
  
  public static boolean isThirdPartyApp(Context paramContext)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((sAppContext != null) && (sAppContext.equals(paramContext.getApplicationContext()))) {
          return sIsThirdPartyApp;
        }
        sAppContext = paramContext.getApplicationContext();
        paramContext = sAppContext.getPackageName();
        String[] arrayOfString = getCoreProviderAppList();
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          if (!paramContext.equals(arrayOfString[i])) {
            break label78;
          }
          sIsThirdPartyApp = false;
          return false;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        sIsThirdPartyApp = true;
        return true;
      }
      label78:
      i += 1;
    }
  }
  
  /* Error */
  private static void loadProperties(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 68	com/tencent/smtt/sdk/TbsShareManager:core_info_already_read	Z
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: ldc 2
    //   9: monitorenter
    //   10: getstatic 68	com/tencent/smtt/sdk/TbsShareManager:core_info_already_read	Z
    //   13: ifeq +13 -> 26
    //   16: ldc 2
    //   18: monitorexit
    //   19: return
    //   20: astore_0
    //   21: ldc 2
    //   23: monitorexit
    //   24: aload_0
    //   25: athrow
    //   26: aload_0
    //   27: ldc_w 432
    //   30: invokestatic 434	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnonnull +27 -> 62
    //   38: iconst_0
    //   39: ifeq +11 -> 50
    //   42: new 436	java/lang/NullPointerException
    //   45: dup
    //   46: invokespecial 437	java/lang/NullPointerException:<init>	()V
    //   49: athrow
    //   50: ldc 2
    //   52: monitorexit
    //   53: return
    //   54: astore_0
    //   55: aload_0
    //   56: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   59: goto -9 -> 50
    //   62: new 439	java/io/BufferedInputStream
    //   65: dup
    //   66: new 441	java/io/FileInputStream
    //   69: dup
    //   70: aload_0
    //   71: invokespecial 444	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   74: invokespecial 447	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   77: astore_1
    //   78: aload_1
    //   79: astore_0
    //   80: new 449	java/util/Properties
    //   83: dup
    //   84: invokespecial 450	java/util/Properties:<init>	()V
    //   87: astore_2
    //   88: aload_1
    //   89: astore_0
    //   90: aload_2
    //   91: aload_1
    //   92: invokevirtual 453	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   95: aload_1
    //   96: astore_0
    //   97: aload_2
    //   98: ldc 20
    //   100: ldc 121
    //   102: invokevirtual 457	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   105: astore_3
    //   106: aload_1
    //   107: astore_0
    //   108: ldc 121
    //   110: aload_3
    //   111: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   114: ifne +67 -> 181
    //   117: aload_1
    //   118: astore_0
    //   119: aload_3
    //   120: invokestatic 460	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   123: iconst_0
    //   124: invokestatic 466	java/lang/Math:max	(II)I
    //   127: putstatic 54	com/tencent/smtt/sdk/TbsShareManager:mAvailableCoreVersion	I
    //   130: aload_1
    //   131: astore_0
    //   132: ldc 26
    //   134: new 133	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 468
    //   144: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: getstatic 54	com/tencent/smtt/sdk/TbsShareManager:mAvailableCoreVersion	I
    //   150: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: ldc_w 470
    //   156: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: new 227	java/lang/Throwable
    //   162: dup
    //   163: ldc_w 472
    //   166: invokespecial 419	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   169: invokestatic 335	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   172: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 155	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload_1
    //   182: astore_0
    //   183: aload_2
    //   184: ldc 14
    //   186: ldc 121
    //   188: invokevirtual 457	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   191: astore_3
    //   192: aload_1
    //   193: astore_0
    //   194: ldc 121
    //   196: aload_3
    //   197: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   200: ifne +9 -> 209
    //   203: aload_1
    //   204: astore_0
    //   205: aload_3
    //   206: putstatic 56	com/tencent/smtt/sdk/TbsShareManager:mSrcPackageName	Ljava/lang/String;
    //   209: aload_1
    //   210: astore_0
    //   211: getstatic 56	com/tencent/smtt/sdk/TbsShareManager:mSrcPackageName	Ljava/lang/String;
    //   214: ifnull +34 -> 248
    //   217: aload_1
    //   218: astore_0
    //   219: getstatic 214	com/tencent/smtt/sdk/TbsShareManager:sAppContext	Landroid/content/Context;
    //   222: ifnull +26 -> 248
    //   225: aload_1
    //   226: astore_0
    //   227: getstatic 56	com/tencent/smtt/sdk/TbsShareManager:mSrcPackageName	Ljava/lang/String;
    //   230: getstatic 214	com/tencent/smtt/sdk/TbsShareManager:sAppContext	Landroid/content/Context;
    //   233: invokevirtual 288	android/content/Context:getPackageName	()Ljava/lang/String;
    //   236: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   239: ifeq +100 -> 339
    //   242: aload_1
    //   243: astore_0
    //   244: iconst_1
    //   245: putstatic 66	com/tencent/smtt/sdk/TbsShareManager:core_from_own	Z
    //   248: aload_1
    //   249: astore_0
    //   250: aload_2
    //   251: ldc 17
    //   253: ldc 121
    //   255: invokevirtual 457	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   258: astore_3
    //   259: aload_1
    //   260: astore_0
    //   261: ldc 121
    //   263: aload_3
    //   264: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   267: ifne +9 -> 276
    //   270: aload_1
    //   271: astore_0
    //   272: aload_3
    //   273: putstatic 52	com/tencent/smtt/sdk/TbsShareManager:mAvailableCorePath	Ljava/lang/String;
    //   276: aload_1
    //   277: astore_0
    //   278: aload_2
    //   279: ldc 8
    //   281: ldc 121
    //   283: invokevirtual 457	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   286: astore_3
    //   287: aload_1
    //   288: astore_0
    //   289: ldc 121
    //   291: aload_3
    //   292: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   295: ifne +9 -> 304
    //   298: aload_1
    //   299: astore_0
    //   300: aload_3
    //   301: putstatic 64	com/tencent/smtt/sdk/TbsShareManager:mAppVersion	Ljava/lang/String;
    //   304: aload_1
    //   305: astore_0
    //   306: aload_2
    //   307: ldc 11
    //   309: ldc_w 474
    //   312: invokevirtual 457	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   315: invokestatic 479	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   318: putstatic 58	com/tencent/smtt/sdk/TbsShareManager:mCoreDiabled	Z
    //   321: aload_1
    //   322: astore_0
    //   323: iconst_1
    //   324: putstatic 68	com/tencent/smtt/sdk/TbsShareManager:core_info_already_read	Z
    //   327: aload_1
    //   328: ifnull +7 -> 335
    //   331: aload_1
    //   332: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   335: ldc 2
    //   337: monitorexit
    //   338: return
    //   339: aload_1
    //   340: astore_0
    //   341: iconst_0
    //   342: putstatic 66	com/tencent/smtt/sdk/TbsShareManager:core_from_own	Z
    //   345: goto -97 -> 248
    //   348: astore_2
    //   349: aload_1
    //   350: astore_0
    //   351: aload_2
    //   352: invokevirtual 426	java/lang/Throwable:printStackTrace	()V
    //   355: aload_1
    //   356: ifnull -21 -> 335
    //   359: aload_1
    //   360: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   363: goto -28 -> 335
    //   366: astore_0
    //   367: aload_0
    //   368: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   371: goto -36 -> 335
    //   374: astore_0
    //   375: aload_0
    //   376: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   379: goto -44 -> 335
    //   382: astore_1
    //   383: aconst_null
    //   384: astore_0
    //   385: aload_0
    //   386: ifnull +7 -> 393
    //   389: aload_0
    //   390: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   393: aload_1
    //   394: athrow
    //   395: astore_0
    //   396: aload_0
    //   397: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   400: goto -7 -> 393
    //   403: astore_1
    //   404: goto -19 -> 385
    //   407: astore_2
    //   408: aconst_null
    //   409: astore_1
    //   410: goto -61 -> 349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	paramContext	Context
    //   77	283	1	localBufferedInputStream	java.io.BufferedInputStream
    //   382	12	1	localObject1	Object
    //   403	1	1	localObject2	Object
    //   409	1	1	localObject3	Object
    //   87	220	2	localProperties	java.util.Properties
    //   348	4	2	localThrowable1	Throwable
    //   407	1	2	localThrowable2	Throwable
    //   105	196	3	str	String
    // Exception table:
    //   from	to	target	type
    //   10	19	20	finally
    //   21	24	20	finally
    //   42	50	20	finally
    //   50	53	20	finally
    //   55	59	20	finally
    //   331	335	20	finally
    //   335	338	20	finally
    //   359	363	20	finally
    //   367	371	20	finally
    //   375	379	20	finally
    //   389	393	20	finally
    //   393	395	20	finally
    //   396	400	20	finally
    //   42	50	54	java/lang/Exception
    //   80	88	348	java/lang/Throwable
    //   90	95	348	java/lang/Throwable
    //   97	106	348	java/lang/Throwable
    //   108	117	348	java/lang/Throwable
    //   119	130	348	java/lang/Throwable
    //   132	181	348	java/lang/Throwable
    //   183	192	348	java/lang/Throwable
    //   194	203	348	java/lang/Throwable
    //   205	209	348	java/lang/Throwable
    //   211	217	348	java/lang/Throwable
    //   219	225	348	java/lang/Throwable
    //   227	242	348	java/lang/Throwable
    //   244	248	348	java/lang/Throwable
    //   250	259	348	java/lang/Throwable
    //   261	270	348	java/lang/Throwable
    //   272	276	348	java/lang/Throwable
    //   278	287	348	java/lang/Throwable
    //   289	298	348	java/lang/Throwable
    //   300	304	348	java/lang/Throwable
    //   306	321	348	java/lang/Throwable
    //   323	327	348	java/lang/Throwable
    //   341	345	348	java/lang/Throwable
    //   359	363	366	java/lang/Exception
    //   331	335	374	java/lang/Exception
    //   26	34	382	finally
    //   62	78	382	finally
    //   389	393	395	java/lang/Exception
    //   80	88	403	finally
    //   90	95	403	finally
    //   97	106	403	finally
    //   108	117	403	finally
    //   119	130	403	finally
    //   132	181	403	finally
    //   183	192	403	finally
    //   194	203	403	finally
    //   205	209	403	finally
    //   211	217	403	finally
    //   219	225	403	finally
    //   227	242	403	finally
    //   244	248	403	finally
    //   250	259	403	finally
    //   261	270	403	finally
    //   272	276	403	finally
    //   278	287	403	finally
    //   289	298	403	finally
    //   300	304	403	finally
    //   306	321	403	finally
    //   323	327	403	finally
    //   341	345	403	finally
    //   351	355	403	finally
    //   26	34	407	java/lang/Throwable
    //   62	78	407	java/lang/Throwable
  }
  
  /* Error */
  private static void openX5(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: ldc_w 432
    //   10: invokestatic 434	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   13: astore 9
    //   15: aload 9
    //   17: ifnonnull +28 -> 45
    //   20: iconst_0
    //   21: ifeq +11 -> 32
    //   24: new 436	java/lang/NullPointerException
    //   27: dup
    //   28: invokespecial 437	java/lang/NullPointerException:<init>	()V
    //   31: athrow
    //   32: iconst_0
    //   33: ifeq +11 -> 44
    //   36: new 436	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 437	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: return
    //   45: new 439	java/io/BufferedInputStream
    //   48: dup
    //   49: new 441	java/io/FileInputStream
    //   52: dup
    //   53: aload 9
    //   55: invokespecial 444	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: invokespecial 447	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore_3
    //   62: new 449	java/util/Properties
    //   65: dup
    //   66: invokespecial 450	java/util/Properties:<init>	()V
    //   69: astore 6
    //   71: aload 6
    //   73: aload_3
    //   74: invokevirtual 453	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   77: aload 6
    //   79: ldc 11
    //   81: iconst_0
    //   82: invokestatic 486	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   85: invokevirtual 490	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   88: pop
    //   89: iload_1
    //   90: ifeq +61 -> 151
    //   93: invokestatic 98	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   96: aload_0
    //   97: invokevirtual 492	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   100: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   103: astore 8
    //   105: aload_0
    //   106: invokevirtual 314	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   109: invokevirtual 288	android/content/Context:getPackageName	()Ljava/lang/String;
    //   112: astore 7
    //   114: aload_0
    //   115: invokestatic 497	com/tencent/smtt/utils/AppUtil:getAppVersionCode	(Landroid/content/Context;)I
    //   118: istore_2
    //   119: aload 6
    //   121: ldc 14
    //   123: aload 7
    //   125: invokevirtual 490	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   128: pop
    //   129: aload 6
    //   131: ldc 17
    //   133: aload 8
    //   135: invokevirtual 490	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   138: pop
    //   139: aload 6
    //   141: ldc 8
    //   143: iload_2
    //   144: invokestatic 499	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   147: invokevirtual 490	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   150: pop
    //   151: new 501	java/io/BufferedOutputStream
    //   154: dup
    //   155: new 503	java/io/FileOutputStream
    //   158: dup
    //   159: aload 9
    //   161: invokespecial 504	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   164: invokespecial 507	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   167: astore_0
    //   168: aload 6
    //   170: aload_0
    //   171: aconst_null
    //   172: invokevirtual 511	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   175: aload_3
    //   176: ifnull +7 -> 183
    //   179: aload_3
    //   180: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   183: aload_0
    //   184: ifnull -140 -> 44
    //   187: aload_0
    //   188: invokevirtual 512	java/io/BufferedOutputStream:close	()V
    //   191: return
    //   192: astore_0
    //   193: return
    //   194: astore 4
    //   196: aconst_null
    //   197: astore_0
    //   198: aload 5
    //   200: astore_3
    //   201: aload 4
    //   203: invokevirtual 426	java/lang/Throwable:printStackTrace	()V
    //   206: aload_0
    //   207: ifnull +7 -> 214
    //   210: aload_0
    //   211: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   214: aload_3
    //   215: ifnull -171 -> 44
    //   218: aload_3
    //   219: invokevirtual 512	java/io/BufferedOutputStream:close	()V
    //   222: return
    //   223: astore_0
    //   224: return
    //   225: astore_0
    //   226: aconst_null
    //   227: astore_3
    //   228: aload_3
    //   229: ifnull +7 -> 236
    //   232: aload_3
    //   233: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   236: aload 4
    //   238: ifnull +8 -> 246
    //   241: aload 4
    //   243: invokevirtual 512	java/io/BufferedOutputStream:close	()V
    //   246: aload_0
    //   247: athrow
    //   248: astore_0
    //   249: goto -217 -> 32
    //   252: astore_0
    //   253: return
    //   254: astore_3
    //   255: goto -72 -> 183
    //   258: astore_0
    //   259: goto -45 -> 214
    //   262: astore_3
    //   263: goto -27 -> 236
    //   266: astore_3
    //   267: goto -21 -> 246
    //   270: astore_0
    //   271: goto -43 -> 228
    //   274: astore 5
    //   276: aload_0
    //   277: astore 4
    //   279: aload 5
    //   281: astore_0
    //   282: goto -54 -> 228
    //   285: astore 4
    //   287: aload_0
    //   288: astore 5
    //   290: aload 4
    //   292: astore_0
    //   293: aload_3
    //   294: astore 4
    //   296: aload 5
    //   298: astore_3
    //   299: goto -71 -> 228
    //   302: astore 4
    //   304: aload_3
    //   305: astore_0
    //   306: aload 5
    //   308: astore_3
    //   309: goto -108 -> 201
    //   312: astore 4
    //   314: aload_0
    //   315: astore 5
    //   317: aload_3
    //   318: astore_0
    //   319: aload 5
    //   321: astore_3
    //   322: goto -121 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	paramContext	Context
    //   0	325	1	paramBoolean	boolean
    //   118	26	2	i	int
    //   61	172	3	localObject1	Object
    //   254	1	3	localException1	Exception
    //   262	1	3	localException2	Exception
    //   266	28	3	localException3	Exception
    //   298	24	3	localContext1	Context
    //   1	1	4	localObject2	Object
    //   194	48	4	localThrowable1	Throwable
    //   277	1	4	localContext2	Context
    //   285	6	4	localObject3	Object
    //   294	1	4	localObject4	Object
    //   302	1	4	localThrowable2	Throwable
    //   312	1	4	localThrowable3	Throwable
    //   4	195	5	localObject5	Object
    //   274	6	5	localObject6	Object
    //   288	32	5	localContext3	Context
    //   69	100	6	localProperties	java.util.Properties
    //   112	12	7	str1	String
    //   103	31	8	str2	String
    //   13	147	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   187	191	192	java/lang/Exception
    //   6	15	194	java/lang/Throwable
    //   45	62	194	java/lang/Throwable
    //   218	222	223	java/lang/Exception
    //   6	15	225	finally
    //   45	62	225	finally
    //   24	32	248	java/lang/Exception
    //   36	44	252	java/lang/Exception
    //   179	183	254	java/lang/Exception
    //   210	214	258	java/lang/Exception
    //   232	236	262	java/lang/Exception
    //   241	246	266	java/lang/Exception
    //   62	89	270	finally
    //   93	151	270	finally
    //   151	168	270	finally
    //   168	175	274	finally
    //   201	206	285	finally
    //   62	89	302	java/lang/Throwable
    //   93	151	302	java/lang/Throwable
    //   151	168	302	java/lang/Throwable
    //   168	175	312	java/lang/Throwable
  }
  
  /* Error */
  static int readCoreVersionFromConfig(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 26
    //   7: ldc_w 515
    //   10: invokestatic 155	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: aconst_null
    //   14: astore 4
    //   16: aload_0
    //   17: ldc_w 432
    //   20: invokestatic 434	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   23: astore_0
    //   24: aload_0
    //   25: ifnonnull +46 -> 71
    //   28: ldc 26
    //   30: ldc_w 517
    //   33: invokestatic 155	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: iload_2
    //   37: istore_1
    //   38: iconst_0
    //   39: ifeq +11 -> 50
    //   42: new 436	java/lang/NullPointerException
    //   45: dup
    //   46: invokespecial 437	java/lang/NullPointerException:<init>	()V
    //   49: athrow
    //   50: ldc 2
    //   52: monitorexit
    //   53: iload_1
    //   54: ireturn
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   60: iload_2
    //   61: istore_1
    //   62: goto -12 -> 50
    //   65: astore_0
    //   66: ldc 2
    //   68: monitorexit
    //   69: aload_0
    //   70: athrow
    //   71: new 439	java/io/BufferedInputStream
    //   74: dup
    //   75: new 441	java/io/FileInputStream
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 444	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: invokespecial 447	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: astore_3
    //   87: new 449	java/util/Properties
    //   90: dup
    //   91: invokespecial 450	java/util/Properties:<init>	()V
    //   94: astore_0
    //   95: aload_0
    //   96: aload_3
    //   97: invokevirtual 453	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   100: aload_0
    //   101: ldc 20
    //   103: ldc 121
    //   105: invokevirtual 457	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_0
    //   109: ldc 121
    //   111: aload_0
    //   112: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: ifne +45 -> 160
    //   118: ldc 26
    //   120: ldc_w 519
    //   123: invokestatic 155	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_0
    //   127: invokestatic 460	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   130: iconst_0
    //   131: invokestatic 466	java/lang/Math:max	(II)I
    //   134: istore_2
    //   135: iload_2
    //   136: istore_1
    //   137: aload_3
    //   138: ifnull -88 -> 50
    //   141: aload_3
    //   142: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   145: iload_2
    //   146: istore_1
    //   147: goto -97 -> 50
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   155: iload_2
    //   156: istore_1
    //   157: goto -107 -> 50
    //   160: ldc 26
    //   162: ldc_w 521
    //   165: invokestatic 155	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: iload_2
    //   169: istore_1
    //   170: aload_3
    //   171: ifnull -121 -> 50
    //   174: aload_3
    //   175: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   178: iload_2
    //   179: istore_1
    //   180: goto -130 -> 50
    //   183: astore_0
    //   184: aload_0
    //   185: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   188: iload_2
    //   189: istore_1
    //   190: goto -140 -> 50
    //   193: astore_3
    //   194: aload 4
    //   196: astore_0
    //   197: aload_3
    //   198: invokevirtual 426	java/lang/Throwable:printStackTrace	()V
    //   201: aload_0
    //   202: ifnull +7 -> 209
    //   205: aload_0
    //   206: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   209: ldc 26
    //   211: ldc_w 523
    //   214: invokestatic 155	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: bipush 254
    //   219: istore_1
    //   220: goto -170 -> 50
    //   223: astore_0
    //   224: aload_0
    //   225: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   228: goto -19 -> 209
    //   231: astore_0
    //   232: aconst_null
    //   233: astore_3
    //   234: aload_3
    //   235: ifnull +7 -> 242
    //   238: aload_3
    //   239: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   242: aload_0
    //   243: athrow
    //   244: astore_3
    //   245: aload_3
    //   246: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   249: goto -7 -> 242
    //   252: astore_0
    //   253: goto -19 -> 234
    //   256: astore 4
    //   258: aload_0
    //   259: astore_3
    //   260: aload 4
    //   262: astore_0
    //   263: goto -29 -> 234
    //   266: astore 4
    //   268: aload_3
    //   269: astore_0
    //   270: aload 4
    //   272: astore_3
    //   273: goto -76 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramContext	Context
    //   37	183	1	i	int
    //   1	188	2	j	int
    //   86	89	3	localBufferedInputStream	java.io.BufferedInputStream
    //   193	5	3	localThrowable1	Throwable
    //   233	6	3	localObject1	Object
    //   244	2	3	localException	Exception
    //   259	14	3	localObject2	Object
    //   14	181	4	localObject3	Object
    //   256	5	4	localObject4	Object
    //   266	5	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   42	50	55	java/lang/Exception
    //   5	13	65	finally
    //   42	50	65	finally
    //   56	60	65	finally
    //   141	145	65	finally
    //   151	155	65	finally
    //   174	178	65	finally
    //   184	188	65	finally
    //   205	209	65	finally
    //   209	217	65	finally
    //   224	228	65	finally
    //   238	242	65	finally
    //   242	244	65	finally
    //   245	249	65	finally
    //   141	145	150	java/lang/Exception
    //   174	178	183	java/lang/Exception
    //   16	24	193	java/lang/Throwable
    //   28	36	193	java/lang/Throwable
    //   71	87	193	java/lang/Throwable
    //   205	209	223	java/lang/Exception
    //   16	24	231	finally
    //   28	36	231	finally
    //   71	87	231	finally
    //   238	242	244	java/lang/Exception
    //   87	135	252	finally
    //   160	168	252	finally
    //   197	201	256	finally
    //   87	135	266	java/lang/Throwable
    //   160	168	266	java/lang/Throwable
  }
  
  /* Error */
  static String readPackageNameFromConfig(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: aload_0
    //   7: ldc_w 432
    //   10: invokestatic 434	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull +23 -> 38
    //   18: aload 4
    //   20: astore_0
    //   21: iconst_0
    //   22: ifeq +11 -> 33
    //   25: new 436	java/lang/NullPointerException
    //   28: dup
    //   29: invokespecial 437	java/lang/NullPointerException:<init>	()V
    //   32: athrow
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: areturn
    //   38: new 439	java/io/BufferedInputStream
    //   41: dup
    //   42: new 441	java/io/FileInputStream
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 444	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   50: invokespecial 447	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   53: astore_2
    //   54: aload_2
    //   55: astore_0
    //   56: new 449	java/util/Properties
    //   59: dup
    //   60: invokespecial 450	java/util/Properties:<init>	()V
    //   63: astore_3
    //   64: aload_2
    //   65: astore_0
    //   66: aload_3
    //   67: aload_2
    //   68: invokevirtual 453	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   71: aload_2
    //   72: astore_0
    //   73: aload_3
    //   74: ldc 14
    //   76: ldc 121
    //   78: invokevirtual 457	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: astore_3
    //   82: aload_2
    //   83: astore_0
    //   84: ldc 121
    //   86: aload_3
    //   87: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: istore_1
    //   91: iload_1
    //   92: ifne +16 -> 108
    //   95: aload_2
    //   96: ifnull +7 -> 103
    //   99: aload_2
    //   100: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   103: aload_3
    //   104: astore_0
    //   105: goto -72 -> 33
    //   108: aload 4
    //   110: astore_0
    //   111: aload_2
    //   112: ifnull -79 -> 33
    //   115: aload_2
    //   116: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   119: aload 4
    //   121: astore_0
    //   122: goto -89 -> 33
    //   125: astore_0
    //   126: aload 4
    //   128: astore_0
    //   129: goto -96 -> 33
    //   132: astore_3
    //   133: aconst_null
    //   134: astore_2
    //   135: aload_2
    //   136: astore_0
    //   137: aload_3
    //   138: invokevirtual 426	java/lang/Throwable:printStackTrace	()V
    //   141: aload 4
    //   143: astore_0
    //   144: aload_2
    //   145: ifnull -112 -> 33
    //   148: aload_2
    //   149: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   152: aload 4
    //   154: astore_0
    //   155: goto -122 -> 33
    //   158: astore_0
    //   159: aload 4
    //   161: astore_0
    //   162: goto -129 -> 33
    //   165: astore_2
    //   166: aconst_null
    //   167: astore_0
    //   168: aload_0
    //   169: ifnull +7 -> 176
    //   172: aload_0
    //   173: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   176: aload_2
    //   177: athrow
    //   178: astore_0
    //   179: ldc 2
    //   181: monitorexit
    //   182: aload_0
    //   183: athrow
    //   184: astore_0
    //   185: aload 4
    //   187: astore_0
    //   188: goto -155 -> 33
    //   191: astore_0
    //   192: goto -89 -> 103
    //   195: astore_0
    //   196: goto -20 -> 176
    //   199: astore_2
    //   200: goto -32 -> 168
    //   203: astore_3
    //   204: goto -69 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	paramContext	Context
    //   90	2	1	bool	boolean
    //   53	96	2	localBufferedInputStream	java.io.BufferedInputStream
    //   165	12	2	localObject1	Object
    //   199	1	2	localObject2	Object
    //   63	41	3	localObject3	Object
    //   132	6	3	localThrowable1	Throwable
    //   203	1	3	localThrowable2	Throwable
    //   1	185	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   115	119	125	java/lang/Exception
    //   6	14	132	java/lang/Throwable
    //   38	54	132	java/lang/Throwable
    //   148	152	158	java/lang/Exception
    //   6	14	165	finally
    //   38	54	165	finally
    //   25	33	178	finally
    //   99	103	178	finally
    //   115	119	178	finally
    //   148	152	178	finally
    //   172	176	178	finally
    //   176	178	178	finally
    //   25	33	184	java/lang/Exception
    //   99	103	191	java/lang/Exception
    //   172	176	195	java/lang/Exception
    //   56	64	199	finally
    //   66	71	199	finally
    //   73	82	199	finally
    //   84	91	199	finally
    //   137	141	199	finally
    //   56	64	203	java/lang/Throwable
    //   66	71	203	java/lang/Throwable
    //   73	82	203	java/lang/Throwable
    //   84	91	203	java/lang/Throwable
  }
  
  public static void setHostCorePathAppDefined(String paramString)
  {
    mHostCorePathAppDefined = paramString;
  }
  
  private static void shareAllDirsAndFiles(Context paramContext, TbsLinuxToolsJni paramTbsLinuxToolsJni, File paramFile)
  {
    TbsLog.i("TbsShareManager", "shareAllDirsAndFiles #1");
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {
      return;
    }
    TbsLog.i("TbsShareManager", "shareAllDirsAndFiles dir is " + paramFile.getAbsolutePath());
    paramTbsLinuxToolsJni.Chmod(paramFile.getAbsolutePath(), "755");
    paramFile = paramFile.listFiles();
    int j = paramFile.length;
    int i = 0;
    label78:
    File localFile;
    if (i < j)
    {
      localFile = paramFile[i];
      if (!localFile.isFile()) {
        break label147;
      }
      if (localFile.getAbsolutePath().indexOf(".so") <= 0) {
        break label131;
      }
      paramTbsLinuxToolsJni.Chmod(localFile.getAbsolutePath(), "755");
    }
    for (;;)
    {
      i += 1;
      break label78;
      break;
      label131:
      paramTbsLinuxToolsJni.Chmod(localFile.getAbsolutePath(), "644");
      continue;
      label147:
      if (localFile.isDirectory()) {
        shareAllDirsAndFiles(paramContext, paramTbsLinuxToolsJni, localFile);
      } else {
        TbsLog.e("TbsShareManager", "unknown file type.", true);
      }
    }
  }
  
  static void shareCoreShareDecouple(Context paramContext)
  {
    try
    {
      shareAllDirsAndFiles(paramContext, new TbsLinuxToolsJni(paramContext), TbsInstaller.getInstance().getCoreShareDecoupleDir(paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  static void shareTbsCore(Context paramContext)
  {
    TbsLog.i("TbsShareManager", "shareTbsCore #1");
    try
    {
      TbsLinuxToolsJni localTbsLinuxToolsJni = new TbsLinuxToolsJni(paramContext);
      shareAllDirsAndFiles(paramContext, localTbsLinuxToolsJni, TbsInstaller.getInstance().getTbsCoreShareDir(paramContext));
      paramContext = TbsInstaller.getInstance().getTbsShareDir(paramContext);
      TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir is " + paramContext.getAbsolutePath());
      localTbsLinuxToolsJni.Chmod(paramContext.getAbsolutePath(), "755");
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir error is " + paramContext.getMessage() + " ## " + paramContext.getCause());
      paramContext.printStackTrace();
    }
  }
  
  public static void writeCoreInfoForThirdPartyApp(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int k = 0;
    label152:
    Object localObject1;
    Object localObject2;
    int j;
    label378:
    Object localObject3;
    for (;;)
    {
      try
      {
        TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersion is " + paramInt);
        if (paramInt == 0)
        {
          closeX5(paramContext);
          TbsDownloadConfig.getInstance(sAppContext).setDownloadInterruptCode(-401);
          return;
        }
        i = readCoreVersionFromConfig(paramContext);
        TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromConfig is " + i);
        if (i < 0)
        {
          TbsDownloadConfig.getInstance(sAppContext).setDownloadInterruptCode(-402);
          continue;
        }
        if (paramInt != i) {
          break label152;
        }
      }
      finally {}
      if ((getAvailableTbsCoreVersion(paramContext) == 0) && (!paramBoolean)) {
        installCoreWithUnzip(paramContext, paramInt);
      }
      openX5(paramContext, paramBoolean);
      TbsDownloadConfig.getInstance(sAppContext).setDownloadInterruptCode(-403);
      continue;
      if (paramInt < i)
      {
        closeX5(paramContext);
        TbsDownloadConfig.getInstance(sAppContext).setDownloadInterruptCode(-404);
      }
      else
      {
        i = TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext);
        TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromCoreShare is " + i);
        if (paramInt < i)
        {
          closeX5(paramContext);
          TbsDownloadConfig.getInstance(sAppContext).setDownloadInterruptCode(-404);
        }
        else
        {
          localObject1 = getSrcPackageNames(paramContext, paramBoolean);
          if (mHostCorePathAppDefined == null) {
            break;
          }
          if (paramInt == TbsInstaller.getInstance().getTbsCoreVersionAppDefined(mHostCorePathAppDefined))
          {
            writeProperties(paramContext, Integer.toString(paramInt), "AppDefined", mHostCorePathAppDefined, Integer.toString(1));
            try
            {
              localObject1 = getTbsShareFile(paramContext, "core_info");
              if ((core_info_shared) || (localObject1 == null)) {
                continue;
              }
              localObject2 = new TbsLinuxToolsJni(sAppContext);
              ((TbsLinuxToolsJni)localObject2).Chmod(((File)localObject1).getAbsolutePath(), "644");
              ((TbsLinuxToolsJni)localObject2).Chmod(TbsInstaller.getInstance().getTbsShareDir(paramContext).getAbsolutePath(), "755");
              core_info_shared = true;
            }
            catch (Throwable paramContext)
            {
              paramContext.printStackTrace();
            }
          }
          else
          {
            if (paramInt <= TbsInstaller.getInstance().getTbsCoreVersionAppDefined(mHostCorePathAppDefined)) {
              break;
            }
            j = localObject1.length;
            i = 0;
            if (i >= j) {
              break;
            }
            localObject2 = localObject1[i];
            if (paramInt != getSharedTbsCoreVersion(paramContext, (String)localObject2)) {
              break label824;
            }
            localObject3 = getPackageContext(paramContext, (String)localObject2, true);
            localObject2 = TbsInstaller.getInstance().getTbsCoreShareDir((Context)localObject3).getAbsolutePath();
            AppUtil.getAppVersionCode(paramContext);
            if (!TbsInstaller.getInstance().vertificateApp((Context)localObject3)) {
              break label824;
            }
            localObject1 = new File(mHostCorePathAppDefined);
            localObject2 = new File((String)localObject2);
            localObject3 = new TbsShareManager.1();
            try
            {
              FileUtil.copyFiles((File)localObject2, (File)localObject1, (FileFilter)localObject3);
              writeProperties(paramContext, Integer.toString(paramInt), "AppDefined", mHostCorePathAppDefined, Integer.toString(1));
              localObject1 = getTbsShareFile(paramContext, "core_info");
              if ((!core_info_shared) && (localObject1 != null))
              {
                localObject2 = new TbsLinuxToolsJni(sAppContext);
                ((TbsLinuxToolsJni)localObject2).Chmod(((File)localObject1).getAbsolutePath(), "644");
                ((TbsLinuxToolsJni)localObject2).Chmod(TbsInstaller.getInstance().getTbsShareDir(paramContext).getAbsolutePath(), "755");
                core_info_shared = true;
              }
            }
            catch (Throwable paramContext)
            {
              paramContext.printStackTrace();
            }
          }
        }
      }
    }
    int m = localObject1.length;
    int i = 0;
    for (;;)
    {
      j = k;
      if (i < m)
      {
        localObject2 = localObject1[i];
        if (paramInt == getSharedTbsCoreVersion(paramContext, (String)localObject2))
        {
          localObject3 = getPackageContext(paramContext, (String)localObject2, true);
          String str = TbsInstaller.getInstance().getTbsCoreShareDir((Context)localObject3).getAbsolutePath();
          j = AppUtil.getAppVersionCode(paramContext);
          if (TbsInstaller.getInstance().vertificateApp((Context)localObject3))
          {
            if (!((String)localObject2).equals(paramContext.getApplicationContext().getPackageName()))
            {
              TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + paramInt);
              TbsCoreVerManager.getInstance(sAppContext).setStatus("remove_old_core", 1);
            }
            writeProperties(paramContext, Integer.toString(paramInt), (String)localObject2, str, Integer.toString(j));
          }
        }
      }
      else
      {
        try
        {
          localObject1 = getTbsShareFile(paramContext, "core_info");
          if ((!core_info_shared) && (localObject1 != null))
          {
            localObject2 = new TbsLinuxToolsJni(sAppContext);
            ((TbsLinuxToolsJni)localObject2).Chmod(((File)localObject1).getAbsolutePath(), "644");
            ((TbsLinuxToolsJni)localObject2).Chmod(TbsInstaller.getInstance().getTbsShareDir(paramContext).getAbsolutePath(), "755");
            core_info_shared = true;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localThrowable.printStackTrace();
          }
        }
        j = 1;
        if ((j != 0) || (paramBoolean)) {
          break;
        }
        installCoreWithUnzip(paramContext, paramInt);
        break;
        label824:
        i += 1;
        break label378;
      }
      i += 1;
    }
  }
  
  /* Error */
  public static void writeProperties(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 5
    //   9: ldc 26
    //   11: new 133	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 638
    //   21: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc_w 640
    //   31: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 642
    //   41: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_3
    //   45: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 155	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: ldc 26
    //   56: new 133	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 644
    //   66: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: new 227	java/lang/Throwable
    //   72: dup
    //   73: ldc_w 472
    //   76: invokespecial 419	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   79: invokestatic 335	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   82: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 155	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_0
    //   92: ldc_w 432
    //   95: invokestatic 434	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   98: astore 11
    //   100: aload 11
    //   102: ifnonnull +54 -> 156
    //   105: getstatic 214	com/tencent/smtt/sdk/TbsShareManager:sAppContext	Landroid/content/Context;
    //   108: invokestatic 598	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   111: sipush -405
    //   114: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   117: iconst_0
    //   118: ifeq +11 -> 129
    //   121: new 436	java/lang/NullPointerException
    //   124: dup
    //   125: invokespecial 437	java/lang/NullPointerException:<init>	()V
    //   128: athrow
    //   129: iconst_0
    //   130: ifeq +11 -> 141
    //   133: new 436	java/lang/NullPointerException
    //   136: dup
    //   137: invokespecial 437	java/lang/NullPointerException:<init>	()V
    //   140: athrow
    //   141: return
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   147: goto -18 -> 129
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   155: return
    //   156: new 439	java/io/BufferedInputStream
    //   159: dup
    //   160: new 441	java/io/FileInputStream
    //   163: dup
    //   164: aload 11
    //   166: invokespecial 444	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   169: invokespecial 447	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   172: astore 7
    //   174: new 449	java/util/Properties
    //   177: dup
    //   178: invokespecial 450	java/util/Properties:<init>	()V
    //   181: astore 10
    //   183: aload 10
    //   185: aload 7
    //   187: invokevirtual 453	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   190: aload_1
    //   191: invokestatic 460	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   194: istore 6
    //   196: iload 6
    //   198: istore 5
    //   200: iload 5
    //   202: ifeq +117 -> 319
    //   205: aload 10
    //   207: ldc 20
    //   209: aload_1
    //   210: invokevirtual 490	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   213: pop
    //   214: aload 10
    //   216: ldc 11
    //   218: iconst_0
    //   219: invokestatic 486	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   222: invokevirtual 490	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   225: pop
    //   226: aload 10
    //   228: ldc 14
    //   230: aload_2
    //   231: invokevirtual 490	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   234: pop
    //   235: aload 10
    //   237: ldc 17
    //   239: aload_3
    //   240: invokevirtual 490	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   243: pop
    //   244: aload 10
    //   246: ldc 8
    //   248: aload 4
    //   250: invokevirtual 490	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   253: pop
    //   254: new 501	java/io/BufferedOutputStream
    //   257: dup
    //   258: new 503	java/io/FileOutputStream
    //   261: dup
    //   262: aload 11
    //   264: invokespecial 504	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   267: invokespecial 507	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   270: astore_0
    //   271: aload 10
    //   273: aload_0
    //   274: aconst_null
    //   275: invokevirtual 511	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   278: iconst_0
    //   279: putstatic 68	com/tencent/smtt/sdk/TbsShareManager:core_info_already_read	Z
    //   282: getstatic 214	com/tencent/smtt/sdk/TbsShareManager:sAppContext	Landroid/content/Context;
    //   285: invokestatic 598	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   288: sipush -406
    //   291: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   294: aload 7
    //   296: ifnull +8 -> 304
    //   299: aload 7
    //   301: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   304: aload_0
    //   305: ifnull -164 -> 141
    //   308: aload_0
    //   309: invokevirtual 512	java/io/BufferedOutputStream:close	()V
    //   312: return
    //   313: astore_0
    //   314: aload_0
    //   315: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   318: return
    //   319: aload 10
    //   321: ldc 11
    //   323: iconst_1
    //   324: invokestatic 486	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   327: invokevirtual 490	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   330: pop
    //   331: goto -77 -> 254
    //   334: astore_2
    //   335: aload 7
    //   337: astore_0
    //   338: aload 8
    //   340: astore_1
    //   341: aload_2
    //   342: invokevirtual 426	java/lang/Throwable:printStackTrace	()V
    //   345: aload_0
    //   346: ifnull +7 -> 353
    //   349: aload_0
    //   350: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   353: aload_1
    //   354: ifnull -213 -> 141
    //   357: aload_1
    //   358: invokevirtual 512	java/io/BufferedOutputStream:close	()V
    //   361: return
    //   362: astore_0
    //   363: aload_0
    //   364: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   367: return
    //   368: astore_1
    //   369: aload_1
    //   370: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   373: goto -69 -> 304
    //   376: astore_0
    //   377: aload_0
    //   378: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   381: goto -28 -> 353
    //   384: astore_0
    //   385: aconst_null
    //   386: astore 7
    //   388: aload 9
    //   390: astore_1
    //   391: aload 7
    //   393: ifnull +8 -> 401
    //   396: aload 7
    //   398: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   401: aload_1
    //   402: ifnull +7 -> 409
    //   405: aload_1
    //   406: invokevirtual 512	java/io/BufferedOutputStream:close	()V
    //   409: aload_0
    //   410: athrow
    //   411: astore_2
    //   412: aload_2
    //   413: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   416: goto -15 -> 401
    //   419: astore_1
    //   420: aload_1
    //   421: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   424: goto -15 -> 409
    //   427: astore_0
    //   428: goto -228 -> 200
    //   431: astore_0
    //   432: aload 9
    //   434: astore_1
    //   435: goto -44 -> 391
    //   438: astore_2
    //   439: aload_0
    //   440: astore_1
    //   441: aload_2
    //   442: astore_0
    //   443: goto -52 -> 391
    //   446: astore_2
    //   447: aload_0
    //   448: astore 7
    //   450: aload_2
    //   451: astore_0
    //   452: goto -61 -> 391
    //   455: astore_2
    //   456: aconst_null
    //   457: astore_0
    //   458: aload 8
    //   460: astore_1
    //   461: goto -120 -> 341
    //   464: astore_2
    //   465: aload_0
    //   466: astore_1
    //   467: aload 7
    //   469: astore_0
    //   470: goto -129 -> 341
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	473	0	paramContext	Context
    //   0	473	1	paramString1	String
    //   0	473	2	paramString2	String
    //   0	473	3	paramString3	String
    //   0	473	4	paramString4	String
    //   7	194	5	i	int
    //   194	3	6	j	int
    //   172	296	7	localObject1	Object
    //   4	455	8	localObject2	Object
    //   1	432	9	localObject3	Object
    //   181	139	10	localProperties	java.util.Properties
    //   98	165	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   121	129	142	java/lang/Exception
    //   133	141	150	java/lang/Exception
    //   308	312	313	java/lang/Exception
    //   174	190	334	java/lang/Throwable
    //   190	196	334	java/lang/Throwable
    //   205	254	334	java/lang/Throwable
    //   254	271	334	java/lang/Throwable
    //   319	331	334	java/lang/Throwable
    //   357	361	362	java/lang/Exception
    //   299	304	368	java/lang/Exception
    //   349	353	376	java/lang/Exception
    //   91	100	384	finally
    //   105	117	384	finally
    //   156	174	384	finally
    //   396	401	411	java/lang/Exception
    //   405	409	419	java/lang/Exception
    //   190	196	427	java/lang/Exception
    //   174	190	431	finally
    //   190	196	431	finally
    //   205	254	431	finally
    //   254	271	431	finally
    //   319	331	431	finally
    //   271	294	438	finally
    //   341	345	446	finally
    //   91	100	455	java/lang/Throwable
    //   105	117	455	java/lang/Throwable
    //   156	174	455	java/lang/Throwable
    //   271	294	464	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsShareManager
 * JD-Core Version:    0.7.0.1
 */