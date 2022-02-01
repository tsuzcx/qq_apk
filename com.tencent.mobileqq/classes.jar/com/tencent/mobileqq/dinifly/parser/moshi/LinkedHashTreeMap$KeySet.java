package com.tencent.mobileqq.dinifly.parser.moshi;

import java.util.AbstractSet;
import java.util.Iterator;

final class LinkedHashTreeMap$KeySet
  extends AbstractSet<K>
{
  LinkedHashTreeMap$KeySet(LinkedHashTreeMap paramLinkedHashTreeMap) {}
  
  public void clear()
  {
    this.this$0.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.this$0.containsKey(paramObject);
  }
  
  public Iterator<K> iterator()
  {
    return new LinkedHashTreeMap.KeySet.1(this);
  }
  
  public boolean remove(Object paramObject)
  {
    return this.this$0.removeInternalByKey(paramObject) != null;
  }
  
  public int size()
  {
    return this.this$0.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.moshi.LinkedHashTreeMap.KeySet
 * JD-Core Version:    0.7.0.1
 */