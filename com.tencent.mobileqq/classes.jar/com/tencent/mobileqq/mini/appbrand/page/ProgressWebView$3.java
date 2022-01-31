package com.tencent.mobileqq.mini.appbrand.page;

import ajyc;
import android.view.View;
import android.view.View.OnLongClickListener;
import bfol;
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
      bfol localbfol = bfol.a(ProgressWebView.access$500(this.this$0).getContext());
      localbfol.a(ajyc.a(2131708498), 7);
      localbfol.a(ajyc.a(2131708500), 7);
      localbfol.d(ajyc.a(2131708511));
      localbfol.c(true);
      localbfol.a(new ProgressWebView.3.1(this, localbfol, paramView));
      localbfol.show();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.3
 * JD-Core Version:    0.7.0.1
 */