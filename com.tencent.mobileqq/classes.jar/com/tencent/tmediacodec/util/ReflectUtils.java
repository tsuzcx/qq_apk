package com.tencent.tmediacodec.util;

import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReflectUtils
{
  public static final Object[] EMPTY_PARAMS = new Object[0];
  public static final Class<?>[] EMPTY_PARAM_TYPES = new Class[0];
  
  public static String getClassName(Class<?> paramClass)
  {
    paramClass = paramClass.getName();
    return paramClass.substring(paramClass.lastIndexOf('.') + 1);
  }
  
  public static Constructor<?> getConstructor(Class<?> paramClass, boolean paramBoolean1, boolean paramBoolean2, Class<?>... paramVarArgs)
  {
    localObject2 = null;
    localObject1 = null;
    if (paramBoolean1) {}
    try
    {
      return paramClass.getDeclaredConstructor(paramVarArgs);
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      Constructor localConstructor;
      if (!paramBoolean2) {
        break label100;
      }
      Class localClass = paramClass.getSuperclass();
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 != null) {
          break;
        }
        localObject2 = localObject1;
        if (localClass == null) {
          break;
        }
        if (paramBoolean1) {}
        try
        {
          localObject2 = paramClass.getDeclaredConstructor(paramVarArgs);
          localObject1 = localObject2;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          localClass = localClass.getSuperclass();
        }
        localObject2 = paramClass.getConstructor(paramVarArgs);
        localObject1 = localObject2;
      }
      return localNoSuchMethodException2;
    }
    localConstructor = paramClass.getConstructor(paramVarArgs);
    return localConstructor;
  }
  
  public static List<Constructor<?>> getConstructors(Class<?> paramClass, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    int j;
    if (paramBoolean2)
    {
      List localList = getSuperClasss(paramClass, true);
      int k;
      if (paramBoolean3)
      {
        i = localList.size() - 1;
        while (i > -1)
        {
          if (paramBoolean1) {}
          for (paramClass = ((Class)localList.get(i)).getDeclaredConstructors();; paramClass = ((Class)localList.get(i)).getConstructors())
          {
            k = paramClass.length;
            j = 0;
            while (j < k)
            {
              localArrayList.add(paramClass[j]);
              j += 1;
            }
          }
          i -= 1;
        }
      }
      i = 0;
      while (i < localList.size())
      {
        if (paramBoolean1) {}
        for (paramClass = ((Class)localList.get(i)).getDeclaredConstructors();; paramClass = ((Class)localList.get(i)).getConstructors())
        {
          k = paramClass.length;
          j = 0;
          while (j < k)
          {
            localArrayList.add(paramClass[j]);
            j += 1;
          }
        }
        i += 1;
      }
    }
    if (paramBoolean1) {}
    for (paramClass = paramClass.getDeclaredConstructors();; paramClass = paramClass.getConstructors())
    {
      j = paramClass.length;
      while (i < j)
      {
        localArrayList.add(paramClass[i]);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static Field getField(Class<?> paramClass, String paramString)
  {
    return getField(paramClass, paramString, true, true);
  }
  
  public static Field getField(Class<?> paramClass, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    localObject1 = null;
    localObject2 = null;
    if (paramBoolean1) {}
    try
    {
      return paramClass.getDeclaredField(paramString);
    }
    catch (NoSuchFieldException localNoSuchFieldException1)
    {
      Field localField;
      if (!paramBoolean2) {
        break label100;
      }
      Class localClass = paramClass.getSuperclass();
      paramClass = localObject2;
      for (;;)
      {
        localObject1 = paramClass;
        if (paramClass != null) {
          break;
        }
        localObject1 = paramClass;
        if (localClass == null) {
          break;
        }
        if (paramBoolean1) {}
        try
        {
          localObject1 = localClass.getDeclaredField(paramString);
          paramClass = (Class<?>)localObject1;
        }
        catch (NoSuchFieldException localNoSuchFieldException2)
        {
          localClass = localClass.getSuperclass();
        }
        localObject1 = localClass.getField(paramString);
        paramClass = (Class<?>)localObject1;
      }
      return localNoSuchFieldException2;
    }
    localField = paramClass.getField(paramString);
    return localField;
  }
  
  public static List<Field> getFields(Class<?> paramClass)
  {
    return getFields(paramClass, true, true, true, true);
  }
  
  public static List<Field> getFields(Class<?> paramClass, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    int j;
    if (paramBoolean2)
    {
      Object localObject;
      int k;
      if (paramBoolean3)
      {
        paramClass = getSuperClasss(paramClass, true);
        if (paramBoolean4) {
          i = paramClass.size() - 1;
        }
      }
      else
      {
        for (;;)
        {
          if (i <= -1) {
            break label323;
          }
          if (paramBoolean1) {}
          for (localObject = ((Class)paramClass.get(i)).getDeclaredFields();; localObject = ((Class)paramClass.get(i)).getFields())
          {
            k = localObject.length;
            j = 0;
            while (j < k)
            {
              localArrayList.add(localObject[j]);
              j += 1;
            }
            localObject = new ArrayList(2);
            ((List)localObject).add(paramClass);
            paramClass = paramClass.getSuperclass();
            if (paramClass != null) {
              ((List)localObject).add(paramClass);
            }
            paramClass = (Class<?>)localObject;
            break;
          }
          i -= 1;
        }
      }
      i = 0;
      while (i < paramClass.size())
      {
        if (paramBoolean1) {}
        for (localObject = ((Class)paramClass.get(i)).getDeclaredFields();; localObject = ((Class)paramClass.get(i)).getFields())
        {
          k = localObject.length;
          j = 0;
          while (j < k)
          {
            localArrayList.add(localObject[j]);
            j += 1;
          }
        }
        i += 1;
      }
    }
    if (paramBoolean1) {}
    for (paramClass = paramClass.getDeclaredFields();; paramClass = paramClass.getFields())
    {
      j = paramClass.length;
      while (i < j)
      {
        localArrayList.add(paramClass[i]);
        i += 1;
      }
    }
    label323:
    return localArrayList;
  }
  
  public static Method getMethod(Class<?> paramClass, String paramString)
  {
    return getMethod(paramClass, paramString, EMPTY_PARAM_TYPES);
  }
  
  public static Method getMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    return getMethod(paramClass, true, true, paramString, paramVarArgs);
  }
  
  public static Method getMethod(Class<?> paramClass, boolean paramBoolean1, boolean paramBoolean2, String paramString, Class<?>... paramVarArgs)
  {
    localObject1 = null;
    localObject2 = null;
    if (paramBoolean1) {}
    try
    {
      return paramClass.getDeclaredMethod(paramString, paramVarArgs);
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      Method localMethod;
      if (!paramBoolean2) {
        break label108;
      }
      Class localClass = paramClass.getSuperclass();
      paramClass = localObject2;
      for (;;)
      {
        localObject1 = paramClass;
        if (paramClass != null) {
          break;
        }
        localObject1 = paramClass;
        if (localClass == null) {
          break;
        }
        if (paramBoolean1) {}
        try
        {
          localObject1 = localClass.getDeclaredMethod(paramString, paramVarArgs);
          paramClass = (Class<?>)localObject1;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          localClass = localClass.getSuperclass();
        }
        localObject1 = localClass.getMethod(paramString, paramVarArgs);
        paramClass = (Class<?>)localObject1;
      }
      return localNoSuchMethodException2;
    }
    localMethod = paramClass.getMethod(paramString, paramVarArgs);
    return localMethod;
  }
  
  public static List<Method> getMethods(Class<?> paramClass)
  {
    return getMethods(paramClass, true, true, true);
  }
  
  public static List<Method> getMethods(Class<?> paramClass, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    int j;
    if (paramBoolean2)
    {
      List localList = getSuperClasss(paramClass, true);
      int k;
      if (paramBoolean3)
      {
        i = localList.size() - 1;
        while (i > -1)
        {
          if (paramBoolean1) {}
          for (paramClass = ((Class)localList.get(i)).getDeclaredMethods();; paramClass = ((Class)localList.get(i)).getMethods())
          {
            k = paramClass.length;
            j = 0;
            while (j < k)
            {
              localArrayList.add(paramClass[j]);
              j += 1;
            }
          }
          i -= 1;
        }
      }
      i = 0;
      while (i < localList.size())
      {
        if (paramBoolean1) {}
        for (paramClass = ((Class)localList.get(i)).getDeclaredMethods();; paramClass = ((Class)localList.get(i)).getMethods())
        {
          k = paramClass.length;
          j = 0;
          while (j < k)
          {
            localArrayList.add(paramClass[j]);
            j += 1;
          }
        }
        i += 1;
      }
    }
    if (paramBoolean1) {}
    for (paramClass = paramClass.getDeclaredMethods();; paramClass = paramClass.getMethods())
    {
      j = paramClass.length;
      while (i < j)
      {
        localArrayList.add(paramClass[i]);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static <T> T getObjectByFieldName(Object paramObject, String paramString, Class<T> paramClass)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramObject != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = localObject2;
        if (paramClass == null) {}
      }
    }
    try
    {
      paramString = getField(paramObject.getClass(), paramString, true, true);
      localObject1 = localObject2;
      if (paramString != null)
      {
        paramString.setAccessible(true);
        localObject1 = paramString.get(paramObject);
      }
      return localObject1;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  public static List<Class<?>> getSuperClasss(Class<?> paramClass, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    while (paramClass != null)
    {
      localArrayList.add(paramClass);
      paramClass = paramClass.getSuperclass();
      continue;
      paramClass = paramClass.getSuperclass();
    }
    return localArrayList;
  }
  
  public static Method getValueOfMethod(Class<?> paramClass, Class<?>... paramVarArgs)
  {
    return getMethod(paramClass, true, true, "valueOf", paramVarArgs);
  }
  
  public static Object invokeMethod(Method paramMethod, Object paramObject)
  {
    return paramMethod.invoke(paramObject, EMPTY_PARAMS);
  }
  
  public static Object invokeMethod(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    return paramMethod.invoke(paramObject, paramVarArgs);
  }
  
  public static final boolean isArrayByType(Field paramField, Class<?> paramClass)
  {
    paramField = paramField.getType();
    return (paramField.isArray()) && (paramClass.isAssignableFrom(paramField.getComponentType()));
  }
  
  public static final boolean isCollectionByType(Field paramField, Class<? extends Collection> paramClass, Class<?> paramClass1)
  {
    if (paramClass.isAssignableFrom(paramField.getType())) {
      return paramClass1.isAssignableFrom((Class)((java.lang.reflect.ParameterizedType)paramField.getGenericType()).getActualTypeArguments()[0]);
    }
    return false;
  }
  
  public static boolean setField(Object paramObject1, String paramString, Object paramObject2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = getField(paramObject1.getClass(), paramString, paramBoolean1, paramBoolean2);
    if (paramString != null) {
      try
      {
        paramString.setAccessible(true);
        paramString.set(paramObject1, paramObject2);
        return true;
      }
      catch (IllegalAccessException paramObject1)
      {
        paramObject1.printStackTrace();
        return false;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.util.ReflectUtils
 * JD-Core Version:    0.7.0.1
 */