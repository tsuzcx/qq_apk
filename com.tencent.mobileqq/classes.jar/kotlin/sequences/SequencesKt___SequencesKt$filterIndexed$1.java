package kotlin.sequences;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "Lkotlin/collections/IndexedValue;", "invoke"}, k=3, mv={1, 1, 16})
final class SequencesKt___SequencesKt$filterIndexed$1
  extends Lambda
  implements Function1<IndexedValue<? extends T>, Boolean>
{
  SequencesKt___SequencesKt$filterIndexed$1(Function2 paramFunction2)
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull IndexedValue<? extends T> paramIndexedValue)
  {
    Intrinsics.checkParameterIsNotNull(paramIndexedValue, "it");
    return ((Boolean)this.$predicate.invoke(Integer.valueOf(paramIndexedValue.getIndex()), paramIndexedValue.getValue())).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.filterIndexed.1
 * JD-Core Version:    0.7.0.1
 */