package com.tencent.mobileqq.mini.cache;

import java.io.Closeable;
import java.io.InputStream;

public final class DiskLruCache$Snapshot
  implements Closeable
{
  private final InputStream[] ins;
  private final String key;
  private final long[] lengths;
  private final long sequenceNumber;
  
  private DiskLruCache$Snapshot(DiskLruCache paramDiskLruCache, String paramString, long paramLong, InputStream[] paramArrayOfInputStream, long[] paramArrayOfLong)
  {
    this.key = paramString;
    this.sequenceNumber = paramLong;
    this.ins = paramArrayOfInputStream;
    this.lengths = paramArrayOfLong;
  }
  
  public void close()
  {
    InputStream[] arrayOfInputStream = this.ins;
    int j = arrayOfInputStream.length;
    int i = 0;
    while (i < j)
    {
      Util.closeQuietly(arrayOfInputStream[i]);
      i += 1;
    }
  }
  
  public DiskLruCache.Editor edit()
  {
    return DiskLruCache.access$1600(this.this$0, this.key, this.sequenceNumber);
  }
  
  public InputStream getInputStream(int paramInt)
  {
    return this.ins[paramInt];
  }
  
  public long getLength(int paramInt)
  {
    return this.lengths[paramInt];
  }
  
  public String getString(int paramInt)
  {
    return DiskLruCache.access$1700(getInputStream(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.DiskLruCache.Snapshot
 * JD-Core Version:    0.7.0.1
 */