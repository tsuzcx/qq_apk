package com.tencent.securemodule;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

public final class ag
{
  public static ah.a[] a = { new ah.a(0, "info", "getGuid"), new ah.a(1, "info", "getUpdatesV2"), new ah.a(2, "info", "reportTipsRes"), new ah.a(3, "cloudcheck", "tinyCloudCheck"), new ah.a(4, "cloudcheck", "cloudCheck"), new ah.a(5, "report", "reportSoftUsageInfo") };
  private static String b;
  private String c = null;
  private String d = null;
  private Context e;
  private l f;
  private v g;
  private h h;
  private p i;
  
  public ag(Context paramContext)
  {
    this.e = paramContext;
    b = at.a(this.e, 20001, null);
    this.c = az.a(au.a(this.e));
    this.d = az.a(au.c(this.e));
  }
  
  public static String a(int paramInt)
  {
    return a[paramInt].b;
  }
  
  public static String b(int paramInt)
  {
    return a[paramInt].c;
  }
  
  private h e()
  {
    h localh = this.h;
    if (localh == null)
    {
      this.h = new h();
      this.h.a(this.c);
      this.h.b(az.a(au.b(this.e)));
      this.h.c(this.d);
      this.h.d(az.a(au.d(this.e)));
      this.h.e(az.a(au.d()));
      this.h.a(au.c());
      this.h.f(az.a(au.a()));
      this.h.g(az.a(au.b()));
      this.h.h(az.a(av.a(this.e)));
      this.h.i(b);
    }
    else
    {
      localh.i(b);
      this.h.a(this.c);
      this.h.c(this.d);
    }
    return this.h;
  }
  
  private int f()
  {
    Object localObject = e();
    AtomicReference localAtomicReference = new AtomicReference();
    int k = ah.a(this.e).a((h)localObject, localAtomicReference);
    int j = k;
    if (k == 0)
    {
      localObject = (j)localAtomicReference.get();
      j = k;
      if (localObject != null)
      {
        b = ((j)localObject).a();
        localObject = b;
        if (localObject != null)
        {
          j = k;
          if (!((String)localObject).equals("")) {}
        }
        else
        {
          j = -2001;
        }
      }
    }
    return j;
  }
  
  private boolean g()
  {
    String str1 = az.a(au.a(this.e));
    String str2 = az.a(au.c(this.e));
    this.c = at.a(this.e, 20002, str1);
    this.d = at.a(this.e, 20003, str2);
    if ((str1.equals(this.c)) && (str2.equals(this.d))) {
      return false;
    }
    this.c = str1;
    this.d = str2;
    return true;
  }
  
  public l a()
  {
    if (this.f == null)
    {
      this.f = new l();
      this.f.a(2);
      this.f.b(at.a(this.e, 30005, 201));
    }
    return this.f;
  }
  
  public p b()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public v c()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public int d()
  {
    String str = b;
    if ((str == null) || (str.equals("")) || (g()))
    {
      int j = f();
      if (j != 0) {
        return j;
      }
      at.b(this.e, 20002, this.c);
      at.b(this.e, 20003, this.d);
      at.b(this.e, 20001, b);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securemodule.ag
 * JD-Core Version:    0.7.0.1
 */