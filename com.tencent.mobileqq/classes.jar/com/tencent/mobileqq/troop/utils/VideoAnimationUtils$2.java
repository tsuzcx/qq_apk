package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import java.lang.ref.WeakReference;

final class VideoAnimationUtils$2
  implements Runnable
{
  VideoAnimationUtils$2(WeakReference paramWeakReference, String paramString, FrameSprite.OnFrameEndListener paramOnFrameEndListener) {}
  
  public void run()
  {
    SpriteVideoView localSpriteVideoView = (SpriteVideoView)this.a.get();
    if (localSpriteVideoView != null) {
      localSpriteVideoView.a(this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.VideoAnimationUtils.2
 * JD-Core Version:    0.7.0.1
 */