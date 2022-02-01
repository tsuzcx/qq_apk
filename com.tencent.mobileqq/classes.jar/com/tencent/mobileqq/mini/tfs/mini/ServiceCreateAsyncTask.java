package com.tencent.mobileqq.mini.tfs.mini;

import android.content.Context;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.page.ServiceWebview.Callback;
import com.tencent.mobileqq.mini.appbrand.utils.WebviewPool;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import java.util.Iterator;
import java.util.List;

public class ServiceCreateAsyncTask
  extends AsyncTask
  implements ServiceWebview.Callback
{
  AppBrandRuntime appBrandRuntime = null;
  private MiniAppConfig miniAppConfig;
  
  public ServiceCreateAsyncTask(Context paramContext)
  {
    super(paramContext);
  }
  
  public void executeAsync()
  {
    Object localObject = getDependTasks();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BaseTask localBaseTask = (BaseTask)((Iterator)localObject).next();
        if ((localBaseTask instanceof MiniTask.RuntimeCreateTask)) {
          this.appBrandRuntime = ((MiniTask.RuntimeCreateTask)localBaseTask).getRuntimeContainer().getEmptyAppRuntime();
        }
      }
    }
    if (this.appBrandRuntime != null)
    {
      localObject = this.appBrandRuntime.webviewPool;
      if ((this.miniAppConfig != null) && (this.miniAppConfig.config != null) && (this.miniAppConfig.config.debugInfo != null))
      {
        MiniReportManager.reportEventType(this.miniAppConfig, 100, "0");
        ((WebviewPool)localObject).initServiceWebViewEx(this.mContext, this.miniAppConfig, this);
        return;
      }
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 100, "0");
      ((WebviewPool)localObject).initServiceWebViewEx(this.mContext, null, this);
      return;
    }
    onTaskFailed();
  }
  
  public void onJscoreInited()
  {
    if ((this.miniAppConfig != null) && (this.miniAppConfig.config != null) && (this.miniAppConfig.config.debugInfo != null)) {
      MiniReportManager.reportEventType(this.miniAppConfig, 101, "0");
    }
    for (;;)
    {
      onTaskSucceed();
      return;
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 101, "0");
    }
  }
  
  public void reset()
  {
    super.reset();
    this.miniAppConfig = null;
  }
  
  public void setMiniAppConfig(MiniAppConfig paramMiniAppConfig)
  {
    this.miniAppConfig = paramMiniAppConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.mini.ServiceCreateAsyncTask
 * JD-Core Version:    0.7.0.1
 */