package de.robv.android.xposed;

import android.content.res.AssetManager;
import android.content.res.Resources;
import dalvik.system.DexFile;
import external.org.apache.commons.lang3.ClassUtils;
import external.org.apache.commons.lang3.reflect.MemberUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipFile;

public final class XposedHelpers
{
  private static final WeakHashMap<Object, HashMap<String, Object>> additionalFields = new WeakHashMap();
  private static final HashMap<String, Constructor<?>> constructorCache;
  private static final HashMap<String, Field> fieldCache = new HashMap();
  private static final HashMap<String, Method> methodCache = new HashMap();
  private static final HashMap<String, ThreadLocal<AtomicInteger>> sMethodDepth = new HashMap();
  
  static
  {
    constructorCache = new HashMap();
  }
  
  public static byte[] assetAsByteArray(Resources paramResources, String paramString)
  {
    return inputStreamToByteArray(paramResources.getAssets().open(paramString));
  }
  
  public static Object callMethod(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramObject = findMethodBestMatch(paramObject.getClass(), paramString, paramArrayOfClass, paramVarArgs).invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      throw new XposedHelpers.InvocationTargetError(paramObject.getCause());
    }
  }
  
  public static Object callMethod(Object paramObject, String paramString, Object... paramVarArgs)
  {
    try
    {
      paramObject = findMethodBestMatch(paramObject.getClass(), paramString, paramVarArgs).invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      throw new XposedHelpers.InvocationTargetError(paramObject.getCause());
    }
  }
  
  public static Object callStaticMethod(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramClass = findMethodBestMatch(paramClass, paramString, paramArrayOfClass, paramVarArgs).invoke(null, paramVarArgs);
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (InvocationTargetException paramClass)
    {
      throw new XposedHelpers.InvocationTargetError(paramClass.getCause());
    }
  }
  
  public static Object callStaticMethod(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    try
    {
      paramClass = findMethodBestMatch(paramClass, paramString, paramVarArgs).invoke(null, paramVarArgs);
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (InvocationTargetException paramClass)
    {
      throw new XposedHelpers.InvocationTargetError(paramClass.getCause());
    }
  }
  
  static void closeSilently(DexFile paramDexFile)
  {
    if (paramDexFile != null) {}
    try
    {
      paramDexFile.close();
      return;
    }
    catch (IOException paramDexFile) {}
  }
  
  static void closeSilently(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  static void closeSilently(ZipFile paramZipFile)
  {
    if (paramZipFile != null) {}
    try
    {
      paramZipFile.close();
      return;
    }
    catch (IOException paramZipFile) {}
  }
  
  public static int decrementMethodDepth(String paramString)
  {
    return ((AtomicInteger)getMethodDepthCounter(paramString).get()).decrementAndGet();
  }
  
  static boolean fileContains(File paramFile, String paramString)
  {
    try
    {
      localBufferedReader = new BufferedReader(new FileReader(paramFile));
    }
    finally
    {
      try
      {
        boolean bool;
        do
        {
          paramFile = localBufferedReader.readLine();
          if (paramFile == null) {
            break;
          }
          bool = paramFile.contains(paramString);
        } while (!bool);
        closeSilently(localBufferedReader);
        return true;
        closeSilently(localBufferedReader);
        return false;
      }
      finally
      {
        for (;;)
        {
          BufferedReader localBufferedReader;
          paramString = localBufferedReader;
        }
      }
      paramFile = finally;
      paramString = null;
    }
    closeSilently(paramString);
    throw paramFile;
  }
  
  public static XC_MethodHook.Unhook findAndHookConstructor(Class<?> paramClass, Object... paramVarArgs)
  {
    if ((paramVarArgs.length == 0) || (!(paramVarArgs[(paramVarArgs.length - 1)] instanceof XC_MethodHook))) {
      throw new IllegalArgumentException("no callback defined");
    }
    XC_MethodHook localXC_MethodHook = (XC_MethodHook)paramVarArgs[(paramVarArgs.length - 1)];
    return XposedBridge.hookMethod(findConstructorExact(paramClass, getParameterClasses(paramClass.getClassLoader(), paramVarArgs)), localXC_MethodHook);
  }
  
  public static XC_MethodHook.Unhook findAndHookConstructor(String paramString, ClassLoader paramClassLoader, Object... paramVarArgs)
  {
    return findAndHookConstructor(findClass(paramString, paramClassLoader), paramVarArgs);
  }
  
  public static XC_MethodHook.Unhook findAndHookMethod(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    if ((paramVarArgs.length == 0) || (!(paramVarArgs[(paramVarArgs.length - 1)] instanceof XC_MethodHook))) {
      throw new IllegalArgumentException("no callback defined");
    }
    XC_MethodHook localXC_MethodHook = (XC_MethodHook)paramVarArgs[(paramVarArgs.length - 1)];
    return XposedBridge.hookMethod(findMethodExact(paramClass, paramString, getParameterClasses(paramClass.getClassLoader(), paramVarArgs)), localXC_MethodHook);
  }
  
  public static XC_MethodHook.Unhook findAndHookMethod(String paramString1, ClassLoader paramClassLoader, String paramString2, Object... paramVarArgs)
  {
    return findAndHookMethod(findClass(paramString1, paramClassLoader), paramString2, paramVarArgs);
  }
  
  public static Class<?> findClass(String paramString, ClassLoader paramClassLoader)
  {
    ClassLoader localClassLoader = paramClassLoader;
    if (paramClassLoader == null) {
      localClassLoader = XposedBridge.BOOTCLASSLOADER;
    }
    try
    {
      paramString = ClassUtils.getClass(localClassLoader, paramString, false);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new XposedHelpers.ClassNotFoundError(paramString);
    }
  }
  
  public static Class<?> findClassIfExists(String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      paramString = findClass(paramString, paramClassLoader);
      return paramString;
    }
    catch (XposedHelpers.ClassNotFoundError paramString) {}
    return null;
  }
  
  public static Constructor<?> findConstructorBestMatch(Class<?> paramClass, Class<?>... paramVarArgs)
  {
    String str = paramClass.getName() + getParametersString(paramVarArgs) + "#bestmatch";
    if (constructorCache.containsKey(str))
    {
      paramVarArgs = (Constructor)constructorCache.get(str);
      paramClass = paramVarArgs;
      if (paramVarArgs != null) {
        break label91;
      }
      throw new NoSuchMethodError(str);
    }
    try
    {
      Constructor localConstructor1 = findConstructorExact(paramClass, paramVarArgs);
      constructorCache.put(str, localConstructor1);
      paramClass = localConstructor1;
      label91:
      return paramClass;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      Constructor[] arrayOfConstructor = paramClass.getDeclaredConstructors();
      int j = arrayOfConstructor.length;
      int i = 0;
      Object localObject;
      for (paramClass = null; i < j; paramClass = (Class<?>)localObject)
      {
        Constructor localConstructor2 = arrayOfConstructor[i];
        localObject = paramClass;
        if (ClassUtils.isAssignable(paramVarArgs, localConstructor2.getParameterTypes(), true)) {
          if (paramClass != null)
          {
            localObject = paramClass;
            if (MemberUtils.compareParameterTypes(localConstructor2.getParameterTypes(), paramClass.getParameterTypes(), paramVarArgs) >= 0) {}
          }
          else
          {
            localObject = localConstructor2;
          }
        }
        i += 1;
      }
      if (paramClass != null)
      {
        paramClass.setAccessible(true);
        constructorCache.put(str, paramClass);
        return paramClass;
      }
      paramClass = new NoSuchMethodError(str);
      constructorCache.put(str, null);
      throw paramClass;
    }
  }
  
  public static Constructor<?> findConstructorBestMatch(Class<?> paramClass, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    Object localObject1 = null;
    int i = 0;
    if (i < paramArrayOfClass.length)
    {
      if (paramArrayOfClass[i] != null) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = getParameterTypes(paramArrayOfObject);
        }
        paramArrayOfClass[i] = localObject2[i];
        localObject1 = localObject2;
      }
    }
    return findConstructorBestMatch(paramClass, paramArrayOfClass);
  }
  
  public static Constructor<?> findConstructorBestMatch(Class<?> paramClass, Object... paramVarArgs)
  {
    return findConstructorBestMatch(paramClass, getParameterTypes(paramVarArgs));
  }
  
  public static Constructor<?> findConstructorExact(Class<?> paramClass, Class<?>... paramVarArgs)
  {
    String str = paramClass.getName() + getParametersString(paramVarArgs) + "#exact";
    if (constructorCache.containsKey(str))
    {
      paramVarArgs = (Constructor)constructorCache.get(str);
      paramClass = paramVarArgs;
      if (paramVarArgs != null) {
        break label87;
      }
      throw new NoSuchMethodError(str);
    }
    try
    {
      paramClass = paramClass.getDeclaredConstructor(paramVarArgs);
      paramClass.setAccessible(true);
      constructorCache.put(str, paramClass);
      label87:
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      constructorCache.put(str, null);
      throw new NoSuchMethodError(str);
    }
  }
  
  public static Constructor<?> findConstructorExact(Class<?> paramClass, Object... paramVarArgs)
  {
    return findConstructorExact(paramClass, getParameterClasses(paramClass.getClassLoader(), paramVarArgs));
  }
  
  public static Constructor<?> findConstructorExact(String paramString, ClassLoader paramClassLoader, Object... paramVarArgs)
  {
    return findConstructorExact(findClass(paramString, paramClassLoader), getParameterClasses(paramClassLoader, paramVarArgs));
  }
  
  public static Constructor<?> findConstructorExactIfExists(Class<?> paramClass, Object... paramVarArgs)
  {
    try
    {
      paramClass = findConstructorExact(paramClass, paramVarArgs);
      return paramClass;
    }
    catch (XposedHelpers.ClassNotFoundError paramClass)
    {
      return null;
    }
    catch (NoSuchMethodError paramClass)
    {
      label9:
      break label9;
    }
  }
  
  public static Constructor<?> findConstructorExactIfExists(String paramString, ClassLoader paramClassLoader, Object... paramVarArgs)
  {
    try
    {
      paramString = findConstructorExact(paramString, paramClassLoader, paramVarArgs);
      return paramString;
    }
    catch (XposedHelpers.ClassNotFoundError paramString)
    {
      return null;
    }
    catch (NoSuchMethodError paramString)
    {
      label10:
      break label10;
    }
  }
  
  public static Field findField(Class<?> paramClass, String paramString)
  {
    String str = paramClass.getName() + '#' + paramString;
    if (fieldCache.containsKey(str))
    {
      paramString = (Field)fieldCache.get(str);
      paramClass = paramString;
      if (paramString != null) {
        break label83;
      }
      throw new NoSuchFieldError(str);
    }
    try
    {
      paramClass = findFieldRecursiveImpl(paramClass, paramString);
      paramClass.setAccessible(true);
      fieldCache.put(str, paramClass);
      label83:
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      fieldCache.put(str, null);
      throw new NoSuchFieldError(str);
    }
  }
  
  public static Field findFieldIfExists(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = findField(paramClass, paramString);
      return paramClass;
    }
    catch (NoSuchFieldError paramClass) {}
    return null;
  }
  
  private static Field findFieldRecursiveImpl(Class<?> paramClass, String paramString)
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
  
  public static Field findFirstFieldByExactType(Class<?> paramClass1, Class<?> paramClass2)
  {
    Object localObject1 = paramClass1;
    Object localObject2;
    do
    {
      localObject2 = ((Class)localObject1).getDeclaredFields();
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        Field localField = localObject2[i];
        if (localField.getType() == paramClass2)
        {
          localField.setAccessible(true);
          return localField;
        }
        i += 1;
      }
      localObject2 = ((Class)localObject1).getSuperclass();
      localObject1 = localObject2;
    } while (localObject2 != null);
    throw new NoSuchFieldError("Field of type " + paramClass2.getName() + " in class " + paramClass1.getName());
  }
  
  public static Method findMethodBestMatch(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    String str = paramClass.getName() + '#' + paramString + getParametersString(paramVarArgs) + "#bestmatch";
    if (methodCache.containsKey(str))
    {
      paramString = (Method)methodCache.get(str);
      paramClass = paramString;
      if (paramString != null) {
        break label101;
      }
      throw new NoSuchMethodError(str);
    }
    label101:
    int i;
    Object localObject1;
    try
    {
      Method localMethod1 = findMethodExact(paramClass, paramString, paramVarArgs);
      methodCache.put(str, localMethod1);
      paramClass = localMethod1;
      return paramClass;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      i = 1;
      localObject1 = null;
    }
    for (;;)
    {
      Method[] arrayOfMethod = paramClass.getDeclaredMethods();
      int k = arrayOfMethod.length;
      int j = 0;
      if (j < k)
      {
        Method localMethod2 = arrayOfMethod[j];
        Object localObject2;
        if ((i == 0) && (Modifier.isPrivate(localMethod2.getModifiers()))) {
          localObject2 = localObject1;
        }
        for (;;)
        {
          j += 1;
          localObject1 = localObject2;
          break;
          localObject2 = localObject1;
          if (localMethod2.getName().equals(paramString))
          {
            localObject2 = localObject1;
            if (ClassUtils.isAssignable(paramVarArgs, localMethod2.getParameterTypes(), true)) {
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                if (MemberUtils.compareParameterTypes(localMethod2.getParameterTypes(), localObject1.getParameterTypes(), paramVarArgs) >= 0) {}
              }
              else
              {
                localObject2 = localMethod2;
              }
            }
          }
        }
      }
      paramClass = paramClass.getSuperclass();
      if (paramClass == null)
      {
        if (localObject1 != null)
        {
          localObject1.setAccessible(true);
          methodCache.put(str, localObject1);
          return localObject1;
        }
        paramClass = new NoSuchMethodError(str);
        methodCache.put(str, null);
        throw paramClass;
      }
      i = 0;
    }
  }
  
  public static Method findMethodBestMatch(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    Object localObject1 = null;
    int i = 0;
    if (i < paramArrayOfClass.length)
    {
      if (paramArrayOfClass[i] != null) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = getParameterTypes(paramArrayOfObject);
        }
        paramArrayOfClass[i] = localObject2[i];
        localObject1 = localObject2;
      }
    }
    return findMethodBestMatch(paramClass, paramString, paramArrayOfClass);
  }
  
  public static Method findMethodBestMatch(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    return findMethodBestMatch(paramClass, paramString, getParameterTypes(paramVarArgs));
  }
  
  public static Method findMethodExact(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    String str = paramClass.getName() + '#' + paramString + getParametersString(paramVarArgs) + "#exact";
    if (methodCache.containsKey(str))
    {
      paramString = (Method)methodCache.get(str);
      paramClass = paramString;
      if (paramString != null) {
        break label97;
      }
      throw new NoSuchMethodError(str);
    }
    try
    {
      paramClass = paramClass.getDeclaredMethod(paramString, paramVarArgs);
      paramClass.setAccessible(true);
      methodCache.put(str, paramClass);
      label97:
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      methodCache.put(str, null);
      throw new NoSuchMethodError(str);
    }
  }
  
  public static Method findMethodExact(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    return findMethodExact(paramClass, paramString, getParameterClasses(paramClass.getClassLoader(), paramVarArgs));
  }
  
  public static Method findMethodExact(String paramString1, ClassLoader paramClassLoader, String paramString2, Object... paramVarArgs)
  {
    return findMethodExact(findClass(paramString1, paramClassLoader), paramString2, getParameterClasses(paramClassLoader, paramVarArgs));
  }
  
  public static Method findMethodExactIfExists(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    try
    {
      paramClass = findMethodExact(paramClass, paramString, paramVarArgs);
      return paramClass;
    }
    catch (XposedHelpers.ClassNotFoundError paramClass)
    {
      return null;
    }
    catch (NoSuchMethodError paramClass)
    {
      label10:
      break label10;
    }
  }
  
  public static Method findMethodExactIfExists(String paramString1, ClassLoader paramClassLoader, String paramString2, Object... paramVarArgs)
  {
    try
    {
      paramString1 = findMethodExact(paramString1, paramClassLoader, paramString2, paramVarArgs);
      return paramString1;
    }
    catch (XposedHelpers.ClassNotFoundError paramString1)
    {
      return null;
    }
    catch (NoSuchMethodError paramString1)
    {
      label11:
      break label11;
    }
  }
  
  public static Method[] findMethodsByExactParameters(Class<?> paramClass1, Class<?> paramClass2, Class<?>... paramVarArgs)
  {
    LinkedList localLinkedList = new LinkedList();
    paramClass1 = paramClass1.getDeclaredMethods();
    int k = paramClass1.length;
    int i = 0;
    Object localObject;
    if (i < k)
    {
      localObject = paramClass1[i];
      if ((paramClass2 == null) || (paramClass2 == localObject.getReturnType())) {}
    }
    label149:
    for (;;)
    {
      i += 1;
      break;
      Class[] arrayOfClass = localObject.getParameterTypes();
      if (paramVarArgs.length == arrayOfClass.length)
      {
        int j = 0;
        label69:
        if (j < paramVarArgs.length) {
          if (paramVarArgs[j] == arrayOfClass[j]) {}
        }
        for (j = 0;; j = 1)
        {
          if (j == 0) {
            break label149;
          }
          localObject.setAccessible(true);
          localLinkedList.add(localObject);
          break;
          j += 1;
          break label69;
          return (Method[])localLinkedList.toArray(new Method[localLinkedList.size()]);
        }
      }
    }
  }
  
  public static Object getAdditionalInstanceField(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new NullPointerException("object must not be null");
    }
    if (paramString == null) {
      throw new NullPointerException("key must not be null");
    }
    synchronized (additionalFields)
    {
      paramObject = (HashMap)additionalFields.get(paramObject);
      if (paramObject == null) {
        return null;
      }
    }
  }
  
  public static Object getAdditionalStaticField(Class<?> paramClass, String paramString)
  {
    return getAdditionalInstanceField(paramClass, paramString);
  }
  
  public static Object getAdditionalStaticField(Object paramObject, String paramString)
  {
    return getAdditionalInstanceField(paramObject.getClass(), paramString);
  }
  
  public static boolean getBooleanField(Object paramObject, String paramString)
  {
    try
    {
      boolean bool = findField(paramObject.getClass(), paramString).getBoolean(paramObject);
      return bool;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static byte getByteField(Object paramObject, String paramString)
  {
    try
    {
      byte b = findField(paramObject.getClass(), paramString).getByte(paramObject);
      return b;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static char getCharField(Object paramObject, String paramString)
  {
    try
    {
      char c = findField(paramObject.getClass(), paramString).getChar(paramObject);
      return c;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static Class<?>[] getClassesAsArray(Class<?>... paramVarArgs)
  {
    return paramVarArgs;
  }
  
  public static double getDoubleField(Object paramObject, String paramString)
  {
    try
    {
      double d = findField(paramObject.getClass(), paramString).getDouble(paramObject);
      return d;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static int getFirstParameterIndexByType(Member paramMember, Class<?> paramClass)
  {
    Class[] arrayOfClass;
    int i;
    if ((paramMember instanceof Method))
    {
      arrayOfClass = ((Method)paramMember).getParameterTypes();
      i = 0;
    }
    for (;;)
    {
      if (i >= arrayOfClass.length) {
        break label50;
      }
      if (arrayOfClass[i] == paramClass)
      {
        return i;
        arrayOfClass = ((Constructor)paramMember).getParameterTypes();
        break;
      }
      i += 1;
    }
    label50:
    throw new NoSuchFieldError("No parameter of type " + paramClass + " found in " + paramMember);
  }
  
  public static float getFloatField(Object paramObject, String paramString)
  {
    try
    {
      float f = findField(paramObject.getClass(), paramString).getFloat(paramObject);
      return f;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static int getIntField(Object paramObject, String paramString)
  {
    try
    {
      int i = findField(paramObject.getClass(), paramString).getInt(paramObject);
      return i;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static long getLongField(Object paramObject, String paramString)
  {
    try
    {
      long l = findField(paramObject.getClass(), paramString).getLong(paramObject);
      return l;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static String getMD5Sum(String paramString)
  {
    MessageDigest localMessageDigest;
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
      paramString = new FileInputStream(paramString);
      byte[] arrayOfByte = new byte[8192];
      for (;;)
      {
        int i = paramString.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramString.close();
    }
    catch (NoSuchAlgorithmException paramString)
    {
      return "";
    }
    paramString = new BigInteger(1, localMessageDigest.digest()).toString(16);
    return paramString;
  }
  
  public static int getMethodDepth(String paramString)
  {
    return ((AtomicInteger)getMethodDepthCounter(paramString).get()).get();
  }
  
  private static ThreadLocal<AtomicInteger> getMethodDepthCounter(String paramString)
  {
    synchronized (sMethodDepth)
    {
      ThreadLocal localThreadLocal = (ThreadLocal)sMethodDepth.get(paramString);
      Object localObject = localThreadLocal;
      if (localThreadLocal == null)
      {
        localObject = new XposedHelpers.1();
        sMethodDepth.put(paramString, localObject);
      }
      return localObject;
    }
  }
  
  public static Object getObjectField(Object paramObject, String paramString)
  {
    try
    {
      paramObject = findField(paramObject.getClass(), paramString).get(paramObject);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  static Method getOverriddenMethod(Method paramMethod)
  {
    int i = paramMethod.getModifiers();
    if ((Modifier.isStatic(i)) || (Modifier.isPrivate(i)))
    {
      paramMethod = null;
      return paramMethod;
    }
    String str = paramMethod.getName();
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    paramMethod = paramMethod.getDeclaringClass().getSuperclass();
    for (;;)
    {
      for (;;)
      {
        if (paramMethod == null) {
          break label90;
        }
        try
        {
          Method localMethod = paramMethod.getDeclaredMethod(str, arrayOfClass);
          i = localMethod.getModifiers();
          if (!Modifier.isPrivate(i))
          {
            boolean bool = Modifier.isAbstract(i);
            paramMethod = localMethod;
            if (!bool) {
              break;
            }
          }
          return null;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          paramMethod = paramMethod.getSuperclass();
        }
      }
    }
    label90:
    return null;
  }
  
  static Set<Method> getOverriddenMethods(Class<?> paramClass)
  {
    HashSet localHashSet = new HashSet();
    paramClass = paramClass.getDeclaredMethods();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = getOverriddenMethod(paramClass[i]);
      if (localMethod != null) {
        localHashSet.add(localMethod);
      }
      i += 1;
    }
    return localHashSet;
  }
  
  private static Class<?>[] getParameterClasses(ClassLoader paramClassLoader, Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length - 1;
    Object localObject1 = null;
    if (i >= 0)
    {
      Object localObject3 = paramArrayOfObject[i];
      if (localObject3 == null) {
        throw new XposedHelpers.ClassNotFoundError("parameter type must not be null", null);
      }
      if ((localObject3 instanceof XC_MethodHook)) {}
      for (;;)
      {
        i -= 1;
        break;
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Class[i + 1];
        }
        if ((localObject3 instanceof Class))
        {
          localObject2[i] = ((Class)localObject3);
          localObject1 = localObject2;
        }
        else
        {
          if (!(localObject3 instanceof String)) {
            break label113;
          }
          localObject2[i] = findClass((String)localObject3, paramClassLoader);
          localObject1 = localObject2;
        }
      }
      label113:
      throw new XposedHelpers.ClassNotFoundError("parameter type must either be specified as Class or String", null);
    }
    paramClassLoader = localObject1;
    if (localObject1 == null) {
      paramClassLoader = new Class[0];
    }
    return paramClassLoader;
  }
  
  public static int getParameterIndexByType(Member paramMember, Class<?> paramClass)
  {
    if ((paramMember instanceof Method)) {}
    int j;
    for (Class[] arrayOfClass = ((Method)paramMember).getParameterTypes();; arrayOfClass = ((Constructor)paramMember).getParameterTypes())
    {
      int i = 0;
      int k;
      for (j = -1;; j = k)
      {
        if (i >= arrayOfClass.length) {
          break label106;
        }
        k = j;
        if (arrayOfClass[i] == paramClass)
        {
          if (j != -1) {
            break;
          }
          k = i;
        }
        i += 1;
      }
    }
    throw new NoSuchFieldError("More than one parameter of type " + paramClass + " found in " + paramMember);
    label106:
    if (j != -1) {
      return j;
    }
    throw new NoSuchFieldError("No parameter of type " + paramClass + " found in " + paramMember);
  }
  
  public static Class<?>[] getParameterTypes(Object... paramVarArgs)
  {
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i = 0;
    if (i < paramVarArgs.length)
    {
      if (paramVarArgs[i] != null) {}
      for (Class localClass = paramVarArgs[i].getClass();; localClass = null)
      {
        arrayOfClass[i] = localClass;
        i += 1;
        break;
      }
    }
    return arrayOfClass;
  }
  
  private static String getParametersString(Class<?>... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder("(");
    int j = 1;
    int k = paramVarArgs.length;
    int i = 0;
    if (i < k)
    {
      Class<?> localClass = paramVarArgs[i];
      if (j != 0)
      {
        j = 0;
        label35:
        if (localClass == null) {
          break label70;
        }
        localStringBuilder.append(localClass.getCanonicalName());
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(",");
        break label35;
        label70:
        localStringBuilder.append("null");
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static short getShortField(Object paramObject, String paramString)
  {
    try
    {
      short s = findField(paramObject.getClass(), paramString).getShort(paramObject);
      return s;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static boolean getStaticBooleanField(Class<?> paramClass, String paramString)
  {
    try
    {
      boolean bool = findField(paramClass, paramString).getBoolean(null);
      return bool;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static byte getStaticByteField(Class<?> paramClass, String paramString)
  {
    try
    {
      byte b = findField(paramClass, paramString).getByte(null);
      return b;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static char getStaticCharField(Class<?> paramClass, String paramString)
  {
    try
    {
      char c = findField(paramClass, paramString).getChar(null);
      return c;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static double getStaticDoubleField(Class<?> paramClass, String paramString)
  {
    try
    {
      double d = findField(paramClass, paramString).getDouble(null);
      return d;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static float getStaticFloatField(Class<?> paramClass, String paramString)
  {
    try
    {
      float f = findField(paramClass, paramString).getFloat(null);
      return f;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static int getStaticIntField(Class<?> paramClass, String paramString)
  {
    try
    {
      int i = findField(paramClass, paramString).getInt(null);
      return i;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static long getStaticLongField(Class<?> paramClass, String paramString)
  {
    try
    {
      long l = findField(paramClass, paramString).getLong(null);
      return l;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static Object getStaticObjectField(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = findField(paramClass, paramString).get(null);
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static short getStaticShortField(Class<?> paramClass, String paramString)
  {
    try
    {
      short s = findField(paramClass, paramString).getShort(null);
      return s;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static Object getSurroundingThis(Object paramObject)
  {
    return getObjectField(paramObject, "this$0");
  }
  
  public static int incrementMethodDepth(String paramString)
  {
    return ((AtomicInteger)getMethodDepthCounter(paramString).get()).incrementAndGet();
  }
  
  static byte[] inputStreamToByteArray(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i <= 0) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramInputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static Object newInstance(Class<?> paramClass, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramClass = findConstructorBestMatch(paramClass, paramArrayOfClass, paramVarArgs).newInstance(paramVarArgs);
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (InvocationTargetException paramClass)
    {
      throw new XposedHelpers.InvocationTargetError(paramClass.getCause());
    }
    catch (InstantiationException paramClass)
    {
      throw new InstantiationError(paramClass.getMessage());
    }
  }
  
  public static Object newInstance(Class<?> paramClass, Object... paramVarArgs)
  {
    try
    {
      paramClass = findConstructorBestMatch(paramClass, paramVarArgs).newInstance(paramVarArgs);
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (InvocationTargetException paramClass)
    {
      throw new XposedHelpers.InvocationTargetError(paramClass.getCause());
    }
    catch (InstantiationException paramClass)
    {
      throw new InstantiationError(paramClass.getMessage());
    }
  }
  
  public static Object removeAdditionalInstanceField(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new NullPointerException("object must not be null");
    }
    if (paramString == null) {
      throw new NullPointerException("key must not be null");
    }
    synchronized (additionalFields)
    {
      paramObject = (HashMap)additionalFields.get(paramObject);
      if (paramObject == null) {
        return null;
      }
    }
  }
  
  public static Object removeAdditionalStaticField(Class<?> paramClass, String paramString)
  {
    return removeAdditionalInstanceField(paramClass, paramString);
  }
  
  public static Object removeAdditionalStaticField(Object paramObject, String paramString)
  {
    return removeAdditionalInstanceField(paramObject.getClass(), paramString);
  }
  
  public static Object setAdditionalInstanceField(Object paramObject1, String paramString, Object paramObject2)
  {
    if (paramObject1 == null) {
      throw new NullPointerException("object must not be null");
    }
    if (paramString == null) {
      throw new NullPointerException("key must not be null");
    }
    for (;;)
    {
      HashMap localHashMap;
      synchronized (additionalFields)
      {
        localHashMap = (HashMap)additionalFields.get(paramObject1);
        if (localHashMap == null)
        {
          localHashMap = new HashMap();
          additionalFields.put(paramObject1, localHashMap);
          paramObject1 = localHashMap;
        }
      }
      paramObject1 = localHashMap;
    }
  }
  
  public static Object setAdditionalStaticField(Class<?> paramClass, String paramString, Object paramObject)
  {
    return setAdditionalInstanceField(paramClass, paramString, paramObject);
  }
  
  public static Object setAdditionalStaticField(Object paramObject1, String paramString, Object paramObject2)
  {
    return setAdditionalInstanceField(paramObject1.getClass(), paramString, paramObject2);
  }
  
  public static void setBooleanField(Object paramObject, String paramString, boolean paramBoolean)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setBoolean(paramObject, paramBoolean);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static void setByteField(Object paramObject, String paramString, byte paramByte)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setByte(paramObject, paramByte);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static void setCharField(Object paramObject, String paramString, char paramChar)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setChar(paramObject, paramChar);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static void setDoubleField(Object paramObject, String paramString, double paramDouble)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setDouble(paramObject, paramDouble);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static void setFloatField(Object paramObject, String paramString, float paramFloat)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setFloat(paramObject, paramFloat);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static void setIntField(Object paramObject, String paramString, int paramInt)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setInt(paramObject, paramInt);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static void setLongField(Object paramObject, String paramString, long paramLong)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setLong(paramObject, paramLong);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static void setObjectField(Object paramObject1, String paramString, Object paramObject2)
  {
    try
    {
      findField(paramObject1.getClass(), paramString).set(paramObject1, paramObject2);
      return;
    }
    catch (IllegalAccessException paramObject1)
    {
      XposedBridge.log(paramObject1);
      throw new IllegalAccessError(paramObject1.getMessage());
    }
    catch (IllegalArgumentException paramObject1)
    {
      throw paramObject1;
    }
  }
  
  public static void setShortField(Object paramObject, String paramString, short paramShort)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setShort(paramObject, paramShort);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      XposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static void setStaticBooleanField(Class<?> paramClass, String paramString, boolean paramBoolean)
  {
    try
    {
      findField(paramClass, paramString).setBoolean(null, paramBoolean);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static void setStaticByteField(Class<?> paramClass, String paramString, byte paramByte)
  {
    try
    {
      findField(paramClass, paramString).setByte(null, paramByte);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static void setStaticCharField(Class<?> paramClass, String paramString, char paramChar)
  {
    try
    {
      findField(paramClass, paramString).setChar(null, paramChar);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static void setStaticDoubleField(Class<?> paramClass, String paramString, double paramDouble)
  {
    try
    {
      findField(paramClass, paramString).setDouble(null, paramDouble);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static void setStaticFloatField(Class<?> paramClass, String paramString, float paramFloat)
  {
    try
    {
      findField(paramClass, paramString).setFloat(null, paramFloat);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static void setStaticIntField(Class<?> paramClass, String paramString, int paramInt)
  {
    try
    {
      findField(paramClass, paramString).setInt(null, paramInt);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static void setStaticLongField(Class<?> paramClass, String paramString, long paramLong)
  {
    try
    {
      findField(paramClass, paramString).setLong(null, paramLong);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static void setStaticObjectField(Class<?> paramClass, String paramString, Object paramObject)
  {
    try
    {
      findField(paramClass, paramString).set(null, paramObject);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static void setStaticShortField(Class<?> paramClass, String paramString, short paramShort)
  {
    try
    {
      findField(paramClass, paramString).setShort(null, paramShort);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      XposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XposedHelpers
 * JD-Core Version:    0.7.0.1
 */