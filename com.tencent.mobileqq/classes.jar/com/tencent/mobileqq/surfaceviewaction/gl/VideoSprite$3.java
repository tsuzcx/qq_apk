package com.tencent.mobileqq.surfaceviewaction.gl;

import android.media.MediaPlayer;

class VideoSprite$3
  implements Runnable
{
  VideoSprite$3(VideoSprite paramVideoSprite) {}
  
  public void run()
  {
    if ((this.this$0.ah) && (this.this$0.ac != null) && (!this.this$0.ac.isPlaying())) {
      this.this$0.ac.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.3
 * JD-Core Version:    0.7.0.1
 */