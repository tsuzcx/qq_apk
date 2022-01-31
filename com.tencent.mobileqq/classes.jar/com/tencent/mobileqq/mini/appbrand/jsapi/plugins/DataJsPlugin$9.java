package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime.ShareScreenshotCallback;
import com.tencent.mobileqq.mini.appbrand.utils.ShareUtils;
import com.tencent.qphone.base.util.QLog;

class DataJsPlugin$9
  implements BaseAppBrandRuntime.ShareScreenshotCallback
{
  DataJsPlugin$9(DataJsPlugin paramDataJsPlugin, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void onGetShareScreenshot(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ShareUtils.startShareToQzone(this.this$0.jsPluginEngine.getActivityContext(), this.val$title, paramString, this.val$finalPath, this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo(), this.val$finalFromInnerButton);
      QLog.e("[mini] DataJsPlugin", 1, "getShareScreenshot for QzoneShare failed, savedScreenshotPath = null");
      return;
    }
    ShareUtils.startShareToQzone(this.this$0.jsPluginEngine.getActivityContext(), this.val$title, paramString, this.val$finalPath, this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo(), this.val$finalFromInnerButton);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */