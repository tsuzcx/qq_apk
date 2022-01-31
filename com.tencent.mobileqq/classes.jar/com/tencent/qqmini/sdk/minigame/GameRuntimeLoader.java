package com.tencent.qqmini.sdk.minigame;

import android.content.Context;
import android.text.TextUtils;
import bejy;
import bepv;
import bepw;
import beqh;
import besl;
import besm;
import beul;
import bevc;
import bevi;
import bevy;
import bewb;
import bewc;
import bewe;
import bewf;
import bexz;
import beyu;
import bfer;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.InstalledEngine;

public class GameRuntimeLoader
  extends bepv
{
  public static final bepw<GameRuntimeLoader> CREATOR = new beul();
  public static final String LOG_TAG = "GameRuntimeLoader";
  private boolean baseEngineLoaded;
  private bevy mGameEngineLoadTask;
  private bewb mGameRuntimeCreateTask;
  private bewc mGpkgLoadTask;
  private bewe mInitGameRuntimeTask;
  private bewf mMiniAppInfoLoadTask;
  private bevc miniGamePkg;
  
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
  
  private void onGameEngineLoadTaskDone(bevy parambevy)
  {
    if (!parambevy.d())
    {
      this.baseEngineLoaded = false;
      parambevy = parambevy.a();
      if (parambevy != null)
      {
        beyu.a(parambevy, "1", null, "page_view", "load_fail", "baselib_task_fail", "");
        bexz.a("2launch_fail", "baselib_task_fail", null, parambevy);
        if (parambevy != null) {
          parambevy = parambevy.appId;
        }
      }
      notifyRuntimeEvent(2013, new Object[] { Integer.valueOf(this.mGameEngineLoadTask.jdField_a_of_type_Int) });
      return;
    }
    this.baseEngineLoaded = true;
    notifyRuntimeEvent(2012, new Object[0]);
  }
  
  private void onGameRuntimeCreateTask(bewb parambewb)
  {
    this.mRuntime = parambewb.a();
  }
  
  private void onGpkgLoadAsyncTaskDone(bewc parambewc)
  {
    if (parambewc.d())
    {
      this.miniGamePkg = parambewc.a();
      bevi.a().a(this.miniGamePkg);
      bevi.a().a(this.mMiniAppInfo);
      notifyRuntimeEvent(2002, new Object[0]);
    }
    for (;;)
    {
      this.mGameEngineLoadTask.jdField_a_of_type_Boolean = true;
      return;
      notifyRuntimeEvent(2003, new Object[0]);
      this.miniGamePkg = null;
      parambewc = parambewc.a();
      if (parambewc != null)
      {
        beyu.a(parambewc, "1", null, "page_view", "load_fail", "pkg_task_fail", "");
        bexz.a("2launch_fail", "pkg_task_fail", null, parambewc);
        if (parambewc != null) {
          parambewc = parambewc.appId;
        }
      }
    }
  }
  
  private void onInitGameRuntimeTaskDone(bewe parambewe)
  {
    this.mIsRunning = false;
    notifyRuntimeEvent(2031, new Object[0]);
    onRuntimeLoadResult(0, "Load runtime successfully");
  }
  
  private void onMiniAppInfoLoadTaskDone(bewf parambewf)
  {
    if (!parambewf.d()) {
      return;
    }
    this.mMiniAppInfo = parambewf.a();
    beqh.a().a(this.mMiniAppInfo);
    this.mGpkgLoadTask.a(this.mMiniAppInfo);
  }
  
  public bfer[] createTasks()
  {
    this.mGameRuntimeCreateTask = new bewb(this.mContext, this);
    this.mMiniAppInfoLoadTask = new bewf(this.mContext, this);
    this.mGameEngineLoadTask = new bevy(this.mContext, this);
    this.mGpkgLoadTask = new bewc(this.mContext, this);
    this.mInitGameRuntimeTask = new bewe(this.mContext, this);
    this.mInitGameRuntimeTask.a(this.mGameEngineLoadTask.a(this.mGameRuntimeCreateTask)).a(this.mGpkgLoadTask.a(this.mMiniAppInfoLoadTask));
    return new bfer[] { this.mInitGameRuntimeTask };
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
  
  public ITTEngine getGameEngine()
  {
    return this.mGameEngineLoadTask.a();
  }
  
  public bevc getMiniGamePkg()
  {
    return this.miniGamePkg;
  }
  
  public boolean isGameReadyStart(MiniAppInfo paramMiniAppInfo)
  {
    boolean bool = isGamePkgReady(paramMiniAppInfo);
    besl.b("GameRuntimeLoader", "[MiniEng]isGameReadyStart:" + bool + ",baseEngineLoaded:" + this.baseEngineLoaded);
    return (this.baseEngineLoaded) && (bool);
  }
  
  public void loadMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    paramMiniAppInfo.apkgInfo = new bejy(besm.a(this.mMiniAppInfo), paramMiniAppInfo);
    this.mMiniAppInfoLoadTask.a(paramMiniAppInfo);
    this.mGameEngineLoadTask.a(paramMiniAppInfo);
    this.mGpkgLoadTask.a(paramMiniAppInfo);
    super.loadMiniAppInfo(paramMiniAppInfo);
  }
  
  public void onTaskDone(bfer parambfer)
  {
    if (parambfer == null) {}
    for (;;)
    {
      return;
      besl.b("GameRuntimeLoader", "[MiniEng]" + parambfer + " done! succ:" + parambfer.d());
      if ((parambfer instanceof bewb)) {
        onGameRuntimeCreateTask((bewb)parambfer);
      }
      while (parambfer.c())
      {
        updateFlow(parambfer);
        return;
        if ((parambfer instanceof bewc)) {
          onGpkgLoadAsyncTaskDone((bewc)parambfer);
        } else if ((parambfer instanceof bevy)) {
          onGameEngineLoadTaskDone((bevy)parambfer);
        } else if ((parambfer instanceof bewf)) {
          onMiniAppInfoLoadTaskDone((bewf)parambfer);
        } else if ((parambfer instanceof bewe)) {
          onInitGameRuntimeTaskDone((bewe)parambfer);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */