package com.tencent.mobileqq.triton.view;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/view/GameView$Companion$from$2$setSurfaceCallback$surfaceTextureListener$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class GameView$Companion$from$2$setSurfaceCallback$surfaceTextureListener$1
  implements TextureView.SurfaceTextureListener
{
  GameView$Companion$from$2$setSurfaceCallback$surfaceTextureListener$1(GameView.SurfaceCallback paramSurfaceCallback) {}
  
  public void onSurfaceTextureAvailable(@NotNull SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceTexture, "surface");
    GameView.Companion.from.2.access$set_surfaceTexture$p(this.this$0, paramSurfaceTexture);
    paramSurfaceTexture = this.this$0;
    GameView.Companion.from.2.access$set_surface$p(paramSurfaceTexture, new Surface(GameView.Companion.from.2.access$get_surfaceTexture$p(paramSurfaceTexture)));
    paramSurfaceTexture = this.$surfaceCallback;
    Surface localSurface = GameView.Companion.from.2.access$get_surface$p(this.this$0);
    if (localSurface == null) {
      Intrinsics.throwNpe();
    }
    paramSurfaceTexture.onSurfaceCreated(localSurface);
  }
  
  public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture paramSurfaceTexture)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceTexture, "surface");
    GameView.Companion.from.2.access$set_surfaceTexture$p(this.this$0, (SurfaceTexture)null);
    GameView.Companion.from.2.access$set_surface$p(this.this$0, (Surface)null);
    this.$surfaceCallback.onSurfaceDestroyed();
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceTexture, "surface");
    paramSurfaceTexture = this.$surfaceCallback;
    Surface localSurface = GameView.Companion.from.2.access$get_surface$p(this.this$0);
    if (localSurface == null) {
      Intrinsics.throwNpe();
    }
    paramSurfaceTexture.onSurfaceChanged(localSurface, 1, paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(@NotNull SurfaceTexture paramSurfaceTexture)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceTexture, "surface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.view.GameView.Companion.from.2.setSurfaceCallback.surfaceTextureListener.1
 * JD-Core Version:    0.7.0.1
 */