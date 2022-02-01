package kotlin.streams.jdk8;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/util/Spliterator;", "T", "kotlin.jvm.PlatformType", "get"}, k=3, mv={1, 1, 16})
final class StreamsKt$asStream$1<T>
  implements Supplier<Spliterator<T>>
{
  StreamsKt$asStream$1(Sequence paramSequence) {}
  
  public final Spliterator<T> get()
  {
    return Spliterators.spliteratorUnknownSize(this.$this_asStream.iterator(), 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     kotlin.streams.jdk8.StreamsKt.asStream.1
 * JD-Core Version:    0.7.0.1
 */