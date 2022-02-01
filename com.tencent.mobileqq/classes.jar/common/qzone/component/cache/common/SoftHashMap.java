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
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private final float jdField_a_of_type_Float = 0.75F;
  private int jdField_a_of_type_Int;
  private final ReferenceQueue<K> jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private volatile transient Collection<V> jdField_a_of_type_JavaUtilCollection = null;
  private transient Set<Map.Entry<K, V>> jdField_a_of_type_JavaUtilSet = null;
  private SoftHashMap.Entry<K, V>[] jdField_a_of_type_ArrayOfCommonQzoneComponentCacheCommonSoftHashMap$Entry = new SoftHashMap.Entry[16];
  private int jdField_b_of_type_Int = 16;
  private volatile transient Set<K> jdField_b_of_type_JavaUtilSet = null;
  private volatile int c;
  
  private static int a(int paramInt)
  {
    paramInt ^= paramInt >>> 20 ^ paramInt >>> 12;
    return paramInt >>> 4 ^ paramInt >>> 7 ^ paramInt;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 & paramInt2 - 1;
  }
  
  private static int a(Object paramObject)
  {
    return a(paramObject.hashCode());
  }
  
  private SoftHashMap.Entry<K, V> a(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; (paramObject != null) && ((SoftHashMap.Entry.a(paramObject) != i) || (!a(localObject, paramObject.get()))); paramObject = SoftHashMap.Entry.a(paramObject)) {}
    return paramObject;
  }
  
  private void a()
  {
    SoftHashMap.Entry localEntry2 = (SoftHashMap.Entry)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll();
    if (localEntry2 != null)
    {
      int i = a(SoftHashMap.Entry.a(localEntry2), this.jdField_a_of_type_ArrayOfCommonQzoneComponentCacheCommonSoftHashMap$Entry.length);
      Object localObject1 = this.jdField_a_of_type_ArrayOfCommonQzoneComponentCacheCommonSoftHashMap$Entry[i];
      Object localObject2 = localObject1;
      while (localObject1 != null)
      {
        SoftHashMap.Entry localEntry1 = SoftHashMap.Entry.a((SoftHashMap.Entry)localObject1);
        if (localObject1 == localEntry2)
        {
          if (localObject2 == localEntry2) {
            this.jdField_a_of_type_ArrayOfCommonQzoneComponentCacheCommonSoftHashMap$Entry[i] = localEntry1;
          } else {
            SoftHashMap.Entry.a(localObject2, localEntry1);
          }
          SoftHashMap.Entry.a(localEntry2, null);
          SoftHashMap.Entry.a(localEntry2, null);
          this.jdField_a_of_type_Int -= 1;
          break;
        }
        localObject2 = localObject1;
        localObject1 = localEntry1;
      }
    }
  }
  
  private void a(int paramInt)
  {
    SoftHashMap.Entry[] arrayOfEntry1 = a();
    if (arrayOfEntry1.length == 1073741824)
    {
      this.jdField_b_of_type_Int = 2147483647;
      return;
    }
    SoftHashMap.Entry[] arrayOfEntry2 = new SoftHashMap.Entry[paramInt];
    a(arrayOfEntry1, arrayOfEntry2);
    this.jdField_a_of_type_ArrayOfCommonQzoneComponentCacheCommonSoftHashMap$Entry = arrayOfEntry2;
    if (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int / 2)
    {
      this.jdField_b_of_type_Int = ((int)(paramInt * this.jdField_a_of_type_Float));
      return;
    }
    a();
    a(arrayOfEntry2, arrayOfEntry1);
    this.jdField_a_of_type_ArrayOfCommonQzoneComponentCacheCommonSoftHashMap$Entry = arrayOfEntry1;
  }
  
  private void a(SoftHashMap.Entry<K, V>[] paramArrayOfEntry1, SoftHashMap.Entry<K, V>[] paramArrayOfEntry2)
  {
    int i = 0;
    while (i < paramArrayOfEntry1.length)
    {
      Object localObject = paramArrayOfEntry1[i];
      paramArrayOfEntry1[i] = null;
      while (localObject != null)
      {
        SoftHashMap.Entry localEntry = SoftHashMap.Entry.a((SoftHashMap.Entry)localObject);
        if (((SoftHashMap.Entry)localObject).get() == null)
        {
          SoftHashMap.Entry.a((SoftHashMap.Entry)localObject, null);
          SoftHashMap.Entry.a((SoftHashMap.Entry)localObject, null);
          this.jdField_a_of_type_Int -= 1;
        }
        else
        {
          int j = a(SoftHashMap.Entry.a((SoftHashMap.Entry)localObject), paramArrayOfEntry2.length);
          SoftHashMap.Entry.a((SoftHashMap.Entry)localObject, paramArrayOfEntry2[j]);
          paramArrayOfEntry2[j] = localObject;
        }
        localObject = localEntry;
      }
      i += 1;
    }
  }
  
  private boolean a()
  {
    SoftHashMap.Entry[] arrayOfEntry = a();
    int j;
    for (int i = arrayOfEntry.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (SoftHashMap.Entry localEntry = arrayOfEntry[j]; localEntry != null; localEntry = SoftHashMap.Entry.a(localEntry)) {
        if (SoftHashMap.Entry.a(localEntry) == null) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || (paramObject1.equals(paramObject2));
  }
  
  private SoftHashMap.Entry<K, V>[] a()
  {
    a();
    return this.jdField_a_of_type_ArrayOfCommonQzoneComponentCacheCommonSoftHashMap$Entry;
  }
  
  private SoftHashMap.Entry<K, V> b(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {
      return null;
    }
    SoftHashMap.Entry[] arrayOfEntry = a();
    Map.Entry localEntry1 = (Map.Entry)paramObject;
    int i = a(b(localEntry1.getKey()));
    int j = a(i, arrayOfEntry.length);
    paramObject = arrayOfEntry[j];
    Object localObject = paramObject;
    while (paramObject != null)
    {
      SoftHashMap.Entry localEntry = SoftHashMap.Entry.a(paramObject);
      if ((i == SoftHashMap.Entry.a(paramObject)) && (paramObject.equals(localEntry1)))
      {
        this.c += 1;
        this.jdField_a_of_type_Int -= 1;
        if (localObject == paramObject)
        {
          arrayOfEntry[j] = localEntry;
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
  
  private static <K> K b(K paramK)
  {
    Object localObject = paramK;
    if (paramK == null) {
      localObject = jdField_a_of_type_JavaLangObject;
    }
    return localObject;
  }
  
  private static <K> K c(K paramK)
  {
    K ? = paramK;
    if (paramK == jdField_a_of_type_JavaLangObject) {
      ? = null;
    }
    return ?;
  }
  
  public void clear()
  {
    while (this.jdField_a_of_type_JavaLangRefReferenceQueue.poll() != null) {}
    this.c += 1;
    SoftHashMap.Entry[] arrayOfEntry = this.jdField_a_of_type_ArrayOfCommonQzoneComponentCacheCommonSoftHashMap$Entry;
    int i = 0;
    while (i < arrayOfEntry.length)
    {
      arrayOfEntry[i] = null;
      i += 1;
    }
    this.jdField_a_of_type_Int = 0;
    while (this.jdField_a_of_type_JavaLangRefReferenceQueue.poll() != null) {}
  }
  
  public boolean containsKey(Object paramObject)
  {
    return a(paramObject) != null;
  }
  
  public boolean containsValue(Object paramObject)
  {
    if (paramObject == null) {
      return a();
    }
    SoftHashMap.Entry[] arrayOfEntry = a();
    int j;
    for (int i = arrayOfEntry.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (SoftHashMap.Entry localEntry = arrayOfEntry[j]; localEntry != null; localEntry = SoftHashMap.Entry.a(localEntry)) {
        if (paramObject.equals(SoftHashMap.Entry.a(localEntry))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilSet;
    if (localObject != null) {
      return localObject;
    }
    localObject = new SoftHashMap.EntrySet(this);
    this.jdField_a_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public V get(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; paramObject != null; paramObject = SoftHashMap.Entry.a(paramObject)) {
      if ((SoftHashMap.Entry.a(paramObject) == i) && (a(localObject, paramObject.get()))) {
        return SoftHashMap.Entry.a(paramObject);
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
    Object localObject = this.jdField_b_of_type_JavaUtilSet;
    if (localObject != null) {
      return localObject;
    }
    localObject = new SoftHashMap.KeySet(this);
    this.jdField_b_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public V put(K paramK, V paramV)
  {
    Object localObject = b(paramK);
    int i = a(localObject);
    SoftHashMap.Entry[] arrayOfEntry = a();
    int j = a(i, arrayOfEntry.length);
    for (paramK = arrayOfEntry[j]; paramK != null; paramK = SoftHashMap.Entry.a(paramK)) {
      if ((i == SoftHashMap.Entry.a(paramK)) && (a(localObject, paramK.get())))
      {
        localObject = SoftHashMap.Entry.a(paramK);
        if (paramV != localObject) {
          SoftHashMap.Entry.a(paramK, paramV);
        }
        return localObject;
      }
    }
    this.c += 1;
    paramK = arrayOfEntry[j];
    arrayOfEntry[j] = new SoftHashMap.Entry(localObject, paramV, this.jdField_a_of_type_JavaLangRefReferenceQueue, i, paramK);
    i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    if (i >= this.jdField_b_of_type_Int) {
      a(arrayOfEntry.length * 2);
    }
    return null;
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    int i = paramMap.size();
    if (i == 0) {
      return;
    }
    if (i > this.jdField_b_of_type_Int)
    {
      int j = (int)(i / this.jdField_a_of_type_Float + 1.0F);
      i = j;
      if (j > 1073741824) {
        i = 1073741824;
      }
      j = this.jdField_a_of_type_ArrayOfCommonQzoneComponentCacheCommonSoftHashMap$Entry.length;
      while (j < i) {
        j <<= 1;
      }
      if (j > this.jdField_a_of_type_ArrayOfCommonQzoneComponentCacheCommonSoftHashMap$Entry.length) {
        a(j);
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
    Object localObject2 = b(paramObject);
    int i = a(localObject2);
    SoftHashMap.Entry[] arrayOfEntry = a();
    int j = a(i, arrayOfEntry.length);
    paramObject = arrayOfEntry[j];
    Object localObject1 = paramObject;
    while (paramObject != null)
    {
      SoftHashMap.Entry localEntry = SoftHashMap.Entry.a(paramObject);
      if ((i == SoftHashMap.Entry.a(paramObject)) && (a(localObject2, paramObject.get())))
      {
        this.c += 1;
        this.jdField_a_of_type_Int -= 1;
        if (localObject1 == paramObject) {
          arrayOfEntry[j] = localEntry;
        } else {
          SoftHashMap.Entry.a(localObject1, localEntry);
        }
        return SoftHashMap.Entry.a(paramObject);
      }
      localObject1 = paramObject;
      paramObject = localEntry;
    }
    return null;
  }
  
  public int size()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return 0;
    }
    a();
    return this.jdField_a_of_type_Int;
  }
  
  public Collection<V> values()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilCollection;
    if (localObject != null) {
      return localObject;
    }
    localObject = new SoftHashMap.Values(this);
    this.jdField_a_of_type_JavaUtilCollection = ((Collection)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap
 * JD-Core Version:    0.7.0.1
 */