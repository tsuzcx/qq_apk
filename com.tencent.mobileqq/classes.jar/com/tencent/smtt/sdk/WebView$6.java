package com.tencent.smtt.sdk;

import android.graphics.Picture;

class WebView$6
  implements android.webkit.WebView.PictureListener
{
  WebView$6(WebView paramWebView, WebView.PictureListener paramPictureListener) {}
  
  public void onNewPicture(android.webkit.WebView paramWebView, Picture paramPicture)
  {
    this.this$0.setSysWebView(paramWebView);
    this.val$listner.onNewPicture(this.this$0, paramPicture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.6
 * JD-Core Version:    0.7.0.1
 */