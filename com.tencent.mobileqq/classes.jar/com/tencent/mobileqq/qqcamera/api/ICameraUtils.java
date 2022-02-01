package com.tencent.mobileqq.qqcamera.api;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ICameraUtils
  extends QRouteApi
{
  @TargetApi(10)
  public abstract Bitmap clipJpegToBitmap(byte[] paramArrayOfByte, Rect paramRect, boolean paramBoolean, int paramInt);
  
  public abstract int getJpegRotation(int paramInt1, int paramInt2);
  
  public abstract Bitmap rotateBitmap(Bitmap paramBitmap, int paramInt, boolean paramBoolean);
  
  public abstract boolean tryRecycle(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqcamera.api.ICameraUtils
 * JD-Core Version:    0.7.0.1
 */