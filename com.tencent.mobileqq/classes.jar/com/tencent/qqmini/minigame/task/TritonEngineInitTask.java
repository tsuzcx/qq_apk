package com.tencent.qqmini.minigame.task;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.qqmini.minigame.api.MiniEnginePackage;
import com.tencent.qqmini.minigame.manager.EnginePackageManager;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.BaseTask;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import java.io.File;

@ClassTag(tag="TritonEngineInitTask")
public class TritonEngineInitTask
  extends BaseTask
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
  private int mEngineLoadResult = -1;
  private volatile MiniEnginePackage mLoadedEnginePackage = null;
  private MiniAppInfo mMiniAppInfo;
  private TritonPlatform mTritonPlatform;
  private final String sTAG = toString();
  
  public TritonEngineInitTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
    GameLog.getInstance().i(this.sTAG, "new TritonEngineInitTask");
  }
  
  private boolean isGameSatisfy(@NonNull MiniEnginePackage paramMiniEnginePackage, MiniAppInfo paramMiniAppInfo)
  {
    boolean bool2 = false;
    if (paramMiniAppInfo == null)
    {
      GameLog.getInstance().e(this.sTAG, "[MiniEng]isGameSatisfy info == null");
      return false;
    }
    paramMiniAppInfo = paramMiniAppInfo.baselibMiniVersion;
    GameLog localGameLog = GameLog.getInstance();
    String str = this.sTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng]isGameSatisfy minVersion=");
    localStringBuilder.append(paramMiniAppInfo);
    localGameLog.i(str, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramMiniAppInfo)) {
      return true;
    }
    paramMiniAppInfo = new EngineVersion(paramMiniAppInfo);
    paramMiniEnginePackage = EngineVersion.fromFolderName(paramMiniEnginePackage.getBaseLibDir().getAbsolutePath());
    boolean bool1 = bool2;
    if (paramMiniEnginePackage != null)
    {
      bool1 = bool2;
      if (EngineVersion.compareVersion(paramMiniEnginePackage.mMinor, paramMiniAppInfo.mMinor) >= 0) {
        bool1 = true;
      }
    }
    localGameLog = GameLog.getInstance();
    str = this.sTAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng]isGameSatisfy appMinVersion=");
    localStringBuilder.append(paramMiniAppInfo);
    localStringBuilder.append(", jsSdkVersion=");
    localStringBuilder.append(paramMiniEnginePackage);
    localStringBuilder.append(",ret=");
    localStringBuilder.append(bool1);
    localGameLog.i(str, localStringBuilder.toString());
    return bool1;
  }
  
  /* Error */
  private int loadEnginePlatform(MiniEnginePackage paramMiniEnginePackage)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   5: lstore_2
    //   6: invokestatic 159	com/tencent/qqmini/sdk/report/MiniProgramReportHelper:miniAppConfigForPreload	()Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   9: sipush 1014
    //   12: ldc 161
    //   14: invokestatic 167	com/tencent/qqmini/sdk/report/MiniReportManager:reportEventType	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;ILjava/lang/String;)V
    //   17: aload_1
    //   18: invokevirtual 170	com/tencent/qqmini/minigame/api/MiniEnginePackage:getEngineJar	()Ljava/io/File;
    //   21: ifnull +14 -> 35
    //   24: invokestatic 159	com/tencent/qqmini/sdk/report/MiniProgramReportHelper:miniAppConfigForPreload	()Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   27: sipush 1003
    //   30: ldc 161
    //   32: invokestatic 167	com/tencent/qqmini/sdk/report/MiniReportManager:reportEventType	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;ILjava/lang/String;)V
    //   35: aload_0
    //   36: aload_1
    //   37: putfield 49	com/tencent/qqmini/minigame/task/TritonEngineInitTask:mLoadedEnginePackage	Lcom/tencent/qqmini/minigame/api/MiniEnginePackage;
    //   40: aload_0
    //   41: aload_0
    //   42: getfield 174	com/tencent/qqmini/minigame/task/TritonEngineInitTask:mContext	Landroid/content/Context;
    //   45: aload_1
    //   46: invokestatic 180	com/tencent/qqmini/minigame/api/TritonPlatformManager:getTritonPlatform	(Landroid/content/Context;Lcom/tencent/qqmini/minigame/api/MiniEnginePackage;)Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   49: putfield 182	com/tencent/qqmini/minigame/task/TritonEngineInitTask:mTritonPlatform	Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   52: aload_1
    //   53: invokevirtual 170	com/tencent/qqmini/minigame/api/MiniEnginePackage:getEngineJar	()Ljava/io/File;
    //   56: ifnull +14 -> 70
    //   59: invokestatic 159	com/tencent/qqmini/sdk/report/MiniProgramReportHelper:miniAppConfigForPreload	()Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   62: sipush 1004
    //   65: ldc 161
    //   67: invokestatic 167	com/tencent/qqmini/sdk/report/MiniReportManager:reportEventType	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;ILjava/lang/String;)V
    //   70: invokestatic 61	com/tencent/qqmini/minigame/utils/GameLog:getInstance	()Lcom/tencent/qqmini/minigame/utils/GameLog;
    //   73: aload_0
    //   74: getfield 55	com/tencent/qqmini/minigame/task/TritonEngineInitTask:sTAG	Ljava/lang/String;
    //   77: ldc 184
    //   79: invokevirtual 67	com/tencent/qqmini/minigame/utils/GameLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   82: pop
    //   83: new 89	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   90: astore_1
    //   91: aload_1
    //   92: ldc 186
    //   94: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_1
    //   99: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   102: lload_2
    //   103: lsub
    //   104: invokevirtual 189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_1
    //   109: ldc 191
    //   111: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: ldc 193
    //   117: aload_1
    //   118: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 198	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: invokestatic 159	com/tencent/qqmini/sdk/report/MiniProgramReportHelper:miniAppConfigForPreload	()Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   127: sipush 1015
    //   130: ldc 161
    //   132: invokestatic 167	com/tencent/qqmini/sdk/report/MiniReportManager:reportEventType	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;ILjava/lang/String;)V
    //   135: aload_0
    //   136: monitorexit
    //   137: iconst_0
    //   138: ireturn
    //   139: astore_1
    //   140: invokestatic 61	com/tencent/qqmini/minigame/utils/GameLog:getInstance	()Lcom/tencent/qqmini/minigame/utils/GameLog;
    //   143: aload_0
    //   144: getfield 55	com/tencent/qqmini/minigame/task/TritonEngineInitTask:sTAG	Ljava/lang/String;
    //   147: ldc 200
    //   149: aload_1
    //   150: invokevirtual 203	com/tencent/qqmini/minigame/utils/GameLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   153: pop
    //   154: aload_0
    //   155: monitorexit
    //   156: bipush 106
    //   158: ireturn
    //   159: astore_1
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	TritonEngineInitTask
    //   0	164	1	paramMiniEnginePackage	MiniEnginePackage
    //   5	98	2	l	long
    // Exception table:
    //   from	to	target	type
    //   40	70	139	com/tencent/mobileqq/triton/exception/TritonInitException
    //   2	35	159	finally
    //   35	40	159	finally
    //   40	70	159	finally
    //   70	135	159	finally
    //   140	154	159	finally
  }
  
  private void loadTritonEngine()
  {
    Object localObject1 = EnginePackageManager.getEnginePackage();
    Object localObject2 = this.mMiniAppInfo;
    StringBuilder localStringBuilder;
    if (localObject2 == null)
    {
      if (this.mEngineLoadResult != -1)
      {
        localObject1 = GameLog.getInstance();
        localObject2 = this.sTAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MiniEng] engine already loaded! status=");
        localStringBuilder.append(this.mEngineLoadResult);
        ((GameLog)localObject1).w((String)localObject2, localStringBuilder.toString());
        return;
      }
      this.mEngineLoadResult = loadEnginePlatform((MiniEnginePackage)localObject1);
      int i = this.mEngineLoadResult;
      if (i == 0)
      {
        onTaskSucceed();
        return;
      }
      onTaskFailed(i, "加载引擎失败");
      return;
    }
    if (isGameSatisfy((MiniEnginePackage)localObject1, (MiniAppInfo)localObject2))
    {
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1012, "1");
      if (this.mEngineLoadResult != -1)
      {
        localObject1 = GameLog.getInstance();
        localObject2 = this.sTAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MiniEng] engine already loaded! status=");
        localStringBuilder.append(this.mEngineLoadResult);
        ((GameLog)localObject1).w((String)localObject2, localStringBuilder.toString());
        return;
      }
      this.mEngineLoadResult = loadEnginePlatform((MiniEnginePackage)localObject1);
      if (this.mEngineLoadResult == 0)
      {
        onTaskSucceed();
        return;
      }
      SDKMiniProgramLpReportDC04239.reportPageView(this.mMiniAppInfo, "1", null, "load_fail", "load_baselib_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "load_baselib_fail", null, this.mMiniAppInfo);
      onTaskFailed(this.mEngineLoadResult, "加载引擎失败");
      return;
    }
    localObject1 = this.mMiniAppInfo;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((MiniAppInfo)localObject1).appId))) {
      MiniAppStartState.setBaseLibLoad(this.mMiniAppInfo.appId, false);
    }
    onTaskFailed(104, "请升级QQ版本");
  }
  
  public void execute()
  {
    ThreadManager.executeOnNetworkIOThreadPool(new TritonEngineInitTask.1(this));
  }
  
  public MiniEnginePackage getEnginePackage()
  {
    try
    {
      if (this.mLoadedEnginePackage == null)
      {
        GameLog.getInstance().e(this.sTAG, "engine not loaded");
        this.mLoadedEnginePackage = EnginePackageManager.getEnginePackage();
      }
      MiniEnginePackage localMiniEnginePackage = this.mLoadedEnginePackage;
      return localMiniEnginePackage;
    }
    finally {}
  }
  
  @NonNull
  public TaskExecutionStatics getExecutionStatics()
  {
    return super.getExecutionStatics();
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.mMiniAppInfo;
  }
  
  public TritonPlatform getTritonPlatform()
  {
    return this.mTritonPlatform;
  }
  
  public void reset()
  {
    try
    {
      GameLog localGameLog = GameLog.getInstance();
      String str = this.sTAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MiniEng]");
      localStringBuilder.append(this);
      localStringBuilder.append(" reset ");
      localGameLog.i(str, localStringBuilder.toString());
      this.mMiniAppInfo = null;
      this.mEngineLoadResult = -1;
      this.mLoadedEnginePackage = null;
      super.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.mMiniAppInfo = paramMiniAppInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.task.TritonEngineInitTask
 * JD-Core Version:    0.7.0.1
 */