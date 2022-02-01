package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/TakeSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class TakeSequence<T>
  implements DropTakeSequence<T>, Sequence<T>
{
  private final int count;
  private final Sequence<T> sequence;
  
  public TakeSequence(@NotNull Sequence<? extends T> paramSequence, int paramInt)
  {
    this.sequence = paramSequence;
    this.count = paramInt;
    if (this.count >= 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      return;
    }
    paramSequence = new StringBuilder();
    paramSequence.append("count must be non-negative, but was ");
    paramSequence.append(this.count);
    paramSequence.append('.');
    throw ((Throwable)new IllegalArgumentException(paramSequence.toString().toString()));
  }
  
  @NotNull
  public Sequence<T> drop(int paramInt)
  {
    int i = this.count;
    if (paramInt >= i) {
      return SequencesKt.emptySequence();
    }
    return (Sequence)new SubSequence(this.sequence, paramInt, i);
  }
  
  @NotNull
  public Iterator<T> iterator()
  {
    return (Iterator)new TakeSequence.iterator.1(this);
  }
  
  @NotNull
  public Sequence<T> take(int paramInt)
  {
    if (paramInt >= this.count) {
      return (Sequence)this;
    }
    return (Sequence)new TakeSequence(this.sequence, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.sequences.TakeSequence
 * JD-Core Version:    0.7.0.1
 */