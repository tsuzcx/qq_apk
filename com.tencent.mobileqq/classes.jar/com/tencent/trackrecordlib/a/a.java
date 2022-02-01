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
import com.tencent.trackrecordlib.core.c;
import com.tencent.trackrecordlib.g.h;
import java.util.List;

public class a
  implements b
{
  private static final String a = "LifecycleCollector";
  private static final String b = "#";
  private static final String c = "_background_";
  private static int d = 0;
  private static int e = 0;
  private static int f = 0;
  private static int g = 0;
  private static int h = 0;
  private static String i;
  private static String j = "";
  private static String k = "";
  private static boolean l = false;
  private static String m = "_background_";
  private static String n = "_background_";
  private static String o = ;
  private static String p;
  private static String q;
  private static String r;
  private static String s;
  private static com.tencent.trackrecordlib.core.a.a t;
  
  static
  {
    String str = o;
    p = str;
    q = str;
    r = str;
    s = str;
  }
  
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
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null)
    {
      Log.e("LifecycleCollector", "get ActivityManager failed");
      return false;
    }
    if (((ActivityManager.RunningTaskInfo)paramContext.getRunningTasks(1).get(0)).numActivities > 1) {
      bool = true;
    }
    return bool;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isApplicationVisible: ");
    localStringBuilder.append(h());
    localStringBuilder.append(", isApplicationInForeground: ");
    localStringBuilder.append(i());
    Log.d("LifecycleCollector", localStringBuilder.toString());
    Log.d("LifecycleCollector", String.format("[start, stop]: [%d, %d], [resumed, paused]: [%d, %d]", new Object[] { Integer.valueOf(f), Integer.valueOf(g), Integer.valueOf(d), Integer.valueOf(e) }));
  }
  
  private void k()
  {
    Object localObject = new c.a().a(m);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(m);
    localStringBuilder.append("#");
    localStringBuilder.append(j);
    localObject = ((c.a)localObject).b(localStringBuilder.toString()).c(n);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(n);
    localStringBuilder.append("#");
    localStringBuilder.append(k);
    localObject = ((c.a)localObject).d(localStringBuilder.toString()).e(p).f(q).g(r).a();
    c.a().a((com.tencent.trackrecordlib.c.b)localObject);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fake activitycreated:");
      localStringBuilder.append(paramActivity.getClass().getName());
      Log.d("LifecycleCollector", localStringBuilder.toString());
      Log.d("LifecycleCollector", String.format("Now start:[%d]", new Object[] { Integer.valueOf(f) }));
      paramActivity = paramActivity.getClass().getName();
      if (paramActivity == null) {
        paramActivity = "";
      }
      i = paramActivity;
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    h += 1;
    paramBundle = new StringBuilder();
    paramBundle.append("activity created: ");
    paramBundle.append(paramActivity.getClass().getName());
    Log.d("LifecycleCollector", paramBundle.toString());
    i = paramActivity.getClass().getName();
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    k = paramString;
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
    paramBundle = new StringBuilder();
    paramBundle.append("activity save instance state: ");
    paramBundle.append(paramActivity.getClass().getName());
    Log.d("LifecycleCollector", paramBundle.toString());
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(n);
    localStringBuilder.append("#");
    localStringBuilder.append(k);
    return localStringBuilder.toString();
  }
  
  public void c(Activity paramActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("activity destroyed: ");
    localStringBuilder.append(paramActivity.getClass().getName());
    Log.d("LifecycleCollector", localStringBuilder.toString());
    com.tencent.trackrecordlib.d.a.b().a();
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("#");
    localStringBuilder.append(j);
    return localStringBuilder.toString();
  }
  
  public void d(Activity paramActivity)
  {
    d += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("activity resumed: ");
    localStringBuilder.append(paramActivity.getClass().getName());
    Log.d("LifecycleCollector", localStringBuilder.toString());
    j = k;
    k = "";
    m = n;
    p = r;
    n = paramActivity.getClass().getName();
    r = h.a();
    if (g())
    {
      int i1 = h;
      if (i1 < 2)
      {
        h = i1 + 1;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("activitychanged but not created,need add");
        localStringBuilder.append(paramActivity.getClass().getName());
        Log.d("LifecycleCollector", localStringBuilder.toString());
        Log.d("LifecycleCollector", String.format("LAKE [start, stop]: [%d, %d], [resumed, paused]: [%d, %d]", new Object[] { Integer.valueOf(f), Integer.valueOf(g), Integer.valueOf(d), Integer.valueOf(e) }));
        h(paramActivity);
      }
    }
  }
  
  public void e()
  {
    j();
  }
  
  public void e(Activity paramActivity)
  {
    e += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("activity paused: ");
    localStringBuilder.append(paramActivity.getClass().getName());
    Log.d("LifecycleCollector", localStringBuilder.toString());
    q = s;
    s = h.a();
    k();
  }
  
  public void f(Activity paramActivity)
  {
    f += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("activity start: ");
    localStringBuilder.append(paramActivity.getClass().getName());
    Log.d("LifecycleCollector", localStringBuilder.toString());
  }
  
  public void g(Activity paramActivity)
  {
    g += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("activity stop: ");
    localStringBuilder.append(paramActivity.getClass().getName());
    Log.d("LifecycleCollector", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trackrecordlib.a.a
 * JD-Core Version:    0.7.0.1
 */