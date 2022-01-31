package com.tencent.qqmini.sdk.minigame;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import bgod;
import bgtu;
import bguj;
import bgun;
import bguo;
import bgvi;
import bgxq;
import bgxv;
import bgxx;
import bgya;
import bgyu;
import bgza;
import bgzc;
import bgzd;
import bgzf;
import bgzj;
import bgzk;
import bgzm;
import bgzn;
import bgzp;
import bgzs;
import bhbs;
import bhcn;
import bhlu;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.manager.EngineChannel;
import com.tencent.qqmini.sdk.manager.InstalledEngine;

public class GameRuntimeLoader
  extends bgun
{
  public static final bguo<GameRuntimeLoader> CREATOR = new bgxv();
  public static final String LOG_TAG = "GameRuntimeLoader";
  private bgza mGameInfoManager = new bgza();
  private bgzj mGameRuntimeCreateTask;
  private bgzk mGpkgLoadTask;
  private bgzm mInitGameRuntimeTask;
  private bgzf mInspectorAgentWrapper = new bgzf();
  private bgzn mInstalledEngineLoadTask;
  private bgzc mLibVersionManager = new bgzc();
  private bgzp mMiniAppInfoLoadTask;
  private bgzd mReportManager = new bgzd();
  private bgzs mTritonEngineInitTask;
  private bgyu miniGamePkg;
  
  private GameRuntimeLoader(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean isGameEngineReady()
  {
    return (this.mInstalledEngineLoadTask.c()) && (this.mInstalledEngineLoadTask.d());
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
  
  private void onGameRuntimeCreateTask(bgzj parambgzj)
  {
    parambgzj = parambgzj.a();
    parambgzj.a(this.mGameInfoManager);
    parambgzj.a(this.mReportManager);
    parambgzj.a(this.mLibVersionManager.b());
    this.mRuntime = parambgzj;
  }
  
  private void onGpkgLoadAsyncTaskDone(bgzk parambgzk)
  {
    if (parambgzk.d())
    {
      this.miniGamePkg = parambgzk.a();
      this.mGameInfoManager.a(this.miniGamePkg);
      this.mGameInfoManager.a(this.mMiniAppInfo);
      if (!parambgzk.d()) {
        break label115;
      }
    }
    label115:
    for (int i = 2002;; i = 2003)
    {
      notifyRuntimeEvent(i, new Object[] { parambgzk.b });
      return;
      this.miniGamePkg = null;
      Object localObject = parambgzk.a();
      if (localObject == null) {
        break;
      }
      bhcn.a((MiniAppInfo)localObject, "1", null, "page_view", "load_fail", "pkg_task_fail", "");
      bhbs.a("2launch_fail", "pkg_task_fail", null, (MiniAppInfo)localObject);
      if (localObject == null) {
        break;
      }
      localObject = ((MiniAppInfo)localObject).appId;
      break;
    }
  }
  
  private void onInitGameRuntimeTaskDone(bgzm parambgzm)
  {
    this.mIsRunning = false;
    notifyRuntimeEvent(2021, new Object[0]);
    onRuntimeLoadResult(0, "Load runtime successfully");
  }
  
  private void onInstalledEngineLoadTask(bgzn parambgzn)
  {
    this.mTritonEngineInitTask.a(parambgzn.a());
  }
  
  private void onMiniAppInfoLoadTaskDone(bgzp parambgzp)
  {
    if (!parambgzp.d()) {
      return;
    }
    this.mMiniAppInfo = parambgzp.a();
    this.mGpkgLoadTask.a(this.mMiniAppInfo);
  }
  
  private void onTritonEngineInitTask(bgzs parambgzs)
  {
    if (!parambgzs.d())
    {
      Object localObject = parambgzs.a();
      if (localObject != null)
      {
        bhcn.a((MiniAppInfo)localObject, "1", null, "page_view", "load_fail", "baselib_task_fail", "");
        bhbs.a("2launch_fail", "baselib_task_fail", null, (MiniAppInfo)localObject);
        if (localObject != null) {
          localObject = ((MiniAppInfo)localObject).appId;
        }
      }
      if (!parambgzs.d()) {
        break label97;
      }
    }
    label97:
    for (int i = 2012;; i = 2013)
    {
      notifyRuntimeEvent(i, new Object[] { Integer.valueOf(parambgzs.a) });
      return;
      if (!getAppStateManager().a) {
        break;
      }
      sendPreloadBaseLibVersion();
      break;
    }
  }
  
  private void sendPreloadBaseLibVersion()
  {
    String str = this.mLibVersionManager.b();
    if (str != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("bundle_key_process_name", AppLoaderFactory.g().getProcessName());
      localBundle.putString("bundle_key_preload_game_baselib_version", str);
      bgtu.a().a("cmd_on_preload_game_baselib", localBundle, null);
      if (QMLog.isColorLevel()) {
        QMLog.i("BaseRuntimeLoader", "[MiniEng]preload engine version:" + str);
      }
    }
  }
  
  public bhlu[] createTasks()
  {
    this.mGameRuntimeCreateTask = new bgzj(this.mContext, this);
    this.mMiniAppInfoLoadTask = new bgzp(this.mContext, this);
    this.mTritonEngineInitTask = new bgzs(this.mContext, this, this.mInspectorAgentWrapper, new bgya(this), new bgxx(this));
    this.mInstalledEngineLoadTask = new bgzn(this.mContext, this);
    this.mGpkgLoadTask = new bgzk(this.mContext, this);
    this.mInitGameRuntimeTask = new bgzm(this.mContext, this);
    this.mInitGameRuntimeTask.a(this.mTritonEngineInitTask.a(this.mInstalledEngineLoadTask.a(this.mGameRuntimeCreateTask))).a(this.mGpkgLoadTask.a(this.mMiniAppInfoLoadTask));
    return new bhlu[] { this.mInitGameRuntimeTask };
  }
  
  public boolean dismissLoadingAfterLoaded()
  {
    return false;
  }
  
  public String getBaseEnginePath()
  {
    return this.mInstalledEngineLoadTask.a();
  }
  
  public ITTEngine getGameEngine()
  {
    return this.mTritonEngineInitTask.a();
  }
  
  public bgza getGameInfoManager()
  {
    return this.mGameInfoManager;
  }
  
  public InstalledEngine getInstalledEngine()
  {
    InstalledEngine localInstalledEngine = this.mInstalledEngineLoadTask.a();
    if ((localInstalledEngine != null) && (localInstalledEngine.a)) {
      return localInstalledEngine;
    }
    return null;
  }
  
  public bgzc getLibVersionManager()
  {
    return this.mLibVersionManager;
  }
  
  public bgyu getMiniGamePkg()
  {
    return this.miniGamePkg;
  }
  
  public bgzd getReportManager()
  {
    return this.mReportManager;
  }
  
  public boolean isGameReadyStart(MiniAppInfo paramMiniAppInfo)
  {
    return (isGameEngineReady()) && (isGamePkgReady(paramMiniAppInfo));
  }
  
  public void loadMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    paramMiniAppInfo.apkgInfo = new bgod(bgvi.a(this.mMiniAppInfo), paramMiniAppInfo);
    this.mMiniAppInfoLoadTask.a(paramMiniAppInfo);
    this.mTritonEngineInitTask.a(paramMiniAppInfo);
    super.loadMiniAppInfo(paramMiniAppInfo);
  }
  
  public void onTaskDone(bhlu parambhlu)
  {
    if (parambhlu == null) {}
    for (;;)
    {
      return;
      if (!parambhlu.d())
      {
        notifyRuntimeEvent(12, new Object[0]);
        onRuntimeLoadResult(parambhlu.a, parambhlu.b);
        return;
      }
      QMLog.i("GameRuntimeLoader", "[MiniEng]" + parambhlu + " done! succ:" + parambhlu.d());
      if ((parambhlu instanceof bgzj)) {
        onGameRuntimeCreateTask((bgzj)parambhlu);
      }
      while (parambhlu.c())
      {
        updateFlow(parambhlu);
        return;
        if ((parambhlu instanceof bgzk)) {
          onGpkgLoadAsyncTaskDone((bgzk)parambhlu);
        } else if ((parambhlu instanceof bgzn)) {
          onInstalledEngineLoadTask((bgzn)parambhlu);
        } else if ((parambhlu instanceof bgzs)) {
          onTritonEngineInitTask((bgzs)parambhlu);
        } else if ((parambhlu instanceof bgzp)) {
          onMiniAppInfoLoadTaskDone((bgzp)parambhlu);
        } else if ((parambhlu instanceof bgzm)) {
          onInitGameRuntimeTaskDone((bgzm)parambhlu);
        }
      }
    }
  }
  
  public void setEngineChannel(EngineChannel paramEngineChannel)
  {
    this.mInstalledEngineLoadTask.a(paramEngineChannel);
    QMLog.i("GameRuntimeLoader", "[MiniEng]setEngineChannel " + paramEngineChannel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */