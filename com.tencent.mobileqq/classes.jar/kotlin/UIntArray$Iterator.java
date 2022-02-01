package kotlin;

import java.util.NoSuchElementException;
import kotlin.collections.UIntIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/UIntArray$Iterator;", "Lkotlin/collections/UIntIterator;", "array", "", "([I)V", "index", "", "hasNext", "", "nextUInt", "Lkotlin/UInt;", "()I", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class UIntArray$Iterator
  extends UIntIterator
{
  private final int[] array;
  private int index;
  
  public UIntArray$Iterator(@NotNull int[] paramArrayOfInt)
  {
    this.array = paramArrayOfInt;
  }
  
  public boolean hasNext()
  {
    return this.index < this.array.length;
  }
  
  public int nextUInt()
  {
    int i = this.index;
    int[] arrayOfInt = this.array;
    if (i < arrayOfInt.length)
    {
      this.index = (i + 1);
      return UInt.constructor-impl(arrayOfInt[i]);
    }
    throw ((Throwable)new NoSuchElementException(String.valueOf(i)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.UIntArray.Iterator
 * JD-Core Version:    0.7.0.1
 */