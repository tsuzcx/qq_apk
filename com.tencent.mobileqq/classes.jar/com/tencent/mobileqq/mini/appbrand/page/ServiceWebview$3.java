package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.OnLoadServiceWebvieJsListener;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.smtt.sdk.ValueCallback;
import java.io.File;
import java.io.IOException;

class ServiceWebview$3
  implements ValueCallback
{
  ServiceWebview$3(ServiceWebview paramServiceWebview, ApkgInfo paramApkgInfo, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener) {}
  
  public void onReceiveValue(Object paramObject)
  {
    paramObject = null;
    try
    {
      String str = FileUtils.readFileToString(new File(this.val$apkgInfo.getAppServiceJsPath()));
      paramObject = str;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
    this.this$0.evaluteJs(paramObject, new ServiceWebview.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceWebview.3
 * JD-Core Version:    0.7.0.1
 */