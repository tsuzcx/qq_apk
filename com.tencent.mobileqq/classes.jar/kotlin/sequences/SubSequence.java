package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/SubSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "startIndex", "", "endIndex", "(Lkotlin/sequences/Sequence;II)V", "count", "getCount", "()I", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class SubSequence<T>
  implements DropTakeSequence<T>, Sequence<T>
{
  private final int endIndex;
  private final Sequence<T> sequence;
  private final int startIndex;
  
  public SubSequence(@NotNull Sequence<? extends T> paramSequence, int paramInt1, int paramInt2)
  {
    this.sequence = paramSequence;
    this.startIndex = paramInt1;
    this.endIndex = paramInt2;
    if (this.startIndex >= 0) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0) {
      throw ((Throwable)new IllegalArgumentException(("startIndex should be non-negative, but is " + this.startIndex).toString()));
    }
    if (this.endIndex >= 0) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0) {
      throw ((Throwable)new IllegalArgumentException(("endIndex should be non-negative, but is " + this.endIndex).toString()));
    }
    if (this.endIndex >= this.startIndex) {}
    for (paramInt1 = i; paramInt1 == 0; paramInt1 = 0) {
      throw ((Throwable)new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + this.endIndex + " < " + this.startIndex).toString()));
    }
  }
  
  private final int getCount()
  {
    return this.endIndex - this.startIndex;
  }
  
  @NotNull
  public Sequence<T> drop(int paramInt)
  {
    if (paramInt >= getCount()) {
      return SequencesKt.emptySequence();
    }
    return (Sequence)new SubSequence(this.sequence, this.startIndex + paramInt, this.endIndex);
  }
  
  @NotNull
  public Iterator<T> iterator()
  {
    return (Iterator)new SubSequence.iterator.1(this);
  }
  
  @NotNull
  public Sequence<T> take(int paramInt)
  {
    if (paramInt >= getCount()) {
      return (Sequence)this;
    }
    return (Sequence)new SubSequence(this.sequence, this.startIndex, this.startIndex + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.SubSequence
 * JD-Core Version:    0.7.0.1
 */