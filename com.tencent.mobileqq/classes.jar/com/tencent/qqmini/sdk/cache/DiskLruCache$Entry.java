package com.tencent.qqmini.sdk.cache;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class DiskLruCache$Entry
{
  private DiskLruCache.Editor currentEditor;
  private final String key;
  private final long[] lengths;
  private boolean readable;
  private long sequenceNumber;
  
  private DiskLruCache$Entry(DiskLruCache paramDiskLruCache, String paramString)
  {
    this.key = paramString;
    this.lengths = new long[DiskLruCache.access$1800(paramDiskLruCache)];
  }
  
  private IOException invalidLengths(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unexpected journal line: ");
    localStringBuilder.append(Arrays.toString(paramArrayOfString));
    throw new IOException(localStringBuilder.toString());
  }
  
  private void setLengths(String[] paramArrayOfString)
  {
    int i;
    if (paramArrayOfString.length == DiskLruCache.access$1800(this.this$0)) {
      i = 0;
    }
    try
    {
      while (i < paramArrayOfString.length)
      {
        this.lengths[i] = Long.parseLong(paramArrayOfString[i]);
        i += 1;
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label40:
      break label40;
    }
    throw invalidLengths(paramArrayOfString);
    paramArrayOfString = invalidLengths(paramArrayOfString);
    for (;;)
    {
      throw paramArrayOfString;
    }
  }
  
  public File getCleanFile(int paramInt)
  {
    File localFile = DiskLruCache.access$1900(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.key);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt);
    return new File(localFile, localStringBuilder.toString());
  }
  
  public File getDirtyFile(int paramInt)
  {
    File localFile = DiskLruCache.access$1900(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.key);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(".tmp");
    return new File(localFile, localStringBuilder.toString());
  }
  
  public String getLengths()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    long[] arrayOfLong = this.lengths;
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = arrayOfLong[i];
      localStringBuilder.append(' ');
      localStringBuilder.append(l);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.cache.DiskLruCache.Entry
 * JD-Core Version:    0.7.0.1
 */