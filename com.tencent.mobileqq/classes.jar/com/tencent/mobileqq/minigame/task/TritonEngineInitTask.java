package com.tencent.mobileqq.minigame.task;

import amtj;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniAppStartState;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.mobileqq.minigame.api.QQMiniEnginePackage;
import com.tencent.mobileqq.minigame.manager.EngineVersion;
import com.tencent.mobileqq.minigame.manager.GameEnvManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager.PREPARE_FROM;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.mobileqq.triton.model.Version;
import java.io.File;

public class TritonEngineInitTask
  extends AsyncTask
{
  public static final int ENG_NOT_LOAD = -1;
  public static final int ERR_ENGINE_NEED_UPDATE = 101;
  public static final int ERR_ENGINE_NULL = 105;
  public static final int ERR_ENGINE_TIMEOUT = 103;
  public static final int ERR_ENGINE_VERSION = 104;
  public static final int ERR_INIT_ENGINE = 109;
  public static final int ERR_INIT_NDK = 108;
  public static final int ERR_INTERNAL = 102;
  public static final int ERR_LOAD_JAR = 106;
  public static final int ERR_LOAD_SO = 107;
  public static final int ERR_UNKNOWN = 100;
  public static final int SUCCEED = 0;
  public final String LOG_TAG = toString();
  private MiniAppConfig mAppConfig;
  private int mEngineLoadResult = -1;
  private QQMiniEnginePackage mEnginePackage;
  private GameRuntimeLoaderManager.PREPARE_FROM mFrom;
  private TritonPlatform mTritonPlatform;
  
  public TritonEngineInitTask(Context paramContext, GameRuntimeLoaderManager.PREPARE_FROM paramPREPARE_FROM)
  {
    super(paramContext);
    GameLog.getInstance().i(this.LOG_TAG, "new TritonEngineInitTask");
    this.mFrom = paramPREPARE_FROM;
  }
  
  private void handleException(QQMiniEnginePackage paramQQMiniEnginePackage, Throwable paramThrowable)
  {
    Object localObject = null;
    String[] arrayOfString = GameWnsUtils.getTritonDownloadBackUpUrl().split("\\|");
    String str2;
    String str1;
    if ((arrayOfString != null) && (arrayOfString.length > 2))
    {
      str2 = arrayOfString[0];
      str1 = arrayOfString[1];
      localObject = arrayOfString[2];
    }
    for (;;)
    {
      GameLog.getInstance().i(this.LOG_TAG, "[MiniEng] url:" + str2 + " version:" + str1 + " timestamp:" + (String)localObject);
      if ((paramQQMiniEnginePackage.getVersion() != null) && (!TextUtils.isEmpty(str2)))
      {
        paramQQMiniEnginePackage = new BaseLibInfo();
        paramQQMiniEnginePackage.baseLibUrl = str2;
        paramQQMiniEnginePackage.baseLibVersion = str1;
        localObject = new Version(str1, Long.parseLong((String)localObject));
        GameLog.getInstance().i(this.LOG_TAG, "[MiniEng] download backup triton:" + paramQQMiniEnginePackage + ", version:" + localObject);
        GameEnvManager.downloadLatestTritonEngine(paramQQMiniEnginePackage, (Version)localObject, new TritonEngineInitTask.1(this));
      }
      reportEngineCreateException(paramThrowable);
      return;
      str1 = null;
      str2 = null;
    }
  }
  
  private boolean isGameSatisfy(QQMiniEnginePackage paramQQMiniEnginePackage, MiniAppConfig paramMiniAppConfig)
  {
    boolean bool = true;
    if (paramQQMiniEnginePackage == null)
    {
      GameLog.getInstance().e(this.LOG_TAG, "[MiniEng]isGameSatisfy envConfig == null");
      return false;
    }
    if (paramMiniAppConfig == null)
    {
      GameLog.getInstance().e(this.LOG_TAG, "[MiniEng]isGameSatisfy gameConfig == null");
      return false;
    }
    paramMiniAppConfig = paramMiniAppConfig.config;
    if (paramMiniAppConfig == null)
    {
      GameLog.getInstance().e(this.LOG_TAG, "[MiniEng]isGameSatisfy info == null");
      return false;
    }
    paramMiniAppConfig = paramMiniAppConfig.baselibMiniVersion;
    GameLog.getInstance().i(this.LOG_TAG, "[MiniEng]isGameSatisfy minVersion=" + paramMiniAppConfig);
    if (TextUtils.isEmpty(paramMiniAppConfig)) {
      return true;
    }
    paramMiniAppConfig = new EngineVersion(paramMiniAppConfig);
    paramQQMiniEnginePackage = EngineVersion.fromFolderName(paramQQMiniEnginePackage.getBaseLibDir().getAbsolutePath());
    if ((paramQQMiniEnginePackage != null) && (EngineVersion.compareVersion(paramQQMiniEnginePackage.mMinor, paramMiniAppConfig.mMinor) >= 0)) {}
    for (;;)
    {
      GameLog.getInstance().i(this.LOG_TAG, "[MiniEng]isGameSatisfy appMinVersion=" + paramMiniAppConfig + ", jsSdkVersion=" + paramQQMiniEnginePackage + ",ret=" + bool);
      return bool;
      bool = false;
    }
  }
  
  private void loadTritonEngine()
  {
    this.mEnginePackage = GameEnvManager.getEnginePackage();
    if (this.mAppConfig == null)
    {
      if (this.mEngineLoadResult != -1)
      {
        GameLog.getInstance().w(this.LOG_TAG, "[MiniEng] engine already loaded! status=" + this.mEngineLoadResult);
        return;
      }
      this.mEngineLoadResult = loadTritonPlatform();
      if (this.mEngineLoadResult == 0)
      {
        onTaskSucceed();
        return;
      }
      onTaskFailed(this.mEngineLoadResult, amtj.a(2131704174));
      return;
    }
    if (isGameSatisfy(this.mEnginePackage, this.mAppConfig))
    {
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1012, "1");
      if (this.mEngineLoadResult != -1)
      {
        GameLog.getInstance().w(this.LOG_TAG, "[MiniEng] engine already loaded! status=" + this.mEngineLoadResult);
        return;
      }
      this.mEngineLoadResult = loadTritonPlatform();
      if (this.mEngineLoadResult == 0)
      {
        onTaskSucceed();
        return;
      }
      MiniProgramLpReportDC04239.reportPageView(this.mAppConfig, "1", null, "load_fail", "load_baselib_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "load_baselib_fail", null, this.mAppConfig);
      onTaskFailed(this.mEngineLoadResult, amtj.a(2131704174));
      return;
    }
    if ((this.mAppConfig != null) && (this.mAppConfig.config != null) && (!TextUtils.isEmpty(this.mAppConfig.config.appId))) {
      MiniAppStartState.setBaseLibLoad(this.mAppConfig.config.appId, false);
    }
    onTaskFailed(104, "请升级QQ版本");
  }
  
  /* Error */
  private int loadTritonPlatform()
  {
    // Byte code:
    //   0: bipush 106
    //   2: istore_1
    //   3: aload_0
    //   4: monitorenter
    //   5: invokestatic 255	com/tencent/mobileqq/mini/report/MiniProgramReportHelper:miniAppConfigForPreload	()Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   8: sipush 1014
    //   11: ldc_w 257
    //   14: invokestatic 263	com/tencent/mobileqq/mini/report/MiniReportManager:reportEventType	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 219	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:mEnginePackage	Lcom/tencent/mobileqq/minigame/api/QQMiniEnginePackage;
    //   21: invokevirtual 298	com/tencent/mobileqq/minigame/api/QQMiniEnginePackage:getEngineJar	()Ljava/io/File;
    //   24: ifnull +15 -> 39
    //   27: invokestatic 255	com/tencent/mobileqq/mini/report/MiniProgramReportHelper:miniAppConfigForPreload	()Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   30: sipush 1003
    //   33: ldc_w 257
    //   36: invokestatic 263	com/tencent/mobileqq/mini/report/MiniReportManager:reportEventType	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;ILjava/lang/String;)V
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 302	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:mContext	Landroid/content/Context;
    //   44: invokestatic 308	com/tencent/mobileqq/minigame/api/QQTritonPlatformManager:getTritonPlatform	(Landroid/content/Context;)Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   47: putfield 310	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:mTritonPlatform	Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   50: aload_0
    //   51: getfield 219	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:mEnginePackage	Lcom/tencent/mobileqq/minigame/api/QQMiniEnginePackage;
    //   54: invokevirtual 298	com/tencent/mobileqq/minigame/api/QQMiniEnginePackage:getEngineJar	()Ljava/io/File;
    //   57: ifnull +15 -> 72
    //   60: invokestatic 255	com/tencent/mobileqq/mini/report/MiniProgramReportHelper:miniAppConfigForPreload	()Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   63: sipush 1004
    //   66: ldc_w 257
    //   69: invokestatic 263	com/tencent/mobileqq/mini/report/MiniReportManager:reportEventType	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;ILjava/lang/String;)V
    //   72: aload_0
    //   73: getfield 310	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:mTritonPlatform	Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   76: ifnonnull +69 -> 145
    //   79: invokestatic 61	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   82: aload_0
    //   83: getfield 55	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:LOG_TAG	Ljava/lang/String;
    //   86: ldc_w 312
    //   89: invokevirtual 162	com/tencent/mobileqq/minigame/utils/GameLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   92: pop
    //   93: aload_0
    //   94: monitorexit
    //   95: iload_1
    //   96: ireturn
    //   97: astore 4
    //   99: invokestatic 61	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   102: aload_0
    //   103: getfield 55	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:LOG_TAG	Ljava/lang/String;
    //   106: ldc_w 314
    //   109: aload 4
    //   111: invokevirtual 317	com/tencent/mobileqq/minigame/utils/GameLog:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   114: pop
    //   115: goto -22 -> 93
    //   118: astore 4
    //   120: aload_0
    //   121: monitorexit
    //   122: aload 4
    //   124: athrow
    //   125: astore 4
    //   127: aload_0
    //   128: aload_0
    //   129: getfield 219	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:mEnginePackage	Lcom/tencent/mobileqq/minigame/api/QQMiniEnginePackage;
    //   132: aload 4
    //   134: invokespecial 319	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:handleException	(Lcom/tencent/mobileqq/minigame/api/QQMiniEnginePackage;Ljava/lang/Throwable;)V
    //   137: goto -65 -> 72
    //   140: astore 4
    //   142: goto -70 -> 72
    //   145: invokestatic 325	java/lang/System:currentTimeMillis	()J
    //   148: lstore_2
    //   149: invokestatic 61	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   152: aload_0
    //   153: getfield 55	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:LOG_TAG	Ljava/lang/String;
    //   156: ldc_w 327
    //   159: invokevirtual 67	com/tencent/mobileqq/minigame/utils/GameLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   162: pop
    //   163: ldc_w 329
    //   166: iconst_1
    //   167: new 87	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 331
    //   177: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokestatic 325	java/lang/System:currentTimeMillis	()J
    //   183: lload_2
    //   184: lsub
    //   185: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   188: ldc_w 336
    //   191: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 341	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: invokestatic 255	com/tencent/mobileqq/mini/report/MiniProgramReportHelper:miniAppConfigForPreload	()Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   203: sipush 1015
    //   206: ldc_w 257
    //   209: invokestatic 263	com/tencent/mobileqq/mini/report/MiniReportManager:reportEventType	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;ILjava/lang/String;)V
    //   212: iconst_0
    //   213: istore_1
    //   214: goto -121 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	TritonEngineInitTask
    //   2	212	1	i	int
    //   148	36	2	l	long
    //   97	13	4	localTritonInitException	com.tencent.mobileqq.triton.exception.TritonInitException
    //   118	5	4	localObject	Object
    //   125	8	4	localThrowable1	Throwable
    //   140	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   39	72	97	com/tencent/mobileqq/triton/exception/TritonInitException
    //   5	39	118	finally
    //   39	72	118	finally
    //   72	93	118	finally
    //   99	115	118	finally
    //   127	137	118	finally
    //   145	212	118	finally
    //   39	72	125	java/lang/Throwable
    //   127	137	140	java/lang/Throwable
  }
  
  private void reportEngineCreateException(Throwable paramThrowable)
  {
    Object localObject = new File(this.mContext.getFilesDir().getParent() + "/lib/libtriton.so");
    if (((File)localObject).exists()) {}
    for (long l = ((File)localObject).length();; l = -1L)
    {
      localObject = MiniProgramReportHelper.miniAppConfigForPreload();
      String str = this.mFrom.toString();
      if (paramThrowable != null) {}
      for (paramThrowable = paramThrowable.getMessage();; paramThrowable = null)
      {
        MiniReportManager.reportEventType((MiniAppConfig)localObject, 1050, "1", str, String.valueOf(l), paramThrowable, null);
        return;
      }
    }
  }
  
  public void executeAsync()
  {
    loadTritonEngine();
  }
  
  public MiniAppConfig getAppConfig()
  {
    return this.mAppConfig;
  }
  
  public QQMiniEnginePackage getEnginePackage()
  {
    return this.mEnginePackage;
  }
  
  @NonNull
  public String getName()
  {
    return "TritonEngineInitTask";
  }
  
  public TritonPlatform getTritonPlatform()
  {
    return this.mTritonPlatform;
  }
  
  public void reset()
  {
    try
    {
      GameLog.getInstance().i(this.LOG_TAG, "[MiniEng]" + this + " reset ");
      this.mAppConfig = null;
      this.mEngineLoadResult = -1;
      super.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setAppConfig(MiniAppConfig paramMiniAppConfig)
  {
    this.mAppConfig = paramMiniAppConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.TritonEngineInitTask
 * JD-Core Version:    0.7.0.1
 */