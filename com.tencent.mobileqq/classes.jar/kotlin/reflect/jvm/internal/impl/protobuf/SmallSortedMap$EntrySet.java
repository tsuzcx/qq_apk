package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class SmallSortedMap$EntrySet
  extends AbstractSet<Map.Entry<K, V>>
{
  private SmallSortedMap$EntrySet(SmallSortedMap paramSmallSortedMap) {}
  
  public boolean add(Map.Entry<K, V> paramEntry)
  {
    if (!contains(paramEntry))
    {
      this.this$0.put((Comparable)paramEntry.getKey(), paramEntry.getValue());
      return true;
    }
    return false;
  }
  
  public void clear()
  {
    this.this$0.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    Object localObject = (Map.Entry)paramObject;
    paramObject = this.this$0.get(((Map.Entry)localObject).getKey());
    localObject = ((Map.Entry)localObject).getValue();
    return (paramObject == localObject) || ((paramObject != null) && (paramObject.equals(localObject)));
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new SmallSortedMap.EntryIterator(this.this$0, null);
  }
  
  public boolean remove(Object paramObject)
  {
    paramObject = (Map.Entry)paramObject;
    if (contains(paramObject))
    {
      this.this$0.remove(paramObject.getKey());
      return true;
    }
    return false;
  }
  
  public int size()
  {
    return this.this$0.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.SmallSortedMap.EntrySet
 * JD-Core Version:    0.7.0.1
 */