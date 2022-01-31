package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;

class VideoJsPlugin$7
  implements Runnable
{
  VideoJsPlugin$7(VideoJsPlugin paramVideoJsPlugin, AppBrandRuntime paramAppBrandRuntime) {}
  
  public void run()
  {
    AbsAppBrandPage localAbsAppBrandPage = this.val$runtime.pageContainer.getCurrentPage();
    if (localAbsAppBrandPage.hasToastView()) {
      localAbsAppBrandPage.hideToastView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VideoJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */