package com.tencent.mobileqq.config.business.qflutter;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k=3, mv={1, 1, 16})
public final class QFlutterResConfig$Companion$from$$inlined$thenByDescending$1<T>
  implements Comparator<T>
{
  public QFlutterResConfig$Companion$from$$inlined$thenByDescending$1(Comparator paramComparator) {}
  
  public final int compare(T paramT1, T paramT2)
  {
    int i = this.a.compare(paramT1, paramT2);
    if (i != 0) {
      return i;
    }
    return ComparisonsKt.compareValues((Comparable)Long.valueOf(((QFlutterResConfig)paramT2).a()), (Comparable)Long.valueOf(((QFlutterResConfig)paramT1).a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.QFlutterResConfig.Companion.from..inlined.thenByDescending.1
 * JD-Core Version:    0.7.0.1
 */