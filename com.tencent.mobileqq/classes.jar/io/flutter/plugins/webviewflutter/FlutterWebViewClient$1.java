package io.flutter.plugins.webviewflutter;

import android.annotation.TargetApi;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class FlutterWebViewClient$1
  extends WebViewClient
{
  FlutterWebViewClient$1(FlutterWebViewClient paramFlutterWebViewClient) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    FlutterWebViewClient.access$200(this.this$0, paramWebView, paramString);
  }
  
  public void onUnhandledKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent) {}
  
  @TargetApi(24)
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return FlutterWebViewClient.access$100(this.this$0, paramWebView, paramWebResourceRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.FlutterWebViewClient.1
 * JD-Core Version:    0.7.0.1
 */