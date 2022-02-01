package com.tencent.qqmini.flutter;

import android.content.Context;
import com.tencent.qqmini.flutter.core.NativeAppBrandRuntime;
import com.tencent.qqmini.flutter.core.task.FlutterRuntimeInitTask;
import com.tencent.qqmini.flutter.core.task.NativeRuntimeCreateTask;
import com.tencent.qqmini.flutter.core.task.TissueEngineInitTask;
import com.tencent.qqmini.flutter.core.task.V8ServiceInitTask;
import com.tencent.qqmini.miniapp.task.ApkgLoadAsyncTask;
import com.tencent.qqmini.miniapp.task.BaselibLoadAsyncTask;
import com.tencent.qqmini.miniapp.task.PreloadFlagTask;
import com.tencent.qqmini.miniapp.task.ServiceInitTask;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl.BaselibProvider;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.report.MiniAppPrelaunchRecorder;
import com.tencent.qqmini.sdk.runtime.AppStateManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.Creator;
import com.tencent.qqmini.sdk.task.BaseTask;

@MiniKeep
public class FlutterRuntimeLoader
  extends BaseRuntimeLoader
{
  @MiniKeep
  public static final BaseRuntimeLoader.Creator<FlutterRuntimeLoader> CREATOR = new FlutterRuntimeLoader.1();
  public static final String TAG = "FlutterRuntimeLoader";
  private ApkgLoadAsyncTask apkgLoadTask;
  private BaselibLoadAsyncTask baselibLoadTask;
  private PreloadFlagTask preloadFlagTask;
  public NativeRuntimeCreateTask runtimeCreateTask;
  private FlutterRuntimeInitTask runtimeInitTask;
  public ServiceInitTask serviceInitTask;
  private TissueEngineInitTask tissueEngineInitTask;
  
  public FlutterRuntimeLoader(Context paramContext)
  {
    super(paramContext);
    getAppStateManager().isFlutter = true;
  }
  
  private void onApkgLoadTaskDone()
  {
    if ((this.apkgLoadTask.isSucceed()) && (this.mMiniAppInfo != null)) {
      this.mMiniAppInfo.apkgInfo = this.apkgLoadTask.getApkgInfo();
    }
  }
  
  private void onPreloadFlagTaskDone()
  {
    if ((getAppStateManager().isFromPreload == true) && (this.mMiniAppInfo == null)) {
      setStatus(4);
    }
    notifyRuntimeEvent(3, new Object[0]);
  }
  
  private void onRuntimeInitTaskDone()
  {
    if (this.runtimeInitTask.isSucceed())
    {
      notifyRuntimeEvent(10, new Object[0]);
      onRuntimeLoadResult(0, "");
      MiniAppPrelaunchRecorder.get().onFlutterTaskDone();
      if (this.baselibLoadTask != null)
      {
        BaselibLoader.BaselibContent localBaselibContent = this.baselibLoadTask.getBaselibContent();
        if ((localBaselibContent != null) && ((getRuntime() instanceof NativeAppBrandRuntime))) {
          ((NativeAppBrandRuntime)getRuntime()).setBaselibContent(localBaselibContent);
        }
      }
    }
    this.mIsRunning = false;
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
    try
    {
      paramContext = new NativeAppBrandRuntime(paramContext);
      paramContext.setAppStateManager(getAppStateManager());
      paramContext.setRuntimeMsgObserver(this);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      QMLog.e("FlutterRuntimeLoader", "createRuntime error!", paramContext);
    }
    return null;
  }
  
  public BaseTask[] createTasks()
  {
    Context localContext = this.mContext;
    this.runtimeCreateTask = new NativeRuntimeCreateTask(localContext, this);
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    this.runtimeCreateTask.setFlutterProxy(localChannelProxy.getFlutterProxy());
    this.runtimeInitTask = new FlutterRuntimeInitTask(localContext, this);
    this.baselibLoadTask = new BaselibLoadAsyncTask(localContext, this);
    this.apkgLoadTask = new ApkgLoadAsyncTask(localContext, this);
    this.apkgLoadTask.setFlutterEnable(true);
    this.serviceInitTask = new V8ServiceInitTask(localContext, this);
    this.preloadFlagTask = new PreloadFlagTask(localContext, this);
    this.tissueEngineInitTask = new TissueEngineInitTask(localContext, this);
    this.runtimeInitTask.addDependTask(this.preloadFlagTask.addDependTask(this.serviceInitTask.addDependTask(this.baselibLoadTask)).addDependTask(this.tissueEngineInitTask.addDependTask(this.runtimeCreateTask))).addDependTask(this.apkgLoadTask);
    return new BaseTask[] { this.runtimeInitTask };
  }
  
  public boolean dismissLoadingAfterLoaded()
  {
    return false;
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {
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
    if (paramBaseTask == this.preloadFlagTask) {
      onPreloadFlagTaskDone();
    }
    for (;;)
    {
      super.onTaskDone(paramBaseTask);
      return;
      if (paramBaseTask == this.baselibLoadTask) {
        setRuntimeBaselib();
      } else if (paramBaseTask == this.runtimeCreateTask)
      {
        if (this.runtimeCreateTask.isSucceed()) {
          setRuntimeBaselib();
        }
      }
      else if (paramBaseTask == this.runtimeInitTask) {
        onRuntimeInitTaskDone();
      } else if (paramBaseTask == this.apkgLoadTask) {
        onApkgLoadTaskDone();
      }
    }
  }
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    super.setMiniAppInfo(paramMiniAppInfo);
    paramMiniAppInfo.renderMode = 1;
    this.apkgLoadTask.loadApkg(paramMiniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.FlutterRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */