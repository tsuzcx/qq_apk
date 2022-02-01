package com.tencent.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import android.support.annotation.Nullable;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.tmediacodec.util.LogUtils;

class THookTextureView$1
  implements TextureView.SurfaceTextureListener
{
  THookTextureView$1(THookTextureView paramTHookTextureView) {}
  
  public void onSurfaceTextureAvailable(@Nullable SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (THookTextureView.access$000(this.this$0) != null) {
      THookTextureView.access$000(this.this$0).onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public boolean onSurfaceTextureDestroyed(@Nullable SurfaceTexture paramSurfaceTexture)
  {
    Object localObject = THookTextureView.access$000(this.this$0);
    boolean bool3 = false;
    boolean bool1;
    if ((localObject != null) && (!THookTextureView.access$000(this.this$0).onSurfaceTextureDestroyed(paramSurfaceTexture))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if (THookTextureView.access$100() != null)
    {
      boolean bool2 = bool3;
      if (bool1)
      {
        bool2 = bool3;
        if (THookTextureView.access$100().onSurfaceTextureDestroyedCalled(paramSurfaceTexture)) {
          bool2 = true;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("onSurfaceTextureDestroyed surfaceTexture:");
      ((StringBuilder)localObject).append(paramSurfaceTexture);
      ((StringBuilder)localObject).append(" hookResult:");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append("result:");
      ((StringBuilder)localObject).append(bool1);
      LogUtils.d("THookTextureView", ((StringBuilder)localObject).toString());
      return bool2;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(", onSurfaceTextureDestroyed surfaceTexture:");
    ((StringBuilder)localObject).append(paramSurfaceTexture);
    ((StringBuilder)localObject).append(" result:");
    ((StringBuilder)localObject).append(bool1);
    LogUtils.d("THookTextureView", ((StringBuilder)localObject).toString());
    return bool1;
  }
  
  public void onSurfaceTextureSizeChanged(@Nullable SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (THookTextureView.access$000(this.this$0) != null) {
      THookTextureView.access$000(this.this$0).onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceTextureUpdated(@Nullable SurfaceTexture paramSurfaceTexture)
  {
    if (THookTextureView.access$000(this.this$0) != null) {
      THookTextureView.access$000(this.this$0).onSurfaceTextureUpdated(paramSurfaceTexture);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.THookTextureView.1
 * JD-Core Version:    0.7.0.1
 */