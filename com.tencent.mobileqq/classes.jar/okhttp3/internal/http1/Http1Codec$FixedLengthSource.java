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
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    if (this.bytesRemaining == 0L) {
      return -1L;
    }
    paramLong = super.read(paramBuffer, Math.min(this.bytesRemaining, paramLong));
    if (paramLong == -1L)
    {
      paramBuffer = new ProtocolException("unexpected end of stream");
      endOfInput(false, paramBuffer);
      throw paramBuffer;
    }
    this.bytesRemaining -= paramLong;
    if (this.bytesRemaining == 0L) {
      endOfInput(true, null);
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.http1.Http1Codec.FixedLengthSource
 * JD-Core Version:    0.7.0.1
 */