package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/ArraysKt___ArraysJvmKt$asList$5", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Float;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ArraysKt___ArraysJvmKt$asList$5
  extends AbstractList<Float>
  implements RandomAccess
{
  ArraysKt___ArraysJvmKt$asList$5(float[] paramArrayOfFloat) {}
  
  public boolean contains(float paramFloat)
  {
    return ArraysKt.contains(this.$this_asList, paramFloat);
  }
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof Float)) {
      return contains(((Number)paramObject).floatValue());
    }
    return false;
  }
  
  @NotNull
  public Float get(int paramInt)
  {
    return Float.valueOf(this.$this_asList[paramInt]);
  }
  
  public int getSize()
  {
    return this.$this_asList.length;
  }
  
  public int indexOf(float paramFloat)
  {
    return ArraysKt.indexOf(this.$this_asList, paramFloat);
  }
  
  public final int indexOf(Object paramObject)
  {
    if ((paramObject instanceof Float)) {
      return indexOf(((Number)paramObject).floatValue());
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    return this.$this_asList.length == 0;
  }
  
  public int lastIndexOf(float paramFloat)
  {
    return ArraysKt.lastIndexOf(this.$this_asList, paramFloat);
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    if ((paramObject instanceof Float)) {
      return lastIndexOf(((Number)paramObject).floatValue());
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.ArraysKt___ArraysJvmKt.asList.5
 * JD-Core Version:    0.7.0.1
 */