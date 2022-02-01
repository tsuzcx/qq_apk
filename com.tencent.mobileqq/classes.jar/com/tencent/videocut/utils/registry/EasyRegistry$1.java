package com.tencent.videocut.utils.registry;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "ListenerType", "Params", "o1", "o2", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k=3, mv={1, 4, 2})
final class EasyRegistry$1<T>
  implements Comparator<ListenerType>
{
  public final int compare(ListenerType paramListenerType1, ListenerType paramListenerType2)
  {
    Comparator localComparator = EasyRegistry.a(this.a);
    Intrinsics.checkNotNull(localComparator);
    return localComparator.compare(paramListenerType1, paramListenerType2) * -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.registry.EasyRegistry.1
 * JD-Core Version:    0.7.0.1
 */