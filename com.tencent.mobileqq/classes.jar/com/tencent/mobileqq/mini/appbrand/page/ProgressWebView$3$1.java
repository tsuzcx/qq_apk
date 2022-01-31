package com.tencent.mobileqq.mini.appbrand.page;

import ajya;
import android.view.View;
import bfpc;
import bfph;

class ProgressWebView$3$1
  implements bfph
{
  ProgressWebView$3$1(ProgressWebView.3 param3, bfpc parambfpc, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.val$actionSheet.dismiss();
    paramView = this.val$actionSheet.a(paramInt);
    if (ajya.a(2131708518).equals(paramView)) {
      ProgressWebView.access$600(this.this$1.this$0, this.val$pic);
    }
    while (!ajya.a(2131708512).equals(paramView)) {
      return;
    }
    ProgressWebView.access$700(this.this$1.this$0, this.val$pic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.3.1
 * JD-Core Version:    0.7.0.1
 */