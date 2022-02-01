package com.tencent.mobileqq.shortvideo.mediadevice;

import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

public class SurfacePreviewContext
  extends PreviewContext
  implements SurfaceHolder.Callback, CameraProxy.CameraProxyCallBack
{
  public SurfacePreviewContext(CameraProxy paramCameraProxy, int paramInt1, int paramInt2)
  {
    super(paramCameraProxy, paramInt1, paramInt2);
  }
  
  public void a(byte[] paramArrayOfByte, Camera paramCamera)
  {
    getPreviewFrame(paramArrayOfByte, paramCamera);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mCamera.a(paramInt1, paramInt2, paramInt3);
    this.mCamera.a(null, paramSurfaceHolder, this, true);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.mCamera.a();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (this.mCamera != null)
    {
      this.mCamera.b();
      this.mCamera.b(true);
      if (this.mActivtiyDestory) {
        this.mCamera = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.SurfacePreviewContext
 * JD-Core Version:    0.7.0.1
 */