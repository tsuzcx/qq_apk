package com.tencent.thumbplayer.api;

import android.graphics.Bitmap;

public abstract interface TPCaptureCallBack
{
  public abstract void onCaptureVideoFailed(int paramInt);
  
  public abstract void onCaptureVideoSuccess(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPCaptureCallBack
 * JD-Core Version:    0.7.0.1
 */