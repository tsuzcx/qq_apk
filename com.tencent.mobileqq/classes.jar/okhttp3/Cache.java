package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.Iterator;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.DiskLruCache.Editor;
import okhttp3.internal.cache.DiskLruCache.Snapshot;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.io.FileSystem;
import okio.BufferedSource;
import okio.ByteString;

public final class Cache
  implements Closeable, Flushable
{
  private static final int ENTRY_BODY = 1;
  private static final int ENTRY_COUNT = 2;
  private static final int ENTRY_METADATA = 0;
  private static final int VERSION = 201105;
  final DiskLruCache cache;
  private int hitCount;
  final InternalCache internalCache = new Cache.1(this);
  private int networkCount;
  private int requestCount;
  int writeAbortCount;
  int writeSuccessCount;
  
  public Cache(File paramFile, long paramLong)
  {
    this(paramFile, paramLong, FileSystem.SYSTEM);
  }
  
  Cache(File paramFile, long paramLong, FileSystem paramFileSystem)
  {
    this.cache = DiskLruCache.create(paramFileSystem, paramFile, 201105, 2, paramLong);
  }
  
  private void abortQuietly(@Nullable DiskLruCache.Editor paramEditor)
  {
    if (paramEditor != null) {}
    try
    {
      paramEditor.abort();
      return;
    }
    catch (IOException paramEditor) {}
  }
  
  public static String key(HttpUrl paramHttpUrl)
  {
    return ByteString.encodeUtf8(paramHttpUrl.toString()).md5().hex();
  }
  
  static int readInt(BufferedSource paramBufferedSource)
  {
    try
    {
      long l = paramBufferedSource.readDecimalLong();
      paramBufferedSource = paramBufferedSource.readUtf8LineStrict();
      if ((l >= 0L) && (l <= 2147483647L) && (paramBufferedSource.isEmpty())) {
        return (int)l;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("expected an int but was \"");
      localStringBuilder.append(l);
      localStringBuilder.append(paramBufferedSource);
      localStringBuilder.append("\"");
      throw new IOException(localStringBuilder.toString());
    }
    catch (NumberFormatException paramBufferedSource)
    {
      throw new IOException(paramBufferedSource.getMessage());
    }
  }
  
  public void close()
  {
    this.cache.close();
  }
  
  public void delete()
  {
    this.cache.delete();
  }
  
  public File directory()
  {
    return this.cache.getDirectory();
  }
  
  public void evictAll()
  {
    this.cache.evictAll();
  }
  
  public void flush()
  {
    this.cache.flush();
  }
  
  @Nullable
  Response get(Request paramRequest)
  {
    Object localObject = key(paramRequest.url());
    try
    {
      localObject = this.cache.get((String)localObject);
      if (localObject == null) {
        return null;
      }
    }
    catch (IOException paramRequest)
    {
      Cache.Entry localEntry;
      label62:
      return null;
    }
    try
    {
      localEntry = new Cache.Entry(((DiskLruCache.Snapshot)localObject).getSource(0));
      localObject = localEntry.response((DiskLruCache.Snapshot)localObject);
      if (!localEntry.matches(paramRequest, (Response)localObject))
      {
        Util.closeQuietly(((Response)localObject).body());
        return null;
      }
      return localObject;
    }
    catch (IOException paramRequest)
    {
      break label62;
    }
    Util.closeQuietly((Closeable)localObject);
    return null;
  }
  
  public int hitCount()
  {
    try
    {
      int i = this.hitCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void initialize()
  {
    this.cache.initialize();
  }
  
  public boolean isClosed()
  {
    return this.cache.isClosed();
  }
  
  public long maxSize()
  {
    return this.cache.getMaxSize();
  }
  
  public int networkCount()
  {
    try
    {
      int i = this.networkCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Nullable
  CacheRequest put(Response paramResponse)
  {
    Object localObject = paramResponse.request().method();
    if (HttpMethod.invalidatesCache(paramResponse.request().method())) {}
    try
    {
      remove(paramResponse.request());
      return null;
    }
    catch (IOException paramResponse)
    {
      return null;
    }
    if (!((String)localObject).equals("GET")) {
      return null;
    }
    if (HttpHeaders.hasVaryAll(paramResponse)) {
      return null;
    }
    localObject = new Cache.Entry(paramResponse);
    try
    {
      paramResponse = this.cache.edit(key(paramResponse.request().url()));
      if (paramResponse == null) {
        return null;
      }
    }
    catch (IOException paramResponse)
    {
      label101:
      break label101;
    }
    try
    {
      ((Cache.Entry)localObject).writeTo(paramResponse);
      localObject = new Cache.CacheRequestImpl(this, paramResponse);
      return localObject;
    }
    catch (IOException localIOException)
    {
      break label103;
    }
    paramResponse = null;
    label103:
    abortQuietly(paramResponse);
    return null;
  }
  
  void remove(Request paramRequest)
  {
    this.cache.remove(key(paramRequest.url()));
  }
  
  public int requestCount()
  {
    try
    {
      int i = this.requestCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long size()
  {
    return this.cache.size();
  }
  
  void trackConditionalCacheHit()
  {
    try
    {
      this.hitCount += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void trackResponse(CacheStrategy paramCacheStrategy)
  {
    try
    {
      this.requestCount += 1;
      if (paramCacheStrategy.networkRequest != null) {
        this.networkCount += 1;
      } else if (paramCacheStrategy.cacheResponse != null) {
        this.hitCount += 1;
      }
      return;
    }
    finally {}
  }
  
  void update(Response paramResponse1, Response paramResponse2)
  {
    paramResponse2 = new Cache.Entry(paramResponse2);
    paramResponse1 = ((Cache.CacheResponseBody)paramResponse1.body()).snapshot;
    try
    {
      paramResponse1 = paramResponse1.edit();
      if (paramResponse1 == null) {}
    }
    catch (IOException paramResponse1)
    {
      label39:
      label41:
      break label39;
    }
    try
    {
      paramResponse2.writeTo(paramResponse1);
      paramResponse1.commit();
      return;
    }
    catch (IOException paramResponse2)
    {
      break label41;
    }
    paramResponse1 = null;
    abortQuietly(paramResponse1);
  }
  
  public Iterator<String> urls()
  {
    return new Cache.2(this);
  }
  
  public int writeAbortCount()
  {
    try
    {
      int i = this.writeAbortCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int writeSuccessCount()
  {
    try
    {
      int i = this.writeSuccessCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.Cache
 * JD-Core Version:    0.7.0.1
 */