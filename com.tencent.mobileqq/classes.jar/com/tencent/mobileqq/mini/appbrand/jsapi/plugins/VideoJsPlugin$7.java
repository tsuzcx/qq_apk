package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;

class VideoJsPlugin$7
  implements Runnable
{
  VideoJsPlugin$7(VideoJsPlugin paramVideoJsPlugin, AppBrandRuntime paramAppBrandRuntime, String paramString) {}
  
  public void run()
  {
    this.val$runtime.pageContainer.getCurrentPage().showToastView(1, "loading", null, this.val$title, -1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VideoJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */