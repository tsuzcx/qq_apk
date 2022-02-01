package com.tencent.qqmini.sdk.launcher.dynamic;

import android.util.SparseArray;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Reflect
{
  private static SparseArray<Class> mClassMap = new SparseArray();
  private static SparseArray<Constructor> mConsMap = new SparseArray();
  private static SparseArray<Field> mFieldMap = new SparseArray();
  private static SparseArray<Method> mMethodMap = new SparseArray();
  private final boolean isClass;
  private final Object object;
  
  private Reflect(Class<?> paramClass)
  {
    this.object = paramClass;
    this.isClass = true;
  }
  
  private Reflect(Object paramObject)
  {
    this.object = paramObject;
    this.isClass = false;
  }
  
  public static <T extends AccessibleObject> T accessible(T paramT)
  {
    if (paramT == null) {
      return null;
    }
    if ((paramT instanceof Member))
    {
      Member localMember = (Member)paramT;
      if ((Modifier.isPublic(localMember.getModifiers())) && (Modifier.isPublic(localMember.getDeclaringClass().getModifiers()))) {
        return paramT;
      }
    }
    if (!paramT.isAccessible()) {
      paramT.setAccessible(true);
    }
    return paramT;
  }
  
  public static boolean checkClassExists(String paramString)
  {
    try
    {
      Class.forName(paramString);
      return true;
    }
    catch (ClassNotFoundException paramString)
    {
      label7:
      break label7;
    }
    return false;
  }
  
  private Method exactMethod(String paramString, Class<?>[] paramArrayOfClass)
  {
    Class localClass = type();
    label69:
    do
    {
      try
      {
        i = localClass.hashCode() + paramString.hashCode() + Arrays.hashCode(paramArrayOfClass);
        if (mMethodMap.get(i) != null) {
          return (Method)mMethodMap.get(i);
        }
        localMethod = localClass.getMethod(paramString, paramArrayOfClass);
        if (localMethod != null) {
          mMethodMap.put(i, localMethod);
        }
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        int i;
        Method localMethod;
        break label69;
      }
      try
      {
        i = localClass.hashCode() + paramString.hashCode() + Arrays.hashCode(paramArrayOfClass);
        if (mMethodMap.get(i) != null) {
          return (Method)mMethodMap.get(i);
        }
        localMethod = (Method)accessible(localClass.getDeclaredMethod(paramString, paramArrayOfClass));
        if (localMethod != null)
        {
          mMethodMap.put(i, localMethod);
          return localMethod;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        break label138;
      }
      localClass = localClass.getSuperclass();
    } while (localClass != null);
    label138:
    paramString = new NoSuchMethodException();
    for (;;)
    {
      throw paramString;
    }
  }
  
  private Field field0(String paramString)
  {
    Class localClass = type();
    int i;
    try
    {
      i = localClass.hashCode() + paramString.hashCode();
      if (mFieldMap.get(i) != null) {
        return (Field)mFieldMap.get(i);
      }
      Field localField1 = localClass.getField(paramString);
      if (localField1 != null) {
        mFieldMap.put(i, localField1);
      }
      return localField1;
    }
    catch (NoSuchFieldException localNoSuchFieldException1) {}
    label123:
    do
    {
      try
      {
        i = localClass.hashCode() + paramString.hashCode();
        if (mFieldMap.get(i) != null) {
          return (Field)mFieldMap.get(i);
        }
        Field localField2 = (Field)accessible(localClass.getDeclaredField(paramString));
        if (localField2 != null) {
          mFieldMap.put(i, localField2);
        }
        return localField2;
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        break label123;
      }
      localClass = localClass.getSuperclass();
    } while (localClass != null);
    paramString = new ReflectException(localNoSuchFieldException1);
    for (;;)
    {
      throw paramString;
    }
  }
  
  private static Class<?> forName(String paramString)
  {
    try
    {
      int i = paramString.hashCode();
      if (mClassMap.get(i) != null) {
        return (Class)mClassMap.get(i);
      }
      paramString = Class.forName(paramString);
      if (paramString != null) {
        mClassMap.put(i, paramString);
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new ReflectException(paramString);
    }
  }
  
  private static Class<?> forName(String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      paramString = Class.forName(paramString, true, paramClassLoader);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new ReflectException(paramString);
    }
  }
  
  private boolean isSimilarSignature(Method paramMethod, String paramString, Class<?>[] paramArrayOfClass)
  {
    return (paramMethod.getName().equals(paramString)) && (match(paramMethod.getParameterTypes(), paramArrayOfClass));
  }
  
  private boolean match(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    if (paramArrayOfClass1.length == paramArrayOfClass2.length)
    {
      int i = 0;
      while (i < paramArrayOfClass2.length) {
        if ((paramArrayOfClass2[i] == Reflect.NULL.class) || (wrapper(paramArrayOfClass1[i]).isAssignableFrom(wrapper(paramArrayOfClass2[i])))) {
          i += 1;
        } else {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public static Reflect on(Class<?> paramClass)
  {
    return new Reflect(paramClass);
  }
  
  public static Reflect on(Object paramObject)
  {
    return new Reflect(paramObject);
  }
  
  public static Reflect on(String paramString)
  {
    return on(forName(paramString));
  }
  
  public static Reflect on(String paramString, ClassLoader paramClassLoader)
  {
    return on(forName(paramString, paramClassLoader));
  }
  
  private static Reflect on(Constructor<?> paramConstructor, Object... paramVarArgs)
  {
    try
    {
      paramConstructor = on(paramConstructor.newInstance(paramVarArgs));
      return paramConstructor;
    }
    catch (Exception paramConstructor)
    {
      throw new ReflectException(paramConstructor);
    }
  }
  
  private static Reflect on(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      if (paramMethod.getReturnType() == Void.TYPE)
      {
        paramMethod.invoke(paramObject, paramVarArgs);
        return on(paramObject);
      }
      paramMethod = on(paramMethod.invoke(paramObject, paramVarArgs));
      return paramMethod;
    }
    catch (Exception paramMethod)
    {
      throw new ReflectException(paramMethod);
    }
  }
  
  private static String property(String paramString)
  {
    int i = paramString.length();
    if (i == 0) {
      return "";
    }
    if (i == 1) {
      return paramString.toLowerCase();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.substring(0, 1).toLowerCase());
    localStringBuilder.append(paramString.substring(1));
    return localStringBuilder.toString();
  }
  
  private Method similarMethod(String paramString, Class<?>[] paramArrayOfClass)
  {
    Object localObject2 = type();
    Method[] arrayOfMethod = ((Class)localObject2).getMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    for (;;)
    {
      localObject1 = localObject2;
      if (i >= j) {
        break;
      }
      localObject1 = arrayOfMethod[i];
      if (isSimilarSignature((Method)localObject1, paramString, paramArrayOfClass)) {
        return localObject1;
      }
      i += 1;
    }
    do
    {
      localObject2 = ((Class)localObject1).getDeclaredMethods();
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        arrayOfMethod = localObject2[i];
        if (isSimilarSignature(arrayOfMethod, paramString, paramArrayOfClass)) {
          return arrayOfMethod;
        }
        i += 1;
      }
      localObject1 = ((Class)localObject1).getSuperclass();
    } while (localObject1 != null);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("No similar method ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" with params ");
    ((StringBuilder)localObject1).append(Arrays.toString(paramArrayOfClass));
    ((StringBuilder)localObject1).append(" could be found on type ");
    ((StringBuilder)localObject1).append(type());
    ((StringBuilder)localObject1).append(".");
    paramString = new NoSuchMethodException(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw paramString;
    }
  }
  
  private static Class<?>[] types(Object... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs == null) {
      return new Class[0];
    }
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    while (i < paramVarArgs.length)
    {
      Object localObject = paramVarArgs[i];
      if (localObject == null) {
        localObject = Reflect.NULL.class;
      } else {
        localObject = localObject.getClass();
      }
      arrayOfClass[i] = localObject;
      i += 1;
    }
    return arrayOfClass;
  }
  
  private static Object unwrap(Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof Reflect)) {
      localObject = ((Reflect)paramObject).get();
    }
    return localObject;
  }
  
  public static Class<?> wrapper(Class<?> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    Object localObject = paramClass;
    if (paramClass.isPrimitive())
    {
      if (Boolean.TYPE == paramClass) {
        return Boolean.class;
      }
      if (Integer.TYPE == paramClass) {
        return Integer.class;
      }
      if (Long.TYPE == paramClass) {
        return Long.class;
      }
      if (Short.TYPE == paramClass) {
        return Short.class;
      }
      if (Byte.TYPE == paramClass) {
        return Byte.class;
      }
      if (Double.TYPE == paramClass) {
        return Double.class;
      }
      if (Float.TYPE == paramClass) {
        return Float.class;
      }
      if (Character.TYPE == paramClass) {
        return Character.class;
      }
      localObject = paramClass;
      if (Void.TYPE == paramClass) {
        localObject = Void.class;
      }
    }
    return localObject;
  }
  
  public <P> P as(Class<P> paramClass)
  {
    Reflect.1 local1 = new Reflect.1(this, this.object instanceof Map);
    return Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, local1);
  }
  
  public Reflect call(String paramString)
  {
    return call(paramString, new Object[0]);
  }
  
  public Reflect call(String paramString, Object... paramVarArgs)
  {
    Class[] arrayOfClass = types(paramVarArgs);
    for (;;)
    {
      try
      {
        Reflect localReflect = on(exactMethod(paramString, arrayOfClass), this.object, paramVarArgs);
        return localReflect;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        continue;
      }
      try
      {
        paramString = on((Method)accessible(similarMethod(paramString, arrayOfClass)), this.object, paramVarArgs);
        return paramString;
      }
      catch (NoSuchMethodException paramString)
      {
        throw new ReflectException(paramString);
      }
    }
  }
  
  public Reflect create()
  {
    return create(new Object[0]);
  }
  
  public Reflect create(Object... paramVarArgs)
  {
    Class[] arrayOfClass = types(paramVarArgs);
    try
    {
      Object localObject = type();
      i = arrayOfClass.hashCode() + Arrays.hashCode(paramVarArgs);
      if (mConsMap.get(i) != null)
      {
        localObject = (Constructor)mConsMap.get(i);
      }
      else
      {
        localObject = (Constructor)accessible(((Class)localObject).getDeclaredConstructor(arrayOfClass));
        mConsMap.put(i, localObject);
      }
      localObject = on((Constructor)localObject, paramVarArgs);
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Constructor[] arrayOfConstructor = type().getDeclaredConstructors();
      int j = arrayOfConstructor.length;
      int i = 0;
      while (i < j)
      {
        Constructor localConstructor = arrayOfConstructor[i];
        if (match(localConstructor.getParameterTypes(), arrayOfClass)) {
          return on((Constructor)accessible(localConstructor), paramVarArgs);
        }
        i += 1;
      }
      paramVarArgs = new ReflectException(localNoSuchMethodException);
    }
    for (;;)
    {
      throw paramVarArgs;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Reflect)) {
      return this.object.equals(((Reflect)paramObject).get());
    }
    return false;
  }
  
  public Reflect field(String paramString)
  {
    try
    {
      paramString = on(field0(paramString).get(this.object));
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new ReflectException(paramString);
    }
  }
  
  public Map<String, Reflect> fields()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject1 = type();
    Object localObject2;
    do
    {
      localObject2 = ((Class)localObject1).getDeclaredFields();
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject2[i];
        if ((this.isClass ^ true ^ Modifier.isStatic(str.getModifiers())))
        {
          str = str.getName();
          if (!localLinkedHashMap.containsKey(str)) {
            localLinkedHashMap.put(str, field(str));
          }
        }
        i += 1;
      }
      localObject2 = ((Class)localObject1).getSuperclass();
      localObject1 = localObject2;
    } while (localObject2 != null);
    return localLinkedHashMap;
  }
  
  public <T> T get()
  {
    return this.object;
  }
  
  public <T> T get(String paramString)
  {
    return field(paramString).get();
  }
  
  public int hashCode()
  {
    return this.object.hashCode();
  }
  
  public Reflect set(String paramString, Object paramObject)
  {
    try
    {
      field0(paramString).set(this.object, unwrap(paramObject));
      return this;
    }
    catch (Exception paramString)
    {
      throw new ReflectException(paramString);
    }
  }
  
  public String toString()
  {
    return this.object.toString();
  }
  
  public Class<?> type()
  {
    if (this.isClass) {
      return (Class)this.object;
    }
    return this.object.getClass();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.dynamic.Reflect
 * JD-Core Version:    0.7.0.1
 */