package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class SmallSortedMap<K extends Comparable<K>, V>
  extends AbstractMap<K, V>
{
  private List<SmallSortedMap<K, V>.Entry> entryList;
  private boolean isImmutable;
  private volatile SmallSortedMap<K, V>.EntrySet lazyEntrySet;
  private final int maxArraySize;
  private Map<K, V> overflowEntries;
  
  private SmallSortedMap(int paramInt)
  {
    this.maxArraySize = paramInt;
    this.entryList = Collections.emptyList();
    this.overflowEntries = Collections.emptyMap();
  }
  
  private int binarySearchInArray(K paramK)
  {
    int j = this.entryList.size() - 1;
    if (j >= 0)
    {
      i = paramK.compareTo(((SmallSortedMap.Entry)this.entryList.get(j)).getKey());
      if (i > 0) {
        return -(j + 2);
      }
      if (i == 0) {
        return j;
      }
    }
    int i = 0;
    while (i <= j)
    {
      int k = (i + j) / 2;
      int m = paramK.compareTo(((SmallSortedMap.Entry)this.entryList.get(k)).getKey());
      if (m < 0) {
        j = k - 1;
      } else if (m > 0) {
        i = k + 1;
      } else {
        return k;
      }
    }
    return -(i + 1);
  }
  
  private void checkMutable()
  {
    if (!this.isImmutable) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  private void ensureEntryArrayMutable()
  {
    checkMutable();
    if ((this.entryList.isEmpty()) && (!(this.entryList instanceof ArrayList))) {
      this.entryList = new ArrayList(this.maxArraySize);
    }
  }
  
  private SortedMap<K, V> getOverflowEntriesMutable()
  {
    checkMutable();
    if ((this.overflowEntries.isEmpty()) && (!(this.overflowEntries instanceof TreeMap))) {
      this.overflowEntries = new TreeMap();
    }
    return (SortedMap)this.overflowEntries;
  }
  
  static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> newFieldMap(int paramInt)
  {
    return new SmallSortedMap.1(paramInt);
  }
  
  private V removeArrayEntryAt(int paramInt)
  {
    checkMutable();
    Object localObject = ((SmallSortedMap.Entry)this.entryList.remove(paramInt)).getValue();
    if (!this.overflowEntries.isEmpty())
    {
      Iterator localIterator = getOverflowEntriesMutable().entrySet().iterator();
      this.entryList.add(new SmallSortedMap.Entry(this, (Map.Entry)localIterator.next()));
      localIterator.remove();
    }
    return localObject;
  }
  
  public void clear()
  {
    checkMutable();
    if (!this.entryList.isEmpty()) {
      this.entryList.clear();
    }
    if (!this.overflowEntries.isEmpty()) {
      this.overflowEntries.clear();
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    return (binarySearchInArray(paramObject) >= 0) || (this.overflowEntries.containsKey(paramObject));
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    if (this.lazyEntrySet == null) {
      this.lazyEntrySet = new SmallSortedMap.EntrySet(this, null);
    }
    return this.lazyEntrySet;
  }
  
  public V get(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    int i = binarySearchInArray(paramObject);
    if (i >= 0) {
      return ((SmallSortedMap.Entry)this.entryList.get(i)).getValue();
    }
    return this.overflowEntries.get(paramObject);
  }
  
  public Map.Entry<K, V> getArrayEntryAt(int paramInt)
  {
    return (Map.Entry)this.entryList.get(paramInt);
  }
  
  public int getNumArrayEntries()
  {
    return this.entryList.size();
  }
  
  public Iterable<Map.Entry<K, V>> getOverflowEntries()
  {
    if (this.overflowEntries.isEmpty()) {
      return SmallSortedMap.EmptySet.iterable();
    }
    return this.overflowEntries.entrySet();
  }
  
  public boolean isImmutable()
  {
    return this.isImmutable;
  }
  
  public void makeImmutable()
  {
    if (!this.isImmutable)
    {
      Map localMap;
      if (this.overflowEntries.isEmpty()) {
        localMap = Collections.emptyMap();
      } else {
        localMap = Collections.unmodifiableMap(this.overflowEntries);
      }
      this.overflowEntries = localMap;
      this.isImmutable = true;
    }
  }
  
  public V put(K paramK, V paramV)
  {
    checkMutable();
    int i = binarySearchInArray(paramK);
    if (i >= 0) {
      return ((SmallSortedMap.Entry)this.entryList.get(i)).setValue(paramV);
    }
    ensureEntryArrayMutable();
    i = -(i + 1);
    if (i >= this.maxArraySize) {
      return getOverflowEntriesMutable().put(paramK, paramV);
    }
    int j = this.entryList.size();
    int k = this.maxArraySize;
    if (j == k)
    {
      SmallSortedMap.Entry localEntry = (SmallSortedMap.Entry)this.entryList.remove(k - 1);
      getOverflowEntriesMutable().put(localEntry.getKey(), localEntry.getValue());
    }
    this.entryList.add(i, new SmallSortedMap.Entry(this, paramK, paramV));
    return null;
  }
  
  public V remove(Object paramObject)
  {
    checkMutable();
    paramObject = (Comparable)paramObject;
    int i = binarySearchInArray(paramObject);
    if (i >= 0) {
      return removeArrayEntryAt(i);
    }
    if (this.overflowEntries.isEmpty()) {
      return null;
    }
    return this.overflowEntries.remove(paramObject);
  }
  
  public int size()
  {
    return this.entryList.size() + this.overflowEntries.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.SmallSortedMap
 * JD-Core Version:    0.7.0.1
 */