package com.tencent.mobileqq.debug.io.util;

import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.HashMap;

public class JavaMethodHook
{
  private static final HashMap<String, Field> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static boolean jdField_a_of_type_Boolean = false;
  
  public static int a(Object paramObject, String paramString)
  {
    try
    {
      int i = a(paramObject.getClass(), paramString).getInt(paramObject);
      return i;
    }
    catch (IllegalAccessException paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("JavaMethodHook", 2, paramObject.toString());
      }
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static JavaMethodHook.AdditionalHookInfo a(Member paramMember, JavaMethodHook.Callback paramCallback)
  {
    if ((!(paramMember instanceof Method)) && (!(paramMember instanceof Constructor))) {
      throw new IllegalArgumentException("only methods and constructors can be hooked");
    }
    Class localClass2 = paramMember.getDeclaringClass();
    int i = a(paramMember, "slot");
    Class[] arrayOfClass;
    if ((paramMember instanceof Method)) {
      arrayOfClass = ((Method)paramMember).getParameterTypes();
    }
    for (Class localClass1 = ((Method)paramMember).getReturnType();; localClass1 = null)
    {
      paramCallback = new JavaMethodHook.AdditionalHookInfo(paramCallback, arrayOfClass, localClass1, null);
      hookMethodNative(paramMember, localClass2, i, paramCallback);
      return paramCallback;
      arrayOfClass = ((Constructor)paramMember).getParameterTypes();
    }
  }
  
  public static Field a(Class<?> paramClass, String paramString)
  {
    Object localObject = new StringBuilder(paramClass.getName());
    ((StringBuilder)localObject).append('#');
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(localObject))
    {
      paramString = (Field)jdField_a_of_type_JavaUtilHashMap.get(localObject);
      paramClass = paramString;
      if (paramString != null) {
        break label86;
      }
      throw new NoSuchFieldError((String)localObject);
    }
    try
    {
      paramClass = b(paramClass, paramString);
      paramClass.setAccessible(true);
      jdField_a_of_type_JavaUtilHashMap.put(localObject, paramClass);
      label86:
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      jdField_a_of_type_JavaUtilHashMap.put(localObject, null);
      throw new NoSuchFieldError((String)localObject);
    }
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
      if ((paramClass == null) || (paramClass.equals(Object.class))) {
        throw localNoSuchFieldException1;
      }
      try
      {
        Field localField2 = paramClass.getDeclaredField(paramString);
        return localField2;
      }
      catch (NoSuchFieldException localNoSuchFieldException2) {}
    }
  }
  
  private static native void hookMethodNative(Member paramMember, Class<?> paramClass, int paramInt, Object paramObject);
  
  public static native boolean initNative();
  
  private static native Object invokeOriginalMethodNative(Member paramMember, int paramInt, Class<?>[] paramArrayOfClass, Class<?> paramClass, Object paramObject, Object[] paramArrayOfObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.debug.io.util.JavaMethodHook
 * JD-Core Version:    0.7.0.1
 */