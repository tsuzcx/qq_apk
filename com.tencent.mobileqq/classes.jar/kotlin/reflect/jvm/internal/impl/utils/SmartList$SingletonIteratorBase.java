package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class SmartList$SingletonIteratorBase<T>
  implements Iterator<T>
{
  private boolean myVisited;
  
  protected abstract void checkCoModification();
  
  protected abstract T getElement();
  
  public final boolean hasNext()
  {
    return this.myVisited ^ true;
  }
  
  public final T next()
  {
    if (!this.myVisited)
    {
      this.myVisited = true;
      checkCoModification();
      return getElement();
    }
    throw new NoSuchElementException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
 * JD-Core Version:    0.7.0.1
 */