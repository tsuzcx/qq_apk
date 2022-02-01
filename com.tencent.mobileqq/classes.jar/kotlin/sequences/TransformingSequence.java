package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/TransformingSequence;", "T", "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "flatten", "E", "iterator", "", "flatten$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class TransformingSequence<T, R>
  implements Sequence<R>
{
  private final Sequence<T> sequence;
  private final Function1<T, R> transformer;
  
  public TransformingSequence(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    this.sequence = paramSequence;
    this.transformer = paramFunction1;
  }
  
  @NotNull
  public final <E> Sequence<E> flatten$kotlin_stdlib(@NotNull Function1<? super R, ? extends Iterator<? extends E>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "iterator");
    return (Sequence)new FlatteningSequence(this.sequence, this.transformer, paramFunction1);
  }
  
  @NotNull
  public Iterator<R> iterator()
  {
    return (Iterator)new TransformingSequence.iterator.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.sequences.TransformingSequence
 * JD-Core Version:    0.7.0.1
 */