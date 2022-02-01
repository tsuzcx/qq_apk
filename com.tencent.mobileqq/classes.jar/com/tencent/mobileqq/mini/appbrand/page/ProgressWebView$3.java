package com.tencent.mobileqq.mini.appbrand.page;

import android.view.View;
import android.view.View.OnLongClickListener;
import anni;
import bkho;
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
      bkho localbkho = bkho.a(ProgressWebView.access$500(this.this$0).getContext());
      localbkho.a(anni.a(2131707269), 7);
      localbkho.a(anni.a(2131707271), 7);
      localbkho.d(anni.a(2131707282));
      localbkho.d(true);
      localbkho.a(new ProgressWebView.3.1(this, localbkho, paramView));
      localbkho.show();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.3
 * JD-Core Version:    0.7.0.1
 */