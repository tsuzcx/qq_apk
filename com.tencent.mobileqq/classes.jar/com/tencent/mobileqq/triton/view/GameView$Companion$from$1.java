package com.tencent.mobileqq.triton.view;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnTouchListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/view/GameView$Companion$from$1", "Lcom/tencent/mobileqq/triton/view/GameView;", "_format", "", "_height", "_width", "displayDensity", "", "getDisplayDensity", "()F", "height", "getHeight", "()I", "surfaceCallback", "Lcom/tencent/mobileqq/triton/view/GameView$SurfaceCallback;", "width", "getWidth", "setGameOnTouchListener", "", "listener", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "Lkotlin/ParameterName;", "name", "event", "", "setSurfaceCallback", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class GameView$Companion$from$1
  implements GameView
{
  private int _format;
  private int _height;
  private int _width;
  private GameView.SurfaceCallback surfaceCallback;
  
  GameView$Companion$from$1(SurfaceView paramSurfaceView)
  {
    paramSurfaceView.getHolder().addCallback((SurfaceHolder.Callback)new GameView.Companion.from.1.1(this));
  }
  
  public float getDisplayDensity()
  {
    Resources localResources = this.$surfaceView.getResources();
    Intrinsics.checkExpressionValueIsNotNull(localResources, "surfaceView.resources");
    return localResources.getDisplayMetrics().density;
  }
  
  public int getHeight()
  {
    return this._height;
  }
  
  public int getWidth()
  {
    return this._width;
  }
  
  public void onSwapBuffer()
  {
    GameView.DefaultImpls.onSwapBuffer(this);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void setGameOnTouchListener(@Nullable Function1<? super MotionEvent, Boolean> paramFunction1)
  {
    SurfaceView localSurfaceView = this.$surfaceView;
    if (paramFunction1 != null) {}
    for (paramFunction1 = (View.OnTouchListener)new GameView.Companion.from.1.setGameOnTouchListener.1.1(paramFunction1);; paramFunction1 = null)
    {
      localSurfaceView.setOnTouchListener(paramFunction1);
      return;
    }
  }
  
  public void setSurfaceCallback(@Nullable GameView.SurfaceCallback paramSurfaceCallback)
  {
    this.surfaceCallback = paramSurfaceCallback;
    if (paramSurfaceCallback != null)
    {
      Object localObject = this.$surfaceView.getHolder();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "surfaceView.holder");
      localObject = ((SurfaceHolder)localObject).getSurface();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "surfaceView.holder.surface");
      if (((Surface)localObject).isValid())
      {
        if (this._format == 0)
        {
          this._format = 1;
          this._width = this.$surfaceView.getWidth();
          this._height = this.$surfaceView.getHeight();
        }
        localObject = this.$surfaceView.getHolder();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "surfaceView.holder");
        localObject = ((SurfaceHolder)localObject).getSurface();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "surfaceView.holder.surface");
        paramSurfaceCallback.onSurfaceCreated((Surface)localObject);
        localObject = this.$surfaceView.getHolder();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "surfaceView.holder");
        localObject = ((SurfaceHolder)localObject).getSurface();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "surfaceView.holder.surface");
        paramSurfaceCallback.onSurfaceChanged((Surface)localObject, this._format, this._width, this._height);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.view.GameView.Companion.from.1
 * JD-Core Version:    0.7.0.1
 */