package okhttp3;

import okhttp3.internal.cache.DiskLruCache.Editor;
import okio.ForwardingSink;
import okio.Sink;

class Cache$CacheRequestImpl$1
  extends ForwardingSink
{
  Cache$CacheRequestImpl$1(Cache.CacheRequestImpl paramCacheRequestImpl, Sink paramSink, Cache paramCache, DiskLruCache.Editor paramEditor)
  {
    super(paramSink);
  }
  
  public void close()
  {
    synchronized (this.this$1.this$0)
    {
      if (this.this$1.done) {
        return;
      }
      this.this$1.done = true;
      Cache localCache2 = this.this$1.this$0;
      localCache2.writeSuccessCount += 1;
      super.close();
      this.val$editor.commit();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.Cache.CacheRequestImpl.1
 * JD-Core Version:    0.7.0.1
 */