package com.tencent.qqmini.minigame.task;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.qqmini.minigame.api.MiniEnginePackage;
import com.tencent.qqmini.minigame.manager.EnginePackageManager;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import java.io.File;

@ClassTag(tag="TritonEngineInitTask")
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
  private int mEngineLoadResult = -1;
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
  private int loadEnginePlatform()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 144	com/tencent/qqmini/sdk/report/MiniProgramReportHelper:miniAppConfigForPreload	()Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   5: sipush 1014
    //   8: ldc 146
    //   10: invokestatic 152	com/tencent/qqmini/sdk/report/MiniReportManager:reportEventType	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;ILjava/lang/String;)V
    //   13: invokestatic 158	com/tencent/qqmini/minigame/manager/EnginePackageManager:getEnginePackage	()Lcom/tencent/qqmini/minigame/api/MiniEnginePackage;
    //   16: astore_3
    //   17: aload_3
    //   18: invokevirtual 161	com/tencent/qqmini/minigame/api/MiniEnginePackage:getEngineJar	()Ljava/io/File;
    //   21: ifnull +14 -> 35
    //   24: invokestatic 144	com/tencent/qqmini/sdk/report/MiniProgramReportHelper:miniAppConfigForPreload	()Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   27: sipush 1003
    //   30: ldc 146
    //   32: invokestatic 152	com/tencent/qqmini/sdk/report/MiniReportManager:reportEventType	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;ILjava/lang/String;)V
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 165	com/tencent/qqmini/minigame/task/TritonEngineInitTask:mContext	Landroid/content/Context;
    //   40: invokestatic 171	com/tencent/qqmini/minigame/api/TritonPlatformManager:getTritonPlatform	(Landroid/content/Context;)Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   43: putfield 173	com/tencent/qqmini/minigame/task/TritonEngineInitTask:mTritonPlatform	Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   46: aload_3
    //   47: invokevirtual 161	com/tencent/qqmini/minigame/api/MiniEnginePackage:getEngineJar	()Ljava/io/File;
    //   50: ifnull +14 -> 64
    //   53: invokestatic 144	com/tencent/qqmini/sdk/report/MiniProgramReportHelper:miniAppConfigForPreload	()Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   56: sipush 1004
    //   59: ldc 146
    //   61: invokestatic 152	com/tencent/qqmini/sdk/report/MiniReportManager:reportEventType	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;ILjava/lang/String;)V
    //   64: invokestatic 179	java/lang/System:currentTimeMillis	()J
    //   67: lstore_1
    //   68: invokestatic 57	com/tencent/qqmini/minigame/utils/GameLog:getInstance	()Lcom/tencent/qqmini/minigame/utils/GameLog;
    //   71: aload_0
    //   72: getfield 51	com/tencent/qqmini/minigame/task/TritonEngineInitTask:sTAG	Ljava/lang/String;
    //   75: ldc 181
    //   77: invokevirtual 63	com/tencent/qqmini/minigame/utils/GameLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   80: pop
    //   81: new 79	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   88: astore_3
    //   89: aload_3
    //   90: ldc 183
    //   92: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_3
    //   97: invokestatic 179	java/lang/System:currentTimeMillis	()J
    //   100: lload_1
    //   101: lsub
    //   102: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_3
    //   107: ldc 188
    //   109: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: ldc 190
    //   115: aload_3
    //   116: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 195	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: invokestatic 144	com/tencent/qqmini/sdk/report/MiniProgramReportHelper:miniAppConfigForPreload	()Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   125: sipush 1015
    //   128: ldc 146
    //   130: invokestatic 152	com/tencent/qqmini/sdk/report/MiniReportManager:reportEventType	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;ILjava/lang/String;)V
    //   133: aload_0
    //   134: monitorexit
    //   135: iconst_0
    //   136: ireturn
    //   137: astore_3
    //   138: invokestatic 57	com/tencent/qqmini/minigame/utils/GameLog:getInstance	()Lcom/tencent/qqmini/minigame/utils/GameLog;
    //   141: aload_0
    //   142: getfield 51	com/tencent/qqmini/minigame/task/TritonEngineInitTask:sTAG	Ljava/lang/String;
    //   145: ldc 197
    //   147: aload_3
    //   148: invokevirtual 200	com/tencent/qqmini/minigame/utils/GameLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   151: pop
    //   152: aload_0
    //   153: monitorexit
    //   154: bipush 106
    //   156: ireturn
    //   157: astore_3
    //   158: aload_0
    //   159: monitorexit
    //   160: aload_3
    //   161: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	TritonEngineInitTask
    //   67	34	1	l	long
    //   16	100	3	localObject1	Object
    //   137	11	3	localTritonInitException	com.tencent.mobileqq.triton.exception.TritonInitException
    //   157	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	64	137	com/tencent/mobileqq/triton/exception/TritonInitException
    //   2	35	157	finally
    //   35	64	157	finally
    //   64	133	157	finally
    //   138	152	157	finally
  }
  
  private void loadTritonEngine()
  {
    String str;
    StringBuilder localStringBuilder;
    if (this.mMiniAppInfo == null)
    {
      if (this.mEngineLoadResult != -1)
      {
        localObject = GameLog.getInstance();
        str = this.sTAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MiniEng] engine already loaded! status=");
        localStringBuilder.append(this.mEngineLoadResult);
        ((GameLog)localObject).w(str, localStringBuilder.toString());
        return;
      }
      this.mEngineLoadResult = loadEnginePlatform();
      int i = this.mEngineLoadResult;
      if (i == 0)
      {
        onTaskSucceed();
        return;
      }
      onTaskFailed(i, "加载引擎失败");
      return;
    }
    if (isGameSatisfy(EnginePackageManager.getEnginePackage(), this.mMiniAppInfo))
    {
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1012, "1");
      if (this.mEngineLoadResult != -1)
      {
        localObject = GameLog.getInstance();
        str = this.sTAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MiniEng] engine already loaded! status=");
        localStringBuilder.append(this.mEngineLoadResult);
        ((GameLog)localObject).w(str, localStringBuilder.toString());
        return;
      }
      this.mEngineLoadResult = loadEnginePlatform();
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
    Object localObject = this.mMiniAppInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((MiniAppInfo)localObject).appId))) {
      MiniAppStartState.setBaseLibLoad(this.mMiniAppInfo.appId, false);
    }
    onTaskFailed(104, "请升级QQ版本");
  }
  
  public void executeAsync()
  {
    loadTritonEngine();
  }
  
  public MiniEnginePackage getEnginePackage()
  {
    return EnginePackageManager.getEnginePackage();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.task.TritonEngineInitTask
 * JD-Core Version:    0.7.0.1
 */