package com.tencent.mobileqq.surfaceviewaction.gl;

import android.media.MediaPlayer;

class VideoSprite$6
  implements Runnable
{
  VideoSprite$6(VideoSprite paramVideoSprite) {}
  
  public void run()
  {
    if ((this.this$0.g) && (this.this$0.a != null) && (!this.this$0.a.isPlaying())) {
      this.this$0.a.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.6
 * JD-Core Version:    0.7.0.1
 */