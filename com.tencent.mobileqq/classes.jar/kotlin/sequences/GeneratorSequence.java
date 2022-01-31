package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/GeneratorSequence;", "T", "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class GeneratorSequence<T>
  implements Sequence<T>
{
  private final Function0<T> getInitialValue;
  private final Function1<T, T> getNextValue;
  
  public GeneratorSequence(@NotNull Function0<? extends T> paramFunction0, @NotNull Function1<? super T, ? extends T> paramFunction1)
  {
    this.getInitialValue = paramFunction0;
    this.getNextValue = paramFunction1;
  }
  
  @NotNull
  public Iterator<T> iterator()
  {
    return (Iterator)new GeneratorSequence.iterator.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.sequences.GeneratorSequence
 * JD-Core Version:    0.7.0.1
 */