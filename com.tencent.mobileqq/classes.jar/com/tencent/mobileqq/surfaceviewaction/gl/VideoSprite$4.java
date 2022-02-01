package com.tencent.mobileqq.surfaceviewaction.gl;

import android.opengl.GLES20;

class VideoSprite$4
  implements Runnable
{
  VideoSprite$4(VideoSprite paramVideoSprite) {}
  
  public void run()
  {
    GLES20.glDeleteTextures(this.this$0.a.length, this.this$0.a, 0);
    GLES20.glFlush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.4
 * JD-Core Version:    0.7.0.1
 */