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
  public static volatile long b = 0L;
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
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new b();
      }
      return d;
    }
    finally {}
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.f == 0L)
    {
      bool1 = bool2;
      if (b != 0L)
      {
        bool1 = bool2;
        if (System.currentTimeMillis() - b >= 180L * 1000L) {
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
      if (i2 == -1) {}
      for (com.tencent.qapmsdk.impl.g.b.g = true; (i2 != -1) && (i2 == i1); com.tencent.qapmsdk.impl.g.b.g = true)
      {
        com.tencent.qapmsdk.impl.g.b.c.set(a.c.a());
        return;
        com.tencent.qapmsdk.impl.g.b.a(BaseInfo.sharePreference.getInt("betaOn", 0));
      }
      com.tencent.qapmsdk.impl.g.b.c.set(a.b.a());
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_Impl_AppStateTimeInfo", "initInAttachBaseContextEnv:", localException);
      return;
    }
  }
  
  private void n()
  {
    long l1;
    f localf;
    j localj;
    if ((com.tencent.qapmsdk.impl.g.b.c.get() != a.e.a()) && (com.tencent.qapmsdk.impl.g.b.c.get() != a.a.a()) && (com.tencent.qapmsdk.impl.g.b.c.get() != a.f.a())) {
      if (u() != -1L)
      {
        com.tencent.qapmsdk.impl.g.b.d.set(true);
        l1 = o();
        localf = f.a("QAPM_APPLAUNCH", v(), PluginCombination.startUpPlugin.threshold, l.b.b);
        localf.b.a(l1);
        localj = localf.b;
        if (this.t != 0L) {
          break label366;
        }
        if (!AndroidVersion.isKitKat()) {
          break label358;
        }
        l1 = this.r;
      }
    }
    for (;;)
    {
      localj.b(l1);
      if (this.t == 0L)
      {
        if ((com.tencent.qapmsdk.impl.g.b.c.get() == a.b.a()) || (com.tencent.qapmsdk.impl.g.b.c.get() == a.c.a()))
        {
          localf.a(new g("QAPM_APPLAUNCH", "LAUNCH_APPLICATION_INIT", this.f, this.g, l.b.b.a()));
          localf.a(false);
          localf.a(new g("QAPM_APPLAUNCH", "LAUNCH_MAIN_ACTIVITY_INIT", this.g, this.i, l.b.b.a()));
          localf.a(false);
        }
        localf.a(new g("QAPM_APPLAUNCH", "LAUNCH_ACTIVITY_LOAD", p(), this.q, l.b.b.a()));
        localf.a(false);
        localf.a(new g("QAPM_APPLAUNCH", "LAUNCH_ACTIVITY_LAYOUT", this.q, this.r, l.b.b.a()));
        localf.a(false);
      }
      localf.b.a(localf.a());
      if (this.w != null)
      {
        this.w.putInt("appVersion", com.tencent.qapmsdk.impl.g.b.h);
        this.w.putInt("betaOn", 1);
        this.w.commit();
      }
      return;
      label358:
      l1 = this.q;
      continue;
      label366:
      l1 = this.t;
    }
  }
  
  private long o()
  {
    if (com.tencent.qapmsdk.impl.g.b.c.get() == a.d.a())
    {
      if (this.j == 0L) {
        return this.l;
      }
      return this.j;
    }
    if ((com.tencent.qapmsdk.impl.g.b.c.get() == a.b.a()) || (com.tencent.qapmsdk.impl.g.b.c.get() == a.c.a())) {
      return this.f;
    }
    return -1L;
  }
  
  private long p()
  {
    if (this.j == 0L) {
      return this.l;
    }
    if (this.i == 0L) {
      return this.j;
    }
    return this.i;
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
    if (this.s <= 0L) {
      return this.q - this.k;
    }
    return this.s - this.k;
  }
  
  private long t()
  {
    if ((this.j != 0L) && (this.k != 0L))
    {
      if ((this.i == 0L) && (this.j != 0L)) {
        return this.k - this.j;
      }
      return this.k - this.i;
    }
    return this.m - this.l;
  }
  
  private long u()
  {
    if (com.tencent.qapmsdk.impl.g.b.c.get() == a.d.a()) {
      return t() + s();
    }
    if ((com.tencent.qapmsdk.impl.g.b.c.get() == a.b.a()) || (com.tencent.qapmsdk.impl.g.b.c.get() == a.c.a())) {
      return r() + q() + t() + s();
    }
    return -1L;
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
      if (com.tencent.qapmsdk.impl.g.b.c.get() == a.f.a())
      {
        if (!k()) {
          break label51;
        }
        l();
      }
    }
    for (;;)
    {
      this.j = System.currentTimeMillis();
      return;
      label51:
      com.tencent.qapmsdk.impl.g.b.c.set(a.e.a());
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
      if (!k()) {
        break label47;
      }
      l();
    }
    for (;;)
    {
      this.l = System.currentTimeMillis();
      return;
      label47:
      com.tencent.qapmsdk.impl.g.b.c.set(a.e.a());
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
  
  public void h()
  {
    if ((com.tencent.qapmsdk.impl.g.b.g) && (!a)) {}
    try
    {
      this.q = System.currentTimeMillis();
      if (!AndroidVersion.isKitKat())
      {
        a = true;
        n();
      }
      return;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_Impl_AppStateTimeInfo", "error:", localException);
      return;
    }
    finally
    {
      if (!AndroidVersion.isKitKat()) {
        w();
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.b
 * JD-Core Version:    0.7.0.1
 */