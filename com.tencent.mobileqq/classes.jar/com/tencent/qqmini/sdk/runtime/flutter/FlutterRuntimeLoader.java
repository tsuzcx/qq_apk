package com.tencent.qqmini.sdk.runtime.flutter;

import android.content.Context;
import bdlq;
import bdlr;
import bdnw;
import bdws;
import bdwv;
import bdwx;
import bdwz;
import bdxa;
import bdxb;
import bdxc;
import bdxz;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class FlutterRuntimeLoader
  extends bdlq
{
  public static final bdlr<FlutterRuntimeLoader> CREATOR = new bdws();
  public static final String TAG = "FlutterRuntimeLoader";
  private bdwv apkgLoadTask;
  private bdwx baselibLoadTask;
  private bdwz preloadFlagTask;
  public bdxa runtimeCreateTask;
  private bdxb runtimeInitTask;
  public bdxc serviceInitTask;
  
  public FlutterRuntimeLoader(Context paramContext)
  {
    super(paramContext);
    getAppStateManager().c = true;
  }
  
  public bdxz[] createTasks()
  {
    Context localContext = this.mContext;
    this.runtimeCreateTask = new bdxa(localContext, this);
    this.runtimeCreateTask.a(true);
    this.runtimeInitTask = new bdxb(localContext, this);
    this.runtimeInitTask.a(true);
    this.baselibLoadTask = new bdwx(localContext, this);
    this.apkgLoadTask = new bdwv(localContext, this);
    this.apkgLoadTask.a(true);
    this.serviceInitTask = new bdxc(localContext, this);
    this.serviceInitTask.a(true);
    this.preloadFlagTask = new bdwz(localContext, this);
    this.runtimeInitTask.a(this.preloadFlagTask.a(this.serviceInitTask.a(this.baselibLoadTask).a(this.runtimeCreateTask))).a(this.apkgLoadTask);
    addTasks(new bdxz[] { this.runtimeInitTask, this.preloadFlagTask, this.serviceInitTask, this.baselibLoadTask, this.runtimeCreateTask, this.apkgLoadTask });
    return new bdxz[] { this.runtimeInitTask };
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
  
  public void onTaskDone(bdxz parambdxz)
  {
    if (parambdxz == null) {
      return;
    }
    bdnw.a("FlutterRuntimeLoader", "onTaskDone " + parambdxz);
    if (!parambdxz.d())
    {
      notifyRuntimeEvent(12, new Object[0]);
      onRuntimeLoadResult(parambdxz.jdField_a_of_type_Int, parambdxz.jdField_a_of_type_JavaLangString);
      return;
    }
    if (parambdxz == this.preloadFlagTask) {
      notifyRuntimeEvent(3, new Object[0]);
    }
    for (;;)
    {
      super.onTaskDone(parambdxz);
      return;
      if (parambdxz == this.runtimeCreateTask)
      {
        if (this.runtimeCreateTask.d()) {
          this.mRuntime = this.runtimeCreateTask.a();
        }
      }
      else if (parambdxz == this.runtimeInitTask)
      {
        if (this.runtimeInitTask.d())
        {
          notifyRuntimeEvent(10, new Object[0]);
          onRuntimeLoadResult(0, "");
        }
        this.mIsRunning = false;
      }
      else if ((parambdxz == this.apkgLoadTask) && (this.apkgLoadTask.d()) && (this.mMiniAppInfo != null))
      {
        this.mMiniAppInfo.apkgInfo = this.apkgLoadTask.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.flutter.FlutterRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */