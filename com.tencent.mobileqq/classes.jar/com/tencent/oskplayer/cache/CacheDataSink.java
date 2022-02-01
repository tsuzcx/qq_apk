package com.tencent.oskplayer.cache;

import com.tencent.oskplayer.datasource.DataSink;
import com.tencent.oskplayer.datasource.DataSpec;
import com.tencent.oskplayer.proxy.FileType;
import com.tencent.oskplayer.util.Assertions;
import com.tencent.oskplayer.util.PlayerUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CacheDataSink
  implements DataSink
{
  protected String TAG = "CacheDataSink";
  private final Cache cache;
  protected DataSpec dataSpec;
  protected long dataSpecBytesWritten;
  private String extraLogTag = "";
  protected File file;
  private FileOutputStream fileOutputStream;
  protected FileType fileType = FileType.UNKNOWN;
  protected final long maxCacheFileSize;
  private BufferedOutputStream outputStream;
  protected long outputStreamBytesWritten;
  protected long totalLength = -1L;
  
  public CacheDataSink(Cache paramCache, long paramLong)
  {
    this.cache = paramCache;
    this.maxCacheFileSize = paramLong;
  }
  
  private void closeCurrentOutputStream()
  {
    if (this.outputStream == null)
    {
      PlayerUtils.log(4, getLogTag(), "finish cache: outputStream == null");
      return;
    }
    try
    {
      this.outputStream.flush();
      this.fileOutputStream.getFD().sync();
      closeQuietly(this.outputStream);
      commitFile();
      PlayerUtils.log(4, getLogTag(), "finish cache " + this.file.getAbsolutePath() + "  filesize=" + this.file.length());
      this.fileOutputStream = null;
      this.outputStream = null;
      this.file = null;
      return;
    }
    finally
    {
      closeQuietly(this.outputStream);
      this.file.delete();
      PlayerUtils.log(6, getLogTag(), "closeCurrentOutputStream failed: " + this.file.getAbsolutePath());
      this.fileOutputStream = null;
      this.outputStream = null;
      this.file = null;
    }
  }
  
  private static void closeQuietly(OutputStream paramOutputStream)
  {
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream) {}
  }
  
  public void close()
  {
    try
    {
      closeCurrentOutputStream();
      PlayerUtils.log(4, getLogTag(), "close " + String.format("total cached %d bytes", new Object[] { Long.valueOf(this.dataSpecBytesWritten) }));
      return;
    }
    catch (IOException localIOException)
    {
      throw new CacheDataSink.CacheDataSinkException(localIOException);
    }
  }
  
  protected void commitFile()
  {
    this.cache.commitFile(this.file);
  }
  
  public String getLogTag()
  {
    return this.extraLogTag + this.TAG;
  }
  
  public DataSink open(DataSpec paramDataSpec, long paramLong, FileType paramFileType)
  {
    if (paramDataSpec.length != -1L) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.totalLength = paramLong;
      this.fileType = paramFileType;
      try
      {
        this.dataSpec = paramDataSpec;
        this.dataSpecBytesWritten = 0L;
        openNextOutputStream();
        return this;
      }
      catch (IOException paramDataSpec)
      {
        throw new CacheDataSink.CacheDataSinkException(paramDataSpec);
      }
    }
  }
  
  protected void openNextOutputStream()
  {
    startFile();
    PlayerUtils.log(4, getLogTag(), "start cache " + this.file.getAbsolutePath());
    this.fileOutputStream = new FileOutputStream(this.file);
    this.outputStream = new BufferedOutputStream(this.fileOutputStream);
    this.outputStreamBytesWritten = 0L;
  }
  
  public void setLogTag(String paramString)
  {
    this.extraLogTag = paramString;
  }
  
  protected void startFile()
  {
    this.file = this.cache.startFile(this.dataSpec.key, this.dataSpec.absoluteStreamPosition + this.dataSpecBytesWritten, this.totalLength, this.fileType, Math.min(this.dataSpec.length - this.dataSpecBytesWritten, this.maxCacheFileSize));
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2) {
      try
      {
        if (this.outputStreamBytesWritten == this.maxCacheFileSize)
        {
          closeCurrentOutputStream();
          openNextOutputStream();
        }
        int j = (int)Math.min(paramInt2 - i, this.maxCacheFileSize - this.outputStreamBytesWritten);
        this.outputStream.write(paramArrayOfByte, paramInt1 + i, j);
        i += j;
        this.outputStreamBytesWritten += j;
        this.dataSpecBytesWritten += j;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new CacheDataSink.CacheDataSinkException(paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.cache.CacheDataSink
 * JD-Core Version:    0.7.0.1
 */