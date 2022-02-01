package com.tencent.turingfd.sdk.xq;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class transient
{
  public static HashMap<String, Class<?>> a = new HashMap();
  public static HashMap<Class<?>, HashMap<String, Field>> b = new HashMap();
  public static HashMap<Class<?>, HashMap<String, Method>> c = new HashMap();
  
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
        localObject2 = (HashMap)b.get(paramClass);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new HashMap();
          b.put(paramClass, localObject1);
        }
        localObject2 = (Field)((HashMap)localObject1).get(paramString);
        if (localObject2 != null) {
          break label108;
        }
        paramClass = paramClass.getDeclaredField(paramString);
        break label111;
      }
      finally {}
      paramClass.setAccessible(true);
      ((HashMap)localObject1).put(paramString, paramClass);
    }
    label108:
    label111:
    while (paramClass != null)
    {
      try
      {
        paramClass.printStackTrace();
        break;
      }
      finally
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
  
  public static Object a(String paramString1, String paramString2)
  {
    Class localClass1;
    try
    {
      Class localClass2 = (Class)a.get(paramString1);
      localClass1 = localClass2;
      if (localClass2 == null) {
        localClass1 = Class.forName(paramString1);
      }
      a.put(paramString1, localClass1);
    }
    finally {}
    try
    {
      paramString1.printStackTrace();
      localClass1 = null;
      paramString1 = a(localClass1, paramString2, null);
      return paramString1;
    }
    finally
    {
      paramString1.printStackTrace();
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
        int i = 0;
        while (i < paramVarArgs.length)
        {
          localObject2 = paramVarArgs[i];
          ((StringBuffer)localObject1).append("+");
          ((StringBuffer)localObject1).append(((Class)localObject2).getName());
          i += 1;
        }
        str = ((StringBuffer)localObject1).toString();
        localObject2 = (HashMap)c.get(paramClass);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new HashMap();
          c.put(paramClass, localObject1);
        }
        Method localMethod = (Method)((HashMap)localObject1).get(str);
        localObject2 = localMethod;
        if (localMethod != null) {
          continue;
        }
        localObject2 = paramClass.getDeclaredMethod(paramString, paramVarArgs);
      }
      finally
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.transient
 * JD-Core Version:    0.7.0.1
 */