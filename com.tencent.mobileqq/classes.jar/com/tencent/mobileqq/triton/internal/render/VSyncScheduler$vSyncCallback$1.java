package com.tencent.mobileqq.triton.internal.render;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/internal/render/VSyncScheduler$vSyncCallback$1", "Landroid/view/Choreographer$FrameCallback;", "doFrame", "", "frameTimeNanos", "", "Triton_release"}, k=1, mv={1, 1, 16})
public final class VSyncScheduler$vSyncCallback$1
  implements Choreographer.FrameCallback
{
  public void doFrame(long paramLong)
  {
    if (VSyncScheduler.access$getPendingVSyncCount$p(this.this$0).get() < 1)
    {
      VSyncScheduler.access$getPendingVSyncCount$p(this.this$0).incrementAndGet();
      VSyncScheduler.access$getScheduleExecutor$p(this.this$0).execute(VSyncScheduler.access$getCallbackMainLoop$p(this.this$0));
    }
    Choreographer.getInstance().postFrameCallback((Choreographer.FrameCallback)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.render.VSyncScheduler.vSyncCallback.1
 * JD-Core Version:    0.7.0.1
 */