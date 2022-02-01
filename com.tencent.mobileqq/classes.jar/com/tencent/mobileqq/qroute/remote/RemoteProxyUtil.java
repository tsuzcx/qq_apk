package com.tencent.mobileqq.qroute.remote;

import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.QRemote;
import com.tencent.mobileqq.qroute.route.ILogger;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class RemoteProxyUtil
{
  public static final String KEY_CALL_API = "callApi";
  public static final String KEY_CALL_RUNTIME_SERVICE = "callService";
  public static final String KEY_RESULT = "result";
  public static final String KEY_RESULT_TYPE = "resultType";
  public static final String SPLIT_CHAR = "$";
  private static final Class<?>[] SUPPORTED_CLASS = { Short.TYPE, Integer.TYPE, Long.TYPE, Double.TYPE, Float.TYPE, Boolean.TYPE, Character.TYPE, Byte.TYPE, String.class, Boolean.class, Parcelable.class, Serializable.class };
  private static final String TAG = "RemoteProxyUtil";
  
  public static void checkCurrentThread(@NonNull Class<?> paramClass, @NonNull Method paramMethod)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      throw new IllegalThreadStateException("IPC Dynamic class " + paramClass.getName() + "#" + paramMethod.getName() + " can't invoke in MainThread");
    }
  }
  
  public static void checkMethodAndParameter(@NonNull Method paramMethod, boolean paramBoolean, @Nullable Object[] paramArrayOfObject)
  {
    Class[] arrayOfClass;
    int i;
    if (!paramMethod.isAnnotationPresent(QRemote.class))
    {
      if (paramBoolean)
      {
        QRoute.logger.warning("RemoteProxyUtil", getMethodExceptionString(paramMethod) + " has not QRemote annotation");
        throw new IllegalArgumentException(getMethodExceptionString(paramMethod) + " has not QRemote annotation");
      }
    }
    else
    {
      arrayOfClass = paramMethod.getParameterTypes();
      i = 0;
      if (i < arrayOfClass.length) {
        if (paramArrayOfObject == null) {
          break label301;
        }
      }
    }
    label301:
    for (Object localObject = paramArrayOfObject[i];; localObject = null)
    {
      if (!isSupportedClass(arrayOfClass[i], localObject))
      {
        QRoute.logger.warning("RemoteProxyUtil", getMethodExceptionString(paramMethod) + " has unsupported param:" + arrayOfClass[i].getName());
        throw new IllegalArgumentException(getMethodExceptionString(paramMethod) + " has unsupported param:" + arrayOfClass[i].getName());
      }
      i += 1;
      break;
      if ((!paramMethod.getReturnType().equals(Void.TYPE)) && (!isSupportedClass(paramMethod.getReturnType(), null)))
      {
        QRoute.logger.warning("RemoteProxyUtil", getMethodExceptionString(paramMethod) + " has unsupported return type:" + paramMethod.getReturnType());
        throw new IllegalArgumentException(getMethodExceptionString(paramMethod) + " has unsupported return type:" + paramMethod.getReturnType());
      }
      return;
    }
  }
  
  @Nullable
  public static Object getBundleParameter(@NonNull Bundle paramBundle, @NonNull String paramString1, @NonNull String paramString2)
  {
    if (paramString1.endsWith("void")) {
      return null;
    }
    int i = -1;
    switch (paramString1.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = Class.forName(paramString1);
        if (((Class)localObject1).getInterfaces().length > 0)
        {
          localObject1 = ((Class)localObject1).getInterfaces();
          if (localObject1 != null)
          {
            int j = localObject1.length;
            i = 0;
            if (i < j)
            {
              localObject3 = localObject1[i];
              if (localObject3.isAssignableFrom(Parcelable.class))
              {
                return paramBundle.getParcelable(paramString2);
                if (!paramString1.equals("byte")) {
                  break;
                }
                i = 0;
                break;
                if (!paramString1.equals("short")) {
                  break;
                }
                i = 1;
                break;
                if (!paramString1.equals("int")) {
                  break;
                }
                i = 2;
                break;
                if (!paramString1.equals("long")) {
                  break;
                }
                i = 3;
                break;
                if (!paramString1.equals("double")) {
                  break;
                }
                i = 4;
                break;
                if (!paramString1.equals("float")) {
                  break;
                }
                i = 5;
                break;
                if (!paramString1.equals("java.lang.Boolean")) {
                  break;
                }
                i = 6;
                break;
                if (!paramString1.equals("boolean")) {
                  break;
                }
                i = 7;
                break;
                if (!paramString1.equals("char")) {
                  break;
                }
                i = 8;
                break;
                if (!paramString1.equals("java.lang.String")) {
                  break;
                }
                i = 9;
                break;
                if (!paramString1.equals("java.util.List")) {
                  break;
                }
                i = 10;
                break;
                if (!paramString1.equals("java.util.ArrayList")) {
                  break;
                }
                i = 11;
                break;
                if (!paramString1.equals("java.util.HashMap")) {
                  break;
                }
                i = 12;
                break;
                return Byte.valueOf(paramBundle.getByte(paramString2));
                return Short.valueOf(paramBundle.getShort(paramString2));
                return Integer.valueOf(paramBundle.getInt(paramString2));
                return Long.valueOf(paramBundle.getLong(paramString2));
                return Double.valueOf(paramBundle.getDouble(paramString2));
                return Float.valueOf(paramBundle.getFloat(paramString2));
                return Boolean.valueOf(paramBundle.getBoolean(paramString2));
                return Character.valueOf(paramBundle.getChar(paramString2));
                return paramBundle.getString(paramString2);
                return getListObject(paramBundle, paramString2);
                return paramBundle.getSerializable(paramString2);
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject3;
        localException.printStackTrace();
        QRoute.logger.warning("RemoteProxyUtil", "getBundleParameter error", localException);
        localObject2 = null;
        continue;
        if (localObject3.isAssignableFrom(Serializable.class)) {
          return paramBundle.getSerializable(paramString2);
        }
        if (localObject3.isAssignableFrom(Collection.class)) {
          return getListObject(paramBundle, paramString2);
        }
        if (localObject3.isAssignableFrom(HashMap.class)) {
          return paramBundle.getSerializable(paramString2);
        }
        i += 1;
        continue;
        QRoute.logger.warning("RemoteProxyUtil", "getBundleParameter unSupportClass=" + paramString1);
        return null;
      }
      Object localObject2 = null;
    }
  }
  
  public static Class<?> getClassFromName(@NonNull String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return Class.forName(paramString);
        if (paramString.equals("byte"))
        {
          i = 0;
          continue;
          if (paramString.equals("short"))
          {
            i = 1;
            continue;
            if (paramString.equals("int"))
            {
              i = 2;
              continue;
              if (paramString.equals("long"))
              {
                i = 3;
                continue;
                if (paramString.equals("double"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("float"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("boolean"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("char"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("java.lang.String"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("java.lang.Boolean"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("java.util.ArrayList"))
                            {
                              i = 10;
                              continue;
                              if (paramString.equals("java.io.Serializable"))
                              {
                                i = 11;
                                continue;
                                if (paramString.equals("java.util.HashMap"))
                                {
                                  i = 12;
                                  continue;
                                  if (paramString.equals("android.os.Parcelable")) {
                                    i = 13;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return Byte.TYPE;
    return Short.TYPE;
    return Integer.TYPE;
    return Long.TYPE;
    return Double.TYPE;
    return Float.TYPE;
    return Boolean.TYPE;
    return Character.TYPE;
    return String.class;
    return Boolean.class;
    return ArrayList.class;
    return Serializable.class;
    return HashMap.class;
    return Parcelable.class;
  }
  
  private static Object getListObject(Bundle paramBundle, String paramString)
  {
    Object localObject2 = paramBundle.getParcelableArrayList(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramBundle.getStringArrayList(paramString);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramBundle.getIntegerArrayList(paramString);
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramBundle.getSerializable(paramString);
    }
    if (localObject1 == null) {
      QRoute.logger.warning("RemoteProxyUtil", "getListObject unSupportList, key=" + paramString);
    }
    return localObject1;
  }
  
  private static String getMethodExceptionString(@NonNull Method paramMethod)
  {
    return "QRemote Annotation Method " + paramMethod.getClass().getName() + "#" + paramMethod.getName();
  }
  
  private static boolean isDeclareAssignableFrom(Class<?> paramClass1, Class<?> paramClass2)
  {
    try
    {
      paramClass1.asSubclass(paramClass2);
      return true;
    }
    catch (ClassCastException paramClass1) {}
    return false;
  }
  
  public static boolean isSupportedClass(Class<?> paramClass, @Nullable Object paramObject)
  {
    Class[] arrayOfClass = SUPPORTED_CLASS;
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      if ((paramClass.isAssignableFrom(localClass)) || (isDeclareAssignableFrom(paramClass, localClass))) {
        return true;
      }
      i += 1;
    }
    return isSupportedListClass(paramClass, paramObject);
  }
  
  private static boolean isSupportedListClass(Class<?> paramClass, @Nullable Object paramObject)
  {
    if (isDeclareAssignableFrom(paramClass, List.class))
    {
      if (paramObject == null) {}
      do
      {
        return true;
        if (!(paramObject instanceof List)) {
          break;
        }
        paramClass = (List)paramObject;
      } while (paramClass.isEmpty());
      if (((paramClass.get(0) instanceof String)) || ((paramClass.get(0) instanceof Integer)) || ((paramClass.get(0) instanceof Parcelable)) || ((paramObject instanceof Serializable))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return false;
  }
  
  private static void putListObject(Bundle paramBundle, String paramString, Object paramObject)
  {
    List localList;
    if ((paramObject instanceof List))
    {
      localList = (List)paramObject;
      if (localList.isEmpty()) {
        break label107;
      }
      if (!(localList.get(0) instanceof String)) {
        break label44;
      }
      paramBundle.putStringArrayList(paramString, (ArrayList)paramObject);
    }
    label44:
    label107:
    while (!(paramObject instanceof Serializable))
    {
      do
      {
        return;
        if ((localList.get(0) instanceof Integer))
        {
          paramBundle.putIntegerArrayList(paramString, (ArrayList)paramObject);
          return;
        }
        if ((localList.get(0) instanceof Parcelable))
        {
          paramBundle.putParcelableArrayList(paramString, (ArrayList)paramObject);
          return;
        }
      } while (!(paramObject instanceof Serializable));
      paramBundle.putSerializable(paramString, (Serializable)paramObject);
      return;
    }
    paramBundle.putSerializable(paramString, (Serializable)paramObject);
  }
  
  public static void setBundleParameter(@NonNull Bundle paramBundle, @NonNull String paramString1, @NonNull String paramString2, @NonNull Object paramObject)
  {
    if ("int".equals(paramString1)) {
      paramBundle.putInt(paramString2, ((Integer)paramObject).intValue());
    }
    do
    {
      return;
      if ("java.lang.String".equals(paramString1))
      {
        paramBundle.putString(paramString2, (String)paramObject);
        return;
      }
      if ("java.lang.Boolean".equals(paramString1))
      {
        paramBundle.putBoolean(paramString2, ((Boolean)paramObject).booleanValue());
        return;
      }
      if ("long".equals(paramString1))
      {
        paramBundle.putLong(paramString2, ((Long)paramObject).longValue());
        return;
      }
      if ("byte".equals(paramString1))
      {
        paramBundle.putByte(paramString2, ((Byte)paramObject).byteValue());
        return;
      }
      if ("double".equals(paramString1))
      {
        paramBundle.putDouble(paramString2, ((Double)paramObject).doubleValue());
        return;
      }
      if ("short".equals(paramString1))
      {
        paramBundle.putShort(paramString2, ((Short)paramObject).shortValue());
        return;
      }
      if ("float".equals(paramString1))
      {
        paramBundle.putFloat(paramString2, ((Float)paramObject).floatValue());
        return;
      }
      if ("char".equals(paramString1))
      {
        paramBundle.putChar(paramString2, ((Character)paramObject).charValue());
        return;
      }
      if ("boolean".equals(paramString1))
      {
        paramBundle.putBoolean(paramString2, ((Boolean)paramObject).booleanValue());
        return;
      }
      if ("java.util.List".equals(paramString1))
      {
        putListObject(paramBundle, paramString2, paramObject);
        return;
      }
      if ((paramObject instanceof Parcelable))
      {
        paramBundle.putParcelable(paramString2, (Parcelable)paramObject);
        return;
      }
    } while (!(paramObject instanceof Serializable));
    paramBundle.putSerializable(paramString2, (Serializable)paramObject);
  }
  
  public static void setMethodAndParameter(@NonNull Method paramMethod, Object[] paramArrayOfObject, Bundle paramBundle)
  {
    paramMethod = paramMethod.getParameterTypes();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMethod.length)
    {
      String str1 = "__arg+" + i + "__";
      String str2 = paramMethod[i].getName();
      localArrayList.add(str2);
      setBundleParameter(paramBundle, str2, str1, paramArrayOfObject[i]);
      i += 1;
    }
    paramBundle.putStringArrayList("__parameterTypes__", localArrayList);
  }
  
  public static void verifyClass(@NonNull Class<?> paramClass)
  {
    paramClass = paramClass.getDeclaredMethods();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      checkMethodAndParameter(paramClass[i], false, null);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.remote.RemoteProxyUtil
 * JD-Core Version:    0.7.0.1
 */