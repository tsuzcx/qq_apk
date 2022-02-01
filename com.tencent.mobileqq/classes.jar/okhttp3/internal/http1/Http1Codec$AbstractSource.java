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
    if (this.this$0.state == 6) {}
    do
    {
      return;
      if (this.this$0.state != 5) {
        throw new IllegalStateException("state: " + this.this$0.state);
      }
      this.this$0.detachTimeout(this.timeout);
      this.this$0.state = 6;
    } while (this.this$0.streamAllocation == null);
    StreamAllocation localStreamAllocation = this.this$0.streamAllocation;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localStreamAllocation.streamFinished(paramBoolean, this.this$0, this.bytesRead, paramIOException);
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.internal.http1.Http1Codec.AbstractSource
 * JD-Core Version:    0.7.0.1
 */