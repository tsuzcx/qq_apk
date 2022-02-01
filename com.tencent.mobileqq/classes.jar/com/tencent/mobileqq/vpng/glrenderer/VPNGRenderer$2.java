package com.tencent.mobileqq.vpng.glrenderer;

import android.opengl.GLES20;
import bgrw;

public class VPNGRenderer$2
  implements Runnable
{
  public VPNGRenderer$2(bgrw parambgrw) {}
  
  public void run()
  {
    GLES20.glDeleteTextures(bgrw.a(this.this$0).length, bgrw.a(this.this$0), 0);
    GLES20.glDeleteProgram(bgrw.a(this.this$0));
    GLES20.glFlush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer.2
 * JD-Core Version:    0.7.0.1
 */