package kotlin;

import java.util.NoSuchElementException;
import kotlin.collections.UShortIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/UShortArray$Iterator;", "Lkotlin/collections/UShortIterator;", "array", "", "([S)V", "index", "", "hasNext", "", "nextUShort", "Lkotlin/UShort;", "()S", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class UShortArray$Iterator
  extends UShortIterator
{
  private final short[] array;
  private int index;
  
  public UShortArray$Iterator(@NotNull short[] paramArrayOfShort)
  {
    this.array = paramArrayOfShort;
  }
  
  public boolean hasNext()
  {
    return this.index < this.array.length;
  }
  
  public short nextUShort()
  {
    int i = this.index;
    short[] arrayOfShort = this.array;
    if (i < arrayOfShort.length)
    {
      this.index = (i + 1);
      return UShort.constructor-impl(arrayOfShort[i]);
    }
    throw ((Throwable)new NoSuchElementException(String.valueOf(i)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.UShortArray.Iterator
 * JD-Core Version:    0.7.0.1
 */