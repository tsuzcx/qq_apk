package kotlin.sequences;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/SequencesKt___SequencesKt$minus$3", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class SequencesKt___SequencesKt$minus$3
  implements Sequence<T>
{
  SequencesKt___SequencesKt$minus$3(Sequence<? extends T> paramSequence, Iterable paramIterable) {}
  
  @NotNull
  public Iterator<T> iterator()
  {
    Collection localCollection = CollectionsKt.convertToSetForSetOperation(this.$elements);
    if (localCollection.isEmpty()) {
      return this.$this_minus.iterator();
    }
    return SequencesKt.filterNot(this.$this_minus, (Function1)new SequencesKt___SequencesKt.minus.3.iterator.1(localCollection)).iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.minus.3
 * JD-Core Version:    0.7.0.1
 */