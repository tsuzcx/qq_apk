package com.tencent.qqlive.mediaplayer.api;

import android.graphics.Bitmap;

public abstract interface TVK_IMediaPlayer$OnCaptureImageListener
{
  public abstract void onCaptureImageFailed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2);
  
  public abstract void onCaptureImageSucceed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCaptureImageListener
 * JD-Core Version:    0.7.0.1
 */