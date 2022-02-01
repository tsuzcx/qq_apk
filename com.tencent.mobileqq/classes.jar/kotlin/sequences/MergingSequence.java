package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/MergingSequence;", "T1", "T2", "V", "Lkotlin/sequences/Sequence;", "sequence1", "sequence2", "transform", "Lkotlin/Function2;", "(Lkotlin/sequences/Sequence;Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class MergingSequence<T1, T2, V>
  implements Sequence<V>
{
  private final Sequence<T1> sequence1;
  private final Sequence<T2> sequence2;
  private final Function2<T1, T2, V> transform;
  
  public MergingSequence(@NotNull Sequence<? extends T1> paramSequence, @NotNull Sequence<? extends T2> paramSequence1, @NotNull Function2<? super T1, ? super T2, ? extends V> paramFunction2)
  {
    this.sequence1 = paramSequence;
    this.sequence2 = paramSequence1;
    this.transform = paramFunction2;
  }
  
  @NotNull
  public Iterator<V> iterator()
  {
    return (Iterator)new MergingSequence.iterator.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.MergingSequence
 * JD-Core Version:    0.7.0.1
 */