package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/LinesSequence;", "Lkotlin/sequences/Sequence;", "", "reader", "Ljava/io/BufferedReader;", "(Ljava/io/BufferedReader;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class LinesSequence
  implements Sequence<String>
{
  private final BufferedReader reader;
  
  public LinesSequence(@NotNull BufferedReader paramBufferedReader)
  {
    this.reader = paramBufferedReader;
  }
  
  @NotNull
  public Iterator<String> iterator()
  {
    return (Iterator)new LinesSequence.iterator.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.io.LinesSequence
 * JD-Core Version:    0.7.0.1
 */