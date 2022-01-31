package com.tencent.qqmini.sdk.runtime.app;

import android.content.Context;
import bepv;
import bepw;
import besl;
import bfam;
import bfan;
import bfao;
import bfdj;
import bfdl;
import bfdn;
import bfdo;
import bfdp;
import bfdq;
import bfds;
import bfer;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class AppRuntimeLoader
  extends bepv
{
  public static final bepw<AppRuntimeLoader> CREATOR = new bfam();
  public static final String TAG = "AppRuntimeLoader";
  private bfdj apkgLoadTask;
  private bfdl baselibLoadTask;
  private bfan pageCreateTask;
  private bfao pageInitTask;
  private bfdn preloadFlagTask;
  public bfdo runtimeCreateTask;
  private bfdp runtimeInitTask;
  public bfdq serviceCreateTask;
  public bfds serviceInitTask;
  
  public AppRuntimeLoader(Context paramContext)
  {
    super(paramContext);
  }
  
  public bfer[] createTasks()
  {
    Context localContext = this.mContext;
    this.runtimeCreateTask = new bfdo(localContext, this);
    this.serviceCreateTask = new bfdq(localContext, this);
    this.runtimeInitTask = new bfdp(localContext, this);
    this.baselibLoadTask = new bfdl(localContext, this);
    this.apkgLoadTask = new bfdj(localContext, this);
    this.serviceInitTask = new bfds(localContext, this);
    this.preloadFlagTask = new bfdn(localContext, this);
    this.pageCreateTask = new bfan(localContext, this);
    this.pageInitTask = new bfao(localContext, this);
    this.runtimeInitTask.a(this.preloadFlagTask.a(this.serviceInitTask.a(this.serviceCreateTask.a(this.runtimeCreateTask)).a(this.baselibLoadTask)).a(this.pageInitTask.a(this.pageCreateTask.a(this.runtimeCreateTask)).a(this.baselibLoadTask))).a(this.apkgLoadTask);
    return new bfer[] { this.runtimeInitTask };
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
    besl.a("AppRuntimeLoader", "onTaskDone " + parambfer);
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
        if (this.runtimeInitTask.d()) {
          notifyRuntimeEvent(4, new Object[0]);
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
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.app.AppRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */