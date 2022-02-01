package com.tencent.mtt.hippy.views.webview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.utils.UrlUtils;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import java.net.URLDecoder;

class HippyWebView$1
  extends WebViewClient
{
  final HippyViewEvent mEventOnError = new HippyViewEvent("onError");
  final HippyViewEvent mEventonLoad = new HippyViewEvent("onLoad");
  final HippyViewEvent mEventonLoadEnd = new HippyViewEvent("onLoadEnd");
  final HippyViewEvent mEventonLoadStart = new HippyViewEvent("onLoadStart");
  final String mMessageUrlPre = "hippy://postMessage?data=";
  
  HippyWebView$1(HippyWebView paramHippyWebView) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (Build.VERSION.SDK_INT < 17) {
      paramWebView.loadUrl("javascript:hippy={};hippy.onMessage=function(data){location.href='hippy://postMessage?data='+encodeURIComponent(data)}");
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("url", paramString);
    this.mEventonLoad.send(this.this$0, localHippyMap);
    this.mEventonLoadEnd.send(this.this$0, localHippyMap);
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("url", paramString);
    this.mEventonLoadStart.send(this.this$0, localHippyMap);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    HippyMap localHippyMap = new HippyMap();
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localHippyMap.pushString("error", (String)paramWebResourceError.getDescription());
      i = paramWebResourceError.getErrorCode();
    }
    else
    {
      localHippyMap.pushString("error", "unknown error");
      i = 2147483647;
    }
    localHippyMap.pushInt("errorCode", i);
    this.mEventOnError.send(this.this$0, localHippyMap);
    super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest.getUrl().toString());
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (paramString != null)
    {
      if (paramString.startsWith("hippy://postMessage?data="))
      {
        this.this$0.postMessage(URLDecoder.decode(paramString.substring(25)));
        return true;
      }
      if ((UrlUtils.isWebUrl(paramString)) || (UrlUtils.isFileUrl(paramString)))
      {
        paramWebView.loadUrl(paramString);
        return true;
      }
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.webview.HippyWebView.1
 * JD-Core Version:    0.7.0.1
 */