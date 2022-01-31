package com.tencent.mobileqq.mini.appbrand.page;

import ajjy;
import android.view.View;
import begr;
import begw;

class ProgressWebView$3$1
  implements begw
{
  ProgressWebView$3$1(ProgressWebView.3 param3, begr parambegr, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.val$actionSheet.dismiss();
    paramView = this.val$actionSheet.a(paramInt);
    if (ajjy.a(2131642722).equals(paramView)) {
      ProgressWebView.access$600(this.this$1.this$0, this.val$pic);
    }
    while (!ajjy.a(2131642716).equals(paramView)) {
      return;
    }
    ProgressWebView.access$700(this.this$1.this$0, this.val$pic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.3.1
 * JD-Core Version:    0.7.0.1
 */