package org.light;

public class LightTestResult
{
  private long nativeContext = 0L;
  
  static
  {
    LibraryLoadUtils.loadLibrary("light-sdk");
    nativeInit();
  }
  
  private native void nativeFinalize();
  
  private static native void nativeInit();
  
  public native void exportToFile(String paramString);
  
  public native long failedFrameCount();
  
  protected void finalize()
  {
    super.finalize();
    nativeFinalize();
  }
  
  public native long successFrameCount();
  
  public native long totalFrameCount();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.LightTestResult
 * JD-Core Version:    0.7.0.1
 */