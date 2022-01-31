package com.tencent.util;

public class Coffee
{
  private static native String getDESSignKey();
  
  public static String getSignkey()
  {
    return getDESSignKey();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.util.Coffee
 * JD-Core Version:    0.7.0.1
 */