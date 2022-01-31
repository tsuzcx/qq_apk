package com.tencent.tvkbeacon.core.event;

import android.content.Context;
import com.tencent.tvkbeacon.core.b.h;
import com.tencent.tvkbeacon.core.b.i;
import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.core.protocol.common.RequestPackage;
import com.tencent.tvkbeacon.core.protocol.event.EventRecord;
import com.tencent.tvkbeacon.core.protocol.event.EventRecordPackage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
  extends com.tencent.tvkbeacon.core.b.a
{
  private List<RDBean> g = null;
  private Context h;
  private Long[] i = null;
  private boolean j = false;
  
  public j(Context paramContext, String paramString, List<RDBean> paramList)
  {
    super(paramContext, 1, 2, paramString);
    this.g = paramList;
    this.h = paramContext;
    this.e = this.g.size();
    if ((this.g.size() == 1) && ("rqd_heartbeat".equals(((RDBean)this.g.get(0)).getEN()))) {
      this.j = true;
    }
    this.d = com.tencent.tvkbeacon.core.c.a.a(paramContext, 2, paramString);
    c.b("[event] request id:%s", new Object[] { this.d });
  }
  
  private RequestPackage a(Context paramContext, int paramInt, List<RDBean> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return null;
      try
      {
        c.b("[event] encode rd size:" + paramList.size(), new Object[0]);
        paramList = a(paramList);
        if (paramList != null)
        {
          paramList = paramList.toByteArray();
          if (paramList != null)
          {
            paramContext = e.a(paramContext, paramInt, paramList, this.f);
            return paramContext;
          }
        }
      }
      catch (Throwable paramContext)
      {
        c.a(paramContext);
        c.d("[event] encode2EventRecordPackage error}", new Object[0]);
      }
    }
    return null;
  }
  
  private static EventRecordPackage a(List<RDBean> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    EventRecordPackage localEventRecordPackage;
    try
    {
      localEventRecordPackage = new EventRecordPackage();
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        EventRecord localEventRecord = k.a((RDBean)paramList.next());
        if (localEventRecord != null) {
          localArrayList.add(localEventRecord);
        }
      }
      localEventRecordPackage.list = localArrayList;
    }
    catch (Throwable paramList)
    {
      c.a(paramList);
      return null;
    }
    c.b("[event] encode end", new Object[0]);
    return localEventRecordPackage;
  }
  
  /* Error */
  public final RequestPackage a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 157
    //   4: iconst_0
    //   5: anewarray 68	java/lang/Object
    //   8: invokestatic 74	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   11: aload_0
    //   12: getfield 20	com/tencent/tvkbeacon/core/event/j:g	Ljava/util/List;
    //   15: ifnull +17 -> 32
    //   18: aload_0
    //   19: getfield 20	com/tencent/tvkbeacon/core/event/j:g	Ljava/util/List;
    //   22: invokeinterface 32 1 0
    //   27: istore_1
    //   28: iload_1
    //   29: ifgt +9 -> 38
    //   32: aconst_null
    //   33: astore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_2
    //   37: areturn
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 26	com/tencent/tvkbeacon/core/event/j:h	Landroid/content/Context;
    //   43: aload_0
    //   44: getfield 159	com/tencent/tvkbeacon/core/event/j:a	I
    //   47: aload_0
    //   48: getfield 20	com/tencent/tvkbeacon/core/event/j:g	Ljava/util/List;
    //   51: invokespecial 161	com/tencent/tvkbeacon/core/event/j:a	(Landroid/content/Context;ILjava/util/List;)Lcom/tencent/tvkbeacon/core/protocol/common/RequestPackage;
    //   54: astore_2
    //   55: aload_2
    //   56: ifnull +29 -> 85
    //   59: ldc 163
    //   61: iconst_0
    //   62: anewarray 68	java/lang/Object
    //   65: invokestatic 74	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   68: goto -34 -> 34
    //   71: astore_2
    //   72: aload_2
    //   73: invokestatic 114	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   76: ldc 165
    //   78: iconst_0
    //   79: anewarray 68	java/lang/Object
    //   82: invokestatic 118	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: aconst_null
    //   86: astore_2
    //   87: goto -53 -> 34
    //   90: astore_2
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_2
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	j
    //   27	2	1	k	int
    //   33	23	2	localRequestPackage	RequestPackage
    //   71	2	2	localThrowable	Throwable
    //   86	1	2	localObject1	Object
    //   90	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   38	55	71	java/lang/Throwable
    //   59	68	71	java/lang/Throwable
    //   2	28	90	finally
    //   38	55	90	finally
    //   59	68	90	finally
    //   72	85	90	finally
  }
  
  public final void b(boolean paramBoolean)
  {
    try
    {
      c.b("[event] isHandled:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      if ((this.g != null) && (!paramBoolean))
      {
        c.f("[event] upload failed, save to db", new Object[0]);
        if (!this.j)
        {
          this.i = l.a(this.h, this.f, this.g);
          if (this.i != null)
          {
            Iterator localIterator1 = h.a(this.h).c().iterator();
            while (localIterator1.hasNext()) {
              ((i)localIterator1.next()).incRealTimeEventWriteSucc(this.i.length);
            }
          }
          this.g = null;
        }
      }
    }
    finally {}
    if ((paramBoolean) && (this.j)) {
      g.a(this.h);
    }
    if ((paramBoolean) && (this.i != null)) {
      l.a(this.h, this.f, this.i);
    }
    if ((paramBoolean) && (this.g != null))
    {
      Iterator localIterator2 = h.a(this.h).c().iterator();
      while (localIterator2.hasNext()) {
        ((i)localIterator2.next()).incRealTimeEventUploadSucc(this.g.size());
      }
    }
    if ((paramBoolean) && (this.i == null) && (this.g != null)) {
      this.g = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.event.j
 * JD-Core Version:    0.7.0.1
 */