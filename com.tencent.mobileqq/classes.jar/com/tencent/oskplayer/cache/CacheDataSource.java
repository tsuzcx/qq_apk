package com.tencent.oskplayer.cache;

import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.datasource.DataSink;
import com.tencent.oskplayer.datasource.DataSource;
import com.tencent.oskplayer.datasource.DataSpec;
import com.tencent.oskplayer.datasource.FileDataSource;
import com.tencent.oskplayer.datasource.HttpDataSource;
import com.tencent.oskplayer.datasource.TeeDataSource;
import com.tencent.oskplayer.proxy.FileType;
import com.tencent.oskplayer.util.PlayerUtils;
import java.io.File;
import java.io.IOException;

public final class CacheDataSource
  implements DataSource
{
  private static final String TAG = "CacheDataSource";
  private final boolean blockOnCache;
  private long bytesRemaining;
  private final Cache cache;
  private final DataSource cacheReadDataSource;
  private final DataSource cacheWriteDataSource;
  private DataSource currentDataSource;
  private boolean dataSourceReadStart;
  private final CacheDataSource.EventListener eventListener;
  private String extraLogTag = "";
  private int flags;
  private boolean ignoreCache;
  private final boolean ignoreCacheOnError;
  private String key;
  private CacheSpan lockedSpan;
  private long openCost = 0L;
  private int priority;
  private long readPosition;
  private long totalCachedBytesRead;
  private long totalLength;
  private int totalUpstreamBytesRead;
  private long totalUpstreamReadCost;
  private final DataSource upstreamDataSource;
  private Uri uri;
  private String uuid;
  
  public CacheDataSource(Cache paramCache, DataSource paramDataSource1, DataSource paramDataSource2, DataSink paramDataSink, boolean paramBoolean1, boolean paramBoolean2, CacheDataSource.EventListener paramEventListener)
  {
    this.cache = paramCache;
    this.cacheReadDataSource = paramDataSource2;
    this.blockOnCache = paramBoolean1;
    this.ignoreCacheOnError = paramBoolean2;
    this.upstreamDataSource = paramDataSource1;
    if (paramDataSink != null) {
      this.cacheWriteDataSource = new TeeDataSource(paramDataSource1, paramDataSink);
    } else {
      this.cacheWriteDataSource = null;
    }
    this.eventListener = paramEventListener;
  }
  
  public CacheDataSource(Cache paramCache, DataSource paramDataSource, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramCache, paramDataSource, paramBoolean1, paramBoolean2, 9223372036854775807L);
  }
  
  public CacheDataSource(Cache paramCache, DataSource paramDataSource, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    this(paramCache, paramDataSource, new FileDataSource(), new CacheDataSink(paramCache, paramLong), paramBoolean1, paramBoolean2, null);
  }
  
  private void closeCurrentSource()
  {
    Object localObject1 = this.currentDataSource;
    if (localObject1 == null) {
      return;
    }
    try
    {
      ((DataSource)localObject1).close();
      this.currentDataSource = null;
      localObject1 = this.lockedSpan;
      if (localObject1 != null)
      {
        this.cache.releaseHoleSpan((CacheSpan)localObject1);
        this.lockedSpan = null;
      }
      return;
    }
    finally
    {
      CacheSpan localCacheSpan = this.lockedSpan;
      if (localCacheSpan != null)
      {
        this.cache.releaseHoleSpan(localCacheSpan);
        this.lockedSpan = null;
      }
    }
  }
  
  private void handleBeforeThrow(IOException paramIOException)
  {
    String str = getLogTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleBeforeThrow ");
    localStringBuilder.append(paramIOException);
    localStringBuilder.append(",ignoreCacheOnError=");
    localStringBuilder.append(this.ignoreCacheOnError);
    localStringBuilder.append(",currentDataSource=");
    localStringBuilder.append(this.currentDataSource);
    PlayerUtils.log(3, str, localStringBuilder.toString());
    if ((this.ignoreCacheOnError) && (this.currentDataSource == this.cacheReadDataSource))
    {
      str = getLogTag();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleBeforeThrow currentDataSource=");
      localStringBuilder.append(this.currentDataSource);
      localStringBuilder.append(",exception=");
      localStringBuilder.append(paramIOException);
      PlayerUtils.log(4, str, localStringBuilder.toString());
      this.ignoreCache = true;
    }
  }
  
  private void notifyBytesRead()
  {
    CacheDataSource.EventListener localEventListener = this.eventListener;
    if (localEventListener != null)
    {
      if (this.priority == 90) {
        localEventListener.downloadSizeAndDuration(this.uuid, this.totalUpstreamBytesRead, this.totalUpstreamReadCost, this.totalLength, this.totalCachedBytesRead);
      }
      this.totalUpstreamBytesRead = 0;
      this.totalUpstreamReadCost = 0L;
      if ((this.currentDataSource == this.cacheReadDataSource) && (this.totalCachedBytesRead > 0L))
      {
        this.eventListener.onCachedBytesRead(this.cache.getCacheSpace(), this.totalCachedBytesRead);
        this.totalCachedBytesRead = 0L;
      }
    }
  }
  
  private long openNextSource()
  {
    try
    {
      if (this.ignoreCache) {
        localObject1 = null;
      } else if (this.blockOnCache) {
        localObject1 = this.cache.startReadWrite(this.key, this.readPosition);
      } else {
        localObject1 = this.cache.startReadWriteNonBlocking(this.key, this.readPosition);
      }
      if (localObject1 == null)
      {
        this.currentDataSource = this.upstreamDataSource;
        localObject1 = new DataSpec(this.uri, this.readPosition, this.readPosition, this.bytesRemaining, this.key, this.flags, this.uuid, this.priority);
        break label509;
      }
      if (((CacheSpan)localObject1).isCached)
      {
        localObject3 = Uri.fromFile(((CacheSpan)localObject1).file);
        l1 = this.readPosition - ((CacheSpan)localObject1).position;
        if (this.bytesRemaining == -1L)
        {
          this.bytesRemaining = (((CacheSpan)localObject1).totalLength - this.readPosition);
        }
        else if (this.bytesRemaining > ((CacheSpan)localObject1).totalLength - this.readPosition)
        {
          String str = getLogTag();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("fix bytesRemaining. max=");
          localStringBuilder.append(((CacheSpan)localObject1).totalLength - this.readPosition);
          localStringBuilder.append(" current=");
          localStringBuilder.append(this.bytesRemaining);
          PlayerUtils.log(5, str, localStringBuilder.toString());
          this.bytesRemaining = (((CacheSpan)localObject1).totalLength - this.readPosition);
        }
        long l2 = Math.min(((CacheSpan)localObject1).length - l1, this.bytesRemaining);
        localObject3 = new DataSpec((Uri)localObject3, this.readPosition, l1, l2, this.key, this.flags, this.uuid, this.priority);
        this.currentDataSource = this.cacheReadDataSource;
        if ((this.eventListener == null) || (((CacheSpan)localObject1).file == null) || (((CacheSpan)localObject1).file.lastModified() >= 628358400L)) {
          break label760;
        }
        this.eventListener.onCachedAttrRead(((CacheSpan)localObject1).file.lastModified());
        break label760;
      }
      this.lockedSpan = ((CacheSpan)localObject1);
      if (((CacheSpan)localObject1).isOpenEnded()) {
        l1 = this.bytesRemaining;
      } else if (this.bytesRemaining != -1L) {
        l1 = Math.min(((CacheSpan)localObject1).length, this.bytesRemaining);
      } else {
        l1 = ((CacheSpan)localObject1).length;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        long l1;
        label509:
        Object localObject2 = new RuntimeException(localInterruptedException);
        for (;;)
        {
          throw ((Throwable)localObject2);
        }
        label760:
        localObject2 = localObject3;
      }
    }
    localObject3 = new DataSpec(this.uri, this.readPosition, this.readPosition, l1, this.key, this.flags, this.uuid, this.priority);
    if (this.cacheWriteDataSource != null) {
      localObject1 = this.cacheWriteDataSource;
    } else {
      localObject1 = this.upstreamDataSource;
    }
    this.currentDataSource = ((DataSource)localObject1);
    localObject1 = localObject3;
    l1 = this.currentDataSource.open((DataSpec)localObject1);
    if (((this.currentDataSource instanceof HttpDataSource)) && (this.currentDataSource.getTotalLength() != -1L) && (((DataSpec)localObject1).position >= this.currentDataSource.getTotalLength() - 1L)) {
      PlayerUtils.log(6, getLogTag(), "read position out of bound");
    }
    if ((this.bytesRemaining == -1L) && (this.currentDataSource.getTotalLength() != -1L))
    {
      this.bytesRemaining = (this.currentDataSource.getTotalLength() - this.readPosition);
      localObject1 = getLogTag();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("init bytesRemaining ");
      ((StringBuilder)localObject3).append(this.bytesRemaining);
      ((StringBuilder)localObject3).append(", readPosition=");
      ((StringBuilder)localObject3).append(this.readPosition);
      ((StringBuilder)localObject3).append(",totalLength=");
      ((StringBuilder)localObject3).append(this.currentDataSource.getTotalLength());
      PlayerUtils.log(4, (String)localObject1, ((StringBuilder)localObject3).toString());
    }
    this.bytesRemaining = Math.max(0L, Math.min(this.bytesRemaining, getTotalLength()));
    this.dataSourceReadStart = false;
    return l1;
  }
  
  public long available()
  {
    DataSource localDataSource = this.currentDataSource;
    if (localDataSource == null) {
      return 0L;
    }
    return localDataSource.available();
  }
  
  public void close()
  {
    try
    {
      closeCurrentSource();
      return;
    }
    catch (IOException localIOException)
    {
      String str;
      StringBuilder localStringBuilder;
      if ((this.currentDataSource instanceof FileDataSource))
      {
        str = getLogTag();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("close cache error ");
        localStringBuilder.append(localIOException.toString());
        PlayerUtils.log(6, str, localStringBuilder.toString());
      }
      else
      {
        str = getLogTag();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("close error ");
        localStringBuilder.append(localIOException.toString());
        PlayerUtils.log(6, str, localStringBuilder.toString());
      }
      handleBeforeThrow(localIOException);
      throw localIOException;
    }
  }
  
  public FileType getFileType()
  {
    Object localObject = this.currentDataSource;
    if (localObject == null) {
      return FileType.UNKNOWN;
    }
    if (localObject == this.cacheReadDataSource)
    {
      localObject = this.cache;
      if (localObject != null) {
        return ((Cache)localObject).getContentType(this.key);
      }
    }
    return this.currentDataSource.getFileType();
  }
  
  public String getLogTag()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.extraLogTag);
    localStringBuilder.append("CacheDataSource");
    return localStringBuilder.toString();
  }
  
  public long getTotalLength()
  {
    Object localObject = this.currentDataSource;
    if (localObject == null) {
      return -1L;
    }
    if (localObject == this.cacheReadDataSource)
    {
      localObject = this.cache;
      if (localObject != null) {
        return ((Cache)localObject).getTotalLength(this.key);
      }
    }
    return this.currentDataSource.getTotalLength();
  }
  
  public DataSource getUpstreamDataSource()
  {
    return this.upstreamDataSource;
  }
  
  public long open(DataSpec paramDataSpec)
  {
    try
    {
      this.uri = paramDataSpec.uri;
      this.flags = paramDataSpec.flags;
      this.uuid = paramDataSpec.uuid;
      this.key = paramDataSpec.key;
      this.readPosition = paramDataSpec.position;
      this.bytesRemaining = paramDataSpec.length;
      this.priority = paramDataSpec.priority;
      l1 = System.currentTimeMillis();
      l2 = openNextSource();
      this.totalLength = getTotalLength();
      this.openCost = (System.currentTimeMillis() - l1);
      return l2;
    }
    catch (IOException paramDataSpec)
    {
      long l1;
      long l2;
      String str;
      StringBuilder localStringBuilder;
      if ((this.currentDataSource instanceof FileDataSource))
      {
        str = getLogTag();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("open cache error ");
        localStringBuilder.append(paramDataSpec.toString());
        PlayerUtils.log(6, str, localStringBuilder.toString());
      }
      else
      {
        str = getLogTag();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("open error ");
        localStringBuilder.append(paramDataSpec.toString());
        PlayerUtils.log(6, str, localStringBuilder.toString());
      }
      handleBeforeThrow(paramDataSpec);
      if (this.ignoreCache)
      {
        try
        {
          closeCurrentSource();
        }
        catch (Exception paramDataSpec)
        {
          PlayerUtils.log(5, getLogTag(), "failed on closeCurrentSource, shouldn't be a problem", paramDataSpec);
        }
        PlayerUtils.log(6, getLogTag(), "open cache error try reopen without cache");
        l1 = System.currentTimeMillis();
        l2 = openNextSource();
        this.totalLength = getTotalLength();
        this.openCost = (System.currentTimeMillis() - l1);
        return l2;
      }
      throw paramDataSpec;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      if ((!this.dataSourceReadStart) && ((this.currentDataSource instanceof FileDataSource)) && (PlayerConfig.g().isDebugVersion()))
      {
        str = getLogTag();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("read from cache ");
        localStringBuilder.append(((FileDataSource)this.currentDataSource).getUri());
        localStringBuilder.append(" filesize=");
        localStringBuilder.append(((FileDataSource)this.currentDataSource).available());
        PlayerUtils.log(4, str, localStringBuilder.toString());
      }
      long l1 = System.currentTimeMillis();
      int j = this.currentDataSource.read(paramArrayOfByte, paramInt1, paramInt2);
      l1 = System.currentTimeMillis() - l1;
      if (!this.dataSourceReadStart)
      {
        if ((this.currentDataSource != this.cacheReadDataSource) && (PlayerConfig.g().getVideoReporter() != null) && (this.priority == 90) && (URLUtil.isNetworkUrl(this.uri.toString())) && (this.eventListener != null)) {
          this.eventListener.onHttpUpstreamServerCost(this.uuid, this.openCost, this.openCost, l1);
        }
        this.dataSourceReadStart = true;
      }
      int i;
      if (j >= 0)
      {
        if (this.currentDataSource == this.cacheReadDataSource)
        {
          this.totalCachedBytesRead += j;
        }
        else
        {
          this.totalUpstreamBytesRead += j;
          this.totalUpstreamReadCost += l1;
        }
        l1 = this.readPosition;
        long l2 = j;
        this.readPosition = (l1 + l2);
        i = j;
        if (this.bytesRemaining != -1L)
        {
          this.bytesRemaining -= l2;
          return j;
        }
      }
      else
      {
        notifyBytesRead();
        closeCurrentSource();
        i = j;
        if (this.bytesRemaining > 0L)
        {
          i = j;
          if (this.bytesRemaining != -1L)
          {
            openNextSource();
            i = read(paramArrayOfByte, paramInt1, paramInt2);
          }
        }
      }
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      String str;
      StringBuilder localStringBuilder;
      if ((this.currentDataSource instanceof FileDataSource))
      {
        str = getLogTag();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("read cache error ");
        localStringBuilder.append(paramArrayOfByte.toString());
        PlayerUtils.log(6, str, localStringBuilder.toString());
      }
      else
      {
        str = getLogTag();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("read error ");
        localStringBuilder.append(paramArrayOfByte.toString());
        PlayerUtils.log(6, str, localStringBuilder.toString());
      }
      handleBeforeThrow(paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  public void setLogTag(String paramString)
  {
    this.extraLogTag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.cache.CacheDataSource
 * JD-Core Version:    0.7.0.1
 */