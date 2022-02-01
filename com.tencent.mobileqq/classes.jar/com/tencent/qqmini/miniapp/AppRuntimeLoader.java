package com.tencent.qqmini.miniapp;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.core.AppBrandRuntime;
import com.tencent.qqmini.miniapp.task.ApkgLoadAsyncTask;
import com.tencent.qqmini.miniapp.task.BaselibLoadAsyncTask;
import com.tencent.qqmini.miniapp.task.BaselibVersionCheckTask;
import com.tencent.qqmini.miniapp.task.PageCreateTask;
import com.tencent.qqmini.miniapp.task.PageInitTask;
import com.tencent.qqmini.miniapp.task.PreloadFlagTask;
import com.tencent.qqmini.miniapp.task.RuntimeCreateTask;
import com.tencent.qqmini.miniapp.task.RuntimeInitTask;
import com.tencent.qqmini.miniapp.task.ServiceCreateTask;
import com.tencent.qqmini.miniapp.task.ServiceInitTask;
import com.tencent.qqmini.miniapp.task.TbsAsyncTask;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl.BaselibProvider;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.AppStateManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.Creator;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.OnAppRuntimeLoadListener;
import com.tencent.qqmini.sdk.task.BaseTask;
import com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask;
import com.tencent.qqmini.sdk.task.TaskThreadPool;

@MiniKeep
public class AppRuntimeLoader
  extends BaseRuntimeLoader
{
  @MiniKeep
  public static final BaseRuntimeLoader.Creator<AppRuntimeLoader> CREATOR = new AppRuntimeLoader.1();
  public static final String TAG = "AppRuntimeLoader";
  private ApkgLoadAsyncTask apkgLoadTask;
  private BaselibLoadAsyncTask baselibLoadTask;
  private BaselibVersionCheckTask baselibVersionCheckTask;
  private volatile boolean fromUpdate = false;
  private MiniAppInfoLoadTask miniAppInfoLoadTask;
  private PageCreateTask pageCreateTask;
  private PageInitTask pageInitTask;
  private PreloadFlagTask preloadFlagTask;
  public RuntimeCreateTask runtimeCreateTask;
  private RuntimeInitTask runtimeInitTask;
  public ServiceCreateTask serviceCreateTask;
  public ServiceInitTask serviceInitTask;
  private TbsAsyncTask tbsTask;
  
  public AppRuntimeLoader(Context paramContext)
  {
    super(paramContext);
  }
  
  private void onBaselibUpdated()
  {
    QMLog.i("AppRuntimeLoader", "BaselibVersionCheck baselib updated, reset runtimeloader!");
    pause();
    resetTaskAndDepends(this.baselibLoadTask);
    resetTaskAndDepends(this.serviceCreateTask);
    resetTaskAndDepends(this.pageCreateTask);
    start();
  }
  
  private void onMiniAppVersionUpdate()
  {
    QMLog.i("AppRuntimeLoader", "onMiniAppVersionUpdate, reset apkgLoadTask & runtimeCreateTask.");
    pause();
    resetTaskAndDepends(this.apkgLoadTask);
    resetTaskAndDepends(this.runtimeCreateTask);
    this.mRuntime = createRuntime(this.mContext);
    this.mRuntime.setRuntimeMsgObserver(this);
    start();
  }
  
  private void setRuntimeBaselib()
  {
    if ((this.mRuntime == null) || (this.baselibLoadTask.getBaselibContent() == null)) {
      return;
    }
    ((BaseRuntimeImpl.BaselibProvider)this.mRuntime.getManager(BaseRuntimeImpl.BaselibProvider.class)).setBaseLib(this.baselibLoadTask.getBaselibContent());
  }
  
  public BaseRuntime createRuntime(Context paramContext)
  {
    paramContext = new AppBrandRuntime(paramContext);
    paramContext.setRuntimeMsgObserver(this);
    paramContext.setAppStateManager(getAppStateManager());
    return paramContext;
  }
  
  public BaseTask[] createTasks()
  {
    Context localContext = this.mContext;
    this.runtimeCreateTask = new RuntimeCreateTask(localContext, this);
    this.tbsTask = new TbsAsyncTask(localContext, this);
    this.serviceCreateTask = new ServiceCreateTask(localContext, this);
    this.runtimeInitTask = new RuntimeInitTask(localContext, this);
    this.baselibLoadTask = new BaselibLoadAsyncTask(localContext, this);
    this.miniAppInfoLoadTask = new MiniAppInfoLoadTask(localContext, this);
    this.apkgLoadTask = new ApkgLoadAsyncTask(localContext, this);
    this.serviceInitTask = new ServiceInitTask(localContext, this);
    this.preloadFlagTask = new PreloadFlagTask(localContext, this);
    this.pageCreateTask = new PageCreateTask(localContext, this);
    this.pageInitTask = new PageInitTask(localContext, this);
    this.baselibVersionCheckTask = new BaselibVersionCheckTask(localContext, this);
    this.runtimeInitTask.addDependTask(this.preloadFlagTask.addDependTask(this.serviceInitTask.addDependTask(this.serviceCreateTask.addDependTask(this.tbsTask).addDependTask(this.runtimeCreateTask)).addDependTask(this.baselibLoadTask)).addDependTask(this.pageInitTask.addDependTask(this.pageCreateTask.addDependTask(this.runtimeCreateTask)).addDependTask(this.baselibLoadTask))).addDependTask(this.apkgLoadTask.addDependTask(this.miniAppInfoLoadTask)).addDependTask(this.baselibVersionCheckTask.addDependTask(this.miniAppInfoLoadTask).addDependTask(this.baselibLoadTask));
    return new BaseTask[] { this.runtimeInitTask };
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {
      return;
    }
    if ((!paramBaseTask.isSucceed()) && ((paramBaseTask instanceof BaselibVersionCheckTask)) && (12 == paramBaseTask.retCode))
    {
      super.onTaskDone(paramBaseTask);
      onBaselibUpdated();
      return;
    }
    if (!paramBaseTask.isSucceed())
    {
      notifyRuntimeEvent(12, new Object[0]);
      onRuntimeLoadResult(paramBaseTask.retCode, paramBaseTask.msg);
      return;
    }
    if (checkAllTaskIsDone()) {
      setStatus(5);
    }
    if (paramBaseTask == this.preloadFlagTask)
    {
      if ((getAppStateManager().isFromPreload == true) && (this.mMiniAppInfo == null)) {
        setStatus(4);
      }
      notifyRuntimeEvent(3, new Object[0]);
    }
    for (;;)
    {
      super.onTaskDone(paramBaseTask);
      return;
      if (paramBaseTask == this.runtimeCreateTask)
      {
        if (this.runtimeCreateTask.isSucceed()) {
          setRuntimeBaselib();
        }
      }
      else if (paramBaseTask == this.baselibLoadTask)
      {
        setRuntimeBaselib();
      }
      else if (paramBaseTask == this.runtimeInitTask)
      {
        if (this.runtimeInitTask.isSucceed())
        {
          notifyRuntimeEvent(4, new Object[0]);
          onRuntimeLoadResult(0, "");
        }
        this.mIsRunning = false;
      }
      else if (paramBaseTask == this.miniAppInfoLoadTask)
      {
        QMLog.w("AppRuntimeLoader", "fromUpdate: " + this.fromUpdate + " threadId=" + Thread.currentThread().getId());
        if (!this.fromUpdate)
        {
          this.mMiniAppInfo = this.miniAppInfoLoadTask.getMiniAppInfo();
        }
        else
        {
          this.fromUpdate = false;
          MiniAppInfo localMiniAppInfo = this.miniAppInfoLoadTask.getMiniAppInfo();
          boolean bool = MiniAppBaseInfo.isSameVersion(localMiniAppInfo, this.mMiniAppInfo);
          ApkgBaseInfo localApkgBaseInfo = this.mMiniAppInfo.apkgInfo;
          this.mMiniAppInfo = localMiniAppInfo;
          this.mMiniAppInfo.apkgInfo = localApkgBaseInfo;
          if (bool)
          {
            if (!TextUtils.isEmpty(this.mMiniAppInfo.launchParam.entryPath)) {
              this.mNeedReloadPage = true;
            }
            if (this.mRuntimeLoadListener != null) {
              this.mRuntimeLoadListener.onResult(0, "", this);
            }
          }
          else
          {
            onMiniAppVersionUpdate();
          }
        }
      }
      else if ((paramBaseTask == this.apkgLoadTask) && (this.apkgLoadTask.isSucceed()) && (this.mMiniAppInfo != null))
      {
        this.mMiniAppInfo.apkgInfo = this.apkgLoadTask.getApkgInfo();
      }
    }
  }
  
  public void resetAndStart(MiniAppInfo paramMiniAppInfo)
  {
    super.resetAndStart(paramMiniAppInfo);
    this.mTaskThreadPool.addExecuteTask(new AppRuntimeLoader.2(this, paramMiniAppInfo));
  }
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    super.setMiniAppInfo(paramMiniAppInfo);
    this.miniAppInfoLoadTask.setMiniAppInfo(paramMiniAppInfo);
  }
  
  public void updateMiniAppInfoFromReload(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo.isFakeAppInfo())
    {
      this.fromUpdate = true;
      QMLog.w("AppRuntimeLoader", "updateMiniAppInfoFromReload  fromUpdate: " + this.fromUpdate + " threadId=" + Thread.currentThread().getId());
      this.miniAppInfoLoadTask.reset();
      this.miniAppInfoLoadTask.setStatus(2);
      this.miniAppInfoLoadTask.setMiniAppInfo(paramMiniAppInfo);
      return;
    }
    super.updateMiniAppInfoFromReload(paramMiniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.AppRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */