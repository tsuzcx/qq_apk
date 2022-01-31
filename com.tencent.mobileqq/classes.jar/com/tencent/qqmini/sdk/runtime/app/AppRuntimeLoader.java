package com.tencent.qqmini.sdk.runtime.app;

import android.content.Context;
import bgun;
import bguo;
import bhem;
import bhen;
import bheo;
import bhib;
import bhid;
import bhig;
import bhih;
import bhii;
import bhij;
import bhil;
import bhin;
import bhlu;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class AppRuntimeLoader
  extends bgun
{
  public static final bguo<AppRuntimeLoader> CREATOR = new bhem();
  public static final String TAG = "AppRuntimeLoader";
  private bhib apkgLoadTask;
  private bhid baselibLoadTask;
  private bhen pageCreateTask;
  private bheo pageInitTask;
  private bhig preloadFlagTask;
  public bhih runtimeCreateTask;
  private bhii runtimeInitTask;
  public bhij serviceCreateTask;
  public bhil serviceInitTask;
  bhin tbsTask;
  
  public AppRuntimeLoader(Context paramContext)
  {
    super(paramContext);
  }
  
  public bhlu[] createTasks()
  {
    Context localContext = this.mContext;
    this.runtimeCreateTask = new bhih(localContext, this);
    this.tbsTask = new bhin(localContext, this);
    this.serviceCreateTask = new bhij(localContext, this);
    this.runtimeInitTask = new bhii(localContext, this);
    this.baselibLoadTask = new bhid(localContext, this);
    this.apkgLoadTask = new bhib(localContext, this);
    this.serviceInitTask = new bhil(localContext, this);
    this.preloadFlagTask = new bhig(localContext, this);
    this.pageCreateTask = new bhen(localContext, this);
    this.pageInitTask = new bheo(localContext, this);
    this.runtimeInitTask.a(this.preloadFlagTask.a(this.serviceInitTask.a(this.serviceCreateTask.a(this.tbsTask).a(this.runtimeCreateTask)).a(this.baselibLoadTask)).a(this.pageInitTask.a(this.pageCreateTask.a(this.runtimeCreateTask)).a(this.baselibLoadTask))).a(this.apkgLoadTask);
    return new bhlu[] { this.runtimeInitTask };
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
        if (this.runtimeInitTask.d()) {
          notifyRuntimeEvent(4, new Object[0]);
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
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.app.AppRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */