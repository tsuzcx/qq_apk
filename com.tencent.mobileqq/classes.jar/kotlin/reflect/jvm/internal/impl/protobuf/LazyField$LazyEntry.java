package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Map.Entry;

class LazyField$LazyEntry<K>
  implements Map.Entry<K, Object>
{
  private Map.Entry<K, LazyField> entry;
  
  private LazyField$LazyEntry(Map.Entry<K, LazyField> paramEntry)
  {
    this.entry = paramEntry;
  }
  
  public K getKey()
  {
    return this.entry.getKey();
  }
  
  public Object getValue()
  {
    LazyField localLazyField = (LazyField)this.entry.getValue();
    if (localLazyField == null) {
      return null;
    }
    return localLazyField.getValue();
  }
  
  public Object setValue(Object paramObject)
  {
    if ((paramObject instanceof MessageLite)) {
      return ((LazyField)this.entry.getValue()).setValue((MessageLite)paramObject);
    }
    throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.LazyField.LazyEntry
 * JD-Core Version:    0.7.0.1
 */