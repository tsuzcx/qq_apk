package com.tencent.mobileqq.vpng.glrenderer;

import android.opengl.GLES20;

class VPNGRenderer$3
  implements Runnable
{
  VPNGRenderer$3(VPNGRenderer paramVPNGRenderer) {}
  
  public void run()
  {
    GLES20.glDeleteTextures(VPNGRenderer.e(this.this$0).length, VPNGRenderer.e(this.this$0), 0);
    GLES20.glDeleteProgram(VPNGRenderer.f(this.this$0));
    GLES20.glFlush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer.3
 * JD-Core Version:    0.7.0.1
 */