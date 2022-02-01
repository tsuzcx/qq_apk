package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/TakeWhileSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class TakeWhileSequence<T>
  implements Sequence<T>
{
  private final Function1<T, Boolean> predicate;
  private final Sequence<T> sequence;
  
  public TakeWhileSequence(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    this.sequence = paramSequence;
    this.predicate = paramFunction1;
  }
  
  @NotNull
  public Iterator<T> iterator()
  {
    return (Iterator)new TakeWhileSequence.iterator.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.sequences.TakeWhileSequence
 * JD-Core Version:    0.7.0.1
 */