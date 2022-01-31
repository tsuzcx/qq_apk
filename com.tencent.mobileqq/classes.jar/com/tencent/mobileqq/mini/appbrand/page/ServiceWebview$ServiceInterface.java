package com.tencent.mobileqq.mini.appbrand.page;

import android.webkit.JavascriptInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.utils.JSUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class ServiceWebview$ServiceInterface
{
  private ServiceWebview$ServiceInterface(ServiceWebview paramServiceWebview) {}
  
  @JavascriptInterface
  public String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    QLog.i("miniapp-JS", 1, "invokeHandler|service: " + paramString1 + " |id:" + paramInt);
    if (this.this$0.appBrandEventInterface != null) {
      return this.this$0.appBrandEventInterface.onServiceNativeRequest(paramString1, paramString2, paramInt);
    }
    return "";
  }
  
  @JavascriptInterface
  public void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    QLog.i("miniapp-JS", 1, "publishHandler|service: " + paramString1 + " |str3:" + paramString3);
    if ("[]".equals(paramString3))
    {
      paramString3 = AppBrandRuntimeContainer.g().getAppBrandRunTime(this.this$0.apkgInfo.appId, this.this$0.apkgInfo.appConfig.config.verType);
      if ((paramString3 != null) && (paramString3.pageContainer != null))
      {
        paramString3 = paramString3.pageContainer.pageLinkedList;
        if (paramString3 != null)
        {
          paramString3 = paramString3.iterator();
          while (paramString3.hasNext())
          {
            Object localObject = (AbsAppBrandPage)paramString3.next();
            if (localObject != null)
            {
              localObject = ((AbsAppBrandPage)localObject).getCurrentPageWebview();
              if (localObject != null) {
                ((PageWebview)localObject).evaluateSubcribeJSInService(paramString1, paramString2, ((PageWebview)localObject).getPageWebViewId());
              }
            }
          }
        }
      }
    }
    else if (this.this$0.appBrandEventInterface != null)
    {
      this.this$0.appBrandEventInterface.onServiceEvent(paramString1, paramString2, JSUtil.jsStringToJavaIntArray(paramString3));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceWebview.ServiceInterface
 * JD-Core Version:    0.7.0.1
 */