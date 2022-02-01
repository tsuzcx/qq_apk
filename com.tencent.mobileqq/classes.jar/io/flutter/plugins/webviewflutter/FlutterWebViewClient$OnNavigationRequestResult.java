package io.flutter.plugins.webviewflutter;

import android.os.Build.VERSION;
import android.webkit.WebView;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.Map;

class FlutterWebViewClient$OnNavigationRequestResult
  implements MethodChannel.Result
{
  private final Map<String, String> headers;
  private final String url;
  private final WebView webView;
  
  private FlutterWebViewClient$OnNavigationRequestResult(String paramString, Map<String, String> paramMap, WebView paramWebView)
  {
    this.url = paramString;
    this.headers = paramMap;
    this.webView = paramWebView;
  }
  
  private void loadUrl()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.webView.loadUrl(this.url, this.headers);
      return;
    }
    this.webView.loadUrl(this.url);
  }
  
  public void error(String paramString1, String paramString2, Object paramObject)
  {
    throw new IllegalStateException("navigationRequest calls must succeed");
  }
  
  public void notImplemented()
  {
    throw new IllegalStateException("navigationRequest must be implemented by the webview method channel");
  }
  
  public void success(Object paramObject)
  {
    if (((Boolean)paramObject).booleanValue()) {
      loadUrl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.FlutterWebViewClient.OnNavigationRequestResult
 * JD-Core Version:    0.7.0.1
 */