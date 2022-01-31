package com.tencent.qqmini.sdk.runtime.app;

import android.content.Context;
import beqm;
import beqn;
import betc;
import bfbd;
import bfbe;
import bfbf;
import bfea;
import bfec;
import bfee;
import bfef;
import bfeg;
import bfeh;
import bfej;
import bffi;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class AppRuntimeLoader
  extends beqm
{
  public static final beqn<AppRuntimeLoader> CREATOR = new bfbd();
  public static final String TAG = "AppRuntimeLoader";
  private bfea apkgLoadTask;
  private bfec baselibLoadTask;
  private bfbe pageCreateTask;
  private bfbf pageInitTask;
  private bfee preloadFlagTask;
  public bfef runtimeCreateTask;
  private bfeg runtimeInitTask;
  public bfeh serviceCreateTask;
  public bfej serviceInitTask;
  
  public AppRuntimeLoader(Context paramContext)
  {
    super(paramContext);
  }
  
  public bffi[] createTasks()
  {
    Context localContext = this.mContext;
    this.runtimeCreateTask = new bfef(localContext, this);
    this.serviceCreateTask = new bfeh(localContext, this);
    this.runtimeInitTask = new bfeg(localContext, this);
    this.baselibLoadTask = new bfec(localContext, this);
    this.apkgLoadTask = new bfea(localContext, this);
    this.serviceInitTask = new bfej(localContext, this);
    this.preloadFlagTask = new bfee(localContext, this);
    this.pageCreateTask = new bfbe(localContext, this);
    this.pageInitTask = new bfbf(localContext, this);
    this.runtimeInitTask.a(this.preloadFlagTask.a(this.serviceInitTask.a(this.serviceCreateTask.a(this.runtimeCreateTask)).a(this.baselibLoadTask)).a(this.pageInitTask.a(this.pageCreateTask.a(this.runtimeCreateTask)).a(this.baselibLoadTask))).a(this.apkgLoadTask);
    return new bffi[] { this.runtimeInitTask };
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
    betc.a("AppRuntimeLoader", "onTaskDone " + parambffi);
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
        if (this.runtimeInitTask.d()) {
          notifyRuntimeEvent(4, new Object[0]);
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
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.app.AppRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */