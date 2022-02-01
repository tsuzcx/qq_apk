package com.tencent.mobileqq.webview.swift;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import mqq.app.AppRuntime;

final class WebViewWrapper$DownloadQQBrowserExtension
  extends ProxyWebViewClientExtension
{
  final TouchWebView a;
  WebViewCallback b;
  ArrayMap<String, Object> c;
  
  public WebViewWrapper$DownloadQQBrowserExtension(WebViewWrapper paramWebViewWrapper, TouchWebView paramTouchWebView, WebViewCallback paramWebViewCallback)
  {
    this.a = paramTouchWebView;
    this.b = paramWebViewCallback;
  }
  
  void a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    WebViewPluginEngine localWebViewPluginEngine = this.a.getPluginEngine();
    if (localWebViewPluginEngine != null)
    {
      if (this.c == null) {
        this.c = new ArrayMap(4);
      }
      this.c.put("performanceData", paramObject1);
      this.c.put("requestData", paramObject2);
      this.c.put("responseData", paramObject3);
      this.c.put("errorCode", paramObject4);
      localWebViewPluginEngine.a(this.a.getUrl(), 64L, this.c);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("WebCoreDump", 2, "No JS plugin engine to web core dump");
    }
  }
  
  public void computeScroll(View paramView)
  {
    this.a.computeScroll(paramView);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return this.a.dispatchTouchEvent(paramMotionEvent, paramView);
  }
  
  public void onFakeLoginRecognised(Bundle paramBundle)
  {
    super.onFakeLoginRecognised(paramBundle);
    if (WebViewWrapper.a(this.d) != null) {
      WebViewWrapper.a(this.d).a(paramBundle, this.d.d, this.d.b.getCurrentAccountUin());
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return this.a.onInterceptTouchEvent(paramMotionEvent, paramView);
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    WebViewCallback localWebViewCallback = this.b;
    if (localWebViewCallback != null) {
      return localWebViewCallback.handlerMiscCallback(paramString, paramBundle);
    }
    return null;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if ((paramString.equalsIgnoreCase("onReportResourceInfo")) || (paramString.equalsIgnoreCase("onResourcesPerformance"))) {
      a(paramObject1, paramObject2, paramObject3, paramObject4);
    }
    return null;
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    this.a.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
  }
  
  public void onPrefetchResourceHit(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("now prefetchResource is hit: ");
    localStringBuilder.append(paramBoolean);
    QLog.i("WebLog_WebViewWrapper", 1, localStringBuilder.toString());
  }
  
  public void onPreloadCallback(int paramInt, String paramString)
  {
    WebViewCallback localWebViewCallback = this.b;
    if (localWebViewCallback != null) {
      localWebViewCallback.handlePreloadCallback(paramInt, paramString);
    }
  }
  
  public void onResponseReceived(WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse, int paramInt)
  {
    a(null, paramWebResourceRequest, paramWebResourceResponse, Integer.valueOf(paramInt));
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    this.a.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return this.a.onTouchEvent(paramMotionEvent, paramView);
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    SwiftBrowserCookieMonster.d();
    WebViewCallback localWebViewCallback = this.b;
    if (localWebViewCallback != null) {
      localWebViewCallback.onUrlChange(paramString1, paramString2);
    }
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    return this.a.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewWrapper.DownloadQQBrowserExtension
 * JD-Core Version:    0.7.0.1
 */