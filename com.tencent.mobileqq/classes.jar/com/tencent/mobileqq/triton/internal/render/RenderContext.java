package com.tencent.mobileqq.triton.internal.render;

import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import com.tencent.mobileqq.triton.statistic.FrameCallback;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/render/RenderContext;", "", "()V", "accomulatedDrawCalls", "", "getAccomulatedDrawCalls", "()J", "accomulatedFrames", "getAccomulatedFrames", "currentFPS", "", "getCurrentFPS", "()F", "targetFPS", "", "getTargetFPS", "()I", "setFrameCallback", "", "frameCallback", "Lcom/tencent/mobileqq/triton/statistic/FrameCallback;", "takeScreenShot", "callback", "Lcom/tencent/mobileqq/triton/engine/ScreenShotCallback;", "Triton_release"}, k=1, mv={1, 1, 16})
public final class RenderContext
{
  public final long getAccomulatedDrawCalls()
  {
    throw ((Throwable)new NotImplementedError(null, 1, null));
  }
  
  public final long getAccomulatedFrames()
  {
    throw ((Throwable)new NotImplementedError(null, 1, null));
  }
  
  public final float getCurrentFPS()
  {
    throw ((Throwable)new NotImplementedError(null, 1, null));
  }
  
  public final int getTargetFPS()
  {
    throw ((Throwable)new NotImplementedError(null, 1, null));
  }
  
  public final void setFrameCallback(@Nullable FrameCallback paramFrameCallback) {}
  
  public final void takeScreenShot(@NotNull ScreenShotCallback paramScreenShotCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramScreenShotCallback, "callback");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.render.RenderContext
 * JD-Core Version:    0.7.0.1
 */