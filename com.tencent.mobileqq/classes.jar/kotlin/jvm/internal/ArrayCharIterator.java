package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/ArrayCharIterator;", "Lkotlin/collections/CharIterator;", "array", "", "([C)V", "index", "", "hasNext", "", "nextChar", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ArrayCharIterator
  extends CharIterator
{
  private final char[] array;
  private int index;
  
  public ArrayCharIterator(@NotNull char[] paramArrayOfChar)
  {
    this.array = paramArrayOfChar;
  }
  
  public boolean hasNext()
  {
    return this.index < this.array.length;
  }
  
  public char nextChar()
  {
    try
    {
      char[] arrayOfChar = this.array;
      int i = this.index;
      this.index = (i + 1);
      char c = arrayOfChar[i];
      return c;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      this.index -= 1;
      throw ((Throwable)new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.jvm.internal.ArrayCharIterator
 * JD-Core Version:    0.7.0.1
 */