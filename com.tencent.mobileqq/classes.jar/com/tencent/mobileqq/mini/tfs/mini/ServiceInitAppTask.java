package com.tencent.mobileqq.mini.tfs.mini;

import android.content.Context;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.WebviewPool;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import java.util.Iterator;
import java.util.List;

public class ServiceInitAppTask
  extends AsyncTask
{
  private ApkgInfo apkgInfo;
  public AppBrandRuntime appBrandRuntime;
  private String appServiceJs;
  private boolean started;
  
  public ServiceInitAppTask(Context paramContext)
  {
    super(paramContext);
  }
  
  public void executeAsync()
  {
    this.started = true;
    if ((this.apkgInfo != null) && (this.appServiceJs != null)) {
      startFakeApkgInfo(this.apkgInfo, this.appServiceJs);
    }
  }
  
  public void reset()
  {
    super.reset();
    this.appBrandRuntime = null;
    this.started = false;
    this.apkgInfo = null;
    this.appServiceJs = null;
  }
  
  public void startFakeApkgInfo(ApkgInfo paramApkgInfo, String paramString)
  {
    this.apkgInfo = paramApkgInfo;
    this.appServiceJs = paramString;
    if ((this.started) && (!isDone()))
    {
      Object localObject = getDependTasks();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          BaseTask localBaseTask = (BaseTask)((Iterator)localObject).next();
          if ((localBaseTask instanceof ServiceInitAsyncTask)) {
            this.appBrandRuntime = ((ServiceInitAsyncTask)localBaseTask).appBrandRuntime;
          }
        }
      }
      localObject = this.appBrandRuntime.webviewPool;
      if (localObject != null) {
        ((WebviewPool)localObject).initServiceWebViewByFakeApkgInfo(paramApkgInfo, paramString);
      }
      onTaskSucceed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.mini.ServiceInitAppTask
 * JD-Core Version:    0.7.0.1
 */