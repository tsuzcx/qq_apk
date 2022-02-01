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
    Object localObject3 = null;
    Object localObject1 = null;
    if (paramBoolean1) {}
    try
    {
      localObject2 = paramClass.getDeclaredConstructor(paramVarArgs);
      paramClass = (Class<?>)localObject2;
      break label33;
      localObject2 = paramClass.getConstructor(paramVarArgs);
      paramClass = (Class<?>)localObject2;
      label33:
      return paramClass;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      Object localObject2;
      label35:
      label95:
      break label35;
    }
    if (paramBoolean2)
    {
      localObject2 = paramClass.getSuperclass();
      for (;;)
      {
        localObject3 = localObject1;
        if (localObject1 != null) {
          break;
        }
        localObject3 = localObject1;
        if ((localObject2 == null) || (paramBoolean1)) {}
        try
        {
          localObject3 = paramClass.getDeclaredConstructor(paramVarArgs);
          localObject1 = localObject3;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          break label95;
        }
        localObject3 = paramClass.getConstructor(paramVarArgs);
        localObject1 = localObject3;
        continue;
        localObject2 = ((Class)localObject2).getSuperclass();
      }
    }
    return localObject3;
  }
  
  public static List<Constructor<?>> getConstructors(Class<?> paramClass, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (paramBoolean2)
    {
      List localList = getSuperClasss(paramClass, true);
      int k;
      if (paramBoolean3)
      {
        i = localList.size() - 1;
        while (i > -1)
        {
          if (paramBoolean1) {
            paramClass = ((Class)localList.get(i)).getDeclaredConstructors();
          } else {
            paramClass = ((Class)localList.get(i)).getConstructors();
          }
          k = paramClass.length;
          j = 0;
          while (j < k)
          {
            localArrayList.add(paramClass[j]);
            j += 1;
          }
          i -= 1;
        }
      }
      i = 0;
      while (i < localList.size())
      {
        if (paramBoolean1) {
          paramClass = ((Class)localList.get(i)).getDeclaredConstructors();
        } else {
          paramClass = ((Class)localList.get(i)).getConstructors();
        }
        k = paramClass.length;
        j = 0;
        while (j < k)
        {
          localArrayList.add(paramClass[j]);
          j += 1;
        }
        i += 1;
      }
    }
    if (paramBoolean1) {
      paramClass = paramClass.getDeclaredConstructors();
    } else {
      paramClass = paramClass.getConstructors();
    }
    int j = paramClass.length;
    while (i < j)
    {
      localArrayList.add(paramClass[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public static Field getField(Class<?> paramClass, String paramString)
  {
    return getField(paramClass, paramString, true, true);
  }
  
  public static Field getField(Class<?> paramClass, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    if (paramBoolean1) {}
    try
    {
      localObject1 = paramClass.getDeclaredField(paramString);
      paramClass = (Class<?>)localObject1;
      break label33;
      localObject1 = paramClass.getField(paramString);
      paramClass = (Class<?>)localObject1;
      label33:
      return paramClass;
    }
    catch (NoSuchFieldException localNoSuchFieldException1)
    {
      Object localObject1;
      label35:
      label92:
      label95:
      break label35;
    }
    if (paramBoolean2)
    {
      localObject1 = paramClass.getSuperclass();
      paramClass = localObject3;
      for (;;)
      {
        localObject2 = paramClass;
        if (paramClass != null) {
          break;
        }
        localObject2 = paramClass;
        if ((localObject1 == null) || (paramBoolean1)) {}
        try
        {
          localObject2 = ((Class)localObject1).getDeclaredField(paramString);
          paramClass = (Class<?>)localObject2;
          break label92;
          localObject2 = ((Class)localObject1).getField(paramString);
          paramClass = (Class<?>)localObject2;
        }
        catch (NoSuchFieldException localNoSuchFieldException2)
        {
          break label95;
        }
        localObject1 = ((Class)localObject1).getSuperclass();
      }
    }
    return localObject2;
  }
  
  public static List<Field> getFields(Class<?> paramClass)
  {
    return getFields(paramClass, true, true, true, true);
  }
  
  public static List<Field> getFields(Class<?> paramClass, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (paramBoolean2)
    {
      Object localObject;
      if (paramBoolean3)
      {
        paramClass = getSuperClasss(paramClass, true);
      }
      else
      {
        localObject = new ArrayList(2);
        ((List)localObject).add(paramClass);
        paramClass = paramClass.getSuperclass();
        if (paramClass != null) {
          ((List)localObject).add(paramClass);
        }
        paramClass = (Class<?>)localObject;
      }
      int k;
      if (paramBoolean4)
      {
        i = paramClass.size() - 1;
        while (i > -1)
        {
          if (paramBoolean1) {
            localObject = ((Class)paramClass.get(i)).getDeclaredFields();
          } else {
            localObject = ((Class)paramClass.get(i)).getFields();
          }
          k = localObject.length;
          j = 0;
          while (j < k)
          {
            localArrayList.add(localObject[j]);
            j += 1;
          }
          i -= 1;
        }
      }
      i = 0;
      while (i < paramClass.size())
      {
        if (paramBoolean1) {
          localObject = ((Class)paramClass.get(i)).getDeclaredFields();
        } else {
          localObject = ((Class)paramClass.get(i)).getFields();
        }
        k = localObject.length;
        j = 0;
        while (j < k)
        {
          localArrayList.add(localObject[j]);
          j += 1;
        }
        i += 1;
      }
    }
    if (paramBoolean1) {
      paramClass = paramClass.getDeclaredFields();
    } else {
      paramClass = paramClass.getFields();
    }
    int j = paramClass.length;
    while (i < j)
    {
      localArrayList.add(paramClass[i]);
      i += 1;
    }
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
    Object localObject2 = null;
    Object localObject3 = null;
    if (paramBoolean1) {}
    try
    {
      localObject1 = paramClass.getDeclaredMethod(paramString, paramVarArgs);
      paramClass = (Class<?>)localObject1;
      break label37;
      localObject1 = paramClass.getMethod(paramString, paramVarArgs);
      paramClass = (Class<?>)localObject1;
      label37:
      return paramClass;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      Object localObject1;
      label39:
      label100:
      label103:
      break label39;
    }
    if (paramBoolean2)
    {
      localObject1 = paramClass.getSuperclass();
      paramClass = localObject3;
      for (;;)
      {
        localObject2 = paramClass;
        if (paramClass != null) {
          break;
        }
        localObject2 = paramClass;
        if ((localObject1 == null) || (paramBoolean1)) {}
        try
        {
          localObject2 = ((Class)localObject1).getDeclaredMethod(paramString, paramVarArgs);
          paramClass = (Class<?>)localObject2;
          break label100;
          localObject2 = ((Class)localObject1).getMethod(paramString, paramVarArgs);
          paramClass = (Class<?>)localObject2;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          break label103;
        }
        localObject1 = ((Class)localObject1).getSuperclass();
      }
    }
    return localObject2;
  }
  
  public static List<Method> getMethods(Class<?> paramClass)
  {
    return getMethods(paramClass, true, true, true);
  }
  
  public static List<Method> getMethods(Class<?> paramClass, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (paramBoolean2)
    {
      List localList = getSuperClasss(paramClass, true);
      int k;
      if (paramBoolean3)
      {
        i = localList.size() - 1;
        while (i > -1)
        {
          if (paramBoolean1) {
            paramClass = ((Class)localList.get(i)).getDeclaredMethods();
          } else {
            paramClass = ((Class)localList.get(i)).getMethods();
          }
          k = paramClass.length;
          j = 0;
          while (j < k)
          {
            localArrayList.add(paramClass[j]);
            j += 1;
          }
          i -= 1;
        }
      }
      i = 0;
      while (i < localList.size())
      {
        if (paramBoolean1) {
          paramClass = ((Class)localList.get(i)).getDeclaredMethods();
        } else {
          paramClass = ((Class)localList.get(i)).getMethods();
        }
        k = paramClass.length;
        j = 0;
        while (j < k)
        {
          localArrayList.add(paramClass[j]);
          j += 1;
        }
        i += 1;
      }
    }
    if (paramBoolean1) {
      paramClass = paramClass.getDeclaredMethods();
    } else {
      paramClass = paramClass.getMethods();
    }
    int j = paramClass.length;
    while (i < j)
    {
      localArrayList.add(paramClass[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public static <T> T getObjectByFieldName(Object paramObject, String paramString, Class<T> paramClass)
  {
    if ((paramObject != null) && (!TextUtils.isEmpty(paramString)) && (paramClass != null)) {
      try
      {
        paramString = getField(paramObject.getClass(), paramString, true, true);
        if (paramString != null)
        {
          paramString.setAccessible(true);
          paramObject = paramString.get(paramObject);
          return paramObject;
        }
        return null;
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
      }
    }
    return null;
  }
  
  public static List<Class<?>> getSuperClasss(Class<?> paramClass, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (!paramBoolean) {}
    for (paramClass = paramClass.getSuperclass(); paramClass != null; paramClass = paramClass.getSuperclass()) {
      localArrayList.add(paramClass);
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
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmediacodec.util.ReflectUtils
 * JD-Core Version:    0.7.0.1
 */