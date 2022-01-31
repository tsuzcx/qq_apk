package com.tencent.mobileqq.minigame.manager;

import android.content.Context;
import android.text.TextUtils;
import bdgk;
import bgzf;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.TaskFlowEngine;
import com.tencent.mobileqq.minigame.api.APIProxyImpl;
import com.tencent.mobileqq.minigame.api.QQEnvImp;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.task.GameJsPluginEngineTask;
import com.tencent.mobileqq.minigame.task.GpkgLoadAsyncTask;
import com.tencent.mobileqq.minigame.task.InitGameRuntimeTask;
import com.tencent.mobileqq.minigame.task.InstalledEngineLoadTask;
import com.tencent.mobileqq.minigame.task.TritonEngineInitTask;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameRuntimeLoader
  extends TaskFlowEngine
{
  private final String TAG = "[MiniEng]" + toString();
  private Context mContext;
  private MiniAppConfig mGameConfig;
  private GameInfoManager mGameInfoManager;
  private MiniGamePkg mGamePkg;
  private GpkgLoadAsyncTask mGpkgLoadTask;
  private GameRuntimeLoader.GameRuntimeProgressListener mGpkgLoadTaskListener;
  private InitGameRuntimeTask mInitGameRuntimeTask;
  private bgzf mInspectorAgentWrapper;
  private InstalledEngineLoadTask mInstalledEngineLoadTask;
  private GameRuntimeLoader.GameRuntimeProgressListener mInstalledEngineLoadTaskListener;
  private GameJsPluginEngine mJsPluginEngine;
  private GameJsPluginEngineTask mJsPluginEngineTask;
  private GameLibVersionManager mLibVersionManager;
  private GameReportManager mReportManager;
  private ArrayList<GameRuntimeLoader.GameRuntimeListener> mRuntimeListeners;
  private TritonEngineInitTask mTritonEngineInitTask;
  
  public GameRuntimeLoader(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("can't create GameRuntimeLoader with null context");
    }
    GameLog.getInstance().i(this.TAG, "run on device pref level:" + bdgk.f());
    this.mContext = paramContext;
    this.mJsPluginEngine = new GameJsPluginEngine();
    this.mLibVersionManager = new GameLibVersionManager();
    this.mGameInfoManager = new GameInfoManager();
    this.mReportManager = new GameReportManager();
    this.mInspectorAgentWrapper = new bgzf();
    this.mRuntimeListeners = new ArrayList();
    this.mInstalledEngineLoadTaskListener = new GameRuntimeLoader.1(this);
    this.mGpkgLoadTaskListener = new GameRuntimeLoader.2(this);
    initBaseTasks();
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
  
  private void initBaseTasks()
  {
    this.mInstalledEngineLoadTask = new InstalledEngineLoadTask(this.mContext, this.mInstalledEngineLoadTaskListener);
    this.mTritonEngineInitTask = new TritonEngineInitTask(this.mContext, this.mInspectorAgentWrapper, new QQEnvImp(this), new APIProxyImpl(this));
    this.mTritonEngineInitTask.addDependTask(this.mInstalledEngineLoadTask);
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
    return (this.mInstalledEngineLoadTask.isDone()) && (this.mInstalledEngineLoadTask.isSucceed());
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
  
  private void onInstalledEngineTaskDone(BaseTask paramBaseTask) {}
  
  private void onTritonEngineInitTaskDone(BaseTask paramBaseTask)
  {
    Object localObject;
    if (!paramBaseTask.isSucceed())
    {
      localObject = ((TritonEngineInitTask)paramBaseTask).getAppConfig();
      if (localObject != null)
      {
        MiniProgramLpReportDC04239.reportPageView((MiniAppConfig)localObject, "1", null, "load_fail", "baselib_task_fail");
        MiniAppReportManager2.reportPageView("2launch_fail", "baselib_task_fail", null, (MiniAppConfig)localObject);
        if (((MiniAppConfig)localObject).config != null) {
          localObject = ((MiniAppConfig)localObject).config.appId;
        }
      }
    }
    for (;;)
    {
      localObject = new ArrayList(this.mRuntimeListeners).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((GameRuntimeLoader.GameRuntimeListener)((Iterator)localObject).next()).onEngineLoad(paramBaseTask.isSucceed(), paramBaseTask.msg, paramBaseTask.retCode);
      }
      getGameEngine().setJsEngine(this.mJsPluginEngine);
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
  
  public String getBaseEnginePath()
  {
    return this.mInstalledEngineLoadTask.getInstalledEnginePath();
  }
  
  public ITTEngine getGameEngine()
  {
    return this.mTritonEngineInitTask.getGameEngine();
  }
  
  public GameInfoManager getGameInfoManager()
  {
    return this.mGameInfoManager;
  }
  
  public bgzf getInspectorAgentWrapper()
  {
    return this.mInspectorAgentWrapper;
  }
  
  public InstalledEngine getInstalledEngine()
  {
    InstalledEngine localInstalledEngine = this.mInstalledEngineLoadTask.getInstalledEngine();
    if ((localInstalledEngine != null) && (localInstalledEngine.isVerify)) {
      return localInstalledEngine;
    }
    return null;
  }
  
  public GameJsPluginEngine getJsPluginEngine()
  {
    return this.mJsPluginEngine;
  }
  
  public GameLibVersionManager getLibVersionManager()
  {
    return this.mLibVersionManager;
  }
  
  public MiniGamePkg getMiniGamePkg()
  {
    return this.mGamePkg;
  }
  
  public GameReportManager getReportManager()
  {
    return this.mReportManager;
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
      if ((paramBaseTask instanceof InstalledEngineLoadTask)) {
        onInstalledEngineTaskDone(paramBaseTask);
      } else if ((paramBaseTask instanceof TritonEngineInitTask)) {
        onTritonEngineInitTaskDone(paramBaseTask);
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
  
  public GameRuntimeLoader unRegisterListener(GameRuntimeLoader.GameRuntimeListener paramGameRuntimeListener)
  {
    this.mRuntimeListeners.remove(paramGameRuntimeListener);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */