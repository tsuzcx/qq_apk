package com.tencent.mobileqq.warbler;

public class Warbler
{
  private static boolean a;
  
  public static boolean a()
  {
    b();
    return nativeMakeArtDebuggable();
  }
  
  private static void b()
  {
    if (a) {
      return;
    }
    System.loadLibrary("warbler");
    a = true;
  }
  
  private static native boolean nativeMakeArtDebuggable();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.warbler.Warbler
 * JD-Core Version:    0.7.0.1
 */