package com.tencent.plato.web;

import android.content.Context;
import android.view.View;
import com.tencent.plato.IPlatoManager;
import com.tencent.plato.IPlatoManager.IRenderListener;
import com.tencent.plato.IPlatoSurface;
import com.tencent.plato.JSONWritableMap;
import com.tencent.plato.core.IExportedModule;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.JSModule;
import com.tencent.plato.core.utils.PLog;
import com.tencent.plato.module.AppRegistry;

public class WebPlatoManager
  implements IPlatoManager
{
  private boolean mHasRender;
  private final WebPlatoRuntime mWebPlatoRuntime;
  
  public WebPlatoManager(Context paramContext, String paramString, IWebView.WebViewFactory paramWebViewFactory)
  {
    this.mWebPlatoRuntime = new WebPlatoRuntime(paramContext, paramString, paramWebViewFactory);
  }
  
  public void bindSurface(int paramInt, IPlatoSurface paramIPlatoSurface)
  {
    paramIPlatoSurface.addView((View)this.mWebPlatoRuntime.getWebView(), -1, -1);
  }
  
  public void destroyInstance()
  {
    this.mWebPlatoRuntime.destroyInstance();
  }
  
  public <T extends IExportedModule> T getExportedModule(Class<T> paramClass)
  {
    return this.mWebPlatoRuntime.getExportedModule(paramClass);
  }
  
  public <T extends JSModule> T getJSModule(Class<T> paramClass)
  {
    return this.mWebPlatoRuntime.getJSModule(paramClass);
  }
  
  public void init()
  {
    this.mWebPlatoRuntime.init();
  }
  
  public int loadPage(IPlatoSurface paramIPlatoSurface, String paramString, IReadableMap paramIReadableMap, IPlatoManager.IRenderListener paramIRenderListener)
  {
    if (this.mHasRender) {
      throw new IllegalStateException("already render");
    }
    this.mHasRender = true;
    if (paramIPlatoSurface != null) {
      bindSurface(-1, paramIPlatoSurface);
    }
    paramIPlatoSurface = new JSONWritableMap();
    paramIPlatoSurface.put("initialProps", paramIReadableMap);
    PLog.i("render:" + paramString);
    ((AppRegistry)this.mWebPlatoRuntime.getJSModule(AppRegistry.class)).runApplication(paramString, paramIPlatoSurface);
    if (paramIRenderListener != null)
    {
      paramIRenderListener.onCreateDomFinish();
      paramIRenderListener.onRenderFinished(null);
    }
    return -1;
  }
  
  public int loadPage(String paramString, IReadableMap paramIReadableMap, IPlatoManager.IRenderListener paramIRenderListener)
  {
    return loadPage(null, paramString, paramIReadableMap, paramIRenderListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.web.WebPlatoManager
 * JD-Core Version:    0.7.0.1
 */