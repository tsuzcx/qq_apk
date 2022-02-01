package com.tencent.mobileqq.qqgamepub.web.delegate;

import com.tencent.mobileqq.qqgamepub.web.view.QQGamePubWebView;
import com.tencent.smtt.sdk.WebView;

class QQGameWebViewDelegate$1$1
  implements Runnable
{
  QQGameWebViewDelegate$1$1(QQGameWebViewDelegate.1 param1, WebView paramWebView, String paramString) {}
  
  public void run()
  {
    if ((QQGameWebViewDelegate.a(this.c.b) != null) && (QQGameWebViewDelegate.b(this.c.b) != null))
    {
      QQGameWebViewDelegate.b(this.c.b).setVisibility(0);
      QQGameWebViewDelegate.a(this.c.b).a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.delegate.QQGameWebViewDelegate.1.1
 * JD-Core Version:    0.7.0.1
 */