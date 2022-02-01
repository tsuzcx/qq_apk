package com.tencent.mobileqq.studyroom.webview;

import android.graphics.Bitmap;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

class StudyRoomBaseWebViewBuilder$InnerAbsWebView
  extends AbsWebView
{
  private boolean b;
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    super.bindJavaScript(paramArrayList);
    if (this.b) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    this.a.a(localArrayList);
    paramArrayList.addAll(localArrayList);
    this.b = true;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.a.b((StudyRoomWebView)paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.a.a((StudyRoomWebView)paramWebView, paramString);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    this.a.a((StudyRoomWebView)paramWebView, paramString2, paramInt, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.webview.StudyRoomBaseWebViewBuilder.InnerAbsWebView
 * JD-Core Version:    0.7.0.1
 */