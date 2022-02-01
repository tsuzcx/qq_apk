package org.libpag;

import org.extra.tools.LibraryLoadUtils;

public class PAGImageLayer
  extends PAGLayer
{
  static
  {
    LibraryLoadUtils.loadLibrary("libpag");
    nativeInit();
  }
  
  public PAGImageLayer(long paramLong)
  {
    super(paramLong);
  }
  
  public static PAGImageLayer Make(int paramInt1, int paramInt2, long paramLong)
  {
    paramLong = nativeMake(paramInt1, paramInt2, paramLong);
    if (paramLong == 0L) {
      return null;
    }
    return new PAGImageLayer(paramLong);
  }
  
  private static native void nativeInit();
  
  private static native long nativeMake(int paramInt1, int paramInt2, long paramLong);
  
  private native void replaceImage(long paramLong);
  
  public native long contentDuration();
  
  public native PAGVideoRange[] getVideoRanges();
  
  public void replaceImage(PAGImage paramPAGImage)
  {
    long l;
    if (paramPAGImage == null) {
      l = 0L;
    } else {
      l = paramPAGImage.nativeContext;
    }
    replaceImage(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.libpag.PAGImageLayer
 * JD-Core Version:    0.7.0.1
 */