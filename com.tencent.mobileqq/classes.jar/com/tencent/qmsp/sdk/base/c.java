package com.tencent.qmsp.sdk.base;

import android.util.Log;

public class c
{
  private static String a = "2g.outt";
  private static boolean b = false;
  
  public static void a(String paramString)
  {
    if (b) {
      Log.d(a, paramString);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static void b(String paramString)
  {
    if (b) {
      Log.e(a, paramString);
    }
  }
  
  public static void c(String paramString)
  {
    if (b) {
      Log.i(a, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.base.c
 * JD-Core Version:    0.7.0.1
 */