package com.tencent.qqmini.sdk.runtime.flutter;

import android.content.Context;
import beqm;
import beqn;
import betc;
import bfdw;
import bfea;
import bfec;
import bfee;
import bfef;
import bfeg;
import bfej;
import bfel;
import bffi;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class FlutterRuntimeLoader
  extends beqm
{
  public static final beqn<FlutterRuntimeLoader> CREATOR = new bfdw();
  public static final String TAG = "FlutterRuntimeLoader";
  private bfea apkgLoadTask;
  private bfec baselibLoadTask;
  private bfee preloadFlagTask;
  public bfef runtimeCreateTask;
  private bfeg runtimeInitTask;
  public bfej serviceInitTask;
  
  public FlutterRuntimeLoader(Context paramContext)
  {
    super(paramContext);
    getAppStateManager().c = true;
  }
  
  public bffi[] createTasks()
  {
    Context localContext = this.mContext;
    this.runtimeCreateTask = new bfef(localContext, this);
    this.runtimeCreateTask.a(true);
    this.runtimeInitTask = new bfeg(localContext, this);
    this.runtimeInitTask.a(true);
    this.baselibLoadTask = new bfec(localContext, this);
    this.apkgLoadTask = new bfea(localContext, this);
    this.apkgLoadTask.a(true);
    this.serviceInitTask = new bfel(localContext, this);
    this.preloadFlagTask = new bfee(localContext, this);
    this.runtimeInitTask.a(this.preloadFlagTask.a(this.serviceInitTask.a(this.baselibLoadTask).a(this.runtimeCreateTask))).a(this.apkgLoadTask);
    return new bffi[] { this.runtimeInitTask };
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
  
  public void onTaskDone(bffi parambffi)
  {
    if (parambffi == null) {
      return;
    }
    betc.a("FlutterRuntimeLoader", "onTaskDone " + parambffi);
    if (!parambffi.d())
    {
      notifyRuntimeEvent(12, new Object[0]);
      onRuntimeLoadResult(parambffi.jdField_a_of_type_Int, parambffi.jdField_a_of_type_JavaLangString);
      return;
    }
    if (parambffi == this.preloadFlagTask) {
      notifyRuntimeEvent(3, new Object[0]);
    }
    for (;;)
    {
      super.onTaskDone(parambffi);
      return;
      if (parambffi == this.runtimeCreateTask)
      {
        if (this.runtimeCreateTask.d()) {
          this.mRuntime = this.runtimeCreateTask.a();
        }
      }
      else if (parambffi == this.runtimeInitTask)
      {
        if (this.runtimeInitTask.d())
        {
          notifyRuntimeEvent(10, new Object[0]);
          onRuntimeLoadResult(0, "");
        }
        this.mIsRunning = false;
      }
      else if ((parambffi == this.apkgLoadTask) && (this.apkgLoadTask.d()) && (this.mMiniAppInfo != null))
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