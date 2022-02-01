package kotlin.reflect.jvm.internal.pcollections;

import java.util.Iterator;

class ConsPStack$Itr<E>
  implements Iterator<E>
{
  private ConsPStack<E> next;
  
  public ConsPStack$Itr(ConsPStack<E> paramConsPStack)
  {
    this.next = paramConsPStack;
  }
  
  public boolean hasNext()
  {
    return ConsPStack.access$000(this.next) > 0;
  }
  
  public E next()
  {
    Object localObject = this.next.first;
    this.next = this.next.rest;
    return localObject;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.pcollections.ConsPStack.Itr
 * JD-Core Version:    0.7.0.1
 */