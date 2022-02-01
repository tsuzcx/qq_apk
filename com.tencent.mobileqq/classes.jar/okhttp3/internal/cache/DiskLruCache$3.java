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
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public DiskLruCache.Snapshot next()
  {
    if (hasNext())
    {
      this.removeSnapshot = this.nextSnapshot;
      this.nextSnapshot = null;
      return this.removeSnapshot;
    }
    throw new NoSuchElementException();
  }
  
  /* Error */
  public void remove()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 74	okhttp3/internal/cache/DiskLruCache$3:removeSnapshot	Lokhttp3/internal/cache/DiskLruCache$Snapshot;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +32 -> 38
    //   9: aload_0
    //   10: getfield 19	okhttp3/internal/cache/DiskLruCache$3:this$0	Lokhttp3/internal/cache/DiskLruCache;
    //   13: aload_1
    //   14: invokestatic 86	okhttp3/internal/cache/DiskLruCache$Snapshot:access$000	(Lokhttp3/internal/cache/DiskLruCache$Snapshot;)Ljava/lang/String;
    //   17: invokevirtual 89	okhttp3/internal/cache/DiskLruCache:remove	(Ljava/lang/String;)Z
    //   20: pop
    //   21: goto +11 -> 32
    //   24: astore_1
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 74	okhttp3/internal/cache/DiskLruCache$3:removeSnapshot	Lokhttp3/internal/cache/DiskLruCache$Snapshot;
    //   30: aload_1
    //   31: athrow
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 74	okhttp3/internal/cache/DiskLruCache$3:removeSnapshot	Lokhttp3/internal/cache/DiskLruCache$Snapshot;
    //   37: return
    //   38: new 91	java/lang/IllegalStateException
    //   41: dup
    //   42: ldc 93
    //   44: invokespecial 96	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   47: athrow
    //   48: astore_1
    //   49: goto -17 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	3
    //   4	10	1	localSnapshot	DiskLruCache.Snapshot
    //   24	7	1	localObject	Object
    //   48	1	1	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   9	21	24	finally
    //   9	21	48	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.cache.DiskLruCache.3
 * JD-Core Version:    0.7.0.1
 */