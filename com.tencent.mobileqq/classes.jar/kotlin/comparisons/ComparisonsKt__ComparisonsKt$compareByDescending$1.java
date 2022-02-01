package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k=3, mv={1, 1, 16})
public final class ComparisonsKt__ComparisonsKt$compareByDescending$1<T>
  implements Comparator<T>
{
  public ComparisonsKt__ComparisonsKt$compareByDescending$1(Function1 paramFunction1) {}
  
  public final int compare(T paramT1, T paramT2)
  {
    return ComparisonsKt.compareValues((Comparable)this.$selector.invoke(paramT2), (Comparable)this.$selector.invoke(paramT1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.comparisons.ComparisonsKt__ComparisonsKt.compareByDescending.1
 * JD-Core Version:    0.7.0.1
 */