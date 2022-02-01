package com.tencent.mobileqq.javahooksdk;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class JavaHookBridge
{
  private static final String TAG = "JavaHookBridge";
  private static Map<Member, Set<HookMethodCallback>> hookCallbackMap;
  private static boolean isCompatible = ;
  private static Map<Member, Integer> methodIdMap = new ConcurrentHashMap();
  private static Map<Member, JavaHookBridge.MethodInfo> methodInfoMap;
  private static Map<Member, ReplaceMethodCallback> replaceCallBackMap = new ConcurrentHashMap();
  private static boolean soError = false;
  
  static
  {
    if (isSdkAvailable()) {
      System.loadLibrary("javahook");
    }
    hookCallbackMap = new ConcurrentHashMap();
    methodInfoMap = new ConcurrentHashMap();
  }
  
  private static void addHookCallback(Member paramMember, HookMethodCallback paramHookMethodCallback)
  {
    Set localSet = (Set)hookCallbackMap.get(paramMember);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      hookCallbackMap.put(paramMember, localObject);
    }
    ((Set)localObject).add(paramHookMethodCallback);
  }
  
  private static boolean checkCompatibility()
  {
    String str = System.getProperty("java.vm.version");
    int i;
    if ((str != null) && (str.startsWith("2"))) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((Build.CPU_ABI.toLowerCase().startsWith("armeabi")) && (!Build.BRAND.equals("asus"))) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool1 = TextUtils.isEmpty(System.getProperty("ro.yunos.version"));
    boolean bool2 = new File("/system/framework/core.jar.jex").exists();
    int k;
    if (Build.VERSION.SDK_INT >= 15) {
      k = 1;
    } else {
      k = 0;
    }
    return (i == 0) && (j != 0) && (!(bool1 ^ true)) && (!bool2) && (k != 0);
  }
  
  public static void findAndHookConstructor(Class<?> paramClass, Object... paramVarArgs)
  {
    if (!isSdkAvailable()) {
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length != 0) && ((paramVarArgs[(paramVarArgs.length - 1)] instanceof HookMethodCallback)))
    {
      Object localObject = new Class[paramVarArgs.length - 1];
      int i = 0;
      for (;;)
      {
        if (i >= localObject.length)
        {
          paramVarArgs = (HookMethodCallback)paramVarArgs[(paramVarArgs.length - 1)];
          paramClass = paramClass.getDeclaredConstructor((Class[])localObject);
          localObject = paramClass.getDeclaringClass();
          i = getMethodId(paramClass);
          JavaHookBridge.MethodInfo localMethodInfo = new JavaHookBridge.MethodInfo(paramClass.getParameterTypes(), null);
          methodInfoMap.put(paramClass, localMethodInfo);
          addHookCallback(paramClass, paramVarArgs);
          hookMethodNative(paramClass, (Class)localObject, i);
          return;
        }
        localObject[i] = ((Class)paramVarArgs[i]);
        i += 1;
      }
    }
    paramClass = new IllegalArgumentException("parameterTypesAndCallback can not be null or empty. And the last element of parameterTypesAndCallback must be instance of HookMethodCallback.");
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public static void findAndHookMethod(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    if (!isSdkAvailable()) {
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length != 0) && ((paramVarArgs[(paramVarArgs.length - 1)] instanceof HookMethodCallback)))
    {
      Object localObject = new Class[paramVarArgs.length - 1];
      int i = 0;
      for (;;)
      {
        if (i >= localObject.length)
        {
          paramVarArgs = (HookMethodCallback)paramVarArgs[(paramVarArgs.length - 1)];
          paramString = paramClass.getDeclaredMethod(paramString, (Class[])localObject);
          i = getMethodId(paramString);
          localObject = new JavaHookBridge.MethodInfo(paramString.getParameterTypes(), paramString.getReturnType());
          methodInfoMap.put(paramString, localObject);
          addHookCallback(paramString, paramVarArgs);
          hookMethodNative(paramString, paramClass, i);
          return;
        }
        localObject[i] = ((Class)paramVarArgs[i]);
        i += 1;
      }
    }
    paramClass = new IllegalArgumentException("parameterTypesAndCallback can not be null or empty. And the last element of parameterTypesAndCallback must be instance of HookMethodCallback.");
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public static void findAndReplaceMethod(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    if (!isSdkAvailable()) {
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length != 0) && ((paramVarArgs[(paramVarArgs.length - 1)] instanceof ReplaceMethodCallback)))
    {
      Object localObject = new Class[paramVarArgs.length - 1];
      int i = 0;
      for (;;)
      {
        if (i >= localObject.length)
        {
          paramVarArgs = (ReplaceMethodCallback)paramVarArgs[(paramVarArgs.length - 1)];
          paramClass = paramClass.getDeclaredMethod(paramString, (Class[])localObject);
          paramString = paramClass.getDeclaringClass();
          i = getMethodId(paramClass);
          localObject = new JavaHookBridge.MethodInfo(paramClass.getParameterTypes(), paramClass.getReturnType());
          methodInfoMap.put(paramClass, localObject);
          if (replaceCallBackMap.containsKey(paramClass))
          {
            localObject = new StringBuilder(String.valueOf(paramClass.getName()));
            ((StringBuilder)localObject).append(" was replaced by ");
            ((StringBuilder)localObject).append(((ReplaceMethodCallback)replaceCallBackMap.get(paramClass)).getClass().getName());
            ((StringBuilder)localObject).append(". And now is replaced by ");
            ((StringBuilder)localObject).append(paramVarArgs.getClass().getName());
            Log.e("JavaHookBridge", ((StringBuilder)localObject).toString());
          }
          replaceCallBackMap.put(paramClass, paramVarArgs);
          hookMethodNative(paramClass, paramString, i);
          return;
        }
        localObject[i] = ((Class)paramVarArgs[i]);
        i += 1;
      }
    }
    paramClass = new IllegalArgumentException("parameterTypesAndCallback can not be null or empty. And the last element of parameterTypesAndCallback must be instance of ReplaceMethodCallback.");
    for (;;)
    {
      throw paramClass;
    }
  }
  
  private static int getMethodId(Member paramMember)
  {
    Object localObject = (Integer)methodIdMap.get(paramMember);
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    try
    {
      localObject = paramMember.getClass().getDeclaredField("slot");
      ((Field)localObject).setAccessible(true);
      int i = ((Field)localObject).getInt(paramMember);
      methodIdMap.put(paramMember, Integer.valueOf(i));
      return i;
    }
    catch (NoSuchFieldException paramMember)
    {
      paramMember.printStackTrace();
    }
    catch (IllegalAccessException paramMember)
    {
      paramMember.printStackTrace();
    }
    return 0;
  }
  
  private static Object handleHookMethod(Member paramMember, Object paramObject, Object[] paramArrayOfObject)
  {
    Set localSet = (Set)hookCallbackMap.get(paramMember);
    MethodHookParam localMethodHookParam = new MethodHookParam();
    localMethodHookParam.method = paramMember;
    localMethodHookParam.thisObject = paramObject;
    localMethodHookParam.args = paramArrayOfObject;
    Object localObject;
    if (localSet != null)
    {
      localObject = localSet.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((HookMethodCallback)((Iterator)localObject).next()).beforeHookedMethod(localMethodHookParam);
      }
    }
    try
    {
      localObject = (ReplaceMethodCallback)replaceCallBackMap.get(paramMember);
      if (localObject != null) {
        ((ReplaceMethodCallback)localObject).replaceMethod(localMethodHookParam);
      } else {
        localMethodHookParam.result = invokeOriginMethod(paramMember, paramObject, paramArrayOfObject);
      }
    }
    catch (Error paramMember)
    {
      localMethodHookParam.throwable = paramMember;
    }
    catch (Exception paramMember)
    {
      localMethodHookParam.throwable = paramMember;
    }
    catch (InvocationTargetException paramMember)
    {
      localMethodHookParam.throwable = paramMember.getTargetException();
    }
    if (localSet != null)
    {
      paramMember = localSet.iterator();
      while (paramMember.hasNext()) {
        ((HookMethodCallback)paramMember.next()).afterHookedMethod(localMethodHookParam);
      }
    }
    if (localMethodHookParam.throwable == null) {
      return localMethodHookParam.result;
    }
    paramMember = localMethodHookParam.throwable;
    for (;;)
    {
      throw paramMember;
    }
  }
  
  private static synchronized native void hookMethodNative(Member paramMember, Class<?> paramClass, int paramInt);
  
  public static Object invokeOriginMethod(Member paramMember, Object paramObject, Object[] paramArrayOfObject)
  {
    Object localObject1 = (JavaHookBridge.MethodInfo)methodInfoMap.get(paramMember);
    if (localObject1 != null) {
      return invokeOriginMethodNative(paramMember, getMethodId(paramMember), paramObject, paramArrayOfObject, ((JavaHookBridge.MethodInfo)localObject1).paramTypes, ((JavaHookBridge.MethodInfo)localObject1).returnType);
    }
    Object localObject2;
    if ((paramMember instanceof Method))
    {
      localObject2 = (Method)paramMember;
      localObject1 = ((Method)localObject2).getParameterTypes();
      localObject2 = ((Method)localObject2).getReturnType();
    }
    else if ((paramMember instanceof Constructor))
    {
      localObject1 = ((Constructor)paramMember).getParameterTypes();
      localObject2 = null;
    }
    else
    {
      localObject1 = null;
      localObject2 = localObject1;
    }
    return invokeOriginMethodNative(paramMember, getMethodId(paramMember), paramObject, paramArrayOfObject, (Class[])localObject1, (Class)localObject2);
  }
  
  private static native Object invokeOriginMethodNative(Member paramMember, int paramInt, Object paramObject, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass, Class<?> paramClass);
  
  public static boolean isSdkAvailable()
  {
    return (isCompatible) && (!soError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.javahooksdk.JavaHookBridge
 * JD-Core Version:    0.7.0.1
 */