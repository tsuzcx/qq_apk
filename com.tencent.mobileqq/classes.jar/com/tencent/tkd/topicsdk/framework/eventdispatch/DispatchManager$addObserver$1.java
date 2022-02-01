package com.tencent.tkd.topicsdk.framework.eventdispatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class DispatchManager$addObserver$1
  extends Lambda
  implements Function0<Unit>
{
  DispatchManager$addObserver$1(Class paramClass, IEventObserver paramIEventObserver)
  {
    super(0);
  }
  
  public final void invoke()
  {
    ArrayList localArrayList2 = (ArrayList)DispatchManager.a(DispatchManager.a).get(this.$eventCls);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      ((Map)DispatchManager.a(DispatchManager.a)).put(this.$eventCls, localArrayList1);
    }
    if (!localArrayList1.contains(this.$observer)) {
      localArrayList1.add(this.$observer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager.addObserver.1
 * JD-Core Version:    0.7.0.1
 */