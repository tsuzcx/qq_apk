package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/SequencesKt___SequencesKt$minus$2", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class SequencesKt___SequencesKt$minus$2
  implements Sequence<T>
{
  SequencesKt___SequencesKt$minus$2(Sequence<? extends T> paramSequence, Object[] paramArrayOfObject) {}
  
  @NotNull
  public Iterator<T> iterator()
  {
    HashSet localHashSet = ArraysKt.toHashSet(this.$elements);
    return SequencesKt.filterNot(this.$this_minus, (Function1)new SequencesKt___SequencesKt.minus.2.iterator.1(localHashSet)).iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.minus.2
 * JD-Core Version:    0.7.0.1
 */