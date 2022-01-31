package com.tencent.mobileqq.mini.tfs.mini;

import android.content.Context;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.utils.WebviewPool;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.MainThreadTask;
import java.util.Iterator;
import java.util.List;

public class PageCreateAsyncTask
  extends MainThreadTask
{
  public AppBrandRuntime appBrandRuntime;
  
  public PageCreateAsyncTask(Context paramContext)
  {
    super(paramContext);
  }
  
  public void executeInMainThread()
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
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 102, "0");
      ((WebviewPool)localObject).initFistWebview(this.mContext);
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 103, "0");
      onTaskSucceed();
      return;
    }
    onTaskFailed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.mini.PageCreateAsyncTask
 * JD-Core Version:    0.7.0.1
 */