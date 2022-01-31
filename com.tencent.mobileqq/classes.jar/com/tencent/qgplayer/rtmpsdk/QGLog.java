package com.tencent.qgplayer.rtmpsdk;

import android.util.Log;

public class QGLog
{
  private static boolean a(int paramInt, String paramString1, String paramString2)
  {
    if (SimpleQGPlayer.logListener != null)
    {
      SimpleQGPlayer.logListener.onLog(paramInt, paramString1, paramString2);
      return true;
    }
    return false;
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (!a(1, paramString1, paramString2)) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (!a(4, paramString1, paramString2)) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (!a(3, paramString1, paramString2)) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (!a(2, paramString1, paramString2)) {
      Log.w(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.QGLog
 * JD-Core Version:    0.7.0.1
 */