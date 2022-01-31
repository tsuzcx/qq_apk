package com.tencent.mobileqq.mini.appbrand.page;

import ajya;
import android.view.View;
import android.view.View.OnLongClickListener;
import bfpc;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;

class ProgressWebView$3
  implements View.OnLongClickListener
{
  ProgressWebView$3(ProgressWebView paramProgressWebView) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = ProgressWebView.access$500(this.this$0).getHitTestResult();
    if ((paramView.getType() == 5) || (paramView.getType() == 8))
    {
      paramView = paramView.getExtra();
      if (QLog.isColorLevel()) {
        QLog.e("ProgressWebView", 2, "onLongClick : " + paramView);
      }
      bfpc localbfpc = bfpc.a(ProgressWebView.access$500(this.this$0).getContext());
      localbfpc.a(ajya.a(2131708509), 7);
      localbfpc.a(ajya.a(2131708511), 7);
      localbfpc.d(ajya.a(2131708522));
      localbfpc.c(true);
      localbfpc.a(new ProgressWebView.3.1(this, localbfpc, paramView));
      localbfpc.show();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.3
 * JD-Core Version:    0.7.0.1
 */