package com.tencent.mobileqq.triton.render;

import android.view.Surface;
import com.tencent.mobileqq.triton.view.GameView;
import com.tencent.mobileqq.triton.view.GameView.SurfaceCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/render/RenderContext$attachSurface$1", "Lcom/tencent/mobileqq/triton/view/GameView$SurfaceCallback;", "onSurfaceChanged", "", "surface", "Landroid/view/Surface;", "format", "", "width", "height", "onSurfaceCreated", "onSurfaceDestroyed", "Triton_release"}, k=1, mv={1, 1, 16})
public final class RenderContext$attachSurface$1
  implements GameView.SurfaceCallback
{
  RenderContext$attachSurface$1(GameView paramGameView) {}
  
  public void onSurfaceChanged(@NotNull Surface paramSurface, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramSurface, "surface");
    this.this$0.surfaceChanged(paramSurface);
  }
  
  public void onSurfaceCreated(@NotNull Surface paramSurface)
  {
    Intrinsics.checkParameterIsNotNull(paramSurface, "surface");
    this.this$0.initRenderContext(this.$gameView, paramSurface);
  }
  
  public void onSurfaceDestroyed()
  {
    this.this$0.destroyRenderContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.RenderContext.attachSurface.1
 * JD-Core Version:    0.7.0.1
 */