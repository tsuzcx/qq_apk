package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/FlatteningSequence;", "T", "R", "E", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "iterator", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class FlatteningSequence<T, R, E>
  implements Sequence<E>
{
  private final Function1<R, Iterator<E>> iterator;
  private final Sequence<T> sequence;
  private final Function1<T, R> transformer;
  
  public FlatteningSequence(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, ? extends R> paramFunction1, @NotNull Function1<? super R, ? extends Iterator<? extends E>> paramFunction11)
  {
    this.sequence = paramSequence;
    this.transformer = paramFunction1;
    this.iterator = paramFunction11;
  }
  
  @NotNull
  public Iterator<E> iterator()
  {
    return (Iterator)new FlatteningSequence.iterator.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.sequences.FlatteningSequence
 * JD-Core Version:    0.7.0.1
 */