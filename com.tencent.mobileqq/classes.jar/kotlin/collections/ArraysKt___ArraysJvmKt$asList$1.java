package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/ArraysKt___ArraysJvmKt$asList$1", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Byte;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ArraysKt___ArraysJvmKt$asList$1
  extends AbstractList<Byte>
  implements RandomAccess
{
  ArraysKt___ArraysJvmKt$asList$1(byte[] paramArrayOfByte) {}
  
  public boolean contains(byte paramByte)
  {
    return ArraysKt.contains(this.$this_asList, paramByte);
  }
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof Byte)) {
      return contains(((Number)paramObject).byteValue());
    }
    return false;
  }
  
  @NotNull
  public Byte get(int paramInt)
  {
    return Byte.valueOf(this.$this_asList[paramInt]);
  }
  
  public int getSize()
  {
    return this.$this_asList.length;
  }
  
  public int indexOf(byte paramByte)
  {
    return ArraysKt.indexOf(this.$this_asList, paramByte);
  }
  
  public final int indexOf(Object paramObject)
  {
    if ((paramObject instanceof Byte)) {
      return indexOf(((Number)paramObject).byteValue());
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    return this.$this_asList.length == 0;
  }
  
  public int lastIndexOf(byte paramByte)
  {
    return ArraysKt.lastIndexOf(this.$this_asList, paramByte);
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    if ((paramObject instanceof Byte)) {
      return lastIndexOf(((Number)paramObject).byteValue());
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.ArraysKt___ArraysJvmKt.asList.1
 * JD-Core Version:    0.7.0.1
 */