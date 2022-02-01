package com.tencent.qqmini.sdk.cache;

import java.util.concurrent.Callable;

class DiskLruCache$2
  implements Callable<Void>
{
  DiskLruCache$2(DiskLruCache paramDiskLruCache) {}
  
  public Void call()
  {
    synchronized (this.this$0)
    {
      if (DiskLruCache.access$000(this.this$0) == null) {
        return null;
      }
      DiskLruCache.access$100(this.this$0);
      if (DiskLruCache.access$200(this.this$0))
      {
        DiskLruCache.access$300(this.this$0);
        DiskLruCache.access$402(this.this$0, 0);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.cache.DiskLruCache.2
 * JD-Core Version:    0.7.0.1
 */