package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/ArraysKt___ArraysKt$groupingBy$1", "Lkotlin/collections/Grouping;", "keyOf", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "sourceIterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ArraysKt___ArraysKt$groupingBy$1
  implements Grouping<T, K>
{
  public ArraysKt___ArraysKt$groupingBy$1(T[] paramArrayOfT, Function1 paramFunction1) {}
  
  public K keyOf(T paramT)
  {
    return this.$keySelector.invoke(paramT);
  }
  
  @NotNull
  public Iterator<T> sourceIterator()
  {
    return ArrayIteratorKt.iterator(this.$this_groupingBy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.ArraysKt___ArraysKt.groupingBy.1
 * JD-Core Version:    0.7.0.1
 */