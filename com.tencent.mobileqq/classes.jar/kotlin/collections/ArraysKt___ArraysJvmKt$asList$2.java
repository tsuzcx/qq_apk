package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/ArraysKt___ArraysJvmKt$asList$2", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Short;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ArraysKt___ArraysJvmKt$asList$2
  extends AbstractList<Short>
  implements RandomAccess
{
  ArraysKt___ArraysJvmKt$asList$2(short[] paramArrayOfShort) {}
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof Short)) {
      return contains(((Number)paramObject).shortValue());
    }
    return false;
  }
  
  public boolean contains(short paramShort)
  {
    return ArraysKt.contains(this.$this_asList, paramShort);
  }
  
  @NotNull
  public Short get(int paramInt)
  {
    return Short.valueOf(this.$this_asList[paramInt]);
  }
  
  public int getSize()
  {
    return this.$this_asList.length;
  }
  
  public final int indexOf(Object paramObject)
  {
    if ((paramObject instanceof Short)) {
      return indexOf(((Number)paramObject).shortValue());
    }
    return -1;
  }
  
  public int indexOf(short paramShort)
  {
    return ArraysKt.indexOf(this.$this_asList, paramShort);
  }
  
  public boolean isEmpty()
  {
    return this.$this_asList.length == 0;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    if ((paramObject instanceof Short)) {
      return lastIndexOf(((Number)paramObject).shortValue());
    }
    return -1;
  }
  
  public int lastIndexOf(short paramShort)
  {
    return ArraysKt.lastIndexOf(this.$this_asList, paramShort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.ArraysKt___ArraysJvmKt.asList.2
 * JD-Core Version:    0.7.0.1
 */