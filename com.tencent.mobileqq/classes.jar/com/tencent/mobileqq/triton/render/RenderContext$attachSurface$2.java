package com.tencent.mobileqq.triton.render;

import com.tencent.mobileqq.triton.view.GameView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/render/RenderContext$attachSurface$2", "Lcom/tencent/mobileqq/triton/render/RenderContext$SwapListener;", "onSwap", "", "Triton_release"}, k=1, mv={1, 1, 16})
public final class RenderContext$attachSurface$2
  implements RenderContext.SwapListener
{
  RenderContext$attachSurface$2(GameView paramGameView) {}
  
  public void onSwap()
  {
    this.$gameView.onSwapBuffer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.RenderContext.attachSurface.2
 * JD-Core Version:    0.7.0.1
 */