package com.tencent.mobileqq.triton.view;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/view/GameView;", "", "displayDensity", "", "getDisplayDensity", "()F", "height", "", "getHeight", "()I", "width", "getWidth", "onSwapBuffer", "", "setGameOnTouchListener", "listener", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "Lkotlin/ParameterName;", "name", "event", "", "setSurfaceCallback", "surfaceCallback", "Lcom/tencent/mobileqq/triton/view/GameView$SurfaceCallback;", "Companion", "SurfaceCallback", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface GameView
{
  public static final GameView.Companion Companion = GameView.Companion.$$INSTANCE;
  
  public abstract float getDisplayDensity();
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  public abstract void onSwapBuffer();
  
  public abstract void setGameOnTouchListener(@Nullable Function1<? super MotionEvent, Boolean> paramFunction1);
  
  public abstract void setSurfaceCallback(@Nullable GameView.SurfaceCallback paramSurfaceCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.view.GameView
 * JD-Core Version:    0.7.0.1
 */