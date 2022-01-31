package com.tencent.mobileqq.mini.appbrand.page;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.OnLoadServiceWebvieJsListener;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.smtt.sdk.ValueCallback;
import java.io.File;
import java.io.IOException;

class ServiceWebview$3
  implements ValueCallback
{
  ServiceWebview$3(ServiceWebview paramServiceWebview, String paramString, ApkgInfo paramApkgInfo, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener) {}
  
  public void onReceiveValue(Object paramObject)
  {
    String str = this.val$appServiceStr;
    paramObject = str;
    try
    {
      if (TextUtils.isEmpty(str)) {
        paramObject = FileUtils.readFileToString(new File(this.val$apkgInfo.getAppServiceJsPath()));
      }
      this.this$0.evaluteJs(paramObject, new ServiceWebview.3.1(this));
      return;
    }
    catch (IOException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
        paramObject = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceWebview.3
 * JD-Core Version:    0.7.0.1
 */