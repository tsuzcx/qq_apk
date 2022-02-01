package com.tencent.mobileqq.surfaceviewaction.gl;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import mqq.util.WeakReference;

class VideoSprite$CompletionListener
  implements MediaPlayer.OnCompletionListener
{
  private WeakReference<VideoSprite> a;
  
  private VideoSprite$CompletionListener(VideoSprite paramVideoSprite)
  {
    this.a = new WeakReference(paramVideoSprite);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = (VideoSprite)this.a.get();
    if (paramMediaPlayer == null) {
      return;
    }
    if (paramMediaPlayer.al)
    {
      paramMediaPlayer.P.b(new VideoSprite.CompletionListener.1(this, paramMediaPlayer));
      return;
    }
    paramMediaPlayer.ah = false;
    paramMediaPlayer.ak.removeCallbacksAndMessages(null);
    if (paramMediaPlayer.ad != null) {
      paramMediaPlayer.ad.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.CompletionListener
 * JD-Core Version:    0.7.0.1
 */