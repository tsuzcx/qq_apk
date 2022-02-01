package org.aspectj.lang;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Aspects
{
  private static final String ASPECTOF = "aspectOf";
  private static final Class[] EMPTY_CLASS_ARRAY = new Class[0];
  private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
  private static final String HASASPECT = "hasAspect";
  private static final Class[] PEROBJECT_CLASS_ARRAY = { Object.class };
  private static final Class[] PERTYPEWITHIN_CLASS_ARRAY = { Class.class };
  
  public static <T> T aspectOf(Class<T> paramClass)
  {
    try
    {
      Object localObject = getSingletonOrThreadAspectOf(paramClass).invoke(null, EMPTY_OBJECT_ARRAY);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new NoAspectBoundException(paramClass.getName(), localException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new NoAspectBoundException(paramClass.getName(), localInvocationTargetException);
    }
  }
  
  public static <T> T aspectOf(Class<T> paramClass, Class<?> paramClass1)
  {
    try
    {
      paramClass1 = getPerTypeWithinAspectOf(paramClass).invoke(null, new Object[] { paramClass1 });
      return paramClass1;
    }
    catch (Exception paramClass1)
    {
      throw new NoAspectBoundException(paramClass.getName(), paramClass1);
    }
    catch (InvocationTargetException paramClass1)
    {
      throw new NoAspectBoundException(paramClass.getName(), paramClass1);
    }
  }
  
  public static <T> T aspectOf(Class<T> paramClass, Object paramObject)
  {
    try
    {
      paramObject = getPerObjectAspectOf(paramClass).invoke(null, new Object[] { paramObject });
      return paramObject;
    }
    catch (Exception paramObject)
    {
      throw new NoAspectBoundException(paramClass.getName(), paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      throw new NoAspectBoundException(paramClass.getName(), paramObject);
    }
  }
  
  private static Method checkAspectOf(Method paramMethod, Class<?> paramClass)
  {
    paramMethod.setAccessible(true);
    if ((paramMethod.isAccessible()) && (Modifier.isPublic(paramMethod.getModifiers())) && (Modifier.isStatic(paramMethod.getModifiers()))) {
      return paramMethod;
    }
    paramMethod = new StringBuilder();
    paramMethod.append(paramClass.getName());
    paramMethod.append(".aspectOf(..) is not accessible public static");
    throw new NoSuchMethodException(paramMethod.toString());
  }
  
  private static Method checkHasAspect(Method paramMethod, Class paramClass)
  {
    paramMethod.setAccessible(true);
    if ((paramMethod.isAccessible()) && (Modifier.isPublic(paramMethod.getModifiers())) && (Modifier.isStatic(paramMethod.getModifiers()))) {
      return paramMethod;
    }
    paramMethod = new StringBuilder();
    paramMethod.append(paramClass.getName());
    paramMethod.append(".hasAspect(..) is not accessible public static");
    throw new NoSuchMethodException(paramMethod.toString());
  }
  
  private static Method getPerObjectAspectOf(Class<?> paramClass)
  {
    return checkAspectOf(paramClass.getDeclaredMethod("aspectOf", PEROBJECT_CLASS_ARRAY), paramClass);
  }
  
  private static Method getPerObjectHasAspect(Class paramClass)
  {
    return checkHasAspect(paramClass.getDeclaredMethod("hasAspect", PEROBJECT_CLASS_ARRAY), paramClass);
  }
  
  private static Method getPerTypeWithinAspectOf(Class<?> paramClass)
  {
    return checkAspectOf(paramClass.getDeclaredMethod("aspectOf", PERTYPEWITHIN_CLASS_ARRAY), paramClass);
  }
  
  private static Method getPerTypeWithinHasAspect(Class paramClass)
  {
    return checkHasAspect(paramClass.getDeclaredMethod("hasAspect", PERTYPEWITHIN_CLASS_ARRAY), paramClass);
  }
  
  private static Method getSingletonOrThreadAspectOf(Class<?> paramClass)
  {
    return checkAspectOf(paramClass.getDeclaredMethod("aspectOf", EMPTY_CLASS_ARRAY), paramClass);
  }
  
  private static Method getSingletonOrThreadHasAspect(Class paramClass)
  {
    return checkHasAspect(paramClass.getDeclaredMethod("hasAspect", EMPTY_CLASS_ARRAY), paramClass);
  }
  
  public static boolean hasAspect(Class<?> paramClass)
  {
    try
    {
      boolean bool = ((Boolean)getSingletonOrThreadHasAspect(paramClass).invoke(null, EMPTY_OBJECT_ARRAY)).booleanValue();
      return bool;
    }
    catch (Exception paramClass)
    {
      label20:
      break label20;
    }
    return false;
  }
  
  public static boolean hasAspect(Class<?> paramClass1, Class<?> paramClass2)
  {
    try
    {
      boolean bool = ((Boolean)getPerTypeWithinHasAspect(paramClass1).invoke(null, new Object[] { paramClass2 })).booleanValue();
      return bool;
    }
    catch (Exception paramClass1) {}
    return false;
  }
  
  public static boolean hasAspect(Class<?> paramClass, Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)getPerObjectHasAspect(paramClass).invoke(null, new Object[] { paramObject })).booleanValue();
      return bool;
    }
    catch (Exception paramClass) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.Aspects
 * JD-Core Version:    0.7.0.1
 */