package okhttp3.internal.http1;

import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Timeout;

final class Http1Codec$ChunkedSink
  implements Sink
{
  private boolean closed;
  private final ForwardingTimeout timeout = new ForwardingTimeout(this.this$0.sink.timeout());
  
  Http1Codec$ChunkedSink(Http1Codec paramHttp1Codec) {}
  
  public void close()
  {
    try
    {
      boolean bool = this.closed;
      if (bool) {
        return;
      }
      this.closed = true;
      this.this$0.sink.writeUtf8("0\r\n\r\n");
      this.this$0.detachTimeout(this.timeout);
      this.this$0.state = 3;
      return;
    }
    finally {}
  }
  
  public void flush()
  {
    try
    {
      boolean bool = this.closed;
      if (bool) {
        return;
      }
      this.this$0.sink.flush();
      return;
    }
    finally {}
  }
  
  public Timeout timeout()
  {
    return this.timeout;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    if (!this.closed)
    {
      if (paramLong == 0L) {
        return;
      }
      this.this$0.sink.writeHexadecimalUnsignedLong(paramLong);
      this.this$0.sink.writeUtf8("\r\n");
      this.this$0.sink.write(paramBuffer, paramLong);
      this.this$0.sink.writeUtf8("\r\n");
      return;
    }
    throw new IllegalStateException("closed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.http1.Http1Codec.ChunkedSink
 * JD-Core Version:    0.7.0.1
 */