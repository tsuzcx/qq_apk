package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.UIntIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/UIntArray;", "", "Lkotlin/UInt;", "size", "", "constructor-impl", "(I)[I", "storage", "", "([I)[I", "getSize-impl", "([I)I", "storage$annotations", "()V", "contains", "", "element", "contains-WZ4Q5Ns", "([II)Z", "containsAll", "elements", "containsAll-impl", "([ILjava/util/Collection;)Z", "equals", "other", "", "get", "index", "get-impl", "([II)I", "hashCode", "isEmpty", "isEmpty-impl", "([I)Z", "iterator", "Lkotlin/collections/UIntIterator;", "iterator-impl", "([I)Lkotlin/collections/UIntIterator;", "set", "", "value", "set-VXSXFK8", "([III)V", "toString", "", "Iterator", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
@SinceKotlin(version="1.3")
public final class UIntArray
  implements Collection<UInt>, KMappedMarker
{
  @NotNull
  private final int[] storage;
  
  @NotNull
  public static int[] constructor-impl(int paramInt)
  {
    return constructor-impl(new int[paramInt]);
  }
  
  @PublishedApi
  @NotNull
  public static int[] constructor-impl(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "storage");
    return paramArrayOfInt;
  }
  
  public static boolean contains-WZ4Q5Ns(int[] paramArrayOfInt, int paramInt)
  {
    return ArraysKt.contains(paramArrayOfInt, paramInt);
  }
  
  public static boolean containsAll-impl(int[] paramArrayOfInt, @NotNull Collection<UInt> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    boolean bool1 = ((Collection)paramCollection).isEmpty();
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    paramCollection = paramCollection.iterator();
    int i;
    do
    {
      bool1 = bool2;
      if (!paramCollection.hasNext()) {
        break;
      }
      Object localObject = paramCollection.next();
      if (((localObject instanceof UInt)) && (ArraysKt.contains(paramArrayOfInt, ((UInt)localObject).unbox-impl()))) {
        i = 1;
      } else {
        i = 0;
      }
    } while (i != 0);
    bool1 = false;
    return bool1;
  }
  
  public static boolean equals-impl(int[] paramArrayOfInt, @Nullable Object paramObject)
  {
    return ((paramObject instanceof UIntArray)) && (Intrinsics.areEqual(paramArrayOfInt, ((UIntArray)paramObject).unbox-impl()));
  }
  
  public static final boolean equals-impl0(@NotNull int[] paramArrayOfInt1, @NotNull int[] paramArrayOfInt2)
  {
    return Intrinsics.areEqual(paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public static final int get-impl(int[] paramArrayOfInt, int paramInt)
  {
    return UInt.constructor-impl(paramArrayOfInt[paramInt]);
  }
  
  public static int getSize-impl(int[] paramArrayOfInt)
  {
    return paramArrayOfInt.length;
  }
  
  public static int hashCode-impl(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null) {
      return Arrays.hashCode(paramArrayOfInt);
    }
    return 0;
  }
  
  public static boolean isEmpty-impl(int[] paramArrayOfInt)
  {
    return paramArrayOfInt.length == 0;
  }
  
  @NotNull
  public static UIntIterator iterator-impl(int[] paramArrayOfInt)
  {
    return (UIntIterator)new UIntArray.Iterator(paramArrayOfInt);
  }
  
  public static final void set-VXSXFK8(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    paramArrayOfInt[paramInt1] = paramInt2;
  }
  
  @NotNull
  public static String toString-impl(int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UIntArray(storage=");
    localStringBuilder.append(Arrays.toString(paramArrayOfInt));
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public boolean add-WZ4Q5Ns(int paramInt)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection<? extends UInt> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof UInt)) {
      return contains-WZ4Q5Ns(((UInt)paramObject).unbox-impl());
    }
    return false;
  }
  
  public boolean contains-WZ4Q5Ns(int paramInt)
  {
    return contains-WZ4Q5Ns(this.storage, paramInt);
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
  public UIntIterator iterator()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.UIntArray
 * JD-Core Version:    0.7.0.1
 */