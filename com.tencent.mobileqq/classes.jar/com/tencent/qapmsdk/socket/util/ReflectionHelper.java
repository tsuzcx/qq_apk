package com.tencent.qapmsdk.socket.util;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class ReflectionHelper
{
  private static final int MAGIC_NUMBER = 11259375;
  private static final String TAG = "QAPM_Socket_ReflectionHelper";
  private static Map<String, Class<?>> classMap = new ConcurrentHashMap();
  private static Map<Class<?>, ReflectionHelper.Cache> reflectClassCacheMap = new ConcurrentHashMap();
  private static String sOpenSSLPackageName;
  
  public static Object fieldValue(Object paramObject, String paramString)
  {
    return of(paramObject.getClass()).field(paramString).get(paramObject);
  }
  
  public static String getOpenSSLPackageName()
  {
    int i = 0;
    String[] arrayOfString;
    int j;
    if (sOpenSSLPackageName == null)
    {
      arrayOfString = new String[3];
      arrayOfString[0] = "com.android.org.conscrypt";
      arrayOfString[1] = "org.conscrypt";
      arrayOfString[2] = "org.apache.harmony.xnet.provider.jsse";
      j = arrayOfString.length;
    }
    for (;;)
    {
      String str;
      if (i < j) {
        str = arrayOfString[i];
      }
      try
      {
        of(str + ".OpenSSLContextImpl");
        sOpenSSLPackageName = str;
        if (TextUtils.isEmpty(sOpenSSLPackageName)) {
          processException(new RuntimeException("cannot find OpenSSLContextImpl"));
        }
        return sOpenSSLPackageName;
      }
      catch (Exception localException)
      {
        i += 1;
      }
    }
  }
  
  public static ReflectionHelper.RetrofitCache instance(Object paramObject)
  {
    return new ReflectionHelper.RetrofitCache(paramObject);
  }
  
  @NonNull
  public static ReflectionHelper.Cache of(Class<?> paramClass)
  {
    Object localObject = (ReflectionHelper.Cache)reflectClassCacheMap.get(paramClass);
    if (localObject == null) {
      try
      {
        ReflectionHelper.Cache localCache2 = (ReflectionHelper.Cache)reflectClassCacheMap.get(paramClass);
        localObject = localCache2;
        if (localCache2 == null)
        {
          localObject = new ReflectionHelper.Cache(paramClass);
          reflectClassCacheMap.put(paramClass, localObject);
        }
        return localObject;
      }
      finally {}
    }
    return localCache1;
  }
  
  public static ReflectionHelper.Cache of(String paramString)
  {
    Class localClass2 = (Class)classMap.get(paramString);
    Class localClass1 = localClass2;
    if (localClass2 == null)
    {
      localClass1 = Class.forName(paramString);
      classMap.put(paramString, localClass1);
    }
    return of(localClass1);
  }
  
  public static String printFd(Object paramObject)
  {
    if ((paramObject instanceof FileDescriptor)) {
      try
      {
        String str = "fd[" + of(FileDescriptor.class).field("descriptor").get(paramObject) + "]";
        return str;
      }
      catch (Exception localException) {}
    }
    return String.valueOf(paramObject);
  }
  
  public static void processException(Throwable paramThrowable)
  {
    Logger.INSTANCE.exception("QAPM_Socket_ReflectionHelper", paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.util.ReflectionHelper
 * JD-Core Version:    0.7.0.1
 */