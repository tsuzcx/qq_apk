package com.tencent.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tmediacodec/hook/THookTextureView$mInnerSetListener$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class THookTextureView$mInnerSetListener$1
  implements TextureView.SurfaceTextureListener
{
  public void onSurfaceTextureAvailable(@Nullable SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    TextureView.SurfaceTextureListener localSurfaceTextureListener = THookTextureView.access$getMOutSetListener$p(this.this$0);
    if (localSurfaceTextureListener != null) {
      localSurfaceTextureListener.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public boolean onSurfaceTextureDestroyed(@Nullable SurfaceTexture paramSurfaceTexture)
  {
    Object localObject = THookTextureView.access$getMOutSetListener$p(this.this$0);
    if (localObject != null) {}
    for (boolean bool = ((TextureView.SurfaceTextureListener)localObject).onSurfaceTextureDestroyed(paramSurfaceTexture);; bool = true)
    {
      localObject = THookTextureView.Companion.getHookCallback();
      if (localObject != null) {
        bool = ((THookTextureView.SurfaceTextureHookCallback)localObject).onSurfaceTextureDestroyedCalled(paramSurfaceTexture);
      }
      return bool;
    }
  }
  
  public void onSurfaceTextureSizeChanged(@Nullable SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    TextureView.SurfaceTextureListener localSurfaceTextureListener = THookTextureView.access$getMOutSetListener$p(this.this$0);
    if (localSurfaceTextureListener != null) {
      localSurfaceTextureListener.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceTextureUpdated(@Nullable SurfaceTexture paramSurfaceTexture)
  {
    TextureView.SurfaceTextureListener localSurfaceTextureListener = THookTextureView.access$getMOutSetListener$p(this.this$0);
    if (localSurfaceTextureListener != null) {
      localSurfaceTextureListener.onSurfaceTextureUpdated(paramSurfaceTexture);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.THookTextureView.mInnerSetListener.1
 * JD-Core Version:    0.7.0.1
 */