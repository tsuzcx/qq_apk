package com.tencent.tvkbeacon.core.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.tvkbeacon.core.event.TunnelModule;
import com.tencent.tvkbeacon.core.event.UserEventModule;
import com.tencent.tvkbeacon.core.info.d;
import com.tencent.tvkbeacon.event.UserAction;
import java.lang.ref.WeakReference;
import java.util.Map;

@TargetApi(14)
public final class e
  implements Application.ActivityLifecycleCallbacks
{
  private static SparseArray<WeakReference<Activity>> a = new SparseArray();
  private boolean b = false;
  private long c = 0L;
  private long d = 0L;
  private long e = 20000L;
  private String f = "";
  private Map<String, String> g = null;
  
  public e()
  {
    this.g.put("A63", "N");
    this.g.put("A66", "F");
  }
  
  private void a()
  {
    e.1 local1 = new e.1(this);
    b.d().a(local1);
  }
  
  private void a(Activity paramActivity)
  {
    Context localContext = paramActivity.getApplicationContext();
    d.a(localContext);
    this.g.put("A33", d.j(localContext));
    Map localMap = this.g;
    if (com.tencent.tvkbeacon.core.info.a.a) {}
    for (paramActivity = "Y";; paramActivity = "N")
    {
      localMap.put("A85", paramActivity);
      this.g.put("A20", d.g(localContext));
      this.g.put("A69", d.h(localContext));
      UserAction.onUserAction("rqd_applaunched", true, 0L, 0L, this.g, true);
      a();
      return;
    }
  }
  
  private void a(boolean paramBoolean, Activity paramActivity)
  {
    UserEventModule localUserEventModule = UserEventModule.getInstance();
    if (paramBoolean)
    {
      long l = System.currentTimeMillis();
      if ((this.c > 0L) && (this.d > 0L) && (this.d + b() <= l))
      {
        com.tencent.tvkbeacon.core.c.c.b("[lifecycle] -> return foreground more than 20s.", new Object[0]);
        a(paramActivity);
        if (localUserEventModule != null) {
          localUserEventModule.onAppHotLaunch();
        }
      }
      this.c = l;
      this.d = 0L;
      return;
    }
    this.d = System.currentTimeMillis();
    if (this.c + 800L > this.d)
    {
      com.tencent.tvkbeacon.core.c.c.b("[lifecycle] -> debounce activity switch.", new Object[0]);
      this.c = 0L;
      return;
    }
    if (this.c == 0L) {
      this.c = this.d;
    }
    if (localUserEventModule != null) {
      localUserEventModule.onAppStop();
    }
    TunnelModule.flushObjectsToDB(false);
  }
  
  private boolean a(Context paramContext)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    String str = com.tencent.tvkbeacon.core.c.a.a();
    if ("".equals(this.f)) {
      this.f = c.a(paramContext).a("LAUEVE_DENGTA", "");
    }
    if (!str.equals(this.f))
    {
      c.a(paramContext).a().a("LAUEVE_DENGTA", str).b();
      bool1 = bool2;
      if (!"".equals(this.f))
      {
        com.tencent.tvkbeacon.core.c.c.b("[core] -> report new day launcher event.", new Object[0]);
        bool1 = true;
      }
      this.f = str;
    }
    return bool1;
  }
  
  private long b()
  {
    String str;
    if (this.e <= 20000L)
    {
      str = com.tencent.tvkbeacon.core.strategy.b.a().b("hotLauncher");
      if (str == null) {}
    }
    try
    {
      this.e = Long.valueOf(str).longValue();
      com.tencent.tvkbeacon.core.c.c.b("[strategy] -> change launcher time: %s ms", new Object[] { str });
      this.e += 1L;
      return this.e;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        com.tencent.tvkbeacon.core.c.c.d("[strategy] -> event param 'hotLauncher' error.", new Object[0]);
      }
    }
  }
  
  private void b(Activity paramActivity)
  {
    com.tencent.tvkbeacon.core.info.a.a = true;
    c(paramActivity);
    if (!this.b)
    {
      com.tencent.tvkbeacon.core.c.c.b("[event] lifecycle callback recover active user.", new Object[0]);
      b.d().a(new e.2(this, paramActivity));
      this.b = true;
    }
    if (a(paramActivity)) {
      a(paramActivity);
    }
  }
  
  private static void c(Activity paramActivity)
  {
    if ((paramActivity != null) && (a != null))
    {
      int i = paramActivity.hashCode();
      if (a.get(i) == null)
      {
        paramActivity = new WeakReference(paramActivity);
        a.put(i, paramActivity);
      }
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    b(paramActivity);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    b(paramActivity);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    b(paramActivity);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    b(paramActivity);
    a(true, paramActivity);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    b(paramActivity);
  }
  
  public final void onActivityStarted(Activity paramActivity)
  {
    b(paramActivity);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    b(paramActivity);
    a(false, paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.a.e
 * JD-Core Version:    0.7.0.1
 */