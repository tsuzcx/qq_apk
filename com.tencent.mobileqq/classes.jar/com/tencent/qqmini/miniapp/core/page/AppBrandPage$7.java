package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.widget.NavigationBar;

class AppBrandPage$7
  implements Runnable
{
  AppBrandPage$7(AppBrandPage paramAppBrandPage, String paramString, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    AppBrandPage.access$100(this.this$0).setTitleText(this.val$title);
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPage.7
 * JD-Core Version:    0.7.0.1
 */