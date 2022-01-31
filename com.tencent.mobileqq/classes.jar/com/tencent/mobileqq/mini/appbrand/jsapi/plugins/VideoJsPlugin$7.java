package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.qphone.base.util.QLog;

class VideoJsPlugin$7
  implements Runnable
{
  VideoJsPlugin$7(VideoJsPlugin paramVideoJsPlugin, AppBrandRuntime paramAppBrandRuntime, String paramString) {}
  
  public void run()
  {
    if ((this.val$runtime != null) && (this.val$runtime.pageContainer != null))
    {
      AbsAppBrandPage localAbsAppBrandPage = this.val$runtime.pageContainer.getCurrentPage();
      if (localAbsAppBrandPage != null) {
        localAbsAppBrandPage.showToastView(1, "loading", null, this.val$title, -1, false);
      }
    }
    else
    {
      return;
    }
    QLog.e("VideoJsPlugin", 1, "showLoading, page is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VideoJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */