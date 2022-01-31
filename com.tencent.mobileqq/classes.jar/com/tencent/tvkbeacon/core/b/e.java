package com.tencent.tvkbeacon.core.b;

import android.content.Context;
import com.tencent.tvkbeacon.core.c.c;

public abstract class e
{
  private static e a = null;
  
  /* Error */
  public static e a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 20	com/tencent/tvkbeacon/core/strategy/d:a	(Landroid/content/Context;)Lcom/tencent/tvkbeacon/core/strategy/d;
    //   7: invokevirtual 24	com/tencent/tvkbeacon/core/strategy/d:d	()Z
    //   10: istore_1
    //   11: getstatic 10	com/tencent/tvkbeacon/core/b/e:a	Lcom/tencent/tvkbeacon/core/b/e;
    //   14: ifnonnull +21 -> 35
    //   17: aload_0
    //   18: ifnull +17 -> 35
    //   21: aload_0
    //   22: iload_1
    //   23: invokestatic 27	com/tencent/tvkbeacon/core/b/e:a	(Landroid/content/Context;Z)V
    //   26: getstatic 10	com/tencent/tvkbeacon/core/b/e:a	Lcom/tencent/tvkbeacon/core/b/e;
    //   29: astore_0
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_0
    //   34: areturn
    //   35: getstatic 10	com/tencent/tvkbeacon/core/b/e:a	Lcom/tencent/tvkbeacon/core/b/e;
    //   38: ifnull -12 -> 26
    //   41: getstatic 10	com/tencent/tvkbeacon/core/b/e:a	Lcom/tencent/tvkbeacon/core/b/e;
    //   44: invokevirtual 29	com/tencent/tvkbeacon/core/b/e:a	()Z
    //   47: iload_1
    //   48: if_icmpeq -22 -> 26
    //   51: aload_0
    //   52: iload_1
    //   53: invokestatic 27	com/tencent/tvkbeacon/core/b/e:a	(Landroid/content/Context;Z)V
    //   56: goto -30 -> 26
    //   59: astore_0
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramContext	Context
    //   10	43	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	17	59	finally
    //   21	26	59	finally
    //   26	30	59	finally
    //   35	56	59	finally
  }
  
  private static void a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a = new e.b(paramContext);
      return;
    }
    a = new e.a(paramContext);
  }
  
  protected static void b()
  {
    try
    {
      Thread.sleep(5000L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      c.a(localInterruptedException);
    }
  }
  
  public abstract boolean a();
  
  public byte[] a(String paramString, int paramInt, byte[] paramArrayOfByte, a parama, d paramd)
  {
    return null;
  }
  
  public byte[] a(String paramString, byte[] paramArrayOfByte, a parama, d paramd)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.b.e
 * JD-Core Version:    0.7.0.1
 */