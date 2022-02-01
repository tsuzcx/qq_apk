package okhttp3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.DiskLruCache.Snapshot;

class Cache$2
  implements Iterator<String>
{
  boolean canRemove;
  final Iterator<DiskLruCache.Snapshot> delegate = this.this$0.cache.snapshots();
  @Nullable
  String nextUrl;
  
  Cache$2(Cache paramCache) {}
  
  /* Error */
  public boolean hasNext()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	okhttp3/Cache$2:nextUrl	Ljava/lang/String;
    //   4: ifnull +5 -> 9
    //   7: iconst_1
    //   8: ireturn
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 47	okhttp3/Cache$2:canRemove	Z
    //   14: aload_0
    //   15: getfield 38	okhttp3/Cache$2:delegate	Ljava/util/Iterator;
    //   18: invokeinterface 49 1 0
    //   23: ifeq +53 -> 76
    //   26: aload_0
    //   27: getfield 38	okhttp3/Cache$2:delegate	Ljava/util/Iterator;
    //   30: invokeinterface 53 1 0
    //   35: checkcast 55	okhttp3/internal/cache/DiskLruCache$Snapshot
    //   38: astore_1
    //   39: aload_0
    //   40: aload_1
    //   41: iconst_0
    //   42: invokevirtual 59	okhttp3/internal/cache/DiskLruCache$Snapshot:getSource	(I)Lokio/Source;
    //   45: invokestatic 65	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   48: invokeinterface 71 1 0
    //   53: putfield 45	okhttp3/Cache$2:nextUrl	Ljava/lang/String;
    //   56: aload_1
    //   57: invokevirtual 74	okhttp3/internal/cache/DiskLruCache$Snapshot:close	()V
    //   60: iconst_1
    //   61: ireturn
    //   62: astore_2
    //   63: aload_1
    //   64: invokevirtual 74	okhttp3/internal/cache/DiskLruCache$Snapshot:close	()V
    //   67: aload_2
    //   68: athrow
    //   69: aload_1
    //   70: invokevirtual 74	okhttp3/internal/cache/DiskLruCache$Snapshot:close	()V
    //   73: goto -59 -> 14
    //   76: iconst_0
    //   77: ireturn
    //   78: astore_2
    //   79: goto -10 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	2
    //   38	32	1	localSnapshot	DiskLruCache.Snapshot
    //   62	6	2	localObject	Object
    //   78	1	2	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   39	56	62	finally
    //   39	56	78	java/io/IOException
  }
  
  public String next()
  {
    if (hasNext())
    {
      String str = this.nextUrl;
      this.nextUrl = null;
      this.canRemove = true;
      return str;
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    if (this.canRemove)
    {
      this.delegate.remove();
      return;
    }
    throw new IllegalStateException("remove() before next()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.Cache.2
 * JD-Core Version:    0.7.0.1
 */