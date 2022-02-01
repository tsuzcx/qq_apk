package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class UrsaMajor
{
  public static int[] Ag = { 0, 15, 30, 90, 240, 360, 600, 1200, 2400, 3200, 4800, 7200 };
  public static long Bg;
  public static UrsaMajor zg = new UrsaMajor();
  public void Yg;
  public Handler Zg;
  public boolean _g = false;
  public Almond ah;
  public final Object bh = new Object();
  public final AtomicReference<Serpens> ch = new AtomicReference(null);
  public final AtomicReference<Boolean> dh = new AtomicReference(Boolean.valueOf(false));
  
  static
  {
    Bg = TimeUnit.MINUTES.toMillis(30L);
  }
  
  public static int J()
  {
    return 1;
  }
  
  public final void I()
  {
    synchronized (this.dh)
    {
      if (((Boolean)this.dh.get()).booleanValue()) {
        return;
      }
      this.dh.set(Boolean.valueOf(true));
      this.Zg.sendEmptyMessage(2);
      return;
    }
  }
  
  public final int a(Serpens paramSerpens)
  {
    if (this.Yg.r()) {}
    do
    {
      long l1;
      do
      {
        do
        {
          return 2;
        } while ((paramSerpens.fg != 0) || (TextUtils.isEmpty(paramSerpens.Og)));
        l1 = System.currentTimeMillis() / 1000L;
        if (l1 < paramSerpens.Pg) {
          break;
        }
      } while (this.Yg.p());
      return 3;
      long l2 = this.ah.w(this.get());
      if (Math.abs(l1 - this.ah.d(this.get(), "108")) < l2) {
        break;
      }
    } while (this.Yg.p());
    return 3;
    return 1;
  }
  
  /* Error */
  public final long a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: ifeq +114 -> 117
    //   6: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   9: lstore 4
    //   11: getstatic 188	com/tencent/turingfd/sdk/xq/Avocado:zg	Lcom/tencent/turingfd/sdk/xq/Avocado;
    //   14: astore 8
    //   16: aload_0
    //   17: getfield 98	com/tencent/turingfd/sdk/xq/UrsaMajor:Yg	Lcom/tencent/turingfd/sdk/xq/void;
    //   20: invokevirtual 192	com/tencent/turingfd/sdk/xq/void:f	()Ljava/lang/String;
    //   23: astore 9
    //   25: aload_0
    //   26: getfield 78	com/tencent/turingfd/sdk/xq/UrsaMajor:ah	Lcom/tencent/turingfd/sdk/xq/Almond;
    //   29: astore 10
    //   31: aload 8
    //   33: aload_1
    //   34: iload_2
    //   35: aload 9
    //   37: aload 10
    //   39: aload_1
    //   40: ldc 194
    //   42: invokevirtual 176	com/tencent/turingfd/sdk/xq/Almond:d	(Landroid/content/Context;Ljava/lang/String;)J
    //   45: aload_0
    //   46: aload_1
    //   47: invokevirtual 197	com/tencent/turingfd/sdk/xq/UrsaMajor:p	(Landroid/content/Context;)Lcom/tencent/turingfd/sdk/xq/Serpens;
    //   50: getfield 139	com/tencent/turingfd/sdk/xq/Serpens:Og	Ljava/lang/String;
    //   53: invokevirtual 200	com/tencent/turingfd/sdk/xq/Avocado:a	(Landroid/content/Context;ILjava/lang/String;JLjava/lang/String;)Z
    //   56: ifeq +11 -> 67
    //   59: aload_0
    //   60: getfield 78	com/tencent/turingfd/sdk/xq/UrsaMajor:ah	Lcom/tencent/turingfd/sdk/xq/Almond;
    //   63: aload_1
    //   64: invokevirtual 204	com/tencent/turingfd/sdk/xq/Almond:C	(Landroid/content/Context;)V
    //   67: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   70: lstore 6
    //   72: lload 6
    //   74: lload 4
    //   76: lsub
    //   77: lstore 4
    //   79: aload_0
    //   80: iload_3
    //   81: invokevirtual 207	com/tencent/turingfd/sdk/xq/UrsaMajor:c	(Z)V
    //   84: getstatic 188	com/tencent/turingfd/sdk/xq/Avocado:zg	Lcom/tencent/turingfd/sdk/xq/Avocado;
    //   87: aload_1
    //   88: invokevirtual 210	com/tencent/turingfd/sdk/xq/Avocado:L	(Landroid/content/Context;)V
    //   91: aload_0
    //   92: monitorexit
    //   93: lload 4
    //   95: lreturn
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    //   101: astore_1
    //   102: lconst_0
    //   103: lstore 4
    //   105: goto -14 -> 91
    //   108: astore_1
    //   109: goto -18 -> 91
    //   112: astore 8
    //   114: goto -47 -> 67
    //   117: lconst_0
    //   118: lstore 4
    //   120: goto -41 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	UrsaMajor
    //   0	123	1	paramContext	Context
    //   0	123	2	paramInt	int
    //   0	123	3	paramBoolean	boolean
    //   9	110	4	l1	long
    //   70	3	6	l2	long
    //   14	18	8	localAvocado	Avocado
    //   112	1	8	localThrowable	Throwable
    //   23	13	9	str	String
    //   29	9	10	localAlmond	Almond
    // Exception table:
    //   from	to	target	type
    //   6	11	96	finally
    //   11	31	96	finally
    //   31	67	96	finally
    //   67	72	96	finally
    //   79	91	96	finally
    //   6	11	101	java/lang/Throwable
    //   67	72	101	java/lang/Throwable
    //   79	91	108	java/lang/Throwable
    //   11	31	112	java/lang/Throwable
    //   31	67	112	java/lang/Throwable
  }
  
  public final Serpens a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final Serpens a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    for (;;)
    {
      try
      {
        localObject1 = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (localObject1 != null) {
          continue;
        }
        i = 0;
      }
      catch (Throwable localThrowable1)
      {
        Object localObject1;
        boolean bool;
        Bergamot.getInstance().f("1", Log.getStackTraceString(localThrowable1));
        localObject2 = localThrowable1.getMessage();
        int j = 0;
        int i = j;
        if (localObject2 == null) {
          continue;
        }
        i = j;
        if (!((String)localObject2).contains("ACCESS_NETWORK_STATE")) {
          continue;
        }
        i = 1;
        continue;
        if (this.Yg.r()) {
          continue;
        }
        localObject2 = this.get();
        if (Math.abs(System.currentTimeMillis() / 1000L - this.ah.z((Context)localObject2) / 1000L) > 3600L) {
          continue;
        }
        i = 0;
        if (i != 0) {
          continue;
        }
        i = 0;
        if (i != 0) {
          continue;
        }
        return Serpens.f(-10011);
        i = 1;
        continue;
        localObject2 = this.ah.a(this.get(), 6);
        if (((finally)localObject2).size() != 0) {
          continue;
        }
        i = 1;
        continue;
        l1 = this.ah.t(this.get());
        if (l1 > 0L) {
          continue;
        }
        i = 1;
        if (i != 0) {
          continue;
        }
        if (!paramBoolean2) {
          continue;
        }
        continue;
        long l2 = ((Long)((finally)localObject2).getLast()).longValue();
        l2 = Math.abs(System.currentTimeMillis() - l2);
        localObject3 = Ag;
        if (l1 >= localObject3.length) {
          continue;
        }
        i = (int)l1;
        if (i < 1) {
          continue;
        }
        localObject3 = Ag;
        j = localObject3[(i - 1)];
        i = localObject3[i];
        if (j >= i) {
          continue;
        }
        i = new Random().nextInt(i - j + 1);
        if (l2 > TimeUnit.SECONDS.toMillis(i + j)) {
          continue;
        }
        i = 0;
        continue;
        i = localObject3.length - 1;
        continue;
        continue;
        localObject3 = (Long)((finally)localObject2).getFirst();
        if (((finally)localObject2).size() < ((finally)localObject2).getLimit()) {
          continue;
        }
        if (Math.abs(System.currentTimeMillis() - ((Long)localObject3).longValue()) < Bg) {
          continue;
        }
        continue;
        throw new IllegalArgumentException("");
        localObject2 = this.ah.a(this.get(), 6);
        ((finally)localObject2).offer(Long.valueOf(System.currentTimeMillis()));
        this.ah.b(this.get(), (finally)localObject2);
        localObject2 = abstract.m(paramContext);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        this.ah.f(paramContext, (String)localObject2);
        Bilberry.d(paramContext, this.ah);
        Bilberry.c(paramContext, this.ah);
      }
      if (i != 0) {
        continue;
      }
      return Serpens.f(-10012);
      localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
      if (localObject1 != null)
      {
        bool = ((NetworkInfo)localObject1).isConnected();
        if (bool)
        {
          i = 1;
          continue;
        }
      }
      i = 0;
    }
    try
    {
      Object localObject3;
      Object localObject2 = a(paramContext, paramBoolean1, paramBoolean3);
      if (((Serpens)localObject2).fg == -30015)
      {
        this.ah.d(paramContext, System.currentTimeMillis());
        l1 = this.ah.t(paramContext);
        if (((Serpens)localObject2).fg >= 0) {
          break label740;
        }
        this.ah.c(paramContext, l1 + 1L);
        if (!TextUtils.isEmpty(this.ah.x(paramContext))) {
          this.ah.f(paramContext, "");
        }
        if (((Serpens)localObject2).fg == 0)
        {
          Bilberry.b(paramContext, this.ah);
          localObject3 = Bagasse.getInstance();
          Almond localAlmond = this.ah;
          if (((Bagasse)localObject3).a(paramContext, localAlmond))
          {
            l1 = System.currentTimeMillis();
            localAlmond.a(paramContext, "112", "" + l1, false);
          }
        }
        this.ah.a(paramContext, ((Serpens)localObject2).fg, paramBoolean1);
        return localObject2;
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        long l1;
        Serpens localSerpens = Serpens.f(-10015);
        continue;
        if (this.ah.z(paramContext) != 0L)
        {
          this.ah.d(paramContext, 0L);
          continue;
          label740:
          if (l1 != 0L) {
            this.ah.c(paramContext, 0L);
          }
        }
      }
    }
  }
  
  public final Serpens a(Serpens paramSerpens, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    synchronized (this.bh)
    {
      ??? = p(paramContext);
      if ((??? != paramSerpens) && (a((Serpens)???) == 1)) {
        return ???;
      }
    }
    synchronized (this.dh)
    {
      if (!((Boolean)this.dh.get()).booleanValue())
      {
        this.dh.set(Boolean.valueOf(true));
        this.Zg.post(new Triangulum(this, paramContext, paramBoolean1));
      }
      for (;;)
      {
        try
        {
          AtomicReference localAtomicReference = this.dh;
          if (!paramBoolean2) {
            continue;
          }
          l = this.Yg.getTimeout();
          localAtomicReference.wait(l);
        }
        catch (InterruptedException localInterruptedException)
        {
          long l;
          continue;
        }
        paramContext = p(paramContext);
        if (paramContext == paramSerpens) {
          continue;
        }
        return paramContext;
        paramSerpens = finally;
        throw paramSerpens;
        l = 10000L;
      }
      paramSerpens = Serpens.f(-10004);
      return paramSerpens;
    }
  }
  
  public final Virgo a(Context paramContext, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramContext = this.Yg.n();
    if (paramContext == null) {
      paramContext = Virgo.f(-20000);
    }
    for (;;)
    {
      if (paramContext.fg != 0) {}
      return paramContext;
      try
      {
        System.currentTimeMillis();
        paramContext = (throws)paramContext;
        paramContext = paramContext.a(1, paramArrayOfByte, 0, 0);
        if (paramContext.nd != 0) {
          paramContext = Virgo.f(paramContext.nd - 20000);
        } else {
          paramContext = new Virgo(0, paramContext.data);
        }
      }
      catch (Throwable paramContext)
      {
        paramContext = Virgo.f(-20000);
      }
    }
  }
  
  public final void a(Context arg1, boolean paramBoolean)
  {
    boolean bool = this.ah.u(???);
    int i = 0;
    for (;;)
    {
      Serpens localSerpens;
      if (i < this.Yg.k())
      {
        localSerpens = a(???, paramBoolean, bool, false);
        a(localSerpens, true);
        if (localSerpens.fg != 0) {}
      }
      else
      {
        label49:
        if (bool) {
          this.ah.c(???, false);
        }
      }
      synchronized (this.dh)
      {
        this.dh.set(Boolean.valueOf(false));
        this.dh.notifyAll();
        return;
        if (localSerpens.fg == -30014) {
          break label49;
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public final void a(Serpens paramSerpens, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 61	com/tencent/turingfd/sdk/xq/UrsaMajor:ch	Ljava/util/concurrent/atomic/AtomicReference;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_3
    //   12: monitorexit
    //   13: return
    //   14: iload_2
    //   15: ifne +18 -> 33
    //   18: aload_1
    //   19: getfield 135	com/tencent/turingfd/sdk/xq/Serpens:fg	I
    //   22: ifeq +11 -> 33
    //   25: aload_3
    //   26: monitorexit
    //   27: return
    //   28: astore_1
    //   29: aload_3
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    //   33: aload_0
    //   34: getfield 61	com/tencent/turingfd/sdk/xq/UrsaMajor:ch	Ljava/util/concurrent/atomic/AtomicReference;
    //   37: aload_1
    //   38: invokevirtual 116	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   41: aload_3
    //   42: monitorexit
    //   43: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	UrsaMajor
    //   0	44	1	paramSerpens	Serpens
    //   0	44	2	paramBoolean	boolean
    //   4	38	3	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   11	13	28	finally
    //   18	27	28	finally
    //   29	31	28	finally
    //   33	43	28	finally
  }
  
  public final Serpens b(Context paramContext, boolean paramBoolean)
  {
    Serpens localSerpens = p(paramContext);
    int i = a(localSerpens);
    if (i == 1) {}
    do
    {
      return localSerpens;
      if (i == 2)
      {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          I();
          return Serpens.f(-10008);
        }
        return a(localSerpens, paramContext, false, paramBoolean);
      }
    } while (i != 3);
    I();
    return localSerpens;
  }
  
  public final void c(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final Serpens p(Context paramContext)
  {
    synchronized (this.ch)
    {
      Serpens localSerpens2 = (Serpens)this.ch.get();
      Serpens localSerpens1 = localSerpens2;
      if (localSerpens2 == null)
      {
        localSerpens1 = this.ah.A(paramContext);
        this.ch.set(localSerpens1);
      }
      return localSerpens1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.UrsaMajor
 * JD-Core Version:    0.7.0.1
 */