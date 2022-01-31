import android.support.v4.util.LruCache;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ssj<KEY, VALUE extends ssi>
{
  public int a;
  public LruCache<KEY, VALUE> a;
  public ConcurrentHashMap<KEY, WeakReference<VALUE>> a;
  
  public ssj(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(50);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new ssk(this, paramInt);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if ((localWeakReference != null) && (localWeakReference.get() == null))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject);
        ved.b("OneObjectCacheList", String.format("key :%s had been remove by jvm", new Object[] { localObject }));
      }
    }
  }
  
  public VALUE a(KEY paramKEY)
  {
    ssi localssi2 = (ssi)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramKEY);
    ssi localssi1 = localssi2;
    if (localssi2 == null)
    {
      WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramKEY);
      localssi1 = localssi2;
      if (localWeakReference != null)
      {
        localssi2 = (ssi)localWeakReference.get();
        localssi1 = localssi2;
        if (localssi2 != null)
        {
          ved.b("OneObjectCacheList", String.format("revert key %s from second cache", new Object[] { paramKEY }));
          a(paramKEY, localssi2);
          localssi1 = localssi2;
        }
      }
    }
    return localssi1;
  }
  
  public VALUE a(KEY paramKEY, VALUE paramVALUE)
  {
    ssi localssi = a(paramKEY);
    if (localssi == null)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramKEY, paramVALUE);
      return paramVALUE;
    }
    localssi.copy(paramVALUE);
    return localssi;
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
    if (i - this.jdField_a_of_type_Int > 50)
    {
      b();
      this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
      ved.a("OneObjectCacheList", "evict second cache data count:%d", Integer.valueOf(i - this.jdField_a_of_type_Int));
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.trimToSize(paramInt);
  }
  
  public void a(KEY paramKEY)
  {
    ssi localssi = (ssi)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(paramKEY);
    if (localssi != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramKEY, new WeakReference(localssi));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ssj
 * JD-Core Version:    0.7.0.1
 */