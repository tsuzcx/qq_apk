package com.tencent.qqmini.sdk.runtime.app;

import android.content.Context;
import bgqg;
import bgqh;
import bhaf;
import bhag;
import bhah;
import bhdu;
import bhdw;
import bhdz;
import bhea;
import bheb;
import bhec;
import bhee;
import bheg;
import bhhn;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class AppRuntimeLoader
  extends bgqg
{
  public static final bgqh<AppRuntimeLoader> CREATOR = new bhaf();
  public static final String TAG = "AppRuntimeLoader";
  private bhdu apkgLoadTask;
  private bhdw baselibLoadTask;
  private bhag pageCreateTask;
  private bhah pageInitTask;
  private bhdz preloadFlagTask;
  public bhea runtimeCreateTask;
  private bheb runtimeInitTask;
  public bhec serviceCreateTask;
  public bhee serviceInitTask;
  bheg tbsTask;
  
  public AppRuntimeLoader(Context paramContext)
  {
    super(paramContext);
  }
  
  public bhhn[] createTasks()
  {
    Context localContext = this.mContext;
    this.runtimeCreateTask = new bhea(localContext, this);
    this.tbsTask = new bheg(localContext, this);
    this.serviceCreateTask = new bhec(localContext, this);
    this.runtimeInitTask = new bheb(localContext, this);
    this.baselibLoadTask = new bhdw(localContext, this);
    this.apkgLoadTask = new bhdu(localContext, this);
    this.serviceInitTask = new bhee(localContext, this);
    this.preloadFlagTask = new bhdz(localContext, this);
    this.pageCreateTask = new bhag(localContext, this);
    this.pageInitTask = new bhah(localContext, this);
    this.runtimeInitTask.a(this.preloadFlagTask.a(this.serviceInitTask.a(this.serviceCreateTask.a(this.tbsTask).a(this.runtimeCreateTask)).a(this.baselibLoadTask)).a(this.pageInitTask.a(this.pageCreateTask.a(this.runtimeCreateTask)).a(this.baselibLoadTask))).a(this.apkgLoadTask);
    return new bhhn[] { this.runtimeInitTask };
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
        if (this.runtimeInitTask.d()) {
          notifyRuntimeEvent(4, new Object[0]);
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
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.app.AppRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */