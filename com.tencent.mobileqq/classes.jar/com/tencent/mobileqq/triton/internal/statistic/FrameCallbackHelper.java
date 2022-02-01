package com.tencent.mobileqq.triton.internal.statistic;

import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.utils.Utils;
import com.tencent.mobileqq.triton.statistic.FrameCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/statistic/FrameCallbackHelper;", "", "frameCallback", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Lcom/tencent/mobileqq/triton/statistic/FrameCallback;", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;)V", "drawBeginTime", "", "frameBeginDrawingTime", "isFirstFrame", "", "onFrameBegin", "", "drawingTime", "onFrameEnd", "Triton_release"}, k=1, mv={1, 1, 16})
public final class FrameCallbackHelper
{
  private long drawBeginTime;
  private long frameBeginDrawingTime;
  private final ValueHolder<FrameCallback> frameCallback;
  private boolean isFirstFrame;
  
  public FrameCallbackHelper(@NotNull ValueHolder<FrameCallback> paramValueHolder)
  {
    this.frameCallback = paramValueHolder;
    this.isFirstFrame = true;
  }
  
  public final void onFrameBegin(long paramLong)
  {
    this.drawBeginTime = Utils.nanoTime();
    FrameCallback localFrameCallback = (FrameCallback)this.frameCallback.getValue();
    if (localFrameCallback != null) {
      localFrameCallback.onFrameBegin(paramLong, this.isFirstFrame);
    }
    this.isFirstFrame = false;
    this.frameBeginDrawingTime = paramLong;
  }
  
  public final void onFrameEnd()
  {
    FrameCallback localFrameCallback = (FrameCallback)this.frameCallback.getValue();
    if (localFrameCallback != null) {
      localFrameCallback.onFrameEnd(this.frameBeginDrawingTime, Utils.nanoTime() - this.drawBeginTime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.statistic.FrameCallbackHelper
 * JD-Core Version:    0.7.0.1
 */