package com.tencent.mobileqq.minicode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import java.io.ByteArrayOutputStream;

public class YuvProxy
{
  public static native int ArgbScale(int[] paramArrayOfInt1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt2, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  public static native int ArgbScaleClip(int[] paramArrayOfInt1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11);
  
  public static native void Yuv2Rgba(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static Bitmap getBitmapJava(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramInt1, paramInt2, null);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramArrayOfByte.compressToJpeg(new Rect(0, 0, paramArrayOfByte.getWidth(), paramArrayOfByte.getHeight()), 100, localByteArrayOutputStream);
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    return BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minicode.YuvProxy
 * JD-Core Version:    0.7.0.1
 */