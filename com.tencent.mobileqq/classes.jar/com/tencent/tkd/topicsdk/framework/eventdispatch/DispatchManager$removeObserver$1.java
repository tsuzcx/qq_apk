package com.tencent.tkd.topicsdk.framework.eventdispatch;

import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class DispatchManager$removeObserver$1
  extends Lambda
  implements Function0<Unit>
{
  DispatchManager$removeObserver$1(Class paramClass, IEventObserver paramIEventObserver)
  {
    super(0);
  }
  
  public final void invoke()
  {
    ArrayList localArrayList = (ArrayList)DispatchManager.a(DispatchManager.a).get(this.$eventCls);
    if (localArrayList != null) {
      localArrayList.remove(this.$observer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager.removeObserver.1
 * JD-Core Version:    0.7.0.1
 */