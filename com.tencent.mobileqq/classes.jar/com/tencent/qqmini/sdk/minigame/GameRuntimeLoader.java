package com.tencent.qqmini.sdk.minigame;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import bgjw;
import bgpn;
import bgqc;
import bgqg;
import bgqh;
import bgrb;
import bgtj;
import bgto;
import bgtq;
import bgtt;
import bgun;
import bgut;
import bguv;
import bguw;
import bguy;
import bgvc;
import bgvd;
import bgvf;
import bgvg;
import bgvi;
import bgvl;
import bgxl;
import bgyg;
import bhhn;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.manager.EngineChannel;
import com.tencent.qqmini.sdk.manager.InstalledEngine;

public class GameRuntimeLoader
  extends bgqg
{
  public static final bgqh<GameRuntimeLoader> CREATOR = new bgto();
  public static final String LOG_TAG = "GameRuntimeLoader";
  private bgut mGameInfoManager = new bgut();
  private bgvc mGameRuntimeCreateTask;
  private bgvd mGpkgLoadTask;
  private bgvf mInitGameRuntimeTask;
  private bguy mInspectorAgentWrapper = new bguy();
  private bgvg mInstalledEngineLoadTask;
  private bguv mLibVersionManager = new bguv();
  private bgvi mMiniAppInfoLoadTask;
  private bguw mReportManager = new bguw();
  private bgvl mTritonEngineInitTask;
  private bgun miniGamePkg;
  
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
  
  private void onGameRuntimeCreateTask(bgvc parambgvc)
  {
    parambgvc = parambgvc.a();
    parambgvc.a(this.mGameInfoManager);
    parambgvc.a(this.mReportManager);
    parambgvc.a(this.mLibVersionManager.b());
    this.mRuntime = parambgvc;
  }
  
  private void onGpkgLoadAsyncTaskDone(bgvd parambgvd)
  {
    if (parambgvd.d())
    {
      this.miniGamePkg = parambgvd.a();
      this.mGameInfoManager.a(this.miniGamePkg);
      this.mGameInfoManager.a(this.mMiniAppInfo);
      if (!parambgvd.d()) {
        break label115;
      }
    }
    label115:
    for (int i = 2002;; i = 2003)
    {
      notifyRuntimeEvent(i, new Object[] { parambgvd.b });
      return;
      this.miniGamePkg = null;
      Object localObject = parambgvd.a();
      if (localObject == null) {
        break;
      }
      bgyg.a((MiniAppInfo)localObject, "1", null, "page_view", "load_fail", "pkg_task_fail", "");
      bgxl.a("2launch_fail", "pkg_task_fail", null, (MiniAppInfo)localObject);
      if (localObject == null) {
        break;
      }
      localObject = ((MiniAppInfo)localObject).appId;
      break;
    }
  }
  
  private void onInitGameRuntimeTaskDone(bgvf parambgvf)
  {
    this.mIsRunning = false;
    notifyRuntimeEvent(2021, new Object[0]);
    onRuntimeLoadResult(0, "Load runtime successfully");
  }
  
  private void onInstalledEngineLoadTask(bgvg parambgvg)
  {
    this.mTritonEngineInitTask.a(parambgvg.a());
  }
  
  private void onMiniAppInfoLoadTaskDone(bgvi parambgvi)
  {
    if (!parambgvi.d()) {
      return;
    }
    this.mMiniAppInfo = parambgvi.a();
    this.mGpkgLoadTask.a(this.mMiniAppInfo);
  }
  
  private void onTritonEngineInitTask(bgvl parambgvl)
  {
    if (!parambgvl.d())
    {
      Object localObject = parambgvl.a();
      if (localObject != null)
      {
        bgyg.a((MiniAppInfo)localObject, "1", null, "page_view", "load_fail", "baselib_task_fail", "");
        bgxl.a("2launch_fail", "baselib_task_fail", null, (MiniAppInfo)localObject);
        if (localObject != null) {
          localObject = ((MiniAppInfo)localObject).appId;
        }
      }
      if (!parambgvl.d()) {
        break label97;
      }
    }
    label97:
    for (int i = 2012;; i = 2013)
    {
      notifyRuntimeEvent(i, new Object[] { Integer.valueOf(parambgvl.a) });
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
      bgpn.a().a("cmd_on_preload_game_baselib", localBundle, null);
      if (QMLog.isColorLevel()) {
        QMLog.i("BaseRuntimeLoader", "[MiniEng]preload engine version:" + str);
      }
    }
  }
  
  public bhhn[] createTasks()
  {
    this.mGameRuntimeCreateTask = new bgvc(this.mContext, this);
    this.mMiniAppInfoLoadTask = new bgvi(this.mContext, this);
    this.mTritonEngineInitTask = new bgvl(this.mContext, this, this.mInspectorAgentWrapper, new bgtt(this), new bgtq(this));
    this.mInstalledEngineLoadTask = new bgvg(this.mContext, this);
    this.mGpkgLoadTask = new bgvd(this.mContext, this);
    this.mInitGameRuntimeTask = new bgvf(this.mContext, this);
    this.mInitGameRuntimeTask.a(this.mTritonEngineInitTask.a(this.mInstalledEngineLoadTask.a(this.mGameRuntimeCreateTask))).a(this.mGpkgLoadTask.a(this.mMiniAppInfoLoadTask));
    return new bhhn[] { this.mInitGameRuntimeTask };
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
  
  public bgut getGameInfoManager()
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
  
  public bguv getLibVersionManager()
  {
    return this.mLibVersionManager;
  }
  
  public bgun getMiniGamePkg()
  {
    return this.miniGamePkg;
  }
  
  public bguw getReportManager()
  {
    return this.mReportManager;
  }
  
  public boolean isGameReadyStart(MiniAppInfo paramMiniAppInfo)
  {
    return (isGameEngineReady()) && (isGamePkgReady(paramMiniAppInfo));
  }
  
  public void loadMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    paramMiniAppInfo.apkgInfo = new bgjw(bgrb.a(this.mMiniAppInfo), paramMiniAppInfo);
    this.mMiniAppInfoLoadTask.a(paramMiniAppInfo);
    this.mTritonEngineInitTask.a(paramMiniAppInfo);
    super.loadMiniAppInfo(paramMiniAppInfo);
  }
  
  public void onTaskDone(bhhn parambhhn)
  {
    if (parambhhn == null) {}
    for (;;)
    {
      return;
      if (!parambhhn.d())
      {
        notifyRuntimeEvent(12, new Object[0]);
        onRuntimeLoadResult(parambhhn.a, parambhhn.b);
        return;
      }
      QMLog.i("GameRuntimeLoader", "[MiniEng]" + parambhhn + " done! succ:" + parambhhn.d());
      if ((parambhhn instanceof bgvc)) {
        onGameRuntimeCreateTask((bgvc)parambhhn);
      }
      while (parambhhn.c())
      {
        updateFlow(parambhhn);
        return;
        if ((parambhhn instanceof bgvd)) {
          onGpkgLoadAsyncTaskDone((bgvd)parambhhn);
        } else if ((parambhhn instanceof bgvg)) {
          onInstalledEngineLoadTask((bgvg)parambhhn);
        } else if ((parambhhn instanceof bgvl)) {
          onTritonEngineInitTask((bgvl)parambhhn);
        } else if ((parambhhn instanceof bgvi)) {
          onMiniAppInfoLoadTaskDone((bgvi)parambhhn);
        } else if ((parambhhn instanceof bgvf)) {
          onInitGameRuntimeTaskDone((bgvf)parambhhn);
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