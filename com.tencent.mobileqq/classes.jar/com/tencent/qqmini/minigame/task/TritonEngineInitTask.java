package com.tencent.qqmini.minigame.task;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.mobileqq.triton.exception.TritonInitException;
import com.tencent.qqmini.minigame.api.MiniEnginePackage;
import com.tencent.qqmini.minigame.api.TritonPlatformManager;
import com.tencent.qqmini.minigame.manager.EnginePackageManager;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
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
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramMiniAppInfo == null)
    {
      GameLog.getInstance().e(this.sTAG, "[MiniEng]isGameSatisfy info == null");
      bool1 = false;
    }
    do
    {
      return bool1;
      paramMiniAppInfo = paramMiniAppInfo.baselibMiniVersion;
      GameLog.getInstance().i(this.sTAG, "[MiniEng]isGameSatisfy minVersion=" + paramMiniAppInfo);
    } while (TextUtils.isEmpty(paramMiniAppInfo));
    paramMiniAppInfo = new EngineVersion(paramMiniAppInfo);
    paramMiniEnginePackage = EngineVersion.fromFolderName(paramMiniEnginePackage.getBaseLibDir().getAbsolutePath());
    if ((paramMiniEnginePackage != null) && (EngineVersion.compareVersion(paramMiniEnginePackage.mMinor, paramMiniAppInfo.mMinor) >= 0)) {}
    for (bool1 = bool2;; bool1 = false)
    {
      GameLog.getInstance().i(this.sTAG, "[MiniEng]isGameSatisfy appMinVersion=" + paramMiniAppInfo + ", jsSdkVersion=" + paramMiniEnginePackage + ",ret=" + bool1);
      return bool1;
    }
  }
  
  private int loadEnginePlatform()
  {
    try
    {
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1014, "1");
      MiniEnginePackage localMiniEnginePackage = EnginePackageManager.getEnginePackage();
      if (localMiniEnginePackage.getEngineJar() != null) {
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1003, "1");
      }
      try
      {
        this.mTritonPlatform = TritonPlatformManager.getTritonPlatform(this.mContext);
        if (localMiniEnginePackage.getEngineJar() != null) {
          MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1004, "1");
        }
        long l = System.currentTimeMillis();
        GameLog.getInstance().i(this.sTAG, "[MiniEng] initEngine");
        QMLog.e("[minigame][timecost] ", "[MiniEng] step[initTTEngine] cost time " + (System.currentTimeMillis() - l) + ", includes steps[load so, cache jssdk]");
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1015, "1");
        i = 0;
      }
      catch (TritonInitException localTritonInitException)
      {
        for (;;)
        {
          GameLog.getInstance().e(this.sTAG, "[MiniEng] TTEngineBuilder create TTEngine failed with exception", localTritonInitException);
          int i = 106;
        }
      }
      return i;
    }
    finally {}
  }
  
  private void loadTritonEngine()
  {
    if (this.mMiniAppInfo == null)
    {
      if (this.mEngineLoadResult != -1)
      {
        GameLog.getInstance().w(this.sTAG, "[MiniEng] engine already loaded! status=" + this.mEngineLoadResult);
        return;
      }
      this.mEngineLoadResult = loadEnginePlatform();
      if (this.mEngineLoadResult == 0)
      {
        onTaskSucceed();
        return;
      }
      onTaskFailed(this.mEngineLoadResult, "加载引擎失败");
      return;
    }
    if (isGameSatisfy(EnginePackageManager.getEnginePackage(), this.mMiniAppInfo))
    {
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1012, "1");
      if (this.mEngineLoadResult != -1)
      {
        GameLog.getInstance().w(this.sTAG, "[MiniEng] engine already loaded! status=" + this.mEngineLoadResult);
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
    if ((this.mMiniAppInfo != null) && (!TextUtils.isEmpty(this.mMiniAppInfo.appId))) {
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
      GameLog.getInstance().i(this.sTAG, "[MiniEng]" + this + " reset ");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.task.TritonEngineInitTask
 * JD-Core Version:    0.7.0.1
 */