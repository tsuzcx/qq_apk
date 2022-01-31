package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;

class VideoJsPlugin$9
  implements Runnable
{
  VideoJsPlugin$9(VideoJsPlugin paramVideoJsPlugin, AppBrandRuntime paramAppBrandRuntime) {}
  
  public void run()
  {
    AbsAppBrandPage localAbsAppBrandPage = this.val$runtime.pageContainer.getCurrentPage();
    if (localAbsAppBrandPage.hasToastView()) {
      localAbsAppBrandPage.hideToastView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VideoJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */