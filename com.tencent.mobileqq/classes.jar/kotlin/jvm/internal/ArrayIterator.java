package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/ArrayIterator;", "T", "", "array", "", "([Ljava/lang/Object;)V", "getArray", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "index", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ArrayIterator<T>
  implements Iterator<T>, KMappedMarker
{
  @NotNull
  private final T[] array;
  private int index;
  
  public ArrayIterator(@NotNull T[] paramArrayOfT)
  {
    this.array = paramArrayOfT;
  }
  
  @NotNull
  public final T[] getArray()
  {
    return this.array;
  }
  
  public boolean hasNext()
  {
    return this.index < this.array.length;
  }
  
  public T next()
  {
    try
    {
      Object localObject = this.array;
      int i = this.index;
      this.index = (i + 1);
      localObject = localObject[i];
      return localObject;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      this.index -= 1;
      throw ((Throwable)new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage()));
    }
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.jvm.internal.ArrayIterator
 * JD-Core Version:    0.7.0.1
 */