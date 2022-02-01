package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

class SmartList$EmptyIterator<T>
  implements Iterator<T>
{
  private static final EmptyIterator INSTANCE = new EmptyIterator();
  
  public static <T> EmptyIterator<T> getInstance()
  {
    return INSTANCE;
  }
  
  public boolean hasNext()
  {
    return false;
  }
  
  public T next()
  {
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.SmartList.EmptyIterator
 * JD-Core Version:    0.7.0.1
 */