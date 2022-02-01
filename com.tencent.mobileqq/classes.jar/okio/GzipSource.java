package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/GzipSource;", "Lokio/Source;", "source", "(Lokio/Source;)V", "crc", "Ljava/util/zip/CRC32;", "inflater", "Ljava/util/zip/Inflater;", "inflaterSource", "Lokio/InflaterSource;", "section", "", "Lokio/RealBufferedSource;", "checkEqual", "", "name", "", "expected", "", "actual", "close", "consumeHeader", "consumeTrailer", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "updateCrc", "buffer", "offset", "okio"}, k=1, mv={1, 1, 16})
public final class GzipSource
  implements Source
{
  private final CRC32 crc;
  private final Inflater inflater;
  private final InflaterSource inflaterSource;
  private byte section;
  private final RealBufferedSource source;
  
  public GzipSource(@NotNull Source paramSource)
  {
    this.source = new RealBufferedSource(paramSource);
    this.inflater = new Inflater(true);
    this.inflaterSource = new InflaterSource((BufferedSource)this.source, this.inflater);
    this.crc = new CRC32();
  }
  
  private final void checkEqual(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1) {
      return;
    }
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    arrayOfObject[2] = Integer.valueOf(paramInt1);
    paramString = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(arrayOfObject, arrayOfObject.length));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "java.lang.String.format(this, *args)");
    throw ((Throwable)new IOException(paramString));
  }
  
  private final void consumeHeader()
  {
    this.source.require(10L);
    int m = this.source.bufferField.getByte(3L);
    int k = 1;
    int i;
    if ((m >> 1 & 0x1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      updateCrc(this.source.bufferField, 0L, 10L);
    }
    checkEqual("ID1ID2", 8075, this.source.readShort());
    this.source.skip(8L);
    int j;
    if ((m >> 2 & 0x1) == 1) {
      j = 1;
    } else {
      j = 0;
    }
    long l;
    if (j != 0)
    {
      this.source.require(2L);
      if (i != 0) {
        updateCrc(this.source.bufferField, 0L, 2L);
      }
      l = this.source.bufferField.readShortLe();
      this.source.require(l);
      if (i != 0) {
        updateCrc(this.source.bufferField, 0L, l);
      }
      this.source.skip(l);
    }
    if ((m >> 3 & 0x1) == 1) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      l = this.source.indexOf((byte)0);
      if (l != -1L)
      {
        if (i != 0) {
          updateCrc(this.source.bufferField, 0L, l + 1L);
        }
        this.source.skip(l + 1L);
      }
      else
      {
        throw ((Throwable)new EOFException());
      }
    }
    if ((m >> 4 & 0x1) == 1) {
      j = k;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      l = this.source.indexOf((byte)0);
      if (l != -1L)
      {
        if (i != 0) {
          updateCrc(this.source.bufferField, 0L, l + 1L);
        }
        this.source.skip(l + 1L);
      }
      else
      {
        throw ((Throwable)new EOFException());
      }
    }
    if (i != 0)
    {
      checkEqual("FHCRC", this.source.readShortLe(), (short)(int)this.crc.getValue());
      this.crc.reset();
    }
  }
  
  private final void consumeTrailer()
  {
    checkEqual("CRC", this.source.readIntLe(), (int)this.crc.getValue());
    checkEqual("ISIZE", this.source.readIntLe(), (int)this.inflater.getBytesWritten());
  }
  
  private final void updateCrc(Buffer paramBuffer, long paramLong1, long paramLong2)
  {
    Segment localSegment = paramBuffer.head;
    paramBuffer = localSegment;
    long l = paramLong1;
    if (localSegment == null)
    {
      Intrinsics.throwNpe();
      l = paramLong1;
      paramBuffer = localSegment;
    }
    while (l >= paramBuffer.limit - paramBuffer.pos)
    {
      paramLong1 = l - (paramBuffer.limit - paramBuffer.pos);
      localSegment = paramBuffer.next;
      paramBuffer = localSegment;
      l = paramLong1;
      if (localSegment == null)
      {
        Intrinsics.throwNpe();
        paramBuffer = localSegment;
        l = paramLong1;
      }
    }
    while (paramLong2 > 0L)
    {
      int i = (int)(paramBuffer.pos + l);
      int j = (int)Math.min(paramBuffer.limit - i, paramLong2);
      this.crc.update(paramBuffer.data, i, j);
      paramLong2 -= j;
      paramBuffer = paramBuffer.next;
      if (paramBuffer == null) {
        Intrinsics.throwNpe();
      }
      l = 0L;
    }
  }
  
  public void close()
  {
    this.inflaterSource.close();
  }
  
  public long read(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramLong == 0L) {
        return 0L;
      }
      if (this.section == 0)
      {
        consumeHeader();
        this.section = 1;
      }
      if (this.section == 1)
      {
        long l = paramBuffer.size();
        paramLong = this.inflaterSource.read(paramBuffer, paramLong);
        if (paramLong != -1L)
        {
          updateCrc(paramBuffer, l, paramLong);
          return paramLong;
        }
        this.section = 2;
      }
      if (this.section == 2)
      {
        consumeTrailer();
        this.section = 3;
        if (this.source.exhausted()) {
          return -1L;
        }
        throw ((Throwable)new IOException("gzip finished without exhausting source"));
      }
      return -1L;
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("byteCount < 0: ");
    paramBuffer.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
  }
  
  @NotNull
  public Timeout timeout()
  {
    return this.source.timeout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.GzipSource
 * JD-Core Version:    0.7.0.1
 */