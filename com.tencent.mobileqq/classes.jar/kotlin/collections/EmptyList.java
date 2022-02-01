package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/EmptyList;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "()V", "serialVersionUID", "", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "get", "index", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "readResolve", "subList", "fromIndex", "toIndex", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class EmptyList
  implements Serializable, List, RandomAccess, KMappedMarker
{
  public static final EmptyList INSTANCE = new EmptyList();
  private static final long serialVersionUID = -7390468764508069838L;
  
  private final Object readResolve()
  {
    return INSTANCE;
  }
  
  public void add(int paramInt, Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean add(Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(int paramInt, Collection paramCollection)
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
    return ((paramObject instanceof List)) && (((List)paramObject).isEmpty());
  }
  
  @NotNull
  public Void get(int paramInt)
  {
    throw ((Throwable)new IndexOutOfBoundsException("Empty list doesn't contain element at index " + paramInt + '.'));
  }
  
  public int getSize()
  {
    return 0;
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public int indexOf(@NotNull Void paramVoid)
  {
    Intrinsics.checkParameterIsNotNull(paramVoid, "element");
    return -1;
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
  
  public int lastIndexOf(@NotNull Void paramVoid)
  {
    Intrinsics.checkParameterIsNotNull(paramVoid, "element");
    return -1;
  }
  
  @NotNull
  public ListIterator listIterator()
  {
    return (ListIterator)EmptyIterator.INSTANCE;
  }
  
  @NotNull
  public ListIterator listIterator(int paramInt)
  {
    if (paramInt != 0) {
      throw ((Throwable)new IndexOutOfBoundsException("Index: " + paramInt));
    }
    return (ListIterator)EmptyIterator.INSTANCE;
  }
  
  public Void remove(int paramInt)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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
  
  public Void set(int paramInt, Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final int size()
  {
    return getSize();
  }
  
  @NotNull
  public List subList(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return (List)this;
    }
    throw ((Throwable)new IndexOutOfBoundsException("fromIndex: " + paramInt1 + ", toIndex: " + paramInt2));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.collections.EmptyList
 * JD-Core Version:    0.7.0.1
 */