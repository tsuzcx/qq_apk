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
    paramInt1 = this.startIndex;
    paramInt2 = 1;
    if (paramInt1 >= 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0)
    {
      if (this.endIndex >= 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0)
      {
        if (this.endIndex >= this.startIndex) {
          paramInt1 = paramInt2;
        } else {
          paramInt1 = 0;
        }
        if (paramInt1 != 0) {
          return;
        }
        paramSequence = new StringBuilder();
        paramSequence.append("endIndex should be not less than startIndex, but was ");
        paramSequence.append(this.endIndex);
        paramSequence.append(" < ");
        paramSequence.append(this.startIndex);
        throw ((Throwable)new IllegalArgumentException(paramSequence.toString().toString()));
      }
      paramSequence = new StringBuilder();
      paramSequence.append("endIndex should be non-negative, but is ");
      paramSequence.append(this.endIndex);
      throw ((Throwable)new IllegalArgumentException(paramSequence.toString().toString()));
    }
    paramSequence = new StringBuilder();
    paramSequence.append("startIndex should be non-negative, but is ");
    paramSequence.append(this.startIndex);
    throw ((Throwable)new IllegalArgumentException(paramSequence.toString().toString()));
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
    Sequence localSequence = this.sequence;
    int i = this.startIndex;
    return (Sequence)new SubSequence(localSequence, i, paramInt + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.sequences.SubSequence
 * JD-Core Version:    0.7.0.1
 */