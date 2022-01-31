package com.tencent.mobileqq.minigame.manager;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.TaskFlowEngine;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.task.GameEngineLoadTask;
import com.tencent.mobileqq.minigame.task.GameJsPluginEngineTask;
import com.tencent.mobileqq.minigame.task.GpkgLoadAsyncTask;
import com.tencent.mobileqq.minigame.task.InitGameRuntimeTask;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qphone.base.util.QLog;

public class GameLoadManager
  extends TaskFlowEngine
{
  public static final String LOG_TAG = "GameLoadManager";
  private static volatile boolean hasConfigTask;
  private static volatile GameLoadManager sInstance;
  private boolean baseEngineLoaded;
  private GameEngineLoadTask mGameEngineLoadTask;
  private GameLoadManager.GameLoadListener mGameLoadListener;
  private GpkgLoadAsyncTask mGpkgLoadTask;
  private InitGameRuntimeTask mInitGameRuntimeTask;
  private GameJsPluginEngineTask mJsPluginEngineTask;
  private MiniGamePkg miniGamePkg;
  
  private GameLoadManager()
  {
    createTask();
  }
  
  private void configTask()
  {
    hasConfigTask = true;
    if (this.mInitGameRuntimeTask.isDone())
    {
      this.mInitGameRuntimeTask = new InitGameRuntimeTask(BaseApplicationImpl.getApplication());
      this.mGameEngineLoadTask.reset();
      this.mJsPluginEngineTask.reset();
      this.mGpkgLoadTask.reset();
      this.mInitGameRuntimeTask.addDependTask(this.mGameEngineLoadTask);
      this.mInitGameRuntimeTask.addDependTask(this.mJsPluginEngineTask);
      this.mInitGameRuntimeTask.addDependTask(this.mGpkgLoadTask);
    }
    for (;;)
    {
      initTasks(new BaseTask[] { this.mInitGameRuntimeTask });
      return;
      if (!this.mGameEngineLoadTask.isDone()) {
        this.mInitGameRuntimeTask.addDependTask(this.mGameEngineLoadTask);
      }
      if (!this.mJsPluginEngineTask.isDone()) {
        this.mInitGameRuntimeTask.addDependTask(this.mJsPluginEngineTask);
      }
      this.mInitGameRuntimeTask.addDependTask(this.mGpkgLoadTask);
    }
  }
  
  private void createTask()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    this.mGameEngineLoadTask = GameEngineLoadTask.g(localBaseApplicationImpl);
    this.mGpkgLoadTask = new GpkgLoadAsyncTask(localBaseApplicationImpl);
    this.mJsPluginEngineTask = GameJsPluginEngineTask.g(localBaseApplicationImpl);
    this.mInitGameRuntimeTask = new InitGameRuntimeTask(localBaseApplicationImpl);
  }
  
  public static GameLoadManager g()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new GameLoadManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  private boolean isGamePkgReady(MiniAppConfig paramMiniAppConfig)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMiniAppConfig != null)
    {
      bool1 = bool2;
      if (this.miniGamePkg != null)
      {
        bool1 = bool2;
        if (this.miniGamePkg.appConfig != null)
        {
          bool1 = bool2;
          if (this.miniGamePkg.appConfig.config != null)
          {
            bool1 = bool2;
            if (paramMiniAppConfig.config != null)
            {
              bool1 = bool2;
              if (TextUtils.equals(this.miniGamePkg.appConfig.config.appId, paramMiniAppConfig.config.appId)) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void attachListener(GameLoadManager.GameLoadListener paramGameLoadListener)
  {
    QLog.i("GameLoadManager", 1, "[MiniEng]attachListener " + paramGameLoadListener);
    this.mGameLoadListener = paramGameLoadListener;
    this.mGameEngineLoadTask.setGameLoadListener(paramGameLoadListener);
    this.mGpkgLoadTask.setGameLoadListener(paramGameLoadListener);
    if (this.mGameEngineLoadTask.isDone())
    {
      QLog.i("GameLoadManager", 1, "[MiniEng]attachListener after mGameEngineLoadTask isDone, retCode: " + this.mGameEngineLoadTask.isSucceed());
      if (paramGameLoadListener != null) {
        paramGameLoadListener.onEngineLoad(this.mGameEngineLoadTask.isSucceed(), this.mGameEngineLoadTask.msg, this.mGameEngineLoadTask.retCode);
      }
    }
    boolean bool;
    if ((this.mGpkgLoadTask.isDone()) && (paramGameLoadListener != null))
    {
      QLog.i("GameLoadManager", 1, "[MiniEng]attachListener after GpkgLoadTask isDone");
      bool = this.mGpkgLoadTask.isSucceed();
      if (this.mGpkgLoadTask.msg == null)
      {
        str = "";
        paramGameLoadListener.onGpkgLoad(bool, str);
      }
    }
    else if ((this.mJsPluginEngineTask.isDone()) && (paramGameLoadListener != null))
    {
      QLog.i("GameLoadManager", 1, "[MiniEng]attachListener after GameJsPluginEngineTask isDone, retCode: " + this.mJsPluginEngineTask.isSucceed());
      bool = this.mJsPluginEngineTask.isSucceed();
      if (this.mJsPluginEngineTask.msg != null) {
        break label303;
      }
    }
    label303:
    for (String str = "";; str = this.mJsPluginEngineTask.msg)
    {
      paramGameLoadListener.onJsPluginEngineLoad(bool, str);
      if ((this.mGameEngineLoadTask.isDone()) && (this.mGpkgLoadTask.isDone()) && (this.mJsPluginEngineTask.isDone()) && (paramGameLoadListener != null))
      {
        QLog.i("GameLoadManager", 1, "[MiniEng]attachListener after ALl Task isDone");
        paramGameLoadListener.onInitRuntimeDone();
      }
      return;
      str = this.mGpkgLoadTask.msg;
      break;
    }
  }
  
  public void detachListener(GameLoadManager.GameLoadListener paramGameLoadListener)
  {
    QLog.i("GameLoadManager", 1, "[MiniEng]detachListener in:" + paramGameLoadListener + ",current:" + this.mGameLoadListener);
    if ((paramGameLoadListener != null) && (paramGameLoadListener.equals(this.mGameLoadListener)))
    {
      this.mGameLoadListener = null;
      this.mGameEngineLoadTask.setGameLoadListener(null);
      return;
    }
    QLog.w("GameLoadManager", 1, "[MiniEng]detachListener failed");
  }
  
  public String getBaseEnginePath()
  {
    return this.mGameEngineLoadTask.getBaseEnginePath();
  }
  
  public InstalledEngine getEngine()
  {
    InstalledEngine localInstalledEngine = this.mGameEngineLoadTask.getEngine();
    if ((localInstalledEngine != null) && (localInstalledEngine.isVerify)) {
      return localInstalledEngine;
    }
    return null;
  }
  
  public ITTEngine getGameEngine()
  {
    return this.mGameEngineLoadTask.getGameEngine();
  }
  
  public MiniGamePkg getMiniGamePkg()
  {
    return this.miniGamePkg;
  }
  
  public boolean hasConfigTask()
  {
    return hasConfigTask;
  }
  
  public boolean isGameReadyStart(MiniAppConfig paramMiniAppConfig)
  {
    boolean bool = isGamePkgReady(paramMiniAppConfig);
    QLog.i("GameLoadManager", 1, "[MiniEng]isGameReadyStart:" + bool + ",baseEngineLoaded:" + this.baseEngineLoaded);
    return (this.baseEngineLoaded) && (bool);
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {}
    label416:
    for (;;)
    {
      return;
      QLog.i("GameLoadManager", 1, "[MiniEng]" + paramBaseTask + " done! succ:" + paramBaseTask.isSucceed() + ", listener=" + this.mGameLoadListener);
      if ((paramBaseTask instanceof GpkgLoadAsyncTask)) {
        if (paramBaseTask.isSucceed())
        {
          this.miniGamePkg = ((GpkgLoadAsyncTask)paramBaseTask).getGpkgInfo();
          GameInfoManager.g().setMiniGamePkg(this.miniGamePkg);
          if (this.mGameLoadListener != null)
          {
            this.mGameLoadListener.onTaskProgress(paramBaseTask, 1.0F, "");
            this.mGameLoadListener.onGpkgLoad(true, "");
          }
          this.mGameEngineLoadTask.allowPostProgress = true;
        }
      }
      for (;;)
      {
        if (!paramBaseTask.isDone()) {
          break label416;
        }
        updateFlow(paramBaseTask);
        return;
        if (this.mGameLoadListener != null) {
          this.mGameLoadListener.onGpkgLoad(false, ((GpkgLoadAsyncTask)paramBaseTask).msg);
        }
        this.miniGamePkg = null;
        Object localObject = ((GpkgLoadAsyncTask)paramBaseTask).getAppConfig();
        if (localObject == null) {
          break;
        }
        MiniProgramLpReportDC04239.reportPageView((MiniAppConfig)localObject, "1", null, "load_fail", "pkg_task_fail");
        MiniAppReportManager2.reportPageView("2launch_fail", "pkg_task_fail", null, (MiniAppConfig)localObject);
        if (((MiniAppConfig)localObject).config == null) {
          break;
        }
        localObject = ((MiniAppConfig)localObject).config.appId;
        break;
        if ((paramBaseTask instanceof GameEngineLoadTask))
        {
          if (!paramBaseTask.isSucceed())
          {
            if (this.mGameLoadListener != null) {
              this.mGameLoadListener.onEngineLoad(false, paramBaseTask.msg, paramBaseTask.retCode);
            }
            this.baseEngineLoaded = false;
            localObject = ((GameEngineLoadTask)paramBaseTask).getAppConfig();
            if (localObject != null)
            {
              MiniProgramLpReportDC04239.reportPageView((MiniAppConfig)localObject, "1", null, "load_fail", "baselib_task_fail");
              MiniAppReportManager2.reportPageView("2launch_fail", "baselib_task_fail", null, (MiniAppConfig)localObject);
              if (((MiniAppConfig)localObject).config != null) {
                localObject = ((MiniAppConfig)localObject).config.appId;
              }
            }
          }
          else
          {
            this.baseEngineLoaded = true;
            if (this.mGameLoadListener != null) {
              this.mGameLoadListener.onEngineLoad(true, paramBaseTask.msg, paramBaseTask.retCode);
            }
          }
        }
        else if ((paramBaseTask instanceof GameJsPluginEngineTask))
        {
          if (this.mGameLoadListener != null) {
            this.mGameLoadListener.onJsPluginEngineLoad(paramBaseTask.isSucceed(), paramBaseTask.msg);
          }
        }
        else if (((paramBaseTask instanceof InitGameRuntimeTask)) && (this.mGameLoadListener != null)) {
          this.mGameLoadListener.onInitRuntimeDone();
        }
      }
    }
  }
  
  public void setEngineChannel(EngineChannel paramEngineChannel)
  {
    this.mGameEngineLoadTask.setEngineChannel(paramEngineChannel);
    QLog.i("GameLoadManager", 1, "[MiniEng]setEngineChannel " + paramEngineChannel + ", " + AppUtil.getProcessName());
  }
  
  @Deprecated
  public void start()
  {
    QLog.w("GameLoadManager", 1, "[MiniEng]start does nothing, use start(MiniAppConfig) instead");
  }
  
  public void start(MiniAppConfig paramMiniAppConfig, GameLoadManager.GameLoadListener paramGameLoadListener)
  {
    start(paramMiniAppConfig, paramGameLoadListener, null);
  }
  
  public void start(MiniAppConfig paramMiniAppConfig, GameLoadManager.GameLoadListener paramGameLoadListener, GameJsPluginEngine paramGameJsPluginEngine)
  {
    configTask();
    this.miniGamePkg = null;
    this.baseEngineLoaded = this.mGameEngineLoadTask.isSucceed();
    AppBrandProxy.g().setPreloadType("preload_game");
    AppBrandProxy.g().setMiniAppConfig(paramMiniAppConfig);
    resetTaskAndDepends(this.mInitGameRuntimeTask);
    if (this.mGpkgLoadTask.getGpkgInfo() != null) {
      resetTaskAndDepends(this.mGpkgLoadTask);
    }
    attachListener(paramGameLoadListener);
    this.mGameEngineLoadTask.setAppConfig(paramMiniAppConfig);
    this.mGpkgLoadTask.setMiniAppConfig(paramMiniAppConfig);
    this.mJsPluginEngineTask.setJsPluginEngine(paramGameJsPluginEngine);
    super.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameLoadManager
 * JD-Core Version:    0.7.0.1
 */