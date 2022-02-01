package com.tencent.thumbplayer.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TPThreadAnnotations
{
  private static ArrayList<TPThreadAnnotations.RegisterMethod> mRegisterMethods = new ArrayList();
  
  public static boolean checkObj(Class<?> paramClass, int paramInt)
  {
    paramClass = getRegisterMethodMap(paramClass);
    if (paramClass == null) {
      return false;
    }
    paramClass = (Method)paramClass.get(Integer.valueOf(paramInt));
    if (paramClass != null)
    {
      paramClass = (TPThreadAnnotations.ThreadSwitch)paramClass.getAnnotation(TPThreadAnnotations.ThreadSwitch.class);
      if (paramClass != null) {
        return paramClass.checkObj();
      }
    }
    return false;
  }
  
  public static String getApi(Class<?> paramClass, int paramInt)
  {
    paramClass = getRegisterMethodMap(paramClass);
    if (paramClass == null) {
      return "unknown";
    }
    paramClass = (Method)paramClass.get(Integer.valueOf(paramInt));
    if (paramClass != null) {
      return paramClass.getName();
    }
    return "unknown";
  }
  
  public static Method getMethod(Class<?> paramClass, String paramString, Object[] paramArrayOfObject)
  {
    paramClass = getRegisterMethodMap(paramClass);
    if (paramClass == null) {
      return null;
    }
    paramClass = paramClass.entrySet().iterator();
    while (paramClass.hasNext())
    {
      Method localMethod = (Method)((Map.Entry)paramClass.next()).getValue();
      if ((localMethod != null) && (paramString.equals(localMethod.getName())) && (isMatchParams(localMethod, paramArrayOfObject))) {
        return localMethod;
      }
    }
    return null;
  }
  
  public static Method getMethodByMsgId(Class<?> paramClass, int paramInt)
  {
    paramClass = getRegisterMethodMap(paramClass);
    if (paramClass == null) {
      return null;
    }
    return (Method)paramClass.get(Integer.valueOf(paramInt));
  }
  
  public static int getMethodMsgId(Class<?> paramClass, String paramString, Object[] paramArrayOfObject)
  {
    paramClass = getRegisterMethodMap(paramClass);
    if (paramClass == null) {
      return -1;
    }
    paramClass = paramClass.entrySet().iterator();
    while (paramClass.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramClass.next();
      Method localMethod = (Method)localEntry.getValue();
      if ((localMethod != null) && (paramString.equals(localMethod.getName())) && (isMatchParams(localMethod, paramArrayOfObject))) {
        return ((Integer)localEntry.getKey()).intValue();
      }
    }
    return -1;
  }
  
  private static Map<Integer, Method> getRegisterMethodMap(Class<?> paramClass)
  {
    Iterator localIterator = mRegisterMethods.iterator();
    while (localIterator.hasNext())
    {
      TPThreadAnnotations.RegisterMethod localRegisterMethod = (TPThreadAnnotations.RegisterMethod)localIterator.next();
      if ((localRegisterMethod != null) && (localRegisterMethod.className != null) && (localRegisterMethod.className.equals(paramClass.getName()))) {
        return localRegisterMethod.methodMap;
      }
    }
    return null;
  }
  
  private static boolean isMatchParams(Method paramMethod, Object[] paramArrayOfObject)
  {
    paramMethod = paramMethod.getParameterTypes();
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length != 0))
    {
      if (paramMethod.length != paramArrayOfObject.length) {
        return false;
      }
      int i = 0;
      while (i < paramMethod.length)
      {
        Class localClass = paramMethod[i];
        if (paramArrayOfObject[i] == null)
        {
          if (localClass.isPrimitive()) {
            return false;
          }
        }
        else if ((!localClass.isAssignableFrom(paramArrayOfObject[i].getClass())) && (!isSamePrimitive(localClass, paramArrayOfObject[i]))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return paramMethod.length == 0;
  }
  
  public static boolean isNeedWait(Class<?> paramClass, int paramInt)
  {
    paramClass = getRegisterMethodMap(paramClass);
    if (paramClass == null) {
      return false;
    }
    paramClass = (Method)paramClass.get(Integer.valueOf(paramInt));
    if (paramClass != null)
    {
      Class[] arrayOfClass = paramClass.getExceptionTypes();
      if ((arrayOfClass != null) && (arrayOfClass.length > 0)) {
        return true;
      }
      paramClass = (TPThreadAnnotations.ThreadSwitch)paramClass.getAnnotation(TPThreadAnnotations.ThreadSwitch.class);
      if (paramClass != null) {
        return paramClass.needWait();
      }
    }
    return false;
  }
  
  private static boolean isRegistered(Class<?> paramClass)
  {
    Iterator localIterator = mRegisterMethods.iterator();
    while (localIterator.hasNext())
    {
      TPThreadAnnotations.RegisterMethod localRegisterMethod = (TPThreadAnnotations.RegisterMethod)localIterator.next();
      if ((localRegisterMethod != null) && (localRegisterMethod.className != null) && (localRegisterMethod.className.equals(paramClass.getName()))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean isSamePrimitive(Class<?> paramClass, Object paramObject)
  {
    if (!paramClass.isPrimitive()) {
      return false;
    }
    try
    {
      boolean bool = paramObject.getClass().getField("TYPE").get(null).equals(paramClass);
      return bool;
    }
    catch (Exception paramClass) {}
    return false;
  }
  
  public static boolean register(Class<?> paramClass, int paramInt)
  {
    try
    {
      boolean bool = isRegistered(paramClass);
      if (bool) {
        return true;
      }
      localHashMap = new HashMap();
    }
    finally
    {
      HashMap localHashMap;
      Object localObject1;
      int j;
      int i;
      label134:
      for (;;)
      {
        label42:
        throw paramClass;
      }
    }
    try
    {
      localObject1 = paramClass.getMethods();
      j = localObject1.length;
      i = paramInt;
      paramInt = 0;
      if (paramInt < j)
      {
        Object localObject2 = localObject1[paramInt];
        if ((TPThreadAnnotations.ThreadSwitch)localObject2.getAnnotation(TPThreadAnnotations.ThreadSwitch.class) != null)
        {
          localHashMap.put(Integer.valueOf(i), localObject2);
          i += 1;
        }
        paramInt += 1;
        break label42;
      }
      localObject1 = new TPThreadAnnotations.RegisterMethod(null);
      ((TPThreadAnnotations.RegisterMethod)localObject1).className = paramClass.getName();
      ((TPThreadAnnotations.RegisterMethod)localObject1).methodMap = localHashMap;
      mRegisterMethods.add(localObject1);
      return true;
    }
    catch (Exception paramClass)
    {
      break label134;
    }
    localHashMap.clear();
    return false;
  }
  
  public static boolean removeRepeat(Class<?> paramClass, int paramInt)
  {
    paramClass = getRegisterMethodMap(paramClass);
    if (paramClass == null) {
      return false;
    }
    paramClass = (Method)paramClass.get(Integer.valueOf(paramInt));
    if (paramClass != null)
    {
      paramClass = (TPThreadAnnotations.ThreadSwitch)paramClass.getAnnotation(TPThreadAnnotations.ThreadSwitch.class);
      if (paramClass != null) {
        return paramClass.removeRepeat();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPThreadAnnotations
 * JD-Core Version:    0.7.0.1
 */