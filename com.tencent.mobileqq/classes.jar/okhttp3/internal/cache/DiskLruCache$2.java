package okhttp3.internal.cache;

import java.io.IOException;
import okio.Sink;

class DiskLruCache$2
  extends FaultHidingSink
{
  DiskLruCache$2(DiskLruCache paramDiskLruCache, Sink paramSink)
  {
    super(paramSink);
  }
  
  protected void onException(IOException paramIOException)
  {
    this.this$0.hasJournalErrors = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.cache.DiskLruCache.2
 * JD-Core Version:    0.7.0.1
 */