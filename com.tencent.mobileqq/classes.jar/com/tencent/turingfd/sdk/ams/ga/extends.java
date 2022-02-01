package com.tencent.turingfd.sdk.ams.ga;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class extends
{
  public static HashMap<String, Class<?>> Uc = new HashMap();
  public static HashMap<Class<?>, HashMap<String, Field>> Vc = new HashMap();
  public static HashMap<Class<?>, HashMap<String, Method>> Wc = new HashMap();
  
  public static Object a(Class<?> paramClass, String paramString, Object paramObject)
  {
    Object localObject2;
    if (paramClass == null)
    {
      paramClass = null;
    }
    else
    {
      Object localObject1;
      label70:
      try
      {
        localObject2 = (HashMap)Vc.get(paramClass);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new HashMap();
          Vc.put(paramClass, localObject1);
        }
        localObject2 = (Field)((HashMap)localObject1).get(paramString);
        if (localObject2 != null) {
          break label108;
        }
        paramClass = paramClass.getDeclaredField(paramString);
      }
      catch (Throwable paramClass) {}
      paramClass.setAccessible(true);
      ((HashMap)localObject1).put(paramString, paramClass);
    }
    label108:
    while (paramClass != null)
    {
      try
      {
        paramClass.printStackTrace();
      }
      catch (Throwable paramClass)
      {
        paramClass.printStackTrace();
        return null;
      }
      paramClass = paramClass.get(paramObject);
      return paramClass;
      paramClass = (Class<?>)localObject2;
      if (paramClass != null) {
        break label70;
      }
      break;
    }
    return null;
  }
  
  public static Method a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    if (paramClass != null) {}
    Object localObject2;
    do
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          return null;
        }
        localObject1 = new StringBuffer(paramString);
        if (paramVarArgs != null)
        {
          int i = 0;
          while (i < paramVarArgs.length)
          {
            localObject2 = paramVarArgs[i];
            ((StringBuffer)localObject1).append("+");
            ((StringBuffer)localObject1).append(((Class)localObject2).getName());
            i += 1;
          }
        }
        str = ((StringBuffer)localObject1).toString();
        localObject2 = (HashMap)Wc.get(paramClass);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new HashMap();
          Wc.put(paramClass, localObject1);
        }
        Method localMethod = (Method)((HashMap)localObject1).get(str);
        localObject2 = localMethod;
        if (localMethod != null) {
          continue;
        }
        localObject2 = paramClass.getDeclaredMethod(paramString, paramVarArgs);
      }
      catch (Throwable paramClass)
      {
        Object localObject1;
        String str;
        paramClass.printStackTrace();
      }
      ((Method)localObject2).setAccessible(true);
      ((HashMap)localObject1).put(str, localObject2);
      return localObject2;
      return null;
    } while (localObject2 != null);
    return null;
  }
  
  public static Object b(Class<?> paramClass, String paramString, Object paramObject)
  {
    try
    {
      paramClass = a(paramClass, paramString, new Class[0]);
      if (paramClass == null) {
        return null;
      }
      paramClass = paramClass.invoke(paramObject, new Object[0]);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static Object c(String paramString1, String paramString2)
  {
    Class localClass1;
    try
    {
      Class localClass2 = (Class)Uc.get(paramString1);
      localClass1 = localClass2;
      if (localClass2 != null) {
        break label61;
      }
      localClass1 = Class.forName(paramString1);
    }
    catch (Throwable paramString1) {}
    Uc.put(paramString1, localClass1);
    for (;;)
    {
      try
      {
        paramString1.printStackTrace();
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
      paramString1 = a(localClass1, paramString2, null);
      return paramString1;
      label61:
      if (localClass1 != null) {
        break;
      }
      localClass1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.extends
 * JD-Core Version:    0.7.0.1
 */