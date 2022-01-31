package com.tencent.mobileqq.mini.appbrand.page;

import alud;
import android.view.View;
import bhuf;
import bhuk;

class ProgressWebView$3$1
  implements bhuk
{
  ProgressWebView$3$1(ProgressWebView.3 param3, bhuf parambhuf, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.val$actionSheet.dismiss();
    paramView = this.val$actionSheet.a(paramInt);
    if (alud.a(2131708902).equals(paramView)) {
      ProgressWebView.access$600(this.this$1.this$0, this.val$pic);
    }
    while (!alud.a(2131708896).equals(paramView)) {
      return;
    }
    ProgressWebView.access$700(this.this$1.this$0, this.val$pic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.3.1
 * JD-Core Version:    0.7.0.1
 */