package com.tencent.ttpic;

import android.view.Surface;

public class HomeActivity
{
  public static native void ndkdraw(Surface paramSurface, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void readPixel(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void toYV12(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.HomeActivity
 * JD-Core Version:    0.7.0.1
 */