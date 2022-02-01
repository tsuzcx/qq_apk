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
    paramString = new StringBuilder(paramString).append('.');
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
    throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
  }
  
  void setLengths(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length != this.this$0.valueCount) {
      throw invalidLengths(paramArrayOfString);
    }
    int i = 0;
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
      throw invalidLengths(paramArrayOfString);
    }
  }
  
  DiskLruCache.Snapshot snapshot()
  {
    j = 0;
    if (!Thread.holdsLock(this.this$0)) {
      throw new AssertionError();
    }
    Source[] arrayOfSource = new Source[this.this$0.valueCount];
    Object localObject = (long[])this.lengths.clone();
    i = 0;
    for (;;)
    {
      try
      {
        if (i < this.this$0.valueCount)
        {
          arrayOfSource[i] = this.this$0.fileSystem.source(this.cleanFiles[i]);
          i += 1;
          continue;
        }
        localObject = new DiskLruCache.Snapshot(this.this$0, this.key, this.sequenceNumber, arrayOfSource, (long[])localObject);
        return localObject;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        i = j;
        continue;
      }
      if ((i >= this.this$0.valueCount) || (arrayOfSource[i] == null)) {
        continue;
      }
      Util.closeQuietly(arrayOfSource[i]);
      i += 1;
    }
    try
    {
      this.this$0.removeEntry(this);
      label150:
      return null;
    }
    catch (IOException localIOException)
    {
      break label150;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.cache.DiskLruCache.Entry
 * JD-Core Version:    0.7.0.1
 */