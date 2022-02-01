package com.tencent.mobileqq.mini.tfs.mini;

import android.content.Context;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.WebviewPool;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.MainThreadTask;
import java.util.Iterator;
import java.util.List;

public class PageInitAsyncTask
  extends MainThreadTask
{
  public AppBrandRuntime appBrandRuntime;
  
  public PageInitAsyncTask(Context paramContext)
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
        if ((localBaseTask instanceof PageCreateAsyncTask)) {
          this.appBrandRuntime = ((PageCreateAsyncTask)localBaseTask).appBrandRuntime;
        }
      }
    }
    if (this.appBrandRuntime != null)
    {
      this.appBrandRuntime.webviewPool.initFirstPageWebView(this.mContext);
      onTaskSucceed();
      return;
    }
    onTaskFailed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.mini.PageInitAsyncTask
 * JD-Core Version:    0.7.0.1
 */