package com.tencent.mobileqq.warbler;

public class Warbler
{
  private static boolean a;
  
  private static void a()
  {
    if (a) {
      return;
    }
    System.loadLibrary("warbler");
    a = true;
  }
  
  public static boolean a()
  {
    a();
    return nativeMakeArtDebuggable();
  }
  
  private static native boolean nativeMakeArtDebuggable();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.warbler.Warbler
 * JD-Core Version:    0.7.0.1
 */