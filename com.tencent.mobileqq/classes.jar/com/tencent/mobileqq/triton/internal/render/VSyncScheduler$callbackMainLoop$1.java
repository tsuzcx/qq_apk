package com.tencent.mobileqq.triton.internal.render;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VSyncScheduler$callbackMainLoop$1
  implements Runnable
{
  VSyncScheduler$callbackMainLoop$1(VSyncScheduler paramVSyncScheduler) {}
  
  public final void run()
  {
    VSyncScheduler.access$getPendingVSyncCount$p(this.this$0).decrementAndGet();
    long l2 = System.nanoTime();
    long l1;
    if (VSyncScheduler.access$getLastFrameTimeNanos$p(this.this$0) == 0L) {
      l1 = 0L;
    } else {
      l1 = l2 - VSyncScheduler.access$getLastFrameTimeNanos$p(this.this$0);
    }
    if ((l1 < 0L) || (VSyncScheduler.access$getRequestResetFrameDuration$p(this.this$0)))
    {
      VSyncScheduler.access$setRequestResetFrameDuration$p(this.this$0, false);
      l1 = VSyncScheduler.access$getDefaultFrameDuration(this.this$0);
    }
    VSyncScheduler.access$setLastFrameTimeNanos$p(this.this$0, l2);
    VSyncScheduler localVSyncScheduler = this.this$0;
    VSyncScheduler.access$setTotalDrawTimeNanos$p(localVSyncScheduler, VSyncScheduler.access$getTotalDrawTimeNanos$p(localVSyncScheduler) + l1);
    if (VSyncScheduler.access$getFpsStabilizer$p(this.this$0).shouldDoFrame(VSyncScheduler.access$getTotalDrawTimeNanos$p(this.this$0))) {
      VSyncScheduler.access$getVSyncListener$p(this.this$0).invoke(Long.valueOf(VSyncScheduler.access$getTotalDrawTimeNanos$p(this.this$0)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.render.VSyncScheduler.callbackMainLoop.1
 * JD-Core Version:    0.7.0.1
 */