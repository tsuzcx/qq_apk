package kotlin.reflect.jvm.internal.pcollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class ConsPStack<E>
  implements Iterable<E>
{
  private static final ConsPStack<Object> EMPTY = new ConsPStack();
  final E first;
  final ConsPStack<E> rest;
  private final int size;
  
  private ConsPStack()
  {
    this.size = 0;
    this.first = null;
    this.rest = null;
  }
  
  private ConsPStack(E paramE, ConsPStack<E> paramConsPStack)
  {
    this.first = paramE;
    this.rest = paramConsPStack;
    paramConsPStack.size += 1;
  }
  
  public static <E> ConsPStack<E> empty()
  {
    return EMPTY;
  }
  
  private Iterator<E> iterator(int paramInt)
  {
    return new ConsPStack.Itr(subList(paramInt));
  }
  
  private ConsPStack<E> minus(Object paramObject)
  {
    if (this.size == 0) {
      return this;
    }
    if (this.first.equals(paramObject)) {
      return this.rest;
    }
    paramObject = this.rest.minus(paramObject);
    if (paramObject == this.rest) {
      return this;
    }
    return new ConsPStack(this.first, paramObject);
  }
  
  private ConsPStack<E> subList(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.size))
    {
      if (paramInt == 0) {
        return this;
      }
      return this.rest.subList(paramInt - 1);
    }
    throw new IndexOutOfBoundsException();
  }
  
  public E get(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.size)) {}
    try
    {
      localObject = iterator(paramInt).next();
      return localObject;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      Object localObject;
      label25:
      break label25;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Index: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
    throw new IndexOutOfBoundsException();
  }
  
  public Iterator<E> iterator()
  {
    return iterator(0);
  }
  
  public ConsPStack<E> minus(int paramInt)
  {
    return minus(get(paramInt));
  }
  
  public ConsPStack<E> plus(E paramE)
  {
    return new ConsPStack(paramE, this);
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.pcollections.ConsPStack
 * JD-Core Version:    0.7.0.1
 */