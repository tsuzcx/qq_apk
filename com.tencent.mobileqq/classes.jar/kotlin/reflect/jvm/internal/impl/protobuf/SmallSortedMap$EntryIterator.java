package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class SmallSortedMap$EntryIterator
  implements Iterator<Map.Entry<K, V>>
{
  private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
  private boolean nextCalledBeforeRemove;
  private int pos = -1;
  
  private SmallSortedMap$EntryIterator(SmallSortedMap paramSmallSortedMap) {}
  
  private Iterator<Map.Entry<K, V>> getOverflowIterator()
  {
    if (this.lazyOverflowIterator == null) {
      this.lazyOverflowIterator = SmallSortedMap.access$600(this.this$0).entrySet().iterator();
    }
    return this.lazyOverflowIterator;
  }
  
  public boolean hasNext()
  {
    int i = this.pos;
    boolean bool = true;
    if (i + 1 >= SmallSortedMap.access$400(this.this$0).size())
    {
      if (getOverflowIterator().hasNext()) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public Map.Entry<K, V> next()
  {
    this.nextCalledBeforeRemove = true;
    int i = this.pos + 1;
    this.pos = i;
    if (i < SmallSortedMap.access$400(this.this$0).size()) {
      return (Map.Entry)SmallSortedMap.access$400(this.this$0).get(this.pos);
    }
    return (Map.Entry)getOverflowIterator().next();
  }
  
  public void remove()
  {
    if (this.nextCalledBeforeRemove)
    {
      this.nextCalledBeforeRemove = false;
      SmallSortedMap.access$200(this.this$0);
      if (this.pos < SmallSortedMap.access$400(this.this$0).size())
      {
        SmallSortedMap localSmallSortedMap = this.this$0;
        int i = this.pos;
        this.pos = (i - 1);
        SmallSortedMap.access$500(localSmallSortedMap, i);
        return;
      }
      getOverflowIterator().remove();
      return;
    }
    throw new IllegalStateException("remove() was called before next()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.SmallSortedMap.EntryIterator
 * JD-Core Version:    0.7.0.1
 */