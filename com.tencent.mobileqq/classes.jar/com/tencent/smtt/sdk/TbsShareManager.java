package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;
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
  private static final String TAG = "TbsShareManager";
  static final String TBS_FOLDER_NAME = "tbs";
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
          Context localContext = getPackageContext(paramContext, str);
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
  
  static Context getAvailableTbsCoreHostContext(Context paramContext)
  {
    isShareTbsCoreAvailable(paramContext);
    if (mSrcPackageName != null)
    {
      paramContext = getPackageContext(paramContext, mSrcPackageName);
      if (TbsInstaller.getInstance().vertificateApp(paramContext)) {}
    }
    else
    {
      return null;
    }
    return paramContext;
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
    return new String[] { "com.tencent.tbs", "com.tencent.mm", "com.tencent.mobileqq", "com.qzone" };
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
  
  static Context getPackageContext(Context paramContext, String paramString)
  {
    try
    {
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
    paramContext = getPackageContext(paramContext, paramString);
    if (paramContext != null) {
      return TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext);
    }
    return 0;
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
  
  private static File getTbsShareFile(Context paramContext, String paramString)
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
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 68	com/tencent/smtt/sdk/TbsShareManager:core_info_already_read	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: ldc_w 358
    //   19: invokestatic 360	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   22: astore_0
    //   23: aload_0
    //   24: ifnonnull +29 -> 53
    //   27: iconst_0
    //   28: ifeq -17 -> 11
    //   31: new 362	java/lang/NullPointerException
    //   34: dup
    //   35: invokespecial 363	java/lang/NullPointerException:<init>	()V
    //   38: athrow
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   44: goto -33 -> 11
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    //   53: new 365	java/io/BufferedInputStream
    //   56: dup
    //   57: new 367	java/io/FileInputStream
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 370	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   65: invokespecial 373	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   68: astore_2
    //   69: aload_2
    //   70: astore_0
    //   71: new 375	java/util/Properties
    //   74: dup
    //   75: invokespecial 376	java/util/Properties:<init>	()V
    //   78: astore_3
    //   79: aload_2
    //   80: astore_0
    //   81: aload_3
    //   82: aload_2
    //   83: invokevirtual 379	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   86: aload_2
    //   87: astore_0
    //   88: aload_3
    //   89: ldc 22
    //   91: ldc 121
    //   93: invokevirtual 383	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 4
    //   98: aload_2
    //   99: astore_0
    //   100: ldc 121
    //   102: aload 4
    //   104: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifne +17 -> 124
    //   110: aload_2
    //   111: astore_0
    //   112: aload 4
    //   114: invokestatic 386	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   117: iconst_0
    //   118: invokestatic 392	java/lang/Math:max	(II)I
    //   121: putstatic 56	com/tencent/smtt/sdk/TbsShareManager:mAvailableCoreVersion	I
    //   124: aload_2
    //   125: astore_0
    //   126: aload_3
    //   127: ldc 16
    //   129: ldc 121
    //   131: invokevirtual 383	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   134: astore 4
    //   136: aload_2
    //   137: astore_0
    //   138: ldc 121
    //   140: aload 4
    //   142: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   145: ifne +10 -> 155
    //   148: aload_2
    //   149: astore_0
    //   150: aload 4
    //   152: putstatic 58	com/tencent/smtt/sdk/TbsShareManager:mSrcPackageName	Ljava/lang/String;
    //   155: aload_2
    //   156: astore_0
    //   157: getstatic 58	com/tencent/smtt/sdk/TbsShareManager:mSrcPackageName	Ljava/lang/String;
    //   160: ifnull +34 -> 194
    //   163: aload_2
    //   164: astore_0
    //   165: getstatic 346	com/tencent/smtt/sdk/TbsShareManager:sAppContext	Landroid/content/Context;
    //   168: ifnull +26 -> 194
    //   171: aload_2
    //   172: astore_0
    //   173: getstatic 58	com/tencent/smtt/sdk/TbsShareManager:mSrcPackageName	Ljava/lang/String;
    //   176: getstatic 346	com/tencent/smtt/sdk/TbsShareManager:sAppContext	Landroid/content/Context;
    //   179: invokevirtual 356	android/content/Context:getPackageName	()Ljava/lang/String;
    //   182: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   185: ifeq +113 -> 298
    //   188: aload_2
    //   189: astore_0
    //   190: iconst_1
    //   191: putstatic 66	com/tencent/smtt/sdk/TbsShareManager:core_from_own	Z
    //   194: aload_2
    //   195: astore_0
    //   196: aload_3
    //   197: ldc 19
    //   199: ldc 121
    //   201: invokevirtual 383	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   204: astore 4
    //   206: aload_2
    //   207: astore_0
    //   208: ldc 121
    //   210: aload 4
    //   212: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifne +10 -> 225
    //   218: aload_2
    //   219: astore_0
    //   220: aload 4
    //   222: putstatic 54	com/tencent/smtt/sdk/TbsShareManager:mAvailableCorePath	Ljava/lang/String;
    //   225: aload_2
    //   226: astore_0
    //   227: aload_3
    //   228: ldc 10
    //   230: ldc 121
    //   232: invokevirtual 383	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   235: astore 4
    //   237: aload_2
    //   238: astore_0
    //   239: ldc 121
    //   241: aload 4
    //   243: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   246: ifne +10 -> 256
    //   249: aload_2
    //   250: astore_0
    //   251: aload 4
    //   253: putstatic 64	com/tencent/smtt/sdk/TbsShareManager:mAppVersion	Ljava/lang/String;
    //   256: aload_2
    //   257: astore_0
    //   258: aload_3
    //   259: ldc 13
    //   261: ldc_w 394
    //   264: invokevirtual 383	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   267: invokestatic 399	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   270: putstatic 60	com/tencent/smtt/sdk/TbsShareManager:mCoreDiabled	Z
    //   273: aload_2
    //   274: astore_0
    //   275: iconst_1
    //   276: putstatic 68	com/tencent/smtt/sdk/TbsShareManager:core_info_already_read	Z
    //   279: aload_2
    //   280: ifnull -269 -> 11
    //   283: aload_2
    //   284: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   287: goto -276 -> 11
    //   290: astore_0
    //   291: aload_0
    //   292: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   295: goto -284 -> 11
    //   298: aload_2
    //   299: astore_0
    //   300: iconst_0
    //   301: putstatic 66	com/tencent/smtt/sdk/TbsShareManager:core_from_own	Z
    //   304: goto -110 -> 194
    //   307: astore_3
    //   308: aload_2
    //   309: astore_0
    //   310: aload_3
    //   311: invokevirtual 343	java/lang/Throwable:printStackTrace	()V
    //   314: aload_2
    //   315: ifnull -304 -> 11
    //   318: aload_2
    //   319: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   322: goto -311 -> 11
    //   325: astore_0
    //   326: aload_0
    //   327: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   330: goto -319 -> 11
    //   333: astore_2
    //   334: aconst_null
    //   335: astore_0
    //   336: aload_0
    //   337: ifnull +7 -> 344
    //   340: aload_0
    //   341: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   344: aload_2
    //   345: athrow
    //   346: astore_0
    //   347: aload_0
    //   348: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   351: goto -7 -> 344
    //   354: astore_2
    //   355: goto -19 -> 336
    //   358: astore_3
    //   359: aconst_null
    //   360: astore_2
    //   361: goto -53 -> 308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	paramContext	Context
    //   6	2	1	bool	boolean
    //   68	251	2	localBufferedInputStream	java.io.BufferedInputStream
    //   333	12	2	localObject1	Object
    //   354	1	2	localObject2	Object
    //   360	1	2	localObject3	Object
    //   78	181	3	localProperties	java.util.Properties
    //   307	4	3	localThrowable1	Throwable
    //   358	1	3	localThrowable2	Throwable
    //   96	156	4	str	String
    // Exception table:
    //   from	to	target	type
    //   31	39	39	java/lang/Exception
    //   3	7	47	finally
    //   31	39	47	finally
    //   40	44	47	finally
    //   283	287	47	finally
    //   291	295	47	finally
    //   318	322	47	finally
    //   326	330	47	finally
    //   340	344	47	finally
    //   344	346	47	finally
    //   347	351	47	finally
    //   283	287	290	java/lang/Exception
    //   71	79	307	java/lang/Throwable
    //   81	86	307	java/lang/Throwable
    //   88	98	307	java/lang/Throwable
    //   100	110	307	java/lang/Throwable
    //   112	124	307	java/lang/Throwable
    //   126	136	307	java/lang/Throwable
    //   138	148	307	java/lang/Throwable
    //   150	155	307	java/lang/Throwable
    //   157	163	307	java/lang/Throwable
    //   165	171	307	java/lang/Throwable
    //   173	188	307	java/lang/Throwable
    //   190	194	307	java/lang/Throwable
    //   196	206	307	java/lang/Throwable
    //   208	218	307	java/lang/Throwable
    //   220	225	307	java/lang/Throwable
    //   227	237	307	java/lang/Throwable
    //   239	249	307	java/lang/Throwable
    //   251	256	307	java/lang/Throwable
    //   258	273	307	java/lang/Throwable
    //   275	279	307	java/lang/Throwable
    //   300	304	307	java/lang/Throwable
    //   318	322	325	java/lang/Exception
    //   15	23	333	finally
    //   53	69	333	finally
    //   340	344	346	java/lang/Exception
    //   71	79	354	finally
    //   81	86	354	finally
    //   88	98	354	finally
    //   100	110	354	finally
    //   112	124	354	finally
    //   126	136	354	finally
    //   138	148	354	finally
    //   150	155	354	finally
    //   157	163	354	finally
    //   165	171	354	finally
    //   173	188	354	finally
    //   190	194	354	finally
    //   196	206	354	finally
    //   208	218	354	finally
    //   220	225	354	finally
    //   227	237	354	finally
    //   239	249	354	finally
    //   251	256	354	finally
    //   258	273	354	finally
    //   275	279	354	finally
    //   300	304	354	finally
    //   310	314	354	finally
    //   15	23	358	java/lang/Throwable
    //   53	69	358	java/lang/Throwable
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
    //   7: ldc_w 358
    //   10: invokestatic 360	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   13: astore 7
    //   15: aload 7
    //   17: ifnonnull +28 -> 45
    //   20: iconst_0
    //   21: ifeq +11 -> 32
    //   24: new 362	java/lang/NullPointerException
    //   27: dup
    //   28: invokespecial 363	java/lang/NullPointerException:<init>	()V
    //   31: athrow
    //   32: iconst_0
    //   33: ifeq +11 -> 44
    //   36: new 362	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 363	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: return
    //   45: new 365	java/io/BufferedInputStream
    //   48: dup
    //   49: new 367	java/io/FileInputStream
    //   52: dup
    //   53: aload 7
    //   55: invokespecial 370	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: invokespecial 373	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore_3
    //   62: new 375	java/util/Properties
    //   65: dup
    //   66: invokespecial 376	java/util/Properties:<init>	()V
    //   69: astore 6
    //   71: aload 6
    //   73: aload_3
    //   74: invokevirtual 379	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   77: aload 6
    //   79: ldc 13
    //   81: iconst_0
    //   82: invokestatic 407	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   85: invokevirtual 411	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   88: pop
    //   89: iload_1
    //   90: ifeq +61 -> 151
    //   93: invokestatic 98	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   96: aload_0
    //   97: invokevirtual 413	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   100: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   103: astore 9
    //   105: aload_0
    //   106: invokevirtual 350	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   109: invokevirtual 356	android/content/Context:getPackageName	()Ljava/lang/String;
    //   112: astore 8
    //   114: aload_0
    //   115: invokestatic 418	com/tencent/smtt/utils/AppUtil:getAppVersionCode	(Landroid/content/Context;)I
    //   118: istore_2
    //   119: aload 6
    //   121: ldc 16
    //   123: aload 8
    //   125: invokevirtual 411	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   128: pop
    //   129: aload 6
    //   131: ldc 19
    //   133: aload 9
    //   135: invokevirtual 411	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   138: pop
    //   139: aload 6
    //   141: ldc 10
    //   143: iload_2
    //   144: invokestatic 420	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   147: invokevirtual 411	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   150: pop
    //   151: new 422	java/io/BufferedOutputStream
    //   154: dup
    //   155: new 424	java/io/FileOutputStream
    //   158: dup
    //   159: aload 7
    //   161: invokespecial 425	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   164: invokespecial 428	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   167: astore_0
    //   168: aload 6
    //   170: aload_0
    //   171: aconst_null
    //   172: invokevirtual 432	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   175: aload_3
    //   176: ifnull +7 -> 183
    //   179: aload_3
    //   180: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   183: aload_0
    //   184: ifnull -140 -> 44
    //   187: aload_0
    //   188: invokevirtual 433	java/io/BufferedOutputStream:close	()V
    //   191: return
    //   192: astore_0
    //   193: return
    //   194: astore 4
    //   196: aconst_null
    //   197: astore_0
    //   198: aload 5
    //   200: astore_3
    //   201: aload 4
    //   203: invokevirtual 343	java/lang/Throwable:printStackTrace	()V
    //   206: aload_0
    //   207: ifnull +7 -> 214
    //   210: aload_0
    //   211: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   214: aload_3
    //   215: ifnull -171 -> 44
    //   218: aload_3
    //   219: invokevirtual 433	java/io/BufferedOutputStream:close	()V
    //   222: return
    //   223: astore_0
    //   224: aconst_null
    //   225: astore_3
    //   226: aload_3
    //   227: ifnull +7 -> 234
    //   230: aload_3
    //   231: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   234: aload 4
    //   236: ifnull +8 -> 244
    //   239: aload 4
    //   241: invokevirtual 433	java/io/BufferedOutputStream:close	()V
    //   244: aload_0
    //   245: athrow
    //   246: astore_3
    //   247: goto -13 -> 234
    //   250: astore_3
    //   251: goto -7 -> 244
    //   254: astore_0
    //   255: goto -41 -> 214
    //   258: astore_0
    //   259: goto -227 -> 32
    //   262: astore_3
    //   263: goto -80 -> 183
    //   266: astore_0
    //   267: goto -41 -> 226
    //   270: astore 5
    //   272: aload_0
    //   273: astore 4
    //   275: aload 5
    //   277: astore_0
    //   278: goto -52 -> 226
    //   281: astore 4
    //   283: aload_0
    //   284: astore 5
    //   286: aload 4
    //   288: astore_0
    //   289: aload_3
    //   290: astore 4
    //   292: aload 5
    //   294: astore_3
    //   295: goto -69 -> 226
    //   298: astore 4
    //   300: aload_3
    //   301: astore_0
    //   302: aload 5
    //   304: astore_3
    //   305: goto -104 -> 201
    //   308: astore 4
    //   310: aload_3
    //   311: astore 5
    //   313: aload_0
    //   314: astore_3
    //   315: aload 5
    //   317: astore_0
    //   318: goto -117 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	paramContext	Context
    //   0	321	1	paramBoolean	boolean
    //   118	26	2	i	int
    //   61	170	3	localObject1	Object
    //   246	1	3	localException1	Exception
    //   250	1	3	localException2	Exception
    //   262	28	3	localException3	Exception
    //   294	21	3	localObject2	Object
    //   1	1	4	localObject3	Object
    //   194	46	4	localThrowable1	Throwable
    //   273	1	4	localContext	Context
    //   281	6	4	localObject4	Object
    //   290	1	4	localObject5	Object
    //   298	1	4	localThrowable2	Throwable
    //   308	1	4	localThrowable3	Throwable
    //   4	195	5	localObject6	Object
    //   270	6	5	localObject7	Object
    //   284	32	5	localObject8	Object
    //   69	100	6	localProperties	java.util.Properties
    //   13	147	7	localFile	File
    //   112	12	8	str1	String
    //   103	31	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   36	44	192	java/lang/Exception
    //   187	191	192	java/lang/Exception
    //   218	222	192	java/lang/Exception
    //   6	15	194	java/lang/Throwable
    //   45	62	194	java/lang/Throwable
    //   6	15	223	finally
    //   45	62	223	finally
    //   230	234	246	java/lang/Exception
    //   239	244	250	java/lang/Exception
    //   210	214	254	java/lang/Exception
    //   24	32	258	java/lang/Exception
    //   179	183	262	java/lang/Exception
    //   62	89	266	finally
    //   93	151	266	finally
    //   151	168	266	finally
    //   168	175	270	finally
    //   201	206	281	finally
    //   62	89	298	java/lang/Throwable
    //   93	151	298	java/lang/Throwable
    //   151	168	298	java/lang/Throwable
    //   168	175	308	java/lang/Throwable
  }
  
  /* Error */
  static int readCoreVersionFromConfig(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 25
    //   7: ldc_w 436
    //   10: invokestatic 155	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: aconst_null
    //   14: astore 4
    //   16: aload_0
    //   17: ldc_w 358
    //   20: invokestatic 360	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   23: astore_0
    //   24: aload_0
    //   25: ifnonnull +30 -> 55
    //   28: ldc 25
    //   30: ldc_w 438
    //   33: invokestatic 155	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: iload_2
    //   37: istore_1
    //   38: iconst_0
    //   39: ifeq +11 -> 50
    //   42: new 362	java/lang/NullPointerException
    //   45: dup
    //   46: invokespecial 363	java/lang/NullPointerException:<init>	()V
    //   49: athrow
    //   50: ldc 2
    //   52: monitorexit
    //   53: iload_1
    //   54: ireturn
    //   55: new 365	java/io/BufferedInputStream
    //   58: dup
    //   59: new 367	java/io/FileInputStream
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 370	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: invokespecial 373	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   70: astore_3
    //   71: new 375	java/util/Properties
    //   74: dup
    //   75: invokespecial 376	java/util/Properties:<init>	()V
    //   78: astore_0
    //   79: aload_0
    //   80: aload_3
    //   81: invokevirtual 379	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   84: aload_0
    //   85: ldc 22
    //   87: ldc 121
    //   89: invokevirtual 383	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   92: astore_0
    //   93: ldc 121
    //   95: aload_0
    //   96: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: ifne +51 -> 150
    //   102: ldc 25
    //   104: ldc_w 440
    //   107: invokestatic 155	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_0
    //   111: invokestatic 386	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   114: iconst_0
    //   115: invokestatic 392	java/lang/Math:max	(II)I
    //   118: istore_2
    //   119: iload_2
    //   120: istore_1
    //   121: aload_3
    //   122: ifnull -72 -> 50
    //   125: aload_3
    //   126: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   129: iload_2
    //   130: istore_1
    //   131: goto -81 -> 50
    //   134: astore_0
    //   135: aload_0
    //   136: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   139: iload_2
    //   140: istore_1
    //   141: goto -91 -> 50
    //   144: astore_0
    //   145: ldc 2
    //   147: monitorexit
    //   148: aload_0
    //   149: athrow
    //   150: ldc 25
    //   152: ldc_w 442
    //   155: invokestatic 155	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: iload_2
    //   159: istore_1
    //   160: aload_3
    //   161: ifnull -111 -> 50
    //   164: aload_3
    //   165: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   168: iload_2
    //   169: istore_1
    //   170: goto -120 -> 50
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   178: iload_2
    //   179: istore_1
    //   180: goto -130 -> 50
    //   183: astore_3
    //   184: aload 4
    //   186: astore_0
    //   187: aload_3
    //   188: invokevirtual 343	java/lang/Throwable:printStackTrace	()V
    //   191: aload_0
    //   192: ifnull +7 -> 199
    //   195: aload_0
    //   196: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   199: ldc 25
    //   201: ldc_w 444
    //   204: invokestatic 155	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: bipush 254
    //   209: istore_1
    //   210: goto -160 -> 50
    //   213: astore_0
    //   214: aconst_null
    //   215: astore_3
    //   216: aload_3
    //   217: ifnull +7 -> 224
    //   220: aload_3
    //   221: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   224: aload_0
    //   225: athrow
    //   226: astore_3
    //   227: aload_3
    //   228: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   231: goto -7 -> 224
    //   234: astore_0
    //   235: aload_0
    //   236: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   239: goto -40 -> 199
    //   242: astore_0
    //   243: aload_0
    //   244: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   247: iload_2
    //   248: istore_1
    //   249: goto -199 -> 50
    //   252: astore_0
    //   253: goto -37 -> 216
    //   256: astore 4
    //   258: aload_0
    //   259: astore_3
    //   260: aload 4
    //   262: astore_0
    //   263: goto -47 -> 216
    //   266: astore 4
    //   268: aload_3
    //   269: astore_0
    //   270: aload 4
    //   272: astore_3
    //   273: goto -86 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramContext	Context
    //   37	212	1	i	int
    //   1	247	2	j	int
    //   70	95	3	localBufferedInputStream	java.io.BufferedInputStream
    //   183	5	3	localThrowable1	Throwable
    //   215	6	3	localObject1	Object
    //   226	2	3	localException	Exception
    //   259	14	3	localObject2	Object
    //   14	171	4	localObject3	Object
    //   256	5	4	localObject4	Object
    //   266	5	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   125	129	134	java/lang/Exception
    //   5	13	144	finally
    //   42	50	144	finally
    //   125	129	144	finally
    //   135	139	144	finally
    //   164	168	144	finally
    //   174	178	144	finally
    //   195	199	144	finally
    //   199	207	144	finally
    //   220	224	144	finally
    //   224	226	144	finally
    //   227	231	144	finally
    //   235	239	144	finally
    //   243	247	144	finally
    //   164	168	173	java/lang/Exception
    //   16	24	183	java/lang/Throwable
    //   28	36	183	java/lang/Throwable
    //   55	71	183	java/lang/Throwable
    //   16	24	213	finally
    //   28	36	213	finally
    //   55	71	213	finally
    //   220	224	226	java/lang/Exception
    //   195	199	234	java/lang/Exception
    //   42	50	242	java/lang/Exception
    //   71	119	252	finally
    //   150	158	252	finally
    //   187	191	256	finally
    //   71	119	266	java/lang/Throwable
    //   150	158	266	java/lang/Throwable
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
    //   7: ldc_w 358
    //   10: invokestatic 360	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull +23 -> 38
    //   18: aload 4
    //   20: astore_0
    //   21: iconst_0
    //   22: ifeq +11 -> 33
    //   25: new 362	java/lang/NullPointerException
    //   28: dup
    //   29: invokespecial 363	java/lang/NullPointerException:<init>	()V
    //   32: athrow
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: areturn
    //   38: new 365	java/io/BufferedInputStream
    //   41: dup
    //   42: new 367	java/io/FileInputStream
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 370	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   50: invokespecial 373	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   53: astore_2
    //   54: aload_2
    //   55: astore_0
    //   56: new 375	java/util/Properties
    //   59: dup
    //   60: invokespecial 376	java/util/Properties:<init>	()V
    //   63: astore_3
    //   64: aload_2
    //   65: astore_0
    //   66: aload_3
    //   67: aload_2
    //   68: invokevirtual 379	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   71: aload_2
    //   72: astore_0
    //   73: aload_3
    //   74: ldc 16
    //   76: ldc 121
    //   78: invokevirtual 383	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: astore_3
    //   82: aload_2
    //   83: astore_0
    //   84: ldc 121
    //   86: aload_3
    //   87: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: istore_1
    //   91: iload_1
    //   92: ifne +76 -> 168
    //   95: aload_2
    //   96: ifnull +7 -> 103
    //   99: aload_2
    //   100: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   103: aload_3
    //   104: astore_0
    //   105: goto -72 -> 33
    //   108: astore_3
    //   109: aconst_null
    //   110: astore_2
    //   111: aload_2
    //   112: astore_0
    //   113: aload_3
    //   114: invokevirtual 343	java/lang/Throwable:printStackTrace	()V
    //   117: aload 4
    //   119: astore_0
    //   120: aload_2
    //   121: ifnull -88 -> 33
    //   124: aload_2
    //   125: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   128: aload 4
    //   130: astore_0
    //   131: goto -98 -> 33
    //   134: astore_0
    //   135: aload 4
    //   137: astore_0
    //   138: goto -105 -> 33
    //   141: astore_2
    //   142: aconst_null
    //   143: astore_0
    //   144: aload_0
    //   145: ifnull +7 -> 152
    //   148: aload_0
    //   149: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   152: aload_2
    //   153: athrow
    //   154: astore_0
    //   155: ldc 2
    //   157: monitorexit
    //   158: aload_0
    //   159: athrow
    //   160: astore_0
    //   161: goto -9 -> 152
    //   164: astore_0
    //   165: goto -62 -> 103
    //   168: aload 4
    //   170: astore_0
    //   171: aload_2
    //   172: ifnull -139 -> 33
    //   175: aload_2
    //   176: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   179: aload 4
    //   181: astore_0
    //   182: goto -149 -> 33
    //   185: astore_2
    //   186: goto -42 -> 144
    //   189: astore_3
    //   190: goto -79 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramContext	Context
    //   90	2	1	bool	boolean
    //   53	72	2	localBufferedInputStream	java.io.BufferedInputStream
    //   141	35	2	localObject1	Object
    //   185	1	2	localObject2	Object
    //   63	41	3	localObject3	Object
    //   108	6	3	localThrowable1	Throwable
    //   189	1	3	localThrowable2	Throwable
    //   1	179	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   6	14	108	java/lang/Throwable
    //   38	54	108	java/lang/Throwable
    //   25	33	134	java/lang/Exception
    //   124	128	134	java/lang/Exception
    //   175	179	134	java/lang/Exception
    //   6	14	141	finally
    //   38	54	141	finally
    //   25	33	154	finally
    //   99	103	154	finally
    //   124	128	154	finally
    //   148	152	154	finally
    //   152	154	154	finally
    //   175	179	154	finally
    //   148	152	160	java/lang/Exception
    //   99	103	164	java/lang/Exception
    //   56	64	185	finally
    //   66	71	185	finally
    //   73	82	185	finally
    //   84	91	185	finally
    //   113	117	185	finally
    //   56	64	189	java/lang/Throwable
    //   66	71	189	java/lang/Throwable
    //   73	82	189	java/lang/Throwable
    //   84	91	189	java/lang/Throwable
  }
  
  public static void setHostCorePathAppDefined(String paramString)
  {
    mHostCorePathAppDefined = paramString;
  }
  
  private static void shareAllDirsAndFiles(Context paramContext, TbsLinuxToolsJni paramTbsLinuxToolsJni, File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {
      return;
    }
    paramTbsLinuxToolsJni.Chmod(paramFile.getAbsolutePath(), "755");
    paramFile = paramFile.listFiles();
    int j = paramFile.length;
    int i = 0;
    label42:
    File localFile;
    if (i < j)
    {
      localFile = paramFile[i];
      if (!localFile.isFile()) {
        break label111;
      }
      if (localFile.getAbsolutePath().indexOf(".so") <= 0) {
        break label95;
      }
      paramTbsLinuxToolsJni.Chmod(localFile.getAbsolutePath(), "755");
    }
    for (;;)
    {
      i += 1;
      break label42;
      break;
      label95:
      paramTbsLinuxToolsJni.Chmod(localFile.getAbsolutePath(), "644");
      continue;
      label111:
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
    try
    {
      TbsLinuxToolsJni localTbsLinuxToolsJni = new TbsLinuxToolsJni(paramContext);
      shareAllDirsAndFiles(paramContext, localTbsLinuxToolsJni, TbsInstaller.getInstance().getTbsCoreShareDir(paramContext));
      localTbsLinuxToolsJni.Chmod(TbsInstaller.getInstance().getTbsShareDir(paramContext).getAbsolutePath(), "755");
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void writeCoreInfoForThirdPartyApp(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int j = 0;
    label136:
    label405:
    label846:
    label849:
    label856:
    label861:
    for (;;)
    {
      int i;
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
          break label136;
        }
      }
      finally {}
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
          Object localObject1;
          if (QbSdk.getOnlyDownload()) {
            localObject1 = new String[] { paramContext.getApplicationContext().getPackageName() };
          }
          label241:
          Object localObject2;
          Object localObject3;
          for (;;)
          {
            for (;;)
            {
              for (;;)
              {
                if (mHostCorePathAppDefined == null) {
                  break label606;
                }
                if (paramInt != TbsInstaller.getInstance().getTbsCoreVersionAppDefined(mHostCorePathAppDefined)) {
                  break label385;
                }
                writeProperties(paramContext, Integer.toString(paramInt), "AppDefined", mHostCorePathAppDefined, Integer.toString(1));
                try
                {
                  localObject1 = getTbsShareFile(paramContext, "core_info");
                  if ((core_info_shared) || (localObject1 == null)) {
                    break;
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
              break;
              localObject1 = getCoreProviderAppList();
              if (!paramBoolean) {
                break label846;
              }
              localObject1 = new String[] { paramContext.getApplicationContext().getPackageName() };
              continue;
              if (paramInt <= TbsInstaller.getInstance().getTbsCoreVersionAppDefined(mHostCorePathAppDefined)) {
                break label606;
              }
              k = localObject1.length;
              i = 0;
              if (i >= k) {
                break label606;
              }
              localObject2 = localObject1[i];
              if (paramInt != getSharedTbsCoreVersion(paramContext, (String)localObject2)) {
                break label849;
              }
              localObject3 = getPackageContext(paramContext, (String)localObject2);
              localObject2 = TbsInstaller.getInstance().getTbsCoreShareDir((Context)localObject3).getAbsolutePath();
              AppUtil.getAppVersionCode(paramContext);
              if (!TbsInstaller.getInstance().vertificateApp((Context)localObject3)) {
                break label849;
              }
              localObject1 = new File(mHostCorePathAppDefined);
              localObject2 = new File((String)localObject2);
              localObject3 = new FileFilter()
              {
                public boolean accept(File paramAnonymousFile)
                {
                  return !paramAnonymousFile.getName().endsWith(".dex");
                }
              };
              try
              {
                FileUtil.copyFiles((File)localObject2, (File)localObject1, (FileFilter)localObject3);
                writeProperties(paramContext, Integer.toString(paramInt), "AppDefined", mHostCorePathAppDefined, Integer.toString(1));
                localObject1 = getTbsShareFile(paramContext, "core_info");
                if ((core_info_shared) || (localObject1 == null)) {
                  break;
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
            break;
          }
          label606:
          int k = localObject1.length;
          i = j;
          for (;;)
          {
            for (;;)
            {
              if (i >= k) {
                break label861;
              }
              localObject2 = localObject1[i];
              if (paramInt != getSharedTbsCoreVersion(paramContext, (String)localObject2)) {
                break label856;
              }
              Context localContext = getPackageContext(paramContext, (String)localObject2);
              localObject3 = TbsInstaller.getInstance().getTbsCoreShareDir(localContext).getAbsolutePath();
              j = AppUtil.getAppVersionCode(paramContext);
              if (!TbsInstaller.getInstance().vertificateApp(localContext)) {
                break label856;
              }
              if (!((String)localObject2).equals(paramContext.getApplicationContext().getPackageName()))
              {
                TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + paramInt);
                localObject1 = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
              }
              try
              {
                for (;;)
                {
                  FileUtil.delete((File)localObject1);
                  TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                  writeProperties(paramContext, Integer.toString(paramInt), (String)localObject2, (String)localObject3, Integer.toString(j));
                  try
                  {
                    localObject1 = getTbsShareFile(paramContext, "core_info");
                    if ((core_info_shared) || (localObject1 == null)) {
                      break;
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
              }
              catch (Throwable localThrowable)
              {
                for (;;)
                {
                  localThrowable.printStackTrace();
                }
              }
            }
            break label241;
            i += 1;
            break label405;
            i += 1;
          }
        }
      }
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
    //   9: ldc 25
    //   11: new 133	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 526
    //   21: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc_w 528
    //   31: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 530
    //   41: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_3
    //   45: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 155	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: ldc_w 358
    //   58: invokestatic 360	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   61: astore_0
    //   62: aload_0
    //   63: ifnonnull +40 -> 103
    //   66: getstatic 346	com/tencent/smtt/sdk/TbsShareManager:sAppContext	Landroid/content/Context;
    //   69: invokestatic 497	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   72: sipush -405
    //   75: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   78: iconst_0
    //   79: ifeq +11 -> 90
    //   82: new 362	java/lang/NullPointerException
    //   85: dup
    //   86: invokespecial 363	java/lang/NullPointerException:<init>	()V
    //   89: athrow
    //   90: iconst_0
    //   91: ifeq +11 -> 102
    //   94: new 362	java/lang/NullPointerException
    //   97: dup
    //   98: invokespecial 363	java/lang/NullPointerException:<init>	()V
    //   101: athrow
    //   102: return
    //   103: new 365	java/io/BufferedInputStream
    //   106: dup
    //   107: new 367	java/io/FileInputStream
    //   110: dup
    //   111: aload_0
    //   112: invokespecial 370	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   115: invokespecial 373	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   118: astore 7
    //   120: new 375	java/util/Properties
    //   123: dup
    //   124: invokespecial 376	java/util/Properties:<init>	()V
    //   127: astore 10
    //   129: aload 10
    //   131: aload 7
    //   133: invokevirtual 379	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   136: aload_1
    //   137: invokestatic 386	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   140: istore 6
    //   142: iload 6
    //   144: istore 5
    //   146: iload 5
    //   148: ifeq +116 -> 264
    //   151: aload 10
    //   153: ldc 22
    //   155: aload_1
    //   156: invokevirtual 411	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   159: pop
    //   160: aload 10
    //   162: ldc 13
    //   164: iconst_0
    //   165: invokestatic 407	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   168: invokevirtual 411	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   171: pop
    //   172: aload 10
    //   174: ldc 16
    //   176: aload_2
    //   177: invokevirtual 411	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   180: pop
    //   181: aload 10
    //   183: ldc 19
    //   185: aload_3
    //   186: invokevirtual 411	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   189: pop
    //   190: aload 10
    //   192: ldc 10
    //   194: aload 4
    //   196: invokevirtual 411	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   199: pop
    //   200: new 422	java/io/BufferedOutputStream
    //   203: dup
    //   204: new 424	java/io/FileOutputStream
    //   207: dup
    //   208: aload_0
    //   209: invokespecial 425	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   212: invokespecial 428	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   215: astore_0
    //   216: aload 10
    //   218: aload_0
    //   219: aconst_null
    //   220: invokevirtual 432	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   223: iconst_0
    //   224: putstatic 68	com/tencent/smtt/sdk/TbsShareManager:core_info_already_read	Z
    //   227: getstatic 346	com/tencent/smtt/sdk/TbsShareManager:sAppContext	Landroid/content/Context;
    //   230: invokestatic 497	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   233: sipush -406
    //   236: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   239: aload 7
    //   241: ifnull +8 -> 249
    //   244: aload 7
    //   246: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   249: aload_0
    //   250: ifnull -148 -> 102
    //   253: aload_0
    //   254: invokevirtual 433	java/io/BufferedOutputStream:close	()V
    //   257: return
    //   258: astore_0
    //   259: aload_0
    //   260: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   263: return
    //   264: aload 10
    //   266: ldc 13
    //   268: iconst_1
    //   269: invokestatic 407	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   272: invokevirtual 411	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   275: pop
    //   276: goto -76 -> 200
    //   279: astore_2
    //   280: aload 7
    //   282: astore_0
    //   283: aload 8
    //   285: astore_1
    //   286: aload_2
    //   287: invokevirtual 343	java/lang/Throwable:printStackTrace	()V
    //   290: aload_0
    //   291: ifnull +7 -> 298
    //   294: aload_0
    //   295: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   298: aload_1
    //   299: ifnull -197 -> 102
    //   302: aload_1
    //   303: invokevirtual 433	java/io/BufferedOutputStream:close	()V
    //   306: return
    //   307: astore_0
    //   308: goto -49 -> 259
    //   311: astore_0
    //   312: aconst_null
    //   313: astore 7
    //   315: aload 9
    //   317: astore_1
    //   318: aload 7
    //   320: ifnull +8 -> 328
    //   323: aload 7
    //   325: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   328: aload_1
    //   329: ifnull +7 -> 336
    //   332: aload_1
    //   333: invokevirtual 433	java/io/BufferedOutputStream:close	()V
    //   336: aload_0
    //   337: athrow
    //   338: astore 11
    //   340: goto -194 -> 146
    //   343: astore_2
    //   344: aload_2
    //   345: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   348: goto -20 -> 328
    //   351: astore_1
    //   352: aload_1
    //   353: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   356: goto -20 -> 336
    //   359: astore_0
    //   360: aload_0
    //   361: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   364: goto -66 -> 298
    //   367: astore_0
    //   368: aload_0
    //   369: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   372: goto -282 -> 90
    //   375: astore_0
    //   376: goto -117 -> 259
    //   379: astore_1
    //   380: aload_1
    //   381: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   384: goto -135 -> 249
    //   387: astore_0
    //   388: aload 9
    //   390: astore_1
    //   391: goto -73 -> 318
    //   394: astore_2
    //   395: aload_0
    //   396: astore_1
    //   397: aload_2
    //   398: astore_0
    //   399: goto -81 -> 318
    //   402: astore_2
    //   403: aload_0
    //   404: astore 7
    //   406: aload_2
    //   407: astore_0
    //   408: goto -90 -> 318
    //   411: astore_2
    //   412: aconst_null
    //   413: astore_0
    //   414: aload 8
    //   416: astore_1
    //   417: goto -131 -> 286
    //   420: astore_2
    //   421: aload_0
    //   422: astore_1
    //   423: aload 7
    //   425: astore_0
    //   426: goto -140 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	paramContext	Context
    //   0	429	1	paramString1	String
    //   0	429	2	paramString2	String
    //   0	429	3	paramString3	String
    //   0	429	4	paramString4	String
    //   7	140	5	i	int
    //   140	3	6	j	int
    //   118	306	7	localObject1	Object
    //   4	411	8	localObject2	Object
    //   1	388	9	localObject3	Object
    //   127	138	10	localProperties	java.util.Properties
    //   338	1	11	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   253	257	258	java/lang/Exception
    //   120	136	279	java/lang/Throwable
    //   136	142	279	java/lang/Throwable
    //   151	200	279	java/lang/Throwable
    //   200	216	279	java/lang/Throwable
    //   264	276	279	java/lang/Throwable
    //   302	306	307	java/lang/Exception
    //   54	62	311	finally
    //   66	78	311	finally
    //   103	120	311	finally
    //   136	142	338	java/lang/Exception
    //   323	328	343	java/lang/Exception
    //   332	336	351	java/lang/Exception
    //   294	298	359	java/lang/Exception
    //   82	90	367	java/lang/Exception
    //   94	102	375	java/lang/Exception
    //   244	249	379	java/lang/Exception
    //   120	136	387	finally
    //   136	142	387	finally
    //   151	200	387	finally
    //   200	216	387	finally
    //   264	276	387	finally
    //   216	239	394	finally
    //   286	290	402	finally
    //   54	62	411	java/lang/Throwable
    //   66	78	411	java/lang/Throwable
    //   103	120	411	java/lang/Throwable
    //   216	239	420	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsShareManager
 * JD-Core Version:    0.7.0.1
 */