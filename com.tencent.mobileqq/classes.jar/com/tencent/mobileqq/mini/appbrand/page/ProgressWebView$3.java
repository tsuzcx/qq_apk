package com.tencent.mobileqq.mini.appbrand.page;

import android.view.View;
import android.view.View.OnLongClickListener;
import anzj;
import blir;
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
      blir localblir = blir.a(ProgressWebView.access$500(this.this$0).getContext());
      localblir.a(anzj.a(2131707378), 7);
      localblir.a(anzj.a(2131707380), 7);
      localblir.d(anzj.a(2131707391));
      localblir.d(true);
      localblir.a(new ProgressWebView.3.1(this, localblir, paramView));
      localblir.show();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.3
 * JD-Core Version:    0.7.0.1
 */