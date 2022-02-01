package shark;

import java.io.Closeable;
import kotlin.Metadata;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/RandomAccessSource;", "Ljava/io/Closeable;", "asStreamingSource", "Lokio/BufferedSource;", "read", "", "sink", "Lokio/Buffer;", "position", "byteCount", "shark-hprof"}, k=1, mv={1, 4, 1})
public abstract interface RandomAccessSource
  extends Closeable
{
  public abstract long a(@NotNull Buffer paramBuffer, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.RandomAccessSource
 * JD-Core Version:    0.7.0.1
 */