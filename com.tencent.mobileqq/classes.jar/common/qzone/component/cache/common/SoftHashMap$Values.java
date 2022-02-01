package common.qzone.component.cache.common;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class SoftHashMap$Values
  extends AbstractCollection<V>
{
  SoftHashMap$Values(SoftHashMap paramSoftHashMap) {}
  
  public void clear()
  {
    this.a.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.a.containsValue(paramObject);
  }
  
  public Iterator<V> iterator()
  {
    return new SoftHashMap.ValueIterator(this.a);
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
      localArrayList.add(localIterator.next());
    }
    return localArrayList.toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    ArrayList localArrayList = new ArrayList(size());
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(localIterator.next());
    }
    return localArrayList.toArray(paramArrayOfT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap.Values
 * JD-Core Version:    0.7.0.1
 */