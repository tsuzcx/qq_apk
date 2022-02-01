package com.tencent.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import com.tencent.tav.coremedia.CMTime;

public abstract interface VideoThumbListener
{
  public abstract void onThumbGenerated(Object paramObject, CMTime paramCMTime, Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbListener
 * JD-Core Version:    0.7.0.1
 */