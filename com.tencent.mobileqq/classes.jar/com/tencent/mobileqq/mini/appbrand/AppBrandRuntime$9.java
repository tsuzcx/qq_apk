package com.tencent.mobileqq.mini.appbrand;

import com.tencent.mobileqq.mini.appbrand.utils.WebviewPool;

class AppBrandRuntime$9
  implements Runnable
{
  AppBrandRuntime$9(AppBrandRuntime paramAppBrandRuntime) {}
  
  public void run()
  {
    this.this$0.webviewPool.putPageWebview(this.this$0.activity, this.this$0.apkgInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.9
 * JD-Core Version:    0.7.0.1
 */