package com.tencent.qapmsdk.impl.appstate;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import com.tencent.qapmsdk.impl.instrumentation.g;
import com.tencent.qapmsdk.impl.instrumentation.l.b;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class b
{
  public static boolean a = false;
  public static volatile long b;
  private static volatile b d;
  public boolean c = false;
  private long e;
  private long f;
  private long g;
  private long h;
  private long i;
  private long j;
  private long k;
  private long l;
  private long m;
  private long n;
  private long o;
  private long p;
  private long q;
  private long r;
  private long s;
  private long t;
  private e u = new e();
  private String v;
  private AsyncSPEditor w = null;
  
  public static b a()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new b();
        }
      }
      finally {}
    }
    return d;
  }
  
  private void j()
  {
    this.f = 0L;
    this.g = 0L;
    this.i = 0L;
    this.j = 0L;
    this.k = 0L;
    this.l = 0L;
    this.m = 0L;
    this.n = 0L;
    this.o = 0L;
    this.p = 0L;
    this.r = 0L;
    this.s = 0L;
    this.t = 0L;
  }
  
  private boolean k()
  {
    long l1 = this.f;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (l1 == 0L)
    {
      bool1 = bool2;
      if (b != 0L)
      {
        bool1 = bool2;
        if (System.currentTimeMillis() - b >= 180000L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void l()
  {
    if (QAPMMonitorThreadLocal.getInstance().f().get() != null) {
      ((Vector)QAPMMonitorThreadLocal.getInstance().f().get()).clear();
    }
    com.tencent.qapmsdk.impl.g.b.c.set(a.d.a());
    this.e = System.currentTimeMillis();
  }
  
  private void m()
  {
    try
    {
      Context localContext = com.tencent.qapmsdk.impl.g.b.b();
      BaseInfo.sharePreference = localContext.getSharedPreferences("QAPM_SP", 0);
      this.w = new AsyncSPEditor(BaseInfo.sharePreference.edit());
      int i1 = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 0).versionCode;
      com.tencent.qapmsdk.impl.g.b.h = i1;
      int i2 = BaseInfo.sharePreference.getInt("appVersion", -1);
      if (i2 == -1)
      {
        com.tencent.qapmsdk.impl.g.b.g = true;
      }
      else
      {
        com.tencent.qapmsdk.impl.g.b.a(BaseInfo.sharePreference.getInt("betaOn", 0));
        com.tencent.qapmsdk.impl.g.b.g = true;
      }
      if ((i2 != -1) && (i2 == i1))
      {
        com.tencent.qapmsdk.impl.g.b.c.set(a.c.a());
        return;
      }
      com.tencent.qapmsdk.impl.g.b.c.set(a.b.a());
      return;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_Impl_AppStateTimeInfo", "initInAttachBaseContextEnv:", localException);
    }
  }
  
  private void n()
  {
    if ((com.tencent.qapmsdk.impl.g.b.c.get() != a.e.a()) && (com.tencent.qapmsdk.impl.g.b.c.get() != a.a.a()) && (com.tencent.qapmsdk.impl.g.b.c.get() != a.f.a()))
    {
      if (u() != -1L)
      {
        com.tencent.qapmsdk.impl.g.b.d.set(true);
        long l1 = o();
        localObject = f.a("QAPM_APPLAUNCH", v(), PluginCombination.startUpPlugin.threshold, l.b.b);
        ((f)localObject).b.a(l1);
        j localj = ((f)localObject).b;
        long l2 = this.t;
        l1 = l2;
        if (l2 == 0L) {
          if (AndroidVersion.isKitKat()) {
            l1 = this.r;
          } else {
            l1 = this.q;
          }
        }
        localj.b(l1);
        if (this.t == 0L)
        {
          if ((com.tencent.qapmsdk.impl.g.b.c.get() == a.b.a()) || (com.tencent.qapmsdk.impl.g.b.c.get() == a.c.a()))
          {
            ((f)localObject).a(new g("QAPM_APPLAUNCH", "LAUNCH_APPLICATION_INIT", this.f, this.g, l.b.b.a()));
            ((f)localObject).a(false);
            ((f)localObject).a(new g("QAPM_APPLAUNCH", "LAUNCH_MAIN_ACTIVITY_INIT", this.g, this.i, l.b.b.a()));
            ((f)localObject).a(false);
          }
          ((f)localObject).a(new g("QAPM_APPLAUNCH", "LAUNCH_ACTIVITY_LOAD", p(), this.q, l.b.b.a()));
          ((f)localObject).a(false);
          ((f)localObject).a(new g("QAPM_APPLAUNCH", "LAUNCH_ACTIVITY_LAYOUT", this.q, this.r, l.b.b.a()));
          ((f)localObject).a(false);
        }
        ((f)localObject).b.a(((f)localObject).a());
      }
      Object localObject = this.w;
      if (localObject != null)
      {
        ((AsyncSPEditor)localObject).putInt("appVersion", com.tencent.qapmsdk.impl.g.b.h);
        this.w.putInt("betaOn", 1);
        this.w.commit();
      }
    }
  }
  
  private long o()
  {
    if (com.tencent.qapmsdk.impl.g.b.c.get() == a.d.a())
    {
      long l2 = this.j;
      long l1 = l2;
      if (l2 == 0L) {
        l1 = this.l;
      }
      return l1;
    }
    if ((com.tencent.qapmsdk.impl.g.b.c.get() != a.b.a()) && (com.tencent.qapmsdk.impl.g.b.c.get() != a.c.a())) {
      return -1L;
    }
    return this.f;
  }
  
  private long p()
  {
    long l1 = this.j;
    if (l1 == 0L) {
      return this.l;
    }
    long l2 = this.i;
    if (l2 == 0L) {
      return l1;
    }
    return l2;
  }
  
  private long q()
  {
    if (com.tencent.qapmsdk.impl.g.b.c.get() == a.d.a()) {
      return -1L;
    }
    return this.i - this.g;
  }
  
  private long r()
  {
    if (com.tencent.qapmsdk.impl.g.b.c.get() == a.d.a()) {
      return -1L;
    }
    return this.g - this.f;
  }
  
  private long s()
  {
    if (this.j == 0L) {
      return this.q - this.m;
    }
    long l2 = this.s;
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = this.q;
    }
    return l1 - this.k;
  }
  
  private long t()
  {
    long l1 = this.j;
    if (l1 != 0L)
    {
      long l2 = this.k;
      if (l2 != 0L)
      {
        if ((this.i == 0L) && (l1 != 0L)) {
          return l2 - l1;
        }
        return this.k - this.i;
      }
    }
    return this.m - this.l;
  }
  
  private long u()
  {
    long l1;
    if (com.tencent.qapmsdk.impl.g.b.c.get() == a.d.a()) {
      l1 = t();
    }
    for (long l2 = s();; l2 = s())
    {
      return l1 + l2;
      if ((com.tencent.qapmsdk.impl.g.b.c.get() != a.b.a()) && (com.tencent.qapmsdk.impl.g.b.c.get() != a.c.a())) {
        return -1L;
      }
      l1 = r() + q() + t();
    }
  }
  
  private String v()
  {
    if (com.tencent.qapmsdk.impl.g.b.c.get() == a.d.a()) {
      return "WARM_LAUNCH";
    }
    if (com.tencent.qapmsdk.impl.g.b.c.get() == a.c.a()) {
      return "COLD_LAUNCH";
    }
    if (com.tencent.qapmsdk.impl.g.b.c.get() == a.b.a()) {
      return "FIRST_TIME_LAUNCH";
    }
    return "";
  }
  
  private void w()
  {
    com.tencent.qapmsdk.impl.instrumentation.QAPMAppInstrumentation.isAppInBackground = false;
    com.tencent.qapmsdk.impl.g.b.c.set(a.a.a());
    d.j();
  }
  
  public void a(Context paramContext)
  {
    a = false;
    com.tencent.qapmsdk.impl.g.b.a(paramContext);
    m();
    if (com.tencent.qapmsdk.impl.g.b.g)
    {
      this.e = System.currentTimeMillis();
      this.f = this.e;
    }
  }
  
  public void a(String paramString)
  {
    if ((!a) && (com.tencent.qapmsdk.impl.g.b.g))
    {
      this.v = paramString;
      if (com.tencent.qapmsdk.impl.g.b.c.get() == a.f.a()) {
        if (k()) {
          l();
        } else {
          com.tencent.qapmsdk.impl.g.b.c.set(a.e.a());
        }
      }
      this.j = System.currentTimeMillis();
    }
  }
  
  public void b()
  {
    if (com.tencent.qapmsdk.impl.g.b.g) {
      this.g = System.currentTimeMillis();
    }
  }
  
  public void b(String paramString)
  {
    if ((!a) && (com.tencent.qapmsdk.impl.g.b.g)) {
      this.n = System.currentTimeMillis();
    }
  }
  
  public void c()
  {
    if (com.tencent.qapmsdk.impl.g.b.g) {
      this.h = System.currentTimeMillis();
    }
  }
  
  public void c(String paramString)
  {
    a = false;
    this.v = paramString;
    com.tencent.qapmsdk.impl.g.b.g = true;
    if ((com.tencent.qapmsdk.impl.g.b.g) && (this.l == 0L))
    {
      if (k()) {
        l();
      } else {
        com.tencent.qapmsdk.impl.g.b.c.set(a.e.a());
      }
      this.l = System.currentTimeMillis();
    }
  }
  
  public void d()
  {
    if (com.tencent.qapmsdk.impl.g.b.g) {
      this.i = System.currentTimeMillis();
    }
  }
  
  public void d(String paramString)
  {
    if ((!a) && (com.tencent.qapmsdk.impl.g.b.g))
    {
      this.v = paramString;
      this.p = System.currentTimeMillis();
    }
  }
  
  public void e()
  {
    if ((!a) && (com.tencent.qapmsdk.impl.g.b.g)) {
      this.k = System.currentTimeMillis();
    }
  }
  
  public void f()
  {
    if ((!a) && (com.tencent.qapmsdk.impl.g.b.g) && (this.o == 0L)) {
      this.o = System.currentTimeMillis();
    }
  }
  
  public void g()
  {
    if ((com.tencent.qapmsdk.impl.g.b.g) && (this.m == 0L)) {
      this.m = System.currentTimeMillis();
    }
  }
  
  /* Error */
  public void h()
  {
    // Byte code:
    //   0: getstatic 191	com/tencent/qapmsdk/impl/g/b:g	Z
    //   3: ifeq +79 -> 82
    //   6: getstatic 336	com/tencent/qapmsdk/impl/appstate/b:a	Z
    //   9: ifne +73 -> 82
    //   12: aload_0
    //   13: invokestatic 88	java/lang/System:currentTimeMillis	()J
    //   16: putfield 275	com/tencent/qapmsdk/impl/appstate/b:q	J
    //   19: invokestatic 273	com/tencent/qapmsdk/common/util/AndroidVersion:isKitKat	()Z
    //   22: ifne +11 -> 33
    //   25: iconst_1
    //   26: putstatic 336	com/tencent/qapmsdk/impl/appstate/b:a	Z
    //   29: aload_0
    //   30: invokespecial 351	com/tencent/qapmsdk/impl/appstate/b:n	()V
    //   33: invokestatic 273	com/tencent/qapmsdk/common/util/AndroidVersion:isKitKat	()Z
    //   36: ifne +46 -> 82
    //   39: aload_0
    //   40: invokespecial 353	com/tencent/qapmsdk/impl/appstate/b:w	()V
    //   43: return
    //   44: astore_1
    //   45: goto +25 -> 70
    //   48: astore_1
    //   49: getstatic 205	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   52: ldc 207
    //   54: ldc_w 355
    //   57: aload_1
    //   58: invokevirtual 213	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   61: invokestatic 273	com/tencent/qapmsdk/common/util/AndroidVersion:isKitKat	()Z
    //   64: ifne +18 -> 82
    //   67: goto -28 -> 39
    //   70: invokestatic 273	com/tencent/qapmsdk/common/util/AndroidVersion:isKitKat	()Z
    //   73: ifne +7 -> 80
    //   76: aload_0
    //   77: invokespecial 353	com/tencent/qapmsdk/impl/appstate/b:w	()V
    //   80: aload_1
    //   81: athrow
    //   82: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	b
    //   44	1	1	localObject	Object
    //   48	33	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   12	33	44	finally
    //   49	61	44	finally
    //   12	33	48	java/lang/Exception
  }
  
  public void i()
  {
    if ((com.tencent.qapmsdk.impl.g.b.g) && (!a))
    {
      this.r = System.currentTimeMillis();
      if (AndroidVersion.isKitKat())
      {
        a = true;
        n();
        w();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.b
 * JD-Core Version:    0.7.0.1
 */