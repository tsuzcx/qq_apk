package okio;

import java.io.Closeable;
import java.io.Flushable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/Sink;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "close", "", "flush", "timeout", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 1, 16})
public abstract interface Sink
  extends Closeable, Flushable
{
  public abstract void close();
  
  public abstract void flush();
  
  @NotNull
  public abstract Timeout timeout();
  
  public abstract void write(@NotNull Buffer paramBuffer, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Sink
 * JD-Core Version:    0.7.0.1
 */