package com.tencent.plato.core.utils;

import android.os.Looper;

public class AssertUtil
{
  public static void Assert(boolean paramBoolean)
  {
    Assert(paramBoolean, "check fail");
  }
  
  public static void Assert(boolean paramBoolean, String paramString) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.core.utils.AssertUtil
 * JD-Core Version:    0.7.0.1
 */