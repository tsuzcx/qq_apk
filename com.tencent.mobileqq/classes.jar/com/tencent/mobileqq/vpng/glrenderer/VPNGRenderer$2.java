package com.tencent.mobileqq.vpng.glrenderer;

import android.opengl.GLES20;

class VPNGRenderer$2
  implements Runnable
{
  VPNGRenderer$2(VPNGRenderer paramVPNGRenderer) {}
  
  public void run()
  {
    GLES20.glDeleteTextures(VPNGRenderer.a(this.this$0).length, VPNGRenderer.a(this.this$0), 0);
    GLES20.glDeleteProgram(VPNGRenderer.a(this.this$0));
    GLES20.glFlush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer.2
 * JD-Core Version:    0.7.0.1
 */