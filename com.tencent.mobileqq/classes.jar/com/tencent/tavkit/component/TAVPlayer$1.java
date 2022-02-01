package com.tencent.tavkit.component;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;

class TAVPlayer$1
  implements TextureView.SurfaceTextureListener
{
  private final String TAG = "GameTextureView@" + Integer.toHexString(hashCode());
  
  TAVPlayer$1(TAVPlayer paramTAVPlayer) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    paramSurfaceTexture = new Surface(paramSurfaceTexture);
    this.this$0.onSurfaceCreate(paramSurfaceTexture, paramInt2, paramInt1);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.this$0.onSurfaceDestory();
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.this$0.onSurfaceSizeChanged(paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVPlayer.1
 * JD-Core Version:    0.7.0.1
 */