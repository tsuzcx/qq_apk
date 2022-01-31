package com.tencent.ttpic;

import android.util.Log;

public class QQLogUtils
{
  private static boolean isEnable = true;
  
  public static void d(String paramString1, String paramString2)
  {
    if (isEnable) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (isEnable) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (isEnable) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public static void setEnable(boolean paramBoolean)
  {
    isEnable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.QQLogUtils
 * JD-Core Version:    0.7.0.1
 */