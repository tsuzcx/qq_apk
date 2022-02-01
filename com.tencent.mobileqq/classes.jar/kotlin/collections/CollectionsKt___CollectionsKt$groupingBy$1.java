package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1", "Lkotlin/collections/Grouping;", "keyOf", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "sourceIterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class CollectionsKt___CollectionsKt$groupingBy$1
  implements Grouping<T, K>
{
  public CollectionsKt___CollectionsKt$groupingBy$1(Iterable<? extends T> paramIterable, Function1 paramFunction1) {}
  
  public K keyOf(T paramT)
  {
    return this.$keySelector.invoke(paramT);
  }
  
  @NotNull
  public Iterator<T> sourceIterator()
  {
    return this.$this_groupingBy.iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.CollectionsKt___CollectionsKt.groupingBy.1
 * JD-Core Version:    0.7.0.1
 */