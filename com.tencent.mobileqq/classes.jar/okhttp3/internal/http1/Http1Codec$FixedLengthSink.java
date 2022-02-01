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
    if (this.bytesRemaining <= 0L)
    {
      this.this$0.detachTimeout(this.timeout);
      this.this$0.state = 3;
      return;
    }
    throw new ProtocolException("unexpected end of stream");
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
    if (!this.closed)
    {
      Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
      if (paramLong <= this.bytesRemaining)
      {
        this.this$0.sink.write(paramBuffer, paramLong);
        this.bytesRemaining -= paramLong;
        return;
      }
      paramBuffer = new StringBuilder();
      paramBuffer.append("expected ");
      paramBuffer.append(this.bytesRemaining);
      paramBuffer.append(" bytes but received ");
      paramBuffer.append(paramLong);
      throw new ProtocolException(paramBuffer.toString());
    }
    throw new IllegalStateException("closed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.http1.Http1Codec.FixedLengthSink
 * JD-Core Version:    0.7.0.1
 */