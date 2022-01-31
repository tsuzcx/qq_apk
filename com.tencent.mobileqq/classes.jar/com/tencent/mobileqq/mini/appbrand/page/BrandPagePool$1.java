package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import java.util.concurrent.ConcurrentLinkedQueue;

class BrandPagePool$1
  implements Runnable
{
  BrandPagePool$1(BrandPagePool paramBrandPagePool, AppBrandRuntime paramAppBrandRuntime) {}
  
  public void run()
  {
    AppBrandPage localAppBrandPage = this.this$0.createBrandPage(this.val$appBrandRuntime.activity, this.val$appBrandRuntime);
    this.this$0.mBrandPageList.add(localAppBrandPage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.BrandPagePool.1
 * JD-Core Version:    0.7.0.1
 */