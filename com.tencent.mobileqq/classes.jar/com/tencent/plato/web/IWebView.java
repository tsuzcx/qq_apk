package com.tencent.plato.web;

import android.content.Context;

public abstract interface IWebView
{
  public abstract void callFunction(String paramString1, String paramString2, Object[] paramArrayOfObject);
  
  public abstract void invokeCallback(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject);
  
  public abstract void loadUrl(String paramString);
  
  public abstract void setUrlRequestHandler(IUrlRequestHandler paramIUrlRequestHandler);
  
  public static abstract interface IUrlRequestHandler
  {
    public abstract void onUrlRequest(String paramString);
  }
  
  public static abstract interface WebViewFactory
  {
    public abstract IWebView newWebView(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.web.IWebView
 * JD-Core Version:    0.7.0.1
 */