package com.tencent.qqmini.sdk.core.utils;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtil
{
  private static final String TAG = "ReflectionUtil";
  
  public static Object callSpecifiedMethod(Object paramObject, String paramString, boolean paramBoolean, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    if (paramObject != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      Class localClass = paramObject.getClass();
      if ((paramBoolean) || (paramArrayOfClass != null)) {}
      try
      {
        if (paramArrayOfClass.length != 0)
        {
          paramString = localClass.getMethod(paramString, paramArrayOfClass);
        }
        else
        {
          paramString = localClass.getMethod(paramString, new Class[0]);
          break label99;
          if ((paramArrayOfClass != null) && (paramArrayOfClass.length != 0)) {
            paramString = localClass.getDeclaredMethod(paramString, paramArrayOfClass);
          } else {
            paramString = localClass.getDeclaredMethod(paramString, new Class[0]);
          }
          paramString.setAccessible(true);
        }
        label99:
        if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
          paramObject = paramString.invoke(paramObject, paramVarArgs);
        } else {
          paramObject = paramString.invoke(paramObject, new Object[0]);
        }
        return paramObject;
      }
      catch (NullPointerException paramObject)
      {
        paramObject.printStackTrace();
        paramString = new StringBuilder();
        paramString.append("NullPointerException: ");
        paramString.append(paramObject.getMessage());
        Log.e("ReflectionUtil", paramString.toString());
        return null;
      }
      catch (IllegalAccessException paramObject)
      {
        paramObject.printStackTrace();
        paramString = new StringBuilder();
        paramString.append("IllegalAccessException: ");
        paramString.append(paramObject.getMessage());
        Log.e("ReflectionUtil", paramString.toString());
        return null;
      }
      catch (InvocationTargetException paramObject)
      {
        paramString = new StringBuilder();
        paramString.append("InvocationTargetException: ");
        paramString.append(paramObject.getMessage());
        Log.e("ReflectionUtil", paramString.toString());
        paramObject.printStackTrace();
        return null;
      }
      catch (NoSuchMethodException paramObject)
      {
        paramString = new StringBuilder();
        paramString.append("NoSuchMethodException: ");
        paramString.append(paramObject.getMessage());
        Log.e("ReflectionUtil", paramString.toString());
        paramObject.printStackTrace();
      }
    }
    return null;
  }
  
  public static Object callSpecifiedStaticMethod(String paramString1, String paramString2, boolean paramBoolean, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      try
      {
        paramString1 = Class.forName(paramString1);
        if (!paramBoolean)
        {
          if ((paramArrayOfClass != null) && (paramArrayOfClass.length != 0)) {
            paramString1 = paramString1.getMethod(paramString2, paramArrayOfClass);
          } else {
            paramString1 = paramString1.getMethod(paramString2, new Class[0]);
          }
        }
        else
        {
          if ((paramArrayOfClass != null) && (paramArrayOfClass.length != 0)) {
            paramString1 = paramString1.getDeclaredMethod(paramString2, paramArrayOfClass);
          } else {
            paramString1 = paramString1.getDeclaredMethod(paramString2, new Class[0]);
          }
          paramString1.setAccessible(true);
        }
        if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
          paramString1 = paramString1.invoke(null, paramVarArgs);
        } else {
          paramString1 = paramString1.invoke(null, new Object[0]);
        }
        return paramString1;
      }
      catch (NullPointerException paramString1)
      {
        paramString1.printStackTrace();
        paramString2 = new StringBuilder();
        paramString2.append("NullPointerException: ");
        paramString2.append(paramString1.getMessage());
        Log.e("ReflectionUtil", paramString2.toString());
        return null;
      }
      catch (ClassNotFoundException paramString1)
      {
        paramString1.printStackTrace();
        paramString2 = new StringBuilder();
        paramString2.append("ClassNotFoundException: ");
        paramString2.append(paramString1.getMessage());
        Log.e("ReflectionUtil", paramString2.toString());
        return null;
      }
      catch (IllegalAccessException paramString1)
      {
        paramString1.printStackTrace();
        paramString2 = new StringBuilder();
        paramString2.append("IllegalAccessException: ");
        paramString2.append(paramString1.getMessage());
        Log.e("ReflectionUtil", paramString2.toString());
        return null;
      }
      catch (InvocationTargetException paramString1)
      {
        paramString1.printStackTrace();
        paramString2 = new StringBuilder();
        paramString2.append("InvocationTargetException: ");
        paramString2.append(paramString1.getMessage());
        Log.e("ReflectionUtil", paramString2.toString());
        return null;
      }
      catch (NoSuchMethodException paramString1)
      {
        paramString1.printStackTrace();
        paramString2 = new StringBuilder();
        paramString2.append("NoSuchMethodException: ");
        paramString2.append(paramString1.getMessage());
        Log.e("ReflectionUtil", paramString2.toString());
      }
    }
    return null;
  }
  
  public static Object createSpecifiedObject(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Class.forName(paramString).newInstance();
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      Log.e("ReflectionUtil", "InstantiationException: ");
      paramString.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      Log.e("ReflectionUtil", "IllegalAccessException: ");
      paramString.printStackTrace();
      return null;
    }
    catch (ClassNotFoundException paramString)
    {
      Log.e("ReflectionUtil", "ClassNotFoundException: ");
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static Object createSpecifiedObject(String paramString, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Class.forName(paramString);
      if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
        paramString = paramString.getConstructor(paramArrayOfClass).newInstance(paramVarArgs);
      } else {
        paramString = paramString.newInstance();
      }
      return paramString;
    }
    catch (InvocationTargetException paramString)
    {
      paramArrayOfClass = new StringBuilder();
      paramArrayOfClass.append("InvocationTargetException: ");
      paramArrayOfClass.append(paramString.getMessage());
      Log.e("ReflectionUtil", paramArrayOfClass.toString());
      paramString.printStackTrace();
      return null;
    }
    catch (NoSuchMethodException paramString)
    {
      paramArrayOfClass = new StringBuilder();
      paramArrayOfClass.append("NoSuchMethodException: ");
      paramArrayOfClass.append(paramString.getMessage());
      Log.e("ReflectionUtil", paramArrayOfClass.toString());
      paramString.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      paramArrayOfClass = new StringBuilder();
      paramArrayOfClass.append("IllegalAccessException: ");
      paramArrayOfClass.append(paramString.getMessage());
      Log.e("ReflectionUtil", paramArrayOfClass.toString());
      paramString.printStackTrace();
      return null;
    }
    catch (InstantiationException paramString)
    {
      paramArrayOfClass = new StringBuilder();
      paramArrayOfClass.append("InstantiationException: ");
      paramArrayOfClass.append(paramString.getMessage());
      Log.e("ReflectionUtil", paramArrayOfClass.toString());
      paramString.printStackTrace();
      return null;
    }
    catch (ClassNotFoundException paramString)
    {
      paramArrayOfClass = new StringBuilder();
      paramArrayOfClass.append("ClassNotFoundException: ");
      paramArrayOfClass.append(paramString.getMessage());
      Log.e("ReflectionUtil", paramArrayOfClass.toString());
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static Object getClassSingleInstance(String paramString1, String paramString2, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    return callSpecifiedStaticMethod(paramString1, paramString2, false, paramArrayOfClass, paramVarArgs);
  }
  
  public static Field getField(Object paramObject, String paramString)
  {
    paramObject = paramObject.getClass();
    try
    {
      paramObject = paramObject.getDeclaredField(paramString);
      return paramObject;
    }
    catch (NoSuchFieldException paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  public static Class[] getParamsClass(Class... paramVarArgs)
  {
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfClass[i] = paramVarArgs[i];
      i += 1;
    }
    return arrayOfClass;
  }
  
  public static Object getSpecifiedField(Object paramObject, String paramString, boolean paramBoolean)
  {
    if (paramObject != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      Class localClass = paramObject.getClass();
      if (!paramBoolean) {}
      try
      {
        paramObject = localClass.getField(paramString).get(paramObject);
      }
      catch (IllegalAccessException paramObject)
      {
        paramString = new StringBuilder();
        paramString.append("IllegalAccessException: ");
        paramString.append(paramObject.getMessage());
        Log.e("ReflectionUtil", paramString.toString());
        paramObject.printStackTrace();
        return null;
      }
      catch (NoSuchFieldException paramObject)
      {
        paramString = new StringBuilder();
        paramString.append("NoSuchFieldException: ");
        paramString.append(paramObject.getMessage());
        Log.e("ReflectionUtil", paramString.toString());
        paramObject.printStackTrace();
      }
      paramString = localClass.getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramObject = paramString.get(paramObject);
    }
    else
    {
      return null;
    }
    return paramObject;
  }
  
  public static Object getStaticField(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      try
      {
        paramString1 = Class.forName(paramString1);
        paramString1 = paramString1.getField(paramString2).get(paramString1);
        return paramString1;
      }
      catch (ClassNotFoundException paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("ClassNotFoundException: ");
        paramString2.append(paramString1.getMessage());
        Log.w("ReflectionUtil", paramString2.toString());
        return null;
      }
      catch (IllegalAccessException paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("IllegalAccessException: ");
        paramString2.append(paramString1.getMessage());
        Log.w("ReflectionUtil", paramString2.toString());
        return null;
      }
      catch (NoSuchFieldException paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("NoSuchFieldException: ");
        paramString2.append(paramString1.getMessage());
        Log.w("ReflectionUtil", paramString2.toString());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.ReflectionUtil
 * JD-Core Version:    0.7.0.1
 */