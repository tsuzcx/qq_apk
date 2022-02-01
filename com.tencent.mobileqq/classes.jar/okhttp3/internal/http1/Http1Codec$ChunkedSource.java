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
      if ((this.bytesRemainingInChunk < 0L) || ((!str.isEmpty()) && (!str.startsWith(";")))) {
        throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + str + "\"");
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new ProtocolException(localNumberFormatException.getMessage());
    }
    if (this.bytesRemainingInChunk == 0L)
    {
      this.hasMoreChunks = false;
      HttpHeaders.receiveHeaders(this.this$0.client.cookieJar(), this.url, this.this$0.readHeaders());
      endOfInput(true, null);
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
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    if (!this.hasMoreChunks) {}
    do
    {
      return -1L;
      if ((this.bytesRemainingInChunk != 0L) && (this.bytesRemainingInChunk != -1L)) {
        break;
      }
      readChunkSize();
    } while (!this.hasMoreChunks);
    paramLong = super.read(paramBuffer, Math.min(paramLong, this.bytesRemainingInChunk));
    if (paramLong == -1L)
    {
      paramBuffer = new ProtocolException("unexpected end of stream");
      endOfInput(false, paramBuffer);
      throw paramBuffer;
    }
    this.bytesRemainingInChunk -= paramLong;
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.internal.http1.Http1Codec.ChunkedSource
 * JD-Core Version:    0.7.0.1
 */