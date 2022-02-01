package okhttp3.internal.cache;

import java.io.IOException;
import okio.Okio;

class DiskLruCache$1
  implements Runnable
{
  DiskLruCache$1(DiskLruCache paramDiskLruCache) {}
  
  public void run()
  {
    int i = 1;
    synchronized (this.this$0)
    {
      if (!this.this$0.initialized)
      {
        if ((i | this.this$0.closed) == 0) {}
      }
      else {
        i = 0;
      }
    }
    try
    {
      this.this$0.trimToSize();
    }
    catch (IOException localIOException1)
    {
      try
      {
        for (;;)
        {
          if (this.this$0.journalRebuildRequired())
          {
            this.this$0.rebuildJournal();
            this.this$0.redundantOpCount = 0;
          }
          return;
          localObject = finally;
          throw localObject;
          localIOException1 = localIOException1;
          this.this$0.mostRecentTrimFailed = true;
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          this.this$0.mostRecentRebuildFailed = true;
          this.this$0.journalWriter = Okio.buffer(Okio.blackhole());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.cache.DiskLruCache.1
 * JD-Core Version:    0.7.0.1
 */