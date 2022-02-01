package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.io.File;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class Bullace
{
  public static Bullace Tg = new Bullace();
  public static int[] Ug = { 0, 15, 30, 90, 240, 360, 600, 1200, 2400, 3200, 4800, 7200 };
  public static long Vg = TimeUnit.MINUTES.toMillis(30L);
  public break Rh;
  public Handler Sh;
  public boolean Th = false;
  public Cascara Uh;
  public final Object Vh = new Object();
  public final AtomicReference<Bilberry> Wh = new AtomicReference(null);
  public final AtomicReference<Boolean> Xh = new AtomicReference(Boolean.valueOf(false));
  
  public final Bilberry C(Context paramContext)
  {
    synchronized (this.Wh)
    {
      Bilberry localBilberry = (Bilberry)this.Wh.get();
      Object localObject = localBilberry;
      if (localBilberry == null)
      {
        if (this.Uh != null) {
          paramContext = this.Uh.Q(paramContext);
        } else {
          paramContext = Bilberry.g(1);
        }
        this.Wh.set(paramContext);
        localObject = paramContext;
      }
      return localObject;
    }
  }
  
  public final void V()
  {
    a(3, 0L);
  }
  
  public final void W()
  {
    Context localContext = void.get();
    Durian.d(localContext, this.Uh);
    try
    {
      Thread.sleep(5000L);
      label20:
      a(localContext, 1, true);
      if (Codlin.Tg.h(39))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        for (;;)
        {
          try
          {
            localObject1 = new String(abstract.i("/proc/self/maps"));
            String[] arrayOfString = ((String)localObject1).split("\n");
            localHashSet = new HashSet();
            int j = arrayOfString.length;
            i = 0;
            if (i < j)
            {
              localObject1 = arrayOfString[i];
              localObject1 = ((String)localObject1).split(" +");
              if (localObject1.length >= 2)
              {
                str = localObject1[(localObject1.length - 1)].trim();
                localObject1 = null;
              }
            }
          }
          catch (Throwable localThrowable1)
          {
            Object localObject1;
            HashSet localHashSet;
            int i;
            String str;
            Object localObject2;
            boolean bool;
            int k;
            continue;
          }
          try
          {
            localObject2 = new File(str);
            if (!((File)localObject2).exists()) {
              continue;
            }
            localObject2 = ((File)localObject2).getName();
            localObject1 = localObject2;
          }
          catch (Throwable localThrowable2)
          {
            continue;
          }
          if (localObject1 != null)
          {
            bool = ((String)localObject1).contains("res");
            if (bool)
            {
              bool = ((String)localObject1).endsWith(".apk");
              if (bool)
              {
                bool = ((String)localObject1).contains("mediatek");
                if ((!bool) && (!TextUtils.equals("/system/framework/framework-res.apk", str)) && (!localHashSet.contains(str)))
                {
                  localHashSet.add(str);
                  localObject1 = void.b(localContext, str);
                  if (localObject1 != null)
                  {
                    bool = TextUtils.equals((CharSequence)localObject1, "android.auto_generated_rro__");
                    if ((!bool) && (!TextUtils.equals((CharSequence)localObject1, "android.overlay")))
                    {
                      k = localStringBuilder.length();
                      if (k > 0) {
                        localStringBuilder.append(":");
                      }
                      localStringBuilder.append((String)localObject1);
                    }
                  }
                }
              }
            }
          }
          i += 1;
        }
        localStringBuilder.append(",");
        localObject1 = Resources.getSystem().getClass().getName();
        if (!TextUtils.equals("android.content.res.Resources", (CharSequence)localObject1)) {
          localStringBuilder.append((String)localObject1);
        }
        localObject1 = localStringBuilder.toString().replace("(\\|)|\\s*|\t|\r|\n", "");
        this.Uh.a(localContext, "405", (String)localObject1, true);
      }
      b(this.Rh.getContext(), false, 0);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label20;
    }
  }
  
  public final int a(Bilberry paramBilberry)
  {
    if (this.Rh.C()) {
      return 2;
    }
    if (paramBilberry.zg == 0)
    {
      if (TextUtils.isEmpty(paramBilberry.Eh)) {
        return 2;
      }
      long l1 = System.currentTimeMillis() / 1000L;
      if (l1 >= paramBilberry.Fh)
      {
        if (this.Rh.A()) {
          return 2;
        }
        return 3;
      }
      long l2 = this.Uh.M(void.get());
      if (Math.abs(l1 - this.Uh.f(void.get(), "108")) >= l2)
      {
        if (this.Rh.A()) {
          return 2;
        }
        return 3;
      }
      return 1;
    }
    return 2;
  }
  
  public final long a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    long l3 = 0L;
    l1 = l3;
    if (paramBoolean) {
      l2 = l3;
    }
    try
    {
      Codlin localCodlin;
      String str;
      Cascara localCascara;
      label79:
      try
      {
        l1 = System.currentTimeMillis();
      }
      finally {}
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
    try
    {
      localCodlin = Codlin.Tg;
      str = this.Rh.o();
      localCascara = this.Uh;
      if (localCodlin.a(paramContext, paramInt, str, localCascara.f(paramContext, "501"), C(paramContext).Eh)) {
        this.Uh.U(paramContext);
      }
    }
    catch (Throwable localThrowable)
    {
      break label79;
    }
    l2 = l3;
    l1 = System.currentTimeMillis() - l1;
    l2 = l1;
    c(paramBoolean);
    l2 = l1;
    Codlin.Tg.da(paramContext);
    return l1;
  }
  
  public final Bilberry a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final Bilberry a(Bilberry paramBilberry, Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    synchronized (this.Vh)
    {
      ??? = C(paramContext);
      if ((??? != paramBilberry) && (a((Bilberry)???) == 1)) {
        return ???;
      }
      synchronized (this.Xh)
      {
        if (!((Boolean)this.Xh.get()).booleanValue())
        {
          this.Xh.set(Boolean.valueOf(true));
          this.Sh.post(new Bryony(this, paramContext, paramBoolean1, paramInt));
        }
        try
        {
          localAtomicReference = this.Xh;
          if (!paramBoolean2) {
            break label173;
          }
          l = this.Rh.getTimeout();
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            AtomicReference localAtomicReference;
            continue;
            long l = 10000L;
          }
        }
        localAtomicReference.wait(l);
        paramContext = C(paramContext);
        if (paramContext != paramBilberry) {
          return paramContext;
        }
        paramBilberry = Bilberry.g(-10004);
        return paramBilberry;
      }
    }
  }
  
  public final Carambola a(Context paramContext, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    paramContext = this.Rh.y();
    if (paramContext == null) {
      paramContext = Carambola.g(-20000);
    }
    try
    {
      System.currentTimeMillis();
      paramContext = (default)paramContext;
      paramContext = paramContext.a(paramInt1, paramArrayOfByte, 0, 0);
      if (paramContext.sd != 0) {
        paramContext = Carambola.g(paramContext.sd - 20000);
      } else {
        paramContext = new Carambola(0, paramContext.data, 0, 0);
      }
    }
    catch (Throwable paramContext)
    {
      label80:
      break label80;
    }
    paramContext = Carambola.g(-20000);
    if (paramContext.zg != 0) {}
    return paramContext;
  }
  
  public final void a(int paramInt, long paramLong)
  {
    synchronized (this.Xh)
    {
      if (((Boolean)this.Xh.get()).booleanValue()) {
        return;
      }
      this.Xh.set(Boolean.valueOf(true));
      Message localMessage = Message.obtain(this.Sh, 2, Integer.valueOf(paramInt));
      this.Sh.sendMessageDelayed(localMessage, paramLong);
      return;
    }
  }
  
  public final void a(Context arg1, boolean paramBoolean, int paramInt)
  {
    boolean bool = this.Uh.J(???);
    int i = 0;
    while (i < this.Rh.u())
    {
      Bilberry localBilberry = a(???, paramBoolean, bool, paramInt);
      a(localBilberry, true);
      if ((localBilberry.zg == 0) || (localBilberry.zg == -30014)) {
        break;
      }
      i += 1;
    }
    if (bool) {
      this.Uh.a(???, false);
    }
    synchronized (this.Xh)
    {
      this.Xh.set(Boolean.valueOf(false));
      this.Xh.notifyAll();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  /* Error */
  public final void a(Bilberry paramBilberry, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 61	com/tencent/turingfd/sdk/xq/Bullace:Wh	Ljava/util/concurrent/atomic/AtomicReference;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_3
    //   12: monitorexit
    //   13: return
    //   14: iload_2
    //   15: ifne +13 -> 28
    //   18: aload_1
    //   19: getfield 292	com/tencent/turingfd/sdk/xq/Bilberry:zg	I
    //   22: ifeq +6 -> 28
    //   25: aload_3
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: getfield 61	com/tencent/turingfd/sdk/xq/Bullace:Wh	Ljava/util/concurrent/atomic/AtomicReference;
    //   32: aload_1
    //   33: invokevirtual 118	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   36: aload_3
    //   37: monitorexit
    //   38: return
    //   39: aload_3
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    //   43: astore_1
    //   44: goto -5 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	Bullace
    //   0	47	1	paramBilberry	Bilberry
    //   0	47	2	paramBoolean	boolean
    //   4	36	3	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   11	13	43	finally
    //   18	27	43	finally
    //   28	38	43	finally
    //   39	41	43	finally
  }
  
  public final Bilberry b(Context paramContext, boolean paramBoolean, int paramInt)
  {
    Bilberry localBilberry = C(paramContext);
    if (this.Rh == null) {
      return Bilberry.g(-10002);
    }
    int i = a(localBilberry);
    if (i == 1) {
      return localBilberry;
    }
    if (i == 2)
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        V();
        return Bilberry.g(-10008);
      }
      paramContext = a(localBilberry, paramContext, false, paramBoolean, paramInt);
      if (paramContext.zg == 0) {
        a(4, 3000L);
      }
      return paramContext;
    }
    if (i == 3) {
      V();
    }
    return localBilberry;
  }
  
  public final Bilberry c(Context paramContext, boolean paramBoolean, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void c(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Bullace
 * JD-Core Version:    0.7.0.1
 */