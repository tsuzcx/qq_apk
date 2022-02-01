package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class GzipSource
  implements Source
{
  private static final byte FCOMMENT = 4;
  private static final byte FEXTRA = 2;
  private static final byte FHCRC = 1;
  private static final byte FNAME = 3;
  private static final byte SECTION_BODY = 1;
  private static final byte SECTION_DONE = 3;
  private static final byte SECTION_HEADER = 0;
  private static final byte SECTION_TRAILER = 2;
  private final CRC32 crc = new CRC32();
  private final Inflater inflater;
  private final InflaterSource inflaterSource;
  private int section = 0;
  private final BufferedSource source;
  
  public GzipSource(Source paramSource)
  {
    if (paramSource != null)
    {
      this.inflater = new Inflater(true);
      this.source = Okio.buffer(paramSource);
      this.inflaterSource = new InflaterSource(this.source, this.inflater);
      return;
    }
    throw new IllegalArgumentException("source == null");
  }
  
  private void checkEqual(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1) {
      return;
    }
    throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
  }
  
  private void consumeHeader()
  {
    this.source.require(10L);
    int j = this.source.buffer().getByte(3L);
    int i;
    if ((j >> 1 & 0x1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      updateCrc(this.source.buffer(), 0L, 10L);
    }
    checkEqual("ID1ID2", 8075, this.source.readShort());
    this.source.skip(8L);
    long l;
    if ((j >> 2 & 0x1) == 1)
    {
      this.source.require(2L);
      if (i != 0) {
        updateCrc(this.source.buffer(), 0L, 2L);
      }
      int k = this.source.buffer().readShortLe();
      BufferedSource localBufferedSource = this.source;
      l = k;
      localBufferedSource.require(l);
      if (i != 0) {
        updateCrc(this.source.buffer(), 0L, l);
      }
      this.source.skip(l);
    }
    if ((j >> 3 & 0x1) == 1)
    {
      l = this.source.indexOf((byte)0);
      if (l != -1L)
      {
        if (i != 0) {
          updateCrc(this.source.buffer(), 0L, l + 1L);
        }
        this.source.skip(l + 1L);
      }
      else
      {
        throw new EOFException();
      }
    }
    if ((j >> 4 & 0x1) == 1)
    {
      l = this.source.indexOf((byte)0);
      if (l != -1L)
      {
        if (i != 0) {
          updateCrc(this.source.buffer(), 0L, l + 1L);
        }
        this.source.skip(l + 1L);
      }
      else
      {
        throw new EOFException();
      }
    }
    if (i != 0)
    {
      checkEqual("FHCRC", this.source.readShortLe(), (short)(int)this.crc.getValue());
      this.crc.reset();
    }
  }
  
  private void consumeTrailer()
  {
    checkEqual("CRC", this.source.readIntLe(), (int)this.crc.getValue());
    checkEqual("ISIZE", this.source.readIntLe(), (int)this.inflater.getBytesWritten());
  }
  
  private void updateCrc(Buffer paramBuffer, long paramLong1, long paramLong2)
  {
    for (paramBuffer = paramBuffer.head; paramLong1 >= paramBuffer.limit - paramBuffer.pos; paramBuffer = paramBuffer.next) {
      paramLong1 -= paramBuffer.limit - paramBuffer.pos;
    }
    while (paramLong2 > 0L)
    {
      int i = (int)(paramBuffer.pos + paramLong1);
      int j = (int)Math.min(paramBuffer.limit - i, paramLong2);
      this.crc.update(paramBuffer.data, i, j);
      paramLong2 -= j;
      paramBuffer = paramBuffer.next;
      paramLong1 = 0L;
    }
  }
  
  public void close()
  {
    this.inflaterSource.close();
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (paramLong >= 0L)
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
        long l = paramBuffer.size;
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
        throw new IOException("gzip finished without exhausting source");
      }
      return -1L;
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("byteCount < 0: ");
    paramBuffer.append(paramLong);
    throw new IllegalArgumentException(paramBuffer.toString());
  }
  
  public Timeout timeout()
  {
    return this.source.timeout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.GzipSource
 * JD-Core Version:    0.7.0.1
 */