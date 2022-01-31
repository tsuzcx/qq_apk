package com.tencent.qqmini.sdk.runtime.flutter;

import android.content.Context;
import bgqg;
import bgqh;
import bhdl;
import bhdu;
import bhdw;
import bhdz;
import bhea;
import bheb;
import bhee;
import bheh;
import bhhn;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class FlutterRuntimeLoader
  extends bgqg
{
  public static final bgqh<FlutterRuntimeLoader> CREATOR = new bhdl();
  public static final String TAG = "FlutterRuntimeLoader";
  private bhdu apkgLoadTask;
  private bhdw baselibLoadTask;
  private bhdz preloadFlagTask;
  public bhea runtimeCreateTask;
  private bheb runtimeInitTask;
  public bhee serviceInitTask;
  
  public FlutterRuntimeLoader(Context paramContext)
  {
    super(paramContext);
    getAppStateManager().c = true;
  }
  
  public bhhn[] createTasks()
  {
    Context localContext = this.mContext;
    this.runtimeCreateTask = new bhea(localContext, this);
    this.runtimeCreateTask.a(true);
    this.runtimeInitTask = new bheb(localContext, this);
    this.runtimeInitTask.a(true);
    this.baselibLoadTask = new bhdw(localContext, this);
    this.apkgLoadTask = new bhdu(localContext, this);
    this.apkgLoadTask.a(true);
    this.serviceInitTask = new bheh(localContext, this);
    this.preloadFlagTask = new bhdz(localContext, this);
    this.runtimeInitTask.a(this.preloadFlagTask.a(this.serviceInitTask.a(this.baselibLoadTask).a(this.runtimeCreateTask))).a(this.apkgLoadTask);
    return new bhhn[] { this.runtimeInitTask };
  }
  
  public boolean dismissLoadingAfterLoaded()
  {
    return false;
  }
  
  public void loadMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    super.loadMiniAppInfo(paramMiniAppInfo);
    this.apkgLoadTask.a(paramMiniAppInfo);
  }
  
  public void onTaskDone(bhhn parambhhn)
  {
    if (parambhhn == null) {
      return;
    }
    if (!parambhhn.d())
    {
      notifyRuntimeEvent(12, new Object[0]);
      onRuntimeLoadResult(parambhhn.a, parambhhn.b);
      return;
    }
    if (parambhhn == this.preloadFlagTask) {
      notifyRuntimeEvent(3, new Object[0]);
    }
    for (;;)
    {
      super.onTaskDone(parambhhn);
      return;
      if (parambhhn == this.runtimeCreateTask)
      {
        if (this.runtimeCreateTask.d()) {
          this.mRuntime = this.runtimeCreateTask.a();
        }
      }
      else if (parambhhn == this.runtimeInitTask)
      {
        if (this.runtimeInitTask.d())
        {
          notifyRuntimeEvent(10, new Object[0]);
          onRuntimeLoadResult(0, "");
        }
        this.mIsRunning = false;
      }
      else if ((parambhhn == this.apkgLoadTask) && (this.apkgLoadTask.d()) && (this.mMiniAppInfo != null))
      {
        this.mMiniAppInfo.apkgInfo = this.apkgLoadTask.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.flutter.FlutterRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */