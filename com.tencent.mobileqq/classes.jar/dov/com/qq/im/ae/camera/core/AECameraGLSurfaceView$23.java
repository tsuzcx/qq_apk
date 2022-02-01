package dov.com.qq.im.ae.camera.core;

import dov.com.qq.im.ae.camera.filter.AEFilterProcessTex;

class AECameraGLSurfaceView$23
  implements Runnable
{
  AECameraGLSurfaceView$23(AECameraGLSurfaceView paramAECameraGLSurfaceView, int paramInt) {}
  
  public void run()
  {
    AEFilterProcessTex localAEFilterProcessTex = (AEFilterProcessTex)AECameraGLSurfaceView.access$000(this.this$0);
    if (localAEFilterProcessTex != null) {
      localAEFilterProcessTex.a(this.val$level);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.23
 * JD-Core Version:    0.7.0.1
 */