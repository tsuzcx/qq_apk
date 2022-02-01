package common.qzone.component.cache.common;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class SoftHashMap$EntrySet
  extends AbstractSet<Map.Entry<K, V>>
{
  SoftHashMap$EntrySet(SoftHashMap paramSoftHashMap) {}
  
  public void clear()
  {
    this.a.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Map.Entry;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    SoftHashMap.Entry localEntry = SoftHashMap.a(this.a, paramObject.getKey());
    bool1 = bool2;
    if (localEntry != null)
    {
      bool1 = bool2;
      if (localEntry.equals(paramObject)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new SoftHashMap.EntryIterator(this.a);
  }
  
  public boolean remove(Object paramObject)
  {
    return SoftHashMap.b(this.a, paramObject) != null;
  }
  
  public int size()
  {
    return this.a.size();
  }
  
  public Object[] toArray()
  {
    ArrayList localArrayList = new ArrayList(size());
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new SoftHashMap.SimpleEntry((Map.Entry)localIterator.next()));
    }
    return localArrayList.toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    ArrayList localArrayList = new ArrayList(size());
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new SoftHashMap.SimpleEntry((Map.Entry)localIterator.next()));
    }
    return localArrayList.toArray(paramArrayOfT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap.EntrySet
 * JD-Core Version:    0.7.0.1
 */