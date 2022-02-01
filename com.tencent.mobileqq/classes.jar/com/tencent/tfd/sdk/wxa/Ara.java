package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import java.io.File;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class Ara
{
  public static Ara ad = new Ara();
  public static long bd = TimeUnit.MINUTES.toMillis(30L);
  public static int[] cd = { 0, 15, 30, 90, 240, 360, 600, 1200, 2400, 3200, 4800, 7200 };
  public static String dd = null;
  public break ed;
  public Handler gd;
  public boolean hd = false;
  public Canesatici jd;
  public final Object kd = new Object();
  public final AtomicReference<instanceof> ld = new AtomicReference(null);
  public final AtomicReference<Boolean> md = new AtomicReference(Boolean.valueOf(false));
  
  public static int J()
  {
    return 1;
  }
  
  public final void H()
  {
    synchronized (this.md)
    {
      if (((Boolean)this.md.get()).booleanValue()) {
        return;
      }
      this.md.set(Boolean.valueOf(true));
      this.gd.sendEmptyMessage(2);
      return;
    }
  }
  
  public final void I()
  {
    Context localContext = void.get();
    Draco.d(localContext, this.jd);
    try
    {
      Thread.sleep(5000L);
      label20:
      a(localContext, 1, true);
      if (Centaurus.ad.h(volatile.qe.value))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        for (;;)
        {
          try
          {
            localObject1 = new String(package.f("/proc/self/maps"));
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
                  localObject1 = void.a(localContext, str);
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
        this.jd.a(localContext, "405", (String)localObject1, true);
      }
      b(this.ed.getContext(), false, 0);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label20;
    }
  }
  
  public final int a(instanceof paraminstanceof)
  {
    if (this.ed.A()) {
      return 2;
    }
    if (paraminstanceof.Oc == 0)
    {
      if (TextUtils.isEmpty(paraminstanceof.Mc)) {
        return 2;
      }
      long l1 = System.currentTimeMillis() / 1000L;
      if (l1 >= paraminstanceof.Nc)
      {
        if (this.ed.y()) {
          return 2;
        }
        return 3;
      }
      long l2 = this.jd.A(void.get());
      if (Math.abs(l1 - this.jd.c(void.get(), "108")) >= l2)
      {
        if (this.ed.y()) {
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
      Centaurus localCentaurus;
      String str;
      Canesatici localCanesatici;
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
      localCentaurus = Centaurus.ad;
      str = this.ed.n();
      localCanesatici = this.jd;
      if (localCentaurus.a(paramContext, paramInt, str, localCanesatici.c(paramContext, "501"), t(paramContext).Mc)) {
        this.jd.G(paramContext);
      }
    }
    catch (Throwable localThrowable)
    {
      break label79;
    }
    l2 = l3;
    l1 = System.currentTimeMillis() - l1;
    l2 = l1;
    b(paramBoolean);
    l2 = l1;
    Centaurus.ad.P(paramContext);
    return l1;
  }
  
  public final Bootes a(Context paramContext, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramContext = this.ed.w();
    if (paramContext == null) {
      paramContext = Bootes.g(-20000);
    }
    try
    {
      System.currentTimeMillis();
      paramContext = (boolean)paramContext;
      paramContext = paramContext.a(1, paramArrayOfByte, 0, 0);
      if (paramContext.aa != 0) {
        paramContext = Bootes.g(paramContext.aa - 20000);
      } else {
        paramContext = new Bootes(0, paramContext.data, 0, 0);
      }
    }
    catch (Throwable paramContext)
    {
      label80:
      break label80;
    }
    paramContext = Bootes.g(-20000);
    if (paramContext.Oc != 0) {}
    return paramContext;
  }
  
  public instanceof a(Context paramContext, boolean paramBoolean)
  {
    return b(paramContext, paramBoolean, 1);
  }
  
  public final instanceof a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final instanceof a(Context paramContext, byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      Object localObject6 = TNative.aa.b(void.k(), paramArrayOfByte, paramInt);
      paramInt = void.b((SparseArray)localObject6);
      if (paramInt != 0) {
        return instanceof.g(paramInt);
      }
      Object localObject2 = (Integer)void.a((SparseArray)localObject6, 102, Integer.class);
      if (localObject2 == null) {
        return instanceof.g(-30000);
      }
      if (((Integer)localObject2).intValue() < 0) {
        return instanceof.g(((Integer)localObject2).intValue() - 30000);
      }
      Object localObject1 = (String)void.a((SparseArray)localObject6, 101, String.class);
      paramArrayOfByte = (byte[])localObject1;
      if (localObject1 == null) {
        paramArrayOfByte = "";
      }
      if (TextUtils.isEmpty(paramArrayOfByte)) {
        return instanceof.g(((Integer)localObject2).intValue() - 10010);
      }
      localObject2 = (String)void.a((SparseArray)localObject6, 104, String.class);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      Object localObject3 = (String)void.a((SparseArray)localObject6, 105, String.class);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      Object localObject4 = (String)void.a((SparseArray)localObject6, 106, String.class);
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = "";
      }
      Object localObject7 = (Integer)void.a((SparseArray)localObject6, 107, Integer.class);
      Object localObject5 = (String)void.a((SparseArray)localObject6, 108, String.class);
      localObject4 = localObject5;
      if (localObject5 == null) {
        localObject4 = "";
      }
      localObject6 = (String)void.a((SparseArray)localObject6, 150, String.class);
      localObject5 = localObject6;
      if (localObject6 == null) {
        localObject5 = "";
      }
      if (localObject7 != null)
      {
        localObject6 = localObject7;
        if (((Integer)localObject7).intValue() >= 3600) {}
      }
      else
      {
        localObject6 = Integer.valueOf(3600);
      }
      long l1 = System.currentTimeMillis() / 1000L;
      long l2 = ((Integer)localObject6).intValue();
      localObject7 = instanceof.create(0);
      ((instanceof.do)localObject7).Nc = (l1 + l2);
      ((instanceof.do)localObject7).Mc = paramArrayOfByte;
      ((instanceof.do)localObject7).Qc = ((String)localObject1);
      ((instanceof.do)localObject7).Rc = ((String)localObject2);
      ((instanceof.do)localObject7).Sc = ((String)localObject3);
      ((instanceof.do)localObject7).Tc = ((String)localObject4);
      ((instanceof.do)localObject7).Uc = new CanisMinor((String)localObject5);
      paramArrayOfByte = ((instanceof.do)localObject7).build();
      this.jd.a(paramContext, paramArrayOfByte);
      this.jd.a(paramContext, ((Integer)localObject6).intValue());
      return paramArrayOfByte;
    }
    catch (Throwable paramContext)
    {
      label415:
      break label415;
    }
    return instanceof.g(-10007);
  }
  
  public final instanceof a(instanceof paraminstanceof, Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    synchronized (this.kd)
    {
      ??? = t(paramContext);
      if ((??? != paraminstanceof) && (a((instanceof)???) == 1)) {
        return ???;
      }
      synchronized (this.md)
      {
        if (!((Boolean)this.md.get()).booleanValue())
        {
          this.md.set(Boolean.valueOf(true));
          this.gd.post(new Aquila(this, paramContext, paramBoolean1, paramInt));
        }
        try
        {
          localAtomicReference = this.md;
          if (!paramBoolean2) {
            break label173;
          }
          l = this.ed.getTimeout();
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
        paramContext = t(paramContext);
        if (paramContext != paraminstanceof) {
          return paramContext;
        }
        paraminstanceof = instanceof.g(-10004);
        return paraminstanceof;
      }
    }
  }
  
  public final void a(Context arg1, boolean paramBoolean, int paramInt)
  {
    boolean bool = this.jd.y(???);
    int i = 0;
    while (i < this.ed.s())
    {
      instanceof localinstanceof = a(???, paramBoolean, bool, paramInt);
      a(localinstanceof, true);
      int j = localinstanceof.Oc;
      if ((j == 0) || (j == -30014)) {
        break;
      }
      i += 1;
    }
    if (bool) {
      this.jd.c(???, false);
    }
    synchronized (this.md)
    {
      this.md.set(Boolean.valueOf(false));
      this.md.notifyAll();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  /* Error */
  public final void a(instanceof paraminstanceof, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/tencent/tfd/sdk/wxa/Ara:ld	Ljava/util/concurrent/atomic/AtomicReference;
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
    //   19: getfield 303	com/tencent/tfd/sdk/wxa/instanceof:Oc	I
    //   22: ifeq +6 -> 28
    //   25: aload_3
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: getfield 65	com/tencent/tfd/sdk/wxa/Ara:ld	Ljava/util/concurrent/atomic/AtomicReference;
    //   32: aload_1
    //   33: invokevirtual 113	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
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
    //   0	47	0	this	Ara
    //   0	47	1	paraminstanceof	instanceof
    //   0	47	2	paramBoolean	boolean
    //   4	36	3	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   11	13	43	finally
    //   18	27	43	finally
    //   28	38	43	finally
    //   39	41	43	finally
  }
  
  public final instanceof b(Context paramContext, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final instanceof b(Context paramContext, boolean paramBoolean, int paramInt)
  {
    instanceof localinstanceof = t(paramContext);
    if (this.ed == null) {
      return instanceof.g(-10002);
    }
    int i = a(localinstanceof);
    if (i == 1) {
      return localinstanceof;
    }
    if (i == 2)
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        H();
        return instanceof.g(-10008);
      }
      return a(localinstanceof, paramContext, false, paramBoolean, paramInt);
    }
    if (i == 3) {
      H();
    }
    return localinstanceof;
  }
  
  public final void b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final instanceof t(Context paramContext)
  {
    synchronized (this.ld)
    {
      instanceof localinstanceof = (instanceof)this.ld.get();
      Object localObject = localinstanceof;
      if (localinstanceof == null)
      {
        if (this.jd != null) {
          paramContext = this.jd.E(paramContext);
        } else {
          paramContext = instanceof.g(1);
        }
        this.ld.set(paramContext);
        localObject = paramContext;
      }
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.Ara
 * JD-Core Version:    0.7.0.1
 */