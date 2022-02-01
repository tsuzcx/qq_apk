package dov.com.qq.im.ae.camera.core;

import dov.com.qq.im.ae.camera.AEVideoCaptureResult;

class AECameraGLSurfaceView$5
  implements Runnable
{
  AECameraGLSurfaceView$5(AECameraGLSurfaceView paramAECameraGLSurfaceView, AEVideoCaptureResult paramAEVideoCaptureResult) {}
  
  public void run()
  {
    this.this$0.captureListener.onVideoCaptured(this.val$videoCaptureResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.5
 * JD-Core Version:    0.7.0.1
 */