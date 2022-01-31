package com.tencent.plato.sdk;

import android.content.Context;
import com.tencent.plato.IPlatoExceptionHandler;
import com.tencent.plato.IPlatoManager;
import com.tencent.plato.IPlatoManager.IRenderListener;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.IPlatoSurface;
import com.tencent.plato.JSONWritableMap;
import com.tencent.plato.core.IExportedModule;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.JSModule;
import com.tencent.plato.core.utils.PLog;
import com.tencent.plato.module.AppRegistry;
import com.tencent.plato.sdk.dom.DocumentModule;
import java.util.concurrent.atomic.AtomicInteger;

class NativePlatoManager
  implements IPlatoManager
{
  private static final AtomicInteger sAtomicInteger = new AtomicInteger();
  private final String mBundlePath;
  private DocumentModule mDocumentModule;
  private int mPageId;
  private IPlatoRuntime mPlatoRuntime;
  
  NativePlatoManager(Context paramContext, String paramString1, IPlatoExceptionHandler paramIPlatoExceptionHandler, String paramString2, String paramString3)
  {
    this.mBundlePath = paramString1;
    this.mPlatoRuntime = NativePlatoRuntimeFactory.getRuntime(paramContext, paramString1, paramString2, paramString3);
    this.mPlatoRuntime.setExceptionHandler(paramIPlatoExceptionHandler);
    this.mDocumentModule = ((DocumentModule)getExportedModule(DocumentModule.class));
  }
  
  public void bindSurface(int paramInt, IPlatoSurface paramIPlatoSurface)
  {
    this.mDocumentModule.bindSurface(paramInt, paramIPlatoSurface);
  }
  
  public void destroyInstance()
  {
    this.mDocumentModule.unmountPage(this.mPageId);
    ((AppRegistry)this.mPlatoRuntime.getJSModule(AppRegistry.class)).unmountApplication(this.mPageId);
    this.mPlatoRuntime.setExceptionHandler(null);
    NativePlatoRuntimeFactory.release(this.mBundlePath);
  }
  
  public <T extends IExportedModule> T getExportedModule(Class<T> paramClass)
  {
    return this.mPlatoRuntime.getExportedModule(paramClass);
  }
  
  public <T extends JSModule> T getJSModule(Class<T> paramClass)
  {
    return this.mPlatoRuntime.getJSModule(paramClass);
  }
  
  public void init()
  {
    this.mPlatoRuntime.init();
  }
  
  public int loadPage(IPlatoSurface paramIPlatoSurface, String paramString, IReadableMap paramIReadableMap, IPlatoManager.IRenderListener paramIRenderListener)
  {
    if (this.mPageId != 0) {
      throw new IllegalStateException("already createDom");
    }
    this.mPageId = sAtomicInteger.incrementAndGet();
    this.mDocumentModule.beforeRender(this.mPlatoRuntime, this.mPageId, this.mPlatoRuntime.getThreadHandler(), paramIRenderListener);
    if (paramIPlatoSurface != null) {
      bindSurface(this.mPageId, paramIPlatoSurface);
    }
    paramIPlatoSurface = new JSONWritableMap();
    paramIPlatoSurface.put("initialProps", paramIReadableMap);
    paramIPlatoSurface.put("pageId", this.mPageId);
    PLog.i("createDom:" + paramString);
    ((AppRegistry)this.mPlatoRuntime.getJSModule(AppRegistry.class)).runApplication(paramString, paramIPlatoSurface);
    return this.mPageId;
  }
  
  public int loadPage(String paramString, IReadableMap paramIReadableMap, IPlatoManager.IRenderListener paramIRenderListener)
  {
    return loadPage(null, paramString, paramIReadableMap, paramIRenderListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.NativePlatoManager
 * JD-Core Version:    0.7.0.1
 */