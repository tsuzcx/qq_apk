package com.tencent.vbox.util;

import android.os.SystemClock;

public class VMeasure
{
  private static long start;
  
  public static long cost()
  {
    return SystemClock.elapsedRealtime() - start;
  }
  
  public static boolean start()
  {
    start = SystemClock.elapsedRealtime();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.util.VMeasure
 * JD-Core Version:    0.7.0.1
 */