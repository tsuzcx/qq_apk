package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k=3, mv={1, 1, 16})
public final class ComparisonsKt__ComparisonsKt$thenComparator$1<T>
  implements Comparator<T>
{
  public ComparisonsKt__ComparisonsKt$thenComparator$1(Comparator paramComparator, Function2 paramFunction2) {}
  
  public final int compare(T paramT1, T paramT2)
  {
    int i = this.$this_thenComparator.compare(paramT1, paramT2);
    if (i != 0) {
      return i;
    }
    return ((Number)this.$comparison.invoke(paramT1, paramT2)).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.comparisons.ComparisonsKt__ComparisonsKt.thenComparator.1
 * JD-Core Version:    0.7.0.1
 */