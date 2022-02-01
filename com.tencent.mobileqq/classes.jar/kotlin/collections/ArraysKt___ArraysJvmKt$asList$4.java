package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/ArraysKt___ArraysJvmKt$asList$4", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Long;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ArraysKt___ArraysJvmKt$asList$4
  extends AbstractList<Long>
  implements RandomAccess
{
  ArraysKt___ArraysJvmKt$asList$4(long[] paramArrayOfLong) {}
  
  public boolean contains(long paramLong)
  {
    return ArraysKt.contains(this.$this_asList, paramLong);
  }
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof Long)) {
      return contains(((Number)paramObject).longValue());
    }
    return false;
  }
  
  @NotNull
  public Long get(int paramInt)
  {
    return Long.valueOf(this.$this_asList[paramInt]);
  }
  
  public int getSize()
  {
    return this.$this_asList.length;
  }
  
  public int indexOf(long paramLong)
  {
    return ArraysKt.indexOf(this.$this_asList, paramLong);
  }
  
  public final int indexOf(Object paramObject)
  {
    if ((paramObject instanceof Long)) {
      return indexOf(((Number)paramObject).longValue());
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    return this.$this_asList.length == 0;
  }
  
  public int lastIndexOf(long paramLong)
  {
    return ArraysKt.lastIndexOf(this.$this_asList, paramLong);
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    if ((paramObject instanceof Long)) {
      return lastIndexOf(((Number)paramObject).longValue());
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.ArraysKt___ArraysJvmKt.asList.4
 * JD-Core Version:    0.7.0.1
 */