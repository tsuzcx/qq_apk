package com.tencent.mobileqq.qqlive.view;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;

class TPTextureView$1
  implements TextureView.SurfaceTextureListener
{
  TPTextureView$1(TPTextureView paramTPTextureView) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (TPTextureView.a(this.a) != null) {
      TPTextureView.a(this.a).a(paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    if (TPTextureView.a(this.a) != null) {
      TPTextureView.a(this.a).a(paramSurfaceTexture);
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (TPTextureView.a(this.a) != null) {
      TPTextureView.a(this.a).b(paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    if (TPTextureView.a(this.a) != null) {
      TPTextureView.a(this.a).b(paramSurfaceTexture, this.a.getWidth(), this.a.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.view.TPTextureView.1
 * JD-Core Version:    0.7.0.1
 */