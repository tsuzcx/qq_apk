package com.tencent.mobileqq.triton.view;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnTouchListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/view/GameView$Companion$from$2", "Lcom/tencent/mobileqq/triton/view/GameView;", "_surface", "Landroid/view/Surface;", "_surfaceTexture", "Landroid/graphics/SurfaceTexture;", "displayDensity", "", "getDisplayDensity", "()F", "height", "", "getHeight", "()I", "width", "getWidth", "setGameOnTouchListener", "", "listener", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "Lkotlin/ParameterName;", "name", "event", "", "setSurfaceCallback", "surfaceCallback", "Lcom/tencent/mobileqq/triton/view/GameView$SurfaceCallback;", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class GameView$Companion$from$2
  implements GameView
{
  private Surface _surface;
  private volatile SurfaceTexture _surfaceTexture;
  
  GameView$Companion$from$2(TextureView paramTextureView) {}
  
  public float getDisplayDensity()
  {
    Resources localResources = this.$textureView.getResources();
    Intrinsics.checkExpressionValueIsNotNull(localResources, "textureView.resources");
    return localResources.getDisplayMetrics().density;
  }
  
  public int getHeight()
  {
    return this.$textureView.getMeasuredHeight();
  }
  
  public int getWidth()
  {
    return this.$textureView.getMeasuredWidth();
  }
  
  public void onSwapBuffer()
  {
    GameView.DefaultImpls.onSwapBuffer(this);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void setGameOnTouchListener(@Nullable Function1<? super MotionEvent, Boolean> paramFunction1)
  {
    TextureView localTextureView = this.$textureView;
    if (paramFunction1 != null) {
      paramFunction1 = (View.OnTouchListener)new GameView.Companion.from.2.setGameOnTouchListener.1.1(paramFunction1);
    } else {
      paramFunction1 = null;
    }
    localTextureView.setOnTouchListener(paramFunction1);
  }
  
  public void setSurfaceCallback(@Nullable GameView.SurfaceCallback paramSurfaceCallback)
  {
    if (paramSurfaceCallback != null)
    {
      paramSurfaceCallback = new GameView.Companion.from.2.setSurfaceCallback.surfaceTextureListener.1(this, paramSurfaceCallback);
      this.$textureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)paramSurfaceCallback);
      if (this.$textureView.isAvailable())
      {
        SurfaceTexture localSurfaceTexture = this.$textureView.getSurfaceTexture();
        if (localSurfaceTexture == null) {
          Intrinsics.throwNpe();
        }
        paramSurfaceCallback.onSurfaceTextureAvailable(localSurfaceTexture, this.$textureView.getWidth(), this.$textureView.getHeight());
        localSurfaceTexture = this.$textureView.getSurfaceTexture();
        if (localSurfaceTexture == null) {
          Intrinsics.throwNpe();
        }
        paramSurfaceCallback.onSurfaceTextureSizeChanged(localSurfaceTexture, this.$textureView.getWidth(), this.$textureView.getHeight());
      }
    }
    else
    {
      this.$textureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.view.GameView.Companion.from.2
 * JD-Core Version:    0.7.0.1
 */