package cooperation.qzone.util;

import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JarReflectUtil
{
  public static Object a(Object paramObject, String paramString, boolean paramBoolean, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    if ((paramObject == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Class localClass = paramObject.getClass();
    if ((paramBoolean) || (paramArrayOfClass != null)) {}
    for (;;)
    {
      try
      {
        if (paramArrayOfClass.length == 0)
        {
          paramString = localClass.getMethod(paramString, new Class[0]);
          if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
            continue;
          }
          return paramString.invoke(paramObject, new Object[0]);
        }
        paramString = localClass.getMethod(paramString, paramArrayOfClass);
        continue;
        if ((paramArrayOfClass != null) && (paramArrayOfClass.length != 0)) {
          continue;
        }
        paramString = localClass.getDeclaredMethod(paramString, new Class[0]);
      }
      catch (NoSuchMethodException paramObject)
      {
        QZLog.e("JarReflectUtil", "NoSuchMethodException: ");
        paramObject.printStackTrace();
        return null;
        paramString = localClass.getDeclaredMethod(paramString, paramArrayOfClass);
        continue;
        paramObject = paramString.invoke(paramObject, paramVarArgs);
        return paramObject;
      }
      catch (InvocationTargetException paramObject)
      {
        QZLog.e("JarReflectUtil", "InvocationTargetException: ");
        paramObject.printStackTrace();
        return null;
      }
      catch (IllegalAccessException paramObject)
      {
        paramObject.printStackTrace();
        QZLog.e("JarReflectUtil", "IllegalAccessException: ");
        return null;
      }
      catch (NullPointerException paramObject)
      {
        paramObject.printStackTrace();
        QZLog.e("JarReflectUtil", "NullPointerException: ");
      }
      paramString.setAccessible(true);
    }
    return null;
  }
  
  public static Object a(String paramString1, String paramString2, boolean paramBoolean, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramString1 = Class.forName(paramString1);
        if (!paramBoolean)
        {
          if ((paramArrayOfClass == null) || (paramArrayOfClass.length == 0))
          {
            paramString1 = paramString1.getMethod(paramString2, new Class[0]);
            if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
              continue;
            }
            return paramString1.invoke(null, new Object[0]);
          }
          paramString1 = paramString1.getMethod(paramString2, paramArrayOfClass);
          continue;
        }
        if ((paramArrayOfClass != null) && (paramArrayOfClass.length != 0)) {
          continue;
        }
        paramString1 = paramString1.getDeclaredMethod(paramString2, new Class[0]);
      }
      catch (NoSuchMethodException paramString1)
      {
        paramString1.printStackTrace();
        QZLog.e("JarReflectUtil", "NoSuchMethodException: ");
        return null;
        paramString1 = paramString1.getDeclaredMethod(paramString2, paramArrayOfClass);
        continue;
        paramString1 = paramString1.invoke(null, paramVarArgs);
        return paramString1;
      }
      catch (InvocationTargetException paramString1)
      {
        paramString1.printStackTrace();
        QZLog.e("JarReflectUtil", "InvocationTargetException: ");
        return null;
      }
      catch (IllegalAccessException paramString1)
      {
        paramString1.printStackTrace();
        QZLog.e("JarReflectUtil", "IllegalAccessException: ");
        return null;
      }
      catch (ClassNotFoundException paramString1)
      {
        paramString1.printStackTrace();
        QZLog.e("JarReflectUtil", "ClassNotFoundException: ");
        return null;
      }
      catch (NullPointerException paramString1)
      {
        paramString1.printStackTrace();
        QZLog.e("JarReflectUtil", "NullPointerException: ");
      }
      paramString1.setAccessible(true);
    }
    return null;
  }
  
  public static Object a(String paramString, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Class.forName(paramString);
      if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
        return paramString.newInstance();
      }
      paramString = paramString.getConstructor(paramArrayOfClass).newInstance(paramVarArgs);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      QZLog.e("JarReflectUtil", "ClassNotFoundException: ");
      paramString.printStackTrace();
      return null;
    }
    catch (InstantiationException paramString)
    {
      QZLog.e("JarReflectUtil", "InstantiationException: ");
      paramString.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      QZLog.e("JarReflectUtil", "IllegalAccessException: ");
      paramString.printStackTrace();
      return null;
    }
    catch (NoSuchMethodException paramString)
    {
      QZLog.e("JarReflectUtil", "NoSuchMethodException: ");
      paramString.printStackTrace();
      return null;
    }
    catch (InvocationTargetException paramString)
    {
      QZLog.e("JarReflectUtil", "InvocationTargetException: ");
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.JarReflectUtil
 * JD-Core Version:    0.7.0.1
 */