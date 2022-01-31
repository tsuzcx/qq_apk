package io.flutter.plugins.webviewflutter;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

class FlutterWebViewClient$1
  extends WebChromeClient
{
  FlutterWebViewClient$1(FlutterWebViewClient paramFlutterWebViewClient) {}
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
    if (!paramWebView.getUrl().contains(paramString)) {
      FlutterWebViewClient.access$100(this.this$0, paramWebView, paramWebView.getUrl(), paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.FlutterWebViewClient.1
 * JD-Core Version:    0.7.0.1
 */