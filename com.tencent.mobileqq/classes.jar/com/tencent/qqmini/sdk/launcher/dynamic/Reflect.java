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
    T ?;
    if (paramT == null) {
      ? = null;
    }
    do
    {
      Member localMember;
      do
      {
        return ?;
        if (!(paramT instanceof Member)) {
          break;
        }
        localMember = (Member)paramT;
        if (!Modifier.isPublic(localMember.getModifiers())) {
          break;
        }
        ? = paramT;
      } while (Modifier.isPublic(localMember.getDeclaringClass().getModifiers()));
      ? = paramT;
    } while (paramT.isAccessible());
    paramT.setAccessible(true);
    return paramT;
  }
  
  public static boolean checkClassExists(String paramString)
  {
    try
    {
      Class.forName(paramString);
      return true;
    }
    catch (ClassNotFoundException paramString) {}
    return false;
  }
  
  private Method exactMethod(String paramString, Class<?>[] paramArrayOfClass)
  {
    Class localClass = type();
    try
    {
      i = localClass.hashCode();
      j = paramString.hashCode();
      i = Arrays.hashCode(paramArrayOfClass) + (i + j);
      if (mMethodMap.get(i) != null) {
        return (Method)mMethodMap.get(i);
      }
      Method localMethod1 = localClass.getMethod(paramString, paramArrayOfClass);
      if (localMethod1 != null)
      {
        mMethodMap.put(i, localMethod1);
        return localMethod1;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      for (;;)
      {
        try
        {
          int i = localClass.hashCode();
          int j = paramString.hashCode();
          i = Arrays.hashCode(paramArrayOfClass) + (i + j);
          if (mMethodMap.get(i) != null) {
            return (Method)mMethodMap.get(i);
          }
          Method localMethod2 = (Method)accessible(localClass.getDeclaredMethod(paramString, paramArrayOfClass));
          if (localMethod2 != null)
          {
            mMethodMap.put(i, localMethod2);
            return localMethod2;
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          localClass = localClass.getSuperclass();
          if (localClass == null) {
            throw new NoSuchMethodException();
          }
        }
      }
      return localNoSuchMethodException2;
    }
  }
  
  private Field field0(String paramString)
  {
    Class localClass = type();
    try
    {
      i = localClass.hashCode();
      i = paramString.hashCode() + i;
      if (mFieldMap.get(i) != null) {
        return (Field)mFieldMap.get(i);
      }
      localField2 = localClass.getField(paramString);
      localField1 = localField2;
      if (localField2 != null)
      {
        mFieldMap.put(i, localField2);
        return localField2;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException2)
    {
      for (;;)
      {
        try
        {
          int i = localClass.hashCode();
          i = paramString.hashCode() + i;
          if (mFieldMap.get(i) != null) {
            return (Field)mFieldMap.get(i);
          }
          Field localField2 = (Field)accessible(localClass.getDeclaredField(paramString));
          Field localField1 = localField2;
          if (localField2 == null) {
            break;
          }
          mFieldMap.put(i, localField2);
          return localField2;
        }
        catch (NoSuchFieldException localNoSuchFieldException1)
        {
          localClass = localClass.getSuperclass();
          if (localClass == null) {
            throw new ReflectException(localNoSuchFieldException2);
          }
        }
      }
      return localNoSuchFieldException1;
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
      if (paramString != null)
      {
        mClassMap.put(i, paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      throw new ReflectException(paramString);
    }
    return paramString;
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
      if (i < paramArrayOfClass2.length)
      {
        if (paramArrayOfClass2[i] == Reflect.NULL.class) {}
        while (wrapper(paramArrayOfClass1[i]).isAssignableFrom(wrapper(paramArrayOfClass2[i])))
        {
          i += 1;
          break;
        }
      }
    }
    else
    {
      return false;
    }
    return true;
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
    return paramString.substring(0, 1).toLowerCase() + paramString.substring(1);
  }
  
  private Method similarMethod(String paramString, Class<?>[] paramArrayOfClass)
  {
    Object localObject2 = type();
    Method[] arrayOfMethod = ((Class)localObject2).getMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    Object localObject1;
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
      localObject2 = ((Class)localObject1).getSuperclass();
      localObject1 = localObject2;
    } while (localObject2 != null);
    throw new NoSuchMethodException("No similar method " + paramString + " with params " + Arrays.toString(paramArrayOfClass) + " could be found on type " + type() + ".");
  }
  
  private static Class<?>[] types(Object... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs == null) {
      return new Class[0];
    }
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    if (i < paramVarArgs.length)
    {
      Object localObject = paramVarArgs[i];
      if (localObject == null) {}
      for (localObject = Reflect.NULL.class;; localObject = localObject.getClass())
      {
        arrayOfClass[i] = localObject;
        i += 1;
        break;
      }
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
    Class<?> localClass;
    if (paramClass == null) {
      localClass = null;
    }
    do
    {
      do
      {
        return localClass;
        localClass = paramClass;
      } while (!paramClass.isPrimitive());
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
      localClass = paramClass;
    } while (Void.TYPE != paramClass);
    return Void.class;
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
    try
    {
      Reflect localReflect = on(exactMethod(paramString, arrayOfClass), this.object, paramVarArgs);
      return localReflect;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
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
  
  /* Error */
  public Reflect create(Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 341	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:types	([Ljava/lang/Object;)[Ljava/lang/Class;
    //   4: astore 5
    //   6: aload_0
    //   7: invokevirtual 96	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:type	()Ljava/lang/Class;
    //   10: astore 4
    //   12: aload 5
    //   14: invokevirtual 99	java/lang/Object:hashCode	()I
    //   17: aload_1
    //   18: invokestatic 107	java/util/Arrays:hashCode	([Ljava/lang/Object;)I
    //   21: iadd
    //   22: istore_2
    //   23: getstatic 30	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:mConsMap	Landroid/util/SparseArray;
    //   26: iload_2
    //   27: invokevirtual 111	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   30: ifnull +22 -> 52
    //   33: getstatic 30	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:mConsMap	Landroid/util/SparseArray;
    //   36: iload_2
    //   37: invokevirtual 111	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   40: checkcast 203	java/lang/reflect/Constructor
    //   43: astore 4
    //   45: aload 4
    //   47: aload_1
    //   48: invokestatic 354	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:on	(Ljava/lang/reflect/Constructor;[Ljava/lang/Object;)Lcom/tencent/qqmini/sdk/launcher/dynamic/Reflect;
    //   51: areturn
    //   52: aload 4
    //   54: aload 5
    //   56: invokevirtual 358	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   59: invokestatic 125	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:accessible	(Ljava/lang/reflect/AccessibleObject;)Ljava/lang/reflect/AccessibleObject;
    //   62: checkcast 203	java/lang/reflect/Constructor
    //   65: astore 4
    //   67: getstatic 30	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:mConsMap	Landroid/util/SparseArray;
    //   70: iload_2
    //   71: aload 4
    //   73: invokevirtual 120	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   76: goto -31 -> 45
    //   79: astore 4
    //   81: aload_0
    //   82: invokevirtual 96	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:type	()Ljava/lang/Class;
    //   85: invokevirtual 362	java/lang/Class:getDeclaredConstructors	()[Ljava/lang/reflect/Constructor;
    //   88: astore 6
    //   90: aload 6
    //   92: arraylength
    //   93: istore_3
    //   94: iconst_0
    //   95: istore_2
    //   96: iload_2
    //   97: iload_3
    //   98: if_icmpge +43 -> 141
    //   101: aload 6
    //   103: iload_2
    //   104: aaload
    //   105: astore 7
    //   107: aload_0
    //   108: aload 7
    //   110: invokevirtual 363	java/lang/reflect/Constructor:getParameterTypes	()[Ljava/lang/Class;
    //   113: aload 5
    //   115: invokespecial 173	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:match	([Ljava/lang/Class;[Ljava/lang/Class;)Z
    //   118: ifeq +16 -> 134
    //   121: aload 7
    //   123: invokestatic 125	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:accessible	(Ljava/lang/reflect/AccessibleObject;)Ljava/lang/reflect/AccessibleObject;
    //   126: checkcast 203	java/lang/reflect/Constructor
    //   129: aload_1
    //   130: invokestatic 354	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:on	(Ljava/lang/reflect/Constructor;[Ljava/lang/Object;)Lcom/tencent/qqmini/sdk/launcher/dynamic/Reflect;
    //   133: areturn
    //   134: iload_2
    //   135: iconst_1
    //   136: iadd
    //   137: istore_2
    //   138: goto -42 -> 96
    //   141: new 144	com/tencent/qqmini/sdk/launcher/dynamic/ReflectException
    //   144: dup
    //   145: aload 4
    //   147: invokespecial 147	com/tencent/qqmini/sdk/launcher/dynamic/ReflectException:<init>	(Ljava/lang/Throwable;)V
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	Reflect
    //   0	151	1	paramVarArgs	Object[]
    //   22	116	2	i	int
    //   93	6	3	j	int
    //   10	62	4	localObject	Object
    //   79	67	4	localNoSuchMethodException	NoSuchMethodException
    //   4	110	5	arrayOfClass	Class[]
    //   88	14	6	arrayOfConstructor	Constructor[]
    //   105	17	7	localConstructor	Constructor
    // Exception table:
    //   from	to	target	type
    //   6	45	79	java/lang/NoSuchMethodException
    //   45	52	79	java/lang/NoSuchMethodException
    //   52	76	79	java/lang/NoSuchMethodException
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
      int k = localObject2.length;
      int i = 0;
      if (i < k)
      {
        String str = localObject2[i];
        if (!this.isClass) {}
        for (int j = 1;; j = 0)
        {
          if ((j ^ Modifier.isStatic(str.getModifiers())) != 0)
          {
            str = str.getName();
            if (!localLinkedHashMap.containsKey(str)) {
              localLinkedHashMap.put(str, field(str));
            }
          }
          i += 1;
          break;
        }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.dynamic.Reflect
 * JD-Core Version:    0.7.0.1
 */