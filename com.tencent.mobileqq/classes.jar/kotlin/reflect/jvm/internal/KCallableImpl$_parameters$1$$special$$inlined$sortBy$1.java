package kotlin.reflect.jvm.internal;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.reflect.KParameter;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 1, 16})
public final class KCallableImpl$_parameters$1$$special$$inlined$sortBy$1<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    return ComparisonsKt.compareValues((Comparable)((KParameter)paramT1).getName(), (Comparable)((KParameter)paramT2).getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KCallableImpl._parameters.1..special..inlined.sortBy.1
 * JD-Core Version:    0.7.0.1
 */