package com.tencent.mobileqq.mini.appbrand.page;

import alud;
import android.view.View;
import android.view.View.OnLongClickListener;
import bhuf;
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
      bhuf localbhuf = bhuf.a(ProgressWebView.access$500(this.this$0).getContext());
      localbhuf.a(alud.a(2131708893), 7);
      localbhuf.a(alud.a(2131708895), 7);
      localbhuf.d(alud.a(2131708906));
      localbhuf.c(true);
      localbhuf.a(new ProgressWebView.3.1(this, localbhuf, paramView));
      localbhuf.show();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.3
 * JD-Core Version:    0.7.0.1
 */