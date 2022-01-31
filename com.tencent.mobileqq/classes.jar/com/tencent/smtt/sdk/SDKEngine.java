package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class SDKEngine
{
  public static final String COUNT_PROPERTIES = "count.prop";
  private static int REBOOT_CALLED_TIMES_MAX = 3;
  private static final String TAG = "SDKEngine";
  private static String mCalledCountKey = null;
  private static int mInitCount;
  private static SDKEngine mInstance = null;
  private static int mTbsCoreVersion = 0;
  static boolean mTbsNeedReboot;
  private boolean mIsInited = false;
  private boolean mTbsAvailable = false;
  private TbsWizard mTbsWizard = null;
  private File mX5CorePath = null;
  
  static
  {
    mInitCount = 0;
    mTbsNeedReboot = false;
  }
  
  /* Error */
  private int getCountProp()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 61	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 53	com/tencent/smtt/sdk/SDKEngine:mX5CorePath	Ljava/io/File;
    //   10: ldc 8
    //   12: invokespecial 64	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: invokevirtual 68	java/io/File:exists	()Z
    //   22: istore_3
    //   23: iload_3
    //   24: ifne +26 -> 50
    //   27: iconst_0
    //   28: ifeq +11 -> 39
    //   31: new 70	java/lang/NullPointerException
    //   34: dup
    //   35: invokespecial 71	java/lang/NullPointerException:<init>	()V
    //   38: athrow
    //   39: iload_1
    //   40: ireturn
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   48: iconst_0
    //   49: ireturn
    //   50: new 76	java/io/BufferedInputStream
    //   53: dup
    //   54: new 78	java/io/FileInputStream
    //   57: dup
    //   58: aload 4
    //   60: invokespecial 81	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 84	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore 5
    //   68: aload 5
    //   70: astore 4
    //   72: new 86	java/util/Properties
    //   75: dup
    //   76: invokespecial 87	java/util/Properties:<init>	()V
    //   79: astore 6
    //   81: aload 5
    //   83: astore 4
    //   85: aload 6
    //   87: aload 5
    //   89: invokevirtual 90	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   92: aload 5
    //   94: astore 4
    //   96: aload 6
    //   98: getstatic 41	com/tencent/smtt/sdk/SDKEngine:mCalledCountKey	Ljava/lang/String;
    //   101: ldc 92
    //   103: invokevirtual 96	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   106: invokestatic 102	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   109: invokevirtual 105	java/lang/Integer:intValue	()I
    //   112: istore_2
    //   113: iload_2
    //   114: istore_1
    //   115: aload 5
    //   117: ifnull -78 -> 39
    //   120: aload 5
    //   122: invokevirtual 108	java/io/BufferedInputStream:close	()V
    //   125: iload_2
    //   126: ireturn
    //   127: astore 4
    //   129: aload 4
    //   131: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   134: iload_2
    //   135: ireturn
    //   136: astore 6
    //   138: aconst_null
    //   139: astore 5
    //   141: aload 5
    //   143: astore 4
    //   145: aload 6
    //   147: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   150: aload 5
    //   152: ifnull -113 -> 39
    //   155: aload 5
    //   157: invokevirtual 108	java/io/BufferedInputStream:close	()V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore 4
    //   164: aload 4
    //   166: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   169: iconst_0
    //   170: ireturn
    //   171: astore 5
    //   173: aconst_null
    //   174: astore 4
    //   176: aload 4
    //   178: ifnull +8 -> 186
    //   181: aload 4
    //   183: invokevirtual 108	java/io/BufferedInputStream:close	()V
    //   186: aload 5
    //   188: athrow
    //   189: astore 4
    //   191: aload 4
    //   193: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   196: goto -10 -> 186
    //   199: astore 5
    //   201: goto -25 -> 176
    //   204: astore 6
    //   206: goto -65 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	SDKEngine
    //   1	114	1	i	int
    //   112	23	2	j	int
    //   22	2	3	bool	boolean
    //   15	3	4	localFile	File
    //   41	18	4	localIOException1	IOException
    //   70	25	4	localObject1	Object
    //   127	3	4	localIOException2	IOException
    //   143	1	4	localObject2	Object
    //   162	3	4	localIOException3	IOException
    //   174	8	4	localObject3	Object
    //   189	3	4	localIOException4	IOException
    //   66	90	5	localBufferedInputStream	java.io.BufferedInputStream
    //   171	16	5	localObject4	Object
    //   199	1	5	localObject5	Object
    //   79	18	6	localProperties	Properties
    //   136	10	6	localException1	java.lang.Exception
    //   204	1	6	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   31	39	41	java/io/IOException
    //   120	125	127	java/io/IOException
    //   2	23	136	java/lang/Exception
    //   50	68	136	java/lang/Exception
    //   155	160	162	java/io/IOException
    //   2	23	171	finally
    //   50	68	171	finally
    //   181	186	189	java/io/IOException
    //   72	81	199	finally
    //   85	92	199	finally
    //   96	113	199	finally
    //   145	150	199	finally
    //   72	81	204	java/lang/Exception
    //   85	92	204	java/lang/Exception
    //   96	113	204	java/lang/Exception
  }
  
  public static SDKEngine getInstance(boolean paramBoolean)
  {
    if ((mInstance == null) && (paramBoolean)) {}
    try
    {
      if (mInstance == null) {
        mInstance = new SDKEngine();
      }
      return mInstance;
    }
    finally {}
  }
  
  public static int getTbsCoreVersion()
  {
    return mTbsCoreVersion;
  }
  
  private void setCountProp(int paramInt)
  {
    Properties localProperties = new Properties();
    localProperties.setProperty(mCalledCountKey, String.valueOf(paramInt));
    try
    {
      localProperties.store(new FileOutputStream(new File(this.mX5CorePath, "count.prop")), null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  static void setTbsCoreVersion(int paramInt)
  {
    mTbsCoreVersion = paramInt;
  }
  
  public String getCrashExtraMessage()
  {
    if ((this.mTbsWizard == null) || (QbSdk.mIsSysWebViewForced)) {
      return "system webview get nothing...";
    }
    return this.mTbsWizard.getCrashExtraMessage();
  }
  
  boolean getTbsNeedReboot()
  {
    int i;
    if (mTbsNeedReboot)
    {
      if (mCalledCountKey == null) {
        return false;
      }
      i = getCountProp();
      if (i != 0) {
        break label32;
      }
      setCountProp(1);
    }
    for (;;)
    {
      return mTbsNeedReboot;
      label32:
      if (i + 1 > REBOOT_CALLED_TIMES_MAX) {
        break;
      }
      setCountProp(i + 1);
    }
  }
  
  public void init(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, TbsInitPerformanceRecorder paramTbsInitPerformanceRecorder)
  {
    boolean bool2;
    label271:
    label291:
    Object localObject3;
    Object localObject2;
    label442:
    label472:
    label493:
    label508:
    Object localObject4;
    int i;
    for (;;)
    {
      try
      {
        TbsLog.addLog(999, null, new Object[0]);
        TbsLog.initIfNeed(paramContext);
        TbsLog.i("SDKEngine", "init -- context: " + paramContext + ", isPreIniting: " + paramBoolean2);
        mInitCount += 1;
        if (paramTbsInitPerformanceRecorder != null)
        {
          if (mInitCount == 1)
          {
            bool1 = true;
            paramTbsInitPerformanceRecorder.mIsFirstInitTbs = bool1;
          }
        }
        else
        {
          TbsCoreLoadStat.getInstance().clearErrorCodeQueue();
          if (paramTbsInitPerformanceRecorder != null) {
            paramTbsInitPerformanceRecorder.recordPerformanceEvent("tbs_rename_task", (byte)1);
          }
          localObject1 = TbsInstaller.getInstance();
          if (mInitCount != 1) {
            continue;
          }
          bool1 = true;
          ((TbsInstaller)localObject1).installTbsCoreIfNeeded(paramContext, bool1);
          TbsInstaller.getInstance().initTbsCoreInstalledVer(paramContext);
          if (paramTbsInitPerformanceRecorder != null) {
            paramTbsInitPerformanceRecorder.recordPerformanceEvent("tbs_rename_task", (byte)2);
          }
          TbsShareManager.forceToLoadX5ForThirdApp(paramContext, true);
          if (paramTbsInitPerformanceRecorder != null) {
            paramTbsInitPerformanceRecorder.recordPerformanceEvent("can_load_x5", (byte)1);
          }
          bool2 = QbSdk.canLoadX5(paramContext, paramBoolean1, paramBoolean2);
          if (paramTbsInitPerformanceRecorder != null) {
            paramTbsInitPerformanceRecorder.recordPerformanceEvent("can_load_x5", (byte)2);
          }
          if (Build.VERSION.SDK_INT < 7) {
            continue;
          }
          paramBoolean2 = true;
          break label825;
          bool1 = paramBoolean1;
          if (paramBoolean1)
          {
            long l = System.currentTimeMillis();
            bool1 = TbsInstaller.getInstance().isTbsCoreLegal(paramContext, getTbsCoreVersion());
            TbsLog.i("SDKEngine", "isTbsCoreLegal: " + bool1 + "; cost: " + (System.currentTimeMillis() - l));
          }
          if (!bool1) {
            break label711;
          }
          paramBoolean1 = this.mTbsAvailable;
          if (!paramBoolean1) {
            continue;
          }
          return;
        }
        boolean bool1 = false;
        continue;
        bool1 = false;
        continue;
        paramBoolean2 = false;
        break label825;
        paramBoolean1 = false;
        continue;
        try
        {
          if (!TbsShareManager.isThirdPartyApp(paramContext)) {
            break;
          }
          TbsLog.addLog(995, null, new Object[0]);
          if (paramTbsInitPerformanceRecorder != null) {
            paramTbsInitPerformanceRecorder.recordPerformanceEvent("read_core_info", (byte)1);
          }
          paramBoolean1 = TbsShareManager.isShareTbsCoreAvailable(paramContext);
          if (paramTbsInitPerformanceRecorder != null) {
            paramTbsInitPerformanceRecorder.recordPerformanceEvent("read_core_info", (byte)2);
          }
          if (!paramBoolean1) {
            break label493;
          }
          localObject3 = new File(TbsShareManager.getAvailableTbsCorePath(paramContext));
          localObject2 = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
          localObject1 = TbsShareManager.getAvailableTbsCoreHostContext(paramContext);
          if (localObject2 != null) {
            break label839;
          }
          this.mTbsAvailable = false;
          QbSdk.forceSysWebViewInner(paramContext, "SDKEngine::useSystemWebView by error_tbs_core_dexopt_dir null!");
        }
        catch (Throwable paramTbsInitPerformanceRecorder)
        {
          TbsLog.e("SDKEngine", "useSystemWebView by exception: " + paramTbsInitPerformanceRecorder);
          if (paramTbsInitPerformanceRecorder != null) {
            break label696;
          }
        }
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 326);
        this.mTbsAvailable = false;
        QbSdk.forceSysWebViewInner(paramContext, "SDKEngine::useSystemWebView by exception: " + paramTbsInitPerformanceRecorder);
        this.mX5CorePath = TbsInstaller.getTbsCorePrivateDir(paramContext);
        this.mIsInited = true;
        continue;
        this.mTbsAvailable = false;
      }
      finally {}
      QbSdk.forceSysWebViewInner(paramContext, "SDKEngine::useSystemWebView by error_host_unavailable");
      continue;
      localObject4 = QbSdk.getDexLoaderFileList(paramContext, (Context)localObject1, ((File)localObject3).getAbsolutePath());
      i = 0;
    }
    while (i < localObject4.length)
    {
      i += 1;
      continue;
      TbsLog.addLog(996, null, new Object[0]);
      localObject2 = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
      if (mTbsCoreVersion == 25436) {
        break label842;
      }
      if (mTbsCoreVersion != 25437) {
        break label848;
      }
      break label842;
      label582:
      if (i == 0) {
        break label854;
      }
    }
    label696:
    label711:
    label839:
    label842:
    label848:
    label854:
    for (Object localObject1 = paramContext.getApplicationContext();; localObject1 = paramContext)
    {
      if (localObject2 == null)
      {
        this.mTbsAvailable = false;
        QbSdk.forceSysWebViewInner(paramContext, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
        break label271;
        if (TbsShareManager.getHostCorePathAppDefined() != null) {}
        for (localObject2 = TbsShareManager.getHostCorePathAppDefined();; localObject2 = ((File)localObject2).getAbsolutePath())
        {
          TbsLog.i("SDKEngine", "SDKEngine init optDir is " + (String)localObject2);
          this.mTbsWizard = new TbsWizard(paramContext, (Context)localObject1, ((File)localObject3).getAbsolutePath(), (String)localObject2, (String[])localObject4, QbSdk.sLibraryPath, paramTbsInitPerformanceRecorder);
          this.mTbsAvailable = true;
          break;
        }
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 327, paramTbsInitPerformanceRecorder);
        break label442;
        paramTbsInitPerformanceRecorder = "can_load_x5=" + bool2 + "; is_compatible=" + paramBoolean2;
        TbsLog.e("SDKEngine", "SDKEngine.init canLoadTbs=false; failure: " + paramTbsInitPerformanceRecorder);
        if ((QbSdk.mIsSysWebViewForced) && (this.mTbsAvailable)) {
          break label472;
        }
        this.mTbsAvailable = false;
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 405, new Throwable(paramTbsInitPerformanceRecorder));
        break label472;
      }
      localObject4 = localObject2;
      localObject3 = localObject2;
      localObject2 = localObject4;
      break label508;
      if ((!bool2) || (!paramBoolean2)) {
        break label291;
      }
      paramBoolean1 = true;
      break;
      break label508;
      i = 1;
      break label582;
      i = 0;
      break label582;
    }
  }
  
  boolean isInited()
  {
    return this.mIsInited;
  }
  
  public boolean isTbsAvailable()
  {
    return this.mTbsAvailable;
  }
  
  void setCalledCountKey(String paramString)
  {
    mCalledCountKey = paramString;
  }
  
  boolean setTbsNeedReboot(boolean paramBoolean)
  {
    mTbsNeedReboot = paramBoolean;
    return paramBoolean;
  }
  
  public boolean useSoftWare()
  {
    return QbSdk.useSoftWare();
  }
  
  public TbsWizard wizard()
  {
    if (this.mTbsAvailable) {
      return this.mTbsWizard;
    }
    return null;
  }
  
  TbsWizard wizardForReaderView()
  {
    return this.mTbsWizard;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.SDKEngine
 * JD-Core Version:    0.7.0.1
 */