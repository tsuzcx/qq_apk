package com.tencent.tvkbeacon.core.strategy;

import android.content.Context;
import android.util.Base64;
import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.core.protocol.a.a;

public class d
{
  private static d a;
  private final String b = "sid";
  private String c = "";
  private boolean d = true;
  private int e = 8081;
  private String f = "";
  private String g = "";
  
  private d(Context paramContext)
  {
    paramContext = new d.1(this, paramContext);
    com.tencent.tvkbeacon.core.a.b.d().a(paramContext);
  }
  
  public static d a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new d(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  private void a(Context paramContext, String paramString)
  {
    try
    {
      this.g = paramString;
      this.f = Base64.encodeToString(com.tencent.tvkbeacon.core.protocol.a.b.a(paramContext, paramString), 2);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      this.c = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String a()
  {
    try
    {
      String str = this.c;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String a(int paramInt)
  {
    boolean bool2 = c.b;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        if (this.d) {
          break label76;
        }
        bool1 = true;
        return a.a(bool1, null);
      }
      catch (Throwable localThrowable)
      {
        String str;
        c.c("[strategy] get strategy error:%s", new Object[] { localThrowable.toString() });
        c.a(localThrowable);
        return null;
      }
      if (!this.d)
      {
        bool1 = true;
        str = a.a(bool1, bool2 & true, null);
        return str;
      }
      boolean bool1 = false;
      continue;
      label76:
      bool1 = false;
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      c.b("[net] -> update local sid|time[%s|%s].", new Object[] { paramString1, paramString2 });
      this.c = paramString1;
      paramContext = new d.2(this, paramString1, paramString2, paramContext);
      com.tencent.tvkbeacon.core.a.b.d().a(paramContext);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public final String b()
  {
    try
    {
      String str = this.g;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 22
    //   5: invokestatic 112	com/tencent/tvkbeacon/core/a/a/c:a	(Landroid/content/Context;Ljava/lang/String;)[Ljava/lang/Object;
    //   8: astore 6
    //   10: aload 6
    //   12: ifnull +55 -> 67
    //   15: aload 6
    //   17: arraylength
    //   18: iconst_3
    //   19: if_icmpne +48 -> 67
    //   22: new 114	java/util/Date
    //   25: dup
    //   26: invokespecial 115	java/util/Date:<init>	()V
    //   29: invokevirtual 119	java/util/Date:getTime	()J
    //   32: ldc2_w 120
    //   35: ldiv
    //   36: lstore 4
    //   38: aload 6
    //   40: iconst_2
    //   41: aaload
    //   42: checkcast 123	java/lang/Long
    //   45: invokevirtual 126	java/lang/Long:longValue	()J
    //   48: lstore_2
    //   49: lload_2
    //   50: lload 4
    //   52: lcmp
    //   53: ifle +14 -> 67
    //   56: aload_0
    //   57: aload 6
    //   59: iconst_1
    //   60: aaload
    //   61: checkcast 128	java/lang/String
    //   64: invokespecial 130	com/tencent/tvkbeacon/core/strategy/d:a	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: aload_1
    //   69: aload_1
    //   70: invokestatic 135	com/tencent/tvkbeacon/core/c/a:a	(Landroid/content/Context;)Ljava/lang/String;
    //   73: invokespecial 137	com/tencent/tvkbeacon/core/strategy/d:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: astore 7
    //   81: lconst_0
    //   82: lstore_2
    //   83: goto -34 -> 49
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	d
    //   0	91	1	paramContext	Context
    //   48	35	2	l1	long
    //   36	15	4	l2	long
    //   8	50	6	arrayOfObject	Object[]
    //   79	1	7	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   38	49	79	java/lang/Exception
    //   2	10	86	finally
    //   15	38	86	finally
    //   38	49	86	finally
    //   56	67	86	finally
    //   67	76	86	finally
  }
  
  public final String c()
  {
    try
    {
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean d()
  {
    return this.d;
  }
  
  public final void e()
  {
    this.d = false;
  }
  
  public final int f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.strategy.d
 * JD-Core Version:    0.7.0.1
 */