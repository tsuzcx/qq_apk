package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

class CacheInterceptor$1
  implements Source
{
  boolean cacheRequestClosed;
  
  CacheInterceptor$1(CacheInterceptor paramCacheInterceptor, BufferedSource paramBufferedSource, CacheRequest paramCacheRequest, BufferedSink paramBufferedSink) {}
  
  public void close()
  {
    if ((!this.cacheRequestClosed) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS)))
    {
      this.cacheRequestClosed = true;
      this.val$cacheRequest.abort();
    }
    this.val$source.close();
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    try
    {
      paramLong = this.val$source.read(paramBuffer, paramLong);
      if (paramLong == -1L)
      {
        if (!this.cacheRequestClosed)
        {
          this.cacheRequestClosed = true;
          this.val$cacheBody.close();
        }
        return -1L;
      }
    }
    catch (IOException paramBuffer)
    {
      if (!this.cacheRequestClosed)
      {
        this.cacheRequestClosed = true;
        this.val$cacheRequest.abort();
      }
      throw paramBuffer;
    }
    paramBuffer.copyTo(this.val$cacheBody.buffer(), paramBuffer.size() - paramLong, paramLong);
    this.val$cacheBody.emitCompleteSegments();
    return paramLong;
  }
  
  public Timeout timeout()
  {
    return this.val$source.timeout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.internal.cache.CacheInterceptor.1
 * JD-Core Version:    0.7.0.1
 */