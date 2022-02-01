package com.tencent.mobileqq.minigame.task;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import anni;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniAppStartState;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.minigame.manager.EngineVersion;
import com.tencent.mobileqq.minigame.manager.GameEngineWrapper;
import com.tencent.mobileqq.minigame.manager.GameEnvManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager.PREPARE_FROM;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.triton.sdk.EnvConfig;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.Version;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
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
  private EnvConfig mEnvConfig;
  private GameRuntimeLoaderManager.PREPARE_FROM mFrom;
  private GameEngineWrapper mGameEngine;
  private final IJSEngine mJSEngine;
  private IQQEnv mQQEnv;
  
  public TritonEngineInitTask(Context paramContext, IQQEnv paramIQQEnv, IJSEngine paramIJSEngine, GameRuntimeLoaderManager.PREPARE_FROM paramPREPARE_FROM)
  {
    super(paramContext);
    GameLog.getInstance().i(this.LOG_TAG, "new TritonEngineInitTask");
    this.mQQEnv = paramIQQEnv;
    this.mJSEngine = paramIJSEngine;
    this.mGameEngine = new GameEngineWrapper();
    this.mFrom = paramPREPARE_FROM;
  }
  
  private String getTritonDexPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(paramString);
    if (paramString.endsWith(File.separator)) {}
    for (paramString = "";; paramString = File.separator) {
      return paramString + "triton.jar";
    }
  }
  
  private void handleException(EnvConfig paramEnvConfig, Throwable paramThrowable)
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
      if ((paramEnvConfig.getTritonVersion() != null) && (!TextUtils.isEmpty(str2)))
      {
        paramEnvConfig = new BaseLibInfo();
        paramEnvConfig.baseLibUrl = str2;
        paramEnvConfig.baseLibVersion = str1;
        localObject = new Version(str1, Long.parseLong((String)localObject));
        GameLog.getInstance().i(this.LOG_TAG, "[MiniEng] download backup triton:" + paramEnvConfig + ", version:" + localObject);
        GameEnvManager.downloadLatestTritonEngine(paramEnvConfig, (Version)localObject, new TritonEngineInitTask.1(this));
      }
      reportEngineCreateException(paramThrowable);
      return;
      str1 = null;
      str2 = null;
    }
  }
  
  private boolean hasNewEngineDex(String paramString)
  {
    if (!GameWnsUtils.gameEnableDexLoader()) {}
    do
    {
      return false;
      paramString = getTritonDexPath(paramString);
    } while (TextUtils.isEmpty(paramString));
    return new File(paramString).exists();
  }
  
  private boolean isGameSatisfy(EnvConfig paramEnvConfig, MiniAppConfig paramMiniAppConfig)
  {
    boolean bool = true;
    if (paramEnvConfig == null)
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
    paramEnvConfig = EngineVersion.fromFolderName(paramEnvConfig.getJSPath());
    if ((paramEnvConfig != null) && (EngineVersion.compareVersion(paramEnvConfig.mMinor, paramMiniAppConfig.mMinor) >= 0)) {}
    for (;;)
    {
      GameLog.getInstance().i(this.LOG_TAG, "[MiniEng]isGameSatisfy appMinVersion=" + paramMiniAppConfig + ", jsSdkVersion=" + paramEnvConfig + ",ret=" + bool);
      return bool;
      bool = false;
    }
  }
  
  /* Error */
  private int loadEngine(EnvConfig paramEnvConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 257	com/tencent/mobileqq/mini/report/MiniProgramReportHelper:miniAppConfigForPreload	()Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   5: sipush 1014
    //   8: ldc_w 259
    //   11: invokestatic 265	com/tencent/mobileqq/mini/report/MiniReportManager:reportEventType	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;ILjava/lang/String;)V
    //   14: new 267	com/tencent/mobileqq/triton/sdk/TTEngineBuilder
    //   17: dup
    //   18: invokespecial 268	com/tencent/mobileqq/triton/sdk/TTEngineBuilder:<init>	()V
    //   21: astore 7
    //   23: aload 7
    //   25: aload_0
    //   26: getfield 272	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:mContext	Landroid/content/Context;
    //   29: invokevirtual 276	com/tencent/mobileqq/triton/sdk/TTEngineBuilder:setContext	(Landroid/content/Context;)Lcom/tencent/mobileqq/triton/sdk/TTEngineBuilder;
    //   32: aload_0
    //   33: getfield 73	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:mQQEnv	Lcom/tencent/mobileqq/triton/sdk/IQQEnv;
    //   36: invokevirtual 280	com/tencent/mobileqq/triton/sdk/TTEngineBuilder:setQQEnv	(Lcom/tencent/mobileqq/triton/sdk/IQQEnv;)Lcom/tencent/mobileqq/triton/sdk/TTEngineBuilder;
    //   39: invokestatic 65	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   42: invokevirtual 284	com/tencent/mobileqq/triton/sdk/TTEngineBuilder:setLog	(Lcom/tencent/mobileqq/triton/sdk/ITLog;)Lcom/tencent/mobileqq/triton/sdk/TTEngineBuilder;
    //   45: aload_0
    //   46: getfield 75	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:mJSEngine	Lcom/tencent/mobileqq/triton/sdk/bridge/IJSEngine;
    //   49: invokevirtual 288	com/tencent/mobileqq/triton/sdk/TTEngineBuilder:setJsEngine	(Lcom/tencent/mobileqq/triton/sdk/bridge/IJSEngine;)Lcom/tencent/mobileqq/triton/sdk/TTEngineBuilder;
    //   52: aload_1
    //   53: invokevirtual 292	com/tencent/mobileqq/triton/sdk/TTEngineBuilder:setEnvConfig	(Lcom/tencent/mobileqq/triton/sdk/EnvConfig;)Lcom/tencent/mobileqq/triton/sdk/TTEngineBuilder;
    //   56: pop
    //   57: aload_0
    //   58: invokevirtual 296	java/lang/Object:getClass	()Ljava/lang/Class;
    //   61: invokevirtual 302	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   64: astore 8
    //   66: aconst_null
    //   67: astore 6
    //   69: aconst_null
    //   70: astore 5
    //   72: aload_0
    //   73: aload_1
    //   74: invokevirtual 305	com/tencent/mobileqq/triton/sdk/EnvConfig:getTritonPath	()Ljava/lang/String;
    //   77: invokespecial 307	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:hasNewEngineDex	(Ljava/lang/String;)Z
    //   80: ifeq +125 -> 205
    //   83: invokestatic 65	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   86: aload_0
    //   87: getfield 59	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:LOG_TAG	Ljava/lang/String;
    //   90: ldc_w 309
    //   93: invokevirtual 71	com/tencent/mobileqq/minigame/utils/GameLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   96: pop
    //   97: invokestatic 257	com/tencent/mobileqq/mini/report/MiniProgramReportHelper:miniAppConfigForPreload	()Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   100: sipush 1003
    //   103: ldc_w 259
    //   106: invokestatic 265	com/tencent/mobileqq/mini/report/MiniReportManager:reportEventType	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;ILjava/lang/String;)V
    //   109: aload 7
    //   111: new 311	com/tencent/mobileqq/mini/util/MiniAppClassloader
    //   114: dup
    //   115: aload_0
    //   116: aload_1
    //   117: invokevirtual 305	com/tencent/mobileqq/triton/sdk/EnvConfig:getTritonPath	()Ljava/lang/String;
    //   120: invokespecial 190	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:getTritonDexPath	(Ljava/lang/String;)Ljava/lang/String;
    //   123: aload_0
    //   124: getfield 272	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:mContext	Landroid/content/Context;
    //   127: invokevirtual 317	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   130: getfield 322	android/content/pm/ApplicationInfo:nativeLibraryDir	Ljava/lang/String;
    //   133: aload_0
    //   134: invokevirtual 296	java/lang/Object:getClass	()Ljava/lang/Class;
    //   137: invokevirtual 302	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   140: invokespecial 325	com/tencent/mobileqq/mini/util/MiniAppClassloader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   143: invokevirtual 329	com/tencent/mobileqq/triton/sdk/TTEngineBuilder:build	(Ljava/lang/ClassLoader;)Lcom/tencent/mobileqq/triton/sdk/ITTEngine;
    //   146: astore 7
    //   148: aload 7
    //   150: astore 5
    //   152: aload 5
    //   154: astore 6
    //   156: aload 5
    //   158: ifnull +19 -> 177
    //   161: invokestatic 257	com/tencent/mobileqq/mini/report/MiniProgramReportHelper:miniAppConfigForPreload	()Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   164: sipush 1004
    //   167: ldc_w 259
    //   170: invokestatic 265	com/tencent/mobileqq/mini/report/MiniReportManager:reportEventType	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;ILjava/lang/String;)V
    //   173: aload 5
    //   175: astore 6
    //   177: aload 6
    //   179: astore_1
    //   180: aload_1
    //   181: ifnonnull +117 -> 298
    //   184: invokestatic 65	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   187: aload_0
    //   188: getfield 59	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:LOG_TAG	Ljava/lang/String;
    //   191: ldc_w 331
    //   194: invokevirtual 203	com/tencent/mobileqq/minigame/utils/GameLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   197: pop
    //   198: bipush 106
    //   200: istore_2
    //   201: aload_0
    //   202: monitorexit
    //   203: iload_2
    //   204: ireturn
    //   205: invokestatic 65	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   208: aload_0
    //   209: getfield 59	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:LOG_TAG	Ljava/lang/String;
    //   212: ldc_w 333
    //   215: invokevirtual 71	com/tencent/mobileqq/minigame/utils/GameLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   218: pop
    //   219: aload 7
    //   221: aload 8
    //   223: invokevirtual 329	com/tencent/mobileqq/triton/sdk/TTEngineBuilder:build	(Ljava/lang/ClassLoader;)Lcom/tencent/mobileqq/triton/sdk/ITTEngine;
    //   226: astore 7
    //   228: aload 7
    //   230: astore 6
    //   232: goto -55 -> 177
    //   235: astore 6
    //   237: aload 5
    //   239: astore_1
    //   240: aload 6
    //   242: astore 5
    //   244: invokestatic 65	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   247: aload_0
    //   248: getfield 59	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:LOG_TAG	Ljava/lang/String;
    //   251: ldc_w 335
    //   254: aload 5
    //   256: invokevirtual 338	com/tencent/mobileqq/minigame/utils/GameLog:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   259: pop
    //   260: goto -80 -> 180
    //   263: astore_1
    //   264: aload_0
    //   265: monitorexit
    //   266: aload_1
    //   267: athrow
    //   268: astore 7
    //   270: aload 6
    //   272: astore 5
    //   274: aload 7
    //   276: astore 6
    //   278: aload_0
    //   279: aload_1
    //   280: aload 6
    //   282: invokespecial 340	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:handleException	(Lcom/tencent/mobileqq/triton/sdk/EnvConfig;Ljava/lang/Throwable;)V
    //   285: aload 5
    //   287: astore_1
    //   288: goto -108 -> 180
    //   291: astore_1
    //   292: aload 5
    //   294: astore_1
    //   295: goto -115 -> 180
    //   298: aload_0
    //   299: getfield 82	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:mGameEngine	Lcom/tencent/mobileqq/minigame/manager/GameEngineWrapper;
    //   302: aload_1
    //   303: invokevirtual 344	com/tencent/mobileqq/minigame/manager/GameEngineWrapper:setBaseEngine	(Lcom/tencent/mobileqq/triton/sdk/ITTEngine;)V
    //   306: invokestatic 350	java/lang/System:currentTimeMillis	()J
    //   309: lstore_3
    //   310: invokestatic 65	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   313: aload_0
    //   314: getfield 59	com/tencent/mobileqq/minigame/task/TritonEngineInitTask:LOG_TAG	Ljava/lang/String;
    //   317: ldc_w 352
    //   320: invokevirtual 71	com/tencent/mobileqq/minigame/utils/GameLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   323: pop
    //   324: ldc_w 354
    //   327: iconst_1
    //   328: new 95	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 356
    //   338: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokestatic 350	java/lang/System:currentTimeMillis	()J
    //   344: lload_3
    //   345: lsub
    //   346: invokevirtual 359	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   349: ldc_w 361
    //   352: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 366	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: invokestatic 257	com/tencent/mobileqq/mini/report/MiniProgramReportHelper:miniAppConfigForPreload	()Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   364: sipush 1015
    //   367: ldc_w 259
    //   370: invokestatic 265	com/tencent/mobileqq/mini/report/MiniReportManager:reportEventType	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;ILjava/lang/String;)V
    //   373: iconst_0
    //   374: istore_2
    //   375: goto -174 -> 201
    //   378: astore 6
    //   380: goto -102 -> 278
    //   383: astore 6
    //   385: aload 5
    //   387: astore_1
    //   388: aload 6
    //   390: astore 5
    //   392: goto -148 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	TritonEngineInitTask
    //   0	395	1	paramEnvConfig	EnvConfig
    //   200	175	2	i	int
    //   309	36	3	l	long
    //   70	321	5	localObject1	Object
    //   67	164	6	localObject2	Object
    //   235	36	6	localEngineCreationException1	com.tencent.mobileqq.triton.sdk.TTEngineBuilder.EngineCreationException
    //   276	5	6	localThrowable1	Throwable
    //   378	1	6	localThrowable2	Throwable
    //   383	6	6	localEngineCreationException2	com.tencent.mobileqq.triton.sdk.TTEngineBuilder.EngineCreationException
    //   21	208	7	localObject3	Object
    //   268	7	7	localThrowable3	Throwable
    //   64	158	8	localClassLoader	java.lang.ClassLoader
    // Exception table:
    //   from	to	target	type
    //   72	148	235	com/tencent/mobileqq/triton/sdk/TTEngineBuilder$EngineCreationException
    //   205	228	235	com/tencent/mobileqq/triton/sdk/TTEngineBuilder$EngineCreationException
    //   2	66	263	finally
    //   72	148	263	finally
    //   161	173	263	finally
    //   184	198	263	finally
    //   205	228	263	finally
    //   244	260	263	finally
    //   278	285	263	finally
    //   298	373	263	finally
    //   72	148	268	java/lang/Throwable
    //   205	228	268	java/lang/Throwable
    //   278	285	291	java/lang/Throwable
    //   161	173	378	java/lang/Throwable
    //   161	173	383	com/tencent/mobileqq/triton/sdk/TTEngineBuilder$EngineCreationException
  }
  
  private void loadTritonEngine(EnvConfig paramEnvConfig)
  {
    if (this.mAppConfig == null)
    {
      if (this.mEngineLoadResult != -1)
      {
        GameLog.getInstance().w(this.LOG_TAG, "[MiniEng] engine already loaded! status=" + this.mEngineLoadResult);
        return;
      }
      this.mEngineLoadResult = loadEngine(paramEnvConfig);
      if (this.mEngineLoadResult == 0)
      {
        onTaskSucceed();
        return;
      }
      onTaskFailed(this.mEngineLoadResult, anni.a(2131703838));
      return;
    }
    if (isGameSatisfy(paramEnvConfig, this.mAppConfig))
    {
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1012, "1");
      if (this.mEngineLoadResult != -1)
      {
        GameLog.getInstance().w(this.LOG_TAG, "[MiniEng] engine already loaded! status=" + this.mEngineLoadResult);
        return;
      }
      this.mEngineLoadResult = loadEngine(paramEnvConfig);
      if (this.mEngineLoadResult == 0)
      {
        onTaskSucceed();
        return;
      }
      MiniProgramLpReportDC04239.reportPageView(this.mAppConfig, "1", null, "load_fail", "load_baselib_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "load_baselib_fail", null, this.mAppConfig);
      onTaskFailed(this.mEngineLoadResult, anni.a(2131703838));
      return;
    }
    if ((this.mAppConfig != null) && (this.mAppConfig.config != null) && (!TextUtils.isEmpty(this.mAppConfig.config.appId))) {
      MiniAppStartState.setBaseLibLoad(this.mAppConfig.config.appId, false);
    }
    onTaskFailed(104, "请升级QQ版本");
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
    this.mEnvConfig = GameEnvManager.getEnvConfig();
    this.mEnvConfig.setDisplayMetrics(DisplayUtil.getDisplayMetrics(this.mContext));
    this.mEnvConfig.setScreenRefreshRate(DisplayUtil.getScreenRefreshRate(this.mContext));
    loadTritonEngine(this.mEnvConfig);
  }
  
  public MiniAppConfig getAppConfig()
  {
    return this.mAppConfig;
  }
  
  public EnvConfig getEnvConfig()
  {
    return this.mEnvConfig;
  }
  
  public ITTEngine getGameEngine()
  {
    return this.mGameEngine;
  }
  
  @NonNull
  public String getName()
  {
    return "TritonEngineInitTask";
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