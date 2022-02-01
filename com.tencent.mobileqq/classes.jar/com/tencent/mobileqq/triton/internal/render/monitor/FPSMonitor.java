package com.tencent.mobileqq.triton.internal.render.monitor;

import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.utils.Utils;
import com.tencent.mobileqq.triton.render.RenderContext.SwapListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/render/monitor/FPSMonitor;", "Lcom/tencent/mobileqq/triton/render/RenderContext$SwapListener;", "fpsHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;)V", "fpsCount", "", "lastTime", "", "onSwap", "", "Triton_release"}, k=1, mv={1, 1, 16})
public final class FPSMonitor
  implements RenderContext.SwapListener
{
  private int fpsCount;
  private final ValueHolder<Float> fpsHolder;
  private long lastTime;
  
  public FPSMonitor(@NotNull ValueHolder<Float> paramValueHolder)
  {
    this.fpsHolder = paramValueHolder;
  }
  
  public void onSwap()
  {
    this.fpsCount += 1;
    long l1 = Utils.timeStamp();
    long l2 = l1 - this.lastTime;
    if (l2 >= 1000)
    {
      this.fpsHolder.setValue(Float.valueOf(this.fpsCount * 1000.0F / (float)l2));
      this.fpsCount = 0;
      this.lastTime = l1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.render.monitor.FPSMonitor
 * JD-Core Version:    0.7.0.1
 */