package com.tencent.tvkbeacon.core.event;

import android.content.Context;
import com.tencent.tvkbeacon.core.a.b;
import com.tencent.tvkbeacon.core.b.i;
import com.tencent.tvkbeacon.core.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
  implements h
{
  private static AtomicInteger h = new AtomicInteger(1000);
  private Context a;
  private boolean b = false;
  private final Object c = new Object();
  private final Object d = new Object();
  private List<RDBean> e;
  private long f = 60000L;
  private d g;
  private int i;
  private Runnable j = new a.1(this);
  private Runnable k = new a.2(this);
  
  public a(Context paramContext, d paramd)
  {
    this.a = paramContext;
    this.e = new ArrayList(25);
    this.g = paramd;
    this.i = h.addAndGet(1);
  }
  
  private String a(String paramString)
  {
    return paramString + " Tunnel key: " + this.g.f();
  }
  
  /* Error */
  private List<RDBean> c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	com/tencent/tvkbeacon/core/event/a:e	Ljava/util/List;
    //   6: invokeinterface 107 1 0
    //   11: ifle +12 -> 23
    //   14: aload_0
    //   15: getfield 43	com/tencent/tvkbeacon/core/event/a:b	Z
    //   18: istore_1
    //   19: iload_1
    //   20: ifne +9 -> 29
    //   23: aconst_null
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: areturn
    //   29: new 67	java/util/ArrayList
    //   32: dup
    //   33: invokespecial 108	java/util/ArrayList:<init>	()V
    //   36: astore_2
    //   37: aload_2
    //   38: aload_0
    //   39: getfield 70	com/tencent/tvkbeacon/core/event/a:e	Ljava/util/List;
    //   42: invokeinterface 112 2 0
    //   47: pop
    //   48: aload_0
    //   49: getfield 70	com/tencent/tvkbeacon/core/event/a:e	Ljava/util/List;
    //   52: invokeinterface 115 1 0
    //   57: aload_0
    //   58: new 85	java/lang/StringBuilder
    //   61: dup
    //   62: ldc 117
    //   64: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: aload_2
    //   68: invokeinterface 107 1 0
    //   73: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokespecial 83	com/tencent/tvkbeacon/core/event/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   82: iconst_0
    //   83: anewarray 4	java/lang/Object
    //   86: invokestatic 128	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: goto -64 -> 25
    //   92: astore_2
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_2
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	a
    //   18	2	1	bool	boolean
    //   24	44	2	localObject1	Object
    //   92	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	92	finally
    //   29	89	92	finally
  }
  
  private Runnable d(boolean paramBoolean)
  {
    return new a.3(this, paramBoolean);
  }
  
  private void e(boolean paramBoolean)
  {
    c.f(a("[event] -> do max size upload task."), new Object[0]);
    try
    {
      this.g.b(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      c.a(localThrowable);
    }
  }
  
  /* Error */
  protected final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc 151
    //   5: invokespecial 83	com/tencent/tvkbeacon/core/event/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   8: iconst_0
    //   9: anewarray 4	java/lang/Object
    //   12: invokestatic 128	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   15: aload_0
    //   16: getfield 43	com/tencent/tvkbeacon/core/event/a:b	Z
    //   19: ifne +19 -> 38
    //   22: aload_0
    //   23: ldc 153
    //   25: invokespecial 83	com/tencent/tvkbeacon/core/event/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   28: iconst_0
    //   29: anewarray 4	java/lang/Object
    //   32: invokestatic 155	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: invokespecial 157	com/tencent/tvkbeacon/core/event/a:c	()Ljava/util/List;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull -9 -> 35
    //   47: aload_1
    //   48: invokeinterface 107 1 0
    //   53: ifle -18 -> 35
    //   56: aload_0
    //   57: getfield 65	com/tencent/tvkbeacon/core/event/a:a	Landroid/content/Context;
    //   60: aload_0
    //   61: getfield 72	com/tencent/tvkbeacon/core/event/a:g	Lcom/tencent/tvkbeacon/core/event/d;
    //   64: invokevirtual 97	com/tencent/tvkbeacon/core/event/d:f	()Ljava/lang/String;
    //   67: aload_1
    //   68: invokestatic 162	com/tencent/tvkbeacon/core/event/l:a	(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)[Ljava/lang/Long;
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull -38 -> 35
    //   76: aload_0
    //   77: getfield 65	com/tencent/tvkbeacon/core/event/a:a	Landroid/content/Context;
    //   80: invokestatic 167	com/tencent/tvkbeacon/core/b/h:a	(Landroid/content/Context;)Lcom/tencent/tvkbeacon/core/b/h;
    //   83: invokevirtual 170	com/tencent/tvkbeacon/core/b/h:c	()Ljava/util/ArrayList;
    //   86: invokevirtual 174	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   89: astore_2
    //   90: aload_2
    //   91: invokeinterface 180 1 0
    //   96: ifeq -61 -> 35
    //   99: aload_2
    //   100: invokeinterface 184 1 0
    //   105: checkcast 186	com/tencent/tvkbeacon/core/b/i
    //   108: aload_1
    //   109: arraylength
    //   110: invokeinterface 189 2 0
    //   115: goto -25 -> 90
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	a
    //   42	67	1	localObject1	Object
    //   118	4	1	localObject2	Object
    //   89	11	2	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	35	118	finally
    //   38	43	118	finally
    //   47	72	118	finally
    //   76	90	118	finally
    //   90	115	118	finally
  }
  
  protected final void a(boolean paramBoolean)
  {
    int m = 0;
    synchronized (this.d)
    {
      if (!this.b)
      {
        c.d(a("[event] err disable."), new Object[0]);
        return;
      }
      Object localObject2 = c();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label329;
      }
      localObject2 = l.a(this.a, this.g.f(), (List)localObject2);
      if (localObject2 != null)
      {
        localObject4 = com.tencent.tvkbeacon.core.b.h.a(this.a).c().iterator();
        if (((Iterator)localObject4).hasNext()) {
          ((i)((Iterator)localObject4).next()).incCommonEventWriteSucc(localObject2.length);
        }
      }
    }
    Object localObject4 = com.tencent.tvkbeacon.core.b.h.a(this.a);
    if (localObject3 != null)
    {
      long l2 = EventStrategyBean.getInstance().getComNumUpload();
      long l1 = l2;
      if (com.tencent.tvkbeacon.core.c.d.a(this.a))
      {
        c.e(a("[event] on wifi, so half mSZ ".concat(String.valueOf(l2))), new Object[0]);
        l1 = l2 / 2L;
      }
      int n = l.a(this.a, this.g.f());
      c.b(a("[event] recordNum: " + n + ", maxNum: " + l1), new Object[0]);
      if (n >= l1) {
        m = 1;
      }
      if ((m != 0) && (((com.tencent.tvkbeacon.core.b.h)localObject4).a()) && (((com.tencent.tvkbeacon.core.b.h)localObject4).b()))
      {
        if (!EventStrategyBean.getInstance().isZeroPeakUploadByRate())
        {
          c.e(a("[event] max but not up(zeroPeak)!"), new Object[0]);
          return;
        }
        e(paramBoolean);
        c.e(a("[event] max then up"), new Object[0]);
      }
    }
    label329:
    label376:
    for (;;)
    {
      return;
      EventStrategyBean localEventStrategyBean = EventStrategyBean.getInstance();
      if (localEventStrategyBean != null) {}
      for (boolean bool = localEventStrategyBean.isComPollUp();; bool = false)
      {
        if (!bool) {
          break label376;
        }
        e(paramBoolean);
        c.e(a("[event] polling then up"), new Object[0]);
        break;
      }
    }
  }
  
  public final boolean a(RDBean paramRDBean)
  {
    synchronized (this.c)
    {
      String str = a("[event] eN:%s");
      if (paramRDBean == null) {}
      for (localObject1 = "null";; localObject1 = paramRDBean.getEN())
      {
        c.f(str, new Object[] { localObject1 });
        if ((this.a != null) && (paramRDBean != null) && (this.b)) {
          break;
        }
        c.d(a("[event] err return."), new Object[0]);
        return false;
      }
      if (!this.b)
      {
        c.d(a("[event] return false, isEnable is false !"), new Object[0]);
        return false;
      }
    }
    Object localObject1 = EventStrategyBean.getInstance();
    int m = ((EventStrategyBean)localObject1).getComNumDB();
    this.f = (((EventStrategyBean)localObject1).getComDelayDB() * 1000);
    int n = this.e.size();
    if (n >= m)
    {
      c.f(a("[event] max num."), new Object[0]);
      b.d().a(d(false));
      b.d().a(this.i, d(true), this.f, this.f);
    }
    this.e.add(paramRDBean);
    c.f(a("[event] event buff num：" + this.e.size()), new Object[0]);
    if (this.e.size() >= m) {
      c.c(a("[event] err BF 3R! list size:".concat(String.valueOf(n))), new Object[0]);
    }
    paramRDBean = com.tencent.tvkbeacon.core.b.h.a(this.a).c().iterator();
    while (paramRDBean.hasNext()) {
      ((i)paramRDBean.next()).incCommonEventCalls();
    }
    c.a(a("[event] process UA:true!"), new Object[0]);
    return true;
  }
  
  public final void b()
  {
    try
    {
      this.f = (EventStrategyBean.getInstance().getComDelayDB() * 1000);
      b.d().a(this.i, d(true), this.f, this.f);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/tencent/tvkbeacon/core/event/a:b	Z
    //   6: iload_1
    //   7: if_icmpeq +50 -> 57
    //   10: iload_1
    //   11: ifeq +49 -> 60
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 43	com/tencent/tvkbeacon/core/event/a:b	Z
    //   19: aload_0
    //   20: invokestatic 195	com/tencent/tvkbeacon/core/event/EventStrategyBean:getInstance	()Lcom/tencent/tvkbeacon/core/event/EventStrategyBean;
    //   23: invokevirtual 266	com/tencent/tvkbeacon/core/event/EventStrategyBean:getComDelayDB	()I
    //   26: sipush 1000
    //   29: imul
    //   30: i2l
    //   31: putfield 51	com/tencent/tvkbeacon/core/event/a:f	J
    //   34: invokestatic 273	com/tencent/tvkbeacon/core/a/b:d	()Lcom/tencent/tvkbeacon/core/a/b;
    //   37: aload_0
    //   38: getfield 78	com/tencent/tvkbeacon/core/event/a:i	I
    //   41: aload_0
    //   42: iconst_1
    //   43: invokespecial 275	com/tencent/tvkbeacon/core/event/a:d	(Z)Ljava/lang/Runnable;
    //   46: aload_0
    //   47: getfield 51	com/tencent/tvkbeacon/core/event/a:f	J
    //   50: aload_0
    //   51: getfield 51	com/tencent/tvkbeacon/core/event/a:f	J
    //   54: invokevirtual 281	com/tencent/tvkbeacon/core/a/b:a	(ILjava/lang/Runnable;JJ)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: invokestatic 273	com/tencent/tvkbeacon/core/a/b:d	()Lcom/tencent/tvkbeacon/core/a/b;
    //   63: aload_0
    //   64: getfield 78	com/tencent/tvkbeacon/core/event/a:i	I
    //   67: iconst_1
    //   68: invokevirtual 304	com/tencent/tvkbeacon/core/a/b:a	(IZ)V
    //   71: invokestatic 273	com/tencent/tvkbeacon/core/a/b:d	()Lcom/tencent/tvkbeacon/core/a/b;
    //   74: bipush 102
    //   76: iconst_1
    //   77: invokevirtual 304	com/tencent/tvkbeacon/core/a/b:a	(IZ)V
    //   80: aload_0
    //   81: iconst_1
    //   82: invokevirtual 306	com/tencent/tvkbeacon/core/event/a:c	(Z)V
    //   85: aload_0
    //   86: iload_1
    //   87: putfield 43	com/tencent/tvkbeacon/core/event/a:b	Z
    //   90: goto -33 -> 57
    //   93: astore_2
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_2
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	a
    //   0	98	1	paramBoolean	boolean
    //   93	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	93	finally
    //   14	57	93	finally
    //   60	90	93	finally
  }
  
  /* Error */
  public final void c(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc_w 308
    //   6: invokespecial 83	com/tencent/tvkbeacon/core/event/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   9: iconst_0
    //   10: anewarray 4	java/lang/Object
    //   13: invokestatic 216	com/tencent/tvkbeacon/core/c/c:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: iload_1
    //   17: ifeq +10 -> 27
    //   20: aload_0
    //   21: invokevirtual 310	com/tencent/tvkbeacon/core/event/a:a	()V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: invokestatic 273	com/tencent/tvkbeacon/core/a/b:d	()Lcom/tencent/tvkbeacon/core/a/b;
    //   30: aload_0
    //   31: getfield 58	com/tencent/tvkbeacon/core/event/a:j	Ljava/lang/Runnable;
    //   34: invokevirtual 278	com/tencent/tvkbeacon/core/a/b:a	(Ljava/lang/Runnable;)V
    //   37: goto -13 -> 24
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	a
    //   0	45	1	paramBoolean	boolean
    //   40	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	40	finally
    //   20	24	40	finally
    //   27	37	40	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.event.a
 * JD-Core Version:    0.7.0.1
 */