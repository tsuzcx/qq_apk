package okhttp3.internal.cache;

import java.io.Closeable;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Source;

public final class DiskLruCache$Snapshot
  implements Closeable
{
  private final String key;
  private final long[] lengths;
  private final long sequenceNumber;
  private final Source[] sources;
  
  DiskLruCache$Snapshot(DiskLruCache paramDiskLruCache, String paramString, long paramLong, Source[] paramArrayOfSource, long[] paramArrayOfLong)
  {
    this.key = paramString;
    this.sequenceNumber = paramLong;
    this.sources = paramArrayOfSource;
    this.lengths = paramArrayOfLong;
  }
  
  public void close()
  {
    Source[] arrayOfSource = this.sources;
    int j = arrayOfSource.length;
    int i = 0;
    while (i < j)
    {
      Util.closeQuietly(arrayOfSource[i]);
      i += 1;
    }
  }
  
  @Nullable
  public DiskLruCache.Editor edit()
  {
    return this.this$0.edit(this.key, this.sequenceNumber);
  }
  
  public long getLength(int paramInt)
  {
    return this.lengths[paramInt];
  }
  
  public Source getSource(int paramInt)
  {
    return this.sources[paramInt];
  }
  
  public String key()
  {
    return this.key;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.cache.DiskLruCache.Snapshot
 * JD-Core Version:    0.7.0.1
 */