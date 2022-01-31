package com.tencent.tvkbeacon.i;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.tvkbeacon.core.c.i;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class b
{
  private static String a = "on_realtime_ua_times_";
  private static String b = "on_normal_ua_times_";
  private static volatile b c;
  private final Context d;
  private AtomicBoolean e = new AtomicBoolean(false);
  private final AtomicBoolean f = new AtomicBoolean(false);
  private String g;
  private AtomicLong h = new AtomicLong(0L);
  private AtomicLong i = new AtomicLong(0L);
  private List<String> j = new ArrayList();
  private String k;
  private String l;
  private SharedPreferences m;
  private boolean n;
  private final Runnable o = new b.2(this);
  
  private b(Context paramContext)
  {
    this.d = paramContext;
    this.n = com.tencent.tvkbeacon.core.info.b.a(paramContext).k();
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new b(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      com.tencent.tvkbeacon.core.a.b.d().a(new b.1(this, paramString, paramLong1, paramLong2));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private SharedPreferences b(Context paramContext)
  {
    if (this.m == null) {
      this.m = paramContext.getSharedPreferences("tvkbeacon_logid", 0);
    }
    return this.m;
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/tencent/tvkbeacon/i/b:e	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 128	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifne +43 -> 52
    //   12: aload_0
    //   13: getfield 67	com/tencent/tvkbeacon/i/b:j	Ljava/util/List;
    //   16: ldc 130
    //   18: invokeinterface 136 2 0
    //   23: pop
    //   24: aload_0
    //   25: getfield 86	com/tencent/tvkbeacon/i/b:n	Z
    //   28: ifeq +27 -> 55
    //   31: ldc 138
    //   33: iconst_0
    //   34: anewarray 4	java/lang/Object
    //   37: invokestatic 143	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   40: aload_0
    //   41: invokespecial 145	com/tencent/tvkbeacon/i/b:f	()V
    //   44: aload_0
    //   45: getfield 51	com/tencent/tvkbeacon/i/b:e	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   48: iconst_1
    //   49: invokevirtual 148	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 76	com/tencent/tvkbeacon/i/b:d	Landroid/content/Context;
    //   60: invokestatic 154	com/tencent/tvkbeacon/i/ModuleImpl:getInstance	(Landroid/content/Context;)Lcom/tencent/tvkbeacon/i/ModuleImpl;
    //   63: getfield 157	com/tencent/tvkbeacon/i/ModuleImpl:specifiedSerialEventName	Ljava/lang/String;
    //   66: putfield 159	com/tencent/tvkbeacon/i/b:k	Ljava/lang/String;
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 76	com/tencent/tvkbeacon/i/b:d	Landroid/content/Context;
    //   74: invokespecial 90	com/tencent/tvkbeacon/i/b:b	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   77: astore_1
    //   78: aload_0
    //   79: aload_1
    //   80: ldc 161
    //   82: ldc 163
    //   84: invokeinterface 169 3 0
    //   89: putfield 125	com/tencent/tvkbeacon/i/b:g	Ljava/lang/String;
    //   92: aload_0
    //   93: getfield 62	com/tencent/tvkbeacon/i/b:i	Ljava/util/concurrent/atomic/AtomicLong;
    //   96: aload_1
    //   97: getstatic 35	com/tencent/tvkbeacon/i/b:a	Ljava/lang/String;
    //   100: lconst_0
    //   101: invokeinterface 173 4 0
    //   106: invokevirtual 175	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   109: aload_0
    //   110: getfield 60	com/tencent/tvkbeacon/i/b:h	Ljava/util/concurrent/atomic/AtomicLong;
    //   113: aload_1
    //   114: getstatic 39	com/tencent/tvkbeacon/i/b:b	Ljava/lang/String;
    //   117: lconst_0
    //   118: invokeinterface 173 4 0
    //   123: invokevirtual 175	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   126: ldc 177
    //   128: iconst_3
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_0
    //   135: getfield 125	com/tencent/tvkbeacon/i/b:g	Ljava/lang/String;
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: aload_0
    //   142: getfield 62	com/tencent/tvkbeacon/i/b:i	Ljava/util/concurrent/atomic/AtomicLong;
    //   145: invokevirtual 180	java/util/concurrent/atomic/AtomicLong:get	()J
    //   148: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   151: aastore
    //   152: dup
    //   153: iconst_2
    //   154: aload_0
    //   155: getfield 60	com/tencent/tvkbeacon/i/b:h	Ljava/util/concurrent/atomic/AtomicLong;
    //   158: invokevirtual 180	java/util/concurrent/atomic/AtomicLong:get	()J
    //   161: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   164: aastore
    //   165: invokestatic 143	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload_0
    //   169: invokevirtual 188	com/tencent/tvkbeacon/i/b:a	()V
    //   172: aload_0
    //   173: getfield 51	com/tencent/tvkbeacon/i/b:e	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   176: iconst_1
    //   177: invokevirtual 148	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   180: goto -128 -> 52
    //   183: astore_1
    //   184: aload_0
    //   185: monitorexit
    //   186: aload_1
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	b
    //   77	37	1	localSharedPreferences	SharedPreferences
    //   183	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	52	183	finally
    //   55	180	183	finally
  }
  
  private void e()
  {
    try
    {
      if (!com.tencent.tvkbeacon.core.c.a.b(com.tencent.tvkbeacon.core.c.a.a(com.tencent.tvkbeacon.core.info.b.a(this.d).i())).equals(this.g))
      {
        a(this.g, this.i.get(), this.h.get());
        f();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void f()
  {
    this.i.set(0L);
    this.h.set(0L);
    this.g = com.tencent.tvkbeacon.core.c.a.b(com.tencent.tvkbeacon.core.c.a.a(com.tencent.tvkbeacon.core.info.b.a(this.d).i()));
    a();
  }
  
  private void g()
  {
    try
    {
      if (!this.f.get())
      {
        if (i.a(this.l)) {
          this.l = com.tencent.tvkbeacon.core.info.a.g(this.d);
        }
        if (!a.contains(this.l)) {
          a = a.concat(this.l);
        }
        if (!b.contains(this.l)) {
          b = b.concat(this.l);
        }
        this.f.set(true);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final String a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 228	com/tencent/tvkbeacon/i/b:g	()V
    //   6: aload_0
    //   7: invokespecial 230	com/tencent/tvkbeacon/i/b:d	()V
    //   10: aload_0
    //   11: invokespecial 232	com/tencent/tvkbeacon/i/b:e	()V
    //   14: aload_0
    //   15: getfield 67	com/tencent/tvkbeacon/i/b:j	Ljava/util/List;
    //   18: aload_1
    //   19: invokeinterface 234 2 0
    //   24: ifeq +10 -> 34
    //   27: ldc 163
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: areturn
    //   34: new 236	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   41: astore_3
    //   42: iload_2
    //   43: ifeq +44 -> 87
    //   46: aload_3
    //   47: aload_0
    //   48: getfield 62	com/tencent/tvkbeacon/i/b:i	Ljava/util/concurrent/atomic/AtomicLong;
    //   51: lconst_1
    //   52: invokevirtual 240	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
    //   55: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: ldc 246
    //   61: iconst_2
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload_1
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: aload_3
    //   72: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: aastore
    //   76: invokestatic 143	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: aload_3
    //   80: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore_1
    //   84: goto -54 -> 30
    //   87: aload_3
    //   88: aload_0
    //   89: getfield 60	com/tencent/tvkbeacon/i/b:h	Ljava/util/concurrent/atomic/AtomicLong;
    //   92: lconst_1
    //   93: invokevirtual 240	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
    //   96: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: goto -41 -> 59
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	b
    //   0	108	1	paramString	String
    //   0	108	2	paramBoolean	boolean
    //   41	47	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	27	103	finally
    //   34	42	103	finally
    //   46	59	103	finally
    //   59	84	103	finally
    //   87	100	103	finally
  }
  
  public final void a()
  {
    try
    {
      com.tencent.tvkbeacon.core.a.b.a = false;
      com.tencent.tvkbeacon.core.a.b.d().a(113, this.o, 0L, 500L);
      com.tencent.tvkbeacon.core.a.b.a = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.i.b
 * JD-Core Version:    0.7.0.1
 */