package com.tencent.tav.player;

import android.graphics.Bitmap;
import com.tencent.tav.coremedia.CMTime;

public abstract interface OnReadSnapShootListener
{
  public abstract void onSuccess(Bitmap paramBitmap, CMTime paramCMTime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.player.OnReadSnapShootListener
 * JD-Core Version:    0.7.0.1
 */