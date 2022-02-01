package com.tencent.qapmsdk.dns.a;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.dns.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
{
  private static a a = new a();
  private Map<String, com.tencent.qapmsdk.dns.b.a> b = new ConcurrentHashMap();
  
  public static a a()
  {
    return a;
  }
  
  List<String> a(String paramString)
  {
    com.tencent.qapmsdk.dns.b.a locala = (com.tencent.qapmsdk.dns.b.a)this.b.get(paramString);
    if (locala != null) {
      if (System.currentTimeMillis() - locala.d > locala.c * 1000L)
      {
        this.b.remove(paramString);
        com.tencent.qapmsdk.dns.b.b.a(paramString);
        return null;
      }
    }
    for (paramString = new ArrayList(locala.a());; paramString = null) {
      return paramString;
    }
  }
  
  public void a(String paramString, List<String> paramList, long paramLong, int paramInt)
  {
    Object localObject1 = (com.tencent.qapmsdk.dns.b.a)this.b.get(paramString);
    if ((localObject1 == null) || (((com.tencent.qapmsdk.dns.b.a)localObject1).g != 1) || (paramInt != 2))
    {
      Object localObject2;
      for (;;)
      {
        try
        {
          localObject1 = (com.tencent.qapmsdk.dns.b.a)this.b.get(paramString);
          if ((localObject1 != null) && (((com.tencent.qapmsdk.dns.b.a)localObject1).g == 1) && (paramInt == 2)) {
            break label307;
          }
          localObject2 = Logger.INSTANCE;
          String str = ", ipList: " + paramList;
          if (paramInt == 1)
          {
            localObject1 = "httpdns";
            ((Logger)localObject2).d(new String[] { "QAPM_DNS_DnsCacheManager", "update cache, host: ", paramString, str, ", ttl: ", String.valueOf(paramLong), "s", ", from: ", localObject1 });
            localObject1 = new com.tencent.qapmsdk.dns.b.a();
            ((com.tencent.qapmsdk.dns.b.a)localObject1).a = paramString;
            ((com.tencent.qapmsdk.dns.b.a)localObject1).c = paramLong;
            ((com.tencent.qapmsdk.dns.b.a)localObject1).d = System.currentTimeMillis();
            ((com.tencent.qapmsdk.dns.b.a)localObject1).e = com.tencent.qapmsdk.dns.network.b.b();
            ((com.tencent.qapmsdk.dns.b.a)localObject1).f = com.tencent.qapmsdk.dns.b.a.a(com.tencent.qapmsdk.dns.network.b.c());
            localObject2 = new CopyOnWriteArrayList();
            paramList = paramList.iterator();
            if (!paramList.hasNext()) {
              break;
            }
            ((CopyOnWriteArrayList)localObject2).add(new c((String)paramList.next()));
            continue;
          }
          localObject1 = "systemdns";
        }
        finally {}
      }
      ((com.tencent.qapmsdk.dns.b.a)localObject1).b = ((CopyOnWriteArrayList)localObject2);
      ((com.tencent.qapmsdk.dns.b.a)localObject1).g = paramInt;
      this.b.put(paramString, localObject1);
      for (;;)
      {
        return;
        label307:
        Logger.INSTANCE.d(new String[] { "QAPM_DNS_DnsCacheManager", "no need to update cache: ", ((com.tencent.qapmsdk.dns.b.a)localObject1).a });
      }
    }
    Logger.INSTANCE.d(new String[] { "QAPM_DNS_DnsCacheManager", "no need to update cache" });
  }
  
  public com.tencent.qapmsdk.dns.b.a b(String paramString)
  {
    return (com.tencent.qapmsdk.dns.b.a)this.b.get(paramString);
  }
  
  public void b()
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (com.tencent.qapmsdk.dns.b.a)this.b.get(localObject);
      if (localObject != null) {
        ((com.tencent.qapmsdk.dns.b.a)localObject).c = 0L;
      }
    }
  }
  
  public void c()
  {
    this.b.clear();
    com.tencent.qapmsdk.dns.b.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.a.a
 * JD-Core Version:    0.7.0.1
 */