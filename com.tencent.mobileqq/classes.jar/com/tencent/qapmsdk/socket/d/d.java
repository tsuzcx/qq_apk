package com.tencent.qapmsdk.socket.d;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class d
{
  private static Map<String, Class<?>> a = new ConcurrentHashMap();
  private static Map<Class<?>, d.a> b = new ConcurrentHashMap();
  private static String c;
  
  @NonNull
  public static d.a a(Class<?> paramClass)
  {
    Object localObject = (d.a)b.get(paramClass);
    if (localObject == null) {
      try
      {
        d.a locala2 = (d.a)b.get(paramClass);
        localObject = locala2;
        if (locala2 == null)
        {
          localObject = new d.a(paramClass);
          b.put(paramClass, localObject);
        }
        return localObject;
      }
      finally {}
    }
    return locala1;
  }
  
  public static d.a a(String paramString)
  {
    Class localClass2 = (Class)a.get(paramString);
    Class localClass1 = localClass2;
    if (localClass2 == null)
    {
      localClass1 = Class.forName(paramString);
      a.put(paramString, localClass1);
    }
    return a(localClass1);
  }
  
  public static String a()
  {
    int i = 0;
    String[] arrayOfString;
    int j;
    if (c == null)
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
        a(str + ".OpenSSLContextImpl");
        c = str;
        if (TextUtils.isEmpty(c)) {
          a(new RuntimeException("cannot find OpenSSLContextImpl"));
        }
        return c;
      }
      catch (Exception localException)
      {
        i += 1;
      }
    }
  }
  
  public static String a(Object paramObject)
  {
    if ((paramObject instanceof FileDescriptor)) {
      try
      {
        String str = "fd[" + a(FileDescriptor.class).a("descriptor").get(paramObject) + "]";
        return str;
      }
      catch (Exception localException) {}
    }
    return String.valueOf(paramObject);
  }
  
  public static void a(Throwable paramThrowable)
  {
    Logger.INSTANCE.exception("QAPM_Socket_ReflectionHelper", paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.d.d
 * JD-Core Version:    0.7.0.1
 */