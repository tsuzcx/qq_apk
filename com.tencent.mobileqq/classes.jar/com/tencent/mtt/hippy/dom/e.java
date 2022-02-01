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
      paramLong += l1;
      this.i[paramInt].a(paramLong, paramObject1, paramObject2);
      if (paramLong <= l1)
      {
        a(l1);
      }
      else
      {
        paramObject1 = this.f.obtainMessage(2, paramObject1);
        paramObject1.arg1 = paramInt;
        this.f.sendMessageAtTime(paramObject1, paramLong);
      }
      return;
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
    if (localb == null)
    {
      localb = new e.b();
    }
    else
    {
      this.h = localb.a;
      localb.a = null;
    }
    localb.b = paramLong;
    localb.c = paramObject1;
    localb.d = paramObject2;
    return localb;
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
  
  /* Error */
  void a(int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	com/tencent/mtt/hippy/dom/e:d	Ljava/lang/Object;
    //   4: astore 7
    //   6: aload 7
    //   8: monitorenter
    //   9: invokestatic 101	android/os/SystemClock:uptimeMillis	()J
    //   12: lstore 4
    //   14: aload_0
    //   15: getfield 73	com/tencent/mtt/hippy/dom/e:i	[Lcom/tencent/mtt/hippy/dom/e$a;
    //   18: iload_1
    //   19: aaload
    //   20: lload 4
    //   22: invokevirtual 161	com/tencent/mtt/hippy/dom/e$a:b	(J)Lcom/tencent/mtt/hippy/dom/e$b;
    //   25: astore 6
    //   27: aload 6
    //   29: ifnonnull +7 -> 36
    //   32: aload 7
    //   34: monitorexit
    //   35: return
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 163	com/tencent/mtt/hippy/dom/e:k	Z
    //   41: aload 7
    //   43: monitorexit
    //   44: aload 6
    //   46: astore 7
    //   48: aload 7
    //   50: ifnull +74 -> 124
    //   53: aload 7
    //   55: lload_2
    //   56: invokevirtual 164	com/tencent/mtt/hippy/dom/e$b:a	(J)V
    //   59: aload 7
    //   61: getfield 149	com/tencent/mtt/hippy/dom/e$b:a	Lcom/tencent/mtt/hippy/dom/e$b;
    //   64: astore 7
    //   66: goto -18 -> 48
    //   69: astore 9
    //   71: aload_0
    //   72: getfield 48	com/tencent/mtt/hippy/dom/e:d	Ljava/lang/Object;
    //   75: astore 8
    //   77: aload 8
    //   79: monitorenter
    //   80: aload_0
    //   81: iconst_0
    //   82: putfield 163	com/tencent/mtt/hippy/dom/e:k	Z
    //   85: aload 6
    //   87: getfield 149	com/tencent/mtt/hippy/dom/e$b:a	Lcom/tencent/mtt/hippy/dom/e$b;
    //   90: astore 7
    //   92: aload_0
    //   93: aload 6
    //   95: invokevirtual 167	com/tencent/mtt/hippy/dom/e:a	(Lcom/tencent/mtt/hippy/dom/e$b;)V
    //   98: aload 7
    //   100: ifnull +10 -> 110
    //   103: aload 7
    //   105: astore 6
    //   107: goto -22 -> 85
    //   110: aload 8
    //   112: monitorexit
    //   113: aload 9
    //   115: athrow
    //   116: astore 6
    //   118: aload 8
    //   120: monitorexit
    //   121: aload 6
    //   123: athrow
    //   124: aload_0
    //   125: getfield 48	com/tencent/mtt/hippy/dom/e:d	Ljava/lang/Object;
    //   128: astore 8
    //   130: aload 8
    //   132: monitorenter
    //   133: aload_0
    //   134: iconst_0
    //   135: putfield 163	com/tencent/mtt/hippy/dom/e:k	Z
    //   138: aload 6
    //   140: getfield 149	com/tencent/mtt/hippy/dom/e$b:a	Lcom/tencent/mtt/hippy/dom/e$b;
    //   143: astore 7
    //   145: aload_0
    //   146: aload 6
    //   148: invokevirtual 167	com/tencent/mtt/hippy/dom/e:a	(Lcom/tencent/mtt/hippy/dom/e$b;)V
    //   151: aload 7
    //   153: ifnonnull +29 -> 182
    //   156: aload 8
    //   158: monitorexit
    //   159: return
    //   160: astore 6
    //   162: aload 8
    //   164: monitorexit
    //   165: aload 6
    //   167: athrow
    //   168: astore 6
    //   170: aload 7
    //   172: monitorexit
    //   173: goto +6 -> 179
    //   176: aload 6
    //   178: athrow
    //   179: goto -3 -> 176
    //   182: aload 7
    //   184: astore 6
    //   186: goto -48 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	e
    //   0	189	1	paramInt	int
    //   0	189	2	paramLong	long
    //   12	9	4	l1	long
    //   25	81	6	localObject1	Object
    //   116	31	6	localb	e.b
    //   160	6	6	localObject2	Object
    //   168	9	6	localObject3	Object
    //   184	1	6	localObject4	Object
    //   4	179	7	localObject5	Object
    //   69	45	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   53	66	69	finally
    //   80	85	116	finally
    //   85	98	116	finally
    //   110	113	116	finally
    //   118	121	116	finally
    //   133	138	160	finally
    //   138	151	160	finally
    //   156	159	160	finally
    //   162	165	160	finally
    //   9	27	168	finally
    //   32	35	168	finally
    //   36	44	168	finally
    //   170	173	168	finally
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
        if (paramLong >= 30L)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Skipped ");
          localStringBuilder.append(paramLong);
          localStringBuilder.append(" frames!  The application may be doing too much work on its main thread.");
          Log.i("Choreographer", localStringBuilder.toString());
        }
        paramLong = l1 - l2 % this.m;
      }
      if (paramLong < this.l)
      {
        d();
        return;
      }
      this.j = false;
      this.l = paramLong;
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
    if (parama != null)
    {
      a(1, parama, a);
      return;
    }
    throw new IllegalArgumentException("callback must not be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.e
 * JD-Core Version:    0.7.0.1
 */