package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmini.miniapp.core.service.AbsAppBrandService;
import com.tencent.qqmini.miniapp.core.service.AppBrandRemoteService;
import com.tencent.qqmini.miniapp.core.service.AppBrandService;
import com.tencent.qqmini.miniapp.core.service.AppBrandWebviewService;
import com.tencent.qqmini.miniapp.core.service.AppV8JsService;
import com.tencent.qqmini.miniapp.util.V8Utils;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.DebugInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;
import com.tencent.smtt.sdk.JsVirtualMachine;
import com.tencent.smtt.sdk.QbSdk;

@ClassTag(tag="ServiceCreateTask")
public class ServiceCreateTask
  extends AsyncTask
{
  public static final String SERVICE_TYPE_V8 = "v8";
  public static final String SERVICE_TYPE_WEBVIEW = "webview";
  public static final String SERVICE_TYPE_X5 = "x5";
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
    if (paramBaseRuntime == null) {
      return false;
    }
    paramBaseRuntime = paramBaseRuntime.getMiniAppInfo();
    if (paramBaseRuntime == null) {
      return false;
    }
    if ((paramBaseRuntime.debugInfo != null) && (!TextUtils.isEmpty(paramBaseRuntime.debugInfo.wsUrl))) {
      return !TextUtils.isEmpty(paramBaseRuntime.debugInfo.roomId);
    }
    return false;
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
  
  private boolean onV8ServiceCreateTaskSuc()
  {
    try
    {
      QMLog.i("ServiceCreateTask", "AppV8JsService create start");
      onServiceCreateSucc(new AppV8JsService(this.appBrandRuntime));
      reportServiceType(650, "v8");
      return true;
    }
    catch (Exception localException)
    {
      QMLog.i("ServiceCreateTask", "run service by v8 failed", localException);
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 151, "0", "", "", "", Log.getStackTraceString(localException));
    }
    return false;
  }
  
  private void reportServiceType(int paramInt, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new ServiceCreateTask.3(this, paramInt, paramString));
  }
  
  private void tbsServiceCreate()
  {
    int i = QbSdk.getTbsVersion(getContext());
    int j = QbSdk.getTmpDirTbsVersion(getContext());
    boolean bool = isTbsFallback(getContext());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tbsVersion=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" tmpDirTbsVersion=");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(",isTbsFallback:");
    ((StringBuilder)localObject).append(Boolean.valueOf(bool));
    QMLog.i("ServiceCreateTask", ((StringBuilder)localObject).toString());
    if (((i > 0) || (j > 0)) && (!isTbsFallback(getContext()))) {
      try
      {
        QMLog.i("ServiceCreateTask", "AppBrandService create start");
        localObject = new AppBrandService(this.appBrandRuntime, null);
        ((AppBrandService)localObject).initFramework(getContext(), new ServiceCreateTask.1(this, (AppBrandService)localObject));
        reportServiceType(650, "x5");
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("ServiceCreateTask", "ServiceCreateTask JsCore execute exception!", localThrowable);
        return;
      }
    }
    QMLog.i("ServiceCreateTask", "createWebviewService create start");
    new Handler(Looper.getMainLooper()).post(new ServiceCreateTask.2(this));
  }
  
  public void executeAsync()
  {
    QMLog.i("ServiceCreateTask", "ServiceCreateTask executeAsync");
    Object localObject = this.appBrandRuntime;
    if (localObject != null) {
      localObject = ((BaseRuntime)localObject).getMiniAppInfo();
    } else {
      localObject = null;
    }
    MiniReportManager.reportEventType((MiniAppInfo)localObject, 100, "0");
    this.startTimestamp = System.currentTimeMillis();
    localObject = (RuntimeCreateTask)getRuntimeLoader().getTask(RuntimeCreateTask.class);
    if (localObject != null) {
      localObject = ((RuntimeCreateTask)localObject).getAppBrandRuntime();
    } else {
      localObject = null;
    }
    this.appBrandRuntime = ((BaseRuntime)localObject);
    boolean bool = V8Utils.checkEnableV8();
    if (canDebug(this.appBrandRuntime))
    {
      QMLog.i("ServiceCreateTask", "AppBrandRemoteService create start");
      onServiceCreateSucc(new AppBrandRemoteService(this.appBrandRuntime, null));
      return;
    }
    if ((bool) && (onV8ServiceCreateTaskSuc())) {
      return;
    }
    tbsServiceCreate();
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onServiceCreateSucc service:");
      localStringBuilder.append(paramAbsAppBrandService);
      QMLog.i("ServiceCreateTask", localStringBuilder.toString());
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
    Object localObject = this.appBrandRuntime;
    if (localObject != null) {
      localObject = ((BaseRuntime)localObject).getMiniAppInfo();
    } else {
      localObject = null;
    }
    MiniReportManager.reportEventType((MiniAppInfo)localObject, 101, "0");
  }
  
  public void reset()
  {
    super.reset();
    this.customJsService = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.ServiceCreateTask
 * JD-Core Version:    0.7.0.1
 */