package dov.com.qq.im.ae.camera.core;

import bnbe;

class AECameraGLSurfaceView$19
  implements Runnable
{
  AECameraGLSurfaceView$19(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void run()
  {
    if (AECameraGLSurfaceView.access$000(this.this$0) != null) {
      AECameraGLSurfaceView.access$000(this.this$0).a(true, AECameraGLSurfaceView.access$800(this.this$0), this.this$0);
    }
    this.this$0.requestRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.19
 * JD-Core Version:    0.7.0.1
 */