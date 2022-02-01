package com.tencent.superplayer.api;

import android.graphics.Bitmap;

public abstract interface ISuperPlayer$OnCaptureImageListener
{
  public abstract void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2);
  
  public abstract void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
 * JD-Core Version:    0.7.0.1
 */