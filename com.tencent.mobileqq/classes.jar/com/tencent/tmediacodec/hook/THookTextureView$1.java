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
    boolean bool2 = true;
    boolean bool1;
    if ((THookTextureView.access$000(this.this$0) == null) || (THookTextureView.access$000(this.this$0).onSurfaceTextureDestroyed(paramSurfaceTexture)))
    {
      bool1 = true;
      if (THookTextureView.access$100() == null) {
        break label110;
      }
      if ((!bool1) || (!THookTextureView.access$100().onSurfaceTextureDestroyedCalled(paramSurfaceTexture))) {
        break label105;
      }
    }
    for (;;)
    {
      LogUtils.d("THookTextureView", this + "onSurfaceTextureDestroyed surfaceTexture:" + paramSurfaceTexture + " hookResult:" + bool2 + "result:" + bool1);
      return bool2;
      bool1 = false;
      break;
      label105:
      bool2 = false;
    }
    label110:
    LogUtils.d("THookTextureView", this + ", onSurfaceTextureDestroyed surfaceTexture:" + paramSurfaceTexture + " result:" + bool1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.THookTextureView.1
 * JD-Core Version:    0.7.0.1
 */