package com.tencent.mtt.abtestsdk.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ReflectionUtil
{
  public static final String TAG = "ReflectionUtil";
  private static HashMap<String, Field> m_fieldCaches = new HashMap();
  private static HashMap<String, Method> m_methodCaches = new HashMap();
  
  private static void addCacheField(Class<?> paramClass, String paramString, Field paramField)
  {
    if ((paramString != null) && (paramField != null))
    {
      paramClass = paramString + "@" + paramClass;
      if (m_fieldCaches.size() > 32) {
        m_fieldCaches.clear();
      }
      m_fieldCaches.put(paramClass, paramField);
    }
  }
  
  private static void addCacheMethod(Class<?> paramClass, String paramString, int paramInt, Method paramMethod)
  {
    if ((paramMethod != null) && (paramString != null))
    {
      paramClass = paramString + "[" + paramInt + "]@" + paramClass;
      if (m_methodCaches.size() > 32) {
        m_methodCaches.clear();
      }
      m_methodCaches.put(paramClass, paramMethod);
    }
  }
  
  private static Field getCacheField(Class<?> paramClass, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (m_fieldCaches.size() > 0)
      {
        paramClass = paramString + "@" + paramClass;
        localObject1 = (Field)m_fieldCaches.get(paramClass);
      }
    }
    return localObject1;
  }
  
  private static Method getCacheMethod(Class<?> paramClass, String paramString, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (m_methodCaches.size() > 0)
      {
        paramClass = paramString + "[" + paramInt + "]@" + paramClass;
        localObject1 = (Method)m_methodCaches.get(paramClass);
      }
    }
    return localObject1;
  }
  
  public static Class<?> getClass(String paramString)
  {
    Class localClass = null;
    if (paramString != null) {}
    try
    {
      localClass = Class.forName(paramString);
      return localClass;
    }
    catch (ClassNotFoundException paramString) {}
    return null;
  }
  
  private static Field getField(Class<?> paramClass, String paramString)
  {
    Object localObject = null;
    try
    {
      Field localField1 = getCacheField(paramClass, paramString);
      localObject = localField1;
      if (localField1 == null)
      {
        localObject = localField1;
        localField1 = paramClass.getField(paramString);
        localObject = localField1;
        localField1.setAccessible(true);
        localObject = localField1;
        addCacheField(paramClass, paramString, localField1);
        localObject = localField1;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException1)
    {
      do
      {
        try
        {
          Field localField2 = paramClass.getDeclaredField(paramString);
          localObject = localField2;
          localField2.setAccessible(true);
          localObject = localField2;
          addCacheField(paramClass, paramString, localField2);
          return localField2;
        }
        catch (NoSuchFieldException localNoSuchFieldException2) {}
      } while (paramClass.getSuperclass() == null);
    }
    return localObject;
    return getField(paramClass.getSuperclass(), paramString);
  }
  
  public static Object getFieldValue(Object paramObject, Class<?> paramClass, String paramString)
  {
    if ((paramObject != null) && (paramClass != null) && (paramString != null))
    {
      paramClass = getField(paramClass, paramString);
      if (paramClass == null) {}
    }
    else
    {
      try
      {
        paramObject = paramClass.get(paramObject);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        try
        {
          paramObject = paramObject.get(paramClass);
          return paramObject;
        }
        catch (Exception paramObject)
        {
          break label61;
        }
        paramObject = paramObject;
      }
      if ((paramObject == null) && (paramClass != null) && (paramString != null))
      {
        paramObject = getField(paramClass, paramString);
        if (paramObject == null) {}
      }
    }
    label61:
    return null;
  }
  
  public static Object getFieldValue(Object paramObject, String paramString)
  {
    return getFieldValue(paramObject, paramObject.getClass(), paramString);
  }
  
  public static Method getMethod(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass)
  {
    Method[] arrayOfMethod1 = null;
    int i;
    if (paramArrayOfClass == null) {
      i = 0;
    }
    int m;
    int j;
    label61:
    Object localObject1;
    Object localObject2;
    int k;
    for (;;)
    {
      Method[] arrayOfMethod2;
      try
      {
        Method localMethod = paramClass.getMethod(paramString, paramArrayOfClass);
        paramArrayOfClass = localMethod;
        return paramArrayOfClass;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        try
        {
          paramArrayOfClass = paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
          return paramArrayOfClass;
        }
        catch (NoSuchMethodException paramArrayOfClass)
        {
          arrayOfMethod2 = paramClass.getMethods();
          if (arrayOfMethod2 == null) {
            break label272;
          }
        }
        m = arrayOfMethod2.length;
        j = 0;
        paramArrayOfClass = null;
      }
      i = paramArrayOfClass.length;
      continue;
      localObject1 = paramArrayOfClass;
      localObject2 = arrayOfMethod1;
      if (j < m)
      {
        localObject2 = arrayOfMethod2[j];
        if (!((Method)localObject2).getName().equalsIgnoreCase(paramString)) {
          break label225;
        }
        if (((Method)localObject2).getParameterTypes() != null) {
          break label214;
        }
        k = 0;
        label105:
        localObject1 = localObject2;
        if (k != i) {
          break label228;
        }
        localObject1 = paramArrayOfClass;
      }
    }
    for (;;)
    {
      paramArrayOfClass = (Class<?>[])localObject1;
      if (localObject2 == null)
      {
        arrayOfMethod1 = paramClass.getDeclaredMethods();
        paramArrayOfClass = (Class<?>[])localObject1;
        if (arrayOfMethod1 != null)
        {
          m = arrayOfMethod1.length;
          j = 0;
          paramClass = (Class<?>)localObject1;
          label151:
          paramArrayOfClass = paramClass;
          if (j < m)
          {
            localObject1 = arrayOfMethod1[j];
            if (((Method)localObject1).getName().equalsIgnoreCase(paramString)) {
              if (((Method)localObject1).getParameterTypes() == null)
              {
                k = 0;
                label190:
                paramArrayOfClass = (Class<?>[])localObject1;
                if (k != i) {
                  break label253;
                }
              }
            }
          }
        }
      }
      for (paramString = (String)localObject1;; paramString = (String)localObject2)
      {
        if (paramString == null)
        {
          paramArrayOfClass = paramClass;
          if (paramClass != null) {
            break;
          }
        }
        return paramString;
        label214:
        k = ((Method)localObject2).getParameterTypes().length;
        break label105;
        label225:
        localObject1 = paramArrayOfClass;
        label228:
        j += 1;
        paramArrayOfClass = (Class<?>[])localObject1;
        break label61;
        k = ((Method)localObject1).getParameterTypes().length;
        break label190;
        paramArrayOfClass = paramClass;
        label253:
        j += 1;
        paramClass = paramArrayOfClass;
        break label151;
        paramClass = paramArrayOfClass;
      }
      label272:
      localObject1 = null;
      localObject2 = arrayOfMethod1;
    }
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
  {
    if (paramArrayOfObject != null) {}
    for (int i = paramArrayOfObject.length;; i = 0)
    {
      Class localClass = paramObject.getClass();
      try
      {
        Method localMethod = getCacheMethod(localClass, paramString, i);
        Object localObject = localMethod;
        if (localMethod == null)
        {
          localObject = paramArrayOfClass;
          if (paramArrayOfObject != null)
          {
            localObject = paramArrayOfClass;
            if (paramArrayOfClass == null)
            {
              paramArrayOfClass = new Class[paramArrayOfObject.length];
              int k = paramArrayOfObject.length;
              int j = 0;
              for (;;)
              {
                localObject = paramArrayOfClass;
                if (j >= k) {
                  break;
                }
                paramArrayOfClass[j] = paramArrayOfObject[j].getClass();
                j += 1;
              }
            }
          }
          paramArrayOfClass = getMethod(localClass, paramString, (Class[])localObject);
          localObject = paramArrayOfClass;
          if (paramArrayOfClass != null)
          {
            paramArrayOfClass.setAccessible(true);
            addCacheMethod(localClass, paramString, i, paramArrayOfClass);
            localObject = paramArrayOfClass;
          }
        }
        if (localObject != null)
        {
          paramObject = ((Method)localObject).invoke(paramObject, paramArrayOfObject);
          return paramObject;
        }
      }
      catch (Exception paramObject)
      {
        ABTestLog.error(paramObject.getMessage(), new Object[0]);
      }
      return null;
    }
  }
  
  public static Object invokeStaticMethod(Class<?> paramClass, String paramString, Object[] paramArrayOfObject)
  {
    Object localObject2 = null;
    int i;
    if (paramArrayOfObject != null) {
      i = paramArrayOfObject.length;
    }
    for (;;)
    {
      try
      {
        Object localObject3 = getCacheMethod(paramClass, paramString, i);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          if (paramArrayOfObject == null) {
            break label150;
          }
          localObject3 = new Class[paramArrayOfObject.length];
          int k = paramArrayOfObject.length;
          int j = 0;
          localObject1 = localObject3;
          if (j < k)
          {
            localObject3[j] = paramArrayOfObject[j].getClass();
            j += 1;
            continue;
          }
          localObject3 = getMethod(paramClass, paramString, localObject1);
          localObject1 = localObject3;
          if (localObject3 != null)
          {
            ((Method)localObject3).setAccessible(true);
            addCacheMethod(paramClass, paramString, i, (Method)localObject3);
            localObject1 = localObject3;
          }
        }
        paramClass = localObject2;
        if (localObject1 != null) {
          paramClass = localObject1.invoke(null, paramArrayOfObject);
        }
        return paramClass;
      }
      catch (Exception paramClass)
      {
        ABTestLog.warn(paramClass.getMessage(), new Object[0]);
        return null;
      }
      i = 0;
      continue;
      label150:
      Object localObject1 = null;
    }
  }
  
  public static boolean isRecursiveCall(String paramString)
  {
    boolean bool = false;
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
        if (arrayOfStackTraceElement != null)
        {
          int i = 2;
          int k = 0;
          if (i < arrayOfStackTraceElement.length)
          {
            StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
            bool = paramString.equalsIgnoreCase(localStackTraceElement.getClassName() + "." + localStackTraceElement.getMethodName());
            int j = k;
            if (bool)
            {
              k += 1;
              j = k;
              if (k > 1)
              {
                bool = true;
                return bool;
              }
            }
            i += 1;
            k = j;
            continue;
          }
        }
        bool = false;
      }
      catch (Throwable paramString)
      {
        return false;
      }
    }
  }
  
  public static boolean setFieldValue(Class paramClass, String paramString, Object paramObject)
  {
    if ((paramClass != null) && (paramString != null))
    {
      paramString = getField(paramClass, paramString);
      if (paramString != null) {
        try
        {
          paramString.setAccessible(true);
          paramString.set(paramClass, paramObject);
          return true;
        }
        catch (Exception paramClass)
        {
          return false;
        }
      }
    }
    return false;
  }
  
  public static boolean setFieldValue(Object paramObject1, String paramString, Object paramObject2)
  {
    if ((paramObject1 != null) && (paramString != null))
    {
      paramString = getField(paramObject1.getClass(), paramString);
      if (paramString != null) {
        try
        {
          paramString.setAccessible(true);
          paramString.set(paramObject1, paramObject2);
          return true;
        }
        catch (Exception paramObject1)
        {
          return false;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.utils.ReflectionUtil
 * JD-Core Version:    0.7.0.1
 */