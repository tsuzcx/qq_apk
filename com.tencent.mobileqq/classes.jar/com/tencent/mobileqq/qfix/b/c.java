package com.tencent.mobileqq.qfix.b;

import android.content.Context;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class c
{
  public static int a(Class<?> paramClass, String paramString, int paramInt)
  {
    try
    {
      int i = a(paramClass, paramString).getInt(null);
      return i;
    }
    catch (Throwable paramClass) {}
    return paramInt;
  }
  
  public static Object a(Context paramContext, Class<?> paramClass)
  {
    Object localObject = paramClass;
    if (paramClass == null) {}
    try
    {
      localObject = Class.forName("android.app.ActivityThread");
      paramClass = ((Class)localObject).getMethod("currentActivityThread", new Class[0]);
      paramClass.setAccessible(true);
      localObject = paramClass.invoke(null, new Object[0]);
      paramClass = (Class<?>)localObject;
      if (localObject == null)
      {
        paramClass = (Class<?>)localObject;
        if (paramContext != null)
        {
          paramClass = paramContext.getClass().getField("mLoadedApk");
          paramClass.setAccessible(true);
          paramContext = paramClass.get(paramContext);
          paramClass = paramContext.getClass().getDeclaredField("mActivityThread");
          paramClass.setAccessible(true);
          paramClass = paramClass.get(paramContext);
        }
      }
      return paramClass;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static Constructor<?> a(Object paramObject, Class<?>... paramVarArgs)
  {
    for (Object localObject = paramObject.getClass(); localObject != null; localObject = ((Class)localObject).getSuperclass()) {
      try
      {
        Constructor localConstructor = ((Class)localObject).getDeclaredConstructor(paramVarArgs);
        if (!localConstructor.isAccessible()) {
          localConstructor.setAccessible(true);
        }
        return localConstructor;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        label29:
        break label29;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Constructor with parameters ");
    ((StringBuilder)localObject).append(Arrays.asList(paramVarArgs));
    ((StringBuilder)localObject).append(" not found in ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    paramObject = new NoSuchMethodException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public static Field a(Class<?> paramClass, String paramString)
  {
    for (Object localObject = paramClass; localObject != null; localObject = ((Class)localObject).getSuperclass()) {
      try
      {
        Field localField = ((Class)localObject).getDeclaredField(paramString);
        if (!localField.isAccessible()) {
          localField.setAccessible(true);
        }
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        label26:
        break label26;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Field ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" not found in ");
    ((StringBuilder)localObject).append(paramClass);
    paramClass = new NoSuchFieldException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public static Field a(Object paramObject, String paramString)
  {
    for (Object localObject = paramObject.getClass(); localObject != null; localObject = ((Class)localObject).getSuperclass()) {
      try
      {
        Field localField = ((Class)localObject).getDeclaredField(paramString);
        if (!localField.isAccessible()) {
          localField.setAccessible(true);
        }
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        label29:
        break label29;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Field ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" not found in ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    paramObject = new NoSuchFieldException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public static Method a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    while (paramClass != null)
    {
      try
      {
        localObject = paramClass.getDeclaredMethod(paramString, paramVarArgs);
        if (!((Method)localObject).isAccessible()) {
          ((Method)localObject).setAccessible(true);
        }
        return localObject;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Object localObject;
        label25:
        break label25;
      }
      paramClass = paramClass.getSuperclass();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Method ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" with parameters ");
    ((StringBuilder)localObject).append(Arrays.asList(paramVarArgs));
    ((StringBuilder)localObject).append(" not found in ");
    ((StringBuilder)localObject).append(paramClass);
    paramClass = new NoSuchMethodException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public static Method a(Object paramObject, String paramString, Class<?>... paramVarArgs)
  {
    for (Object localObject = paramObject.getClass(); localObject != null; localObject = ((Class)localObject).getSuperclass()) {
      try
      {
        Method localMethod = ((Class)localObject).getDeclaredMethod(paramString, paramVarArgs);
        if (!localMethod.isAccessible()) {
          localMethod.setAccessible(true);
        }
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        label34:
        break label34;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Method ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" with parameters ");
    ((StringBuilder)localObject).append(Arrays.asList(paramVarArgs));
    ((StringBuilder)localObject).append(" not found in ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    paramObject = new NoSuchMethodException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public static void a(Object paramObject, String paramString, int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    paramString = a(paramObject, paramString);
    Object[] arrayOfObject1 = (Object[])paramString.get(paramObject);
    int i = arrayOfObject1.length - paramInt;
    if (i <= 0) {
      return;
    }
    Object[] arrayOfObject2 = (Object[])Array.newInstance(arrayOfObject1.getClass().getComponentType(), i);
    System.arraycopy(arrayOfObject1, paramInt, arrayOfObject2, 0, i);
    paramString.set(paramObject, arrayOfObject2);
  }
  
  public static void a(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    paramString = a(paramObject, paramString);
    Object[] arrayOfObject1 = (Object[])paramString.get(paramObject);
    Object[] arrayOfObject2 = (Object[])Array.newInstance(arrayOfObject1.getClass().getComponentType(), arrayOfObject1.length + paramArrayOfObject.length);
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject2, 0, paramArrayOfObject.length);
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, paramArrayOfObject.length, arrayOfObject1.length);
    paramString.set(paramObject, arrayOfObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qfix.b.c
 * JD-Core Version:    0.7.0.1
 */