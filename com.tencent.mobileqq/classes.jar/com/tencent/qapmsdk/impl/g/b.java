package com.tencent.qapmsdk.impl.g;

import android.content.Context;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.impl.appstate.a;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class b
{
  public static final List<String> a = Arrays.asList(new String[] { "FIRST_TIME_LAUNCH", "COLD_LAUNCH", "WARM_LAUNCH" });
  public static AtomicInteger b = new AtomicInteger(a.a.a());
  public static boolean c = true;
  public static int d = 0;
  private static final Random e = new Random();
  private static Context f;
  private static boolean g = true;
  private static boolean h = false;
  
  public static Random a()
  {
    return e;
  }
  
  public static void a(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      g = bool;
      return;
    }
  }
  
  public static void a(Context paramContext)
  {
    f = paramContext;
  }
  
  public static void a(boolean paramBoolean)
  {
    h = paramBoolean;
    NetworkWatcher.INSTANCE.setNetMonitor(h);
  }
  
  public static Context b()
  {
    return f;
  }
  
  public static boolean c()
  {
    return h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.g.b
 * JD-Core Version:    0.7.0.1
 */