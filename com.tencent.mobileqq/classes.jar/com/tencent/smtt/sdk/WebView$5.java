package com.tencent.smtt.sdk;

import android.graphics.Picture;

class WebView$5
  implements android.webkit.WebView.PictureListener
{
  WebView$5(WebView paramWebView, WebView.PictureListener paramPictureListener) {}
  
  public void onNewPicture(android.webkit.WebView paramWebView, Picture paramPicture)
  {
    this.b.a(paramWebView);
    this.a.onNewPicture(this.b, paramPicture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.5
 * JD-Core Version:    0.7.0.1
 */