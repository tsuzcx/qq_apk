package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/TransformingIndexedSequence;", "T", "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function2;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class TransformingIndexedSequence<T, R>
  implements Sequence<R>
{
  private final Sequence<T> sequence;
  private final Function2<Integer, T, R> transformer;
  
  public TransformingIndexedSequence(@NotNull Sequence<? extends T> paramSequence, @NotNull Function2<? super Integer, ? super T, ? extends R> paramFunction2)
  {
    this.sequence = paramSequence;
    this.transformer = paramFunction2;
  }
  
  @NotNull
  public Iterator<R> iterator()
  {
    return (Iterator)new TransformingIndexedSequence.iterator.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.sequences.TransformingIndexedSequence
 * JD-Core Version:    0.7.0.1
 */