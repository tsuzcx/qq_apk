package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMutableIterator;
import org.jetbrains.annotations.NotNull;

final class SmartSet$SingletonIterator<T>
  implements Iterator<T>, KMutableIterator
{
  private final T element;
  private boolean hasNext;
  
  public SmartSet$SingletonIterator(T paramT)
  {
    this.element = paramT;
    this.hasNext = true;
  }
  
  public boolean hasNext()
  {
    return this.hasNext;
  }
  
  public T next()
  {
    if (this.hasNext)
    {
      this.hasNext = false;
      return this.element;
    }
    throw ((Throwable)new NoSuchElementException());
  }
  
  @NotNull
  public Void remove()
  {
    throw ((Throwable)new UnsupportedOperationException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.SmartSet.SingletonIterator
 * JD-Core Version:    0.7.0.1
 */