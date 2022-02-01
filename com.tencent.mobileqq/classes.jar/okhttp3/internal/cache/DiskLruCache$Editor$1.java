package okhttp3.internal.cache;

import java.io.IOException;
import okio.Sink;

class DiskLruCache$Editor$1
  extends FaultHidingSink
{
  DiskLruCache$Editor$1(DiskLruCache.Editor paramEditor, Sink paramSink)
  {
    super(paramSink);
  }
  
  protected void onException(IOException arg1)
  {
    synchronized (this.this$1.this$0)
    {
      this.this$1.detach();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.cache.DiskLruCache.Editor.1
 * JD-Core Version:    0.7.0.1
 */