package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/Sequence;", "T", "", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface Sequence<T>
{
  @NotNull
  public abstract Iterator<T> iterator();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.sequences.Sequence
 * JD-Core Version:    0.7.0.1
 */