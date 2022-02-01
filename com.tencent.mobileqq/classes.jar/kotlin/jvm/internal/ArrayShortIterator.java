package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ShortIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/ArrayShortIterator;", "Lkotlin/collections/ShortIterator;", "array", "", "([S)V", "index", "", "hasNext", "", "nextShort", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ArrayShortIterator
  extends ShortIterator
{
  private final short[] array;
  private int index;
  
  public ArrayShortIterator(@NotNull short[] paramArrayOfShort)
  {
    this.array = paramArrayOfShort;
  }
  
  public boolean hasNext()
  {
    return this.index < this.array.length;
  }
  
  public short nextShort()
  {
    try
    {
      short[] arrayOfShort = this.array;
      int i = this.index;
      this.index = (i + 1);
      short s = arrayOfShort[i];
      return s;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      this.index -= 1;
      throw ((Throwable)new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.jvm.internal.ArrayShortIterator
 * JD-Core Version:    0.7.0.1
 */