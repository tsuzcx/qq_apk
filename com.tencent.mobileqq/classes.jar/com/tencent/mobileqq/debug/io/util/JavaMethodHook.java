package com.tencent.mobileqq.debug.io.util;

import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.HashMap;

public class JavaMethodHook
{
  private static final HashMap<String, Field> jdField_a_of_type_JavaUtilHashMap;
  private static boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    a = new HashMap();
  }
  
  public static int a(Object paramObject, String paramString)
  {
    try
    {
      int i = a(paramObject.getClass(), paramString).getInt(paramObject);
      return i;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("JavaMethodHook", 2, paramObject.toString());
      }
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static JavaMethodHook.AdditionalHookInfo a(Member paramMember, JavaMethodHook.Callback paramCallback)
  {
    boolean bool = paramMember instanceof Method;
    if ((!bool) && (!(paramMember instanceof Constructor))) {
      throw new IllegalArgumentException("only methods and constructors can be hooked");
    }
    Class localClass = paramMember.getDeclaringClass();
    int i = a(paramMember, "slot");
    Object localObject;
    Class[] arrayOfClass;
    if (bool)
    {
      localObject = (Method)paramMember;
      arrayOfClass = ((Method)localObject).getParameterTypes();
      localObject = ((Method)localObject).getReturnType();
    }
    else
    {
      arrayOfClass = ((Constructor)paramMember).getParameterTypes();
      localObject = null;
    }
    paramCallback = new JavaMethodHook.AdditionalHookInfo(paramCallback, arrayOfClass, (Class)localObject, null);
    hookMethodNative(paramMember, localClass, i, paramCallback);
    return paramCallback;
  }
  
  public static Field a(Class<?> paramClass, String paramString)
  {
    Object localObject = new StringBuilder(paramClass.getName());
    ((StringBuilder)localObject).append('#');
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    if (a.containsKey(localObject))
    {
      paramClass = (Field)a.get(localObject);
      if (paramClass != null) {
        return paramClass;
      }
      throw new NoSuchFieldError((String)localObject);
    }
    try
    {
      paramClass = b(paramClass, paramString);
      paramClass.setAccessible(true);
      a.put(localObject, paramClass);
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      label88:
      break label88;
    }
    a.put(localObject, null);
    throw new NoSuchFieldError((String)localObject);
  }
  
  public static boolean a()
  {
    try
    {
      System.loadLibrary("apmhook");
      initNative();
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("JavaMethodHook", 2, localUnsatisfiedLinkError.toString());
      }
    }
    return false;
  }
  
  private static Field b(Class<?> paramClass, String paramString)
  {
    try
    {
      Field localField1 = paramClass.getDeclaredField(paramString);
      return localField1;
    }
    catch (NoSuchFieldException localNoSuchFieldException1) {}
    for (;;)
    {
      paramClass = paramClass.getSuperclass();
      if ((paramClass != null) && (!paramClass.equals(Object.class))) {}
      try
      {
        Field localField2 = paramClass.getDeclaredField(paramString);
        return localField2;
      }
      catch (NoSuchFieldException localNoSuchFieldException2) {}
      throw localNoSuchFieldException1;
    }
  }
  
  private static native void hookMethodNative(Member paramMember, Class<?> paramClass, int paramInt, Object paramObject);
  
  public static native boolean initNative();
  
  private static native Object invokeOriginalMethodNative(Member paramMember, int paramInt, Class<?>[] paramArrayOfClass, Class<?> paramClass, Object paramObject, Object[] paramArrayOfObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.debug.io.util.JavaMethodHook
 * JD-Core Version:    0.7.0.1
 */