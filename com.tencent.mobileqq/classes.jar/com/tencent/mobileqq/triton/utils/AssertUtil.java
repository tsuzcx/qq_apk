package com.tencent.mobileqq.triton.utils;

import android.os.Looper;

public class AssertUtil
{
  private static boolean DEBUG = true;
  
  public static void Assert(boolean paramBoolean)
  {
    Assert(paramBoolean, "check fail");
  }
  
  public static void Assert(boolean paramBoolean, String paramString)
  {
    if (!DEBUG) {}
    while (paramBoolean) {
      return;
    }
    throw new AssertionError(paramString);
  }
  
  public static <T> T assertNotNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  public static void assertOnUiThread()
  {
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new AssertionError("assertOnUiThread error!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.utils.AssertUtil
 * JD-Core Version:    0.7.0.1
 */