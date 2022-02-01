package common.qzone.component.cache.common;

import java.lang.ref.ReferenceQueue;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class SoftHashMap<K, V>
  extends AbstractMap<K, V>
{
  private static final Object a = new Object();
  private SoftHashMap.Entry<K, V>[] b = new SoftHashMap.Entry[16];
  private int c;
  private int d = 16;
  private final float e = 0.75F;
  private final ReferenceQueue<K> f = new ReferenceQueue();
  private volatile int g;
  private transient Set<Map.Entry<K, V>> h = null;
  private volatile transient Set<K> i = null;
  private volatile transient Collection<V> j = null;
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 & paramInt2 - 1;
  }
  
  private void a()
  {
    SoftHashMap.Entry localEntry2 = (SoftHashMap.Entry)this.f.poll();
    if (localEntry2 != null)
    {
      int k = a(SoftHashMap.Entry.a(localEntry2), this.b.length);
      Object localObject1 = this.b[k];
      Object localObject2 = localObject1;
      while (localObject1 != null)
      {
        SoftHashMap.Entry localEntry1 = SoftHashMap.Entry.c((SoftHashMap.Entry)localObject1);
        if (localObject1 == localEntry2)
        {
          if (localObject2 == localEntry2) {
            this.b[k] = localEntry1;
          } else {
            SoftHashMap.Entry.a(localObject2, localEntry1);
          }
          SoftHashMap.Entry.a(localEntry2, null);
          SoftHashMap.Entry.a(localEntry2, null);
          this.c -= 1;
          break;
        }
        localObject2 = localObject1;
        localObject1 = localEntry1;
      }
    }
  }
  
  private void a(int paramInt)
  {
    SoftHashMap.Entry[] arrayOfEntry1 = b();
    if (arrayOfEntry1.length == 1073741824)
    {
      this.d = 2147483647;
      return;
    }
    SoftHashMap.Entry[] arrayOfEntry2 = new SoftHashMap.Entry[paramInt];
    a(arrayOfEntry1, arrayOfEntry2);
    this.b = arrayOfEntry2;
    if (this.c >= this.d / 2)
    {
      this.d = ((int)(paramInt * this.e));
      return;
    }
    a();
    a(arrayOfEntry2, arrayOfEntry1);
    this.b = arrayOfEntry1;
  }
  
  private void a(SoftHashMap.Entry<K, V>[] paramArrayOfEntry1, SoftHashMap.Entry<K, V>[] paramArrayOfEntry2)
  {
    int k = 0;
    while (k < paramArrayOfEntry1.length)
    {
      Object localObject = paramArrayOfEntry1[k];
      paramArrayOfEntry1[k] = null;
      while (localObject != null)
      {
        SoftHashMap.Entry localEntry = SoftHashMap.Entry.c((SoftHashMap.Entry)localObject);
        if (((SoftHashMap.Entry)localObject).get() == null)
        {
          SoftHashMap.Entry.a((SoftHashMap.Entry)localObject, null);
          SoftHashMap.Entry.a((SoftHashMap.Entry)localObject, null);
          this.c -= 1;
        }
        else
        {
          int m = a(SoftHashMap.Entry.a((SoftHashMap.Entry)localObject), paramArrayOfEntry2.length);
          SoftHashMap.Entry.a((SoftHashMap.Entry)localObject, paramArrayOfEntry2[m]);
          paramArrayOfEntry2[m] = localObject;
        }
        localObject = localEntry;
      }
      k += 1;
    }
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || (paramObject1.equals(paramObject2));
  }
  
  private static int b(int paramInt)
  {
    paramInt ^= paramInt >>> 20 ^ paramInt >>> 12;
    return paramInt >>> 4 ^ paramInt >>> 7 ^ paramInt;
  }
  
  private SoftHashMap.Entry<K, V> b(Object paramObject)
  {
    Object localObject = d(paramObject);
    int k = f(localObject);
    paramObject = b();
    for (paramObject = paramObject[a(k, paramObject.length)]; (paramObject != null) && ((SoftHashMap.Entry.a(paramObject) != k) || (!a(localObject, paramObject.get()))); paramObject = SoftHashMap.Entry.c(paramObject)) {}
    return paramObject;
  }
  
  private SoftHashMap.Entry<K, V>[] b()
  {
    a();
    return this.b;
  }
  
  private SoftHashMap.Entry<K, V> c(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {
      return null;
    }
    SoftHashMap.Entry[] arrayOfEntry = b();
    Map.Entry localEntry1 = (Map.Entry)paramObject;
    int k = f(d(localEntry1.getKey()));
    int m = a(k, arrayOfEntry.length);
    paramObject = arrayOfEntry[m];
    Object localObject = paramObject;
    while (paramObject != null)
    {
      SoftHashMap.Entry localEntry = SoftHashMap.Entry.c(paramObject);
      if ((k == SoftHashMap.Entry.a(paramObject)) && (paramObject.equals(localEntry1)))
      {
        this.g += 1;
        this.c -= 1;
        if (localObject == paramObject)
        {
          arrayOfEntry[m] = localEntry;
          return paramObject;
        }
        SoftHashMap.Entry.a(localObject, localEntry);
        return paramObject;
      }
      localObject = paramObject;
      paramObject = localEntry;
    }
    return null;
  }
  
  private boolean c()
  {
    SoftHashMap.Entry[] arrayOfEntry = b();
    int m;
    for (int k = arrayOfEntry.length;; k = m)
    {
      m = k - 1;
      if (k <= 0) {
        break;
      }
      for (SoftHashMap.Entry localEntry = arrayOfEntry[m]; localEntry != null; localEntry = SoftHashMap.Entry.c(localEntry)) {
        if (SoftHashMap.Entry.b(localEntry) == null) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static <K> K d(K paramK)
  {
    Object localObject = paramK;
    if (paramK == null) {
      localObject = a;
    }
    return localObject;
  }
  
  private static <K> K e(K paramK)
  {
    K ? = paramK;
    if (paramK == a) {
      ? = null;
    }
    return ?;
  }
  
  private static int f(Object paramObject)
  {
    return b(paramObject.hashCode());
  }
  
  public void clear()
  {
    while (this.f.poll() != null) {}
    this.g += 1;
    SoftHashMap.Entry[] arrayOfEntry = this.b;
    int k = 0;
    while (k < arrayOfEntry.length)
    {
      arrayOfEntry[k] = null;
      k += 1;
    }
    this.c = 0;
    while (this.f.poll() != null) {}
  }
  
  public boolean containsKey(Object paramObject)
  {
    return b(paramObject) != null;
  }
  
  public boolean containsValue(Object paramObject)
  {
    if (paramObject == null) {
      return c();
    }
    SoftHashMap.Entry[] arrayOfEntry = b();
    int m;
    for (int k = arrayOfEntry.length;; k = m)
    {
      m = k - 1;
      if (k <= 0) {
        break;
      }
      for (SoftHashMap.Entry localEntry = arrayOfEntry[m]; localEntry != null; localEntry = SoftHashMap.Entry.c(localEntry)) {
        if (paramObject.equals(SoftHashMap.Entry.b(localEntry))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Object localObject = this.h;
    if (localObject != null) {
      return localObject;
    }
    localObject = new SoftHashMap.EntrySet(this);
    this.h = ((Set)localObject);
    return localObject;
  }
  
  public V get(Object paramObject)
  {
    Object localObject = d(paramObject);
    int k = f(localObject);
    paramObject = b();
    for (paramObject = paramObject[a(k, paramObject.length)]; paramObject != null; paramObject = SoftHashMap.Entry.c(paramObject)) {
      if ((SoftHashMap.Entry.a(paramObject) == k) && (a(localObject, paramObject.get()))) {
        return SoftHashMap.Entry.b(paramObject);
      }
    }
    return null;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public Set<K> keySet()
  {
    Object localObject = this.i;
    if (localObject != null) {
      return localObject;
    }
    localObject = new SoftHashMap.KeySet(this);
    this.i = ((Set)localObject);
    return localObject;
  }
  
  public V put(K paramK, V paramV)
  {
    Object localObject = d(paramK);
    int k = f(localObject);
    SoftHashMap.Entry[] arrayOfEntry = b();
    int m = a(k, arrayOfEntry.length);
    for (paramK = arrayOfEntry[m]; paramK != null; paramK = SoftHashMap.Entry.c(paramK)) {
      if ((k == SoftHashMap.Entry.a(paramK)) && (a(localObject, paramK.get())))
      {
        localObject = SoftHashMap.Entry.b(paramK);
        if (paramV != localObject) {
          SoftHashMap.Entry.a(paramK, paramV);
        }
        return localObject;
      }
    }
    this.g += 1;
    paramK = arrayOfEntry[m];
    arrayOfEntry[m] = new SoftHashMap.Entry(localObject, paramV, this.f, k, paramK);
    k = this.c + 1;
    this.c = k;
    if (k >= this.d) {
      a(arrayOfEntry.length * 2);
    }
    return null;
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    int k = paramMap.size();
    if (k == 0) {
      return;
    }
    if (k > this.d)
    {
      int m = (int)(k / this.e + 1.0F);
      k = m;
      if (m > 1073741824) {
        k = 1073741824;
      }
      m = this.b.length;
      while (m < k) {
        m <<= 1;
      }
      if (m > this.b.length) {
        a(m);
      }
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public V remove(Object paramObject)
  {
    Object localObject2 = d(paramObject);
    int k = f(localObject2);
    SoftHashMap.Entry[] arrayOfEntry = b();
    int m = a(k, arrayOfEntry.length);
    paramObject = arrayOfEntry[m];
    Object localObject1 = paramObject;
    while (paramObject != null)
    {
      SoftHashMap.Entry localEntry = SoftHashMap.Entry.c(paramObject);
      if ((k == SoftHashMap.Entry.a(paramObject)) && (a(localObject2, paramObject.get())))
      {
        this.g += 1;
        this.c -= 1;
        if (localObject1 == paramObject) {
          arrayOfEntry[m] = localEntry;
        } else {
          SoftHashMap.Entry.a(localObject1, localEntry);
        }
        return SoftHashMap.Entry.b(paramObject);
      }
      localObject1 = paramObject;
      paramObject = localEntry;
    }
    return null;
  }
  
  public int size()
  {
    if (this.c == 0) {
      return 0;
    }
    a();
    return this.c;
  }
  
  public Collection<V> values()
  {
    Object localObject = this.j;
    if (localObject != null) {
      return localObject;
    }
    localObject = new SoftHashMap.Values(this);
    this.j = ((Collection)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap
 * JD-Core Version:    0.7.0.1
 */