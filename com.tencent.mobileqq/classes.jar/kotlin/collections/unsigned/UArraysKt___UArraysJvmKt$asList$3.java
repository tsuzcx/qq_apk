package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$3", "Lkotlin/collections/AbstractList;", "Lkotlin/UByte;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "contains-7apg3OU", "(B)Z", "get", "index", "indexOf", "indexOf-7apg3OU", "(B)I", "isEmpty", "lastIndexOf", "lastIndexOf-7apg3OU", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class UArraysKt___UArraysJvmKt$asList$3
  extends AbstractList<UByte>
  implements RandomAccess
{
  UArraysKt___UArraysJvmKt$asList$3(byte[] paramArrayOfByte) {}
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof UByte)) {
      return contains-7apg3OU(((UByte)paramObject).unbox-impl());
    }
    return false;
  }
  
  public boolean contains-7apg3OU(byte paramByte)
  {
    return UByteArray.contains-7apg3OU(this.$this_asList, paramByte);
  }
  
  @NotNull
  public UByte get(int paramInt)
  {
    return UByte.box-impl(UByteArray.get-impl(this.$this_asList, paramInt));
  }
  
  public int getSize()
  {
    return UByteArray.getSize-impl(this.$this_asList);
  }
  
  public final int indexOf(Object paramObject)
  {
    if ((paramObject instanceof UByte)) {
      return indexOf-7apg3OU(((UByte)paramObject).unbox-impl());
    }
    return -1;
  }
  
  public int indexOf-7apg3OU(byte paramByte)
  {
    return ArraysKt.indexOf(this.$this_asList, paramByte);
  }
  
  public boolean isEmpty()
  {
    return UByteArray.isEmpty-impl(this.$this_asList);
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    if ((paramObject instanceof UByte)) {
      return lastIndexOf-7apg3OU(((UByte)paramObject).unbox-impl());
    }
    return -1;
  }
  
  public int lastIndexOf-7apg3OU(byte paramByte)
  {
    return ArraysKt.lastIndexOf(this.$this_asList, paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.collections.unsigned.UArraysKt___UArraysJvmKt.asList.3
 * JD-Core Version:    0.7.0.1
 */