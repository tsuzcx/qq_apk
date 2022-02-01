package com.tencent.mobileqq.minigame.manager;

import android.content.Context;
import android.text.TextUtils;
import bhlo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.TaskFlowEngine;
import com.tencent.mobileqq.minigame.api.QQMiniEnginePackage;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.task.GameJsPluginEngineTask;
import com.tencent.mobileqq.minigame.task.GpkgLoadAsyncTask;
import com.tencent.mobileqq.minigame.task.InitGameRuntimeTask;
import com.tencent.mobileqq.minigame.task.TritonEngineInitTask;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.mobileqq.triton.model.Version;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameRuntimeLoader
  extends TaskFlowEngine
{
  private final String TAG = "[MiniEng]" + toString();
  private Context mContext;
  private MiniAppConfig mGameConfig;
  private TritonEngine mGameEngine;
  private GameInfoManager mGameInfoManager;
  private MiniGamePkg mGamePkg;
  private GpkgLoadAsyncTask mGpkgLoadTask;
  private GameRuntimeLoader.GameRuntimeProgressListener mGpkgLoadTaskListener;
  private InitGameRuntimeTask mInitGameRuntimeTask;
  private GameJsPluginEngine mJsPluginEngine;
  private GameJsPluginEngineTask mJsPluginEngineTask;
  private GameReportManager mReportManager;
  private ArrayList<GameRuntimeLoader.GameRuntimeListener> mRuntimeListeners;
  private TritonEngineInitTask mTritonEngineInitTask;
  
  public GameRuntimeLoader(Context paramContext, GameRuntimeLoaderManager.PREPARE_FROM paramPREPARE_FROM)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("can't create GameRuntimeLoader with null context");
    }
    this.mContext = paramContext;
    this.mJsPluginEngine = new GameJsPluginEngine();
    this.mGameInfoManager = new GameInfoManager();
    this.mReportManager = new GameReportManager();
    this.mRuntimeListeners = new ArrayList();
    this.mGpkgLoadTaskListener = new GameRuntimeLoader.1(this);
    initBaseTasks(paramPREPARE_FROM);
  }
  
  private void dumpTask(BaseTask paramBaseTask)
  {
    Object localObject = paramBaseTask.getDependTasks();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        dumpTask((BaseTask)((Iterator)localObject).next());
      }
    }
    GameLog.getInstance().i(this.TAG, paramBaseTask.toString() + " current state:" + paramBaseTask.getStatus() + ", retCode:" + paramBaseTask.retCode + ", msg:" + paramBaseTask.msg);
  }
  
  private void initBaseTasks(GameRuntimeLoaderManager.PREPARE_FROM paramPREPARE_FROM)
  {
    this.mTritonEngineInitTask = new TritonEngineInitTask(this.mContext, paramPREPARE_FROM);
    this.mJsPluginEngineTask = new GameJsPluginEngineTask(this.mContext, this.mJsPluginEngine);
    initTasks(new BaseTask[] { this.mTritonEngineInitTask, this.mJsPluginEngineTask });
  }
  
  private void initExternalTasks()
  {
    this.mGpkgLoadTask = new GpkgLoadAsyncTask(this.mContext);
    this.mGpkgLoadTask.setMiniAppConfig(this.mGameConfig);
    this.mGpkgLoadTask.setProgressListener(this.mGpkgLoadTaskListener);
    this.mInitGameRuntimeTask = new InitGameRuntimeTask(this.mContext);
    this.mInitGameRuntimeTask.addDependTask(this.mTritonEngineInitTask).addDependTask(this.mJsPluginEngineTask).addDependTask(this.mGpkgLoadTask);
    initTasks(new BaseTask[] { this.mInitGameRuntimeTask });
  }
  
  private boolean isGameEngineReady()
  {
    return (this.mTritonEngineInitTask.isDone()) && (this.mTritonEngineInitTask.isSucceed());
  }
  
  private boolean isGamePkgReady()
  {
    return (this.mGameConfig != null) && (this.mGameConfig.config != null) && (this.mGamePkg != null) && (this.mGamePkg.appConfig != null) && (this.mGamePkg.appConfig.config != null) && (TextUtils.equals(this.mGamePkg.appConfig.config.appId, this.mGameConfig.config.appId));
  }
  
  private void onGameJsPluginEngineTaskDone(BaseTask paramBaseTask)
  {
    Iterator localIterator = new ArrayList(this.mRuntimeListeners).iterator();
    while (localIterator.hasNext()) {
      ((GameRuntimeLoader.GameRuntimeListener)localIterator.next()).onJsPluginEngineLoad(paramBaseTask.isSucceed(), paramBaseTask.msg);
    }
  }
  
  private void onGpkgLoadAsyncTaskDone(GpkgLoadAsyncTask paramGpkgLoadAsyncTask)
  {
    if (paramGpkgLoadAsyncTask.isSucceed())
    {
      this.mGamePkg = paramGpkgLoadAsyncTask.getGpkgInfo();
      this.mGameInfoManager.setMiniGamePkg(this.mGamePkg);
    }
    for (;;)
    {
      Object localObject = new ArrayList(this.mRuntimeListeners).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GameRuntimeLoader.GameRuntimeListener localGameRuntimeListener = (GameRuntimeLoader.GameRuntimeListener)((Iterator)localObject).next();
        if (paramGpkgLoadAsyncTask.isSucceed()) {
          localGameRuntimeListener.onTaskProgress(paramGpkgLoadAsyncTask, 1.0F, paramGpkgLoadAsyncTask.msg);
        }
        localGameRuntimeListener.onGpkgLoad(paramGpkgLoadAsyncTask.isSucceed(), paramGpkgLoadAsyncTask.msg);
      }
      localObject = paramGpkgLoadAsyncTask.getAppConfig();
      if (localObject != null)
      {
        MiniProgramLpReportDC04239.reportPageView((MiniAppConfig)localObject, "1", null, "load_fail", "pkg_task_fail");
        MiniAppReportManager2.reportPageView("2launch_fail", "pkg_task_fail", null, (MiniAppConfig)localObject);
        if (((MiniAppConfig)localObject).config != null) {
          localObject = ((MiniAppConfig)localObject).config.appId;
        }
      }
    }
  }
  
  private void onInitGameRuntimeTaskDone(BaseTask paramBaseTask)
  {
    paramBaseTask = new ArrayList(this.mRuntimeListeners).iterator();
    while (paramBaseTask.hasNext()) {
      ((GameRuntimeLoader.GameRuntimeListener)paramBaseTask.next()).onInitRuntimeDone();
    }
  }
  
  private void onTritonEngineInitTaskDone(TritonEngineInitTask paramTritonEngineInitTask)
  {
    if (!paramTritonEngineInitTask.isSucceed())
    {
      localObject = paramTritonEngineInitTask.getAppConfig();
      if (localObject != null)
      {
        MiniProgramLpReportDC04239.reportPageView((MiniAppConfig)localObject, "1", null, "load_fail", "baselib_task_fail");
        MiniAppReportManager2.reportPageView("2launch_fail", "baselib_task_fail", null, (MiniAppConfig)localObject);
        if (((MiniAppConfig)localObject).config != null) {
          localObject = ((MiniAppConfig)localObject).config.appId;
        }
      }
    }
    GameLog.getInstance().i(this.TAG, "TritonEngine 初始化配置:" + paramTritonEngineInitTask.getEnginePackage() + ", 机器性能:" + bhlo.f());
    Object localObject = new ArrayList(this.mRuntimeListeners).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((GameRuntimeLoader.GameRuntimeListener)((Iterator)localObject).next()).onEngineLoad(paramTritonEngineInitTask.isSucceed(), paramTritonEngineInitTask.msg, paramTritonEngineInitTask.retCode);
    }
  }
  
  public void dump()
  {
    BaseTask[] arrayOfBaseTask = getTasks();
    if ((arrayOfBaseTask != null) && (arrayOfBaseTask.length > 0))
    {
      int j = arrayOfBaseTask.length;
      int i = 0;
      while (i < j)
      {
        dumpTask(arrayOfBaseTask[i]);
        i += 1;
      }
    }
  }
  
  public TritonEngine getGameEngine()
  {
    return this.mGameEngine;
  }
  
  public GameInfoManager getGameInfoManager()
  {
    return this.mGameInfoManager;
  }
  
  public TritonPlatform getGamePlatform()
  {
    return this.mTritonEngineInitTask.getTritonPlatform();
  }
  
  public GameJsPluginEngine getJsPluginEngine()
  {
    return this.mJsPluginEngine;
  }
  
  public String getJsVersion()
  {
    QQMiniEnginePackage localQQMiniEnginePackage = getTritonEnginePackage();
    if ((localQQMiniEnginePackage != null) && (localQQMiniEnginePackage.getJsVersion() != null)) {
      return localQQMiniEnginePackage.getJsVersion().getVersion();
    }
    return "";
  }
  
  public MiniGamePkg getMiniGamePkg()
  {
    return this.mGamePkg;
  }
  
  public GameReportManager getReportManager()
  {
    return this.mReportManager;
  }
  
  public QQMiniEnginePackage getTritonEnginePackage()
  {
    return this.mTritonEngineInitTask.getEnginePackage();
  }
  
  public String getTritonVersion()
  {
    QQMiniEnginePackage localQQMiniEnginePackage = getTritonEnginePackage();
    if ((localQQMiniEnginePackage != null) && (localQQMiniEnginePackage.getVersion() != null)) {
      return localQQMiniEnginePackage.getVersion().getVersion();
    }
    return "";
  }
  
  public boolean isGameReadyStart()
  {
    return (isGameEngineReady()) && (isGamePkgReady());
  }
  
  public void onTaskBegin(BaseTask paramBaseTask)
  {
    GameLog.getInstance().i(this.TAG, "onTaskBegin:" + paramBaseTask);
    super.onTaskBegin(paramBaseTask);
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    GameLog.getInstance().i(this.TAG, "onTaskDone:" + paramBaseTask + ", success:" + paramBaseTask.isSucceed());
    if ((paramBaseTask instanceof GpkgLoadAsyncTask)) {
      onGpkgLoadAsyncTaskDone((GpkgLoadAsyncTask)paramBaseTask);
    }
    for (;;)
    {
      if (paramBaseTask.isDone()) {
        updateFlow(paramBaseTask);
      }
      return;
      if ((paramBaseTask instanceof TritonEngineInitTask)) {
        onTritonEngineInitTaskDone((TritonEngineInitTask)paramBaseTask);
      } else if ((paramBaseTask instanceof GameJsPluginEngineTask)) {
        onGameJsPluginEngineTaskDone(paramBaseTask);
      } else if ((paramBaseTask instanceof InitGameRuntimeTask)) {
        onInitGameRuntimeTaskDone(paramBaseTask);
      }
    }
  }
  
  public GameRuntimeLoader prepare()
  {
    GameLog.getInstance().i(this.TAG, "prepare start");
    super.start();
    return this;
  }
  
  public GameRuntimeLoader prepareGameRuntime(MiniAppConfig paramMiniAppConfig)
  {
    if (!MiniAppConfig.isValid(paramMiniAppConfig)) {
      throw new IllegalArgumentException("launchGame on invalid MiniAppConfig:" + paramMiniAppConfig);
    }
    GameLog.getInstance().i(this.TAG, "launchGame start, " + paramMiniAppConfig.config.simpleInfo());
    this.mGameConfig = paramMiniAppConfig;
    initExternalTasks();
    AppBrandProxy.g().setPreloadType("preload_game");
    AppBrandProxy.g().setMiniAppConfig(paramMiniAppConfig);
    dump();
    super.start();
    return this;
  }
  
  public GameRuntimeLoader registerListener(GameRuntimeLoader.GameRuntimeListener paramGameRuntimeListener)
  {
    if ((paramGameRuntimeListener != null) && (!this.mRuntimeListeners.contains(paramGameRuntimeListener))) {
      this.mRuntimeListeners.add(paramGameRuntimeListener);
    }
    return this;
  }
  
  public void setGameEngine(TritonEngine paramTritonEngine)
  {
    this.mGameEngine = paramTritonEngine;
  }
  
  public GameRuntimeLoader unRegisterListener(GameRuntimeLoader.GameRuntimeListener paramGameRuntimeListener)
  {
    this.mRuntimeListeners.remove(paramGameRuntimeListener);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */