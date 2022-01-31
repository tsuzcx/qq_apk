package com.tencent.plato;

import com.tencent.plato.core.IExportedModule;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.JSModule;

public abstract interface IPlatoManager
{
  public abstract void bindSurface(int paramInt, IPlatoSurface paramIPlatoSurface);
  
  public abstract void destroyInstance();
  
  public abstract <T extends IExportedModule> T getExportedModule(Class<T> paramClass);
  
  public abstract <T extends JSModule> T getJSModule(Class<T> paramClass);
  
  public abstract void init();
  
  public abstract int loadPage(IPlatoSurface paramIPlatoSurface, String paramString, IReadableMap paramIReadableMap, IRenderListener paramIRenderListener);
  
  public abstract int loadPage(String paramString, IReadableMap paramIReadableMap, IRenderListener paramIRenderListener);
  
  public static abstract interface IRenderListener
  {
    public abstract void onCreateDomFinish();
    
    public abstract void onRenderFinished(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.IPlatoManager
 * JD-Core Version:    0.7.0.1
 */