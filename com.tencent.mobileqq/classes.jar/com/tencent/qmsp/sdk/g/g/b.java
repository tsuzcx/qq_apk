package com.tencent.qmsp.sdk.g.g;

import android.content.Context;

public class b
{
  public static String a(Context paramContext)
  {
    if (a.a) {
      return e.f.a(a.a(paramContext), "AUID");
    }
    throw new RuntimeException("SDK Need Init First!");
  }
  
  public static boolean a()
  {
    if (a.a) {
      return a.b;
    }
    throw new RuntimeException("SDK Need Init First!");
  }
  
  public static String b(Context paramContext)
  {
    if (a.a) {
      return e.f.a(a.a(paramContext), "OUID");
    }
    throw new RuntimeException("SDK Need Init First!");
  }
  
  public static void c(Context paramContext)
  {
    a.b = e.f.a(a.a(paramContext));
    a.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.g.b
 * JD-Core Version:    0.7.0.1
 */