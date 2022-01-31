package okio;

import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class GzipSink
  implements Sink
{
  private boolean closed;
  private final CRC32 crc = new CRC32();
  private final Deflater deflater;
  private final DeflaterSink deflaterSink;
  private final BufferedSink sink;
  
  public GzipSink(Sink paramSink)
  {
    if (paramSink == null) {
      throw new IllegalArgumentException("sink == null");
    }
    this.deflater = new Deflater(-1, true);
    this.sink = Okio.buffer(paramSink);
    this.deflaterSink = new DeflaterSink(this.sink, this.deflater);
    writeHeader();
  }
  
  private void updateCrc(Buffer paramBuffer, long paramLong)
  {
    for (paramBuffer = paramBuffer.head; paramLong > 0L; paramBuffer = paramBuffer.next)
    {
      int i = (int)Math.min(paramLong, paramBuffer.limit - paramBuffer.pos);
      this.crc.update(paramBuffer.data, paramBuffer.pos, i);
      paramLong -= i;
    }
  }
  
  private void writeFooter()
  {
    this.sink.writeIntLe((int)this.crc.getValue());
    this.sink.writeIntLe((int)this.deflater.getBytesRead());
  }
  
  private void writeHeader()
  {
    Buffer localBuffer = this.sink.buffer();
    localBuffer.writeShort(8075);
    localBuffer.writeByte(8);
    localBuffer.writeByte(0);
    localBuffer.writeInt(0);
    localBuffer.writeByte(0);
    localBuffer.writeByte(0);
  }
  
  public void close()
  {
    if (this.closed) {}
    for (;;)
    {
      return;
      Object localObject2 = null;
      try
      {
        this.deflaterSink.finishDeflate();
        writeFooter();
        try
        {
          label21:
          this.deflater.end();
          localObject1 = localObject2;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            Object localObject1;
            label41:
            if (localThrowable3 != null) {
              localThrowable2 = localThrowable3;
            }
          }
        }
        try
        {
          this.sink.close();
          localObject2 = localObject1;
        }
        catch (Throwable localThrowable4)
        {
          Object localObject3 = localThrowable2;
          if (localThrowable2 != null) {
            break label41;
          }
          localObject3 = localThrowable4;
          break label41;
        }
        this.closed = true;
        if (localObject2 == null) {
          continue;
        }
        Util.sneakyRethrow(localObject2);
        return;
      }
      catch (Throwable localThrowable3)
      {
        break label21;
      }
    }
  }
  
  public final Deflater deflater()
  {
    return this.deflater;
  }
  
  public void flush()
  {
    this.deflaterSink.flush();
  }
  
  public Timeout timeout()
  {
    return this.sink.timeout();
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (paramLong == 0L) {
      return;
    }
    updateCrc(paramBuffer, paramLong);
    this.deflaterSink.write(paramBuffer, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okio.GzipSink
 * JD-Core Version:    0.7.0.1
 */