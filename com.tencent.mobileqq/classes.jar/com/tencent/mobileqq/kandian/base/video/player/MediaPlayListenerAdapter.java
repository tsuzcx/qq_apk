package com.tencent.mobileqq.kandian.base.video.player;

import android.graphics.Bitmap;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.MediaPlayListener;

public abstract class MediaPlayListenerAdapter
  implements MediaPlayListener
{
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper) {}
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, String paramString) {}
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public boolean a(IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    return false;
  }
  
  public boolean a(IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    return false;
  }
  
  public void b(IVideoPlayerWrapper paramIVideoPlayerWrapper) {}
  
  public void c(IVideoPlayerWrapper paramIVideoPlayerWrapper) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.MediaPlayListenerAdapter
 * JD-Core Version:    0.7.0.1
 */