package com.tencent.tvkbeacon.core.info;

import android.content.Context;
import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.upload.TunnelInfo;
import java.util.HashMap;
import java.util.Map;

public class e
  extends b
{
  private static volatile e d;
  private Context e;
  private Map<String, TunnelInfo> f = new HashMap();
  private String g = "";
  
  private e(Context paramContext)
  {
    super(paramContext);
    this.e = paramContext;
  }
  
  public static e b(Context paramContext)
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new e(paramContext);
      }
      return d;
    }
    finally {}
  }
  
  /* Error */
  public final String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 43	com/tencent/tvkbeacon/core/c/i:a	(Ljava/lang/String;)Z
    //   6: ifne +40 -> 46
    //   9: aload_0
    //   10: getfield 24	com/tencent/tvkbeacon/core/info/e:f	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 49 2 0
    //   19: checkcast 51	com/tencent/tvkbeacon/upload/TunnelInfo
    //   22: astore_2
    //   23: aload_2
    //   24: ifnull +22 -> 46
    //   27: aload_2
    //   28: getfield 54	com/tencent/tvkbeacon/upload/TunnelInfo:channel	Ljava/lang/String;
    //   31: invokestatic 43	com/tencent/tvkbeacon/core/c/i:a	(Ljava/lang/String;)Z
    //   34: ifne +12 -> 46
    //   37: aload_2
    //   38: getfield 54	com/tencent/tvkbeacon/upload/TunnelInfo:channel	Ljava/lang/String;
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: aload_0
    //   47: getfield 30	com/tencent/tvkbeacon/core/info/e:e	Landroid/content/Context;
    //   50: invokestatic 57	com/tencent/tvkbeacon/core/info/b:a	(Landroid/content/Context;)Lcom/tencent/tvkbeacon/core/info/b;
    //   53: aload_1
    //   54: invokevirtual 59	com/tencent/tvkbeacon/core/info/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore_1
    //   58: goto -16 -> 42
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	e
    //   0	66	1	paramString	String
    //   22	16	2	localTunnelInfo	TunnelInfo
    // Exception table:
    //   from	to	target	type
    //   2	23	61	finally
    //   27	42	61	finally
    //   46	58	61	finally
  }
  
  public final void a(String paramString, TunnelInfo paramTunnelInfo)
  {
    try
    {
      this.f.put(paramString, paramTunnelInfo);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public final String b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 43	com/tencent/tvkbeacon/core/c/i:a	(Ljava/lang/String;)Z
    //   6: ifne +40 -> 46
    //   9: aload_0
    //   10: getfield 24	com/tencent/tvkbeacon/core/info/e:f	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 49 2 0
    //   19: checkcast 51	com/tencent/tvkbeacon/upload/TunnelInfo
    //   22: astore_2
    //   23: aload_2
    //   24: ifnull +22 -> 46
    //   27: aload_2
    //   28: getfield 67	com/tencent/tvkbeacon/upload/TunnelInfo:version	Ljava/lang/String;
    //   31: invokestatic 43	com/tencent/tvkbeacon/core/c/i:a	(Ljava/lang/String;)Z
    //   34: ifne +12 -> 46
    //   37: aload_2
    //   38: getfield 67	com/tencent/tvkbeacon/upload/TunnelInfo:version	Ljava/lang/String;
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: aload_0
    //   47: getfield 30	com/tencent/tvkbeacon/core/info/e:e	Landroid/content/Context;
    //   50: invokestatic 57	com/tencent/tvkbeacon/core/info/b:a	(Landroid/content/Context;)Lcom/tencent/tvkbeacon/core/info/b;
    //   53: aload_1
    //   54: invokevirtual 69	com/tencent/tvkbeacon/core/info/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore_1
    //   58: goto -16 -> 42
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	e
    //   0	66	1	paramString	String
    //   22	16	2	localTunnelInfo	TunnelInfo
    // Exception table:
    //   from	to	target	type
    //   2	23	61	finally
    //   27	42	61	finally
    //   46	58	61	finally
  }
  
  public final void d(String paramString)
  {
    if (paramString != null)
    {
      this.g = paramString;
      c.b("[core] -> JavaScript clientID:" + this.g, new Object[0]);
    }
  }
  
  public final String h()
  {
    try
    {
      String str = b.a(this.e).h();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long i()
  {
    try
    {
      long l = b.a(this.e).i();
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String l()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.info.e
 * JD-Core Version:    0.7.0.1
 */