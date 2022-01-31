package com.tencent.plato.web;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.plato.impl.AbstractPlatoRuntime;
import java.io.File;

class WebPlatoRuntime
  extends AbstractPlatoRuntime
{
  private final String mBundle;
  private Handler mMainHandler;
  private final IWebView mWebView;
  
  WebPlatoRuntime(Context paramContext, String paramString, IWebView.WebViewFactory paramWebViewFactory)
  {
    super(paramContext, paramString);
    if (paramWebViewFactory != null) {}
    for (this.mWebView = paramWebViewFactory.newWebView(paramContext);; this.mWebView = new PWebView(paramContext))
    {
      this.mWebView.setUrlRequestHandler(new WebPlatoBridge(this));
      this.mBundle = ("file://" + new File(paramString).getParent() + "/index.html");
      return;
    }
  }
  
  public void callFunction(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    this.mWebView.callFunction(paramString1, paramString2, paramArrayOfObject);
  }
  
  public Handler getThreadHandler()
  {
    if (this.mMainHandler == null) {
      this.mMainHandler = new Handler(Looper.getMainLooper());
    }
    return this.mMainHandler;
  }
  
  IWebView getWebView()
  {
    return this.mWebView;
  }
  
  public void init()
  {
    this.mWebView.loadUrl(this.mBundle);
  }
  
  public void invokeCallback(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject)
  {
    this.mWebView.invokeCallback(paramInt1, paramInt2, paramInt3, paramArrayOfObject);
  }
  
  public void onPlatoException(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.web.WebPlatoRuntime
 * JD-Core Version:    0.7.0.1
 */