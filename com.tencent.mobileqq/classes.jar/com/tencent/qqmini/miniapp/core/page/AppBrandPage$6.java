package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.widget.NavigationBar;

class AppBrandPage$6
  implements Runnable
{
  AppBrandPage$6(AppBrandPage paramAppBrandPage, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    if (AppBrandPage.access$100(this.this$0) != null)
    {
      AppBrandPage.access$100(this.this$0).showLoading();
      this.val$req.ok();
      return;
    }
    this.val$req.fail("native view error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPage.6
 * JD-Core Version:    0.7.0.1
 */