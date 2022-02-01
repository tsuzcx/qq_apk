package com.tencent.qapmsdk.impl.g;

import android.content.Context;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.impl.appstate.a;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class b
{
  public static final List<String> a = Arrays.asList(new String[] { "FIRST_TIME_LAUNCH", "COLD_LAUNCH", "WARM_LAUNCH" });
  public static final List<String> b = Arrays.asList(new String[] { "LAUNCH_APPLICATION_INIT", "LAUNCH_MAIN_ACTIVITY_INIT", "LAUNCH_ACTIVITY_LAYOUT", "LAUNCH_END_BY_USER", "LAUNCH_ACTIVITY_LOAD" });
  public static AtomicInteger c = new AtomicInteger(a.a.a());
  public static AtomicBoolean d = new AtomicBoolean(false);
  public static AtomicBoolean e = new AtomicBoolean(false);
  public static AtomicBoolean f = new AtomicBoolean(false);
  public static boolean g = true;
  public static int h = 0;
  private static final Random i = new Random();
  private static Context j;
  private static boolean k = true;
  private static boolean l = false;
  
  public static Random a()
  {
    return i;
  }
  
  public static void a(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      k = bool;
      return;
    }
  }
  
  public static void a(Context paramContext)
  {
    j = paramContext;
  }
  
  public static void a(boolean paramBoolean)
  {
    l = paramBoolean;
    NetworkWatcher.INSTANCE.setNetMonitor(l);
  }
  
  public static Context b()
  {
    return j;
  }
  
  public static boolean c()
  {
    return l;
  }
  
  public static boolean d()
  {
    return (c.get() == a.b.a()) || (c.get() == a.c.a()) || (c.get() == a.d.a());
  }
  
  public static boolean e()
  {
    return f.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.g.b
 * JD-Core Version:    0.7.0.1
 */