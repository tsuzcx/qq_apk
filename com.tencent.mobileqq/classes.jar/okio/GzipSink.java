package okio;

import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/GzipSink;", "Lokio/Sink;", "sink", "(Lokio/Sink;)V", "closed", "", "crc", "Ljava/util/zip/CRC32;", "deflater", "Ljava/util/zip/Deflater;", "()Ljava/util/zip/Deflater;", "deflaterSink", "Lokio/DeflaterSink;", "Lokio/RealBufferedSink;", "close", "", "-deprecated_deflater", "flush", "timeout", "Lokio/Timeout;", "updateCrc", "buffer", "Lokio/Buffer;", "byteCount", "", "write", "source", "writeFooter", "okio"}, k=1, mv={1, 1, 16})
public final class GzipSink
  implements Sink
{
  private boolean closed;
  private final CRC32 crc;
  @NotNull
  private final Deflater deflater;
  private final DeflaterSink deflaterSink;
  private final RealBufferedSink sink;
  
  public GzipSink(@NotNull Sink paramSink)
  {
    this.sink = new RealBufferedSink(paramSink);
    this.deflater = new Deflater(-1, true);
    this.deflaterSink = new DeflaterSink((BufferedSink)this.sink, this.deflater);
    this.crc = new CRC32();
    paramSink = this.sink.bufferField;
    paramSink.writeShort(8075);
    paramSink.writeByte(8);
    paramSink.writeByte(0);
    paramSink.writeInt(0);
    paramSink.writeByte(0);
    paramSink.writeByte(0);
  }
  
  private final void updateCrc(Buffer paramBuffer, long paramLong)
  {
    Segment localSegment = paramBuffer.head;
    paramBuffer = localSegment;
    long l = paramLong;
    if (localSegment == null)
    {
      Intrinsics.throwNpe();
      l = paramLong;
      paramBuffer = localSegment;
    }
    while (l > 0L)
    {
      int i = (int)Math.min(l, paramBuffer.limit - paramBuffer.pos);
      this.crc.update(paramBuffer.data, paramBuffer.pos, i);
      paramLong = l - i;
      localSegment = paramBuffer.next;
      paramBuffer = localSegment;
      l = paramLong;
      if (localSegment == null)
      {
        Intrinsics.throwNpe();
        paramBuffer = localSegment;
        l = paramLong;
      }
    }
  }
  
  private final void writeFooter()
  {
    this.sink.writeIntLe((int)this.crc.getValue());
    this.sink.writeIntLe((int)this.deflater.getBytesRead());
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="deflater", imports={}))
  @JvmName(name="-deprecated_deflater")
  @NotNull
  public final Deflater -deprecated_deflater()
  {
    return this.deflater;
  }
  
  public void close()
  {
    if (this.closed) {
      return;
    }
    Throwable localThrowable1 = (Throwable)null;
    try
    {
      this.deflaterSink.finishDeflate$okio();
      writeFooter();
    }
    catch (Throwable localThrowable2) {}
    Object localObject1;
    try
    {
      this.deflater.end();
      localObject1 = localThrowable2;
    }
    catch (Throwable localThrowable3)
    {
      localObject1 = localThrowable2;
      if (localThrowable2 == null) {
        localObject1 = localThrowable3;
      }
    }
    Object localObject2;
    try
    {
      this.sink.close();
      localObject2 = localObject1;
    }
    catch (Throwable localThrowable4)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localThrowable4;
      }
    }
    this.closed = true;
    if (localObject2 == null) {
      return;
    }
    throw localObject2;
  }
  
  @JvmName(name="deflater")
  @NotNull
  public final Deflater deflater()
  {
    return this.deflater;
  }
  
  public void flush()
  {
    this.deflaterSink.flush();
  }
  
  @NotNull
  public Timeout timeout()
  {
    return this.sink.timeout();
  }
  
  public void write(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramLong == 0L) {
        return;
      }
      updateCrc(paramBuffer, paramLong);
      this.deflaterSink.write(paramBuffer, paramLong);
      return;
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("byteCount < 0: ");
    paramBuffer.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.GzipSink
 * JD-Core Version:    0.7.0.1
 */