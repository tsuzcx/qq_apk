package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/DropSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class DropSequence<T>
  implements DropTakeSequence<T>, Sequence<T>
{
  private final int count;
  private final Sequence<T> sequence;
  
  public DropSequence(@NotNull Sequence<? extends T> paramSequence, int paramInt)
  {
    this.sequence = paramSequence;
    this.count = paramInt;
    if (this.count >= 0) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0) {
      throw ((Throwable)new IllegalArgumentException(("count must be non-negative, but was " + this.count + '.').toString()));
    }
  }
  
  @NotNull
  public Sequence<T> drop(int paramInt)
  {
    int i = this.count + paramInt;
    if (i < 0) {
      return (Sequence)new DropSequence((Sequence)this, paramInt);
    }
    return (Sequence)new DropSequence(this.sequence, i);
  }
  
  @NotNull
  public Iterator<T> iterator()
  {
    return (Iterator)new DropSequence.iterator.1(this);
  }
  
  @NotNull
  public Sequence<T> take(int paramInt)
  {
    int i = this.count + paramInt;
    if (i < 0) {
      return (Sequence)new TakeSequence((Sequence)this, paramInt);
    }
    return (Sequence)new SubSequence(this.sequence, this.count, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.sequences.DropSequence
 * JD-Core Version:    0.7.0.1
 */