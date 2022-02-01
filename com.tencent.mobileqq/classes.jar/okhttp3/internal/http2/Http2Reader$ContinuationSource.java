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
    if (b == 9)
    {
      if (this.streamId == i) {
        return;
      }
      throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
    }
    throw Http2.ioException("%s != TYPE_CONTINUATION", new Object[] { Byte.valueOf(b) });
  }
  
  public void close() {}
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    int i;
    for (;;)
    {
      i = this.left;
      if (i != 0) {
        break;
      }
      this.source.skip(this.padding);
      this.padding = 0;
      if ((this.flags & 0x4) != 0) {
        return -1L;
      }
      readContinuationHeader();
    }
    paramLong = this.source.read(paramBuffer, Math.min(paramLong, i));
    if (paramLong == -1L) {
      return -1L;
    }
    this.left = ((int)(this.left - paramLong));
    return paramLong;
  }
  
  public Timeout timeout()
  {
    return this.source.timeout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Reader.ContinuationSource
 * JD-Core Version:    0.7.0.1
 */