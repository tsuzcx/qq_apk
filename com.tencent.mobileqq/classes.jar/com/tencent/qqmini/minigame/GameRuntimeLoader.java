package com.tencent.qqmini.minigame;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.model.Version;
import com.tencent.qqmini.minigame.api.MiniEnginePackage;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.minigame.manager.GameReportManager;
import com.tencent.qqmini.minigame.report.MiniGameBeaconReport;
import com.tencent.qqmini.minigame.task.GpkgLoadAsyncTask;
import com.tencent.qqmini.minigame.task.InitGameRuntimeTask;
import com.tencent.qqmini.minigame.task.TritonEngineInitTask;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.runtime.AppStateManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.Creator;
import com.tencent.qqmini.sdk.task.BaseTask;
import com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import java.util.ArrayList;
import java.util.List;

@MiniKeep
public class GameRuntimeLoader
  extends BaseRuntimeLoader
{
  @MiniKeep
  public static final BaseRuntimeLoader.Creator<GameRuntimeLoader> CREATOR = new GameRuntimeLoader.1();
  public static final String LOG_TAG = "GameRuntimeLoader";
  private final Bundle mBundle;
  private GameInfoManager mGameInfoManager;
  private GpkgLoadAsyncTask mGpkgLoadTask;
  private InitGameRuntimeTask mInitGameRuntimeTask;
  private MiniAppInfoLoadTask mMiniAppInfoLoadTask;
  private TritonEngineInitTask mTritonEngineInitTask;
  private MiniGamePkg miniGamePkg;
  
  private GameRuntimeLoader(Context paramContext, Bundle paramBundle)
  {
    super(paramContext);
    this.mBundle = paramBundle;
  }
  
  private boolean isGameEngineReady()
  {
    return (this.mTritonEngineInitTask.isDone()) && (this.mTritonEngineInitTask.isSucceed());
  }
  
  private boolean isGamePkgReady(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      MiniGamePkg localMiniGamePkg = this.miniGamePkg;
      if ((localMiniGamePkg != null) && (TextUtils.equals(localMiniGamePkg.appId, paramMiniAppInfo.appId))) {
        return true;
      }
    }
    return false;
  }
  
  private void onGpkgLoadAsyncTaskDone(GpkgLoadAsyncTask paramGpkgLoadAsyncTask)
  {
    Object localObject;
    if (paramGpkgLoadAsyncTask.isSucceed())
    {
      this.miniGamePkg = paramGpkgLoadAsyncTask.getGpkgInfo();
      if (this.mMiniAppInfo != null)
      {
        localObject = new ApkgInfo(ApkgManager.getApkgFolderPath(this.mMiniAppInfo), this.mMiniAppInfo);
        MiniGamePkg localMiniGamePkg = this.miniGamePkg;
        if (localMiniGamePkg != null) {
          ((ApkgInfo)localObject).mConfigStr = localMiniGamePkg.mConfigStr;
        }
        this.mMiniAppInfo.apkgInfo = ((ApkgBaseInfo)localObject);
        updateMiniGameInfo(this.mMiniAppInfo);
      }
      this.mGameInfoManager.setLaunchOptions();
    }
    else
    {
      this.miniGamePkg = null;
      localObject = paramGpkgLoadAsyncTask.getMiniAppInfo();
      if (localObject != null)
      {
        SDKMiniProgramLpReportDC04239.reportForSDK((MiniAppInfo)localObject, "1", null, "page_view", "load_fail", "pkg_task_fail", "");
        MiniAppReportManager2.reportPageView("2launch_fail", "pkg_task_fail", null, (MiniAppInfo)localObject);
      }
    }
    int i;
    if (paramGpkgLoadAsyncTask.isSucceed()) {
      i = 2002;
    } else {
      i = 2003;
    }
    notifyRuntimeEvent(i, new Object[] { paramGpkgLoadAsyncTask.msg });
  }
  
  private void onInitGameRuntimeTaskDone(InitGameRuntimeTask paramInitGameRuntimeTask)
  {
    if (paramInitGameRuntimeTask.isSucceed())
    {
      this.mIsRunning = false;
      notifyRuntimeEvent(2021, new Object[0]);
      onRuntimeLoadResult(0, "Load runtime successfully");
    }
  }
  
  private void onMiniAppInfoLoadTaskDone(MiniAppInfoLoadTask paramMiniAppInfoLoadTask)
  {
    if (!paramMiniAppInfoLoadTask.isSucceed()) {
      return;
    }
    this.mMiniAppInfo = paramMiniAppInfoLoadTask.getMiniAppInfo();
    this.mGpkgLoadTask.setMiniAppInfo(this.mMiniAppInfo);
  }
  
  private void onTritonEngineInitTask(TritonEngineInitTask paramTritonEngineInitTask)
  {
    if (!paramTritonEngineInitTask.isSucceed())
    {
      localObject = paramTritonEngineInitTask.getMiniAppInfo();
      if (localObject != null)
      {
        SDKMiniProgramLpReportDC04239.reportForSDK((MiniAppInfo)localObject, "1", null, "page_view", "load_fail", "baselib_task_fail", "");
        MiniAppReportManager2.reportPageView("2launch_fail", "baselib_task_fail", null, (MiniAppInfo)localObject);
      }
    }
    else if (getAppStateManager().isFromPreload)
    {
      sendPreloadBaseLibVersion();
    }
    Object localObject = paramTritonEngineInitTask.getEnginePackage();
    ((GameRuntime)getRuntime()).setEnginePackage((MiniEnginePackage)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TritonEngine 初始化配置:");
    localStringBuilder.append(localObject);
    QMLog.i("BaseRuntimeLoader", localStringBuilder.toString());
    int i;
    if (paramTritonEngineInitTask.isSucceed()) {
      i = 2012;
    } else {
      i = 2013;
    }
    notifyRuntimeEvent(i, new Object[] { Integer.valueOf(paramTritonEngineInitTask.retCode) });
    if ((getAppStateManager().isFromPreload) && (this.mMiniAppInfo == null)) {
      preloadReport();
    }
  }
  
  private void preloadReport()
  {
    Bundle localBundle = this.mBundle;
    if (localBundle == null)
    {
      QMLog.e("BaseRuntimeLoader", "[preloadReport] mBundle null!");
      return;
    }
    long l1 = localBundle.getLong("time_start_broadcast", 0L);
    long l2 = this.mBundle.getLong("time_broadcast_receive", 0L);
    if (l1 != 0L)
    {
      if (l2 == 0L) {
        return;
      }
      MiniGameBeaconReport.reportPreloadTime(l1, l2, System.currentTimeMillis());
      this.mBundle.remove("time_start_broadcast");
      this.mBundle.remove("time_broadcast_receive");
    }
  }
  
  private void sendPreloadBaseLibVersion()
  {
    String str = this.mTritonEngineInitTask.getEnginePackage().getVersion().getVersion();
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("bundle_key_process_name", AppLoaderFactory.g().getProcessName());
    ((Bundle)localObject).putString("bundle_key_preload_game_baselib_version", str);
    AppBrandCmdProxy.g().sendCmd("cmd_on_preload_game_baselib", (Bundle)localObject, null);
    if (QMLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[MiniEng]preload jsLib version:");
      ((StringBuilder)localObject).append(str);
      QMLog.i("BaseRuntimeLoader", ((StringBuilder)localObject).toString());
    }
  }
  
  protected BaseRuntime createRuntime(Context paramContext)
  {
    paramContext = new GameRuntime(paramContext);
    paramContext.setRuntimeMsgObserver(this);
    this.mGameInfoManager = new GameInfoManager(this);
    GameReportManager localGameReportManager = new GameReportManager(this);
    paramContext.setGameInfoManager(this.mGameInfoManager);
    paramContext.setGameReportManager(localGameReportManager);
    this.mRuntime = paramContext;
    return paramContext;
  }
  
  public BaseTask[] createTasks()
  {
    this.mMiniAppInfoLoadTask = new MiniAppInfoLoadTask(this.mContext, this);
    this.mTritonEngineInitTask = new TritonEngineInitTask(this.mContext, this);
    this.mGpkgLoadTask = new GpkgLoadAsyncTask(this.mContext, this);
    this.mInitGameRuntimeTask = new InitGameRuntimeTask(this.mContext, this);
    this.mInitGameRuntimeTask.addDependTask(this.mTritonEngineInitTask).addDependTask(this.mGpkgLoadTask.addDependTask(this.mMiniAppInfoLoadTask));
    return new BaseTask[] { this.mInitGameRuntimeTask };
  }
  
  public boolean dismissLoadingAfterLoaded()
  {
    return false;
  }
  
  public MiniGamePkg getMiniGamePkg()
  {
    return this.miniGamePkg;
  }
  
  public List<TaskExecutionStatics> getTaskExecuteStatics()
  {
    ArrayList localArrayList = new ArrayList();
    BaseTask[] arrayOfBaseTask = this.mTasks;
    int j = arrayOfBaseTask.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(arrayOfBaseTask[i].getExecutionStatics());
      i += 1;
    }
    return localArrayList;
  }
  
  public boolean isGameReadyStart(MiniAppInfo paramMiniAppInfo)
  {
    return (isGameEngineReady()) && (isGamePkgReady(paramMiniAppInfo));
  }
  
  public void onDetachActivity(Activity paramActivity, boolean paramBoolean)
  {
    super.onDetachActivity(paramActivity, paramBoolean);
  }
  
  public void onMiniPause()
  {
    if (!isLoadSucceed()) {
      return;
    }
    super.onMiniPause();
  }
  
  public void onMiniResume()
  {
    if (!isLoadSucceed())
    {
      notifyRuntimeEvent(21, new Object[0]);
      return;
    }
    super.onMiniResume();
  }
  
  public void onMiniStart()
  {
    if (!isLoadSucceed()) {
      return;
    }
    super.onMiniStart();
  }
  
  public void onMiniStop()
  {
    if (!isLoadSucceed()) {
      return;
    }
    super.onMiniStop();
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng]");
    localStringBuilder.append(paramBaseTask);
    localStringBuilder.append(" done! succ:");
    localStringBuilder.append(paramBaseTask.isSucceed());
    QMLog.i("GameRuntimeLoader", localStringBuilder.toString());
    if ((paramBaseTask instanceof GpkgLoadAsyncTask)) {
      onGpkgLoadAsyncTaskDone((GpkgLoadAsyncTask)paramBaseTask);
    } else if ((paramBaseTask instanceof TritonEngineInitTask)) {
      onTritonEngineInitTask((TritonEngineInitTask)paramBaseTask);
    } else if ((paramBaseTask instanceof MiniAppInfoLoadTask)) {
      onMiniAppInfoLoadTaskDone((MiniAppInfoLoadTask)paramBaseTask);
    } else if ((paramBaseTask instanceof InitGameRuntimeTask)) {
      onInitGameRuntimeTaskDone((InitGameRuntimeTask)paramBaseTask);
    }
    if (!paramBaseTask.isSucceed())
    {
      markHasTaskFailed(true);
      notifyRuntimeEvent(12, new Object[0]);
      onRuntimeLoadResult(paramBaseTask.retCode, paramBaseTask.msg);
      return;
    }
    if (paramBaseTask.isDone()) {
      updateFlow(paramBaseTask);
    }
  }
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    paramMiniAppInfo.apkgInfo = new ApkgInfo(ApkgManager.getApkgFolderPath(paramMiniAppInfo), paramMiniAppInfo);
    this.mMiniAppInfoLoadTask.setMiniAppInfo(paramMiniAppInfo);
    this.mTritonEngineInitTask.setMiniAppInfo(paramMiniAppInfo);
    super.setMiniAppInfo(paramMiniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */