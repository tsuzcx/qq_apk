package okhttp3;

import java.io.IOException;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.DiskLruCache.Editor;
import okio.Sink;

final class Cache$CacheRequestImpl
  implements CacheRequest
{
  private Sink body;
  private Sink cacheOut;
  boolean done;
  private final DiskLruCache.Editor editor;
  
  Cache$CacheRequestImpl(Cache paramCache, DiskLruCache.Editor paramEditor)
  {
    this.editor = paramEditor;
    this.cacheOut = paramEditor.newSink(1);
    this.body = new Cache.CacheRequestImpl.1(this, this.cacheOut, paramCache, paramEditor);
  }
  
  public void abort()
  {
    synchronized (this.this$0)
    {
      if (this.done) {
        return;
      }
      this.done = true;
      Cache localCache2 = this.this$0;
      localCache2.writeAbortCount += 1;
      Util.closeQuietly(this.cacheOut);
    }
  }
  
  public Sink body()
  {
    return this.body;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.Cache.CacheRequestImpl
 * JD-Core Version:    0.7.0.1
 */