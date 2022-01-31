package com.tencent.mobileqq.shortvideo.mediadevice;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.view.TextureView.SurfaceTextureListener;

@TargetApi(14)
public class TexturePreviewContext
  extends PreviewContext
  implements Camera.PreviewCallback, TextureView.SurfaceTextureListener
{
  public TexturePreviewContext(CameraProxy paramCameraProxy, int paramInt1, int paramInt2)
  {
    super(paramCameraProxy, paramInt1, paramInt2);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    getPreviewFrame(paramArrayOfByte, paramCamera);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mCamera.a();
    this.mCamera.a(0, paramInt1, paramInt2);
    this.mCamera.a(paramSurfaceTexture, null, this, true);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    if (this.mCamera != null)
    {
      this.mCamera.b();
      this.mCamera.b(true);
      if (this.mActivtiyDestory) {
        this.mCamera = null;
      }
    }
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.TexturePreviewContext
 * JD-Core Version:    0.7.0.1
 */