package kotlin.streams.jdk8;

import java.util.Iterator;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class StreamsKt$asSequence$$inlined$Sequence$1
  implements Sequence<T>
{
  public StreamsKt$asSequence$$inlined$Sequence$1(Stream paramStream) {}
  
  @NotNull
  public Iterator<T> iterator()
  {
    return this.$this_asSequence$inlined.iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     kotlin.streams.jdk8.StreamsKt.asSequence..inlined.Sequence.1
 * JD-Core Version:    0.7.0.1
 */