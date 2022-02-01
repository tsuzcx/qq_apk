package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.connection.StreamAllocation;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

class Http2Codec$StreamFinishingSource
  extends ForwardingSource
{
  long bytesRead = 0L;
  boolean completed = false;
  
  Http2Codec$StreamFinishingSource(Http2Codec paramHttp2Codec, Source paramSource)
  {
    super(paramSource);
  }
  
  private void endOfInput(IOException paramIOException)
  {
    if (this.completed) {
      return;
    }
    this.completed = true;
    this.this$0.streamAllocation.streamFinished(false, this.this$0, this.bytesRead, paramIOException);
  }
  
  public void close()
  {
    super.close();
    endOfInput(null);
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    try
    {
      paramLong = delegate().read(paramBuffer, paramLong);
      if (paramLong > 0L) {
        this.bytesRead += paramLong;
      }
      return paramLong;
    }
    catch (IOException paramBuffer)
    {
      endOfInput(paramBuffer);
      throw paramBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Codec.StreamFinishingSource
 * JD-Core Version:    0.7.0.1
 */