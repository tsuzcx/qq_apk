package okhttp3.internal.cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okio.BufferedSink;
import okio.Source;

final class DiskLruCache$Entry
{
  final File[] cleanFiles;
  DiskLruCache.Editor currentEditor;
  final File[] dirtyFiles;
  final String key;
  final long[] lengths;
  boolean readable;
  long sequenceNumber;
  
  DiskLruCache$Entry(DiskLruCache paramDiskLruCache, String paramString)
  {
    this.key = paramString;
    this.lengths = new long[paramDiskLruCache.valueCount];
    this.cleanFiles = new File[paramDiskLruCache.valueCount];
    this.dirtyFiles = new File[paramDiskLruCache.valueCount];
    paramString = new StringBuilder(paramString);
    paramString.append('.');
    int j = paramString.length();
    int i = 0;
    while (i < paramDiskLruCache.valueCount)
    {
      paramString.append(i);
      this.cleanFiles[i] = new File(paramDiskLruCache.directory, paramString.toString());
      paramString.append(".tmp");
      this.dirtyFiles[i] = new File(paramDiskLruCache.directory, paramString.toString());
      paramString.setLength(j);
      i += 1;
    }
  }
  
  private IOException invalidLengths(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unexpected journal line: ");
    localStringBuilder.append(Arrays.toString(paramArrayOfString));
    throw new IOException(localStringBuilder.toString());
  }
  
  void setLengths(String[] paramArrayOfString)
  {
    int i;
    if (paramArrayOfString.length == this.this$0.valueCount) {
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
  
  DiskLruCache.Snapshot snapshot()
  {
    if (Thread.holdsLock(this.this$0))
    {
      localObject1 = new Source[this.this$0.valueCount];
      Object localObject2 = (long[])this.lengths.clone();
      j = 0;
      i = 0;
      for (;;)
      {
        try
        {
          if (i < this.this$0.valueCount)
          {
            localObject1[i] = this.this$0.fileSystem.source(this.cleanFiles[i]);
            i += 1;
            continue;
          }
          localObject2 = new DiskLruCache.Snapshot(this.this$0, this.key, this.sequenceNumber, (Source[])localObject1, (long[])localObject2);
          return localObject2;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          try
          {
            this.this$0.removeEntry(this);
            return null;
            localObject1 = new AssertionError();
            continue;
            throw ((Throwable)localObject1);
            continue;
            localFileNotFoundException = localFileNotFoundException;
            i = j;
          }
          catch (IOException localIOException)
          {
            continue;
          }
        }
        if ((i >= this.this$0.valueCount) || (localObject1[i] == null)) {
          continue;
        }
        Util.closeQuietly(localObject1[i]);
        i += 1;
      }
    }
  }
  
  void writeLengths(BufferedSink paramBufferedSink)
  {
    long[] arrayOfLong = this.lengths;
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = arrayOfLong[i];
      paramBufferedSink.writeByte(32).writeDecimalLong(l);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.cache.DiskLruCache.Entry
 * JD-Core Version:    0.7.0.1
 */