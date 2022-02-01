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
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IPC Dynamic class ");
    localStringBuilder.append(paramClass.getName());
    localStringBuilder.append("#");
    localStringBuilder.append(paramMethod.getName());
    localStringBuilder.append(" can't invoke in MainThread");
    throw new IllegalThreadStateException(localStringBuilder.toString());
  }
  
  public static void checkMethodAndParameter(@NonNull Method paramMethod, boolean paramBoolean, @Nullable Object[] paramArrayOfObject)
  {
    if (!paramMethod.isAnnotationPresent(QRemote.class))
    {
      if (!paramBoolean) {
        return;
      }
      paramArrayOfObject = QRoute.logger;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getMethodExceptionString(paramMethod));
      ((StringBuilder)localObject).append(" has not QRemote annotation");
      paramArrayOfObject.warning("RemoteProxyUtil", ((StringBuilder)localObject).toString());
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append(getMethodExceptionString(paramMethod));
      paramArrayOfObject.append(" has not QRemote annotation");
      throw new IllegalArgumentException(paramArrayOfObject.toString());
    }
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    int i = 0;
    for (;;)
    {
      int j = arrayOfClass.length;
      localObject = null;
      if (i >= j) {
        break label249;
      }
      if (paramArrayOfObject != null) {
        localObject = paramArrayOfObject[i];
      }
      if (!isSupportedClass(arrayOfClass[i], localObject)) {
        break;
      }
      i += 1;
    }
    paramArrayOfObject = QRoute.logger;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getMethodExceptionString(paramMethod));
    ((StringBuilder)localObject).append(" has unsupported param:");
    ((StringBuilder)localObject).append(arrayOfClass[i].getName());
    paramArrayOfObject.warning("RemoteProxyUtil", ((StringBuilder)localObject).toString());
    paramArrayOfObject = new StringBuilder();
    paramArrayOfObject.append(getMethodExceptionString(paramMethod));
    paramArrayOfObject.append(" has unsupported param:");
    paramArrayOfObject.append(arrayOfClass[i].getName());
    throw new IllegalArgumentException(paramArrayOfObject.toString());
    label249:
    if (!paramMethod.getReturnType().equals(Void.TYPE))
    {
      if (isSupportedClass(paramMethod.getReturnType(), null)) {
        return;
      }
      paramArrayOfObject = QRoute.logger;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getMethodExceptionString(paramMethod));
      ((StringBuilder)localObject).append(" has unsupported return type:");
      ((StringBuilder)localObject).append(paramMethod.getReturnType());
      paramArrayOfObject.warning("RemoteProxyUtil", ((StringBuilder)localObject).toString());
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append(getMethodExceptionString(paramMethod));
      paramArrayOfObject.append(" has unsupported return type:");
      paramArrayOfObject.append(paramMethod.getReturnType());
      throw new IllegalArgumentException(paramArrayOfObject.toString());
    }
  }
  
  @Nullable
  public static Object getBundleParameter(@NonNull Bundle paramBundle, @NonNull String paramString1, @NonNull String paramString2)
  {
    if (paramString1.endsWith("void")) {
      return null;
    }
    int i = -1;
    int k = paramString1.hashCode();
    int j = 0;
    switch (k)
    {
    default: 
      break;
    case 1195259493: 
      if (paramString1.equals("java.lang.String")) {
        i = 9;
      }
      break;
    case 344809556: 
      if (paramString1.equals("java.lang.Boolean")) {
        i = 6;
      }
      break;
    case 109413500: 
      if (paramString1.equals("short")) {
        i = 1;
      }
      break;
    case 97526364: 
      if (paramString1.equals("float")) {
        i = 5;
      }
      break;
    case 65821278: 
      if (paramString1.equals("java.util.List")) {
        i = 10;
      }
      break;
    case 64711720: 
      if (paramString1.equals("boolean")) {
        i = 7;
      }
      break;
    case 3327612: 
      if (paramString1.equals("long")) {
        i = 3;
      }
      break;
    case 3052374: 
      if (paramString1.equals("char")) {
        i = 8;
      }
      break;
    case 3039496: 
      if (paramString1.equals("byte")) {
        i = 0;
      }
      break;
    case 104431: 
      if (paramString1.equals("int")) {
        i = 2;
      }
      break;
    case -1114099497: 
      if (paramString1.equals("java.util.ArrayList")) {
        i = 11;
      }
      break;
    case -1325958191: 
      if (paramString1.equals("double")) {
        i = 4;
      }
      break;
    case -1402722386: 
      if (paramString1.equals("java.util.HashMap")) {
        i = 12;
      }
      break;
    }
    switch (i)
    {
    default: 
      break;
    case 12: 
      return paramBundle.getSerializable(paramString2);
    case 10: 
    case 11: 
      return getListObject(paramBundle, paramString2);
    case 9: 
      return paramBundle.getString(paramString2);
    case 8: 
      return Character.valueOf(paramBundle.getChar(paramString2));
    case 6: 
    case 7: 
      return Boolean.valueOf(paramBundle.getBoolean(paramString2));
    case 5: 
      return Float.valueOf(paramBundle.getFloat(paramString2));
    case 4: 
      return Double.valueOf(paramBundle.getDouble(paramString2));
    case 3: 
      return Long.valueOf(paramBundle.getLong(paramString2));
    case 2: 
      return Integer.valueOf(paramBundle.getInt(paramString2));
    case 1: 
      return Short.valueOf(paramBundle.getShort(paramString2));
    case 0: 
      return Byte.valueOf(paramBundle.getByte(paramString2));
    }
    Object localObject2;
    try
    {
      Object localObject1 = Class.forName(paramString1);
      if (((Class)localObject1).getInterfaces().length > 0) {
        localObject1 = ((Class)localObject1).getInterfaces();
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QRoute.logger.warning("RemoteProxyUtil", "getBundleParameter error", localException);
      localObject2 = null;
    }
    if (localObject2 != null)
    {
      k = localObject2.length;
      i = j;
      while (i < k)
      {
        Object localObject3 = localObject2[i];
        if (localObject3.isAssignableFrom(Parcelable.class)) {
          return paramBundle.getParcelable(paramString2);
        }
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
      }
    }
    paramBundle = QRoute.logger;
    paramString2 = new StringBuilder();
    paramString2.append("getBundleParameter unSupportClass=");
    paramString2.append(paramString1);
    paramBundle.warning("RemoteProxyUtil", paramString2.toString());
    return null;
  }
  
  public static Class<?> getClassFromName(@NonNull String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1832181019: 
      if (paramString.equals("java.io.Serializable")) {
        i = 11;
      }
      break;
    case 1195259493: 
      if (paramString.equals("java.lang.String")) {
        i = 8;
      }
      break;
    case 344809556: 
      if (paramString.equals("java.lang.Boolean")) {
        i = 9;
      }
      break;
    case 109413500: 
      if (paramString.equals("short")) {
        i = 1;
      }
      break;
    case 97526364: 
      if (paramString.equals("float")) {
        i = 5;
      }
      break;
    case 64711720: 
      if (paramString.equals("boolean")) {
        i = 6;
      }
      break;
    case 3327612: 
      if (paramString.equals("long")) {
        i = 3;
      }
      break;
    case 3052374: 
      if (paramString.equals("char")) {
        i = 7;
      }
      break;
    case 3039496: 
      if (paramString.equals("byte")) {
        i = 0;
      }
      break;
    case 104431: 
      if (paramString.equals("int")) {
        i = 2;
      }
      break;
    case -361922034: 
      if (paramString.equals("android.os.Parcelable")) {
        i = 13;
      }
      break;
    case -1114099497: 
      if (paramString.equals("java.util.ArrayList")) {
        i = 10;
      }
      break;
    case -1325958191: 
      if (paramString.equals("double")) {
        i = 4;
      }
      break;
    case -1402722386: 
      if (paramString.equals("java.util.HashMap")) {
        i = 12;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      return Class.forName(paramString);
    case 13: 
      return Parcelable.class;
    case 12: 
      return HashMap.class;
    case 11: 
      return Serializable.class;
    case 10: 
      return ArrayList.class;
    case 9: 
      return Boolean.class;
    case 8: 
      return String.class;
    case 7: 
      return Character.TYPE;
    case 6: 
      return Boolean.TYPE;
    case 5: 
      return Float.TYPE;
    case 4: 
      return Double.TYPE;
    case 3: 
      return Long.TYPE;
    case 2: 
      return Integer.TYPE;
    case 1: 
      return Short.TYPE;
    }
    return Byte.TYPE;
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
    if (localObject1 == null)
    {
      paramBundle = QRoute.logger;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getListObject unSupportList, key=");
      ((StringBuilder)localObject2).append(paramString);
      paramBundle.warning("RemoteProxyUtil", ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  private static String getMethodExceptionString(@NonNull Method paramMethod)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QRemote Annotation Method ");
    localStringBuilder.append(paramMethod.getClass().getName());
    localStringBuilder.append("#");
    localStringBuilder.append(paramMethod.getName());
    return localStringBuilder.toString();
  }
  
  private static boolean isDeclareAssignableFrom(Class<?> paramClass1, Class<?> paramClass2)
  {
    try
    {
      paramClass1.asSubclass(paramClass2);
      return true;
    }
    catch (ClassCastException paramClass1)
    {
      label8:
      break label8;
    }
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
      if ((!paramClass.isAssignableFrom(localClass)) && (!isDeclareAssignableFrom(paramClass, localClass))) {
        i += 1;
      } else {
        return true;
      }
    }
    return isSupportedListClass(paramClass, paramObject);
  }
  
  private static boolean isSupportedListClass(Class<?> paramClass, @Nullable Object paramObject)
  {
    if (isDeclareAssignableFrom(paramClass, List.class))
    {
      boolean bool2 = true;
      if (paramObject == null) {
        return true;
      }
      if ((paramObject instanceof List))
      {
        paramClass = (List)paramObject;
        if (paramClass.isEmpty()) {
          return true;
        }
        boolean bool1 = bool2;
        if (!(paramClass.get(0) instanceof String))
        {
          bool1 = bool2;
          if (!(paramClass.get(0) instanceof Integer))
          {
            bool1 = bool2;
            if (!(paramClass.get(0) instanceof Parcelable))
            {
              if ((paramObject instanceof Serializable)) {
                return true;
              }
              bool1 = false;
            }
          }
        }
        return bool1;
      }
    }
    return false;
  }
  
  private static void putListObject(Bundle paramBundle, String paramString, Object paramObject)
  {
    if ((paramObject instanceof List))
    {
      List localList = (List)paramObject;
      if (!localList.isEmpty())
      {
        if ((localList.get(0) instanceof String))
        {
          paramBundle.putStringArrayList(paramString, (ArrayList)paramObject);
          return;
        }
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
        if ((paramObject instanceof Serializable)) {
          paramBundle.putSerializable(paramString, (Serializable)paramObject);
        }
      }
      else if ((paramObject instanceof Serializable))
      {
        paramBundle.putSerializable(paramString, (Serializable)paramObject);
      }
    }
  }
  
  public static void setBundleParameter(@NonNull Bundle paramBundle, @NonNull String paramString1, @NonNull String paramString2, @NonNull Object paramObject)
  {
    if ("int".equals(paramString1))
    {
      paramBundle.putInt(paramString2, ((Integer)paramObject).intValue());
      return;
    }
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
    if ((paramObject instanceof Serializable)) {
      paramBundle.putSerializable(paramString2, (Serializable)paramObject);
    }
  }
  
  public static void setMethodAndParameter(@NonNull Method paramMethod, Object[] paramArrayOfObject, Bundle paramBundle)
  {
    paramMethod = paramMethod.getParameterTypes();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMethod.length)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("__arg+");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("__");
      localObject = ((StringBuilder)localObject).toString();
      String str = paramMethod[i].getName();
      localArrayList.add(str);
      setBundleParameter(paramBundle, str, (String)localObject, paramArrayOfObject[i]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.remote.RemoteProxyUtil
 * JD-Core Version:    0.7.0.1
 */