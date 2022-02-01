package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import android.util.Log;
import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.miniapp.core.service.AbsAppBrandService;
import com.tencent.qqmini.miniapp.core.service.AppBrandService;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MtaReportSt;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;
import java.util.Properties;

@ClassTag(tag="ServiceInitTask")
public class ServiceInitTask
  extends AsyncTask
{
  public static final String TAG = "ServiceInitTask";
  protected BaseAppBrandRuntime appBrandRuntime;
  protected AbsAppBrandService customJsService;
  
  public ServiceInitTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  public void executeAsync()
  {
    Object localObject = this.appBrandRuntime;
    BaseAppBrandRuntime localBaseAppBrandRuntime = null;
    if (localObject != null) {
      localObject = ((BaseAppBrandRuntime)localObject).getMiniAppInfo();
    } else {
      localObject = null;
    }
    MiniReportManager.reportEventType((MiniAppInfo)localObject, 14, "0");
    localObject = (RuntimeCreateTask)getRuntimeLoader().getTask(RuntimeCreateTask.class);
    if (localObject != null) {
      localObject = ((RuntimeCreateTask)localObject).getAppBrandRuntime();
    } else {
      localObject = null;
    }
    this.appBrandRuntime = ((BaseAppBrandRuntime)localObject);
    ServiceCreateTask localServiceCreateTask = (ServiceCreateTask)getRuntimeLoader().getTask(ServiceCreateTask.class);
    BaselibLoader.BaselibContent localBaselibContent = ((BaselibLoadAsyncTask)getRuntimeLoader().getTask(BaselibLoadAsyncTask.class)).getBaselibContent();
    localObject = localBaseAppBrandRuntime;
    if (localServiceCreateTask != null) {
      localObject = localServiceCreateTask.getJsService();
    }
    long l;
    if (localServiceCreateTask != null) {
      l = localServiceCreateTask.getCreateTime();
    } else {
      l = 0L;
    }
    if (localObject != null)
    {
      localBaseAppBrandRuntime = this.appBrandRuntime;
      if (localBaseAppBrandRuntime != null) {
        ((AbsAppBrandService)localObject).setAppBrandEventInterface(localBaseAppBrandRuntime.getEventListener());
      }
      ((AbsAppBrandService)localObject).addStateChangeListener(new ServiceInitTask.1(this, (AbsAppBrandService)localObject, l));
      ((AbsAppBrandService)localObject).initBaseJs(localBaselibContent);
      return;
    }
    onTaskFailed();
  }
  
  public AbsAppBrandService getJsService()
  {
    return this.customJsService;
  }
  
  protected void onServiceInitSucc(AbsAppBrandService paramAbsAppBrandService, long paramLong1, long paramLong2)
  {
    try
    {
      if ((this.customJsService == null) && (paramAbsAppBrandService != null))
      {
        this.customJsService = paramAbsAppBrandService;
        onTaskSucceed();
        Properties localProperties = new Properties();
        if ((paramAbsAppBrandService instanceof AppBrandService)) {
          localProperties.put("service_type", "x5");
        } else {
          localProperties.put("service_type", "unexpected");
        }
        localProperties.put("service_init_timecost", Long.valueOf(paramLong1));
        localProperties.put("service_exec_timecost", Long.valueOf(paramLong2));
        localProperties.put("reserved", "1");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAbsAppBrandService);
        localStringBuilder.append(",serviceInit:");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append(",serviceExec:");
        localStringBuilder.append(paramLong2);
        Log.d("ServiceInitTask", localStringBuilder.toString());
        this.appBrandRuntime.performAction(AppStateEvent.obtain(50, new MtaReportSt("miniapp_service_init", localProperties)));
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
      localObject = ((BaseAppBrandRuntime)localObject).getMiniAppInfo();
    } else {
      localObject = null;
    }
    MiniReportManager.reportEventType((MiniAppInfo)localObject, 15, "0");
  }
  
  public void reset()
  {
    super.reset();
    this.customJsService = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.ServiceInitTask
 * JD-Core Version:    0.7.0.1
 */