package com.tencent.mobileqq.triton.internal.render.monitor;

import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.render.RenderContext.SwapListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/render/monitor/FirstScreenMonitor;", "Lcom/tencent/mobileqq/triton/render/RenderContext$SwapListener;", "firstFameHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "", "accumulatedDrawCallHolder", "", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;)V", "isFirstScreen", "onSwap", "", "Triton_release"}, k=1, mv={1, 1, 16})
public final class FirstScreenMonitor
  implements RenderContext.SwapListener
{
  private final ValueHolder<Long> accumulatedDrawCallHolder;
  private final ValueHolder<Boolean> firstFameHolder;
  private boolean isFirstScreen;
  
  public FirstScreenMonitor(@NotNull ValueHolder<Boolean> paramValueHolder, @NotNull ValueHolder<Long> paramValueHolder1)
  {
    this.firstFameHolder = paramValueHolder;
    this.accumulatedDrawCallHolder = paramValueHolder1;
    this.isFirstScreen = true;
  }
  
  public void onSwap()
  {
    if ((this.isFirstScreen) && (((Number)this.accumulatedDrawCallHolder.getValue()).longValue() > 0L))
    {
      this.isFirstScreen = false;
      this.firstFameHolder.setValue(Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.render.monitor.FirstScreenMonitor
 * JD-Core Version:    0.7.0.1
 */