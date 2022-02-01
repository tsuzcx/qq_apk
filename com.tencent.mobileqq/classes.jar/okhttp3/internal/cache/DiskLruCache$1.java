package okhttp3.internal.cache;

import java.io.IOException;
import okio.Okio;

class DiskLruCache$1
  implements Runnable
{
  DiskLruCache$1(DiskLruCache paramDiskLruCache) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (this.this$0)
      {
        if (!this.this$0.initialized)
        {
          i = 1;
          if ((i | this.this$0.closed) != 0) {
            return;
          }
          try
          {
            this.this$0.trimToSize();
          }
          catch (IOException localIOException1)
          {
            continue;
          }
          this.this$0.mostRecentTrimFailed = true;
          try
          {
            if (!this.this$0.journalRebuildRequired()) {
              continue;
            }
            this.this$0.rebuildJournal();
            this.this$0.redundantOpCount = 0;
          }
          catch (IOException localIOException2)
          {
            continue;
          }
          this.this$0.mostRecentRebuildFailed = true;
          this.this$0.journalWriter = Okio.buffer(Okio.blackhole());
          return;
        }
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.cache.DiskLruCache.1
 * JD-Core Version:    0.7.0.1
 */