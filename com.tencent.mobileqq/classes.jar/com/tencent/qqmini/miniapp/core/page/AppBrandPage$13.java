package com.tencent.qqmini.miniapp.core.page;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.widget.TabBar;

class AppBrandPage$13
  implements Runnable
{
  AppBrandPage$13(AppBrandPage paramAppBrandPage, int paramInt, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2) {}
  
  public void run()
  {
    if (AppBrandPage.access$300(this.this$0) != null) {
      AppBrandPage.access$300(this.this$0).setTabBarItem(this.val$index, this.val$text, this.val$iconBitmap, this.val$selectedIconBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPage.13
 * JD-Core Version:    0.7.0.1
 */