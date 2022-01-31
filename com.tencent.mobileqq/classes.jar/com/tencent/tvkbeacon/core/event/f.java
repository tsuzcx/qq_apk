package com.tencent.tvkbeacon.core.event;

import com.tencent.tvkbeacon.core.a.b;
import com.tencent.tvkbeacon.core.c.c;
import java.util.HashMap;
import java.util.Map;

public final class f
{
  private static Map<String, Long> a = null;
  
  public static void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if (a == null) {
      a = new HashMap();
    }
    a.put(paramString, Long.valueOf(l));
    c.b("[page] onPageIn cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public static void b(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (a == null)
    {
      c.c("[page] please call 'onPageIn' first!", new Object[0]);
      return;
    }
    Long localLong = (Long)a.get(paramString);
    if (localLong == null)
    {
      c.c("[page] please call 'onPageIn' first!", new Object[0]);
      return;
    }
    long l2 = localLong.longValue();
    b.d().a(new f.1(l1, paramString, l1 - l2));
    a.remove(paramString);
    c.b("[page] onPageOut cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.event.f
 * JD-Core Version:    0.7.0.1
 */