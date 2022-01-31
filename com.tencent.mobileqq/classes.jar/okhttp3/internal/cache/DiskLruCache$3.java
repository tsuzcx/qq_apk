package okhttp3.internal.cache;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

class DiskLruCache$3
  implements Iterator<DiskLruCache.Snapshot>
{
  final Iterator<DiskLruCache.Entry> delegate = new ArrayList(this.this$0.lruEntries.values()).iterator();
  DiskLruCache.Snapshot nextSnapshot;
  DiskLruCache.Snapshot removeSnapshot;
  
  DiskLruCache$3(DiskLruCache paramDiskLruCache) {}
  
  public boolean hasNext()
  {
    if (this.nextSnapshot != null) {
      return true;
    }
    synchronized (this.this$0)
    {
      if (this.this$0.closed) {
        return false;
      }
      while (this.delegate.hasNext())
      {
        Object localObject1 = (DiskLruCache.Entry)this.delegate.next();
        if (((DiskLruCache.Entry)localObject1).readable)
        {
          localObject1 = ((DiskLruCache.Entry)localObject1).snapshot();
          if (localObject1 != null)
          {
            this.nextSnapshot = ((DiskLruCache.Snapshot)localObject1);
            return true;
          }
        }
      }
      return false;
    }
  }
  
  public DiskLruCache.Snapshot next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    this.removeSnapshot = this.nextSnapshot;
    this.nextSnapshot = null;
    return this.removeSnapshot;
  }
  
  /* Error */
  public void remove()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 77	okhttp3/internal/cache/DiskLruCache$3:removeSnapshot	Lokhttp3/internal/cache/DiskLruCache$Snapshot;
    //   4: ifnonnull +13 -> 17
    //   7: new 82	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc 84
    //   13: invokespecial 87	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_0
    //   18: getfield 19	okhttp3/internal/cache/DiskLruCache$3:this$0	Lokhttp3/internal/cache/DiskLruCache;
    //   21: aload_0
    //   22: getfield 77	okhttp3/internal/cache/DiskLruCache$3:removeSnapshot	Lokhttp3/internal/cache/DiskLruCache$Snapshot;
    //   25: invokestatic 93	okhttp3/internal/cache/DiskLruCache$Snapshot:access$000	(Lokhttp3/internal/cache/DiskLruCache$Snapshot;)Ljava/lang/String;
    //   28: invokevirtual 96	okhttp3/internal/cache/DiskLruCache:remove	(Ljava/lang/String;)Z
    //   31: pop
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 77	okhttp3/internal/cache/DiskLruCache$3:removeSnapshot	Lokhttp3/internal/cache/DiskLruCache$Snapshot;
    //   37: return
    //   38: astore_1
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 77	okhttp3/internal/cache/DiskLruCache$3:removeSnapshot	Lokhttp3/internal/cache/DiskLruCache$Snapshot;
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 77	okhttp3/internal/cache/DiskLruCache$3:removeSnapshot	Lokhttp3/internal/cache/DiskLruCache$Snapshot;
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	3
    //   38	1	1	localIOException	java.io.IOException
    //   45	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	32	38	java/io/IOException
    //   17	32	45	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.cache.DiskLruCache.3
 * JD-Core Version:    0.7.0.1
 */