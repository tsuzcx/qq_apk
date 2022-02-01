package okhttp3.internal.http1;

import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;

class Http1Codec$ChunkedSource
  extends Http1Codec.AbstractSource
{
  private static final long NO_CHUNK_YET = -1L;
  private long bytesRemainingInChunk = -1L;
  private boolean hasMoreChunks = true;
  private final HttpUrl url;
  
  Http1Codec$ChunkedSource(Http1Codec paramHttp1Codec, HttpUrl paramHttpUrl)
  {
    super(paramHttp1Codec, null);
    this.url = paramHttpUrl;
  }
  
  private void readChunkSize()
  {
    if (this.bytesRemainingInChunk != -1L) {
      this.this$0.source.readUtf8LineStrict();
    }
    try
    {
      this.bytesRemainingInChunk = this.this$0.source.readHexadecimalUnsignedLong();
      String str = this.this$0.source.readUtf8LineStrict().trim();
      if (this.bytesRemainingInChunk >= 0L) {
        if (!str.isEmpty())
        {
          boolean bool = str.startsWith(";");
          if (!bool) {}
        }
        else
        {
          if (this.bytesRemainingInChunk == 0L)
          {
            this.hasMoreChunks = false;
            HttpHeaders.receiveHeaders(this.this$0.client.cookieJar(), this.url, this.this$0.readHeaders());
            endOfInput(true, null);
          }
          return;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("expected chunk size and optional extensions but was \"");
      localStringBuilder.append(this.bytesRemainingInChunk);
      localStringBuilder.append(str);
      localStringBuilder.append("\"");
      throw new ProtocolException(localStringBuilder.toString());
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new ProtocolException(localNumberFormatException.getMessage());
    }
  }
  
  public void close()
  {
    if (this.closed) {
      return;
    }
    if ((this.hasMoreChunks) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
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
        if (!this.hasMoreChunks) {
          return -1L;
        }
        long l = this.bytesRemainingInChunk;
        if ((l == 0L) || (l == -1L))
        {
          readChunkSize();
          if (!this.hasMoreChunks) {
            return -1L;
          }
        }
        paramLong = super.read(paramBuffer, Math.min(paramLong, this.bytesRemainingInChunk));
        if (paramLong != -1L)
        {
          this.bytesRemainingInChunk -= paramLong;
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
 * Qualified Name:     okhttp3.internal.http1.Http1Codec.ChunkedSource
 * JD-Core Version:    0.7.0.1
 */