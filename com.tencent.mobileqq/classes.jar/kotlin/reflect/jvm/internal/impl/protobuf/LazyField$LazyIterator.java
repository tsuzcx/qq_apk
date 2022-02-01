package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.Map.Entry;

class LazyField$LazyIterator<K>
  implements Iterator<Map.Entry<K, Object>>
{
  private Iterator<Map.Entry<K, Object>> iterator;
  
  public LazyField$LazyIterator(Iterator<Map.Entry<K, Object>> paramIterator)
  {
    this.iterator = paramIterator;
  }
  
  public boolean hasNext()
  {
    return this.iterator.hasNext();
  }
  
  public Map.Entry<K, Object> next()
  {
    Map.Entry localEntry = (Map.Entry)this.iterator.next();
    if ((localEntry.getValue() instanceof LazyField)) {
      return new LazyField.LazyEntry(localEntry, null);
    }
    return localEntry;
  }
  
  public void remove()
  {
    this.iterator.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.LazyField.LazyIterator
 * JD-Core Version:    0.7.0.1
 */