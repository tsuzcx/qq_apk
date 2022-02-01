package com.tencent.xweb.internal;

import com.tencent.xweb.WebView.c;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class k
{
  private static ConcurrentMap<WebView.c, f> a = new ConcurrentHashMap(3);
  
  public static f a(WebView.c paramc)
  {
    return (f)a.get(paramc);
  }
  
  public static void a(WebView.c paramc, f paramf)
  {
    a.put(paramc, paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.internal.k
 * JD-Core Version:    0.7.0.1
 */