package com.tencent.qqmini.flutter.core.task;

import android.content.Context;
import android.util.Log;
import com.tencent.qqmini.flutter.core.service.AppV8JsService;
import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.miniapp.core.service.AbsAppBrandService;
import com.tencent.qqmini.miniapp.core.service.AppBrandService;
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
    try
    {
      this.appBrandRuntime = ((BaseAppBrandRuntime)getRuntimeLoader().getRuntime());
      BaselibLoader.BaselibContent localBaselibContent = ((BaselibLoadAsyncTask)getRuntimeLoader().getTask(BaselibLoadAsyncTask.class)).getBaselibContent();
      long l1 = System.currentTimeMillis();
      AppV8JsService localAppV8JsService;
      if (this.appBrandRuntime != null)
      {
        localMiniAppInfo = this.appBrandRuntime.getMiniAppInfo();
        MiniReportManager.reportEventType(localMiniAppInfo, 100, "0");
        localAppV8JsService = new AppV8JsService(this.appBrandRuntime);
        if (this.appBrandRuntime == null) {
          break label168;
        }
      }
      label168:
      for (MiniAppInfo localMiniAppInfo = this.appBrandRuntime.getMiniAppInfo();; localMiniAppInfo = null)
      {
        MiniReportManager.reportEventType(localMiniAppInfo, 101, "0");
        long l2 = System.currentTimeMillis();
        if (this.appBrandRuntime != null) {
          localAppV8JsService.setAppBrandEventInterface(this.appBrandRuntime.getEventListener());
        }
        localAppV8JsService.addStateChangeListener(new V8ServiceInitTask.1(this, localAppV8JsService, l2 - l1));
        localAppV8JsService.initBaseJs(localBaselibContent);
        return;
        localMiniAppInfo = null;
        break;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start", "ServiceInitTask execute exception!", localThrowable);
    }
  }
  
  public void onServiceInitSucc(AbsAppBrandService paramAbsAppBrandService, long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        Properties localProperties;
        if ((this.customJsService == null) && (paramAbsAppBrandService != null))
        {
          this.customJsService = paramAbsAppBrandService;
          onTaskSucceed();
          localProperties = new Properties();
          if ((paramAbsAppBrandService instanceof AppV8JsService))
          {
            localProperties.put("service_type", "v8");
            localProperties.put("service_init_timecost", Long.valueOf(paramLong1));
            localProperties.put("service_exec_timecost", Long.valueOf(paramLong2));
            localProperties.put("reserved", "1");
            Log.d("ServiceInitTask", paramAbsAppBrandService + ",serviceInit:" + paramLong1 + ",serviceExec:" + paramLong2);
            this.appBrandRuntime.performAction(AppStateEvent.obtain(50, new MtaReportSt("miniapp_service_init", localProperties)));
          }
        }
        else
        {
          return;
        }
        if ((paramAbsAppBrandService instanceof AppBrandService)) {
          localProperties.put("service_type", "x5");
        } else {
          localProperties.put("service_type", "unexpected");
        }
      }
      finally {}
    }
  }
  
  public void onTaskSucceed()
  {
    super.onTaskSucceed();
    MiniAppReportManager2.reportLaunchPiecewise(209, "", getRuntimeLoader().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.task.V8ServiceInitTask
 * JD-Core Version:    0.7.0.1
 */