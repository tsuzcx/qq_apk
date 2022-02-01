package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$2", "Lkotlin/collections/AbstractList;", "Lkotlin/ULong;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "contains-VKZWuLQ", "(J)Z", "get", "index", "indexOf", "indexOf-VKZWuLQ", "(J)I", "isEmpty", "lastIndexOf", "lastIndexOf-VKZWuLQ", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class UArraysKt___UArraysJvmKt$asList$2
  extends AbstractList<ULong>
  implements RandomAccess
{
  UArraysKt___UArraysJvmKt$asList$2(long[] paramArrayOfLong) {}
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof ULong)) {
      return contains-VKZWuLQ(((ULong)paramObject).unbox-impl());
    }
    return false;
  }
  
  public boolean contains-VKZWuLQ(long paramLong)
  {
    return ULongArray.contains-VKZWuLQ(this.$this_asList, paramLong);
  }
  
  @NotNull
  public ULong get(int paramInt)
  {
    return ULong.box-impl(ULongArray.get-impl(this.$this_asList, paramInt));
  }
  
  public int getSize()
  {
    return ULongArray.getSize-impl(this.$this_asList);
  }
  
  public final int indexOf(Object paramObject)
  {
    if ((paramObject instanceof ULong)) {
      return indexOf-VKZWuLQ(((ULong)paramObject).unbox-impl());
    }
    return -1;
  }
  
  public int indexOf-VKZWuLQ(long paramLong)
  {
    return ArraysKt.indexOf(this.$this_asList, paramLong);
  }
  
  public boolean isEmpty()
  {
    return ULongArray.isEmpty-impl(this.$this_asList);
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    if ((paramObject instanceof ULong)) {
      return lastIndexOf-VKZWuLQ(((ULong)paramObject).unbox-impl());
    }
    return -1;
  }
  
  public int lastIndexOf-VKZWuLQ(long paramLong)
  {
    return ArraysKt.lastIndexOf(this.$this_asList, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.unsigned.UArraysKt___UArraysJvmKt.asList.2
 * JD-Core Version:    0.7.0.1
 */