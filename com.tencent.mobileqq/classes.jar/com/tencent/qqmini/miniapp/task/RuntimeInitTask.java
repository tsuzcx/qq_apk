package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.miniapp.core.service.IAppBrandService;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.MainThreadTask;

@ClassTag(tag="RuntimeInitTask")
public class RuntimeInitTask
  extends MainThreadTask
{
  private BaseAppBrandRuntime appBrandRuntime;
  
  public RuntimeInitTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  public void executeInMainThread()
  {
    MiniAppReportManager2.reportLaunchPiecewise(202, "", getRuntimeLoader().getMiniAppInfoForReport());
    MiniAppInfo localMiniAppInfo = getRuntimeLoader().getMiniAppInfo();
    IAppBrandService localIAppBrandService = getAppBrandService();
    this.appBrandRuntime = ((BaseAppBrandRuntime)getRuntimeLoader().getRuntime());
    BaseAppBrandRuntime localBaseAppBrandRuntime = this.appBrandRuntime;
    if ((localBaseAppBrandRuntime != null) && (localIAppBrandService != null) && (localMiniAppInfo != null))
    {
      localBaseAppBrandRuntime.init(localIAppBrandService);
      this.appBrandRuntime.loadMiniApp(localMiniAppInfo);
      localIAppBrandService.setApkgInfo((ApkgInfo)localMiniAppInfo.apkgInfo);
      onTaskSucceed();
      return;
    }
    onTaskFailed();
  }
  
  public void executeStartTime()
  {
    MiniAppReportManager2.reportLaunchPiecewise(222, "", getRuntimeLoader().getMiniAppInfoForReport());
  }
  
  public BaseAppBrandRuntime getAppBrandRuntime()
  {
    return this.appBrandRuntime;
  }
  
  protected IAppBrandService getAppBrandService()
  {
    ServiceInitTask localServiceInitTask = (ServiceInitTask)getRuntimeLoader().getTask(ServiceInitTask.class);
    if (localServiceInitTask != null) {
      return localServiceInitTask.getJsService();
    }
    return null;
  }
  
  public void onTaskSucceed()
  {
    super.onTaskSucceed();
    MiniAppReportManager2.reportLaunchPiecewise(203, "", getRuntimeLoader().getMiniAppInfoForReport());
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if (localChannelProxy != null) {
      localChannelProxy.onInitFinish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.RuntimeInitTask
 * JD-Core Version:    0.7.0.1
 */