package com.tencent.mobileqq.webview.webso;

import android.app.Activity;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;

final class WebSoScreenshot$2
  implements Runnable
{
  WebSoScreenshot$2(CustomWebView paramCustomWebView) {}
  
  public void run()
  {
    try
    {
      View localView = ((Activity)this.a.getContext()).findViewById(2131370699);
      localView.animate().alpha(0.0F).setDuration(300L);
      localView.postDelayed(new WebSoScreenshot.2.1(this, localView), 300L);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WebSoScreenshot", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoScreenshot.2
 * JD-Core Version:    0.7.0.1
 */