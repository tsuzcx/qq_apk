package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.miniapp.core.page.pool.AppBrandPagePool;

class BrandPageWebview$4
  implements Runnable
{
  BrandPageWebview$4(BrandPageWebview paramBrandPageWebview) {}
  
  public void run()
  {
    BrandPageWebview.access$700(this.this$0).getAppBrandPagePool().preLoadAppBrandPage(BrandPageWebview.access$300(this.this$0), BrandPageWebview.access$700(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.BrandPageWebview.4
 * JD-Core Version:    0.7.0.1
 */