package com.tencent.mobileqq.minigame.manager;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.TaskFlowEngine;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.task.GameEngineLoadTask;
import com.tencent.mobileqq.minigame.task.GameJsPluginEngineTask;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.qphone.base.util.QLog;

public class GamePreloadManager
  extends TaskFlowEngine
{
  public static final String TAG = "GamePreloadManager";
  private static volatile GamePreloadManager sInstance;
  private GameEngineLoadTask mGameEngineLoadTask;
  private GameJsPluginEngineTask mJsPluginEngineTask;
  
  private GamePreloadManager()
  {
    if (GameLoadManager.g().hasConfigTask())
    {
      QLog.e("GamePreloadManager", 1, "[MiniEng] GameLoadManager.hasConfigTask, no need preload again!");
      return;
    }
    createTask();
  }
  
  private void createTask()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    this.mGameEngineLoadTask = GameEngineLoadTask.g(localBaseApplicationImpl);
    this.mJsPluginEngineTask = GameJsPluginEngineTask.g(localBaseApplicationImpl);
    this.mJsPluginEngineTask.setJsPluginEngine(new GameJsPluginEngine());
    initTasks(new BaseTask[] { this.mGameEngineLoadTask, this.mJsPluginEngineTask });
  }
  
  public static GamePreloadManager g()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new GamePreloadManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  private void sendBaseLibVersion()
  {
    InstalledEngine localInstalledEngine = this.mGameEngineLoadTask.getEngine();
    if ((localInstalledEngine != null) && (localInstalledEngine.loadStatus == 3) && (localInstalledEngine.engineVersion != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("bundle_key_process_name", AppUtil.getProcessName());
      localBundle.putString("bundle_key_preload_game_baselib_version", localInstalledEngine.engineVersion.mMinor);
      AppBrandProxy.g().sendCmd("cmd_on_preload_game_baselib", localBundle, null);
    }
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    super.onTaskDone(paramBaseTask);
    if (((paramBaseTask instanceof GameEngineLoadTask)) && (paramBaseTask.isSucceed())) {
      sendBaseLibVersion();
    }
    if (paramBaseTask != null) {
      QLog.i("GamePreloadManager", 1, "[MiniEng]" + paramBaseTask + " onTaskDone! isSucceed: " + paramBaseTask.isSucceed());
    }
  }
  
  public void setEngineChannel(EngineChannel paramEngineChannel)
  {
    this.mGameEngineLoadTask.setEngineChannel(paramEngineChannel);
    QLog.i("GamePreloadManager", 1, "[MiniEng]setEngineChannel " + paramEngineChannel + ", " + AppUtil.getProcessName());
  }
  
  public void start()
  {
    super.start();
    QLog.i("GamePreloadManager", 1, "[MiniEng] [start]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GamePreloadManager
 * JD-Core Version:    0.7.0.1
 */