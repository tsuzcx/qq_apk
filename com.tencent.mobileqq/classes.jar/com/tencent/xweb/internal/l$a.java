package com.tencent.xweb.internal;

import android.content.Context;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.PreInitCallback;
import org.xwalk.core.WebViewExtensionListener;

public abstract interface l$a
{
  public abstract void clearAllWebViewCache(Context paramContext, boolean paramBoolean);
  
  public abstract IWebView createWebView(WebView paramWebView);
  
  public abstract Object excute(String paramString, Object[] paramArrayOfObject);
  
  public abstract CookieInternal.ICookieManagerInternal getCookieManager();
  
  public abstract CookieInternal.ICookieSyncManagerInternal getCookieSyncManager();
  
  public abstract IWebViewDatabase getWebViewDatabase();
  
  public abstract boolean hasInited();
  
  public abstract void initCallback(WebViewExtensionListener paramWebViewExtensionListener);
  
  public abstract void initEnviroment(Context paramContext);
  
  public abstract void initInterface();
  
  public abstract boolean initWebviewCore(Context paramContext, WebView.PreInitCallback paramPreInitCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.internal.l.a
 * JD-Core Version:    0.7.0.1
 */