package com.tencent.mobileqq.vpng.glrenderer;

import android.opengl.GLES20;
import bicm;

public class VPNGRenderer$2
  implements Runnable
{
  public VPNGRenderer$2(bicm parambicm) {}
  
  public void run()
  {
    GLES20.glDeleteTextures(bicm.a(this.this$0).length, bicm.a(this.this$0), 0);
    GLES20.glDeleteProgram(bicm.a(this.this$0));
    GLES20.glFlush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer.2
 * JD-Core Version:    0.7.0.1
 */