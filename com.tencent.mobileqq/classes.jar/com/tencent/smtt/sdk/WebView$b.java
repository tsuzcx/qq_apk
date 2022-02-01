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

class WebView$b
  extends android.webkit.WebView
{
  public WebView$b(WebView paramWebView, Context paramContext)
  {
    this(paramWebView, paramContext, null);
  }
  
  public WebView$b(WebView paramWebView, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(WebView.a(paramWebView, paramContext), paramAttributeSet);
    if ((QbSdk.getIsSysWebViewForcedByOuter()) && (TbsShareManager.isThirdPartyApp(paramContext))) {
      return;
    }
    CookieSyncManager.createInstance(WebView.a(paramWebView)).startSync();
    try
    {
      paramWebView = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
      paramWebView.setAccessible(true);
      ((Handler)paramWebView.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new e());
      WebView.mSysWebviewCreated = true;
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public void a()
  {
    super.computeScroll();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @TargetApi(9)
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    }
  }
  
  @TargetApi(9)
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    }
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void computeScroll()
  {
    if (this.a.mWebViewCallbackClient != null)
    {
      this.a.mWebViewCallbackClient.computeScroll(this);
      return;
    }
    super.computeScroll();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      if ((!WebView.f()) && (WebView.g() != null))
      {
        paramCanvas.save();
        paramCanvas.drawPaint(WebView.g());
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
    if (this.a.mWebViewCallbackClient != null) {
      return this.a.mWebViewCallbackClient.dispatchTouchEvent(paramMotionEvent, this);
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
    if (this.a.mWebViewCallbackClient != null) {
      this.a.mWebViewCallbackClient.invalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a.mWebViewCallbackClient != null) {
      return this.a.mWebViewCallbackClient.onInterceptTouchEvent(paramMotionEvent, this);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  @TargetApi(9)
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a.mWebViewCallbackClient != null) {
      this.a.mWebViewCallbackClient.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, this);
    }
    while (Build.VERSION.SDK_INT < 9) {
      return;
    }
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a.mWebViewCallbackClient != null)
    {
      this.a.mWebViewCallbackClient.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
      return;
    }
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    WebView.b(this.a, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!hasFocus()) {
      requestFocus();
    }
    if (this.a.mWebViewCallbackClient != null) {
      return this.a.mWebViewCallbackClient.onTouchEvent(paramMotionEvent, this);
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
    if (this.a.mWebViewCallbackClient != null) {
      return this.a.mWebViewCallbackClient.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, this);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.b
 * JD-Core Version:    0.7.0.1
 */