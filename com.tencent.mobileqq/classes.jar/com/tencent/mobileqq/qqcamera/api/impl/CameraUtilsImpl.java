package com.tencent.mobileqq.qqcamera.api.impl;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.mobileqq.camera.CameraHolder;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.qqcamera.api.ICameraUtils;

public class CameraUtilsImpl
  implements ICameraUtils
{
  private static final String TAG = "CameraUtilsImpl";
  
  public Bitmap clipJpegToBitmap(byte[] paramArrayOfByte, Rect paramRect, boolean paramBoolean, int paramInt)
  {
    return CameraUtils.a(paramArrayOfByte, paramRect, paramBoolean, paramInt);
  }
  
  public int getJpegRotation(int paramInt1, int paramInt2)
  {
    return CameraUtils.a(CameraHolder.a(), paramInt1, paramInt2);
  }
  
  public Bitmap rotateBitmap(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    return CameraUtils.a(paramBitmap, paramInt, paramBoolean);
  }
  
  public boolean tryRecycle(Bitmap paramBitmap)
  {
    return CameraUtils.a(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqcamera.api.impl.CameraUtilsImpl
 * JD-Core Version:    0.7.0.1
 */