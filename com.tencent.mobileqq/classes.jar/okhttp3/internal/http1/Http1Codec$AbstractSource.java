package okhttp3.internal.http1;

import java.io.IOException;
import okhttp3.internal.connection.StreamAllocation;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Source;
import okio.Timeout;

abstract class Http1Codec$AbstractSource
  implements Source
{
  protected long bytesRead = 0L;
  protected boolean closed;
  protected final ForwardingTimeout timeout = new ForwardingTimeout(this.this$0.source.timeout());
  
  private Http1Codec$AbstractSource(Http1Codec paramHttp1Codec) {}
  
  protected final void endOfInput(boolean paramBoolean, IOException paramIOException)
  {
    if (this.this$0.state == 6) {
      return;
    }
    if (this.this$0.state == 5)
    {
      this.this$0.detachTimeout(this.timeout);
      Http1Codec localHttp1Codec = this.this$0;
      localHttp1Codec.state = 6;
      if (localHttp1Codec.streamAllocation != null) {
        this.this$0.streamAllocation.streamFinished(paramBoolean ^ true, this.this$0, this.bytesRead, paramIOException);
      }
      return;
    }
    paramIOException = new StringBuilder();
    paramIOException.append("state: ");
    paramIOException.append(this.this$0.state);
    throw new IllegalStateException(paramIOException.toString());
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    try
    {
      paramLong = this.this$0.source.read(paramBuffer, paramLong);
      if (paramLong > 0L) {
        this.bytesRead += paramLong;
      }
      return paramLong;
    }
    catch (IOException paramBuffer)
    {
      endOfInput(false, paramBuffer);
      throw paramBuffer;
    }
  }
  
  public Timeout timeout()
  {
    return this.timeout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.http1.Http1Codec.AbstractSource
 * JD-Core Version:    0.7.0.1
 */