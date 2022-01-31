package com.tencent.plato.impl;

import android.content.Context;
import com.tencent.plato.IPlatoExceptionHandler;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.JSModuleRegistry;
import com.tencent.plato.ModuleManager;
import com.tencent.plato.ModuleManager.Arr;
import com.tencent.plato.core.IExportedModule;
import com.tencent.plato.core.IReadableArray;
import com.tencent.plato.core.JSModule;
import com.tencent.plato.jni.HybridObject;
import java.io.File;

public abstract class AbstractPlatoRuntime
  extends HybridObject
  implements IPlatoRuntime
{
  private final String mAppId;
  private final String mBundleDir;
  private final Context mContext;
  private final JSModuleRegistry mJSModuleRegistry;
  private final ModuleManager mModuleManager;
  
  public AbstractPlatoRuntime(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    paramContext = new File(paramString).getParent();
    this.mBundleDir = paramContext;
    this.mAppId = paramContext;
    this.mModuleManager = new ModuleManager(this, ModuleManager.Arr.getModules());
    this.mJSModuleRegistry = new JSModuleRegistry();
  }
  
  public void destroyInstance() {}
  
  public Object dispatchScriptRequest(int paramInt1, int paramInt2, IReadableArray paramIReadableArray)
  {
    return this.mModuleManager.invoke(paramInt1, paramInt2, paramIReadableArray);
  }
  
  public String getAllModuleDesc()
  {
    return ModuleManager.Arr.getAllModuleDesc();
  }
  
  public String getAppId()
  {
    return this.mAppId;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public <T extends IExportedModule> T getExportedModule(Class<T> paramClass)
  {
    return this.mModuleManager.getExportedModule(paramClass);
  }
  
  public <T extends JSModule> T getJSModule(Class<T> paramClass)
  {
    return this.mJSModuleRegistry.getJSModule(this, paramClass);
  }
  
  public String getPath()
  {
    return this.mBundleDir;
  }
  
  public void setExceptionHandler(IPlatoExceptionHandler paramIPlatoExceptionHandler) {}
  
  public void throwException(Throwable paramThrowable)
  {
    throw new IllegalStateException(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.impl.AbstractPlatoRuntime
 * JD-Core Version:    0.7.0.1
 */