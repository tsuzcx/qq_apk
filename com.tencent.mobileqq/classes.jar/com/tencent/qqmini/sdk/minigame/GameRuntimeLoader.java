package com.tencent.qqmini.sdk.minigame;

import android.content.Context;
import android.text.TextUtils;
import bekp;
import beqm;
import beqn;
import beqy;
import betc;
import betd;
import bevc;
import bevt;
import bevz;
import bewp;
import bews;
import bewt;
import bewv;
import beww;
import beyq;
import bezl;
import bffi;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.InstalledEngine;

public class GameRuntimeLoader
  extends beqm
{
  public static final beqn<GameRuntimeLoader> CREATOR = new bevc();
  public static final String LOG_TAG = "GameRuntimeLoader";
  private boolean baseEngineLoaded;
  private bewp mGameEngineLoadTask;
  private bews mGameRuntimeCreateTask;
  private bewt mGpkgLoadTask;
  private bewv mInitGameRuntimeTask;
  private beww mMiniAppInfoLoadTask;
  private bevt miniGamePkg;
  
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
  
  private void onGameEngineLoadTaskDone(bewp parambewp)
  {
    if (!parambewp.d())
    {
      this.baseEngineLoaded = false;
      parambewp = parambewp.a();
      if (parambewp != null)
      {
        bezl.a(parambewp, "1", null, "page_view", "load_fail", "baselib_task_fail", "");
        beyq.a("2launch_fail", "baselib_task_fail", null, parambewp);
        if (parambewp != null) {
          parambewp = parambewp.appId;
        }
      }
      notifyRuntimeEvent(2013, new Object[] { Integer.valueOf(this.mGameEngineLoadTask.jdField_a_of_type_Int) });
      return;
    }
    this.baseEngineLoaded = true;
    notifyRuntimeEvent(2012, new Object[0]);
  }
  
  private void onGameRuntimeCreateTask(bews parambews)
  {
    this.mRuntime = parambews.a();
  }
  
  private void onGpkgLoadAsyncTaskDone(bewt parambewt)
  {
    if (parambewt.d())
    {
      this.miniGamePkg = parambewt.a();
      bevz.a().a(this.miniGamePkg);
      bevz.a().a(this.mMiniAppInfo);
      notifyRuntimeEvent(2002, new Object[0]);
    }
    for (;;)
    {
      this.mGameEngineLoadTask.jdField_a_of_type_Boolean = true;
      return;
      notifyRuntimeEvent(2003, new Object[0]);
      this.miniGamePkg = null;
      parambewt = parambewt.a();
      if (parambewt != null)
      {
        bezl.a(parambewt, "1", null, "page_view", "load_fail", "pkg_task_fail", "");
        beyq.a("2launch_fail", "pkg_task_fail", null, parambewt);
        if (parambewt != null) {
          parambewt = parambewt.appId;
        }
      }
    }
  }
  
  private void onInitGameRuntimeTaskDone(bewv parambewv)
  {
    this.mIsRunning = false;
    notifyRuntimeEvent(2031, new Object[0]);
    onRuntimeLoadResult(0, "Load runtime successfully");
  }
  
  private void onMiniAppInfoLoadTaskDone(beww parambeww)
  {
    if (!parambeww.d()) {
      return;
    }
    this.mMiniAppInfo = parambeww.a();
    beqy.a().a(this.mMiniAppInfo);
    this.mGpkgLoadTask.a(this.mMiniAppInfo);
  }
  
  public bffi[] createTasks()
  {
    this.mGameRuntimeCreateTask = new bews(this.mContext, this);
    this.mMiniAppInfoLoadTask = new beww(this.mContext, this);
    this.mGameEngineLoadTask = new bewp(this.mContext, this);
    this.mGpkgLoadTask = new bewt(this.mContext, this);
    this.mInitGameRuntimeTask = new bewv(this.mContext, this);
    this.mInitGameRuntimeTask.a(this.mGameEngineLoadTask.a(this.mGameRuntimeCreateTask)).a(this.mGpkgLoadTask.a(this.mMiniAppInfoLoadTask));
    return new bffi[] { this.mInitGameRuntimeTask };
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
  
  public bevt getMiniGamePkg()
  {
    return this.miniGamePkg;
  }
  
  public boolean isGameReadyStart(MiniAppInfo paramMiniAppInfo)
  {
    boolean bool = isGamePkgReady(paramMiniAppInfo);
    betc.b("GameRuntimeLoader", "[MiniEng]isGameReadyStart:" + bool + ",baseEngineLoaded:" + this.baseEngineLoaded);
    return (this.baseEngineLoaded) && (bool);
  }
  
  public void loadMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    paramMiniAppInfo.apkgInfo = new bekp(betd.a(this.mMiniAppInfo), paramMiniAppInfo);
    this.mMiniAppInfoLoadTask.a(paramMiniAppInfo);
    this.mGameEngineLoadTask.a(paramMiniAppInfo);
    this.mGpkgLoadTask.a(paramMiniAppInfo);
    super.loadMiniAppInfo(paramMiniAppInfo);
  }
  
  public void onTaskDone(bffi parambffi)
  {
    if (parambffi == null) {}
    for (;;)
    {
      return;
      betc.b("GameRuntimeLoader", "[MiniEng]" + parambffi + " done! succ:" + parambffi.d());
      if ((parambffi instanceof bews)) {
        onGameRuntimeCreateTask((bews)parambffi);
      }
      while (parambffi.c())
      {
        updateFlow(parambffi);
        return;
        if ((parambffi instanceof bewt)) {
          onGpkgLoadAsyncTaskDone((bewt)parambffi);
        } else if ((parambffi instanceof bewp)) {
          onGameEngineLoadTaskDone((bewp)parambffi);
        } else if ((parambffi instanceof beww)) {
          onMiniAppInfoLoadTaskDone((beww)parambffi);
        } else if ((parambffi instanceof bewv)) {
          onInitGameRuntimeTaskDone((bewv)parambffi);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */