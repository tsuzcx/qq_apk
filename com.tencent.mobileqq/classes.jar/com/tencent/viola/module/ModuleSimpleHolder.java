package com.tencent.viola.module;

import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.Invoker;
import com.tencent.viola.bridge.MethodInvoker;
import com.tencent.viola.utils.ViolaLogUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ModuleSimpleHolder<T extends BaseModule>
  implements IModuleHolder<T>
{
  public static final String TAG = "TypeModuleFactory";
  Class<T> mClazz;
  Map<String, Invoker> mMethodMap;
  
  public ModuleSimpleHolder(Class<T> paramClass)
  {
    this.mClazz = paramClass;
  }
  
  private void generateMethodMap()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("extractMethodNames:");
    ((StringBuilder)localObject1).append(this.mClazz.getSimpleName());
    ViolaLogUtils.d("TypeModuleFactory", ((StringBuilder)localObject1).toString());
    HashMap localHashMap = new HashMap();
    try
    {
      Object localObject2 = this.mClazz.getMethods();
      int k = localObject2.length;
      int i = 0;
      while (i < k)
      {
        Method localMethod = localObject2[i];
        localObject1 = localMethod.getDeclaredAnnotations();
        int m = localObject1.length;
        int j = 0;
        while (j < m)
        {
          JSMethod localJSMethod = localObject1[j];
          if ((localJSMethod != null) && ((localJSMethod instanceof JSMethod)))
          {
            localJSMethod = (JSMethod)localJSMethod;
            if ("_".equals(localJSMethod.alias())) {
              localObject1 = localMethod.getName();
            } else {
              localObject1 = localJSMethod.alias();
            }
            localHashMap.put(localObject1, new MethodInvoker(localMethod, localJSMethod.uiThread()));
            break;
          }
          j += 1;
        }
        i += 1;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[ModuleManager] extractMethodNames:");
      ((StringBuilder)localObject2).append(localThrowable);
      ViolaLogUtils.e("TypeModuleFactory", ((StringBuilder)localObject2).toString());
      this.mMethodMap = localHashMap;
    }
  }
  
  public T buildInstance()
  {
    return (BaseModule)this.mClazz.newInstance();
  }
  
  public Invoker getMethodInvoker(String paramString)
  {
    if (this.mMethodMap == null) {
      generateMethodMap();
    }
    return (Invoker)this.mMethodMap.get(paramString);
  }
  
  public String[] getMethods()
  {
    if (this.mMethodMap == null) {
      generateMethodMap();
    }
    Set localSet = this.mMethodMap.keySet();
    return (String[])localSet.toArray(new String[localSet.size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.module.ModuleSimpleHolder
 * JD-Core Version:    0.7.0.1
 */