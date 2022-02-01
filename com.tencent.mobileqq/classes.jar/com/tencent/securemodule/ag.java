package com.tencent.securemodule;

import android.content.Context;
import com.tencent.securemodule.jni.SecureEngine;
import java.util.concurrent.atomic.AtomicReference;

public final class ag
{
  public static ah.a[] a = { new ah.a(0, "info", "getGuid"), new ah.a(1, "info", "getUpdatesV2"), new ah.a(2, "info", "reportTipsRes"), new ah.a(3, "cloudcheck", "tinyCloudCheck"), new ah.a(4, "cloudcheck", "cloudCheck"), new ah.a(5, "report", "reportSoftUsageInfo") };
  private static String b = null;
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
    if (this.h == null)
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
    for (;;)
    {
      return this.h;
      this.h.i(b);
      this.h.a(this.c);
      this.h.c(this.d);
    }
  }
  
  private int f()
  {
    Object localObject = e();
    AtomicReference localAtomicReference = new AtomicReference();
    int j = ah.a(this.e).a((h)localObject, localAtomicReference);
    if (j == 0)
    {
      localObject = (j)localAtomicReference.get();
      if (localObject != null)
      {
        b = ((j)localObject).a();
        if ((b == null) || (b.equals(""))) {
          return -2001;
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
    boolean bool = false;
    if ((!str1.equals(this.c)) || (!str2.equals(this.d)))
    {
      this.c = str1;
      this.d = str2;
      bool = true;
    }
    return bool;
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
    int j;
    if (this.i == null)
    {
      this.i = new p();
      this.i.n(b);
      this.i.a("0000000000000000");
      this.i.b(i.a(at.a(this.e, 30003, 6)).toString());
      this.i.c(at.a(this.e, 30001, "0.0.0"));
      this.i.d(this.c);
      this.i.e(az.a(au.b(this.e)));
      this.i.a(2);
      this.i.h("" + au.c());
      this.i.b(201);
      this.i.i(az.a(au.a()));
      this.i.l(at.a(this.e, 30002, ""));
      p localp = this.i;
      if (as.a(this.e))
      {
        j = 1;
        localp.c(j);
      }
    }
    for (;;)
    {
      return this.i;
      j = 0;
      break;
      this.i.d(this.c);
    }
  }
  
  public v c()
  {
    int j = 2;
    int m = 0;
    int k = 1;
    if (this.g == null)
    {
      this.g = new v();
      this.g.a(this.c);
      this.g.e("0000000000000000");
      this.g.f(at.a(this.e, 30002, ""));
      this.g.g(az.a(au.a()));
      this.g.b(at.a(this.e, 30003, 6));
      localObject = at.a(this.e, 30001, "0.0.0").trim().split("[\\.]");
      if (localObject.length >= 3) {
        this.g.a(new n(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1]), Integer.parseInt(localObject[2])));
      }
      this.g.h(b);
      this.g.i(az.a(au.b(this.e)));
      localObject = this.g;
      if (af.c(this.e) == af.a.a)
      {
        ((v)localObject).a(j);
        localObject = this.g;
        if (!as.a(this.e)) {
          break label316;
        }
        j = 1;
        label229:
        ((v)localObject).c(j);
        localObject = this.g;
        if (!SecureEngine.checkSecureStatus(this.e)) {
          break label321;
        }
      }
      label316:
      label321:
      for (j = k;; j = 0)
      {
        ((v)localObject).d(j);
        this.g.e(au.c());
        this.g.f(at.a(this.e, 30004, 0));
        this.g.b(at.a(this.e, 30006, ""));
        return this.g;
        j = 1;
        break;
        j = 0;
        break label229;
      }
    }
    this.g.h(b);
    this.g.a(this.c);
    Object localObject = this.g;
    k = m;
    if (SecureEngine.checkSecureStatus(this.e)) {
      k = 1;
    }
    ((v)localObject).d(k);
    localObject = this.g;
    if (af.c(this.e) == af.a.a) {}
    for (;;)
    {
      ((v)localObject).a(j);
      this.g.b(at.a(this.e, 30006, ""));
      break;
      j = 1;
    }
  }
  
  public int d()
  {
    if ((b == null) || (b.equals("")) || (g()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.securemodule.ag
 * JD-Core Version:    0.7.0.1
 */