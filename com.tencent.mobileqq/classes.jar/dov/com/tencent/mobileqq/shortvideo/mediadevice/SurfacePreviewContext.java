package dov.com.tencent.mobileqq.shortvideo.mediadevice;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;

public class SurfacePreviewContext
  extends PreviewContext
  implements Camera.PreviewCallback, SurfaceHolder.Callback
{
  public SurfacePreviewContext(CameraProxy paramCameraProxy, int paramInt1, int paramInt2)
  {
    super(paramCameraProxy, paramInt1, paramInt2);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.mediadevice.SurfacePreviewContext
 * JD-Core Version:    0.7.0.1
 */