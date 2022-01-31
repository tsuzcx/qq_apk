package com.tencent.plato;

import com.tencent.plato.core.JSModule;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class JSModuleRegistry
{
  private final HashMap<Class<? extends JSModule>, JSModule> mModuleInstances = new HashMap();
  
  public <T extends JSModule> T getJSModule(IScriptFunctionInvoker paramIScriptFunctionInvoker, Class<T> paramClass)
  {
    Object localObject = (JSModule)this.mModuleInstances.get(paramClass);
    if (localObject == null) {
      try
      {
        JSModule localJSModule = (JSModule)this.mModuleInstances.get(paramClass);
        localObject = localJSModule;
        if (localJSModule == null)
        {
          localObject = paramClass.getClassLoader();
          paramIScriptFunctionInvoker = new JSModuleInvocationHandler(paramIScriptFunctionInvoker, paramClass);
          localObject = (JSModule)Proxy.newProxyInstance((ClassLoader)localObject, new Class[] { paramClass }, paramIScriptFunctionInvoker);
          this.mModuleInstances.put(paramClass, localObject);
        }
        return localObject;
      }
      finally {}
    }
    return localObject;
  }
  
  public static abstract interface IScriptFunctionInvoker
  {
    public abstract void callFunction(String paramString1, String paramString2, Object[] paramArrayOfObject);
  }
  
  private static class JSModuleInvocationHandler
    implements InvocationHandler
  {
    private final Class<? extends JSModule> mModuleInterface;
    private String mName;
    private final JSModuleRegistry.IScriptFunctionInvoker mScriptFunctionInvoker;
    
    public JSModuleInvocationHandler(JSModuleRegistry.IScriptFunctionInvoker paramIScriptFunctionInvoker, Class<? extends JSModule> paramClass)
    {
      this.mScriptFunctionInvoker = paramIScriptFunctionInvoker;
      this.mModuleInterface = paramClass;
    }
    
    private String getJSModuleName()
    {
      if (this.mName == null)
      {
        String str2 = this.mModuleInterface.getSimpleName();
        int i = str2.lastIndexOf('$');
        String str1 = str2;
        if (i != -1) {
          str1 = str2.substring(i + 1);
        }
        this.mName = str1;
      }
      return this.mName;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      this.mScriptFunctionInvoker.callFunction(getJSModuleName(), paramMethod.getName(), paramArrayOfObject);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.JSModuleRegistry
 * JD-Core Version:    0.7.0.1
 */