package org.libpag;

import org.extra.tools.LibraryLoadUtils;

public class PAGShapeLayer
  extends PAGLayer
{
  static
  {
    LibraryLoadUtils.loadLibrary("libpag");
    nativeInit();
  }
  
  public PAGShapeLayer(long paramLong)
  {
    super(paramLong);
  }
  
  private static native void nativeInit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.libpag.PAGShapeLayer
 * JD-Core Version:    0.7.0.1
 */