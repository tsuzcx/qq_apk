package com.tencent.qqmini.sdk.runtime.core.page;

import android.app.Activity;
import android.text.TextUtils;
import behq;
import bekj;
import bfgh;
import bfgp;
import com.tencent.qqmini.sdk.core.widget.NavigationBar;

class AppBrandPage$13
  implements Runnable
{
  AppBrandPage$13(AppBrandPage paramAppBrandPage, String paramString1, String paramString2, String paramString3, long paramLong, bekj parambekj) {}
  
  public void run()
  {
    boolean bool2 = "#000000".equals(this.jdField_a_of_type_JavaLangString);
    NavigationBar localNavigationBar = AppBrandPage.a(this.this$0);
    String str;
    if (bool2)
    {
      str = "black";
      localNavigationBar.b(str);
      boolean bool1 = false;
      if (AppBrandPage.a(this.this$0).a() != null) {
        bool1 = bfgp.a(bool2, AppBrandPage.a(this.this$0).a().getWindow());
      }
      AppBrandPage.a(this.this$0).setUseCustomStatusBarStyle(bool1);
      if (TextUtils.isEmpty(this.b)) {
        break label132;
      }
      AppBrandPage.a(this.this$0).a(bfgh.a(this.c), this.jdField_a_of_type_Long, this.b);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bekj.a();
      return;
      str = "white";
      break;
      label132:
      AppBrandPage.a(this.this$0).a(bfgh.a(this.c));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage.13
 * JD-Core Version:    0.7.0.1
 */