package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.miniapp.core.page.pool.AppBrandPagePool;

class BrandPageWebview$4
  implements Runnable
{
  BrandPageWebview$4(BrandPageWebview paramBrandPageWebview) {}
  
  public void run()
  {
    BrandPageWebview.access$600(this.this$0).getAppBrandPagePool().preLoadAppBrandPage(BrandPageWebview.access$500(this.this$0), BrandPageWebview.access$600(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.BrandPageWebview.4
 * JD-Core Version:    0.7.0.1
 */