package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/IndexingSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/collections/IndexedValue;", "sequence", "(Lkotlin/sequences/Sequence;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class IndexingSequence<T>
  implements Sequence<IndexedValue<? extends T>>
{
  private final Sequence<T> sequence;
  
  public IndexingSequence(@NotNull Sequence<? extends T> paramSequence)
  {
    this.sequence = paramSequence;
  }
  
  @NotNull
  public Iterator<IndexedValue<T>> iterator()
  {
    return (Iterator)new IndexingSequence.iterator.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.sequences.IndexingSequence
 * JD-Core Version:    0.7.0.1
 */