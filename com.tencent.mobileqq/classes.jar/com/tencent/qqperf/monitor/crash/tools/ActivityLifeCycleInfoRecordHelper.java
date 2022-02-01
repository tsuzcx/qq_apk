package com.tencent.qqperf.monitor.crash.tools;

import android.content.Context;
import java.util.HashMap;
import java.util.Stack;

public class ActivityLifeCycleInfoRecordHelper
{
  public static HashMap<String, String> a;
  public static Stack<String> a;
  
  static
  {
    jdField_a_of_type_JavaUtilStack = new Stack();
    jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
  }
  
  public static int a()
  {
    return jdField_a_of_type_JavaUtilStack.size();
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    int i = Math.min(jdField_a_of_type_JavaUtilStack.size(), 5);
    while (i > 0)
    {
      String str = (String)jdField_a_of_type_JavaUtilStack.pop();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("\n--->");
      }
      localStringBuilder.append(str);
      i -= 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilStack.clear();
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.toString();
      jdField_a_of_type_JavaUtilStack.push(paramContext);
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
      jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" time:");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("\n");
      paramString2 = localStringBuilder.toString();
      jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
    }
  }
  
  public static String b()
  {
    return jdField_a_of_type_JavaUtilHashMap.toString();
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext != null) {
      a("onResume", paramContext.toString());
    }
  }
  
  public static void c(Context paramContext)
  {
    if (paramContext != null) {
      a("onPause", paramContext.toString());
    }
  }
  
  public static void d(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.toString();
      jdField_a_of_type_JavaUtilStack.remove(paramContext);
      a("onDestroy", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.tools.ActivityLifeCycleInfoRecordHelper
 * JD-Core Version:    0.7.0.1
 */