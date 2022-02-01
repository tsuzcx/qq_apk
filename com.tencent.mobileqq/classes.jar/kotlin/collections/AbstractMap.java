package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
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
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (Intrinsics.areEqual(((Map.Entry)localObject).getKey(), paramK))
      {
        paramK = localObject;
        break label52;
      }
    }
    paramK = null;
    label52:
    return (Map.Entry)paramK;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(toString(paramEntry.getKey()));
    localStringBuilder.append("=");
    localStringBuilder.append(toString(paramEntry.getValue()));
    return localStringBuilder.toString();
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
    Map localMap = (Map)this;
    Object localObject2 = localMap.get(localObject1);
    if ((Intrinsics.areEqual(paramEntry, localObject2) ^ true)) {
      return false;
    }
    return (localObject2 != null) || (localMap.containsKey(localObject1));
  }
  
  public boolean containsKey(Object paramObject)
  {
    return implFindEntry(paramObject) != null;
  }
  
  public boolean containsValue(Object paramObject)
  {
    Object localObject = (Iterable)entrySet();
    boolean bool1 = localObject instanceof Collection;
    boolean bool2 = false;
    if ((bool1) && (((Collection)localObject).isEmpty())) {
      return false;
    }
    localObject = ((Iterable)localObject).iterator();
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (!Intrinsics.areEqual(((Map.Entry)((Iterator)localObject).next()).getValue(), paramObject));
    bool1 = true;
    return bool1;
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    return getEntries();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    AbstractMap localAbstractMap = (AbstractMap)this;
    boolean bool2 = true;
    if (paramObject == localAbstractMap) {
      return true;
    }
    if (!(paramObject instanceof Map)) {
      return false;
    }
    int i = size();
    paramObject = (Map)paramObject;
    if (i != paramObject.size()) {
      return false;
    }
    paramObject = (Iterable)paramObject.entrySet();
    if (((paramObject instanceof Collection)) && (((Collection)paramObject).isEmpty())) {
      return true;
    }
    paramObject = paramObject.iterator();
    do
    {
      bool1 = bool2;
      if (!paramObject.hasNext()) {
        break;
      }
    } while (containsEntry$kotlin_stdlib((Map.Entry)paramObject.next()));
    boolean bool1 = false;
    return bool1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.AbstractMap
 * JD-Core Version:    0.7.0.1
 */