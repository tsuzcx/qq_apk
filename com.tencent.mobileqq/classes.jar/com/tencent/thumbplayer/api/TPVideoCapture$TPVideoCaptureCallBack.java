package com.tencent.thumbplayer.api;

import android.graphics.Bitmap;

public abstract interface TPVideoCapture$TPVideoCaptureCallBack
{
  public abstract void onCaptureError(int paramInt);
  
  public abstract void onCaptureSuccess(Bitmap[] paramArrayOfBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPVideoCapture.TPVideoCaptureCallBack
 * JD-Core Version:    0.7.0.1
 */