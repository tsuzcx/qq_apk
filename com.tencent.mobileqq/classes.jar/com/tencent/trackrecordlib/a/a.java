package com.tencent.trackrecordlib.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import com.tencent.trackrecordlib.c.c.a;
import com.tencent.trackrecordlib.g.h;
import java.util.List;

public class a
  implements b
{
  private static final String a = "LifecycleCollector";
  private static final String b = "#";
  private static final String c = "_background_";
  private static int d;
  private static int e;
  private static int f;
  private static int g;
  private static int h;
  private static String i;
  private static String j = "";
  private static String k = "";
  private static boolean l = false;
  private static String m = "_background_";
  private static String n = "_background_";
  private static String o = h.a();
  private static String p = o;
  private static String q = o;
  private static String r = o;
  private static String s = o;
  private static com.tencent.trackrecordlib.core.a.a t;
  
  private String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null)
    {
      Log.e("LifecycleCollector", "get ActivityManager failed");
      return "";
    }
    return ((ActivityManager.RunningTaskInfo)paramContext.getRunningTasks(1).get(0)).topActivity.getClassName();
  }
  
  private boolean b(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null)
    {
      Log.e("LifecycleCollector", "get ActivityManager failed");
      return false;
    }
    if (((ActivityManager.RunningTaskInfo)paramContext.getRunningTasks(1).get(0)).numActivities > 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static a f()
  {
    return a.a.a();
  }
  
  private static boolean g()
  {
    return h < f;
  }
  
  private void h(Activity paramActivity)
  {
    if ((t != null) && (paramActivity.getClass().getName().equals(f().a()))) {
      t.a(paramActivity.getWindow().getDecorView());
    }
  }
  
  private static boolean h()
  {
    return f > g;
  }
  
  private static boolean i()
  {
    return d > e;
  }
  
  private void j()
  {
    Log.d("LifecycleCollector", "isApplicationVisible: " + h() + ", isApplicationInForeground: " + i());
    Log.d("LifecycleCollector", String.format("[start, stop]: [%d, %d], [resumed, paused]: [%d, %d]", new Object[] { Integer.valueOf(f), Integer.valueOf(g), Integer.valueOf(d), Integer.valueOf(e) }));
  }
  
  private void k()
  {
    com.tencent.trackrecordlib.c.c localc = new c.a().a(m).b(m + "#" + j).c(n).d(n + "#" + k).e(p).f(q).g(r).a();
    com.tencent.trackrecordlib.core.c.a().a(localc);
  }
  
  public String a()
  {
    return i;
  }
  
  public void a(Activity paramActivity)
  {
    if ((paramActivity != null) && (i != paramActivity.getClass().getName()))
    {
      f += 1;
      Log.d("LifecycleCollector", "fake activitycreated:" + paramActivity.getClass().getName());
      Log.d("LifecycleCollector", String.format("Now start:[%d]", new Object[] { Integer.valueOf(f) }));
      paramActivity = paramActivity.getClass().getName();
      if (paramActivity == null) {
        break label97;
      }
    }
    for (;;)
    {
      i = paramActivity;
      return;
      label97:
      paramActivity = "";
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    h += 1;
    Log.d("LifecycleCollector", "activity created: " + paramActivity.getClass().getName());
    i = paramActivity.getClass().getName();
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      k = paramString;
      return;
      paramString = "";
    }
  }
  
  public String b()
  {
    return n;
  }
  
  public void b(Activity paramActivity)
  {
    if (g())
    {
      Log.d("LifecycleCollector", "Listener & Resume plus");
      h += 1;
      h(paramActivity);
      if (e > d) {
        d(paramActivity);
      }
    }
  }
  
  public void b(Activity paramActivity, Bundle paramBundle)
  {
    Log.d("LifecycleCollector", "activity save instance state: " + paramActivity.getClass().getName());
  }
  
  public String c()
  {
    return n + "#" + k;
  }
  
  public void c(Activity paramActivity)
  {
    Log.d("LifecycleCollector", "activity destroyed: " + paramActivity.getClass().getName());
    com.tencent.trackrecordlib.d.a.b().a();
  }
  
  public String d()
  {
    return i + "#" + j;
  }
  
  public void d(Activity paramActivity)
  {
    d += 1;
    Log.d("LifecycleCollector", "activity resumed: " + paramActivity.getClass().getName());
    j = k;
    k = "";
    m = n;
    p = r;
    n = paramActivity.getClass().getName();
    r = h.a();
    if ((g()) && (h < 2))
    {
      h += 1;
      Log.d("LifecycleCollector", "activitychanged but not created,need add" + paramActivity.getClass().getName());
      Log.d("LifecycleCollector", String.format("LAKE [start, stop]: [%d, %d], [resumed, paused]: [%d, %d]", new Object[] { Integer.valueOf(f), Integer.valueOf(g), Integer.valueOf(d), Integer.valueOf(e) }));
      h(paramActivity);
    }
  }
  
  public void e()
  {
    j();
  }
  
  public void e(Activity paramActivity)
  {
    e += 1;
    Log.d("LifecycleCollector", "activity paused: " + paramActivity.getClass().getName());
    q = s;
    s = h.a();
    k();
  }
  
  public void f(Activity paramActivity)
  {
    f += 1;
    Log.d("LifecycleCollector", "activity start: " + paramActivity.getClass().getName());
  }
  
  public void g(Activity paramActivity)
  {
    g += 1;
    Log.d("LifecycleCollector", "activity stop: " + paramActivity.getClass().getName());
    j();
    if (!h())
    {
      Log.d("LifecycleCollector", "enter background");
      m = n;
      p = r;
      q = s;
      j = k;
      k = "";
      n = "_background_";
      r = h.a();
      s = h.a();
      k();
    }
    com.tencent.trackrecordlib.d.a.b().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.trackrecordlib.a.a
 * JD-Core Version:    0.7.0.1
 */