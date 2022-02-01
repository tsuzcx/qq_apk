package kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/MapWithDefaultImpl;", "K", "V", "Lkotlin/collections/MapWithDefault;", "map", "", "default", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "key", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "getMap", "()Ljava/util/Map;", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "(Ljava/lang/Object;)Z", "containsValue", "value", "equals", "other", "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrImplicitDefault", "hashCode", "isEmpty", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class MapWithDefaultImpl<K, V>
  implements MapWithDefault<K, V>
{
  private final Function1<K, V> jdField_default;
  @NotNull
  private final Map<K, V> map;
  
  public MapWithDefaultImpl(@NotNull Map<K, ? extends V> paramMap, @NotNull Function1<? super K, ? extends V> paramFunction1)
  {
    this.map = paramMap;
    this.jdField_default = paramFunction1;
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean containsKey(Object paramObject)
  {
    return getMap().containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return getMap().containsValue(paramObject);
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    return getEntries();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return getMap().equals(paramObject);
  }
  
  @Nullable
  public V get(Object paramObject)
  {
    return getMap().get(paramObject);
  }
  
  @NotNull
  public Set<Map.Entry<K, V>> getEntries()
  {
    return getMap().entrySet();
  }
  
  @NotNull
  public Set<K> getKeys()
  {
    return getMap().keySet();
  }
  
  @NotNull
  public Map<K, V> getMap()
  {
    return this.map;
  }
  
  public V getOrImplicitDefault(K paramK)
  {
    Map localMap = getMap();
    Object localObject2 = localMap.get(paramK);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (!localMap.containsKey(paramK)) {
        localObject1 = this.jdField_default.invoke(paramK);
      }
    }
    return localObject1;
  }
  
  public int getSize()
  {
    return getMap().size();
  }
  
  @NotNull
  public Collection<V> getValues()
  {
    return getMap().values();
  }
  
  public int hashCode()
  {
    return getMap().hashCode();
  }
  
  public boolean isEmpty()
  {
    return getMap().isEmpty();
  }
  
  public final Set<K> keySet()
  {
    return getKeys();
  }
  
  public V put(K paramK, V paramV)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public V remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final int size()
  {
    return getSize();
  }
  
  @NotNull
  public String toString()
  {
    return getMap().toString();
  }
  
  public final Collection<V> values()
  {
    return getValues();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.collections.MapWithDefaultImpl
 * JD-Core Version:    0.7.0.1
 */