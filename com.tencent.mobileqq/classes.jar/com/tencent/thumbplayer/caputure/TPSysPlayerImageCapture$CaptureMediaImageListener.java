package com.tencent.thumbplayer.caputure;

import android.graphics.Bitmap;

public abstract interface TPSysPlayerImageCapture$CaptureMediaImageListener
{
  public abstract void onCaptureFailed(int paramInt1, int paramInt2);
  
  public abstract void onCaptureSucceed(int paramInt1, long paramLong1, int paramInt2, int paramInt3, Bitmap paramBitmap, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.caputure.TPSysPlayerImageCapture.CaptureMediaImageListener
 * JD-Core Version:    0.7.0.1
 */