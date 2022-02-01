package com.tencent.mobileqq.mini.appbrand.page;

import amtj;
import android.view.View;
import bjnw;
import bjoe;

class ProgressWebView$3$1
  implements bjoe
{
  ProgressWebView$3$1(ProgressWebView.3 param3, bjnw parambjnw, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.val$actionSheet.dismiss();
    paramView = this.val$actionSheet.a(paramInt);
    if (amtj.a(2131707619).equals(paramView)) {
      ProgressWebView.access$600(this.this$1.this$0, this.val$pic);
    }
    while (!amtj.a(2131707613).equals(paramView)) {
      return;
    }
    ProgressWebView.access$700(this.this$1.this$0, this.val$pic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.3.1
 * JD-Core Version:    0.7.0.1
 */