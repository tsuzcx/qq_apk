package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.UByteIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "size", "", "constructor-impl", "(I)[B", "storage", "", "([B)[B", "getSize-impl", "([B)I", "storage$annotations", "()V", "contains", "", "element", "contains-7apg3OU", "([BB)Z", "containsAll", "elements", "containsAll-impl", "([BLjava/util/Collection;)Z", "equals", "other", "", "get", "index", "get-impl", "([BI)B", "hashCode", "isEmpty", "isEmpty-impl", "([B)Z", "iterator", "Lkotlin/collections/UByteIterator;", "iterator-impl", "([B)Lkotlin/collections/UByteIterator;", "set", "", "value", "set-VurrAj0", "([BIB)V", "toString", "", "Iterator", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
@SinceKotlin(version="1.3")
public final class UByteArray
  implements Collection<UByte>, KMappedMarker
{
  @NotNull
  private final byte[] storage;
  
  @NotNull
  public static byte[] constructor-impl(int paramInt)
  {
    return constructor-impl(new byte[paramInt]);
  }
  
  @PublishedApi
  @NotNull
  public static byte[] constructor-impl(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "storage");
    return paramArrayOfByte;
  }
  
  public static boolean contains-7apg3OU(byte[] paramArrayOfByte, byte paramByte)
  {
    return ArraysKt.contains(paramArrayOfByte, paramByte);
  }
  
  public static boolean containsAll-impl(byte[] paramArrayOfByte, @NotNull Collection<UByte> paramCollection)
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
      if (((localObject instanceof UByte)) && (ArraysKt.contains(paramArrayOfByte, ((UByte)localObject).unbox-impl()))) {}
      for (int i = 1; i == 0; i = 0) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean equals-impl(byte[] paramArrayOfByte, @Nullable Object paramObject)
  {
    return ((paramObject instanceof UByteArray)) && (Intrinsics.areEqual(paramArrayOfByte, ((UByteArray)paramObject).unbox-impl()));
  }
  
  public static final boolean equals-impl0(@NotNull byte[] paramArrayOfByte1, @NotNull byte[] paramArrayOfByte2)
  {
    return Intrinsics.areEqual(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static final byte get-impl(byte[] paramArrayOfByte, int paramInt)
  {
    return UByte.constructor-impl(paramArrayOfByte[paramInt]);
  }
  
  public static int getSize-impl(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte.length;
  }
  
  public static int hashCode-impl(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return Arrays.hashCode(paramArrayOfByte);
    }
    return 0;
  }
  
  public static boolean isEmpty-impl(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte.length == 0;
  }
  
  @NotNull
  public static UByteIterator iterator-impl(byte[] paramArrayOfByte)
  {
    return (UByteIterator)new UByteArray.Iterator(paramArrayOfByte);
  }
  
  public static final void set-VurrAj0(byte[] paramArrayOfByte, int paramInt, byte paramByte)
  {
    paramArrayOfByte[paramInt] = paramByte;
  }
  
  @NotNull
  public static String toString-impl(byte[] paramArrayOfByte)
  {
    return "UByteArray(storage=" + Arrays.toString(paramArrayOfByte) + ")";
  }
  
  public boolean add-7apg3OU(byte paramByte)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection<? extends UByte> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof UByte)) {
      return contains-7apg3OU(((UByte)paramObject).unbox-impl());
    }
    return false;
  }
  
  public boolean contains-7apg3OU(byte paramByte)
  {
    return contains-7apg3OU(this.storage, paramByte);
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
  public UByteIterator iterator()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.UByteArray
 * JD-Core Version:    0.7.0.1
 */