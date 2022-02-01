package com.tencent.mobileqq.webview;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;

final class AbsWebView$DownloadQQBrowserExtension
  extends ProxyWebViewClientExtension
{
  private TouchWebView b;
  private ArrayMap<String, Object> c;
  
  public AbsWebView$DownloadQQBrowserExtension(AbsWebView paramAbsWebView, TouchWebView paramTouchWebView)
  {
    this.b = paramTouchWebView;
  }
  
  private void a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    WebViewPluginEngine localWebViewPluginEngine = this.b.getPluginEngine();
    if (localWebViewPluginEngine != null)
    {
      if (this.c == null) {
        this.c = new ArrayMap(4);
      }
      this.c.put("performanceData", paramObject1);
      this.c.put("requestData", paramObject2);
      this.c.put("responseData", paramObject3);
      this.c.put("errorCode", paramObject4);
      localWebViewPluginEngine.a(this.b.getUrl(), 64L, this.c);
      if (QLog.isColorLevel())
      {
        paramObject1 = new StringBuilder();
        paramObject1.append("Take web core dump for ");
        paramObject1.append(Util.b(this.b.getUrl(), new String[0]));
        QLog.i("WebCoreDump", 2, paramObject1.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("WebCoreDump", 2, "No JS plugin engine to handle web core dump");
    }
  }
  
  public void computeScroll(View paramView)
  {
    this.b.computeScroll(paramView);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return this.b.dispatchTouchEvent(paramMotionEvent, paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return this.b.onInterceptTouchEvent(paramMotionEvent, paramView);
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    this.a.onMiscCallBack(paramString, paramBundle);
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
    this.b.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
  }
  
  public void onResponseReceived(WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse, int paramInt)
  {
    a(null, paramWebResourceRequest, paramWebResourceResponse, Integer.valueOf(paramInt));
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    this.b.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return this.b.onTouchEvent(paramMotionEvent, paramView);
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("onUrlChange detect 302 url: ");
      paramString1.append(paramString2);
      QLog.i("AbsWebView", 2, paramString1.toString());
    }
    SwiftBrowserCookieMonster.d();
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    return this.b.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.AbsWebView.DownloadQQBrowserExtension
 * JD-Core Version:    0.7.0.1
 */