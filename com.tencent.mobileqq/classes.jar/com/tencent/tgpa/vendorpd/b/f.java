package com.tencent.tgpa.vendorpd.b;

import android.util.Log;

public class f
{
  private static boolean a = false;
  
  public static void a(String paramString)
  {
    Log.v("TGPA", paramString);
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (a) {
      Log.d("TGPA", String.format(paramString, paramVarArgs));
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static void b(String paramString)
  {
    if (a) {
      Log.d("TGPA", paramString);
    }
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    d(String.format(paramString, paramVarArgs));
  }
  
  public static void c(String paramString)
  {
    Log.w("TGPA", paramString);
  }
  
  public static void d(String paramString)
  {
    Log.e("TGPA", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.b.f
 * JD-Core Version:    0.7.0.1
 */