package com.tencent.mobileqq.vpng.glrenderer;

import android.opengl.GLES20;
import bbzy;

public class VPNGRenderer$2
  implements Runnable
{
  public VPNGRenderer$2(bbzy parambbzy) {}
  
  public void run()
  {
    GLES20.glDeleteTextures(bbzy.a(this.this$0).length, bbzy.a(this.this$0), 0);
    GLES20.glDeleteProgram(bbzy.a(this.this$0));
    GLES20.glFlush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer.2
 * JD-Core Version:    0.7.0.1
 */