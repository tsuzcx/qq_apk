package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/SequencesKt___SequencesKt$minus$4", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class SequencesKt___SequencesKt$minus$4
  implements Sequence<T>
{
  SequencesKt___SequencesKt$minus$4(Sequence<? extends T> paramSequence, Sequence paramSequence1) {}
  
  @NotNull
  public Iterator<T> iterator()
  {
    HashSet localHashSet = SequencesKt.toHashSet(this.$elements);
    if (localHashSet.isEmpty()) {
      return this.$this_minus.iterator();
    }
    return SequencesKt.filterNot(this.$this_minus, (Function1)new SequencesKt___SequencesKt.minus.4.iterator.1(localHashSet)).iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.minus.4
 * JD-Core Version:    0.7.0.1
 */