package com.tencent.mobileqq.minicode;

public class YuvProxy
{
  public static native int ArgbScale(int[] paramArrayOfInt1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt2, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  public static native int ArgbScaleClip(int[] paramArrayOfInt1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11);
  
  public static native void Yuv2Rgba(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minicode.YuvProxy
 * JD-Core Version:    0.7.0.1
 */