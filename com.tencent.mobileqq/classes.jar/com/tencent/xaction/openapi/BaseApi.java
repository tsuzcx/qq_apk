package com.tencent.xaction.openapi;

import android.content.Context;
import com.tencent.xaction.openapi.api.IDynamicLoader;
import com.tencent.xaction.openapi.api.IXAEngine;
import com.tencent.xaction.openapi.api.IXAGlobal;
import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicBoolean;

class BaseApi
{
  static ClassLoader jdField_a_of_type_JavaLangClassLoader = null;
  static String jdField_a_of_type_JavaLangString = "com.tencent.xaction.openapi.api.impl.DynamicLoaderImpl";
  static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  
  static IXAEngine a(Context paramContext)
  {
    try
    {
      paramContext = jdField_a_of_type_JavaLangClassLoader.loadClass("com.tencent.xaction.impl.XAEngine").getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
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
      Object localObject1 = jdField_a_of_type_JavaLangClassLoader.loadClass("com.tencent.xaction.impl.XAGlobal").getConstructor(new Class[0]).newInstance(new Object[0]);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject2 = null;
    }
    return (IXAGlobal)localObject2;
  }
  
  static void a()
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      try
      {
        if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          return;
        }
        Object localObject1 = jdField_a_of_type_JavaLangClassLoader;
        if (localObject1 == null) {
          try
          {
            localObject1 = (IDynamicLoader)XAApi.class.getClassLoader().loadClass(jdField_a_of_type_JavaLangString).newInstance();
            ((IDynamicLoader)localObject1).loadSync();
            if (((IDynamicLoader)localObject1).isLoaded()) {
              jdField_a_of_type_JavaLangClassLoader = ((IDynamicLoader)localObject1).getClassLoader();
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return;
      }
      finally {}
    }
  }
  
  static boolean a()
  {
    return jdField_a_of_type_JavaLangClassLoader != null;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.openapi.BaseApi
 * JD-Core Version:    0.7.0.1
 */