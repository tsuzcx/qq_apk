package com.tencent.mobileqq.kandian.base.utils;

import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class ViewReflectionUtils
{
  private static Method a;
  private static Method b;
  private static Method c;
  
  static
  {
    try
    {
      a = Class.class.getDeclaredMethod("forName", new Class[] { String.class });
      b = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, [Ljava.lang.Class.class });
      c = Class.class.getDeclaredMethod("getDeclaredField", new Class[] { String.class });
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init throw ");
      localStringBuilder.append(localThrowable);
      QLog.e("ReflectionUtils", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.ViewReflectionUtils
 * JD-Core Version:    0.7.0.1
 */