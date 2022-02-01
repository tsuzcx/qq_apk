package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.DoubleIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/ArrayDoubleIterator;", "Lkotlin/collections/DoubleIterator;", "array", "", "([D)V", "index", "", "hasNext", "", "nextDouble", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ArrayDoubleIterator
  extends DoubleIterator
{
  private final double[] array;
  private int index;
  
  public ArrayDoubleIterator(@NotNull double[] paramArrayOfDouble)
  {
    this.array = paramArrayOfDouble;
  }
  
  public boolean hasNext()
  {
    return this.index < this.array.length;
  }
  
  public double nextDouble()
  {
    try
    {
      double[] arrayOfDouble = this.array;
      int i = this.index;
      this.index = (i + 1);
      double d = arrayOfDouble[i];
      return d;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      this.index -= 1;
      throw ((Throwable)new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.jvm.internal.ArrayDoubleIterator
 * JD-Core Version:    0.7.0.1
 */