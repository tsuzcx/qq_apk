package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/ArraysKt___ArraysJvmKt$asList$8", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Character;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ArraysKt___ArraysJvmKt$asList$8
  extends AbstractList<Character>
  implements RandomAccess
{
  ArraysKt___ArraysJvmKt$asList$8(char[] paramArrayOfChar) {}
  
  public boolean contains(char paramChar)
  {
    return ArraysKt.contains(this.$this_asList, paramChar);
  }
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof Character)) {
      return contains(((Character)paramObject).charValue());
    }
    return false;
  }
  
  @NotNull
  public Character get(int paramInt)
  {
    return Character.valueOf(this.$this_asList[paramInt]);
  }
  
  public int getSize()
  {
    return this.$this_asList.length;
  }
  
  public int indexOf(char paramChar)
  {
    return ArraysKt.indexOf(this.$this_asList, paramChar);
  }
  
  public final int indexOf(Object paramObject)
  {
    if ((paramObject instanceof Character)) {
      return indexOf(((Character)paramObject).charValue());
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    return this.$this_asList.length == 0;
  }
  
  public int lastIndexOf(char paramChar)
  {
    return ArraysKt.lastIndexOf(this.$this_asList, paramChar);
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    if ((paramObject instanceof Character)) {
      return lastIndexOf(((Character)paramObject).charValue());
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.ArraysKt___ArraysJvmKt.asList.8
 * JD-Core Version:    0.7.0.1
 */