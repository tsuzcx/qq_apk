package okhttp3.internal.http2;

import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

final class Http2Reader$ContinuationSource
  implements Source
{
  byte flags;
  int left;
  int length;
  short padding;
  private final BufferedSource source;
  int streamId;
  
  Http2Reader$ContinuationSource(BufferedSource paramBufferedSource)
  {
    this.source = paramBufferedSource;
  }
  
  private void readContinuationHeader()
  {
    int i = this.streamId;
    int j = Http2Reader.readMedium(this.source);
    this.left = j;
    this.length = j;
    byte b = (byte)(this.source.readByte() & 0xFF);
    this.flags = ((byte)(this.source.readByte() & 0xFF));
    if (Http2Reader.logger.isLoggable(Level.FINE)) {
      Http2Reader.logger.fine(Http2.frameLog(true, this.streamId, this.length, b, this.flags));
    }
    this.streamId = (this.source.readInt() & 0x7FFFFFFF);
    if (b != 9) {
      throw Http2.ioException("%s != TYPE_CONTINUATION", new Object[] { Byte.valueOf(b) });
    }
    if (this.streamId != i) {
      throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
    }
  }
  
  public void close() {}
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (this.left == 0)
    {
      this.source.skip(this.padding);
      this.padding = 0;
      if ((this.flags & 0x4) == 0) {}
    }
    do
    {
      return -1L;
      readContinuationHeader();
      break;
      paramLong = this.source.read(paramBuffer, Math.min(paramLong, this.left));
    } while (paramLong == -1L);
    this.left = ((int)(this.left - paramLong));
    return paramLong;
  }
  
  public Timeout timeout()
  {
    return this.source.timeout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Reader.ContinuationSource
 * JD-Core Version:    0.7.0.1
 */