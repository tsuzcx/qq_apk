package com.tencent.qgplayer.rtmpsdk.c;

import android.os.Build;
import android.os.Build.VERSION;

public class e
{
  public static final int a;
  public static final String b;
  public static final String c;
  
  static
  {
    if ((Build.VERSION.SDK_INT == 25) && (Build.VERSION.CODENAME.charAt(0) == 'O')) {}
    for (int i = 26;; i = Build.VERSION.SDK_INT)
    {
      a = i;
      b = Build.DEVICE;
      c = Build.MANUFACTURER;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.c.e
 * JD-Core Version:    0.7.0.1
 */