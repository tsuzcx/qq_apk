package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.BooleanIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/ArrayBooleanIterator;", "Lkotlin/collections/BooleanIterator;", "array", "", "([Z)V", "index", "", "hasNext", "", "nextBoolean", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ArrayBooleanIterator
  extends BooleanIterator
{
  private final boolean[] array;
  private int index;
  
  public ArrayBooleanIterator(@NotNull boolean[] paramArrayOfBoolean)
  {
    this.array = paramArrayOfBoolean;
  }
  
  public boolean hasNext()
  {
    return this.index < this.array.length;
  }
  
  public boolean nextBoolean()
  {
    try
    {
      boolean[] arrayOfBoolean = this.array;
      int i = this.index;
      this.index = (i + 1);
      int j = arrayOfBoolean[i];
      return j;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      this.index -= 1;
      throw ((Throwable)new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.jvm.internal.ArrayBooleanIterator
 * JD-Core Version:    0.7.0.1
 */