package com.tencent.tkd.topicsdk.framework.eventdispatch;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEvent;", "invoke"}, k=3, mv={1, 1, 16})
final class DispatchManager$dispatchEvent$1
  extends Lambda
  implements Function0<Unit>
{
  DispatchManager$dispatchEvent$1(IEvent paramIEvent)
  {
    super(0);
  }
  
  public final void invoke()
  {
    DispatchManager.a(DispatchManager.a, this.$event);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager.dispatchEvent.1
 * JD-Core Version:    0.7.0.1
 */