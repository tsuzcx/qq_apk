package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.widget.TabBar;

class AppBrandPage$15
  implements Runnable
{
  AppBrandPage$15(AppBrandPage paramAppBrandPage, boolean paramBoolean, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    if (AppBrandPage.access$300(this.this$0) != null) {
      AppBrandPage.access$300(this.this$0).showTabBar(this.val$isAnim);
    }
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPage.15
 * JD-Core Version:    0.7.0.1
 */