package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.EmptyIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/EmptySequence;", "Lkotlin/sequences/Sequence;", "", "Lkotlin/sequences/DropTakeSequence;", "()V", "drop", "n", "", "iterator", "", "take", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class EmptySequence
  implements DropTakeSequence, Sequence
{
  public static final EmptySequence INSTANCE = new EmptySequence();
  
  @NotNull
  public EmptySequence drop(int paramInt)
  {
    return INSTANCE;
  }
  
  @NotNull
  public Iterator iterator()
  {
    return (Iterator)EmptyIterator.INSTANCE;
  }
  
  @NotNull
  public EmptySequence take(int paramInt)
  {
    return INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.sequences.EmptySequence
 * JD-Core Version:    0.7.0.1
 */