package okhttp3.internal.http1;

import java.net.ProtocolException;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Timeout;

final class Http1Codec$FixedLengthSink
  implements Sink
{
  private long bytesRemaining;
  private boolean closed;
  private final ForwardingTimeout timeout = new ForwardingTimeout(this.this$0.sink.timeout());
  
  Http1Codec$FixedLengthSink(Http1Codec paramHttp1Codec, long paramLong)
  {
    this.bytesRemaining = paramLong;
  }
  
  public void close()
  {
    if (this.closed) {
      return;
    }
    this.closed = true;
    if (this.bytesRemaining > 0L) {
      throw new ProtocolException("unexpected end of stream");
    }
    this.this$0.detachTimeout(this.timeout);
    this.this$0.state = 3;
  }
  
  public void flush()
  {
    if (this.closed) {
      return;
    }
    this.this$0.sink.flush();
  }
  
  public Timeout timeout()
  {
    return this.timeout;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
    if (paramLong > this.bytesRemaining) {
      throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + paramLong);
    }
    this.this$0.sink.write(paramBuffer, paramLong);
    this.bytesRemaining -= paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.http1.Http1Codec.FixedLengthSink
 * JD-Core Version:    0.7.0.1
 */