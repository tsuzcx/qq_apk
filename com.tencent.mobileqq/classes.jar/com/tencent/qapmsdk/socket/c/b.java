package com.tencent.qapmsdk.socket.c;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static final ConcurrentHashMap<String, a> a = new ConcurrentHashMap();
  
  public static a a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1;
    Object localObject2;
    if (a.get(paramString) == null)
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("/");
      localObject2 = ((StringBuilder)localObject2).toString();
      paramString = (String)localObject1;
      localObject1 = localObject2;
    }
    else
    {
      localObject2 = a;
      localObject1 = paramString;
      paramString = (String)localObject2;
    }
    return (a)paramString.get(localObject1);
  }
  
  public static void a(String paramString, a parama)
  {
    if ((!TextUtils.isEmpty(paramString)) && (parama != null) && (a.get(paramString) == null))
    {
      parama.q = com.tencent.qapmsdk.dns.b.b.b(parama.d);
      a.put(paramString, parama);
    }
  }
  
  public static void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((a)a.get(paramString) != null) {
      a.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.c.b
 * JD-Core Version:    0.7.0.1
 */