package com.tencent.qapmsdk.dns.b;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static final ConcurrentHashMap<String, b.a> a = new ConcurrentHashMap();
  
  public static void a()
  {
    a.clear();
  }
  
  public static void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (a.get(paramString) != null)) {
      a.remove(paramString);
    }
  }
  
  public static void a(String paramString, InetAddress[] paramArrayOfInetAddress, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramLong >= 0L) && (a.get(paramString) == null)) {
      a.put(paramString, new b.a(paramArrayOfInetAddress, paramLong));
    }
  }
  
  public static long b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (a.get(paramString) == null)) {
      return 0L;
    }
    b.a locala = (b.a)a.get(paramString);
    if ((locala != null) && (!locala.c))
    {
      locala.c = true;
      a.put(paramString, locala);
      return locala.a;
    }
    return 0L;
  }
  
  public static String c(String paramString)
  {
    Iterator localIterator = a.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = (b.a)a.get(str);
      if (localObject != null)
      {
        localObject = ((b.a)localObject).b;
        if (localObject != null)
        {
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            if (paramString.equals(localObject[i].getHostAddress())) {
              return str;
            }
            i += 1;
          }
        }
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.b.b
 * JD-Core Version:    0.7.0.1
 */