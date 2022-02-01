package org.libpag;

import org.extra.tools.LibraryLoadUtils;

public class PAGTextLayer
  extends PAGLayer
{
  static
  {
    LibraryLoadUtils.loadLibrary("libpag");
    nativeInit();
  }
  
  public PAGTextLayer(long paramLong)
  {
    super(paramLong);
  }
  
  private static native void nativeInit();
  
  private native void setFont(String paramString1, String paramString2);
  
  public native int fillColor();
  
  public native PAGFont font();
  
  public native float fontSize();
  
  public native void setFillColor(int paramInt);
  
  public void setFont(PAGFont paramPAGFont)
  {
    setFont(paramPAGFont.fontFamily, paramPAGFont.fontStyle);
  }
  
  public native void setFontSize(float paramFloat);
  
  public native void setStrokeColor(int paramInt);
  
  public native void setText(String paramString);
  
  public native int strokeColor();
  
  public native String text();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.libpag.PAGTextLayer
 * JD-Core Version:    0.7.0.1
 */