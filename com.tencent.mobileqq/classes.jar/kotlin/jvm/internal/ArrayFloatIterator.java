package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.FloatIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/ArrayFloatIterator;", "Lkotlin/collections/FloatIterator;", "array", "", "([F)V", "index", "", "hasNext", "", "nextFloat", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ArrayFloatIterator
  extends FloatIterator
{
  private final float[] array;
  private int index;
  
  public ArrayFloatIterator(@NotNull float[] paramArrayOfFloat)
  {
    this.array = paramArrayOfFloat;
  }
  
  public boolean hasNext()
  {
    return this.index < this.array.length;
  }
  
  public float nextFloat()
  {
    try
    {
      float[] arrayOfFloat = this.array;
      int i = this.index;
      this.index = (i + 1);
      float f = arrayOfFloat[i];
      return f;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      this.index -= 1;
      throw ((Throwable)new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.jvm.internal.ArrayFloatIterator
 * JD-Core Version:    0.7.0.1
 */