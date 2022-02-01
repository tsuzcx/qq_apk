package com.tencent.theme;

import android.util.Log;

public class h
{
  public static ISkinEngineLog a;
  public static final int b = 4;
  public static final int c = 2;
  public static final int d = 1;
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    d(paramString1, paramInt, paramString2, null);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if (a != null) {
      a.trace(6, paramString1, paramInt, paramString2, paramThrowable);
    }
    while ((!SkinEngine.DEBUG) && (!SkinEngine.SWITCH_DEBUG)) {
      return;
    }
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void b(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if (a != null) {
      a.trace(5, paramString1, paramInt, paramString2, paramThrowable);
    }
    while ((!SkinEngine.DEBUG) && (!SkinEngine.SWITCH_DEBUG)) {
      return;
    }
    Log.w(paramString1, paramString2, paramThrowable);
  }
  
  public static void c(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if (a != null) {
      a.trace(4, paramString1, paramInt, paramString2, paramThrowable);
    }
    while ((!SkinEngine.DEBUG) && (!SkinEngine.SWITCH_DEBUG)) {
      return;
    }
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if (a != null) {
      a.trace(3, paramString1, paramInt, paramString2, paramThrowable);
    }
    while ((!SkinEngine.DEBUG) && (!SkinEngine.SWITCH_DEBUG)) {
      return;
    }
    Log.d(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.h
 * JD-Core Version:    0.7.0.1
 */