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
        if (this.isCacheSinkOpen)
        {
          this.dataSink.close();
          return;
        }
      }
      catch (CacheDataSink.CacheDataSinkException localCacheDataSinkException1)
      {
        String str = getLogTag();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("error close datasink ");
        ((StringBuilder)localObject2).append(localCacheDataSinkException1.toString());
        PlayerUtils.log(5, str, ((StringBuilder)localObject2).toString(), localCacheDataSinkException1);
      }
      return;
    }
    finally
    {
      try
      {
        if (this.isCacheSinkOpen) {
          this.dataSink.close();
        }
      }
      catch (CacheDataSink.CacheDataSinkException localCacheDataSinkException2)
      {
        Object localObject2 = getLogTag();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("error close datasink ");
        localStringBuilder.append(localCacheDataSinkException2.toString());
        PlayerUtils.log(5, (String)localObject2, localStringBuilder.toString(), localCacheDataSinkException2);
      }
    }
  }
  
  public FileType getFileType()
  {
    return this.upstream.getFileType();
  }
  
  public String getLogTag()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.extraLogTag);
    localStringBuilder.append("TeeDataSource");
    return localStringBuilder.toString();
  }
  
  public long getTotalLength()
  {
    return this.upstream.getTotalLength();
  }
  
  public long open(DataSpec paramDataSpec)
  {
    long l2 = this.upstream.open(paramDataSpec);
    Object localObject1 = FileType.UNKNOWN;
    Object localObject2 = this.upstream;
    long l1;
    if ((localObject2 instanceof HttpDataSource))
    {
      l1 = ((HttpDataSource)localObject2).getTotalLength();
      localObject1 = FileType.getFileType((String)((List)((HttpDataSource)this.upstream).getResponseHeaders().get("Content-Type")).get(0));
    }
    else
    {
      l1 = -1L;
    }
    if ((paramDataSpec.length == -1L) && (l2 != -1L)) {
      paramDataSpec = new DataSpec(paramDataSpec.uri, paramDataSpec.absoluteStreamPosition, paramDataSpec.position, l2, paramDataSpec.key, paramDataSpec.flags, paramDataSpec.uuid, paramDataSpec.priority);
    }
    this.ignoreCacheSink = false;
    if (l1 != -1L) {
      try
      {
        this.dataSink.open(paramDataSpec, l1, (FileType)localObject1);
        this.isCacheSinkOpen = true;
        return l2;
      }
      catch (CacheDataSink.CacheDataSinkException paramDataSpec)
      {
        this.ignoreCacheSink = true;
        localObject1 = getLogTag();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("error open datasink ");
        ((StringBuilder)localObject2).append(paramDataSpec.toString());
        PlayerUtils.log(5, (String)localObject1, ((StringBuilder)localObject2).toString(), paramDataSpec);
        return l2;
      }
    }
    this.ignoreCacheSink = true;
    return l2;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = this.upstream.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0)
    {
      if (this.ignoreCacheSink) {
        return paramInt2;
      }
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
        String str = getLogTag();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("error write datasink ");
        localStringBuilder.append(paramArrayOfByte.toString());
        PlayerUtils.log(5, str, localStringBuilder.toString(), paramArrayOfByte);
      }
    }
    return paramInt2;
  }
  
  public void setLogTag(String paramString)
  {
    this.extraLogTag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.TeeDataSource
 * JD-Core Version:    0.7.0.1
 */