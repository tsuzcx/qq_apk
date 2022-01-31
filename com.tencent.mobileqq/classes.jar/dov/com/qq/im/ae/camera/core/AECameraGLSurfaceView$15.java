package dov.com.qq.im.ae.camera.core;

import bikj;

class AECameraGLSurfaceView$15
  implements Runnable
{
  AECameraGLSurfaceView$15(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void run()
  {
    if (AECameraGLSurfaceView.a(this.this$0) != null) {
      AECameraGLSurfaceView.a(this.this$0).a(true, AECameraGLSurfaceView.a(this.this$0), this.this$0);
    }
    this.this$0.requestRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.15
 * JD-Core Version:    0.7.0.1
 */