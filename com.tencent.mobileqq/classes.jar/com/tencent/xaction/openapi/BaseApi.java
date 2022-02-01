package com.tencent.xaction.openapi;

import android.content.Context;
import com.tencent.xaction.openapi.api.IDynamicLoader;
import com.tencent.xaction.openapi.api.IXAEngine;
import com.tencent.xaction.openapi.api.IXAGlobal;
import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicBoolean;

class BaseApi
{
  static String a = "com.tencent.xaction.openapi.api.impl.DynamicLoaderImpl";
  static AtomicBoolean b = new AtomicBoolean(true);
  static ClassLoader c = null;
  
  static IXAEngine a(Context paramContext)
  {
    try
    {
      paramContext = c.loadClass("com.tencent.xaction.impl.XAEngine").getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramContext = null;
    }
    return (IXAEngine)paramContext;
  }
  
  static IXAGlobal a()
  {
    Object localObject2;
    try
    {
      Object localObject1 = c.loadClass("com.tencent.xaction.impl.XAGlobal").getConstructor(new Class[0]).newInstance(new Object[0]);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject2 = null;
    }
    return (IXAGlobal)localObject2;
  }
  
  static IXAEngine b(Context paramContext)
  {
    try
    {
      paramContext = (IXAEngine)Class.forName("com.tencent.xaction.impl.XAEngine").getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  static IXAGlobal b()
  {
    try
    {
      IXAGlobal localIXAGlobal = (IXAGlobal)Class.forName("com.tencent.xaction.impl.XAGlobal").getConstructor(new Class[0]).newInstance(new Object[0]);
      return localIXAGlobal;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  static boolean c()
  {
    return c != null;
  }
  
  static void d()
  {
    if (b.get()) {
      try
      {
        if (!b.get()) {
          return;
        }
        Object localObject1 = c;
        if (localObject1 == null) {
          try
          {
            localObject1 = (IDynamicLoader)XAApi.class.getClassLoader().loadClass(a).newInstance();
            ((IDynamicLoader)localObject1).loadSync();
            if (((IDynamicLoader)localObject1).isLoaded()) {
              c = ((IDynamicLoader)localObject1).getClassLoader();
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        b.set(false);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.openapi.BaseApi
 * JD-Core Version:    0.7.0.1
 */