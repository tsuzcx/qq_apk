package com.tencent.mobileqq.kandian.base.video.player.api;

import android.graphics.Bitmap;

public abstract interface MediaPlayListener
{
  public abstract void a(IVideoPlayerWrapper paramIVideoPlayerWrapper);
  
  public abstract void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, Object paramObject);
  
  public abstract void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, String paramString);
  
  public abstract void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap);
  
  public abstract boolean a(IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject);
  
  public abstract boolean a(IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt, Object paramObject);
  
  public abstract void b(IVideoPlayerWrapper paramIVideoPlayerWrapper);
  
  public abstract void c(IVideoPlayerWrapper paramIVideoPlayerWrapper);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.api.MediaPlayListener
 * JD-Core Version:    0.7.0.1
 */