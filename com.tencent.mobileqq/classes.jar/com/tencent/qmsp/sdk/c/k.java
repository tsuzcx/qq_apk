package com.tencent.qmsp.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.util.Pair;
import com.tencent.qmsp.sdk.a.c;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.f.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class k
{
  private static final byte[][] i = { { 44, 116 }, { 49, 105, -93, 69 }, { 35, 124, -78, 71 }, { 40, 127, -73, 69 }, { 51, 117, -95 }, { 20, 65, -125, 82, 33, 47, 114, -2, 49, 62, -126, 125, -96, 80 }, { 20, 125, -96, 80, 29, 11 } };
  private static k j;
  private ConcurrentHashMap<Integer, k.f> a = new ConcurrentHashMap();
  private CopyOnWriteArrayList<k.f> b = new CopyOnWriteArrayList();
  private j c = new j();
  private g d;
  private Handler e = new k.g(this, com.tencent.qmsp.sdk.app.b.e().c());
  private boolean f = false;
  private boolean g = false;
  private CopyOnWriteArrayList<k.e> h = new CopyOnWriteArrayList();
  
  private k.f a(j.a parama)
  {
    k.f localf = new k.f(null);
    localf.a = parama.a;
    localf.b = parama.b;
    localf.c = parama.c;
    localf.h = parama.e;
    localf.g = parama.d;
    localf.e = 4;
    return localf;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      k.e locale = (k.e)localIterator.next();
      com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Notify listener [%d:%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      locale.a(paramInt1, paramInt2);
    }
  }
  
  private void a(k.f paramf)
  {
    this.b.add(paramf);
  }
  
  private void a(k.f paramf, String paramString1, String paramString2)
  {
    e(paramf);
    if (paramf.e == 4)
    {
      String str = paramf.h;
      if ((str != null) && (!str.equals(paramString2)))
      {
        d.a(paramf.h, false);
        paramf.h = paramString2;
      }
      paramString2 = paramf.g;
      if ((paramString2 != null) && (!paramString2.equals(paramString1))) {
        paramf.g = paramString1;
      }
      paramf.f = 0;
      d(paramf);
      a(paramf);
    }
  }
  
  private void a(List<j.a> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (j.a)paramList.next();
      this.c.a(((j.a)localObject).a, false);
      localObject = ((j.a)localObject).e;
      if (localObject != null) {
        d.a((String)localObject, false);
      }
    }
    this.c.a();
  }
  
  private static String b(int paramInt)
  {
    return com.tencent.qmsp.sdk.f.k.a(i[paramInt]);
  }
  
  private void b(k.f paramf)
  {
    try
    {
      com.tencent.qmsp.sdk.a.g localg = new com.tencent.qmsp.sdk.a.g();
      localg.a(paramf.a).a(paramf.g).a(paramf.d);
      com.tencent.qmsp.sdk.a.f.a(localg.toString(), 3);
      return;
    }
    catch (Exception paramf)
    {
      paramf.printStackTrace();
    }
  }
  
  private void b(List<Pair<Integer, Integer>> paramList)
  {
    if (paramList != null)
    {
      if (!this.f) {
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (Pair)paramList.next();
        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("cb changed: id(%d), cb(%d)", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second }));
        Object localObject2 = (k.f)this.a.get(((Pair)localObject1).first);
        if (localObject2 == null)
        {
          localObject2 = this.c.a(((Integer)((Pair)localObject1).first).intValue());
          if (localObject2 != null) {
            if (((Integer)((Pair)localObject1).second).intValue() == 1) {
              c(a((j.a)localObject2));
            } else if (((Integer)((Pair)localObject1).second).intValue() == 2) {
              localLinkedList.add(localObject2);
            }
          }
        }
        else if (((Integer)((Pair)localObject1).second).intValue() == 1)
        {
          if (((k.f)localObject2).e == 4)
          {
            d((k.f)localObject2);
            if (((k.f)localObject2).d != 0) {
              this.a.remove(Integer.valueOf(((k.f)localObject2).a));
            }
            a((k.f)localObject2);
          }
        }
        else if ((((Integer)((Pair)localObject1).second).intValue() == 2) && (((k.f)localObject2).e == 4))
        {
          this.a.remove(((Pair)localObject1).first);
          localObject1 = this.c.a(((Integer)((Pair)localObject1).first).intValue());
          if (localObject1 != null) {
            localLinkedList.add(localObject1);
          }
        }
      }
      if (!localLinkedList.isEmpty()) {
        a(localLinkedList);
      }
    }
  }
  
  private void c(k.e parame)
  {
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((k.f)localEntry.getValue()).e == 1)
      {
        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Notify listener [%d:%d]", new Object[] { Integer.valueOf(1), localEntry.getKey() }));
        parame.a(1, ((Integer)localEntry.getKey()).intValue());
      }
    }
  }
  
  private void c(k.f paramf)
  {
    d(paramf);
    if (paramf.d == 0)
    {
      this.a.put(Integer.valueOf(paramf.a), paramf);
      a(1, paramf.a);
    }
    a(paramf);
  }
  
  private void d()
  {
    com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, "addLostUpgradeLibs");
    new k.h(new k.i(this, null)).a(1);
  }
  
  private void d(k.f paramf)
  {
    paramf.e = 2;
    Object localObject = new k.b(this);
    ((k.b)localObject).a = paramf;
    int m = paramf.a;
    String str = paramf.g;
    int k = 1;
    new a(String.format("Lib%d_%s", new Object[] { Integer.valueOf(m), str }), 43200000L).a((a.a)localObject);
    str = paramf.h;
    localObject = str;
    if (str == null) {
      localObject = "null";
    }
    com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("load: %s ver: %s error: %08X", new Object[] { localObject, c.a(paramf.f), Integer.valueOf(paramf.d) }));
    if (paramf.d != 0) {
      k = 4;
    }
    paramf.e = k;
  }
  
  public static k e()
  {
    if (j == null) {
      try
      {
        if (j == null) {
          j = new k();
        }
      }
      finally {}
    }
    return j;
  }
  
  private void e(k.f paramf)
  {
    com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Prepare to unload: %d,%d,%d,%d,%s,%s", new Object[] { Integer.valueOf(paramf.a), Integer.valueOf(paramf.b), Integer.valueOf(paramf.c), Integer.valueOf(paramf.e), paramf.g, paramf.h }));
    if ((paramf.c & 0x1) == 0) {
      return;
    }
    if (paramf.e == 1)
    {
      paramf.e = 3;
      paramf.i.c();
      int k = f.a(3L, paramf.a, 0L, 0L, null, null, null, null);
      com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Unload ret: %d", new Object[] { Integer.valueOf(k) }));
      if (k == 0)
      {
        paramf.e = 4;
        a(2, paramf.a);
        return;
      }
      paramf.e = 5;
      paramf.d = k;
      return;
    }
  }
  
  private void f()
  {
    Object localObject = this.c.b();
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        j.a locala = (j.a)localIterator.next();
        int k = this.d.a(locala.a);
        int m = locala.a;
        int n = locala.b;
        int i1 = locala.c;
        String str2 = locala.d;
        String str1 = locala.e;
        localObject = str1;
        if (str1 == null) {
          localObject = "null";
        }
        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("%d,%d,%d,%s,%s,%d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), str2, localObject, Integer.valueOf(k) }));
        if ((k != 0) && (-1 != k))
        {
          if (2 == k)
          {
            localLinkedList.add(locala);
          }
          else if (1 == k)
          {
            localObject = a(locala);
            c((k.f)localObject);
            a((k.f)localObject);
          }
          if (!localLinkedList.isEmpty()) {
            a(localLinkedList);
          }
        }
      }
    }
  }
  
  private void g()
  {
    if (!this.f)
    {
      this.g = true;
      return;
    }
    this.g = false;
    new k.h(new k.c(this)).a(1);
  }
  
  private void h()
  {
    com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, "onLoadLocalLibs");
    if (this.f) {
      return;
    }
    this.f = true;
    d();
    f();
    if (this.g) {
      b();
    }
    j();
  }
  
  private void i()
  {
    Object localObject1 = QmspSDK.getContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(b.a);
    ((StringBuilder)localObject2).append(b(6));
    SharedPreferences localSharedPreferences = ((Context)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
    localObject2 = localSharedPreferences.edit();
    long l1;
    try
    {
      Iterator localIterator = this.b.iterator();
      l1 = 28800000L;
      for (;;)
      {
        l2 = l1;
        try
        {
          if (!localIterator.hasNext()) {
            break label411;
          }
          k.f localf = (k.f)localIterator.next();
          localObject1 = localf.g;
          if (localf.f != 0) {
            localObject1 = c.a(localf.f);
          }
          String str1 = String.format("Lib%d_%s_%s", new Object[] { Integer.valueOf(localf.a), QmspSDK.getUid(), localObject1 });
          String str2 = String.format("Lib%d_%s_%s_lpt", new Object[] { Integer.valueOf(localf.a), QmspSDK.getUid(), localObject1 });
          int k = localSharedPreferences.getInt(str1, -1);
          l2 = localSharedPreferences.getLong(str2, 0L);
          l2 = System.currentTimeMillis() - l2;
          if (l2 < 28800000L)
          {
            int m = localf.d;
            if (m == k)
            {
              com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Ignore rp for: %d,%08X,%s", new Object[] { Integer.valueOf(localf.a), Integer.valueOf(localf.d), localObject1 }));
              l2 = 28800000L - l2;
              if (l1 <= l2) {
                continue;
              }
              l1 = l2;
              continue;
            }
          }
          com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Rp: %d,%d,%s", new Object[] { Integer.valueOf(localf.a), Integer.valueOf(localf.d), localObject1 }));
          ((SharedPreferences.Editor)localObject2).putInt(str1, localf.d);
          ((SharedPreferences.Editor)localObject2).putLong(str2, System.currentTimeMillis());
          b(localf);
          this.b.remove(localf);
        }
        catch (Exception localException1) {}
      }
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      l1 = 28800000L;
    }
    long l2 = l1;
    label411:
    ((SharedPreferences.Editor)localObject2).commit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("next rp interval: ");
    localStringBuilder.append(l2);
    com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, localStringBuilder.toString());
    f.i().c().postDelayed(new k.d(this), l2);
  }
  
  private void j()
  {
    Handler localHandler = this.e;
    localHandler.sendMessage(localHandler.obtainMessage(4));
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    k.f localf = (k.f)this.a.get(Integer.valueOf(paramInt1));
    if (localf == null)
    {
      if (this.c.a(paramInt1) == null) {
        paramInt2 = 4;
      } else {
        paramInt2 = 17;
      }
    }
    else if ((paramInt2 != 0) && (paramInt2 != localf.f))
    {
      paramInt2 = 32;
    }
    else if (localf.a != paramInt1)
    {
      paramInt2 = 5;
    }
    else
    {
      int k = this.d.a(paramInt1);
      if ((1 != k) && (k != -1))
      {
        paramInt2 = 6;
      }
      else if ((localf.e != 1) || (!localf.i.a()))
      {
        paramInt2 = 7;
      }
      else
      {
        paramInt2 = f.a(4L, localf.a, paramInt2, paramInt3, null, null, paramArrayOfObject1, paramArrayOfObject2);
        localf.i.b();
      }
    }
    com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("dispatch to id: %d, cmd: %d, err: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) }));
    return paramInt2;
  }
  
  public void a()
  {
    try
    {
      if (this.a != null)
      {
        Iterator localIterator = this.a.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          ((k.f)localEntry.getValue()).c = 1;
          e((k.f)localEntry.getValue());
        }
      }
      if (j != null)
      {
        j = null;
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(g paramg)
  {
    this.d = paramg;
    this.d.a(new k.a(this));
  }
  
  public void a(k.e parame)
  {
    this.h.add(parame);
    Handler localHandler = this.e;
    localHandler.sendMessage(localHandler.obtainMessage(5, parame));
  }
  
  public void b()
  {
    Handler localHandler = this.e;
    localHandler.sendMessage(localHandler.obtainMessage(1));
  }
  
  public void b(k.e parame)
  {
    this.h.remove(parame);
  }
  
  public void c()
  {
    com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("OnEveryLogin mHasLoadLocal = %b", new Object[] { Boolean.valueOf(this.f) }));
    if (!this.f)
    {
      Handler localHandler = this.e;
      localHandler.sendMessage(localHandler.obtainMessage(3));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.k
 * JD-Core Version:    0.7.0.1
 */