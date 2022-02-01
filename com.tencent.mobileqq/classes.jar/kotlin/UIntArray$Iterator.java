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
    if (this.index < this.array.length)
    {
      int[] arrayOfInt = this.array;
      int i = this.index;
      this.index = (i + 1);
      return UInt.constructor-impl(arrayOfInt[i]);
    }
    throw ((Throwable)new NoSuchElementException(String.valueOf(this.index)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.UIntArray.Iterator
 * JD-Core Version:    0.7.0.1
 */