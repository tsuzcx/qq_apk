package com.tencent.plato;

import android.content.Context;
import android.os.Handler;
import com.tencent.plato.core.IExportedModule;
import com.tencent.plato.core.IFunction.CallbackInvoker;
import com.tencent.plato.core.IReadableArray;
import com.tencent.plato.core.JSModule;

public abstract interface IPlatoRuntime
  extends IFunction.CallbackInvoker, JSModuleRegistry.IScriptFunctionInvoker
{
  public abstract void destroyInstance();
  
  public abstract Object dispatchScriptRequest(int paramInt1, int paramInt2, IReadableArray paramIReadableArray);
  
  public abstract String getAppId();
  
  public abstract Context getContext();
  
  public abstract <T extends IExportedModule> T getExportedModule(Class<T> paramClass);
  
  public abstract <T extends JSModule> T getJSModule(Class<T> paramClass);
  
  public abstract String getPath();
  
  public abstract Handler getThreadHandler();
  
  public abstract void init();
  
  public abstract void onPlatoException(String paramString);
  
  public abstract void setExceptionHandler(IPlatoExceptionHandler paramIPlatoExceptionHandler);
  
  public abstract void throwException(Throwable paramThrowable);
  
  public static abstract interface Factory
  {
    public abstract IPlatoRuntime newPlatoRuntime(Context paramContext, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.IPlatoRuntime
 * JD-Core Version:    0.7.0.1
 */