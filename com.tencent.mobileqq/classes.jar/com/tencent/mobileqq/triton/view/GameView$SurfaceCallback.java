package com.tencent.mobileqq.triton.view;

import android.view.Surface;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/view/GameView$SurfaceCallback;", "", "onSurfaceChanged", "", "surface", "Landroid/view/Surface;", "format", "", "width", "height", "onSurfaceCreated", "onSurfaceDestroyed", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface GameView$SurfaceCallback
{
  public abstract void onSurfaceChanged(@NotNull Surface paramSurface, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onSurfaceCreated(@NotNull Surface paramSurface);
  
  public abstract void onSurfaceDestroyed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.view.GameView.SurfaceCallback
 * JD-Core Version:    0.7.0.1
 */