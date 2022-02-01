package shark;

import kotlin.Metadata;
import okio.Buffer;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ByteArraySourceProvider;", "Lshark/DualSourceProvider;", "byteArray", "", "([B)V", "openRandomAccessSource", "Lshark/RandomAccessSource;", "openStreamingSource", "Lokio/BufferedSource;", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class ByteArraySourceProvider
  implements DualSourceProvider
{
  private final byte[] a;
  
  @NotNull
  public BufferedSource a()
  {
    Buffer localBuffer = new Buffer();
    localBuffer.write(this.a);
    return (BufferedSource)localBuffer;
  }
  
  @NotNull
  public RandomAccessSource b()
  {
    return (RandomAccessSource)new ByteArraySourceProvider.openRandomAccessSource.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ByteArraySourceProvider
 * JD-Core Version:    0.7.0.1
 */