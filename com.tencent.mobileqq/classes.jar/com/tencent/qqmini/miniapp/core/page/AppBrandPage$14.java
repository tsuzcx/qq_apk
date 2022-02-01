package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.widget.TabBar;

class AppBrandPage$14
  implements Runnable
{
  AppBrandPage$14(AppBrandPage paramAppBrandPage, boolean paramBoolean, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    if (AppBrandPage.access$300(this.this$0) != null) {
      AppBrandPage.access$300(this.this$0).hideTabBar(this.val$isAnim);
    }
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPage.14
 * JD-Core Version:    0.7.0.1
 */