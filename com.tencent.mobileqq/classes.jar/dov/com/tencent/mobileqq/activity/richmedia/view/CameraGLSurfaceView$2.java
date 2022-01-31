package dov.com.tencent.mobileqq.activity.richmedia.view;

import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

class CameraGLSurfaceView$2
  implements Runnable
{
  CameraGLSurfaceView$2(CameraGLSurfaceView paramCameraGLSurfaceView) {}
  
  public void run()
  {
    CameraGLSurfaceView.a(this.this$0).sendFirstFrameMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView.2
 * JD-Core Version:    0.7.0.1
 */