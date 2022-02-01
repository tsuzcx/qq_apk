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
    Object localObject5 = null;
    Object localObject1 = "";
    Object localObject2 = getDependTasks();
    Object localObject4;
    Object localObject3;
    if (localObject2 != null)
    {
      Iterator localIterator = ((List)localObject2).iterator();
      localObject2 = null;
      localObject4 = localObject2;
      localObject3 = localObject1;
      if (!localIterator.hasNext()) {
        break label106;
      }
      localObject3 = (BaseTask)localIterator.next();
      if ((localObject3 instanceof BaselibLoadAsyncTask))
      {
        localObject3 = ((BaselibLoadAsyncTask)localObject3).getWaServiceJs();
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      if ((localObject3 instanceof ServiceCreateAsyncTask))
      {
        localObject3 = ((ServiceCreateAsyncTask)localObject3).appBrandRuntime;
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        localObject4 = null;
        localObject3 = localObject1;
        label106:
        this.appBrandRuntime = ((AppBrandRuntime)localObject4);
        if ((localObject4 != null) && (((AppBrandRuntime)localObject4).webviewPool != null))
        {
          localObject2 = ((AppBrandRuntime)localObject4).webviewPool;
          localObject4 = this.mContext;
          localObject1 = localObject5;
          if (this.mSync) {
            localObject1 = this;
          }
          ((WebviewPool)localObject2).initServiceWebView((Context)localObject4, (String)localObject3, (ValueCallback)localObject1);
          if (!this.mSync) {
            onTaskSucceed();
          }
          return;
        }
        onTaskFailed();
      }
      else
      {
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.mini.ServiceInitAsyncTask
 * JD-Core Version:    0.7.0.1
 */