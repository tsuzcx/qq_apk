package kotlin.streams.jdk8;

import java.util.Iterator;
import java.util.stream.LongStream;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class StreamsKt$asSequence$$inlined$Sequence$3
  implements Sequence<Long>
{
  public StreamsKt$asSequence$$inlined$Sequence$3(LongStream paramLongStream) {}
  
  @NotNull
  public Iterator<Long> iterator()
  {
    return (Iterator)this.$this_asSequence$inlined.iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     kotlin.streams.jdk8.StreamsKt.asSequence..inlined.Sequence.3
 * JD-Core Version:    0.7.0.1
 */