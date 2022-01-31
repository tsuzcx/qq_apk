package com.tencent.mobileqq.mini.tfs.mini;

import android.content.Context;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.JsErrorGuard;
import com.tencent.mobileqq.mini.appbrand.utils.WebviewPool;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.smtt.sdk.ValueCallback;
import java.util.Iterator;
import java.util.List;

public class ServiceInitAsyncTask
  extends AsyncTask
  implements ValueCallback
{
  public AppBrandRuntime appBrandRuntime;
  public boolean isTimeout;
  private boolean mSync = true;
  
  public ServiceInitAsyncTask(Context paramContext)
  {
    super(paramContext);
  }
  
  public void doOnServiceError()
  {
    if ((this.isTimeout) && (this.appBrandRuntime != null))
    {
      if (this.appBrandRuntime.activity == null) {
        this.appBrandRuntime.activity = AppBrandRuntimeContainer.g().getActivity();
      }
      if ((this.appBrandRuntime.activity != null) && (this.appBrandRuntime.mJsErrorGuard != null)) {
        this.appBrandRuntime.mJsErrorGuard.startShowX5Guide();
      }
    }
  }
  
  public void executeAsync()
  {
    Object localObject1 = "";
    Object localObject3 = getDependTasks();
    Object localObject2 = localObject1;
    if (localObject3 != null)
    {
      localObject3 = ((List)localObject3).iterator();
      localObject2 = localObject1;
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (BaseTask)((Iterator)localObject3).next();
        if ((localObject2 instanceof BaselibLoadAsyncTask)) {
          localObject1 = ((BaselibLoadAsyncTask)localObject2).getWaServiceJs();
        }
        for (;;)
        {
          break;
          if ((localObject2 instanceof ServiceCreateAsyncTask)) {
            this.appBrandRuntime = ((ServiceCreateAsyncTask)localObject2).appBrandRuntime;
          }
        }
      }
    }
    localObject3 = this.appBrandRuntime.webviewPool;
    if (localObject3 != null)
    {
      Context localContext = this.mContext;
      if (this.mSync) {}
      for (localObject1 = this;; localObject1 = null)
      {
        ((WebviewPool)localObject3).initServiceWebView(localContext, (String)localObject2, (ValueCallback)localObject1);
        if (!this.mSync) {
          onTaskSucceed();
        }
        return;
      }
    }
    onTaskFailed();
  }
  
  public void onReceiveValue(Object paramObject)
  {
    onTaskSucceed();
  }
  
  public void reset()
  {
    super.reset();
    this.appBrandRuntime = null;
    this.isTimeout = false;
  }
  
  public void setJsSyncMode(boolean paramBoolean)
  {
    this.mSync = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.mini.ServiceInitAsyncTask
 * JD-Core Version:    0.7.0.1
 */