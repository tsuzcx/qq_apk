package com.tencent.timi.game.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtils
{
  public static String a = "ReflectionUtils";
  
  public static Object a(Class paramClass, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramClass = paramClass.getMethod(paramString, paramArrayOfClass).invoke(null, paramArrayOfObject);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      Logger.a(a, paramClass.toString(), paramClass);
      return null;
    }
    catch (InvocationTargetException paramClass)
    {
      Logger.a(a, paramClass.toString(), paramClass);
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      Logger.a(a, paramClass.toString(), paramClass);
      return null;
    }
    catch (IllegalArgumentException paramClass)
    {
      Logger.a(a, paramClass.toString(), paramClass);
    }
    return null;
  }
  
  public static Object a(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    paramString = a(paramObject, paramString, paramArrayOfClass);
    if (paramString != null) {
      try
      {
        paramString.setAccessible(true);
        if (paramArrayOfObject == null) {
          return paramString.invoke(paramObject, new Object[0]);
        }
        paramObject = paramString.invoke(paramObject, paramArrayOfObject);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        Logger.a(a, paramObject.toString(), paramObject);
      }
      catch (InvocationTargetException paramObject)
      {
        Logger.a(a, paramObject.toString(), paramObject);
      }
      catch (IllegalAccessException paramObject)
      {
        Logger.a(a, paramObject.toString(), paramObject);
      }
      catch (IllegalArgumentException paramObject)
      {
        Logger.a(a, paramObject.toString(), paramObject);
      }
    }
    return null;
  }
  
  public static Field a(Object paramObject, String paramString)
  {
    for (paramObject = paramObject.getClass(); paramObject != Object.class; paramObject = paramObject.getSuperclass()) {
      try
      {
        Field localField = paramObject.getDeclaredField(paramString);
        return localField;
      }
      catch (Exception localException)
      {
        label19:
        break label19;
      }
    }
    return null;
  }
  
  public static Method a(Object paramObject, String paramString, Class<?>... paramVarArgs)
  {
    for (paramObject = paramObject.getClass(); paramObject != Object.class; paramObject = paramObject.getSuperclass()) {
      try
      {
        Method localMethod = paramObject.getDeclaredMethod(paramString, paramVarArgs);
        return localMethod;
      }
      catch (Exception localException)
      {
        label20:
        break label20;
      }
    }
    paramObject = a;
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("no such method ");
    paramVarArgs.append(paramString);
    Logger.c(paramObject, paramVarArgs.toString());
    return null;
  }
  
  public static void a(Object paramObject1, String paramString, Object paramObject2)
  {
    paramString = a(paramObject1, paramString);
    if (paramString != null) {
      try
      {
        paramString.setAccessible(true);
        if ((paramString.getType().equals(Integer.TYPE)) && ((paramObject2 instanceof Long)))
        {
          paramString.set(paramObject1, Integer.valueOf(((Long)paramObject2).intValue()));
          return;
        }
        paramString.set(paramObject1, paramObject2);
        return;
      }
      catch (Exception paramObject1)
      {
        paramObject1.printStackTrace();
      }
    }
  }
  
  public static Object b(Object paramObject, String paramString, Class<?>[] paramArrayOfClass)
  {
    return a(paramObject, paramString, paramArrayOfClass, (Object[])null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.ReflectionUtils
 * JD-Core Version:    0.7.0.1
 */