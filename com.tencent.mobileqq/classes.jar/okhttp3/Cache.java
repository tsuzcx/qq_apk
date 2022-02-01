package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.Iterator;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.DiskLruCache.Editor;
import okhttp3.internal.cache.DiskLruCache.Snapshot;
import okhttp3.internal.cache.InternalCache;
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
    long l;
    try
    {
      l = paramBufferedSource.readDecimalLong();
      paramBufferedSource = paramBufferedSource.readUtf8LineStrict();
      if ((l < 0L) || (l > 2147483647L) || (!paramBufferedSource.isEmpty())) {
        throw new IOException("expected an int but was \"" + l + paramBufferedSource + "\"");
      }
    }
    catch (NumberFormatException paramBufferedSource)
    {
      throw new IOException(paramBufferedSource.getMessage());
    }
    return (int)l;
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
      try
      {
        Cache.Entry localEntry = new Cache.Entry(((DiskLruCache.Snapshot)localObject).getSource(0));
        localObject = localEntry.response((DiskLruCache.Snapshot)localObject);
        if (!localEntry.matches(paramRequest, (Response)localObject))
        {
          Util.closeQuietly(((Response)localObject).body());
          return null;
        }
      }
      catch (IOException paramRequest)
      {
        Util.closeQuietly((Closeable)localObject);
        return null;
      }
      return localObject;
    }
    catch (IOException paramRequest) {}
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
  
  /* Error */
  @Nullable
  okhttp3.internal.cache.CacheRequest put(Response paramResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 213	okhttp3/Response:request	()Lokhttp3/Request;
    //   4: invokevirtual 216	okhttp3/Request:method	()Ljava/lang/String;
    //   7: astore_2
    //   8: aload_1
    //   9: invokevirtual 213	okhttp3/Response:request	()Lokhttp3/Request;
    //   12: invokevirtual 216	okhttp3/Request:method	()Ljava/lang/String;
    //   15: invokestatic 222	okhttp3/internal/http/HttpMethod:invalidatesCache	(Ljava/lang/String;)Z
    //   18: ifeq +13 -> 31
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 213	okhttp3/Response:request	()Lokhttp3/Request;
    //   26: invokevirtual 226	okhttp3/Cache:remove	(Lokhttp3/Request;)V
    //   29: aconst_null
    //   30: areturn
    //   31: aload_2
    //   32: ldc 228
    //   34: invokevirtual 232	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifeq -8 -> 29
    //   40: aload_1
    //   41: invokestatic 238	okhttp3/internal/http/HttpHeaders:hasVaryAll	(Lokhttp3/Response;)Z
    //   44: ifne -15 -> 29
    //   47: new 162	okhttp3/Cache$Entry
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 241	okhttp3/Cache$Entry:<init>	(Lokhttp3/Response;)V
    //   55: astore_2
    //   56: aload_0
    //   57: getfield 56	okhttp3/Cache:cache	Lokhttp3/internal/cache/DiskLruCache;
    //   60: aload_1
    //   61: invokevirtual 213	okhttp3/Response:request	()Lokhttp3/Request;
    //   64: invokevirtual 155	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   67: invokestatic 157	okhttp3/Cache:key	(Lokhttp3/HttpUrl;)Ljava/lang/String;
    //   70: invokevirtual 245	okhttp3/internal/cache/DiskLruCache:edit	(Ljava/lang/String;)Lokhttp3/internal/cache/DiskLruCache$Editor;
    //   73: astore_1
    //   74: aload_1
    //   75: ifnull -46 -> 29
    //   78: aload_2
    //   79: aload_1
    //   80: invokevirtual 248	okhttp3/Cache$Entry:writeTo	(Lokhttp3/internal/cache/DiskLruCache$Editor;)V
    //   83: new 250	okhttp3/Cache$CacheRequestImpl
    //   86: dup
    //   87: aload_0
    //   88: aload_1
    //   89: invokespecial 253	okhttp3/Cache$CacheRequestImpl:<init>	(Lokhttp3/Cache;Lokhttp3/internal/cache/DiskLruCache$Editor;)V
    //   92: astore_2
    //   93: aload_2
    //   94: areturn
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_0
    //   99: aload_1
    //   100: invokespecial 255	okhttp3/Cache:abortQuietly	(Lokhttp3/internal/cache/DiskLruCache$Editor;)V
    //   103: aconst_null
    //   104: areturn
    //   105: astore_2
    //   106: goto -8 -> 98
    //   109: astore_1
    //   110: aconst_null
    //   111: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	Cache
    //   0	112	1	paramResponse	Response
    //   7	87	2	localObject	Object
    //   105	1	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   56	74	95	java/io/IOException
    //   78	93	105	java/io/IOException
    //   21	29	109	java/io/IOException
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
  
  /* Error */
  void trackResponse(okhttp3.internal.cache.CacheStrategy paramCacheStrategy)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 259	okhttp3/Cache:requestCount	I
    //   7: iconst_1
    //   8: iadd
    //   9: putfield 259	okhttp3/Cache:requestCount	I
    //   12: aload_1
    //   13: getfield 271	okhttp3/internal/cache/CacheStrategy:networkRequest	Lokhttp3/Request;
    //   16: ifnull +16 -> 32
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 207	okhttp3/Cache:networkCount	I
    //   24: iconst_1
    //   25: iadd
    //   26: putfield 207	okhttp3/Cache:networkCount	I
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_1
    //   33: getfield 275	okhttp3/internal/cache/CacheStrategy:cacheResponse	Lokhttp3/Response;
    //   36: ifnull -7 -> 29
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 195	okhttp3/Cache:hitCount	I
    //   44: iconst_1
    //   45: iadd
    //   46: putfield 195	okhttp3/Cache:hitCount	I
    //   49: goto -20 -> 29
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	Cache
    //   0	57	1	paramCacheStrategy	okhttp3.internal.cache.CacheStrategy
    // Exception table:
    //   from	to	target	type
    //   2	29	52	finally
    //   32	49	52	finally
  }
  
  void update(Response paramResponse1, Response paramResponse2)
  {
    Cache.Entry localEntry = new Cache.Entry(paramResponse2);
    paramResponse2 = ((Cache.CacheResponseBody)paramResponse1.body()).snapshot;
    paramResponse1 = null;
    try
    {
      paramResponse2 = paramResponse2.edit();
      if (paramResponse2 != null)
      {
        paramResponse1 = paramResponse2;
        localEntry.writeTo(paramResponse2);
        paramResponse1 = paramResponse2;
        paramResponse2.commit();
      }
      return;
    }
    catch (IOException paramResponse2)
    {
      abortQuietly(paramResponse1);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.Cache
 * JD-Core Version:    0.7.0.1
 */