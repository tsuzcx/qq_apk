package kotlin.sequences;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/SequencesKt___SequencesKt$sortedWith$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class SequencesKt___SequencesKt$sortedWith$1
  implements Sequence<T>
{
  SequencesKt___SequencesKt$sortedWith$1(Sequence<? extends T> paramSequence, Comparator paramComparator) {}
  
  @NotNull
  public Iterator<T> iterator()
  {
    List localList = SequencesKt.toMutableList(this.$this_sortedWith);
    CollectionsKt.sortWith(localList, this.$comparator);
    return localList.iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.sortedWith.1
 * JD-Core Version:    0.7.0.1
 */