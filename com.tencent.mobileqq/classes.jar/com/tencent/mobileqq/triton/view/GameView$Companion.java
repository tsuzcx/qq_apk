package com.tencent.mobileqq.triton.view;

import android.view.SurfaceView;
import android.view.TextureView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/view/GameView$Companion;", "", "()V", "from", "Lcom/tencent/mobileqq/triton/view/GameView;", "surfaceView", "Landroid/view/SurfaceView;", "textureView", "Landroid/view/TextureView;", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class GameView$Companion
{
  @NotNull
  public final GameView from(@NotNull SurfaceView paramSurfaceView)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceView, "surfaceView");
    return (GameView)new GameView.Companion.from.1(paramSurfaceView);
  }
  
  @NotNull
  public final GameView from(@NotNull TextureView paramTextureView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextureView, "textureView");
    return (GameView)new GameView.Companion.from.2(paramTextureView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.view.GameView.Companion
 * JD-Core Version:    0.7.0.1
 */