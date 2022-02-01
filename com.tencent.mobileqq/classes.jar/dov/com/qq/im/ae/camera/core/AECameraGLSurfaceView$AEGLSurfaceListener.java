package dov.com.qq.im.ae.camera.core;

import android.graphics.SurfaceTexture;

public abstract interface AECameraGLSurfaceView$AEGLSurfaceListener
{
  public abstract void onFirstFrameDone();
  
  public abstract void onOrientionChanged(int paramInt);
  
  public abstract void onPreviewSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void onPreviewSurfaceTextureCreate(SurfaceTexture paramSurfaceTexture);
  
  public abstract void onPreviewSurfaceTextureRelease();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.AEGLSurfaceListener
 * JD-Core Version:    0.7.0.1
 */