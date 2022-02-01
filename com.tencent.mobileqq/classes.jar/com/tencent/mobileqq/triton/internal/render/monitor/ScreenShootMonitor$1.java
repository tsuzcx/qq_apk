package com.tencent.mobileqq.triton.internal.render.monitor;

import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/triton/engine/ScreenShotCallback;", "invoke"}, k=3, mv={1, 1, 16})
final class ScreenShootMonitor$1
  extends Lambda
  implements Function1<ScreenShotCallback, Unit>
{
  ScreenShootMonitor$1(ScreenShootMonitor paramScreenShootMonitor)
  {
    super(1);
  }
  
  public final void invoke(@Nullable ScreenShotCallback paramScreenShotCallback)
  {
    if (paramScreenShotCallback != null)
    {
      ScreenShootMonitor.access$getScreenShotCallbackValueHolder$p(this.this$0).setValue(null);
      ScreenShootMonitor.access$getPendingCallback$p(this.this$0).add(paramScreenShotCallback);
      ScreenShootMonitor.access$setNeedTakeScreenShot$p(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.render.monitor.ScreenShootMonitor.1
 * JD-Core Version:    0.7.0.1
 */