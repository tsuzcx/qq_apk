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
import com.tencent.qqmini.minigame.task.GameRuntimeCreateTask;
import com.tencent.qqmini.minigame.task.GpkgLoadAsyncTask;
import com.tencent.qqmini.minigame.task.InitGameRuntimeTask;
import com.tencent.qqmini.minigame.task.TritonEngineInitTask;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
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
  private GameInfoManager mGameInfoManager = new GameInfoManager(this);
  private GameRuntimeCreateTask mGameRuntimeCreateTask;
  private GpkgLoadAsyncTask mGpkgLoadTask;
  private InitGameRuntimeTask mInitGameRuntimeTask;
  private MiniAppInfoLoadTask mMiniAppInfoLoadTask;
  private GameReportManager mReportManager = new GameReportManager(this);
  private TritonEngineInitTask mTritonEngineInitTask;
  private MiniGamePkg miniGamePkg;
  
  private GameRuntimeLoader(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean isGameEngineReady()
  {
    return (this.mTritonEngineInitTask.isDone()) && (this.mTritonEngineInitTask.isSucceed());
  }
  
  private boolean isGamePkgReady(MiniAppInfo paramMiniAppInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMiniAppInfo != null)
    {
      bool1 = bool2;
      if (this.miniGamePkg != null)
      {
        bool1 = bool2;
        if (TextUtils.equals(this.miniGamePkg.appId, paramMiniAppInfo.appId)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void onGameRuntimeCreateTask(GameRuntimeCreateTask paramGameRuntimeCreateTask)
  {
    if (paramGameRuntimeCreateTask.isSucceed())
    {
      paramGameRuntimeCreateTask = paramGameRuntimeCreateTask.getGameRuntime();
      paramGameRuntimeCreateTask.setGameInfoManager(this.mGameInfoManager);
      paramGameRuntimeCreateTask.setGameReportManager(this.mReportManager);
      this.mRuntime = paramGameRuntimeCreateTask;
    }
  }
  
  private void onGpkgLoadAsyncTaskDone(GpkgLoadAsyncTask paramGpkgLoadAsyncTask)
  {
    if (paramGpkgLoadAsyncTask.isSucceed())
    {
      this.miniGamePkg = paramGpkgLoadAsyncTask.getGpkgInfo();
      if (this.mMiniAppInfo != null)
      {
        this.mMiniAppInfo.apkgInfo = new ApkgInfo(ApkgManager.getApkgFolderPath(this.mMiniAppInfo), this.mMiniAppInfo);
        updateMiniGameInfo(this.mMiniAppInfo);
      }
      this.mGameInfoManager.setLaunchOptions();
      if (!paramGpkgLoadAsyncTask.isSucceed()) {
        break label140;
      }
    }
    label140:
    for (int i = 2002;; i = 2003)
    {
      notifyRuntimeEvent(i, new Object[] { paramGpkgLoadAsyncTask.msg });
      return;
      this.miniGamePkg = null;
      Object localObject = paramGpkgLoadAsyncTask.getMiniAppInfo();
      if (localObject == null) {
        break;
      }
      SDKMiniProgramLpReportDC04239.reportForSDK((MiniAppInfo)localObject, "1", null, "page_view", "load_fail", "pkg_task_fail", "");
      MiniAppReportManager2.reportPageView("2launch_fail", "pkg_task_fail", null, (MiniAppInfo)localObject);
      if (localObject == null) {
        break;
      }
      localObject = ((MiniAppInfo)localObject).appId;
      break;
    }
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
      Object localObject = paramTritonEngineInitTask.getMiniAppInfo();
      if (localObject != null)
      {
        SDKMiniProgramLpReportDC04239.reportForSDK((MiniAppInfo)localObject, "1", null, "page_view", "load_fail", "baselib_task_fail", "");
        MiniAppReportManager2.reportPageView("2launch_fail", "baselib_task_fail", null, (MiniAppInfo)localObject);
        if (localObject != null) {
          localObject = ((MiniAppInfo)localObject).appId;
        }
      }
      localObject = paramTritonEngineInitTask.getEnginePackage();
      ((GameRuntime)getRuntime()).setEnginePackage((MiniEnginePackage)localObject);
      QMLog.i("BaseRuntimeLoader", "TritonEngine 初始化配置:" + localObject);
      if (!paramTritonEngineInitTask.isSucceed()) {
        break label137;
      }
    }
    label137:
    for (int i = 2012;; i = 2013)
    {
      notifyRuntimeEvent(i, new Object[] { Integer.valueOf(paramTritonEngineInitTask.retCode) });
      return;
      if (!getAppStateManager().isFromPreload) {
        break;
      }
      sendPreloadBaseLibVersion();
      break;
    }
  }
  
  private void sendPreloadBaseLibVersion()
  {
    String str = this.mTritonEngineInitTask.getEnginePackage().getVersion().getVersion();
    Bundle localBundle = new Bundle();
    localBundle.putString("bundle_key_process_name", AppLoaderFactory.g().getProcessName());
    localBundle.putString("bundle_key_preload_game_baselib_version", str);
    AppBrandCmdProxy.g().sendCmd("cmd_on_preload_game_baselib", localBundle, null);
    if (QMLog.isColorLevel()) {
      QMLog.i("BaseRuntimeLoader", "[MiniEng]preload jsLib version:" + str);
    }
  }
  
  public BaseRuntime createRuntime(Context paramContext)
  {
    paramContext = new GameRuntime(paramContext);
    paramContext.setRuntimeMsgObserver(this);
    return paramContext;
  }
  
  public BaseTask[] createTasks()
  {
    this.mGameRuntimeCreateTask = new GameRuntimeCreateTask(this.mContext, this);
    this.mMiniAppInfoLoadTask = new MiniAppInfoLoadTask(this.mContext, this);
    this.mTritonEngineInitTask = new TritonEngineInitTask(this.mContext, this);
    this.mGpkgLoadTask = new GpkgLoadAsyncTask(this.mContext, this);
    this.mInitGameRuntimeTask = new InitGameRuntimeTask(this.mContext, this);
    this.mInitGameRuntimeTask.addDependTask(this.mTritonEngineInitTask.addDependTask(this.mGameRuntimeCreateTask)).addDependTask(this.mGpkgLoadTask.addDependTask(this.mMiniAppInfoLoadTask));
    return new BaseTask[] { this.mInitGameRuntimeTask };
  }
  
  public boolean dismissLoadingAfterLoaded()
  {
    return false;
  }
  
  public GameInfoManager getGameInfoManager()
  {
    return this.mGameInfoManager;
  }
  
  public MiniGamePkg getMiniGamePkg()
  {
    return this.miniGamePkg;
  }
  
  public GameReportManager getReportManager()
  {
    return this.mReportManager;
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
    if (paramBaseTask == null) {}
    do
    {
      return;
      QMLog.i("GameRuntimeLoader", "[MiniEng]" + paramBaseTask + " done! succ:" + paramBaseTask.isSucceed());
      if ((paramBaseTask instanceof GameRuntimeCreateTask)) {
        onGameRuntimeCreateTask((GameRuntimeCreateTask)paramBaseTask);
      }
      while (!paramBaseTask.isSucceed())
      {
        markHasTaskFailed(true);
        notifyRuntimeEvent(12, new Object[0]);
        onRuntimeLoadResult(paramBaseTask.retCode, paramBaseTask.msg);
        return;
        if ((paramBaseTask instanceof GpkgLoadAsyncTask)) {
          onGpkgLoadAsyncTaskDone((GpkgLoadAsyncTask)paramBaseTask);
        } else if ((paramBaseTask instanceof TritonEngineInitTask)) {
          onTritonEngineInitTask((TritonEngineInitTask)paramBaseTask);
        } else if ((paramBaseTask instanceof MiniAppInfoLoadTask)) {
          onMiniAppInfoLoadTaskDone((MiniAppInfoLoadTask)paramBaseTask);
        } else if ((paramBaseTask instanceof InitGameRuntimeTask)) {
          onInitGameRuntimeTaskDone((InitGameRuntimeTask)paramBaseTask);
        }
      }
    } while (!paramBaseTask.isDone());
    updateFlow(paramBaseTask);
  }
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    paramMiniAppInfo.apkgInfo = new ApkgInfo(ApkgManager.getApkgFolderPath(paramMiniAppInfo), paramMiniAppInfo);
    this.mMiniAppInfoLoadTask.setMiniAppInfo(paramMiniAppInfo);
    this.mTritonEngineInitTask.setMiniAppInfo(paramMiniAppInfo);
    super.setMiniAppInfo(paramMiniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */