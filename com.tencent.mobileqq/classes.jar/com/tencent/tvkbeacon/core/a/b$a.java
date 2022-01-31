package com.tencent.tvkbeacon.core.a;

import android.util.SparseArray;
import com.tencent.tvkbeacon.core.c.c;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

final class b$a
  extends b
{
  private ScheduledExecutorService b = null;
  private SparseArray<b.c<?>> c = null;
  private int d = 4;
  private boolean e = false;
  
  public b$a()
  {
    this.b = Executors.newScheduledThreadPool(4, new b.b());
    this.c = new SparseArray();
  }
  
  public b$a(ScheduledExecutorService paramScheduledExecutorService)
  {
    if ((paramScheduledExecutorService == null) || (paramScheduledExecutorService.isShutdown())) {
      throw new IllegalArgumentException("ScheduledExecutorService is not valiable!");
    }
    this.b = paramScheduledExecutorService;
    this.c = new SparseArray();
  }
  
  private Runnable b(Runnable paramRunnable)
  {
    return new b.a.1(this, paramRunnable);
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 61
    //   4: iconst_0
    //   5: anewarray 63	java/lang/Object
    //   8: invokestatic 68	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   11: aload_0
    //   12: getfield 25	com/tencent/tvkbeacon/core/a/b$a:e	Z
    //   15: ifeq +15 -> 30
    //   18: ldc 70
    //   20: iconst_0
    //   21: anewarray 63	java/lang/Object
    //   24: invokestatic 72	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: ldc 74
    //   32: iconst_0
    //   33: anewarray 63	java/lang/Object
    //   36: invokestatic 68	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: aload_0
    //   40: iconst_1
    //   41: putfield 25	com/tencent/tvkbeacon/core/a/b$a:e	Z
    //   44: aload_0
    //   45: getfield 19	com/tencent/tvkbeacon/core/a/b$a:b	Ljava/util/concurrent/ScheduledExecutorService;
    //   48: invokeinterface 77 1 0
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 19	com/tencent/tvkbeacon/core/a/b$a:b	Ljava/util/concurrent/ScheduledExecutorService;
    //   58: aload_0
    //   59: getfield 21	com/tencent/tvkbeacon/core/a/b$a:c	Landroid/util/SparseArray;
    //   62: invokevirtual 80	android/util/SparseArray:clear	()V
    //   65: aload_0
    //   66: aconst_null
    //   67: putfield 21	com/tencent/tvkbeacon/core/a/b$a:c	Landroid/util/SparseArray;
    //   70: ldc 82
    //   72: iconst_0
    //   73: anewarray 63	java/lang/Object
    //   76: invokestatic 68	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: goto -52 -> 27
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	a
    //   82	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	82	finally
    //   30	79	82	finally
  }
  
  public final void a(int paramInt, Runnable paramRunnable, long paramLong1, long paramLong2)
  {
    try
    {
      if (this.e) {
        c.d("[task] was closed , should not post!", new Object[0]);
      }
      for (;;)
      {
        return;
        if (paramRunnable != null) {
          break;
        }
        c.d("[task] runner should not be null", new Object[0]);
      }
      paramRunnable = b(paramRunnable);
    }
    finally {}
    if (paramLong1 > 0L)
    {
      label54:
      if (!a) {
        break label161;
      }
      if (paramLong2 <= 10000L) {
        break label153;
      }
      break label164;
    }
    label153:
    label161:
    label164:
    for (;;)
    {
      a(paramInt, true);
      paramRunnable = new b.c((FutureTask)this.b.scheduleAtFixedRate(paramRunnable, paramLong1, paramLong2, TimeUnit.MILLISECONDS), paramRunnable, paramLong1, paramLong2, TimeUnit.MILLISECONDS);
      c.b("[task] add a new future! taskId: %d , periodTime: %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong2) });
      this.c.put(paramInt, paramRunnable);
      break;
      paramLong1 = 0L;
      break label54;
      paramLong2 = 10000L;
      break label164;
    }
  }
  
  /* Error */
  public final void a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/tvkbeacon/core/a/b$a:e	Z
    //   6: ifeq +15 -> 21
    //   9: ldc 70
    //   11: iconst_0
    //   12: anewarray 63	java/lang/Object
    //   15: invokestatic 72	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 21	com/tencent/tvkbeacon/core/a/b$a:c	Landroid/util/SparseArray;
    //   25: iload_1
    //   26: invokevirtual 134	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   29: checkcast 98	com/tencent/tvkbeacon/core/a/b$c
    //   32: astore_3
    //   33: aload_3
    //   34: ifnull +25 -> 59
    //   37: aload_3
    //   38: invokevirtual 136	com/tencent/tvkbeacon/core/a/b$c:a	()Z
    //   41: ifne +18 -> 59
    //   44: ldc 138
    //   46: iconst_0
    //   47: anewarray 63	java/lang/Object
    //   50: invokestatic 68	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aload_3
    //   54: iload_2
    //   55: invokevirtual 141	com/tencent/tvkbeacon/core/a/b$c:a	(Z)Z
    //   58: pop
    //   59: aload_0
    //   60: getfield 21	com/tencent/tvkbeacon/core/a/b$a:c	Landroid/util/SparseArray;
    //   63: iload_1
    //   64: invokevirtual 145	android/util/SparseArray:remove	(I)V
    //   67: goto -49 -> 18
    //   70: astore_3
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_3
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	a
    //   0	75	1	paramInt	int
    //   0	75	2	paramBoolean	boolean
    //   32	22	3	localc	b.c
    //   70	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	70	finally
    //   21	33	70	finally
    //   37	59	70	finally
    //   59	67	70	finally
  }
  
  public final void a(Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        if (this.e)
        {
          c.d("[task] was closed , should not post!", new Object[0]);
          return;
        }
        if (paramRunnable == null)
        {
          c.d("[task] runner should not be null", new Object[0]);
          continue;
        }
        paramRunnable = b(paramRunnable);
      }
      finally {}
      this.b.execute(paramRunnable);
    }
  }
  
  public final void a(Runnable paramRunnable, long paramLong)
  {
    for (;;)
    {
      try
      {
        if (this.e)
        {
          c.d("[task] was closed , should not post!", new Object[0]);
          return;
        }
        paramRunnable = b(paramRunnable);
        if (paramLong > 0L) {
          this.b.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
        } else {
          paramLong = 0L;
        }
      }
      finally {}
    }
  }
  
  public final void b()
  {
    for (;;)
    {
      try
      {
        c.b("[task] Start stop all schedule task", new Object[0]);
        if (this.e)
        {
          c.d("task was close, should all stopped!", new Object[0]);
          return;
        }
        int i = 0;
        if (i < this.c.size())
        {
          b.c localc = (b.c)this.c.get(this.c.keyAt(i));
          if ((localc != null) && (!localc.a())) {
            localc.a(false);
          }
        }
        else
        {
          c.b("[task] All schedule tasks stop", new Object[0]);
          continue;
        }
        i += 1;
      }
      finally {}
    }
  }
  
  public final void c()
  {
    for (;;)
    {
      try
      {
        c.b("[task] Resumed all schedule task", new Object[0]);
        if (this.e)
        {
          c.d("task was close, should all stopped!", new Object[0]);
          return;
        }
        int i = 0;
        if (i < this.c.size())
        {
          b.c localc = (b.c)this.c.get(this.c.keyAt(i));
          if (localc != null)
          {
            if (!b.c.a(localc).isCancelled()) {
              b.c.a(localc).cancel(true);
            }
            b.c.a(localc, (FutureTask)this.b.scheduleAtFixedRate(b.c.b(localc), b.c.c(localc), b.c.d(localc), b.c.e(localc)));
          }
        }
        else
        {
          c.b("[task] Resumed all schedule task", new Object[0]);
          continue;
        }
        i += 1;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.a.b.a
 * JD-Core Version:    0.7.0.1
 */