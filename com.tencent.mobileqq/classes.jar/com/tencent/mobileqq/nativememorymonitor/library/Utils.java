package com.tencent.mobileqq.nativememorymonitor.library;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Utils
{
  public static long getArtMethod(Class paramClass, String paramString, Class<?>... paramVarArgs)
  {
    try
    {
      paramClass = paramClass.getDeclaredMethod(paramString, paramVarArgs);
      paramString = paramClass.getClass().getSuperclass().getDeclaredField("artMethod");
      paramString.setAccessible(true);
      long l = ((Long)paramString.get(paramClass)).longValue();
      return l;
    }
    catch (NoSuchFieldException paramClass)
    {
      paramClass.printStackTrace();
    }
    catch (IllegalAccessException paramClass)
    {
      paramClass.printStackTrace();
    }
    catch (NoSuchMethodException paramClass)
    {
      paramClass.printStackTrace();
    }
    return 0L;
  }
  
  public static long getHiddenArtMethod(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    try
    {
      paramString1 = (Method)Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, [Ljava.lang.Class.class }).invoke(Class.forName(paramString1), new Object[] { paramString2, paramVarArgs });
      paramString2 = paramString1.getClass().getSuperclass().getDeclaredField("artMethod");
      paramString2.setAccessible(true);
      long l = ((Long)paramString2.get(paramString1)).longValue();
      return l;
    }
    catch (NoSuchFieldException paramString1)
    {
      paramString1.printStackTrace();
    }
    catch (InvocationTargetException paramString1)
    {
      paramString1.printStackTrace();
    }
    catch (IllegalAccessException paramString1)
    {
      paramString1.printStackTrace();
    }
    catch (NoSuchMethodException paramString1)
    {
      paramString1.printStackTrace();
    }
    catch (ClassNotFoundException paramString1)
    {
      paramString1.printStackTrace();
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nativememorymonitor.library.Utils
 * JD-Core Version:    0.7.0.1
 */