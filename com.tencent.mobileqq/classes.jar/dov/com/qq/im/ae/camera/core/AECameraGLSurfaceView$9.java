package dov.com.qq.im.ae.camera.core;

import dov.com.qq.im.ae.camera.AEVideoCaptureResult;

class AECameraGLSurfaceView$9
  implements Runnable
{
  AECameraGLSurfaceView$9(AECameraGLSurfaceView paramAECameraGLSurfaceView, AEVideoCaptureResult paramAEVideoCaptureResult) {}
  
  public void run()
  {
    this.this$0.captureListener.onVideoCaptured(this.val$videoCaptureResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.9
 * JD-Core Version:    0.7.0.1
 */