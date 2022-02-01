package org.light;

public class AudioOutput
{
  private long nativeContext = 0L;
  
  static
  {
    LibraryLoadUtils.loadLibrary("light-sdk");
    nativeInit();
  }
  
  private native void nativeFinalize();
  
  private static native void nativeInit();
  
  private final native void nativeRelease();
  
  public native AudioFrame copyNextSample();
  
  protected void finalize()
  {
    super.finalize();
    nativeFinalize();
  }
  
  public void release()
  {
    nativeRelease();
  }
  
  public native void seekTo(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.AudioOutput
 * JD-Core Version:    0.7.0.1
 */