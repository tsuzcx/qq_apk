package okhttp3.internal.http1;

import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import okio.Buffer;

class Http1Codec$FixedLengthSource
  extends Http1Codec.AbstractSource
{
  private long bytesRemaining;
  
  Http1Codec$FixedLengthSource(Http1Codec paramHttp1Codec, long paramLong)
  {
    super(paramHttp1Codec, null);
    this.bytesRemaining = paramLong;
    if (this.bytesRemaining == 0L) {
      endOfInput(true, null);
    }
  }
  
  public void close()
  {
    if (this.closed) {
      return;
    }
    if ((this.bytesRemaining != 0L) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
      endOfInput(false, null);
    }
    this.closed = true;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (!this.closed)
      {
        long l = this.bytesRemaining;
        if (l == 0L) {
          return -1L;
        }
        paramLong = super.read(paramBuffer, Math.min(l, paramLong));
        if (paramLong != -1L)
        {
          this.bytesRemaining -= paramLong;
          if (this.bytesRemaining == 0L) {
            endOfInput(true, null);
          }
          return paramLong;
        }
        paramBuffer = new ProtocolException("unexpected end of stream");
        endOfInput(false, paramBuffer);
        throw paramBuffer;
      }
      throw new IllegalStateException("closed");
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("byteCount < 0: ");
    paramBuffer.append(paramLong);
    throw new IllegalArgumentException(paramBuffer.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.http1.Http1Codec.FixedLengthSource
 * JD-Core Version:    0.7.0.1
 */