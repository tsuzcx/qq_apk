package com.tencent.turingfd.sdk.ams.ga;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class Ara
{
  public static Ara rd = new Ara();
  public static long sd = TimeUnit.MINUTES.toMillis(30L);
  public static int[] td = { 0, 15, 30, 90, 240, 360, 600, 1200, 2400, 3200, 4800, 7200 };
  public final AtomicReference<Boolean> Ad = new AtomicReference(Boolean.valueOf(false));
  public long ud;
  public Handler vd;
  public boolean wd = false;
  public Canesatici xd;
  public final Object yd = new Object();
  public final AtomicReference<implements> zd = new AtomicReference(null);
  
  public static int L()
  {
    return 1;
  }
  
  public final void J()
  {
    a(3, 0L);
  }
  
  public final void K()
  {
    Context localContext = goto.get();
    Draco.d(localContext, this.xd);
    try
    {
      Thread.sleep(5000L);
      label20:
      a(localContext, 1, true);
      if (Centaurus.rd.h(39))
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
                  localObject1 = goto.a(localContext, str);
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
        this.xd.a(localContext, "405", (String)localObject1, true);
      }
      Phoenix.e(localContext, this.xd);
      if (!this.ud.B()) {
        return;
      }
      b(this.ud.getContext(), false, 0);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label20;
    }
  }
  
  public final int a(implements paramimplements)
  {
    if (this.ud.C()) {
      return 2;
    }
    if (paramimplements.cd == 0)
    {
      if (TextUtils.isEmpty(paramimplements.ad)) {
        return 2;
      }
      long l1 = System.currentTimeMillis() / 1000L;
      if (l1 >= paramimplements.bd)
      {
        if (this.ud.A()) {
          return 2;
        }
        return 3;
      }
      long l2 = this.xd.C(goto.get());
      if (Math.abs(l1 - this.xd.c(goto.get(), "108")) >= l2)
      {
        if (this.ud.A()) {
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
      localCentaurus = Centaurus.rd;
      str = this.ud.o();
      localCanesatici = this.xd;
      if (localCentaurus.a(paramContext, paramInt, str, localCanesatici.c(paramContext, "501"), t(paramContext).ad)) {
        this.xd.L(paramContext);
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
    Centaurus.rd.U(paramContext);
    return l1;
  }
  
  public final Bootes a(Context paramContext, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    paramContext = this.ud.y();
    if (paramContext == null) {
      paramContext = Bootes.g(-20000);
    }
    try
    {
      System.currentTimeMillis();
      paramContext = (boolean)paramContext;
      paramContext = paramContext.a(paramInt1, paramArrayOfByte, 0, 0);
      if (paramContext.G != 0) {
        paramContext = Bootes.g(paramContext.G - 20000);
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
    if (paramContext.cd != 0) {}
    return paramContext;
  }
  
  public implements a(Context paramContext, boolean paramBoolean)
  {
    return b(paramContext, paramBoolean, 1);
  }
  
  public final implements a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final implements a(Context paramContext, byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      Object localObject6 = TNative.aa.b(goto.l(), paramArrayOfByte, paramInt);
      paramInt = goto.b((SparseArray)localObject6);
      if (paramInt != 0) {
        return implements.g(paramInt);
      }
      Object localObject2 = (Integer)goto.a((SparseArray)localObject6, 102, Integer.class);
      if (localObject2 == null) {
        return implements.g(-30000);
      }
      if (((Integer)localObject2).intValue() < 0) {
        return implements.g(((Integer)localObject2).intValue() - 30000);
      }
      Object localObject1 = (String)goto.a((SparseArray)localObject6, 101, String.class);
      paramArrayOfByte = (byte[])localObject1;
      if (localObject1 == null) {
        paramArrayOfByte = "";
      }
      if (TextUtils.isEmpty(paramArrayOfByte)) {
        return implements.g(((Integer)localObject2).intValue() - 10010);
      }
      localObject2 = (String)goto.a((SparseArray)localObject6, 104, String.class);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      Object localObject3 = (String)goto.a((SparseArray)localObject6, 105, String.class);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      Object localObject4 = (String)goto.a((SparseArray)localObject6, 106, String.class);
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = "";
      }
      Object localObject7 = (Integer)goto.a((SparseArray)localObject6, 107, Integer.class);
      Object localObject5 = (String)goto.a((SparseArray)localObject6, 108, String.class);
      localObject4 = localObject5;
      if (localObject5 == null) {
        localObject4 = "";
      }
      localObject6 = (String)goto.a((SparseArray)localObject6, 150, String.class);
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
      localObject7 = implements.create(0);
      ((implements.do)localObject7).bd = (l1 + l2);
      ((implements.do)localObject7).ad = paramArrayOfByte;
      ((implements.do)localObject7).ed = ((String)localObject1);
      ((implements.do)localObject7).gd = ((String)localObject2);
      ((implements.do)localObject7).hd = ((String)localObject3);
      ((implements.do)localObject7).jd = ((String)localObject4);
      ((implements.do)localObject7).kd = new CanisMinor((String)localObject5);
      paramArrayOfByte = ((implements.do)localObject7).build();
      this.xd.a(paramContext, paramArrayOfByte);
      this.xd.a(paramContext, ((Integer)localObject6).intValue());
      return paramArrayOfByte;
    }
    catch (Throwable paramContext)
    {
      label409:
      break label409;
    }
    return implements.g(-10007);
  }
  
  public final implements a(implements paramimplements, Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    synchronized (this.yd)
    {
      ??? = t(paramContext);
      if ((??? != paramimplements) && (a((implements)???) == 1)) {
        return ???;
      }
      synchronized (this.Ad)
      {
        if (!((Boolean)this.Ad.get()).booleanValue())
        {
          this.Ad.set(Boolean.valueOf(true));
          this.vd.post(new Andromeda(this, paramContext, paramBoolean1, paramInt));
        }
        try
        {
          localAtomicReference = this.Ad;
          if (!paramBoolean2) {
            break label173;
          }
          l = this.ud.getTimeout();
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
        if (paramContext != paramimplements) {
          return paramContext;
        }
        paramimplements = implements.g(-10004);
        return paramimplements;
      }
    }
  }
  
  public final void a(int paramInt, long paramLong)
  {
    synchronized (this.Ad)
    {
      if (((Boolean)this.Ad.get()).booleanValue()) {
        return;
      }
      this.Ad.set(Boolean.valueOf(true));
      Message localMessage = Message.obtain(this.vd, 2, Integer.valueOf(paramInt));
      this.vd.sendMessageDelayed(localMessage, paramLong);
      return;
    }
  }
  
  public final void a(Context arg1, boolean paramBoolean, int paramInt)
  {
    boolean bool = this.xd.z(???);
    int i = 0;
    while (i < this.ud.u())
    {
      implements localimplements = a(???, paramBoolean, bool, paramInt);
      a(localimplements, true);
      int j = localimplements.cd;
      if ((j == 0) || (j == -30014)) {
        break;
      }
      i += 1;
    }
    if (bool) {
      this.xd.b(???, false);
    }
    synchronized (this.Ad)
    {
      this.Ad.set(Boolean.valueOf(false));
      this.Ad.notifyAll();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public final void a(ITuringDeviceInfoProvider paramITuringDeviceInfoProvider, HashMap<String, String> paramHashMap)
  {
    Object localObject = new Object();
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    new Aquila(this, localAtomicBoolean, paramHashMap, paramITuringDeviceInfoProvider, System.currentTimeMillis(), localObject).start();
    try
    {
      try
      {
        localObject.wait(1000L);
      }
      finally
      {
        break label62;
      }
    }
    catch (InterruptedException paramITuringDeviceInfoProvider)
    {
      label53:
      label62:
      break label53;
    }
    localAtomicBoolean.set(true);
    return;
    throw paramITuringDeviceInfoProvider;
  }
  
  /* Error */
  public final void a(implements paramimplements, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 61	com/tencent/turingfd/sdk/ams/ga/Ara:zd	Ljava/util/concurrent/atomic/AtomicReference;
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
    //   19: getfield 287	com/tencent/turingfd/sdk/ams/ga/implements:cd	I
    //   22: ifeq +6 -> 28
    //   25: aload_3
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: getfield 61	com/tencent/turingfd/sdk/ams/ga/Ara:zd	Ljava/util/concurrent/atomic/AtomicReference;
    //   32: aload_1
    //   33: invokevirtual 455	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
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
    //   0	47	1	paramimplements	implements
    //   0	47	2	paramBoolean	boolean
    //   4	36	3	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   11	13	43	finally
    //   18	27	43	finally
    //   28	38	43	finally
    //   39	41	43	finally
  }
  
  public final implements b(Context paramContext, boolean paramBoolean, int paramInt)
  {
    implements localimplements = t(paramContext);
    if (this.ud == null) {
      return implements.g(-10002);
    }
    int i = a(localimplements);
    if (i == 1) {
      return localimplements;
    }
    if (i == 2)
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        J();
        return implements.g(-10008);
      }
      paramContext = a(localimplements, paramContext, false, paramBoolean, paramInt);
      if (paramContext.cd == 0) {
        a(4, 3000L);
      }
      return paramContext;
    }
    if (i == 3) {
      J();
    }
    return localimplements;
  }
  
  public final void b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final implements c(Context paramContext, boolean paramBoolean, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final implements t(Context paramContext)
  {
    synchronized (this.zd)
    {
      implements localimplements = (implements)this.zd.get();
      Object localObject = localimplements;
      if (localimplements == null)
      {
        if (this.xd != null) {
          paramContext = this.xd.I(paramContext);
        } else {
          paramContext = implements.g(1);
        }
        this.zd.set(paramContext);
        localObject = paramContext;
      }
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Ara
 * JD-Core Version:    0.7.0.1
 */