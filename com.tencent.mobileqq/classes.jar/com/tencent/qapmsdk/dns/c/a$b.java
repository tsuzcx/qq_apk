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
      return b.a(paramString, paramList);
    }
    SystemClock.elapsedRealtime();
    localObject1 = com.tencent.qapmsdk.dns.a.a.a().b(paramString);
    if (localObject1 != null)
    {
      Object localObject2 = ((com.tencent.qapmsdk.dns.b.a)localObject1).b;
      if (localObject2 != null)
      {
        if (((CopyOnWriteArrayList)localObject2).size() == 0) {
          return paramList;
        }
        ArrayList localArrayList = new ArrayList();
        localObject1 = d;
        int j = localObject1.length;
        int k = 0;
        int i = 0;
        int m;
        while (i < j)
        {
          m = localObject1[i];
          localArrayList.add(new ArrayList());
          i += 1;
        }
        localObject1 = null;
        double d1 = 1.7976931348623157E+308D;
        Iterator localIterator = ((CopyOnWriteArrayList)localObject2).iterator();
        if (localIterator.hasNext())
        {
          localObject3 = (com.tencent.qapmsdk.dns.b.c)localIterator.next();
          localObject2 = localObject1;
          double d2 = d1;
          if (((com.tencent.qapmsdk.dns.b.c)localObject3).c < d1)
          {
            d2 = ((com.tencent.qapmsdk.dns.b.c)localObject3).c;
            localObject2 = localObject3;
          }
          i = 0;
          j = 0;
          for (;;)
          {
            int[] arrayOfInt = d;
            localObject1 = localObject2;
            d1 = d2;
            if (i >= arrayOfInt.length) {
              break;
            }
            m = arrayOfInt[i];
            if ((((com.tencent.qapmsdk.dns.b.c)localObject3).c >= j) && (((com.tencent.qapmsdk.dns.b.c)localObject3).c < m))
            {
              ((List)localArrayList.get(i)).add(localObject3);
              localObject1 = localObject2;
              d1 = d2;
              break;
            }
            j += m;
            i += 1;
          }
        }
        Object localObject3 = localArrayList.iterator();
        do
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (List)((Iterator)localObject3).next();
          i = ((List)localObject2).size();
        } while (i <= 0);
        localObject2 = (com.tencent.qapmsdk.dns.b.c)((List)localObject2).get(new Random().nextInt(i));
        if (localObject2 != null)
        {
          j = paramList.indexOf(((com.tencent.qapmsdk.dns.b.c)localObject2).a);
          paramString = new ArrayList();
          paramString.add(((com.tencent.qapmsdk.dns.b.c)localObject2).a);
          i = k;
          while (i < paramList.size())
          {
            if (i != j) {
              paramString.add(paramList.get(i));
            }
            i += 1;
          }
          return paramString;
        }
        return b.a(paramString, paramList);
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.c.a.b
 * JD-Core Version:    0.7.0.1
 */