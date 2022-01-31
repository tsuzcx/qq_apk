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
  private static boolean isCompatible;
  private static Map<Member, Integer> methodIdMap = new ConcurrentHashMap();
  private static Map<Member, MethodInfo> methodInfoMap;
  private static Map<Member, ReplaceMethodCallback> replaceCallBackMap = new ConcurrentHashMap();
  private static boolean soError = false;
  
  static
  {
    isCompatible = false;
    isCompatible = checkCompatibility();
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
    int j;
    label51:
    int k;
    label64:
    boolean bool;
    if ((str != null) && (str.startsWith("2")))
    {
      i = 1;
      if ((!Build.CPU_ABI.toLowerCase().startsWith("armeabi")) || (Build.BRAND.equals("asus"))) {
        break label116;
      }
      j = 1;
      if (!TextUtils.isEmpty(System.getProperty("ro.yunos.version"))) {
        break label121;
      }
      k = 0;
      bool = new File("/system/framework/core.jar.jex").exists();
      if (Build.VERSION.SDK_INT < 15) {
        break label126;
      }
    }
    label116:
    label121:
    label126:
    for (int m = 1;; m = 0)
    {
      if ((i != 0) || (j == 0) || (k != 0) || (bool) || (m == 0)) {
        break label131;
      }
      return true;
      i = 0;
      break;
      j = 0;
      break label51;
      k = 1;
      break label64;
    }
    label131:
    return false;
  }
  
  public static void findAndHookConstructor(Class<?> paramClass, Object... paramVarArgs)
    throws NoSuchMethodException
  {
    if (!isSdkAvailable()) {
      return;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0) || (!(paramVarArgs[(paramVarArgs.length - 1)] instanceof HookMethodCallback))) {
      throw new IllegalArgumentException("parameterTypesAndCallback can not be null or empty. And the last element of parameterTypesAndCallback must be instance of HookMethodCallback.");
    }
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
        MethodInfo localMethodInfo = new MethodInfo(paramClass.getParameterTypes(), null);
        methodInfoMap.put(paramClass, localMethodInfo);
        addHookCallback(paramClass, paramVarArgs);
        hookMethodNative(paramClass, (Class)localObject, i);
        return;
      }
      localObject[i] = ((Class)paramVarArgs[i]);
      i += 1;
    }
  }
  
  public static void findAndHookMethod(Class<?> paramClass, String paramString, Object... paramVarArgs)
    throws NoSuchMethodException
  {
    if (!isSdkAvailable()) {
      return;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0) || (!(paramVarArgs[(paramVarArgs.length - 1)] instanceof HookMethodCallback))) {
      throw new IllegalArgumentException("parameterTypesAndCallback can not be null or empty. And the last element of parameterTypesAndCallback must be instance of HookMethodCallback.");
    }
    Object localObject = new Class[paramVarArgs.length - 1];
    int i = 0;
    for (;;)
    {
      if (i >= localObject.length)
      {
        paramVarArgs = (HookMethodCallback)paramVarArgs[(paramVarArgs.length - 1)];
        paramString = paramClass.getDeclaredMethod(paramString, (Class[])localObject);
        i = getMethodId(paramString);
        localObject = new MethodInfo(paramString.getParameterTypes(), paramString.getReturnType());
        methodInfoMap.put(paramString, localObject);
        addHookCallback(paramString, paramVarArgs);
        hookMethodNative(paramString, paramClass, i);
        return;
      }
      localObject[i] = ((Class)paramVarArgs[i]);
      i += 1;
    }
  }
  
  public static void findAndReplaceMethod(Class<?> paramClass, String paramString, Object... paramVarArgs)
    throws NoSuchMethodException
  {
    if (!isSdkAvailable()) {
      return;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0) || (!(paramVarArgs[(paramVarArgs.length - 1)] instanceof ReplaceMethodCallback))) {
      throw new IllegalArgumentException("parameterTypesAndCallback can not be null or empty. And the last element of parameterTypesAndCallback must be instance of ReplaceMethodCallback.");
    }
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
        localObject = new MethodInfo(paramClass.getParameterTypes(), paramClass.getReturnType());
        methodInfoMap.put(paramClass, localObject);
        if (replaceCallBackMap.containsKey(paramClass)) {
          Log.e("JavaHookBridge", paramClass.getName() + " was replaced by " + ((ReplaceMethodCallback)replaceCallBackMap.get(paramClass)).getClass().getName() + ". And now is replaced by " + paramVarArgs.getClass().getName());
        }
        replaceCallBackMap.put(paramClass, paramVarArgs);
        hookMethodNative(paramClass, paramString, i);
        return;
      }
      localObject[i] = ((Class)paramVarArgs[i]);
      i += 1;
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
    catch (IllegalAccessException paramMember)
    {
      paramMember.printStackTrace();
      return 0;
    }
    catch (NoSuchFieldException paramMember)
    {
      for (;;)
      {
        paramMember.printStackTrace();
      }
    }
  }
  
  private static Object handleHookMethod(Member paramMember, Object paramObject, Object[] paramArrayOfObject)
    throws Throwable
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
      if (((Iterator)localObject).hasNext()) {
        break label122;
      }
    }
    for (;;)
    {
      try
      {
        localObject = (ReplaceMethodCallback)replaceCallBackMap.get(paramMember);
        if (localObject == null) {
          continue;
        }
        ((ReplaceMethodCallback)localObject).replaceMethod(localMethodHookParam);
      }
      catch (InvocationTargetException paramMember)
      {
        localMethodHookParam.throwable = paramMember.getTargetException();
        continue;
      }
      catch (Exception paramMember)
      {
        localMethodHookParam.throwable = paramMember;
        continue;
      }
      catch (Error paramMember)
      {
        label122:
        localMethodHookParam.throwable = paramMember;
        continue;
        ((HookMethodCallback)paramMember.next()).afterHookedMethod(localMethodHookParam);
        continue;
      }
      if (localSet != null)
      {
        paramMember = localSet.iterator();
        if (paramMember.hasNext()) {
          continue;
        }
      }
      if (localMethodHookParam.throwable == null) {
        break label202;
      }
      throw localMethodHookParam.throwable;
      ((HookMethodCallback)((Iterator)localObject).next()).beforeHookedMethod(localMethodHookParam);
      break;
      localMethodHookParam.result = invokeOriginMethod(paramMember, paramObject, paramArrayOfObject);
    }
    label202:
    return localMethodHookParam.result;
  }
  
  private static synchronized native void hookMethodNative(Member paramMember, Class<?> paramClass, int paramInt);
  
  public static Object invokeOriginMethod(Member paramMember, Object paramObject, Object[] paramArrayOfObject)
    throws InvocationTargetException
  {
    Object localObject = (MethodInfo)methodInfoMap.get(paramMember);
    if (localObject != null) {
      return invokeOriginMethodNative(paramMember, getMethodId(paramMember), paramObject, paramArrayOfObject, ((MethodInfo)localObject).paramTypes, ((MethodInfo)localObject).returnType);
    }
    localObject = null;
    Class localClass = null;
    if ((paramMember instanceof Method))
    {
      localObject = ((Method)paramMember).getParameterTypes();
      localClass = ((Method)paramMember).getReturnType();
    }
    for (;;)
    {
      return invokeOriginMethodNative(paramMember, getMethodId(paramMember), paramObject, paramArrayOfObject, (Class[])localObject, localClass);
      if ((paramMember instanceof Constructor))
      {
        localObject = ((Constructor)paramMember).getParameterTypes();
        localClass = null;
      }
    }
  }
  
  private static native Object invokeOriginMethodNative(Member paramMember, int paramInt, Object paramObject, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass, Class<?> paramClass)
    throws InvocationTargetException;
  
  public static boolean isSdkAvailable()
  {
    return (isCompatible) && (!soError);
  }
  
  public static class MethodInfo
  {
    final Class<?>[] paramTypes;
    final Class<?> returnType;
    
    public MethodInfo(Class<?>[] paramArrayOfClass, Class<?> paramClass)
    {
      this.paramTypes = paramArrayOfClass;
      this.returnType = paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.javahooksdk.JavaHookBridge
 * JD-Core Version:    0.7.0.1
 */