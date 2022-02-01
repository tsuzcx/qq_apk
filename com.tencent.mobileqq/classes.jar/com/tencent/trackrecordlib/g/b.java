package com.tencent.trackrecordlib.g;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import com.tencent.trackrecordlib.a.a;
import com.tencent.trackrecordlib.core.a.a;

public class b
{
  private static final String a = "b";
  private static a.a b;
  private static Application.ActivityLifecycleCallbacks c = new b.1();
  
  public static String a()
  {
    return a.f().a();
  }
  
  public static void a(Activity paramActivity)
  {
    a.f().a(paramActivity);
    a.f().b(paramActivity);
  }
  
  public static void a(Context paramContext)
  {
    ((Application)paramContext).unregisterActivityLifecycleCallbacks(c);
  }
  
  public static void a(Context paramContext, a.a parama)
  {
    b = parama;
    ((Application)paramContext).registerActivityLifecycleCallbacks(c);
  }
  
  public static void a(String paramString)
  {
    a.f().a(paramString);
  }
  
  public static String b()
  {
    return a.f().b();
  }
  
  public static String c()
  {
    return a.f().c();
  }
  
  public static String d()
  {
    return a.f().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trackrecordlib.g.b
 * JD-Core Version:    0.7.0.1
 */