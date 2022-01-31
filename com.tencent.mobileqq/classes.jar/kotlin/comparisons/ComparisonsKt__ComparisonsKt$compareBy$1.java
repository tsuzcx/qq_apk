package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k=3, mv={1, 1, 16})
final class ComparisonsKt__ComparisonsKt$compareBy$1<T>
  implements Comparator<T>
{
  ComparisonsKt__ComparisonsKt$compareBy$1(Function1[] paramArrayOfFunction1) {}
  
  public final int compare(T paramT1, T paramT2)
  {
    return ComparisonsKt__ComparisonsKt.access$compareValuesByImpl(paramT1, paramT2, this.$selectors);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.comparisons.ComparisonsKt__ComparisonsKt.compareBy.1
 * JD-Core Version:    0.7.0.1
 */