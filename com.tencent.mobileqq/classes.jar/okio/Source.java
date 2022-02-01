package okio;

import java.io.Closeable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/Source;", "Ljava/io/Closeable;", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "okio"}, k=1, mv={1, 1, 16})
public abstract interface Source
  extends Closeable
{
  public abstract void close();
  
  public abstract long read(@NotNull Buffer paramBuffer, long paramLong);
  
  @NotNull
  public abstract Timeout timeout();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Source
 * JD-Core Version:    0.7.0.1
 */