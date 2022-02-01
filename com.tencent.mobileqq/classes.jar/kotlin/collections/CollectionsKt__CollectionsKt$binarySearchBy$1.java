package kotlin.collections;

import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "K", "", "it", "invoke", "(Ljava/lang/Object;)I"}, k=3, mv={1, 1, 16})
public final class CollectionsKt__CollectionsKt$binarySearchBy$1
  extends Lambda
  implements Function1<T, Integer>
{
  public CollectionsKt__CollectionsKt$binarySearchBy$1(Function1 paramFunction1, Comparable paramComparable)
  {
    super(1);
  }
  
  public final int invoke(T paramT)
  {
    return ComparisonsKt.compareValues((Comparable)this.$selector.invoke(paramT), this.$key);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.CollectionsKt__CollectionsKt.binarySearchBy.1
 * JD-Core Version:    0.7.0.1
 */