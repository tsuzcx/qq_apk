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
    String str = SPlayerTextureView.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SPlayerTextureView = ");
    localStringBuilder.append(System.identityHashCode(this.this$0));
    localStringBuilder.append(", onSurfaceTextureAvailable() surface = ");
    localStringBuilder.append(paramSurfaceTexture.toString());
    localStringBuilder.append(" width = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height=");
    localStringBuilder.append(paramInt2);
    LogUtil.i(str, localStringBuilder.toString());
    if (SPlayerTextureView.access$100(this.this$0) != null) {
      SPlayerTextureView.access$100(this.this$0).onViewCreated(paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    String str2 = SPlayerTextureView.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SPlayerTextureView = ");
    localStringBuilder.append(System.identityHashCode(this.this$0));
    localStringBuilder.append(", onSurfaceTextureDestroyed() surface = ");
    String str1;
    if (paramSurfaceTexture != null) {
      str1 = paramSurfaceTexture.toString();
    } else {
      str1 = "null";
    }
    localStringBuilder.append(str1);
    LogUtil.i(str2, localStringBuilder.toString());
    return (SPlayerTextureView.access$100(this.this$0) == null) || (SPlayerTextureView.access$100(this.this$0).onViewDestroyed(paramSurfaceTexture));
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    String str = SPlayerTextureView.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SPlayerTextureView = ");
    localStringBuilder.append(System.identityHashCode(this.this$0));
    localStringBuilder.append(", onSurfaceTextureSizeChanged() surface = ");
    localStringBuilder.append(paramSurfaceTexture.toString());
    localStringBuilder.append(" width = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height=");
    localStringBuilder.append(paramInt2);
    LogUtil.i(str, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.view.SPlayerTextureView.1
 * JD-Core Version:    0.7.0.1
 */