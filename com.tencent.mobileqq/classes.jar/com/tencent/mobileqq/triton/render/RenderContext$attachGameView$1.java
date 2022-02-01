package com.tencent.mobileqq.triton.render;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle.DefaultImpls;
import com.tencent.mobileqq.triton.view.GameView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/render/RenderContext$attachGameView$1", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "onDestroy", "", "Triton_release"}, k=1, mv={1, 1, 16})
public final class RenderContext$attachGameView$1
  implements LifeCycle
{
  RenderContext$attachGameView$1(GameView paramGameView) {}
  
  public void onDestroy()
  {
    this.$gameView.setGameOnTouchListener(null);
    this.$gameView.setSurfaceCallback(null);
  }
  
  public void onFirstFrame()
  {
    LifeCycle.DefaultImpls.onFirstFrame(this);
  }
  
  public void onGameLaunched(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    LifeCycle.DefaultImpls.onGameLaunched(this, paramTritonEngine);
  }
  
  public void onStart()
  {
    LifeCycle.DefaultImpls.onStart(this);
  }
  
  public void onStop()
  {
    LifeCycle.DefaultImpls.onStop(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.RenderContext.attachGameView.1
 * JD-Core Version:    0.7.0.1
 */