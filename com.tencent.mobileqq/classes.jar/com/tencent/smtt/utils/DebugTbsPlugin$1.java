package com.tencent.smtt.utils;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.smtt.sdk.WebView;

class DebugTbsPlugin$1
  implements DebugTbsPlugin.DebugDownloadStatusListener
{
  DebugTbsPlugin$1(DebugTbsPlugin paramDebugTbsPlugin, WebView paramWebView, Context paramContext, RelativeLayout paramRelativeLayout, String paramString, TextView paramTextView) {}
  
  public void onDownloadFailure(Throwable paramThrowable)
  {
    this.val$webview.post(new DebugTbsPlugin.1.3(this));
  }
  
  public void onDownloadProgress(int paramInt)
  {
    this.val$webview.post(new DebugTbsPlugin.1.2(this, paramInt));
  }
  
  public void onDownloadSuccess()
  {
    this.val$webview.post(new DebugTbsPlugin.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.DebugTbsPlugin.1
 * JD-Core Version:    0.7.0.1
 */