package com.tencent.qapmsdk.impl.appstate;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import com.tencent.qapmsdk.impl.instrumentation.f;
import com.tencent.qapmsdk.impl.instrumentation.k.b;
import java.util.Vector;
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
  private d s = new d();
  private String t;
  private AsyncSPEditor u = null;
  
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
  
  private void i()
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
  }
  
  private boolean j()
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
  
  private void k()
  {
    if (QAPMMonitorThreadLocal.getInstance().f().get() != null) {
      ((Vector)QAPMMonitorThreadLocal.getInstance().f().get()).clear();
    }
    com.tencent.qapmsdk.impl.g.b.b.set(a.d.a());
    this.e = System.currentTimeMillis();
  }
  
  private void l()
  {
    try
    {
      Context localContext = com.tencent.qapmsdk.impl.g.b.b();
      BaseInfo.sharePreference = localContext.getSharedPreferences("QAPM_SP", 0);
      this.u = new AsyncSPEditor(BaseInfo.sharePreference.edit());
      int i1 = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 0).versionCode;
      com.tencent.qapmsdk.impl.g.b.d = i1;
      int i2 = BaseInfo.sharePreference.getInt("appVersion", -1);
      if (i2 == -1) {}
      for (com.tencent.qapmsdk.impl.g.b.c = true; (i2 != -1) && (i2 == i1); com.tencent.qapmsdk.impl.g.b.c = true)
      {
        com.tencent.qapmsdk.impl.g.b.b.set(a.c.a());
        return;
        com.tencent.qapmsdk.impl.g.b.a(BaseInfo.sharePreference.getInt("betaOn", 0));
      }
      com.tencent.qapmsdk.impl.g.b.b.set(a.b.a());
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_Impl_AppStateTimeInfo", "initInAttachBaseContextEnv:", localException);
      return;
    }
  }
  
  private void m()
  {
    if ((com.tencent.qapmsdk.impl.g.b.b.get() != a.e.a()) && (com.tencent.qapmsdk.impl.g.b.b.get() != a.a.a()) && (com.tencent.qapmsdk.impl.g.b.b.get() != a.f.a()))
    {
      if (t() != -1L)
      {
        long l1 = n();
        e locale = e.a("QAPM_APPLAUNCH", u(), PluginCombination.resourcePlugin.threshold, k.b.b);
        locale.b.a(l1);
        locale.b.b(this.q);
        if ((com.tencent.qapmsdk.impl.g.b.b.get() == a.b.a()) || (com.tencent.qapmsdk.impl.g.b.b.get() == a.c.a()))
        {
          locale.a(new f("QAPM_APPLAUNCH", "LAUNCH_APPLICATION_INIT", this.f, this.g, k.b.b.a()));
          locale.a(false);
          locale.a(new f("QAPM_APPLAUNCH", "LAUNCH_MAIN_ACTIVITY_INIT", this.g, this.i, k.b.b.a()));
          locale.a(false);
        }
        locale.a(new f("QAPM_APPLAUNCH", "LAUNCH_ACTIVITY_LOAD", o(), this.q, k.b.b.a()));
        locale.a(false);
        locale.b.a(locale.a());
      }
      if (this.u != null)
      {
        this.u.putInt("appVersion", com.tencent.qapmsdk.impl.g.b.d);
        this.u.putInt("betaOn", 1);
        this.u.commit();
      }
    }
  }
  
  private long n()
  {
    if (com.tencent.qapmsdk.impl.g.b.b.get() == a.d.a())
    {
      if (this.j == 0L) {
        return this.l;
      }
      return this.j;
    }
    if ((com.tencent.qapmsdk.impl.g.b.b.get() == a.b.a()) || (com.tencent.qapmsdk.impl.g.b.b.get() == a.c.a())) {
      return this.f;
    }
    return -1L;
  }
  
  private long o()
  {
    if (this.j == 0L) {
      return this.l;
    }
    if (this.i == 0L) {
      return this.j;
    }
    return this.i;
  }
  
  private long p()
  {
    if (com.tencent.qapmsdk.impl.g.b.b.get() == a.d.a()) {
      return -1L;
    }
    return this.i - this.g;
  }
  
  private long q()
  {
    if (com.tencent.qapmsdk.impl.g.b.b.get() == a.d.a()) {
      return -1L;
    }
    return this.g - this.f;
  }
  
  private long r()
  {
    if (this.j == 0L) {
      return this.q - this.m;
    }
    if (this.r <= 0L) {
      return this.q - this.k;
    }
    return this.r - this.k;
  }
  
  private long s()
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
  
  private long t()
  {
    if (com.tencent.qapmsdk.impl.g.b.b.get() == a.d.a()) {
      return s() + r();
    }
    if ((com.tencent.qapmsdk.impl.g.b.b.get() == a.b.a()) || (com.tencent.qapmsdk.impl.g.b.b.get() == a.c.a())) {
      return q() + p() + s() + r();
    }
    return -1L;
  }
  
  private String u()
  {
    if (com.tencent.qapmsdk.impl.g.b.b.get() == a.d.a()) {
      return "WARM_LAUNCH";
    }
    if (com.tencent.qapmsdk.impl.g.b.b.get() == a.c.a()) {
      return "COLD_LAUNCH";
    }
    if (com.tencent.qapmsdk.impl.g.b.b.get() == a.b.a()) {
      return "FIRST_TIME_LAUNCH";
    }
    return "";
  }
  
  private void v()
  {
    com.tencent.qapmsdk.impl.instrumentation.QAPMAppInstrumentation.isAppInBackground = false;
    com.tencent.qapmsdk.impl.g.b.b.set(a.a.a());
    d.i();
  }
  
  public void a(Context paramContext)
  {
    a = false;
    com.tencent.qapmsdk.impl.g.b.a(paramContext);
    l();
    if (com.tencent.qapmsdk.impl.g.b.c)
    {
      this.e = System.currentTimeMillis();
      this.f = this.e;
    }
  }
  
  public void a(String paramString)
  {
    if ((!a) && (com.tencent.qapmsdk.impl.g.b.c))
    {
      this.t = paramString;
      if (com.tencent.qapmsdk.impl.g.b.b.get() == a.f.a())
      {
        if (!j()) {
          break label51;
        }
        k();
      }
    }
    for (;;)
    {
      this.j = System.currentTimeMillis();
      return;
      label51:
      com.tencent.qapmsdk.impl.g.b.b.set(a.e.a());
    }
  }
  
  public void b()
  {
    if (com.tencent.qapmsdk.impl.g.b.c) {
      this.g = System.currentTimeMillis();
    }
  }
  
  public void b(String paramString)
  {
    if ((!a) && (com.tencent.qapmsdk.impl.g.b.c)) {
      this.n = System.currentTimeMillis();
    }
  }
  
  public void c()
  {
    if (com.tencent.qapmsdk.impl.g.b.c) {
      this.h = System.currentTimeMillis();
    }
  }
  
  public void c(String paramString)
  {
    a = false;
    this.t = paramString;
    com.tencent.qapmsdk.impl.g.b.c = true;
    if ((com.tencent.qapmsdk.impl.g.b.c) && (this.l == 0L))
    {
      if (!j()) {
        break label47;
      }
      k();
    }
    for (;;)
    {
      this.l = System.currentTimeMillis();
      return;
      label47:
      com.tencent.qapmsdk.impl.g.b.b.set(a.e.a());
    }
  }
  
  public void d()
  {
    if (com.tencent.qapmsdk.impl.g.b.c) {
      this.i = System.currentTimeMillis();
    }
  }
  
  public void d(String paramString)
  {
    if ((!a) && (com.tencent.qapmsdk.impl.g.b.c))
    {
      this.t = paramString;
      this.p = System.currentTimeMillis();
    }
  }
  
  public void e()
  {
    if ((!a) && (com.tencent.qapmsdk.impl.g.b.c)) {
      this.k = System.currentTimeMillis();
    }
  }
  
  public void f()
  {
    if ((!a) && (com.tencent.qapmsdk.impl.g.b.c) && (this.o == 0L)) {
      this.o = System.currentTimeMillis();
    }
  }
  
  public void g()
  {
    if ((com.tencent.qapmsdk.impl.g.b.c) && (this.m == 0L)) {
      this.m = System.currentTimeMillis();
    }
  }
  
  public void h()
  {
    if ((com.tencent.qapmsdk.impl.g.b.c) && (!a)) {}
    try
    {
      this.q = System.currentTimeMillis();
      a = true;
      m();
      return;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_Impl_AppStateTimeInfo", "error:", localException);
      return;
    }
    finally
    {
      v();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.b
 * JD-Core Version:    0.7.0.1
 */