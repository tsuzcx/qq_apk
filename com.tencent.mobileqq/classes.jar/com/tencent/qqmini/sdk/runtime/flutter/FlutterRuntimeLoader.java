package com.tencent.qqmini.sdk.runtime.flutter;

import android.content.Context;
import bepv;
import bepw;
import besl;
import bfdf;
import bfdj;
import bfdl;
import bfdn;
import bfdo;
import bfdp;
import bfds;
import bfdu;
import bfer;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class FlutterRuntimeLoader
  extends bepv
{
  public static final bepw<FlutterRuntimeLoader> CREATOR = new bfdf();
  public static final String TAG = "FlutterRuntimeLoader";
  private bfdj apkgLoadTask;
  private bfdl baselibLoadTask;
  private bfdn preloadFlagTask;
  public bfdo runtimeCreateTask;
  private bfdp runtimeInitTask;
  public bfds serviceInitTask;
  
  public FlutterRuntimeLoader(Context paramContext)
  {
    super(paramContext);
    getAppStateManager().c = true;
  }
  
  public bfer[] createTasks()
  {
    Context localContext = this.mContext;
    this.runtimeCreateTask = new bfdo(localContext, this);
    this.runtimeCreateTask.a(true);
    this.runtimeInitTask = new bfdp(localContext, this);
    this.runtimeInitTask.a(true);
    this.baselibLoadTask = new bfdl(localContext, this);
    this.apkgLoadTask = new bfdj(localContext, this);
    this.apkgLoadTask.a(true);
    this.serviceInitTask = new bfdu(localContext, this);
    this.preloadFlagTask = new bfdn(localContext, this);
    this.runtimeInitTask.a(this.preloadFlagTask.a(this.serviceInitTask.a(this.baselibLoadTask).a(this.runtimeCreateTask))).a(this.apkgLoadTask);
    return new bfer[] { this.runtimeInitTask };
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
  
  public void onTaskDone(bfer parambfer)
  {
    if (parambfer == null) {
      return;
    }
    besl.a("FlutterRuntimeLoader", "onTaskDone " + parambfer);
    if (!parambfer.d())
    {
      notifyRuntimeEvent(12, new Object[0]);
      onRuntimeLoadResult(parambfer.jdField_a_of_type_Int, parambfer.jdField_a_of_type_JavaLangString);
      return;
    }
    if (parambfer == this.preloadFlagTask) {
      notifyRuntimeEvent(3, new Object[0]);
    }
    for (;;)
    {
      super.onTaskDone(parambfer);
      return;
      if (parambfer == this.runtimeCreateTask)
      {
        if (this.runtimeCreateTask.d()) {
          this.mRuntime = this.runtimeCreateTask.a();
        }
      }
      else if (parambfer == this.runtimeInitTask)
      {
        if (this.runtimeInitTask.d())
        {
          notifyRuntimeEvent(10, new Object[0]);
          onRuntimeLoadResult(0, "");
        }
        this.mIsRunning = false;
      }
      else if ((parambfer == this.apkgLoadTask) && (this.apkgLoadTask.d()) && (this.mMiniAppInfo != null))
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