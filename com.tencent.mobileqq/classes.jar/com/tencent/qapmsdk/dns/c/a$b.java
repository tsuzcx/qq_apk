package com.tencent.qapmsdk.dns.c;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

class a$b
  extends a
{
  private static final int[] d = { 50, 150, 250, 350, 450, 550 };
  
  public List<String> a(String paramString, List<String> paramList)
  {
    Object localObject1 = com.tencent.qapmsdk.dns.a.c.a().a(paramString);
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      localObject1 = b.a(paramString, paramList);
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          SystemClock.elapsedRealtime();
          localObject2 = com.tencent.qapmsdk.dns.a.a.a().b(paramString);
          localObject1 = paramList;
        } while (localObject2 == null);
        localObject2 = ((com.tencent.qapmsdk.dns.b.a)localObject2).b;
        localObject1 = paramList;
      } while (localObject2 == null);
      localObject1 = paramList;
    } while (((CopyOnWriteArrayList)localObject2).size() == 0);
    ArrayList localArrayList = new ArrayList();
    localObject1 = d;
    int j = localObject1.length;
    int i = 0;
    int k;
    while (i < j)
    {
      k = localObject1[i];
      localArrayList.add(new ArrayList());
      i += 1;
    }
    localObject1 = null;
    double d1 = 1.7976931348623157E+308D;
    Iterator localIterator = ((CopyOnWriteArrayList)localObject2).iterator();
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject3 = (com.tencent.qapmsdk.dns.b.c)localIterator.next();
      j = 0;
      double d2 = d1;
      localObject2 = localObject1;
      if (((com.tencent.qapmsdk.dns.b.c)localObject3).c < d1)
      {
        d2 = ((com.tencent.qapmsdk.dns.b.c)localObject3).c;
        localObject2 = localObject3;
      }
      i = 0;
      for (;;)
      {
        d1 = d2;
        localObject1 = localObject2;
        if (i >= d.length) {
          break;
        }
        k = d[i];
        if ((((com.tencent.qapmsdk.dns.b.c)localObject3).c >= j) && (((com.tencent.qapmsdk.dns.b.c)localObject3).c < k))
        {
          ((List)localArrayList.get(i)).add(localObject3);
          d1 = d2;
          localObject1 = localObject2;
          break;
        }
        j += k;
        i += 1;
      }
    }
    Object localObject2 = localArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (List)((Iterator)localObject2).next();
      i = ((List)localObject3).size();
      if (i > 0) {
        localObject1 = (com.tencent.qapmsdk.dns.b.c)((List)localObject3).get(new Random().nextInt(i));
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        j = paramList.indexOf(((com.tencent.qapmsdk.dns.b.c)localObject1).a);
        paramString = new ArrayList();
        paramString.add(((com.tencent.qapmsdk.dns.b.c)localObject1).a);
        i = 0;
        if (i < paramList.size())
        {
          if (i == j) {}
          for (;;)
          {
            i += 1;
            break;
            paramString.add(paramList.get(i));
          }
        }
        return paramString;
      }
      return b.a(paramString, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.c.a.b
 * JD-Core Version:    0.7.0.1
 */