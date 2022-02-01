package com.tencent.qqmini.v8rt.engine;

import android.os.Build;
import android.os.Build.VERSION;

public class Util
{
  public static final String DEVICE = Build.DEVICE;
  public static final String MANUFACTURER = Build.MANUFACTURER;
  public static final int SDK_INT;
  
  static
  {
    int i;
    if ((Build.VERSION.SDK_INT == 25) && (Build.VERSION.CODENAME.charAt(0) == 'O')) {
      i = 26;
    } else {
      i = Build.VERSION.SDK_INT;
    }
    SDK_INT = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.Util
 * JD-Core Version:    0.7.0.1
 */