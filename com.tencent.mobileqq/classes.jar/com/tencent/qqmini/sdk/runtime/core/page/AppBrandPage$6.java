package com.tencent.qqmini.sdk.runtime.core.page;

import com.tencent.qqmini.sdk.core.widget.TabBar;

class AppBrandPage$6
  implements Runnable
{
  AppBrandPage$6(AppBrandPage paramAppBrandPage, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    if (AppBrandPage.a(this.this$0) != null)
    {
      if (!this.jdField_a_of_type_JavaLangString.equals("text")) {
        break label41;
      }
      AppBrandPage.a(this.this$0).setTabBarBadge(this.jdField_a_of_type_Int, this.b);
    }
    label41:
    do
    {
      return;
      if (this.jdField_a_of_type_JavaLangString.equals("redDot"))
      {
        AppBrandPage.a(this.this$0).a(this.jdField_a_of_type_Int);
        return;
      }
    } while (!this.jdField_a_of_type_JavaLangString.equals("none"));
    AppBrandPage.a(this.this$0).c(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage.6
 * JD-Core Version:    0.7.0.1
 */