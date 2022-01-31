package com.tencent.tvkbeacon.core.event;

import android.content.Context;
import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.core.c.d;
import com.tencent.tvkbeacon.core.protocol.common.MixPackage;
import com.tencent.tvkbeacon.core.protocol.common.RequestPackage;
import com.tencent.tvkbeacon.g.QimeiSDK;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
  extends com.tencent.tvkbeacon.core.b.a
{
  private static b.b l = new b.a((byte)0);
  private Context g = null;
  private Long[] h = null;
  private List<Long> i = null;
  private byte[] j = null;
  private boolean k = false;
  
  public b(Context paramContext, String paramString)
  {
    super(paramContext, 1, 4, paramString);
    this.g = paramContext;
  }
  
  private boolean g()
  {
    try
    {
      boolean bool = this.k;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final RequestPackage a()
  {
    Object localObject9 = null;
    Object localObject7;
    Object localObject8;
    label150:
    int n;
    label214:
    for (;;)
    {
      try
      {
        Object localObject1 = TunnelModule.getInstance(this.c);
        if ((localObject1 == null) || (!((TunnelModule)localObject1).isEnable))
        {
          c.d("[event] module null!", new Object[0]);
          localObject1 = localObject9;
          return localObject1;
        }
        localObject7 = EventStrategyBean.getInstance();
        if (localObject7 == null)
        {
          c.d("[event] strategy null!", new Object[0]);
          localObject1 = localObject9;
        }
        else
        {
          try
          {
            if (!g()) {
              break label678;
            }
            localObject8 = com.tencent.tvkbeacon.core.a.a.b.a(this.g, this.f);
            if ((localObject8 == null) || (((List)localObject8).size() <= 0)) {
              break label678;
            }
            Object localObject3 = (byte[])((List)localObject8).get(3);
            this.d = String.valueOf(((List)localObject8).get(1));
            this.e = ((Integer)((List)localObject8).get(4)).intValue();
            if (localObject3 != null)
            {
              localObject3 = e.a(this.c, this.a, (byte[])localObject3, this.f);
            }
            else
            {
              n = ((EventStrategyBean)localObject7).getComNumUpload();
              m = n;
              if (!d.a(this.g)) {
                m = n / 2;
              }
              if (m < 0) {
                break label672;
              }
              localObject7 = l.a(this.g, this.f, m);
              if ((localObject7 != null) && (((List)localObject7).size() > 0)) {
                break;
              }
              c.h("[event] No event need upload.", new Object[0]);
              localObject3 = localObject9;
            }
          }
          catch (Throwable localThrowable)
          {
            c.a(localThrowable);
            c.d("[event] get req data error: %s", new Object[] { localThrowable.toString() });
            localObject4 = localObject9;
          }
        }
      }
      finally {}
    }
    int m = ((List)localObject7).size();
    c.h("[event] %d events need upload.", new Object[] { Integer.valueOf(m) });
    this.e = m;
    Object localObject4 = ((List)localObject7).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject8 = ((RDBean)((Iterator)localObject4).next()).getEMap();
      if (localObject8 != null) {
        ((Map)localObject8).put("A3", QimeiSDK.getInstance().getQimeiInternal());
      }
    }
    if (localObject7 != null) {}
    for (;;)
    {
      for (;;)
      {
        try
        {
          n = ((List)localObject7).size();
          if (n > 0) {
            continue;
          }
          localObject4 = null;
          localObject8 = localObject4;
        }
        catch (Exception localException1)
        {
          b();
          localObject8 = null;
          continue;
          ((List)localObject7).clear();
          localObject5 = localObject9;
        }
        this.h = new Long[m];
        m = 0;
        if (m < this.h.length)
        {
          this.h[m] = Long.valueOf(((RDBean)((List)localObject7).get(m)).getCid());
          m += 1;
          continue;
          this.i = new ArrayList();
          if (l == null) {
            break label667;
          }
          localObject4 = l.a((List)localObject7, this.i);
          if (this.i.size() <= 0) {
            break label683;
          }
          l.a(this.g, this.f, (Long[])this.i.toArray(new Long[this.i.size()]));
          break label683;
          localObject8 = new HashMap();
          if (localObject4 != null) {
            ((Map)localObject8).put(Integer.valueOf(1), localObject4);
          }
          localObject4 = new MixPackage();
          ((MixPackage)localObject4).mixMap = ((Map)localObject8);
        }
        else
        {
          if (localObject8 == null) {
            break;
          }
          Object localObject5 = ((MixPackage)localObject8).toByteArray();
          this.j = new byte[localObject5.length];
          System.arraycopy(localObject5, 0, this.j, 0, localObject5.length);
          this.d = com.tencent.tvkbeacon.core.c.a.a(this.c, 4, this.f);
          c.b("[event] comm rid:%s", new Object[] { this.d });
          try
          {
            localObject5 = e.a(this.c, this.a, (byte[])localObject5, this.f);
          }
          catch (Exception localException2)
          {
            b();
            localObject6 = localObject9;
          }
        }
      }
      break;
      label667:
      Object localObject6 = null;
      continue;
      label672:
      localObject7 = null;
      break label214;
      label678:
      localObject6 = null;
      break label150;
      label683:
      if (localObject6 == null) {
        localObject6 = null;
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      this.k = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b()
  {
    try
    {
      c.c("[event] encode failed, clear db data", new Object[0]);
      if ((this.h != null) && (this.h.length > 0))
      {
        c.b("[event] remove num :".concat(String.valueOf(l.a(this.g, this.f, this.h))), new Object[0]);
        this.h = null;
      }
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
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 36	com/tencent/tvkbeacon/core/event/b:h	[Ljava/lang/Long;
    //   8: ifnull +9 -> 17
    //   11: aload_0
    //   12: getfield 36	com/tencent/tvkbeacon/core/event/b:h	[Ljava/lang/Long;
    //   15: arraylength
    //   16: istore_2
    //   17: iload_2
    //   18: ifle +34 -> 52
    //   21: ldc_w 267
    //   24: aload_0
    //   25: getfield 34	com/tencent/tvkbeacon/core/event/b:g	Landroid/content/Context;
    //   28: aload_0
    //   29: getfield 84	com/tencent/tvkbeacon/core/event/b:f	Ljava/lang/String;
    //   32: aload_0
    //   33: getfield 36	com/tencent/tvkbeacon/core/event/b:h	[Ljava/lang/Long;
    //   36: invokestatic 216	com/tencent/tvkbeacon/core/event/l:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Long;)I
    //   39: invokestatic 261	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   42: invokevirtual 265	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   45: iconst_0
    //   46: anewarray 65	java/lang/Object
    //   49: invokestatic 251	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 36	com/tencent/tvkbeacon/core/event/b:h	[Ljava/lang/Long;
    //   57: iload_1
    //   58: ifeq +34 -> 92
    //   61: aload_0
    //   62: invokespecial 80	com/tencent/tvkbeacon/core/event/b:g	()Z
    //   65: ifeq +27 -> 92
    //   68: aload_0
    //   69: getfield 34	com/tencent/tvkbeacon/core/event/b:g	Landroid/content/Context;
    //   72: aload_0
    //   73: getfield 84	com/tencent/tvkbeacon/core/event/b:f	Ljava/lang/String;
    //   76: aload_0
    //   77: getfield 108	com/tencent/tvkbeacon/core/event/b:d	Ljava/lang/String;
    //   80: invokestatic 270	com/tencent/tvkbeacon/core/a/a/b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   83: pop
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 40	com/tencent/tvkbeacon/core/event/b:j	[B
    //   89: aload_0
    //   90: monitorexit
    //   91: return
    //   92: iload_1
    //   93: ifne -9 -> 84
    //   96: aload_0
    //   97: getfield 40	com/tencent/tvkbeacon/core/event/b:j	[B
    //   100: ifnull -16 -> 84
    //   103: ldc_w 272
    //   106: iconst_1
    //   107: anewarray 65	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload_0
    //   113: getfield 108	com/tencent/tvkbeacon/core/event/b:d	Ljava/lang/String;
    //   116: aastore
    //   117: invokestatic 251	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: aload_0
    //   121: getfield 34	com/tencent/tvkbeacon/core/event/b:g	Landroid/content/Context;
    //   124: aload_0
    //   125: getfield 84	com/tencent/tvkbeacon/core/event/b:f	Ljava/lang/String;
    //   128: aload_0
    //   129: getfield 40	com/tencent/tvkbeacon/core/event/b:j	[B
    //   132: aload_0
    //   133: getfield 108	com/tencent/tvkbeacon/core/event/b:d	Ljava/lang/String;
    //   136: iload_2
    //   137: invokestatic 275	com/tencent/tvkbeacon/core/a/a/b:a	(Landroid/content/Context;Ljava/lang/String;[BLjava/lang/String;I)Z
    //   140: pop
    //   141: goto -57 -> 84
    //   144: astore_3
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_3
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	b
    //   0	149	1	paramBoolean	boolean
    //   1	136	2	m	int
    //   144	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	17	144	finally
    //   21	52	144	finally
    //   52	57	144	finally
    //   61	84	144	finally
    //   84	89	144	finally
    //   96	141	144	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.event.b
 * JD-Core Version:    0.7.0.1
 */