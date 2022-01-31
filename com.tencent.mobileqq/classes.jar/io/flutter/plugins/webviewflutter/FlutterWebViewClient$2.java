package io.flutter.plugins.webviewflutter;

import android.annotation.TargetApi;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class FlutterWebViewClient$2
  extends WebViewClient
{
  FlutterWebViewClient$2(FlutterWebViewClient paramFlutterWebViewClient) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    FlutterWebViewClient.access$300(this.this$0, paramWebView, paramString);
  }
  
  public void onUnhandledKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent) {}
  
  @TargetApi(24)
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return FlutterWebViewClient.access$200(this.this$0, paramWebView, paramWebResourceRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.FlutterWebViewClient.2
 * JD-Core Version:    0.7.0.1
 */