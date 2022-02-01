package com.tencent.mtt.hippy.dom;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

public final class e
{
  static final Object a = new e.2();
  private static volatile long b = 10L;
  private static final ThreadLocal<e> c = new e.1();
  private final Object d = new Object();
  private final Looper e;
  private final e.d f;
  private final e.c g;
  private e.b h;
  private final e.a[] i;
  private boolean j;
  private boolean k;
  private long l;
  private long m;
  
  private e(Looper paramLooper)
  {
    this.e = paramLooper;
    this.f = new e.d(this, paramLooper);
    this.g = null;
    this.l = -9223372036854775808L;
    this.m = ((1.0E+009F / c()));
    this.i = new e.a[3];
    int n = 0;
    while (n <= 2)
    {
      this.i[n] = new e.a(this, null);
      n += 1;
    }
  }
  
  public static e a()
  {
    return (e)c.get();
  }
  
  private void a(int paramInt, Object paramObject1, Object paramObject2)
  {
    synchronized (this.d)
    {
      this.i[paramInt].a(paramObject1, paramObject2);
      if ((paramObject1 != null) && (paramObject2 == null)) {
        this.f.removeMessages(2, paramObject1);
      }
      return;
    }
  }
  
  private void a(int paramInt, Object paramObject1, Object paramObject2, long paramLong)
  {
    synchronized (this.d)
    {
      long l1 = SystemClock.uptimeMillis();
      paramLong = l1 + paramLong;
      this.i[paramInt].a(paramLong, paramObject1, paramObject2);
      if (paramLong <= l1)
      {
        a(l1);
        return;
      }
      paramObject1 = this.f.obtainMessage(2, paramObject1);
      paramObject1.arg1 = paramInt;
      this.f.sendMessageAtTime(paramObject1, paramLong);
    }
  }
  
  private void a(long paramLong)
  {
    if (!this.j)
    {
      this.j = true;
      paramLong = Math.max(this.l / 1000000L + b, paramLong);
      Message localMessage = this.f.obtainMessage(0);
      this.f.sendMessageAtTime(localMessage, paramLong);
    }
  }
  
  private static float c()
  {
    return 60.0F;
  }
  
  private void d()
  {
    this.g.a();
  }
  
  e.b a(long paramLong, Object paramObject1, Object paramObject2)
  {
    e.b localb = this.h;
    if (localb == null) {
      localb = new e.b();
    }
    for (;;)
    {
      localb.b = paramLong;
      localb.c = paramObject1;
      localb.d = paramObject2;
      return localb;
      this.h = localb.a;
      localb.a = null;
    }
  }
  
  void a(int paramInt)
  {
    synchronized (this.d)
    {
      if (!this.j)
      {
        long l1 = SystemClock.uptimeMillis();
        if (this.i[paramInt].a(l1)) {
          a(l1);
        }
      }
      return;
    }
  }
  
  void a(int paramInt, long paramLong)
  {
    for (;;)
    {
      synchronized (this.d)
      {
        long l1 = SystemClock.uptimeMillis();
        e.b localb1 = this.i[paramInt].b(l1);
        if (localb1 == null) {
          return;
        }
        this.k = true;
        ??? = localb1;
        if (??? == null) {}
      }
      try
      {
        ((e.b)???).a(paramLong);
        ??? = ((e.b)???).a;
      }
      finally
      {
        for (;;)
        {
          synchronized (this.d)
          {
            this.k = false;
            ??? = localb3.a;
            a(localb3);
            if (??? == null) {
              throw localObject5;
            }
          }
          localObject2 = ???;
        }
        Object localObject2 = ???;
      }
    }
    localb2 = finally;
    throw localb2;
    synchronized (this.d)
    {
      this.k = false;
      ??? = localb2.a;
      a(localb2);
      if (??? == null) {
        return;
      }
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    synchronized (this.d)
    {
      if (!this.j) {
        return;
      }
      long l1 = System.nanoTime();
      long l2 = l1 - paramLong;
      if (l2 >= this.m)
      {
        paramLong = l2 / this.m;
        if (paramLong >= 30L) {
          Log.i("Choreographer", "Skipped " + paramLong + " frames!  The application may be doing too much work on its main thread.");
        }
        paramLong = l1 - l2 % this.m;
      }
      if (paramLong < this.l)
      {
        d();
        return;
      }
    }
    this.j = false;
    this.l = paramLong;
    a(0, paramLong);
    a(1, paramLong);
    a(2, paramLong);
  }
  
  public void a(d.a parama)
  {
    a(parama, 0L);
  }
  
  public void a(d.a parama, long paramLong)
  {
    if (parama == null) {
      throw new IllegalArgumentException("callback must not be null");
    }
    a(1, parama, a, paramLong);
  }
  
  void a(e.b paramb)
  {
    paramb.c = null;
    paramb.d = null;
    paramb.a = this.h;
    this.h = paramb;
  }
  
  void b()
  {
    synchronized (this.d)
    {
      if (this.j) {
        d();
      }
      return;
    }
  }
  
  public void b(d.a parama)
  {
    if (parama == null) {
      throw new IllegalArgumentException("callback must not be null");
    }
    a(1, parama, a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.e
 * JD-Core Version:    0.7.0.1
 */