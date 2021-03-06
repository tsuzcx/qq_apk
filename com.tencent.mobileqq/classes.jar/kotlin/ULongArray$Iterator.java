package kotlin;

import java.util.NoSuchElementException;
import kotlin.collections.ULongIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ULongArray$Iterator;", "Lkotlin/collections/ULongIterator;", "array", "", "([J)V", "index", "", "hasNext", "", "nextULong", "Lkotlin/ULong;", "()J", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ULongArray$Iterator
  extends ULongIterator
{
  private final long[] array;
  private int index;
  
  public ULongArray$Iterator(@NotNull long[] paramArrayOfLong)
  {
    this.array = paramArrayOfLong;
  }
  
  public boolean hasNext()
  {
    return this.index < this.array.length;
  }
  
  public long nextULong()
  {
    int i = this.index;
    long[] arrayOfLong = this.array;
    if (i < arrayOfLong.length)
    {
      this.index = (i + 1);
      return ULong.constructor-impl(arrayOfLong[i]);
    }
    throw ((Throwable)new NoSuchElementException(String.valueOf(i)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.ULongArray.Iterator
 * JD-Core Version:    0.7.0.1
 */