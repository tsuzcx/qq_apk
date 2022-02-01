package shark.internal;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2", "shark/internal/DominatorTree$$special$$inlined$sortBy$1"}, k=3, mv={1, 4, 1})
public final class DominatorTree$buildFullDominatorTree$$inlined$forEach$lambda$1<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    long l = ((Number)paramT1).longValue();
    paramT1 = (Comparable)Integer.valueOf(-((DominatorTree.MutableDominatorNode)MapsKt.getValue(this.a, Long.valueOf(l))).a());
    l = ((Number)paramT2).longValue();
    return ComparisonsKt.compareValues(paramT1, (Comparable)Integer.valueOf(-((DominatorTree.MutableDominatorNode)MapsKt.getValue(this.a, Long.valueOf(l))).a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.DominatorTree.buildFullDominatorTree..inlined.forEach.lambda.1
 * JD-Core Version:    0.7.0.1
 */