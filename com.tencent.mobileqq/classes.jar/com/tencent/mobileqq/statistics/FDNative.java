package com.tencent.mobileqq.statistics;

public class FDNative
{
  private static FDNative a;
  
  private FDNative()
  {
    System.loadLibrary("qq_fd");
  }
  
  public static FDNative a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new FDNative();
      }
      return a;
    }
    finally {}
  }
  
  public static native int nativeIgnore(String paramString);
  
  public static native int nativeRegister(String paramString);
  
  public static native int nativeSave(String paramString);
  
  public static native int nativeSetTarget(String paramString);
  
  public static native int nativeStart();
  
  public static native int nativeStop();
  
  public void a(String paramString)
  {
    nativeSave(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDNative
 * JD-Core Version:    0.7.0.1
 */