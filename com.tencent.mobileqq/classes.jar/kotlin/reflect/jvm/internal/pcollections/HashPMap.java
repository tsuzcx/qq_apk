package kotlin.reflect.jvm.internal.pcollections;

import org.jetbrains.annotations.NotNull;

public final class HashPMap<K, V>
{
  private static final HashPMap<Object, Object> EMPTY = new HashPMap(IntTreePMap.empty(), 0);
  private final IntTreePMap<ConsPStack<MapEntry<K, V>>> intMap;
  private final int size;
  
  private HashPMap(IntTreePMap<ConsPStack<MapEntry<K, V>>> paramIntTreePMap, int paramInt)
  {
    this.intMap = paramIntTreePMap;
    this.size = paramInt;
  }
  
  @NotNull
  public static <K, V> HashPMap<K, V> empty()
  {
    HashPMap localHashPMap = EMPTY;
    if (localHashPMap == null) {
      $$$reportNull$$$0(0);
    }
    return localHashPMap;
  }
  
  private ConsPStack<MapEntry<K, V>> getEntries(int paramInt)
  {
    ConsPStack localConsPStack2 = (ConsPStack)this.intMap.get(paramInt);
    ConsPStack localConsPStack1 = localConsPStack2;
    if (localConsPStack2 == null) {
      localConsPStack1 = ConsPStack.empty();
    }
    return localConsPStack1;
  }
  
  private static <K, V> int keyIndexIn(ConsPStack<MapEntry<K, V>> paramConsPStack, Object paramObject)
  {
    int i = 0;
    while ((paramConsPStack != null) && (paramConsPStack.size() > 0))
    {
      if (((MapEntry)paramConsPStack.first).key.equals(paramObject)) {
        return i;
      }
      paramConsPStack = paramConsPStack.rest;
      i += 1;
    }
    return -1;
  }
  
  public boolean containsKey(Object paramObject)
  {
    return keyIndexIn(getEntries(paramObject.hashCode()), paramObject) != -1;
  }
  
  public V get(Object paramObject)
  {
    for (ConsPStack localConsPStack = getEntries(paramObject.hashCode()); (localConsPStack != null) && (localConsPStack.size() > 0); localConsPStack = localConsPStack.rest)
    {
      MapEntry localMapEntry = (MapEntry)localConsPStack.first;
      if (localMapEntry.key.equals(paramObject)) {
        return localMapEntry.value;
      }
    }
    return null;
  }
  
  @NotNull
  public HashPMap<K, V> minus(Object paramObject)
  {
    ConsPStack localConsPStack = getEntries(paramObject.hashCode());
    int i = keyIndexIn(localConsPStack, paramObject);
    if (i == -1) {
      return this;
    }
    localConsPStack = localConsPStack.minus(i);
    if (localConsPStack.size() == 0) {
      return new HashPMap(this.intMap.minus(paramObject.hashCode()), this.size - 1);
    }
    return new HashPMap(this.intMap.plus(paramObject.hashCode(), localConsPStack), this.size - 1);
  }
  
  @NotNull
  public HashPMap<K, V> plus(K paramK, V paramV)
  {
    ConsPStack localConsPStack2 = getEntries(paramK.hashCode());
    int i = localConsPStack2.size();
    int j = keyIndexIn(localConsPStack2, paramK);
    ConsPStack localConsPStack1 = localConsPStack2;
    if (j != -1) {
      localConsPStack1 = localConsPStack2.minus(j);
    }
    paramV = localConsPStack1.plus(new MapEntry(paramK, paramV));
    return new HashPMap(this.intMap.plus(paramK.hashCode(), paramV), this.size - i + paramV.size());
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.pcollections.HashPMap
 * JD-Core Version:    0.7.0.1
 */