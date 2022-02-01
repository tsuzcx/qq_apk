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
    if (paramDataSink != null) {}
    for (this.cacheWriteDataSource = new TeeDataSource(paramDataSource1, paramDataSink);; this.cacheWriteDataSource = null)
    {
      this.eventListener = paramEventListener;
      return;
    }
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
    if (this.currentDataSource == null) {}
    for (;;)
    {
      return;
      try
      {
        this.currentDataSource.close();
        this.currentDataSource = null;
        return;
      }
      finally
      {
        if (this.lockedSpan != null)
        {
          this.cache.releaseHoleSpan(this.lockedSpan);
          this.lockedSpan = null;
        }
      }
    }
  }
  
  private void handleBeforeThrow(IOException paramIOException)
  {
    PlayerUtils.log(3, getLogTag(), "handleBeforeThrow " + paramIOException + ",ignoreCacheOnError=" + this.ignoreCacheOnError + ",currentDataSource=" + this.currentDataSource);
    if ((this.ignoreCacheOnError) && (this.currentDataSource == this.cacheReadDataSource))
    {
      PlayerUtils.log(4, getLogTag(), "handleBeforeThrow currentDataSource=" + this.currentDataSource + ",exception=" + paramIOException);
      this.ignoreCache = true;
    }
  }
  
  private void notifyBytesRead()
  {
    if (this.eventListener != null)
    {
      if (this.priority == 90) {
        this.eventListener.downloadSizeAndDuration(this.uuid, this.totalUpstreamBytesRead, this.totalUpstreamReadCost, this.totalLength, this.totalCachedBytesRead);
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
    Object localObject;
    long l1;
    for (;;)
    {
      try
      {
        CacheSpan localCacheSpan;
        if (this.ignoreCache)
        {
          localCacheSpan = null;
          if (localCacheSpan == null)
          {
            this.currentDataSource = this.upstreamDataSource;
            localObject = new DataSpec(this.uri, this.readPosition, this.readPosition, this.bytesRemaining, this.key, this.flags, this.uuid, this.priority);
            l1 = this.currentDataSource.open((DataSpec)localObject);
            if (((this.currentDataSource instanceof HttpDataSource)) && (this.currentDataSource.getTotalLength() != -1L) && (((DataSpec)localObject).position >= this.currentDataSource.getTotalLength() - 1L)) {
              PlayerUtils.log(6, getLogTag(), "read position out of bound");
            }
            if ((this.bytesRemaining == -1L) && (this.currentDataSource.getTotalLength() != -1L))
            {
              this.bytesRemaining = (this.currentDataSource.getTotalLength() - this.readPosition);
              PlayerUtils.log(4, getLogTag(), "init bytesRemaining " + this.bytesRemaining + ", readPosition=" + this.readPosition + ",totalLength=" + this.currentDataSource.getTotalLength());
            }
            this.bytesRemaining = Math.max(0L, Math.min(this.bytesRemaining, getTotalLength()));
            this.dataSourceReadStart = false;
            return l1;
          }
        }
        else
        {
          if (this.blockOnCache)
          {
            localCacheSpan = this.cache.startReadWrite(this.key, this.readPosition);
            continue;
          }
          localCacheSpan = this.cache.startReadWriteNonBlocking(this.key, this.readPosition);
          continue;
        }
        if (!localCacheSpan.isCached) {
          break;
        }
        localObject = Uri.fromFile(localCacheSpan.file);
        l1 = this.readPosition - localCacheSpan.position;
        if (this.bytesRemaining == -1L)
        {
          this.bytesRemaining = (localCacheSpan.totalLength - this.readPosition);
          long l2 = Math.min(localCacheSpan.length - l1, this.bytesRemaining);
          DataSpec localDataSpec = new DataSpec((Uri)localObject, this.readPosition, l1, l2, this.key, this.flags, this.uuid, this.priority);
          this.currentDataSource = this.cacheReadDataSource;
          localObject = localDataSpec;
          if (this.eventListener == null) {
            continue;
          }
          localObject = localDataSpec;
          if (localCacheSpan.file == null) {
            continue;
          }
          localObject = localDataSpec;
          if (localCacheSpan.file.lastModified() >= 628358400L) {
            continue;
          }
          this.eventListener.onCachedAttrRead(localCacheSpan.file.lastModified());
          localObject = localDataSpec;
          continue;
        }
        if (this.bytesRemaining <= localInterruptedException.totalLength - this.readPosition) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new RuntimeException(localInterruptedException);
      }
      PlayerUtils.log(5, getLogTag(), "fix bytesRemaining. max=" + (localInterruptedException.totalLength - this.readPosition) + " current=" + this.bytesRemaining);
      this.bytesRemaining = (localInterruptedException.totalLength - this.readPosition);
    }
    this.lockedSpan = localInterruptedException;
    if (localInterruptedException.isOpenEnded())
    {
      l1 = this.bytesRemaining;
      label606:
      localObject = new DataSpec(this.uri, this.readPosition, this.readPosition, l1, this.key, this.flags, this.uuid, this.priority);
      if (this.cacheWriteDataSource == null) {
        break label702;
      }
    }
    label702:
    for (DataSource localDataSource = this.cacheWriteDataSource;; localDataSource = this.upstreamDataSource)
    {
      this.currentDataSource = localDataSource;
      break;
      if (this.bytesRemaining != -1L)
      {
        l1 = Math.min(localDataSource.length, this.bytesRemaining);
        break label606;
      }
      l1 = localDataSource.length;
      break label606;
    }
  }
  
  public long available()
  {
    if (this.currentDataSource == null) {
      return 0L;
    }
    return this.currentDataSource.available();
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
      if (!(this.currentDataSource instanceof FileDataSource)) {
        break label55;
      }
    }
    PlayerUtils.log(6, getLogTag(), "close cache error " + localIOException.toString());
    for (;;)
    {
      handleBeforeThrow(localIOException);
      throw localIOException;
      label55:
      PlayerUtils.log(6, getLogTag(), "close error " + localIOException.toString());
    }
  }
  
  public FileType getFileType()
  {
    if (this.currentDataSource == null) {
      return FileType.UNKNOWN;
    }
    if ((this.currentDataSource == this.cacheReadDataSource) && (this.cache != null)) {
      return this.cache.getContentType(this.key);
    }
    return this.currentDataSource.getFileType();
  }
  
  public String getLogTag()
  {
    return this.extraLogTag + "CacheDataSource";
  }
  
  public long getTotalLength()
  {
    if (this.currentDataSource == null) {
      return -1L;
    }
    if ((this.currentDataSource == this.cacheReadDataSource) && (this.cache != null)) {
      return this.cache.getTotalLength(this.key);
    }
    return this.currentDataSource.getTotalLength();
  }
  
  public DataSource getUpstreamDataSource()
  {
    return this.upstreamDataSource;
  }
  
  public long open(DataSpec paramDataSpec)
  {
    long l1;
    long l2;
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
      if ((this.currentDataSource instanceof FileDataSource)) {
        PlayerUtils.log(6, getLogTag(), "open cache error " + paramDataSpec.toString());
      }
      for (;;)
      {
        handleBeforeThrow(paramDataSpec);
        if (this.ignoreCache) {
          break;
        }
        throw paramDataSpec;
        PlayerUtils.log(6, getLogTag(), "open error " + paramDataSpec.toString());
      }
    }
    try
    {
      closeCurrentSource();
      PlayerUtils.log(6, getLogTag(), "open cache error try reopen without cache");
      l1 = System.currentTimeMillis();
      l2 = openNextSource();
      this.totalLength = getTotalLength();
      this.openCost = (System.currentTimeMillis() - l1);
      return l2;
    }
    catch (Exception paramDataSpec)
    {
      for (;;)
      {
        PlayerUtils.log(5, getLogTag(), "failed on closeCurrentSource, shouldn't be a problem", paramDataSpec);
      }
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      if ((!this.dataSourceReadStart) && ((this.currentDataSource instanceof FileDataSource)) && (PlayerConfig.g().isDebugVersion())) {
        PlayerUtils.log(4, getLogTag(), "read from cache " + ((FileDataSource)this.currentDataSource).getUri() + " filesize=" + ((FileDataSource)this.currentDataSource).available());
      }
      long l = System.currentTimeMillis();
      int i = this.currentDataSource.read(paramArrayOfByte, paramInt1, paramInt2);
      l = System.currentTimeMillis() - l;
      if (!this.dataSourceReadStart)
      {
        if ((this.currentDataSource != this.cacheReadDataSource) && (PlayerConfig.g().getVideoReporter() != null) && (this.priority == 90) && (URLUtil.isNetworkUrl(this.uri.toString())) && (this.eventListener != null)) {
          this.eventListener.onHttpUpstreamServerCost(this.uuid, this.openCost, this.openCost, l);
        }
        this.dataSourceReadStart = true;
      }
      if (i >= 0)
      {
        if (this.currentDataSource == this.cacheReadDataSource) {
          this.totalCachedBytesRead += i;
        }
        for (;;)
        {
          this.readPosition += i;
          if (this.bytesRemaining == -1L) {
            break;
          }
          this.bytesRemaining -= i;
          break;
          this.totalUpstreamBytesRead += i;
          this.totalUpstreamReadCost += l;
        }
      }
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      if ((this.currentDataSource instanceof FileDataSource)) {
        PlayerUtils.log(6, getLogTag(), "read cache error " + paramArrayOfByte.toString());
      }
      for (;;)
      {
        handleBeforeThrow(paramArrayOfByte);
        throw paramArrayOfByte;
        notifyBytesRead();
        closeCurrentSource();
        if ((this.bytesRemaining <= 0L) || (this.bytesRemaining == -1L)) {
          break;
        }
        openNextSource();
        paramInt1 = read(paramArrayOfByte, paramInt1, paramInt2);
        return paramInt1;
        PlayerUtils.log(6, getLogTag(), "read error " + paramArrayOfByte.toString());
      }
    }
  }
  
  public void setLogTag(String paramString)
  {
    this.extraLogTag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.cache.CacheDataSource
 * JD-Core Version:    0.7.0.1
 */