package com.tencent.plato.sdk;

import android.content.Context;
import com.tencent.plato.IPlatoExceptionHandler;
import com.tencent.plato.IPlatoManager;
import com.tencent.plato.web.IWebView.WebViewFactory;
import com.tencent.plato.web.WebPlatoManager;

public class PlatoManagerBuilder
{
  private String mBundlePath;
  private Context mContext;
  private IPlatoExceptionHandler mExceptionHandler;
  private String mNativesBlobPath;
  private boolean mRenderInWebView;
  private String mSnapshotBlobPath;
  private IWebView.WebViewFactory mWebViewFactory;
  
  public IPlatoManager build()
  {
    if (this.mRenderInWebView) {
      return new WebPlatoManager(this.mContext, this.mBundlePath, this.mWebViewFactory);
    }
    return new NativePlatoManager(this.mContext, this.mBundlePath, this.mExceptionHandler, this.mNativesBlobPath, this.mSnapshotBlobPath);
  }
  
  public PlatoManagerBuilder setApplication(Context paramContext)
  {
    this.mContext = paramContext;
    return this;
  }
  
  public PlatoManagerBuilder setBundlePath(String paramString)
  {
    this.mBundlePath = paramString;
    return this;
  }
  
  public PlatoManagerBuilder setExceptionHandler(IPlatoExceptionHandler paramIPlatoExceptionHandler)
  {
    this.mExceptionHandler = paramIPlatoExceptionHandler;
    return this;
  }
  
  public PlatoManagerBuilder setNativesBlobPath(String paramString)
  {
    this.mNativesBlobPath = paramString;
    return this;
  }
  
  public PlatoManagerBuilder setRenderInWebView(IWebView.WebViewFactory paramWebViewFactory)
  {
    this.mRenderInWebView = true;
    this.mWebViewFactory = paramWebViewFactory;
    return this;
  }
  
  public PlatoManagerBuilder setSnapshotBlobPath(String paramString)
  {
    this.mSnapshotBlobPath = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.PlatoManagerBuilder
 * JD-Core Version:    0.7.0.1
 */