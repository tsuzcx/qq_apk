package org.libpag;

import org.extra.tools.LibraryLoadUtils;

public class PAGSolidLayer
  extends PAGLayer
{
  static
  {
    LibraryLoadUtils.loadLibrary("libpag");
    nativeInit();
  }
  
  public PAGSolidLayer(long paramLong)
  {
    super(paramLong);
  }
  
  private static native void nativeInit();
  
  public native void setSolidColor(int paramInt);
  
  public native int solidColor();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.libpag.PAGSolidLayer
 * JD-Core Version:    0.7.0.1
 */