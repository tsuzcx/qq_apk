package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/ArrayAsCollection;", "T", "", "values", "", "isVarargs", "", "([Ljava/lang/Object;Z)V", "()Z", "size", "", "getSize", "()I", "getValues", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "contains", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "toArray", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ArrayAsCollection<T>
  implements Collection<T>, KMappedMarker
{
  private final boolean isVarargs;
  @NotNull
  private final T[] values;
  
  public ArrayAsCollection(@NotNull T[] paramArrayOfT, boolean paramBoolean)
  {
    this.values = paramArrayOfT;
    this.isVarargs = paramBoolean;
  }
  
  public boolean add(T paramT)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection<? extends T> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean contains(Object paramObject)
  {
    return ArraysKt.contains(this.values, paramObject);
  }
  
  public boolean containsAll(@NotNull Collection<? extends Object> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    if (((Collection)paramCollection).isEmpty()) {
      return true;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public int getSize()
  {
    return this.values.length;
  }
  
  @NotNull
  public final T[] getValues()
  {
    return this.values;
  }
  
  public boolean isEmpty()
  {
    return this.values.length == 0;
  }
  
  public final boolean isVarargs()
  {
    return this.isVarargs;
  }
  
  @NotNull
  public Iterator<T> iterator()
  {
    return ArrayIteratorKt.iterator(this.values);
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean removeAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean retainAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final int size()
  {
    return getSize();
  }
  
  @NotNull
  public final Object[] toArray()
  {
    return CollectionsKt.copyToArrayOfAny(this.values, this.isVarargs);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return CollectionToArray.toArray(this, paramArrayOfT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.collections.ArrayAsCollection
 * JD-Core Version:    0.7.0.1
 */