package me.ele.uetool.util;

import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Reflect28Util
{
  static
  {
    if (Build.VERSION.SDK_INT >= 28) {}
    try
    {
      Field localField = Class.class.getDeclaredField("classLoader");
      localField.setAccessible(true);
      localField.set(Reflect28Util.class, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static Class<?> forName(String paramString)
  {
    return Class.forName(paramString);
  }
  
  public static Field getDeclaredField(Class<?> paramClass, String paramString)
  {
    return paramClass.getDeclaredField(paramString);
  }
  
  public static Method getDeclaredMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    return paramClass.getDeclaredMethod(paramString, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.util.Reflect28Util
 * JD-Core Version:    0.7.0.1
 */