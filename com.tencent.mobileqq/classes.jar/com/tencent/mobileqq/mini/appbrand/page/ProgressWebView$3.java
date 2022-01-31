package com.tencent.mobileqq.mini.appbrand.page;

import ajjy;
import android.view.View;
import android.view.View.OnLongClickListener;
import begr;
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
      begr localbegr = begr.a(ProgressWebView.access$500(this.this$0).getContext());
      localbegr.a(ajjy.a(2131642713), 7);
      localbegr.a(ajjy.a(2131642715), 7);
      localbegr.d(ajjy.a(2131642726));
      localbegr.c(true);
      localbegr.a(new ProgressWebView.3.1(this, localbegr, paramView));
      localbegr.show();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.3
 * JD-Core Version:    0.7.0.1
 */