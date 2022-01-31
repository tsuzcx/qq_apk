package com.tencent.superplayer.view;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.superplayer.utils.LogUtil;

class SPlayerTextureView$1
  implements TextureView.SurfaceTextureListener
{
  SPlayerTextureView$1(SPlayerTextureView paramSPlayerTextureView) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    LogUtil.i(SPlayerTextureView.access$000(), "FCCTextureView = " + System.identityHashCode(this.this$0) + ", onSurfaceTextureAvailable() surface = " + paramSurfaceTexture.toString() + " width = " + paramInt1 + ", height=" + paramInt2);
    if (SPlayerTextureView.access$100(this.this$0) != null) {
      SPlayerTextureView.access$100(this.this$0).onViewCreated(paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    LogUtil.i(SPlayerTextureView.access$000(), "FCCTextureView = " + System.identityHashCode(this.this$0) + ", onSurfaceTextureDestroyed() surface = " + paramSurfaceTexture.toString());
    return (SPlayerTextureView.access$100(this.this$0) == null) || (SPlayerTextureView.access$100(this.this$0).onViewDestroyed(paramSurfaceTexture));
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    LogUtil.i(SPlayerTextureView.access$000(), "FCCTextureView = " + System.identityHashCode(this.this$0) + ", onSurfaceTextureSizeChanged() surface = " + paramSurfaceTexture.toString() + " width = " + paramInt1 + ", height=" + paramInt2);
    if (SPlayerTextureView.access$100(this.this$0) != null) {
      SPlayerTextureView.access$100(this.this$0).onViewChanged(paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    if (SPlayerTextureView.access$100(this.this$0) != null) {
      SPlayerTextureView.access$100(this.this$0).onViewChanged(paramSurfaceTexture, this.this$0.getWidth(), this.this$0.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.view.SPlayerTextureView.1
 * JD-Core Version:    0.7.0.1
 */