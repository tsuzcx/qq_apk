package com.tencent.mobileqq.mini.appbrand.page;

import alpo;
import android.view.View;
import android.view.View.OnLongClickListener;
import bhpy;
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
      bhpy localbhpy = bhpy.a(ProgressWebView.access$500(this.this$0).getContext());
      localbhpy.a(alpo.a(2131708881), 7);
      localbhpy.a(alpo.a(2131708883), 7);
      localbhpy.d(alpo.a(2131708894));
      localbhpy.c(true);
      localbhpy.a(new ProgressWebView.3.1(this, localbhpy, paramView));
      localbhpy.show();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.3
 * JD-Core Version:    0.7.0.1
 */