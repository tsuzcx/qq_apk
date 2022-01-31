package com.tencent.qqmini.sdk.runtime.core.page;

import android.app.Activity;
import android.text.TextUtils;
import bgho;
import bgid;
import com.tencent.qqmini.sdk.core.widget.NavigationBar;
import com.tencent.qqmini.sdk.utils.ColorUtils;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;

class AppBrandPage$13
  implements Runnable
{
  AppBrandPage$13(AppBrandPage paramAppBrandPage, String paramString1, String paramString2, String paramString3, long paramLong, bgid parambgid) {}
  
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
        bool1 = ImmersiveUtils.setStatusTextColor(bool2, AppBrandPage.a(this.this$0).a().getWindow());
      }
      AppBrandPage.a(this.this$0).setUseCustomStatusBarStyle(bool1);
      if (TextUtils.isEmpty(this.b)) {
        break label132;
      }
      AppBrandPage.a(this.this$0).a(ColorUtils.parseColor(this.c), this.jdField_a_of_type_Long, this.b);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bgid.a();
      return;
      str = "white";
      break;
      label132:
      AppBrandPage.a(this.this$0).a(ColorUtils.parseColor(this.c));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage.13
 * JD-Core Version:    0.7.0.1
 */