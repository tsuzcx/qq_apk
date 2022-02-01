package com.tencent.mobileqq.utils;

import android.os.Build.VERSION;

public final class SecMsgUtil
{
  public static int a()
  {
    if (Build.VERSION.SDK_INT > 10) {
      return 4;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SecMsgUtil
 * JD-Core Version:    0.7.0.1
 */