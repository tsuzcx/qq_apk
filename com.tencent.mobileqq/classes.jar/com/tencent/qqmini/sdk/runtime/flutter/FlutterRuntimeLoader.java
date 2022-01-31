package com.tencent.qqmini.sdk.runtime.flutter;

import android.content.Context;
import bgun;
import bguo;
import bhhs;
import bhib;
import bhid;
import bhig;
import bhih;
import bhii;
import bhil;
import bhio;
import bhlu;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class FlutterRuntimeLoader
  extends bgun
{
  public static final bguo<FlutterRuntimeLoader> CREATOR = new bhhs();
  public static final String TAG = "FlutterRuntimeLoader";
  private bhib apkgLoadTask;
  private bhid baselibLoadTask;
  private bhig preloadFlagTask;
  public bhih runtimeCreateTask;
  private bhii runtimeInitTask;
  public bhil serviceInitTask;
  
  public FlutterRuntimeLoader(Context paramContext)
  {
    super(paramContext);
    getAppStateManager().c = true;
  }
  
  public bhlu[] createTasks()
  {
    Context localContext = this.mContext;
    this.runtimeCreateTask = new bhih(localContext, this);
    this.runtimeCreateTask.a(true);
    this.runtimeInitTask = new bhii(localContext, this);
    this.runtimeInitTask.a(true);
    this.baselibLoadTask = new bhid(localContext, this);
    this.apkgLoadTask = new bhib(localContext, this);
    this.apkgLoadTask.a(true);
    this.serviceInitTask = new bhio(localContext, this);
    this.preloadFlagTask = new bhig(localContext, this);
    this.runtimeInitTask.a(this.preloadFlagTask.a(this.serviceInitTask.a(this.baselibLoadTask).a(this.runtimeCreateTask))).a(this.apkgLoadTask);
    return new bhlu[] { this.runtimeInitTask };
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
  
  public void onTaskDone(bhlu parambhlu)
  {
    if (parambhlu == null) {
      return;
    }
    if (!parambhlu.d())
    {
      notifyRuntimeEvent(12, new Object[0]);
      onRuntimeLoadResult(parambhlu.a, parambhlu.b);
      return;
    }
    if (parambhlu == this.preloadFlagTask) {
      notifyRuntimeEvent(3, new Object[0]);
    }
    for (;;)
    {
      super.onTaskDone(parambhlu);
      return;
      if (parambhlu == this.runtimeCreateTask)
      {
        if (this.runtimeCreateTask.d()) {
          this.mRuntime = this.runtimeCreateTask.a();
        }
      }
      else if (parambhlu == this.runtimeInitTask)
      {
        if (this.runtimeInitTask.d())
        {
          notifyRuntimeEvent(10, new Object[0]);
          onRuntimeLoadResult(0, "");
        }
        this.mIsRunning = false;
      }
      else if ((parambhlu == this.apkgLoadTask) && (this.apkgLoadTask.d()) && (this.mMiniAppInfo != null))
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