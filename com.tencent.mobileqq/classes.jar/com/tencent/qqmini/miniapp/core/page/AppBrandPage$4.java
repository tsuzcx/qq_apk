package com.tencent.qqmini.miniapp.core.page;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.NavigationBar;

class AppBrandPage$4
  implements Runnable
{
  AppBrandPage$4(AppBrandPage paramAppBrandPage, String paramString1, String paramString2, String paramString3, long paramLong, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    boolean bool2 = "#000000".equals(this.val$frontColor);
    NavigationBar localNavigationBar = AppBrandPage.access$100(this.this$0);
    String str;
    if (bool2) {
      str = "black";
    } else {
      str = "white";
    }
    localNavigationBar.setTextStyle(str);
    boolean bool1 = false;
    if (AppBrandPage.access$200(this.this$0).getAttachedActivity() != null) {
      bool1 = ImmersiveUtils.setStatusTextColor(bool2, AppBrandPage.access$200(this.this$0).getAttachedActivity().getWindow());
    }
    AppBrandPage.access$100(this.this$0).setUseCustomStatusBarStyle(bool1);
    if (!TextUtils.isEmpty(this.val$interpolator)) {
      AppBrandPage.access$100(this.this$0).setNavBackgroundColor(ColorUtils.parseColor(this.val$backgroundColor), this.val$delay, this.val$interpolator);
    } else {
      AppBrandPage.access$100(this.this$0).setNavBackgroundColor(ColorUtils.parseColor(this.val$backgroundColor));
    }
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPage.4
 * JD-Core Version:    0.7.0.1
 */