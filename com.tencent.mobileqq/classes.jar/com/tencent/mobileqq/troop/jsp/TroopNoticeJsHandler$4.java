package com.tencent.mobileqq.troop.jsp;

import com.tencent.smtt.sdk.WebView;

class TroopNoticeJsHandler$4
  implements Runnable
{
  TroopNoticeJsHandler$4(TroopNoticeJsHandler paramTroopNoticeJsHandler, WebView paramWebView, String paramString1, String paramString2) {}
  
  public void run()
  {
    WebView localWebView = this.a;
    if (localWebView != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript: ");
      localStringBuilder.append(this.b);
      localStringBuilder.append("(");
      localStringBuilder.append(this.c);
      localStringBuilder.append(")");
      localWebView.loadUrl(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.4
 * JD-Core Version:    0.7.0.1
 */