package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractMap;", "K", "V", "", "()V", "_keys", "", "_values", "", "keys", "getKeys", "()Ljava/util/Set;", "size", "", "getSize", "()I", "values", "getValues", "()Ljava/util/Collection;", "containsEntry", "", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "equals", "other", "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "implFindEntry", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "isEmpty", "toString", "", "o", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public abstract class AbstractMap<K, V>
  implements Map<K, V>, KMappedMarker
{
  public static final AbstractMap.Companion Companion = new AbstractMap.Companion(null);
  private volatile Set<? extends K> _keys;
  private volatile Collection<? extends V> _values;
  
  private final Map.Entry<K, V> implFindEntry(K paramK)
  {
    Iterator localIterator = ((Iterable)entrySet()).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!Intrinsics.areEqual(((Map.Entry)localObject).getKey(), paramK));
    for (paramK = localObject;; paramK = null) {
      return (Map.Entry)paramK;
    }
  }
  
  private final String toString(Object paramObject)
  {
    if (paramObject == (AbstractMap)this) {
      return "(this Map)";
    }
    return String.valueOf(paramObject);
  }
  
  private final String toString(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    return toString(paramEntry.getKey()) + "=" + toString(paramEntry.getValue());
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final boolean containsEntry$kotlin_stdlib(@Nullable Map.Entry<?, ?> paramEntry)
  {
    if (!(paramEntry instanceof Map.Entry)) {
      return false;
    }
    Object localObject1 = paramEntry.getKey();
    paramEntry = paramEntry.getValue();
    if (this == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }
    Object localObject2 = ((Map)this).get(localObject1);
    if ((Intrinsics.areEqual(paramEntry, localObject2) ^ true)) {
      return false;
    }
    if (localObject2 == null)
    {
      if (this == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      }
      if (!((Map)this).containsKey(localObject1)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean containsKey(Object paramObject)
  {
    return implFindEntry(paramObject) != null;
  }
  
  public boolean containsValue(Object paramObject)
  {
    Object localObject = (Iterable)entrySet();
    if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {
      return false;
    }
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (Intrinsics.areEqual(((Map.Entry)((Iterator)localObject).next()).getValue(), paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    return getEntries();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == (AbstractMap)this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof Map));
      bool1 = bool2;
    } while (size() != ((Map)paramObject).size());
    paramObject = (Iterable)((Map)paramObject).entrySet();
    if (((paramObject instanceof Collection)) && (((Collection)paramObject).isEmpty())) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      paramObject = paramObject.iterator();
      for (;;)
      {
        if (paramObject.hasNext()) {
          if (!containsEntry$kotlin_stdlib((Map.Entry)paramObject.next()))
          {
            bool1 = false;
            break;
          }
        }
      }
      bool1 = true;
    }
  }
  
  @Nullable
  public V get(Object paramObject)
  {
    paramObject = implFindEntry(paramObject);
    if (paramObject != null) {
      return paramObject.getValue();
    }
    return null;
  }
  
  public abstract Set getEntries();
  
  @NotNull
  public Set<K> getKeys()
  {
    if (this._keys == null) {
      this._keys = ((Set)new AbstractMap.keys.1(this));
    }
    Set localSet = this._keys;
    if (localSet == null) {
      Intrinsics.throwNpe();
    }
    return localSet;
  }
  
  public int getSize()
  {
    return entrySet().size();
  }
  
  @NotNull
  public Collection<V> getValues()
  {
    if (this._values == null) {
      this._values = ((Collection)new AbstractMap.values.1(this));
    }
    Collection localCollection = this._values;
    if (localCollection == null) {
      Intrinsics.throwNpe();
    }
    return localCollection;
  }
  
  public int hashCode()
  {
    return entrySet().hashCode();
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
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
    return CollectionsKt.joinToString$default((Iterable)entrySet(), (CharSequence)", ", (CharSequence)"{", (CharSequence)"}", 0, null, (Function1)new AbstractMap.toString.1(this), 24, null);
  }
  
  public final Collection<V> values()
  {
    return getValues();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.collections.AbstractMap
 * JD-Core Version:    0.7.0.1
 */