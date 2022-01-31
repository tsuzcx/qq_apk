package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import java.lang.reflect.Method;

class WebView$SystemWebView
  extends android.webkit.WebView
{
  public WebView$SystemWebView(WebView paramWebView, Context paramContext)
  {
    this(paramWebView, paramContext, null);
  }
  
  public WebView$SystemWebView(WebView paramWebView, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if ((QbSdk.getIsSysWebViewForcedByOuter()) && (TbsShareManager.isThirdPartyApp(paramContext))) {
      return;
    }
    CookieSyncManager.createInstance(WebView.access$300(paramWebView)).startSync();
    try
    {
      paramWebView = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
      paramWebView.setAccessible(true);
      ((Handler)paramWebView.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
      WebView.mSysWebviewCreated = true;
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public void computeScroll()
  {
    if (this.this$0.mWebViewCallbackClient != null)
    {
      this.this$0.mWebViewCallbackClient.computeScroll(this);
      return;
    }
    super.computeScroll();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      if ((!WebView.access$500()) && (WebView.access$600() != null))
      {
        paramCanvas.save();
        paramCanvas.drawPaint(WebView.access$600());
        paramCanvas.restore();
      }
      return;
    }
    catch (Throwable paramCanvas)
    {
      paramCanvas.printStackTrace();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.this$0.mWebViewCallbackClient != null) {
      return this.this$0.mWebViewCallbackClient.dispatchTouchEvent(paramMotionEvent, this);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public WebSettings getSettings()
  {
    try
    {
      WebSettings localWebSettings = super.getSettings();
      return localWebSettings;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public void invalidate()
  {
    super.invalidate();
    if (this.this$0.mWebViewCallbackClient != null) {
      this.this$0.mWebViewCallbackClient.invalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.this$0.mWebViewCallbackClient != null) {
      return this.this$0.mWebViewCallbackClient.onInterceptTouchEvent(paramMotionEvent, this);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  @TargetApi(9)
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.this$0.mWebViewCallbackClient != null) {
      this.this$0.mWebViewCallbackClient.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, this);
    }
    while (Build.VERSION.SDK_INT < 9) {
      return;
    }
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.this$0.mWebViewCallbackClient != null)
    {
      this.this$0.mWebViewCallbackClient.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
      return;
    }
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    WebView.access$400(this.this$0, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!hasFocus()) {
      requestFocus();
    }
    if (this.this$0.mWebViewCallbackClient != null) {
      return this.this$0.mWebViewCallbackClient.onTouchEvent(paramMotionEvent, this);
    }
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  @TargetApi(9)
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (this.this$0.mWebViewCallbackClient != null) {
      return this.this$0.mWebViewCallbackClient.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, this);
    }
    if (Build.VERSION.SDK_INT >= 9) {
      return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    }
    return false;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    try
    {
      super.setOverScrollMode(paramInt);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void super_computeScroll()
  {
    super.computeScroll();
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  @TargetApi(9)
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    }
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  @TargetApi(9)
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.SystemWebView
 * JD-Core Version:    0.7.0.1
 */