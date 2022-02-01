package com.tencent.mobileqq.mini.appbrand.page;

import android.view.View;
import anni;
import bkho;
import bkhw;

class ProgressWebView$3$1
  implements bkhw
{
  ProgressWebView$3$1(ProgressWebView.3 param3, bkho parambkho, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.val$actionSheet.dismiss();
    paramView = this.val$actionSheet.a(paramInt);
    if (anni.a(2131707278).equals(paramView)) {
      ProgressWebView.access$600(this.this$1.this$0, this.val$pic);
    }
    while (!anni.a(2131707272).equals(paramView)) {
      return;
    }
    ProgressWebView.access$700(this.this$1.this$0, this.val$pic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.3.1
 * JD-Core Version:    0.7.0.1
 */