package com.tencent.oskplayer.util;

import android.text.TextUtils;

public final class Assertions
{
  public static void checkArgument(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public static String checkNotEmpty(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    throw new IllegalArgumentException();
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException();
  }
  
  public static void checkState(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.util.Assertions
 * JD-Core Version:    0.7.0.1
 */