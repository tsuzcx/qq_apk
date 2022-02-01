package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.core.service.AbsAppBrandService;
import com.tencent.qqmini.miniapp.core.service.AppBrandRemoteService;
import com.tencent.qqmini.miniapp.core.service.AppBrandService;
import com.tencent.qqmini.miniapp.core.service.AppBrandWebviewService;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.DebugInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;
import com.tencent.smtt.sdk.JsVirtualMachine;
import com.tencent.smtt.sdk.QbSdk;

@ClassTag(tag="ServiceCreateTask")
public class ServiceCreateTask
  extends AsyncTask
{
  public static final String TAG = "ServiceCreateTask";
  BaseRuntime appBrandRuntime;
  private AbsAppBrandService customJsService;
  private long endTimestamp = 0L;
  JsVirtualMachine jsVirtualMachine;
  private long startTimestamp = 0L;
  
  public ServiceCreateTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  private static boolean canDebug(BaseRuntime paramBaseRuntime)
  {
    if (paramBaseRuntime == null) {}
    do
    {
      return false;
      paramBaseRuntime = paramBaseRuntime.getMiniAppInfo();
    } while ((paramBaseRuntime == null) || (paramBaseRuntime.debugInfo == null) || (TextUtils.isEmpty(paramBaseRuntime.debugInfo.wsUrl)) || (TextUtils.isEmpty(paramBaseRuntime.debugInfo.roomId)));
    return true;
  }
  
  private void createWebviewService()
  {
    try
    {
      QMLog.i("ServiceCreateTask", "AppBrandWebviewService create start");
      onServiceCreateSucc(new AppBrandWebviewService(this.appBrandRuntime, null));
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("ServiceCreateTask", "AppBrandWebviewService execute exception!", localThrowable);
      onTaskFailed();
    }
  }
  
  public void executeAsync()
  {
    QMLog.i("ServiceCreateTask", "AppBrandRemoteService ServiceCreateTask executeAsync");
    if (this.appBrandRuntime != null)
    {
      localObject = this.appBrandRuntime.getMiniAppInfo();
      MiniReportManager.reportEventType((MiniAppInfo)localObject, 100, "0");
      this.startTimestamp = System.currentTimeMillis();
      localObject = (RuntimeCreateTask)getRuntimeLoader().getTask(RuntimeCreateTask.class);
      if (localObject == null) {
        break label119;
      }
    }
    int i;
    int j;
    label119:
    for (Object localObject = ((RuntimeCreateTask)localObject).getAppBrandRuntime();; localObject = null)
    {
      this.appBrandRuntime = ((BaseRuntime)localObject);
      i = QbSdk.getTbsVersion(getContext());
      j = QbSdk.getTmpDirTbsVersion(getContext());
      if (!canDebug(this.appBrandRuntime)) {
        break label124;
      }
      QMLog.i("ServiceCreateTask", "AppBrandRemoteService AppBrandRemoteService create start");
      onServiceCreateSucc(new AppBrandRemoteService(this.appBrandRuntime, null));
      return;
      localObject = null;
      break;
    }
    label124:
    if (((i > 0) || (j > 0)) && (!isTbsFallback(getContext()))) {
      try
      {
        QMLog.i("ServiceCreateTask", "AppBrandRemoteService AppBrandService create start");
        localObject = new AppBrandService(this.appBrandRuntime, null);
        ((AppBrandService)localObject).initFramework(getContext(), new ServiceCreateTask.1(this, (AppBrandService)localObject));
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("ServiceCreateTask", "ServiceCreateTask JsCore execute exception!", localThrowable);
        return;
      }
    }
    QMLog.i("ServiceCreateTask", "AppBrandRemoteService createWebviewService create start");
    new Handler(Looper.getMainLooper()).post(new ServiceCreateTask.2(this));
  }
  
  public long getCreateTime()
  {
    return this.endTimestamp - this.startTimestamp;
  }
  
  public AbsAppBrandService getJsService()
  {
    return this.customJsService;
  }
  
  public boolean isTbsFallback(Context paramContext)
  {
    if (this.jsVirtualMachine == null) {
      this.jsVirtualMachine = new JsVirtualMachine(paramContext);
    }
    return this.jsVirtualMachine.isFallback();
  }
  
  protected void onServiceCreateSucc(AbsAppBrandService paramAbsAppBrandService)
  {
    try
    {
      QMLog.i("ServiceCreateTask", "onServiceCreateSucc service:" + paramAbsAppBrandService);
      if ((this.customJsService == null) && (paramAbsAppBrandService != null))
      {
        this.customJsService = paramAbsAppBrandService;
        this.endTimestamp = System.currentTimeMillis();
        onTaskSucceed();
      }
      return;
    }
    finally {}
  }
  
  public void onTaskSucceed()
  {
    super.onTaskSucceed();
    if (this.appBrandRuntime != null) {}
    for (MiniAppInfo localMiniAppInfo = this.appBrandRuntime.getMiniAppInfo();; localMiniAppInfo = null)
    {
      MiniReportManager.reportEventType(localMiniAppInfo, 101, "0");
      return;
    }
  }
  
  public void reset()
  {
    super.reset();
    this.customJsService = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.ServiceCreateTask
 * JD-Core Version:    0.7.0.1
 */