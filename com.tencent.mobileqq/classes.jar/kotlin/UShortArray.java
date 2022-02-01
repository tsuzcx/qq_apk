package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.UShortIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/UShortArray;", "", "Lkotlin/UShort;", "size", "", "constructor-impl", "(I)[S", "storage", "", "([S)[S", "getSize-impl", "([S)I", "storage$annotations", "()V", "contains", "", "element", "contains-xj2QHRw", "([SS)Z", "containsAll", "elements", "containsAll-impl", "([SLjava/util/Collection;)Z", "equals", "other", "", "get", "index", "get-impl", "([SI)S", "hashCode", "isEmpty", "isEmpty-impl", "([S)Z", "iterator", "Lkotlin/collections/UShortIterator;", "iterator-impl", "([S)Lkotlin/collections/UShortIterator;", "set", "", "value", "set-01HTLdE", "([SIS)V", "toString", "", "Iterator", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
@SinceKotlin(version="1.3")
public final class UShortArray
  implements Collection<UShort>, KMappedMarker
{
  @NotNull
  private final short[] storage;
  
  @NotNull
  public static short[] constructor-impl(int paramInt)
  {
    return constructor-impl(new short[paramInt]);
  }
  
  @PublishedApi
  @NotNull
  public static short[] constructor-impl(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "storage");
    return paramArrayOfShort;
  }
  
  public static boolean contains-xj2QHRw(short[] paramArrayOfShort, short paramShort)
  {
    return ArraysKt.contains(paramArrayOfShort, paramShort);
  }
  
  public static boolean containsAll-impl(short[] paramArrayOfShort, @NotNull Collection<UShort> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    if (((Collection)paramCollection).isEmpty()) {
      return true;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      if (((localObject instanceof UShort)) && (ArraysKt.contains(paramArrayOfShort, ((UShort)localObject).unbox-impl()))) {}
      for (int i = 1; i == 0; i = 0) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean equals-impl(short[] paramArrayOfShort, @Nullable Object paramObject)
  {
    return ((paramObject instanceof UShortArray)) && (Intrinsics.areEqual(paramArrayOfShort, ((UShortArray)paramObject).unbox-impl()));
  }
  
  public static final boolean equals-impl0(@NotNull short[] paramArrayOfShort1, @NotNull short[] paramArrayOfShort2)
  {
    return Intrinsics.areEqual(paramArrayOfShort1, paramArrayOfShort2);
  }
  
  public static final short get-impl(short[] paramArrayOfShort, int paramInt)
  {
    return UShort.constructor-impl(paramArrayOfShort[paramInt]);
  }
  
  public static int getSize-impl(short[] paramArrayOfShort)
  {
    return paramArrayOfShort.length;
  }
  
  public static int hashCode-impl(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort != null) {
      return Arrays.hashCode(paramArrayOfShort);
    }
    return 0;
  }
  
  public static boolean isEmpty-impl(short[] paramArrayOfShort)
  {
    return paramArrayOfShort.length == 0;
  }
  
  @NotNull
  public static UShortIterator iterator-impl(short[] paramArrayOfShort)
  {
    return (UShortIterator)new UShortArray.Iterator(paramArrayOfShort);
  }
  
  public static final void set-01HTLdE(short[] paramArrayOfShort, int paramInt, short paramShort)
  {
    paramArrayOfShort[paramInt] = paramShort;
  }
  
  @NotNull
  public static String toString-impl(short[] paramArrayOfShort)
  {
    return "UShortArray(storage=" + Arrays.toString(paramArrayOfShort) + ")";
  }
  
  public boolean add-xj2QHRw(short paramShort)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection<? extends UShort> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof UShort)) {
      return contains-xj2QHRw(((UShort)paramObject).unbox-impl());
    }
    return false;
  }
  
  public boolean contains-xj2QHRw(short paramShort)
  {
    return contains-xj2QHRw(this.storage, paramShort);
  }
  
  public boolean containsAll(@NotNull Collection<? extends Object> paramCollection)
  {
    return containsAll-impl(this.storage, paramCollection);
  }
  
  public boolean equals(Object paramObject)
  {
    return equals-impl(this.storage, paramObject);
  }
  
  public int getSize()
  {
    return getSize-impl(this.storage);
  }
  
  public int hashCode()
  {
    return hashCode-impl(this.storage);
  }
  
  public boolean isEmpty()
  {
    return isEmpty-impl(this.storage);
  }
  
  @NotNull
  public UShortIterator iterator()
  {
    return iterator-impl(this.storage);
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
  
  public Object[] toArray()
  {
    return CollectionToArray.toArray(this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return CollectionToArray.toArray(this, paramArrayOfT);
  }
  
  public String toString()
  {
    return toString-impl(this.storage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.UShortArray
 * JD-Core Version:    0.7.0.1
 */