package com.tencent.timi.game.float_window.impl;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;

public class FloatingScreenUtils
{
  public static int a = 480;
  private static int b;
  
  public static boolean a(Context paramContext)
  {
    if (b == 0) {
      if ((Build.VERSION.SDK_INT >= 26) && (Build.VERSION.SDK_INT < 28) && (LiuHaiUtils.c(paramContext)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FloatingScreenUtils", 2, "AndroidO With Notch in Screen.");
        }
        b = 1;
      }
      else
      {
        b = 2;
      }
    }
    return b == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.FloatingScreenUtils
 * JD-Core Version:    0.7.0.1
 */