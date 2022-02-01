package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.markers.KMutableIterator;
import org.jetbrains.annotations.NotNull;

final class SmartSet$ArrayIterator<T>
  implements Iterator<T>, KMutableIterator
{
  private final Iterator<T> arrayIterator;
  
  public SmartSet$ArrayIterator(@NotNull T[] paramArrayOfT)
  {
    this.arrayIterator = ArrayIteratorKt.iterator(paramArrayOfT);
  }
  
  public boolean hasNext()
  {
    return this.arrayIterator.hasNext();
  }
  
  public T next()
  {
    return this.arrayIterator.next();
  }
  
  @NotNull
  public Void remove()
  {
    throw ((Throwable)new UnsupportedOperationException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.SmartSet.ArrayIterator
 * JD-Core Version:    0.7.0.1
 */