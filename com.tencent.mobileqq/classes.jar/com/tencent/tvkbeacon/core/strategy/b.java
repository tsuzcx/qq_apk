package com.tencent.tvkbeacon.core.strategy;

import android.util.SparseArray;
import com.tencent.tvkbeacon.core.c.c;
import java.util.Map;

public class b
{
  private static b b = null;
  public boolean a = false;
  private String c = "";
  private int d = 360;
  private int e = 100;
  private SparseArray<a> f = null;
  private Map<String, String> g = null;
  private boolean h = true;
  
  private b()
  {
    this.f.put(1, new a(1));
    this.f.put(2, new a(2));
    this.f.put(3, new a(3));
  }
  
  public static b a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new b();
      }
      return b;
    }
    finally {}
  }
  
  private void k()
  {
    c.b("[net] -> change to http mode.", new Object[0]);
    this.h = false;
  }
  
  public final void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final void a(String paramString)
  {
    if (this.a)
    {
      c.c("[strategy] url has defined by api, don't change.", new Object[0]);
      return;
    }
    this.c = paramString;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    try
    {
      this.a = true;
      k();
      this.c = com.tencent.tvkbeacon.core.protocol.a.a.a(paramString1);
      c.b("[strategy] set strategy url to %s by api.", new Object[] { this.c });
      paramString1 = (a)this.f.get(1);
      if (paramString1 != null)
      {
        paramString1.a = com.tencent.tvkbeacon.core.protocol.a.a.a(paramString2);
        c.b("[strategy] set user event url to %s by api.", new Object[] { paramString1.a });
      }
      return;
    }
    finally {}
  }
  
  public final void a(Map<String, String> paramMap)
  {
    this.g = paramMap;
  }
  
  public final String b()
  {
    if (!a().h) {}
    for (boolean bool = true;; bool = false)
    {
      String str = com.tencent.tvkbeacon.core.protocol.a.a.a(bool, this.c);
      c.b("[net] module strategy url: %s", new Object[] { str });
      return str;
    }
  }
  
  public final String b(String paramString)
  {
    Object localObject = (a)this.f.get(1);
    if (localObject != null)
    {
      localObject = ((a)localObject).b();
      if (localObject != null) {
        return (String)((Map)localObject).get(paramString);
      }
    }
    return null;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  public final Map<String, String> d()
  {
    return this.g;
  }
  
  /* Error */
  public final SparseArray<a> e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	com/tencent/tvkbeacon/core/strategy/b:f	Landroid/util/SparseArray;
    //   6: ifnull +23 -> 29
    //   9: new 115	com/tencent/tvkbeacon/core/c/g
    //   12: dup
    //   13: invokespecial 116	com/tencent/tvkbeacon/core/c/g:<init>	()V
    //   16: pop
    //   17: aload_0
    //   18: getfield 40	com/tencent/tvkbeacon/core/strategy/b:f	Landroid/util/SparseArray;
    //   21: invokestatic 119	com/tencent/tvkbeacon/core/c/g:a	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: areturn
    //   29: aconst_null
    //   30: astore_1
    //   31: goto -6 -> 25
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	b
    //   24	7	1	localSparseArray	SparseArray
    //   34	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	34	finally
  }
  
  /* Error */
  public final a f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	com/tencent/tvkbeacon/core/strategy/b:f	Landroid/util/SparseArray;
    //   6: ifnull +19 -> 25
    //   9: aload_0
    //   10: getfield 40	com/tencent/tvkbeacon/core/strategy/b:f	Landroid/util/SparseArray;
    //   13: iconst_1
    //   14: invokevirtual 85	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   17: checkcast 51	com/tencent/tvkbeacon/core/strategy/a
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: aconst_null
    //   26: astore_1
    //   27: goto -6 -> 21
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	b
    //   20	7	1	locala	a
    //   30	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	30	finally
  }
  
  public final int g()
  {
    if (this.g != null)
    {
      String str = (String)this.g.get("maxStrategyQueryOneDay");
      if ((str != null) && (!str.trim().equals("")))
      {
        int i = this.e;
        try
        {
          int j = Integer.valueOf(str).intValue();
          return j;
        }
        catch (Exception localException)
        {
          return i;
        }
      }
    }
    return this.e;
  }
  
  /* Error */
  public final boolean h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/tencent/tvkbeacon/core/strategy/b:g	Ljava/util/Map;
    //   6: ifnull +50 -> 56
    //   9: aload_0
    //   10: getfield 42	com/tencent/tvkbeacon/core/strategy/b:g	Ljava/util/Map;
    //   13: ldc 144
    //   15: invokeinterface 108 2 0
    //   20: checkcast 110	java/lang/String
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +31 -> 56
    //   28: ldc 146
    //   30: aload_3
    //   31: invokevirtual 150	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   34: ifeq +22 -> 56
    //   37: invokestatic 156	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   40: bipush 11
    //   42: invokevirtual 159	java/util/Calendar:get	(I)I
    //   45: istore_1
    //   46: iload_1
    //   47: ifne +9 -> 56
    //   50: iconst_1
    //   51: istore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_2
    //   55: ireturn
    //   56: iconst_0
    //   57: istore_2
    //   58: goto -6 -> 52
    //   61: astore_3
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_3
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	b
    //   45	2	1	i	int
    //   51	7	2	bool	boolean
    //   23	8	3	str	String
    //   61	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	61	finally
    //   28	46	61	finally
  }
  
  public final boolean i()
  {
    return this.h;
  }
  
  public final void j()
  {
    String str = b("isSocketOnOff");
    if ((str != null) && ("n".equals(str))) {
      k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.strategy.b
 * JD-Core Version:    0.7.0.1
 */