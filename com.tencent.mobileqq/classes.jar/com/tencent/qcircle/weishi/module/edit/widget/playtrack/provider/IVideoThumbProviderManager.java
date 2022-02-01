package com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.tavkit.composition.TAVSource;

public abstract interface IVideoThumbProviderManager
{
  public abstract Bitmap getBitmapByTime(long paramLong, Object paramObject, String paramString);
  
  public abstract long getCacheSize();
  
  public abstract void initWidthAndHeight(int paramInt1, int paramInt2);
  
  public abstract void pause();
  
  public abstract void registerListener(VideoThumbListener paramVideoThumbListener);
  
  public abstract void release(String paramString);
  
  public abstract void reset(MediaResourceModel paramMediaResourceModel, String paramString);
  
  public abstract void reset(TAVSource paramTAVSource, String paramString1, String paramString2);
  
  public abstract void resume();
  
  public abstract void setDefaultBitmap(Bitmap paramBitmap);
  
  public abstract void unRegisterListener(VideoThumbListener paramVideoThumbListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.IVideoThumbProviderManager
 * JD-Core Version:    0.7.0.1
 */