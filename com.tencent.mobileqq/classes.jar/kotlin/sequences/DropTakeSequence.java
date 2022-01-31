package kotlin.sequences;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/DropTakeSequence;", "T", "Lkotlin/sequences/Sequence;", "drop", "n", "", "take", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface DropTakeSequence<T>
  extends Sequence<T>
{
  @NotNull
  public abstract Sequence<T> drop(int paramInt);
  
  @NotNull
  public abstract Sequence<T> take(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.sequences.DropTakeSequence
 * JD-Core Version:    0.7.0.1
 */