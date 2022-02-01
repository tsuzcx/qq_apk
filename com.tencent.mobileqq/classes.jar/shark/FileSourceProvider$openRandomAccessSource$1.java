package shark;

import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/FileSourceProvider$openRandomAccessSource$1", "Lshark/RandomAccessSource;", "close", "", "read", "", "sink", "Lokio/Buffer;", "position", "byteCount", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class FileSourceProvider$openRandomAccessSource$1
  implements RandomAccessSource
{
  FileSourceProvider$openRandomAccessSource$1(FileChannel paramFileChannel) {}
  
  public long a(@NotNull Buffer paramBuffer, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    return this.a.transferTo(paramLong1, paramLong2, (WritableByteChannel)paramBuffer);
  }
  
  public void close()
  {
    this.a.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.FileSourceProvider.openRandomAccessSource.1
 * JD-Core Version:    0.7.0.1
 */