package org.libpag;

import org.extra.tools.LibraryLoadUtils;

public abstract class VideoDecoder
{
  static
  {
    LibraryLoadUtils.loadLibrary("libpag");
  }
  
  public static native void RegisterSoftwareDecoderFactory(long paramLong);
  
  public static native void SetMaxHardwareDecoderCount(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.libpag.VideoDecoder
 * JD-Core Version:    0.7.0.1
 */