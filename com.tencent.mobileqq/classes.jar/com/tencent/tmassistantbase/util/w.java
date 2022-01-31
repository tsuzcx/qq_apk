package com.tencent.tmassistantbase.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class w
{
  private final Object a;
  private final boolean b;
  
  private w(Class<?> paramClass)
  {
    this.a = paramClass;
    this.b = true;
  }
  
  private w(Object paramObject)
  {
    this.a = paramObject;
    this.b = false;
  }
  
  public static w a(Class<?> paramClass)
  {
    return new w(paramClass);
  }
  
  public static w a(Object paramObject)
  {
    return new w(paramObject);
  }
  
  public static w a(String paramString)
  {
    return a(f(paramString));
  }
  
  private static w a(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      a(paramMethod);
      if (paramMethod.getReturnType() == Void.TYPE)
      {
        paramMethod.invoke(paramObject, paramVarArgs);
        return a(paramObject);
      }
      paramMethod = a(paramMethod.invoke(paramObject, paramVarArgs));
      return paramMethod;
    }
    catch (Exception paramMethod)
    {
      throw new ReflectException(paramMethod);
    }
  }
  
  public static <T extends AccessibleObject> T a(T paramT)
  {
    T ?;
    if (paramT == null) {
      ? = null;
    }
    do
    {
      Member localMember;
      do
      {
        return ?;
        if (!(paramT instanceof Member)) {
          break;
        }
        localMember = (Member)paramT;
        if (!Modifier.isPublic(localMember.getModifiers())) {
          break;
        }
        ? = paramT;
      } while (Modifier.isPublic(localMember.getDeclaringClass().getModifiers()));
      ? = paramT;
    } while (paramT.isAccessible());
    paramT.setAccessible(true);
    return paramT;
  }
  
  private Method a(String paramString, Class<?>[] paramArrayOfClass)
  {
    Object localObject = b();
    try
    {
      Method localMethod1 = ((Class)localObject).getMethod(paramString, paramArrayOfClass);
      return localMethod1;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      Class localClass;
      do
      {
        try
        {
          Method localMethod2 = ((Class)localObject).getDeclaredMethod(paramString, paramArrayOfClass);
          return localMethod2;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          localClass = ((Class)localObject).getSuperclass();
          localObject = localClass;
        }
      } while (localClass != null);
      throw new NoSuchMethodException();
    }
  }
  
  private boolean a(Method paramMethod, String paramString, Class<?>[] paramArrayOfClass)
  {
    return (paramMethod.getName().equals(paramString)) && (a(paramMethod.getParameterTypes(), paramArrayOfClass));
  }
  
  private boolean a(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    if (paramArrayOfClass1.length == paramArrayOfClass2.length)
    {
      int i = 0;
      if (i < paramArrayOfClass2.length)
      {
        if (paramArrayOfClass2[i] == x.class) {}
        while (b(paramArrayOfClass1[i]).isAssignableFrom(b(paramArrayOfClass2[i])))
        {
          i += 1;
          break;
        }
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  private static Class<?>[] a(Object... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs == null) {
      return new Class[0];
    }
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    if (i < paramVarArgs.length)
    {
      Object localObject = paramVarArgs[i];
      if (localObject == null) {}
      for (localObject = x.class;; localObject = localObject.getClass())
      {
        arrayOfClass[i] = localObject;
        i += 1;
        break;
      }
    }
    return arrayOfClass;
  }
  
  public static Class<?> b(Class<?> paramClass)
  {
    Class<?> localClass;
    if (paramClass == null) {
      localClass = null;
    }
    do
    {
      do
      {
        return localClass;
        localClass = paramClass;
      } while (!paramClass.isPrimitive());
      if (Boolean.TYPE == paramClass) {
        return Boolean.class;
      }
      if (Integer.TYPE == paramClass) {
        return Integer.class;
      }
      if (Long.TYPE == paramClass) {
        return Long.class;
      }
      if (Short.TYPE == paramClass) {
        return Short.class;
      }
      if (Byte.TYPE == paramClass) {
        return Byte.class;
      }
      if (Double.TYPE == paramClass) {
        return Double.class;
      }
      if (Float.TYPE == paramClass) {
        return Float.class;
      }
      if (Character.TYPE == paramClass) {
        return Character.class;
      }
      localClass = paramClass;
    } while (Void.TYPE != paramClass);
    return Void.class;
  }
  
  private Method b(String paramString, Class<?>[] paramArrayOfClass)
  {
    Object localObject2 = b();
    Method[] arrayOfMethod = ((Class)localObject2).getMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    Object localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      if (i >= j) {
        break;
      }
      localObject1 = arrayOfMethod[i];
      if (a((Method)localObject1, paramString, paramArrayOfClass)) {
        return localObject1;
      }
      i += 1;
    }
    do
    {
      localObject2 = ((Class)localObject1).getDeclaredMethods();
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        arrayOfMethod = localObject2[i];
        if (a(arrayOfMethod, paramString, paramArrayOfClass)) {
          return arrayOfMethod;
        }
        i += 1;
      }
      localObject2 = ((Class)localObject1).getSuperclass();
      localObject1 = localObject2;
    } while (localObject2 != null);
    throw new NoSuchMethodException("No similar method " + paramString + " with params " + Arrays.toString(paramArrayOfClass) + " could be found on type " + b() + ".");
  }
  
  private Field e(String paramString)
  {
    Class localClass = b();
    try
    {
      Field localField1 = (Field)a(localClass.getField(paramString));
      return localField1;
    }
    catch (NoSuchFieldException localNoSuchFieldException1) {}
    for (;;)
    {
      try
      {
        Field localField2 = (Field)a(localClass.getDeclaredField(paramString));
        return localField2;
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        localClass = localClass.getSuperclass();
        if (localClass == null) {
          throw new ReflectException(localNoSuchFieldException1);
        }
      }
    }
  }
  
  private static Class<?> f(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new ReflectException(paramString);
    }
  }
  
  public w a(String paramString, Object... paramVarArgs)
  {
    Class[] arrayOfClass = a(paramVarArgs);
    try
    {
      w localw = a(a(paramString, arrayOfClass), this.a, paramVarArgs);
      return localw;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      try
      {
        paramString = a(b(paramString, arrayOfClass), this.a, paramVarArgs);
        return paramString;
      }
      catch (NoSuchMethodException paramString)
      {
        throw new ReflectException(paramString);
      }
    }
  }
  
  public <T> T a()
  {
    return this.a;
  }
  
  public Class<?> b()
  {
    if (this.b) {
      return (Class)this.a;
    }
    return this.a.getClass();
  }
  
  public <T> T b(String paramString)
  {
    return c(paramString).a();
  }
  
  public w c(String paramString)
  {
    try
    {
      paramString = a(e(paramString).get(this.a));
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new ReflectException(paramString);
    }
  }
  
  public w d(String paramString)
  {
    return a(paramString, new Object[0]);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof w)) {
      return this.a.equals(((w)paramObject).a());
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.w
 * JD-Core Version:    0.7.0.1
 */