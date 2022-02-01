package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;

@ClassTag(tag="RuntimeCreateTask")
public class RuntimeCreateTask
  extends AsyncTask
{
  public static final String TAG = "RuntimeCreateTask";
  
  public RuntimeCreateTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  public void executeAsync()
  {
    MiniAppReportManager2.reportLaunchPiecewise(200, "", getRuntimeLoader().getMiniAppInfoForReport());
    try
    {
      getRuntimeLoader().getRuntime().onRuntimeCreate();
      onTaskSucceed();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("RuntimeCreateTask", "onRuntimeCreate exception!", localThrowable);
      onTaskFailed();
    }
  }
  
  public BaseAppBrandRuntime getAppBrandRuntime()
  {
    return (BaseAppBrandRuntime)getRuntimeLoader().getRuntime();
  }
  
  public void onTaskSucceed()
  {
    super.onTaskSucceed();
    MiniAppReportManager2.reportLaunchPiecewise(201, "", getRuntimeLoader().getMiniAppInfoForReport());
  }
  
  public void reset()
  {
    super.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.RuntimeCreateTask
 * JD-Core Version:    0.7.0.1
 */