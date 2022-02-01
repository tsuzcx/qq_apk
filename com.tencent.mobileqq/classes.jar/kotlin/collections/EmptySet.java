package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/EmptySet;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "hashCode", "isEmpty", "iterator", "", "readResolve", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class EmptySet
  implements Serializable, Set, KMappedMarker
{
  public static final EmptySet INSTANCE = new EmptySet();
  private static final long serialVersionUID = 3406603774387020532L;
  
  private final Object readResolve()
  {
    return INSTANCE;
  }
  
  public boolean add(Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean contains(@NotNull Void paramVoid)
  {
    Intrinsics.checkParameterIsNotNull(paramVoid, "element");
    return false;
  }
  
  public boolean containsAll(@NotNull Collection paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    return paramCollection.isEmpty();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof Set)) && (((Set)paramObject).isEmpty());
  }
  
  public int getSize()
  {
    return 0;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  @NotNull
  public Iterator iterator()
  {
    return (Iterator)EmptyIterator.INSTANCE;
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean removeAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean retainAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final int size()
  {
    return getSize();
  }
  
  public Object[] toArray()
  {
    return CollectionToArray.toArray(this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return CollectionToArray.toArray(this, paramArrayOfT);
  }
  
  @NotNull
  public String toString()
  {
    return "[]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.EmptySet
 * JD-Core Version:    0.7.0.1
 */