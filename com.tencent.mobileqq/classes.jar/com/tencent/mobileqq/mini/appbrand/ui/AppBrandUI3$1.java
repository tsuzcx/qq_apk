package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.qqmini.sdk.utils.QUAUtil;

class AppBrandUI3$1
  implements Runnable
{
  AppBrandUI3$1(AppBrandUI3 paramAppBrandUI3) {}
  
  public void run()
  {
    QUAUtil.getWebViewUA();
    AppBrandUI3.setCookie();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3.1
 * JD-Core Version:    0.7.0.1
 */