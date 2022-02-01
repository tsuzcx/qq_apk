package com.tencent.tgpa.vendorpd.b;

import android.content.Context;

public class a
{
  private static Context a;
  
  public static Context a()
  {
    return a;
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getApplicationContext();
      if (paramContext == null) {
        paramContext = "get application context is null, ple check!";
      } else {
        a = paramContext;
      }
    }
    else
    {
      paramContext = "the init context is null, ple check!";
    }
    f.d(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.b.a
 * JD-Core Version:    0.7.0.1
 */