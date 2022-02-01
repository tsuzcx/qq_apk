package com.tencent.mobileqq.triton.internal.render;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class VSyncScheduler$1
  extends Lambda
  implements Function1<Float, Unit>
{
  VSyncScheduler$1(VSyncScheduler paramVSyncScheduler)
  {
    super(1);
  }
  
  public final void invoke(float paramFloat)
  {
    VSyncScheduler.access$getFpsStabilizer$p(this.this$0).setTargetFps(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.render.VSyncScheduler.1
 * JD-Core Version:    0.7.0.1
 */