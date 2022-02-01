package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/EmptyMap;", "", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "serialVersionUID", "", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "containsValue", "value", "equals", "other", "get", "hashCode", "isEmpty", "readResolve", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class EmptyMap
  implements Serializable, Map, KMappedMarker
{
  public static final EmptyMap INSTANCE = new EmptyMap();
  private static final long serialVersionUID = 8246714829545688274L;
  
  private final Object readResolve()
  {
    return INSTANCE;
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean containsKey(@Nullable Object paramObject)
  {
    return false;
  }
  
  public boolean containsValue(@NotNull Void paramVoid)
  {
    Intrinsics.checkParameterIsNotNull(paramVoid, "value");
    return false;
  }
  
  public final Set<Map.Entry> entrySet()
  {
    return getEntries();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof Map)) && (((Map)paramObject).isEmpty());
  }
  
  @Nullable
  public Void get(@Nullable Object paramObject)
  {
    return null;
  }
  
  @NotNull
  public Set<Map.Entry> getEntries()
  {
    return (Set)EmptySet.INSTANCE;
  }
  
  @NotNull
  public Set<Object> getKeys()
  {
    return (Set)EmptySet.INSTANCE;
  }
  
  public int getSize()
  {
    return 0;
  }
  
  @NotNull
  public Collection getValues()
  {
    return (Collection)EmptyList.INSTANCE;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public final Set<Object> keySet()
  {
    return getKeys();
  }
  
  public Void put(Object paramObject, Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void putAll(Map paramMap)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public Object remove(Object paramObject)
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
    return "{}";
  }
  
  public final Collection values()
  {
    return getValues();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.EmptyMap
 * JD-Core Version:    0.7.0.1
 */