package com.tencent.smtt.sdk;

import android.graphics.Picture;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener;

class WebView$6
  implements IX5WebViewBase.PictureListener
{
  WebView$6(WebView paramWebView, WebView.PictureListener paramPictureListener) {}
  
  public void onNewPicture(IX5WebViewBase paramIX5WebViewBase, Picture paramPicture, boolean paramBoolean)
  {
    this.b.a(paramIX5WebViewBase);
    this.a.onNewPicture(this.b, paramPicture);
  }
  
  public void onNewPictureIfHaveContent(IX5WebViewBase paramIX5WebViewBase, Picture paramPicture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.6
 * JD-Core Version:    0.7.0.1
 */