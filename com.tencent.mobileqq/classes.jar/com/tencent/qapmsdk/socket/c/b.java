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
    if (a.get(paramString) == null) {
      return (a)a.get(paramString + "/");
    }
    return (a)a.get(paramString);
  }
  
  public static void a(String paramString, a parama)
  {
    if ((!TextUtils.isEmpty(paramString)) && (parama != null))
    {
      parama.q = com.tencent.qapmsdk.dns.b.b.b(parama.d);
      if (a.get(paramString) == null) {
        a.put(paramString, parama);
      }
    }
  }
  
  public static void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((a)a.get(paramString) == null) {
      return;
    }
    a.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.c.b
 * JD-Core Version:    0.7.0.1
 */