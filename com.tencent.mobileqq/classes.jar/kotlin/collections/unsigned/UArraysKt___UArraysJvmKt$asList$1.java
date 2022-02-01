package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$1", "Lkotlin/collections/AbstractList;", "Lkotlin/UInt;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "contains-WZ4Q5Ns", "(I)Z", "get", "index", "indexOf", "indexOf-WZ4Q5Ns", "(I)I", "isEmpty", "lastIndexOf", "lastIndexOf-WZ4Q5Ns", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class UArraysKt___UArraysJvmKt$asList$1
  extends AbstractList<UInt>
  implements RandomAccess
{
  UArraysKt___UArraysJvmKt$asList$1(int[] paramArrayOfInt) {}
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof UInt)) {
      return contains-WZ4Q5Ns(((UInt)paramObject).unbox-impl());
    }
    return false;
  }
  
  public boolean contains-WZ4Q5Ns(int paramInt)
  {
    return UIntArray.contains-WZ4Q5Ns(this.$this_asList, paramInt);
  }
  
  @NotNull
  public UInt get(int paramInt)
  {
    return UInt.box-impl(UIntArray.get-impl(this.$this_asList, paramInt));
  }
  
  public int getSize()
  {
    return UIntArray.getSize-impl(this.$this_asList);
  }
  
  public final int indexOf(Object paramObject)
  {
    if ((paramObject instanceof UInt)) {
      return indexOf-WZ4Q5Ns(((UInt)paramObject).unbox-impl());
    }
    return -1;
  }
  
  public int indexOf-WZ4Q5Ns(int paramInt)
  {
    return ArraysKt.indexOf(this.$this_asList, paramInt);
  }
  
  public boolean isEmpty()
  {
    return UIntArray.isEmpty-impl(this.$this_asList);
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    if ((paramObject instanceof UInt)) {
      return lastIndexOf-WZ4Q5Ns(((UInt)paramObject).unbox-impl());
    }
    return -1;
  }
  
  public int lastIndexOf-WZ4Q5Ns(int paramInt)
  {
    return ArraysKt.lastIndexOf(this.$this_asList, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.unsigned.UArraysKt___UArraysJvmKt.asList.1
 * JD-Core Version:    0.7.0.1
 */