package io.flutter.plugins.webviewflutter;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

class FlutterWebViewClient
{
  private static final String TAG = "FlutterWebViewClient";
  private boolean hasNavigationDelegate;
  private final MethodChannel methodChannel;
  
  FlutterWebViewClient(MethodChannel paramMethodChannel)
  {
    this.methodChannel = paramMethodChannel;
  }
  
  private WebViewClient internalCreateWebViewClient()
  {
    Log.i("FlutterWebView", "create internalCreateWebViewClient");
    return new FlutterWebViewClient.1(this);
  }
  
  private void notifyOnNavigationRequest(String paramString, Map<String, String> paramMap, WebView paramWebView, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramString);
    localHashMap.put("isForMainFrame", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      this.methodChannel.invokeMethod("navigationRequest", localHashMap, new FlutterWebViewClient.OnNavigationRequestResult(paramString, paramMap, paramWebView, null));
      return;
    }
    this.methodChannel.invokeMethod("navigationRequest", localHashMap);
  }
  
  private void onPageFinished(WebView paramWebView, String paramString)
  {
    paramWebView = new HashMap();
    paramWebView.put("url", paramString);
    this.methodChannel.invokeMethod("onPageFinished", paramWebView);
  }
  
  @TargetApi(21)
  private boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if (!this.hasNavigationDelegate) {
      return false;
    }
    notifyOnNavigationRequest(paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.getRequestHeaders(), paramWebView, paramWebResourceRequest.isForMainFrame());
    return paramWebResourceRequest.isForMainFrame();
  }
  
  private boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (!this.hasNavigationDelegate) {
      return false;
    }
    Log.w("FlutterWebViewClient", "Using a navigationDelegate with an old webview implementation, pages with frames or iframes will not work");
    notifyOnNavigationRequest(paramString, null, paramWebView, true);
    return true;
  }
  
  WebViewClient createWebViewClient(boolean paramBoolean)
  {
    this.hasNavigationDelegate = paramBoolean;
    if ((!paramBoolean) || (Build.VERSION.SDK_INT >= 24)) {
      return internalCreateWebViewClient();
    }
    return internalCreateWebViewClient();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.FlutterWebViewClient
 * JD-Core Version:    0.7.0.1
 */