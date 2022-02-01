package dov.com.qq.im.ae.camera.core;

import dov.com.qq.im.ae.camera.AEVideoCaptureResult;

class AECameraGLSurfaceView$7
  implements Runnable
{
  AECameraGLSurfaceView$7(AECameraGLSurfaceView paramAECameraGLSurfaceView, AEVideoCaptureResult paramAEVideoCaptureResult) {}
  
  public void run()
  {
    this.this$0.captureListener.onVideoCaptured(this.val$videoCaptureResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.7
 * JD-Core Version:    0.7.0.1
 */