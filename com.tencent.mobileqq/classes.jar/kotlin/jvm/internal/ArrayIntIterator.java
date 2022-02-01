package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/ArrayIntIterator;", "Lkotlin/collections/IntIterator;", "array", "", "([I)V", "index", "", "hasNext", "", "nextInt", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ArrayIntIterator
  extends IntIterator
{
  private final int[] array;
  private int index;
  
  public ArrayIntIterator(@NotNull int[] paramArrayOfInt)
  {
    this.array = paramArrayOfInt;
  }
  
  public boolean hasNext()
  {
    return this.index < this.array.length;
  }
  
  public int nextInt()
  {
    try
    {
      int[] arrayOfInt = this.array;
      int i = this.index;
      this.index = (i + 1);
      i = arrayOfInt[i];
      return i;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      this.index -= 1;
      throw ((Throwable)new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.jvm.internal.ArrayIntIterator
 * JD-Core Version:    0.7.0.1
 */