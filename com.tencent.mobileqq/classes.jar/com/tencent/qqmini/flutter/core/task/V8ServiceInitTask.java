package com.tencent.qqmini.flutter.core.task;

import android.content.Context;
import android.util.Log;
import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.miniapp.core.service.AbsAppBrandService;
import com.tencent.qqmini.miniapp.core.service.AppBrandService;
import com.tencent.qqmini.miniapp.core.service.AppV8JsService;
import com.tencent.qqmini.miniapp.task.BaselibLoadAsyncTask;
import com.tencent.qqmini.miniapp.task.ServiceInitTask;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MtaReportSt;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import java.util.Properties;

@ClassTag(tag="V8ServiceInitTask")
public class V8ServiceInitTask
  extends ServiceInitTask
{
  public V8ServiceInitTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  public void executeAsync()
  {
    MiniAppReportManager2.reportLaunchPiecewise(208, "", getRuntimeLoader().getMiniAppInfoForReport());
    for (;;)
    {
      try
      {
        this.appBrandRuntime = ((BaseAppBrandRuntime)getRuntimeLoader().getRuntime());
        BaselibLoader.BaselibContent localBaselibContent = ((BaselibLoadAsyncTask)getRuntimeLoader().getTask(BaselibLoadAsyncTask.class)).getBaselibContent();
        long l1 = System.currentTimeMillis();
        Object localObject1 = this.appBrandRuntime;
        Object localObject3 = null;
        if (localObject1 != null)
        {
          localObject1 = this.appBrandRuntime.getMiniAppInfo();
          MiniReportManager.reportEventType((MiniAppInfo)localObject1, 100, "0");
          AppV8JsService localAppV8JsService = new AppV8JsService(this.appBrandRuntime, true);
          localObject1 = localObject3;
          if (this.appBrandRuntime != null) {
            localObject1 = this.appBrandRuntime.getMiniAppInfo();
          }
          MiniReportManager.reportEventType((MiniAppInfo)localObject1, 101, "0");
          long l2 = System.currentTimeMillis();
          if (this.appBrandRuntime != null) {
            localAppV8JsService.setAppBrandEventInterface(this.appBrandRuntime.getEventListener());
          }
          localAppV8JsService.addStateChangeListener(new V8ServiceInitTask.1(this, localAppV8JsService, l2 - l1));
          localAppV8JsService.initBaseJs(localBaselibContent);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-start", "ServiceInitTask execute exception!", localThrowable);
        return;
      }
      Object localObject2 = null;
    }
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
        if ((paramAbsAppBrandService instanceof AppV8JsService)) {
          localProperties.put("service_type", "v8");
        } else if ((paramAbsAppBrandService instanceof AppBrandService)) {
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
    MiniAppReportManager2.reportLaunchPiecewise(209, "", getRuntimeLoader().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.task.V8ServiceInitTask
 * JD-Core Version:    0.7.0.1
 */