package com.tencent.oskplayer.datasource;

import com.tencent.oskplayer.cache.CacheDataSink.CacheDataSinkException;
import com.tencent.oskplayer.proxy.FileType;
import com.tencent.oskplayer.util.Assertions;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.List;
import java.util.Map;

public final class TeeDataSource
  implements DataSource
{
  private static final String TAG = "TeeDataSource";
  private final DataSink dataSink;
  private String extraLogTag = "";
  private boolean ignoreCacheSink;
  private boolean isCacheSinkOpen;
  private final DataSource upstream;
  
  public TeeDataSource(DataSource paramDataSource, DataSink paramDataSink)
  {
    this.upstream = ((DataSource)Assertions.checkNotNull(paramDataSource));
    this.dataSink = ((DataSink)Assertions.checkNotNull(paramDataSink));
  }
  
  public long available()
  {
    return this.upstream.available();
  }
  
  public void close()
  {
    try
    {
      this.upstream.close();
      try
      {
        if (this.isCacheSinkOpen) {
          this.dataSink.close();
        }
        return;
      }
      catch (CacheDataSink.CacheDataSinkException localCacheDataSinkException1)
      {
        PlayerUtils.log(5, getLogTag(), "error close datasink " + localCacheDataSinkException1.toString(), localCacheDataSinkException1);
        return;
      }
      try
      {
        if (this.isCacheSinkOpen) {
          this.dataSink.close();
        }
        throw localObject;
      }
      catch (CacheDataSink.CacheDataSinkException localCacheDataSinkException2)
      {
        for (;;)
        {
          PlayerUtils.log(5, getLogTag(), "error close datasink " + localCacheDataSinkException2.toString(), localCacheDataSinkException2);
        }
      }
    }
    finally {}
  }
  
  public FileType getFileType()
  {
    return this.upstream.getFileType();
  }
  
  public String getLogTag()
  {
    return this.extraLogTag + "TeeDataSource";
  }
  
  public long getTotalLength()
  {
    return this.upstream.getTotalLength();
  }
  
  public long open(DataSpec paramDataSpec)
  {
    long l2 = this.upstream.open(paramDataSpec);
    FileType localFileType = FileType.UNKNOWN;
    long l1;
    if ((this.upstream instanceof HttpDataSource))
    {
      l1 = ((HttpDataSource)this.upstream).getTotalLength();
      localFileType = FileType.getFileType((String)((List)((HttpDataSource)this.upstream).getResponseHeaders().get("Content-Type")).get(0));
    }
    for (;;)
    {
      DataSpec localDataSpec = paramDataSpec;
      if (paramDataSpec.length == -1L)
      {
        localDataSpec = paramDataSpec;
        if (l2 != -1L) {
          localDataSpec = new DataSpec(paramDataSpec.uri, paramDataSpec.absoluteStreamPosition, paramDataSpec.position, l2, paramDataSpec.key, paramDataSpec.flags, paramDataSpec.uuid, paramDataSpec.priority);
        }
      }
      this.ignoreCacheSink = false;
      if (l1 != -1L) {
        try
        {
          this.dataSink.open(localDataSpec, l1, localFileType);
          this.isCacheSinkOpen = true;
          return l2;
        }
        catch (CacheDataSink.CacheDataSinkException paramDataSpec)
        {
          this.ignoreCacheSink = true;
          PlayerUtils.log(5, getLogTag(), "error open datasink " + paramDataSpec.toString(), paramDataSpec);
          return l2;
        }
      }
      this.ignoreCacheSink = true;
      return l2;
      l1 = -1L;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = this.upstream.read(paramArrayOfByte, paramInt1, paramInt2);
    if ((paramInt2 <= 0) || (this.ignoreCacheSink)) {}
    for (;;)
    {
      return paramInt2;
      try
      {
        if (this.isCacheSinkOpen)
        {
          this.dataSink.write(paramArrayOfByte, paramInt1, paramInt2);
          return paramInt2;
        }
      }
      catch (CacheDataSink.CacheDataSinkException paramArrayOfByte)
      {
        this.ignoreCacheSink = true;
        PlayerUtils.log(5, getLogTag(), "error write datasink " + paramArrayOfByte.toString(), paramArrayOfByte);
      }
    }
    return paramInt2;
  }
  
  public void setLogTag(String paramString)
  {
    this.extraLogTag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.TeeDataSource
 * JD-Core Version:    0.7.0.1
 */