package com.tencent.mobileqq.mini.app;

import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3;
import com.tencent.qqmini.sdk.utils.QUAUtil;

class AppBrandTaskPreloadReceiver7$1
  implements Runnable
{
  AppBrandTaskPreloadReceiver7$1(AppBrandTaskPreloadReceiver7 paramAppBrandTaskPreloadReceiver7) {}
  
  public void run()
  {
    QUAUtil.getWebViewUA();
    AppBrandUI3.setCookie();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver7.1
 * JD-Core Version:    0.7.0.1
 */