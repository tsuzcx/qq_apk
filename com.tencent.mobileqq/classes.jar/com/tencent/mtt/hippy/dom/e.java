package com.tencent.mtt.hippy.dom;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

public final class e
{
  static final Object a = new e.2();
  private static final ThreadLocal<e> b = new e.1();
  private final Object c = new Object();
  private final Looper d;
  private final e.d e;
  private final e.c f;
  private e.b g;
  private final e.a[] h;
  private boolean i;
  private long j;
  private final long k;
  
  private e(Looper paramLooper)
  {
    this.d = paramLooper;
    this.e = new e.d(this, paramLooper);
    this.f = null;
    this.j = -9223372036854775808L;
    this.k = ((1.0E+009F / c()));
    this.h = new e.a[3];
    int m = 0;
    while (m <= 2)
    {
      this.h[m] = new e.a(this, null);
      m += 1;
    }
  }
  
  public static e a()
  {
    return (e)b.get();
  }
  
  private void a(int paramInt, Object paramObject1, Object paramObject2)
  {
    synchronized (this.c)
    {
      this.h[paramInt].a(paramObject1, paramObject2);
      if ((paramObject1 != null) && (paramObject2 == null)) {
        this.e.removeMessages(2, paramObject1);
      }
      return;
    }
  }
  
  private void a(int paramInt, Object paramObject1, Object paramObject2, long paramLong)
  {
    synchronized (this.c)
    {
      long l = SystemClock.uptimeMillis();
      paramLong += l;
      this.h[paramInt].a(paramLong, paramObject1, paramObject2);
      if (paramLong <= l)
      {
        a(l);
      }
      else
      {
        paramObject1 = this.e.obtainMessage(2, paramObject1);
        paramObject1.arg1 = paramInt;
        this.e.sendMessageAtTime(paramObject1, paramLong);
      }
      return;
    }
  }
  
  private void a(long paramLong)
  {
    if (!this.i)
    {
      this.i = true;
      paramLong = Math.max(this.j / 1000000L + 10L, paramLong);
      Message localMessage = this.e.obtainMessage(0);
      this.e.sendMessageAtTime(localMessage, paramLong);
    }
  }
  
  private static float c()
  {
    return 60.0F;
  }
  
  private void d()
  {
    this.f.a();
  }
  
  e.b a(long paramLong, Object paramObject1, Object paramObject2)
  {
    e.b localb = this.g;
    if (localb == null)
    {
      localb = new e.b();
    }
    else
    {
      this.g = localb.a;
      localb.a = null;
    }
    localb.b = paramLong;
    localb.c = paramObject1;
    localb.d = paramObject2;
    return localb;
  }
  
  void a(int paramInt)
  {
    synchronized (this.c)
    {
      if (!this.i)
      {
        long l = SystemClock.uptimeMillis();
        if (this.h[paramInt].a(l)) {
          a(l);
        }
      }
      return;
    }
  }
  
  /* Error */
  void a(int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/mtt/hippy/dom/e:c	Ljava/lang/Object;
    //   4: astore 7
    //   6: aload 7
    //   8: monitorenter
    //   9: invokestatic 97	android/os/SystemClock:uptimeMillis	()J
    //   12: lstore 4
    //   14: aload_0
    //   15: getfield 69	com/tencent/mtt/hippy/dom/e:h	[Lcom/tencent/mtt/hippy/dom/e$a;
    //   18: iload_1
    //   19: aaload
    //   20: lload 4
    //   22: invokevirtual 158	com/tencent/mtt/hippy/dom/e$a:b	(J)Lcom/tencent/mtt/hippy/dom/e$b;
    //   25: astore 6
    //   27: aload 6
    //   29: ifnonnull +7 -> 36
    //   32: aload 7
    //   34: monitorexit
    //   35: return
    //   36: aload 7
    //   38: monitorexit
    //   39: aload 6
    //   41: astore 7
    //   43: aload 7
    //   45: ifnull +69 -> 114
    //   48: aload 7
    //   50: lload_2
    //   51: invokevirtual 159	com/tencent/mtt/hippy/dom/e$b:a	(J)V
    //   54: aload 7
    //   56: getfield 145	com/tencent/mtt/hippy/dom/e$b:a	Lcom/tencent/mtt/hippy/dom/e$b;
    //   59: astore 7
    //   61: goto -18 -> 43
    //   64: astore 9
    //   66: aload_0
    //   67: getfield 44	com/tencent/mtt/hippy/dom/e:c	Ljava/lang/Object;
    //   70: astore 8
    //   72: aload 8
    //   74: monitorenter
    //   75: aload 6
    //   77: getfield 145	com/tencent/mtt/hippy/dom/e$b:a	Lcom/tencent/mtt/hippy/dom/e$b;
    //   80: astore 7
    //   82: aload_0
    //   83: aload 6
    //   85: invokevirtual 162	com/tencent/mtt/hippy/dom/e:a	(Lcom/tencent/mtt/hippy/dom/e$b;)V
    //   88: aload 7
    //   90: ifnull +10 -> 100
    //   93: aload 7
    //   95: astore 6
    //   97: goto -22 -> 75
    //   100: aload 8
    //   102: monitorexit
    //   103: aload 9
    //   105: athrow
    //   106: astore 6
    //   108: aload 8
    //   110: monitorexit
    //   111: aload 6
    //   113: athrow
    //   114: aload_0
    //   115: getfield 44	com/tencent/mtt/hippy/dom/e:c	Ljava/lang/Object;
    //   118: astore 8
    //   120: aload 8
    //   122: monitorenter
    //   123: aload 6
    //   125: getfield 145	com/tencent/mtt/hippy/dom/e$b:a	Lcom/tencent/mtt/hippy/dom/e$b;
    //   128: astore 7
    //   130: aload_0
    //   131: aload 6
    //   133: invokevirtual 162	com/tencent/mtt/hippy/dom/e:a	(Lcom/tencent/mtt/hippy/dom/e$b;)V
    //   136: aload 7
    //   138: ifnonnull +29 -> 167
    //   141: aload 8
    //   143: monitorexit
    //   144: return
    //   145: astore 6
    //   147: aload 8
    //   149: monitorexit
    //   150: aload 6
    //   152: athrow
    //   153: astore 6
    //   155: aload 7
    //   157: monitorexit
    //   158: goto +6 -> 164
    //   161: aload 6
    //   163: athrow
    //   164: goto -3 -> 161
    //   167: aload 7
    //   169: astore 6
    //   171: goto -48 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	e
    //   0	174	1	paramInt	int
    //   0	174	2	paramLong	long
    //   12	9	4	l	long
    //   25	71	6	localObject1	Object
    //   106	26	6	localb	e.b
    //   145	6	6	localObject2	Object
    //   153	9	6	localObject3	Object
    //   169	1	6	localObject4	Object
    //   4	164	7	localObject5	Object
    //   64	40	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   48	61	64	finally
    //   75	88	106	finally
    //   100	103	106	finally
    //   108	111	106	finally
    //   123	136	145	finally
    //   141	144	145	finally
    //   147	150	145	finally
    //   9	27	153	finally
    //   32	35	153	finally
    //   36	39	153	finally
    //   155	158	153	finally
  }
  
  void a(long paramLong, int paramInt)
  {
    synchronized (this.c)
    {
      if (!this.i) {
        return;
      }
      long l1 = System.nanoTime();
      long l2 = l1 - paramLong;
      if (l2 >= this.k)
      {
        paramLong = l2 / this.k;
        if (paramLong >= 30L)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Skipped ");
          localStringBuilder.append(paramLong);
          localStringBuilder.append(" frames!  The application may be doing too much work on its main thread.");
          Log.i("Choreographer", localStringBuilder.toString());
        }
        paramLong = l1 - l2 % this.k;
      }
      if (paramLong < this.j)
      {
        d();
        return;
      }
      this.i = false;
      this.j = paramLong;
      a(0, paramLong);
      a(1, paramLong);
      a(2, paramLong);
      return;
    }
  }
  
  public void a(d.a parama)
  {
    a(parama, 0L);
  }
  
  public void a(d.a parama, long paramLong)
  {
    if (parama != null)
    {
      a(1, parama, a, paramLong);
      return;
    }
    throw new IllegalArgumentException("callback must not be null");
  }
  
  void a(e.b paramb)
  {
    paramb.c = null;
    paramb.d = null;
    paramb.a = this.g;
    this.g = paramb;
  }
  
  void b()
  {
    synchronized (this.c)
    {
      if (this.i) {
        d();
      }
      return;
    }
  }
  
  public void b(d.a parama)
  {
    if (parama != null)
    {
      a(1, parama, a);
      return;
    }
    throw new IllegalArgumentException("callback must not be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.e
 * JD-Core Version:    0.7.0.1
 */