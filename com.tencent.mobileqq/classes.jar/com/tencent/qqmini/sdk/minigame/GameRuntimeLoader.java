package com.tencent.qqmini.sdk.minigame;

import android.content.Context;
import android.text.TextUtils;
import bdfx;
import bdlq;
import bdlr;
import bdlx;
import bdnw;
import bdnx;
import bdpd;
import bdpy;
import bdqa;
import bdqm;
import bdqp;
import bdqr;
import bdqs;
import bdsc;
import bdsx;
import bdxz;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.InstalledEngine;

public class GameRuntimeLoader
  extends bdlq
{
  public static final bdlr<GameRuntimeLoader> CREATOR = new bdpd();
  public static final String LOG_TAG = "GameRuntimeLoader";
  private boolean baseEngineLoaded;
  private bdqm mGameEngineLoadTask;
  private bdqp mGpkgLoadTask;
  private bdqr mInitGameRuntimeTask;
  private bdqs mMiniAppInfoLoadTask;
  private bdpy miniGamePkg;
  
  private GameRuntimeLoader(Context paramContext)
  {
    super(paramContext);
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
        if (TextUtils.equals(this.miniGamePkg.d, paramMiniAppInfo.appId)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void onGameEngineLoadTaskDone(bdqm parambdqm)
  {
    if (!parambdqm.d())
    {
      this.baseEngineLoaded = false;
      parambdqm = parambdqm.a();
      if (parambdqm != null)
      {
        bdsx.a(parambdqm, "1", null, "page_view", "load_fail", "baselib_task_fail", "");
        bdsc.a("2launch_fail", "baselib_task_fail", null, parambdqm);
        if (parambdqm != null) {
          parambdqm = parambdqm.appId;
        }
      }
      notifyRuntimeEvent(2013, new Object[0]);
      return;
    }
    this.baseEngineLoaded = true;
    notifyRuntimeEvent(2012, new Object[0]);
  }
  
  private void onGpkgLoadAsyncTaskDone(bdqp parambdqp)
  {
    if (parambdqp.d())
    {
      this.miniGamePkg = parambdqp.a();
      bdqa.a().a(this.miniGamePkg);
      notifyRuntimeEvent(2002, new Object[0]);
    }
    for (;;)
    {
      this.mGameEngineLoadTask.jdField_a_of_type_Boolean = true;
      return;
      notifyRuntimeEvent(2003, new Object[0]);
      this.miniGamePkg = null;
      parambdqp = parambdqp.a();
      if (parambdqp != null)
      {
        bdsx.a(parambdqp, "1", null, "page_view", "load_fail", "pkg_task_fail", "");
        bdsc.a("2launch_fail", "pkg_task_fail", null, parambdqp);
        if (parambdqp != null) {
          parambdqp = parambdqp.appId;
        }
      }
    }
  }
  
  private void onInitGameRuntimeTaskDone(bdqr parambdqr)
  {
    this.mRuntime = parambdqr.a();
    onRuntimeLoadResult(0, "Load runtime successfully");
    this.mIsRunning = false;
  }
  
  private void onMiniAppInfoLoadTaskDone(bdqs parambdqs)
  {
    if (!parambdqs.d()) {
      return;
    }
    this.mMiniAppInfo = parambdqs.a();
    bdlx.a().a(this.mMiniAppInfo);
    this.mGpkgLoadTask.a(this.mMiniAppInfo);
  }
  
  public bdxz[] createTasks()
  {
    this.mMiniAppInfoLoadTask = new bdqs(this.mContext, this);
    this.mGameEngineLoadTask = new bdqm(this.mContext, this);
    this.mGpkgLoadTask = new bdqp(this.mContext, this);
    this.mInitGameRuntimeTask = new bdqr(this.mContext, this);
    this.mInitGameRuntimeTask.a(this.mGameEngineLoadTask).a(this.mGpkgLoadTask.a(this.mMiniAppInfoLoadTask));
    addTasks(new bdxz[] { this.mGameEngineLoadTask, this.mGpkgLoadTask, this.mInitGameRuntimeTask, this.mMiniAppInfoLoadTask });
    return new bdxz[] { this.mInitGameRuntimeTask };
  }
  
  public boolean dismissLoadingAfterLoaded()
  {
    return false;
  }
  
  public String getBaseEnginePath()
  {
    return this.mGameEngineLoadTask.a();
  }
  
  public InstalledEngine getEngine()
  {
    InstalledEngine localInstalledEngine = this.mGameEngineLoadTask.a();
    if ((localInstalledEngine != null) && (localInstalledEngine.jdField_a_of_type_Boolean)) {
      return localInstalledEngine;
    }
    return null;
  }
  
  public String getEngineVersion()
  {
    InstalledEngine localInstalledEngine = this.mGameEngineLoadTask.a();
    if ((localInstalledEngine != null) && (localInstalledEngine.b == 3)) {
      return String.valueOf(localInstalledEngine.jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion);
    }
    return "";
  }
  
  public ITTEngine getGameEngine()
  {
    return this.mGameEngineLoadTask.a();
  }
  
  public bdpy getMiniGamePkg()
  {
    return this.miniGamePkg;
  }
  
  public boolean isGameReadyStart(MiniAppInfo paramMiniAppInfo)
  {
    boolean bool = isGamePkgReady(paramMiniAppInfo);
    bdnw.b("GameRuntimeLoader", "[MiniEng]isGameReadyStart:" + bool + ",baseEngineLoaded:" + this.baseEngineLoaded);
    return (this.baseEngineLoaded) && (bool);
  }
  
  public void loadMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    paramMiniAppInfo.apkgInfo = new bdfx(bdnx.a(this.mMiniAppInfo), paramMiniAppInfo);
    this.mMiniAppInfoLoadTask.a(paramMiniAppInfo);
    this.mGameEngineLoadTask.a(paramMiniAppInfo);
    this.mGpkgLoadTask.a(paramMiniAppInfo);
    super.loadMiniAppInfo(paramMiniAppInfo);
  }
  
  public void onTaskDone(bdxz parambdxz)
  {
    if (parambdxz == null) {}
    for (;;)
    {
      return;
      bdnw.b("GameRuntimeLoader", "[MiniEng]" + parambdxz + " done! succ:" + parambdxz.d());
      if ((parambdxz instanceof bdqp)) {
        onGpkgLoadAsyncTaskDone((bdqp)parambdxz);
      }
      while (parambdxz.c())
      {
        updateFlow(parambdxz);
        return;
        if ((parambdxz instanceof bdqm)) {
          onGameEngineLoadTaskDone((bdqm)parambdxz);
        } else if ((parambdxz instanceof bdqs)) {
          onMiniAppInfoLoadTaskDone((bdqs)parambdxz);
        } else if ((parambdxz instanceof bdqr)) {
          onInitGameRuntimeTaskDone((bdqr)parambdxz);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */