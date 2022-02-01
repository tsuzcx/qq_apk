package com.tencent.qqperf.monitor.crash.tools;

import android.content.Context;
import java.util.HashMap;
import java.util.Stack;

public class ActivityLifeCycleInfoRecordHelper
{
  public static Stack<String> a = new Stack();
  public static HashMap<String, String> b = new HashMap(4);
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    int i = Math.min(a.size(), 5);
    while (i > 0)
    {
      String str = (String)a.pop();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("\n--->");
      }
      localStringBuilder.append(str);
      i -= 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.toString();
      a.push(paramContext);
      a("onCreate", paramContext);
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      b.remove(paramString1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" time:");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("\n");
      paramString2 = localStringBuilder.toString();
      b.put(paramString1, paramString2);
    }
  }
  
  public static int b()
  {
    return a.size();
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext != null) {
      a("onResume", paramContext.toString());
    }
  }
  
  public static void c()
  {
    a.clear();
  }
  
  public static void c(Context paramContext)
  {
    if (paramContext != null) {
      a("onPause", paramContext.toString());
    }
  }
  
  public static String d()
  {
    return b.toString();
  }
  
  public static void d(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.toString();
      a.remove(paramContext);
      a("onDestroy", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.tools.ActivityLifeCycleInfoRecordHelper
 * JD-Core Version:    0.7.0.1
 */