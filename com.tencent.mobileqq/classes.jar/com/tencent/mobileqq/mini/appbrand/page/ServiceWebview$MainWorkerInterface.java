package com.tencent.mobileqq.mini.appbrand.page;

import android.webkit.JavascriptInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.utils.WebviewPool;
import com.tencent.mobileqq.mini.appbrand.worker.MiniAppWorkerManager;
import com.tencent.qphone.base.util.QLog;

class ServiceWebview$MainWorkerInterface
{
  private ServiceWebview$MainWorkerInterface(ServiceWebview paramServiceWebview) {}
  
  @JavascriptInterface
  public int create(String paramString)
  {
    QLog.i("miniapp-worker", 2, "WORKER|create --> " + paramString);
    if (this.this$0.mAppBrandRuntime == null)
    {
      Object localObject = this.this$0.apkgInfo;
      if (localObject != null)
      {
        localObject = ((ApkgInfo)localObject).appConfig;
        if ((localObject != null) && (((MiniAppConfig)localObject).config != null))
        {
          AppBrandRuntimeContainer localAppBrandRuntimeContainer = AppBrandRuntimeContainer.g();
          if (localAppBrandRuntimeContainer != null)
          {
            localObject = localAppBrandRuntimeContainer.getAppBrandRunTime(((MiniAppConfig)localObject).config);
            this.this$0.mAppBrandRuntime = ((AppBrandRuntime)localObject);
          }
        }
      }
    }
    if ((this.this$0.mAppBrandRuntime != null) && (this.this$0.mAppBrandRuntime.miniAppWorkerManager != null)) {
      return this.this$0.mAppBrandRuntime.miniAppWorkerManager.handleCreateWorker(paramString, this.this$0.apkgInfo);
    }
    return 0;
  }
  
  @JavascriptInterface
  public void postMsgToAppService(String paramString)
  {
    QLog.i("miniapp-worker", 2, "WORKER|postMsgToMain --> data = " + paramString);
    if ((this.this$0.mAppBrandRuntime != null) && (this.this$0.mAppBrandRuntime.miniAppWorkerManager != null)) {
      this.this$0.mAppBrandRuntime.miniAppWorkerManager.handlePostMsgToServiceWebview(paramString);
    }
  }
  
  @JavascriptInterface
  public void postMsgToWorker(Object paramObject, String paramString)
  {
    QLog.i("miniapp-worker", 2, "WORKER|postMsgToWorker --> obj = " + paramObject + "data = " + paramString);
    if ((this.this$0.mAppBrandRuntime != null) && (this.this$0.mAppBrandRuntime.miniAppWorkerManager != null)) {
      this.this$0.mAppBrandRuntime.miniAppWorkerManager.handlePostMsgToWorker(paramObject, paramString);
    }
  }
  
  @JavascriptInterface
  public void terminate(int paramInt)
  {
    QLog.i("miniapp-worker", 2, "WORKER|stopWorker code = " + paramInt);
    if ((this.this$0.mAppBrandRuntime != null) && (this.this$0.mAppBrandRuntime.webviewPool != null)) {
      this.this$0.mAppBrandRuntime.webviewPool.stopWorker();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceWebview.MainWorkerInterface
 * JD-Core Version:    0.7.0.1
 */