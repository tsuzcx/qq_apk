package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/DistinctSequence;", "T", "K", "Lkotlin/sequences/Sequence;", "source", "keySelector", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class DistinctSequence<T, K>
  implements Sequence<T>
{
  private final Function1<T, K> keySelector;
  private final Sequence<T> source;
  
  public DistinctSequence(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    this.source = paramSequence;
    this.keySelector = paramFunction1;
  }
  
  @NotNull
  public Iterator<T> iterator()
  {
    return (Iterator)new DistinctIterator(this.source.iterator(), this.keySelector);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.DistinctSequence
 * JD-Core Version:    0.7.0.1
 */