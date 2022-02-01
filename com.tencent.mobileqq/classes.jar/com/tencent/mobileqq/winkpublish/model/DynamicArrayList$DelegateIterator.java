package com.tencent.mobileqq.winkpublish.model;

import java.util.Iterator;

class DynamicArrayList$DelegateIterator
  implements Iterator<E>
{
  private Iterator<E> b;
  private int c = this.a.size();
  private int d = -1;
  
  private DynamicArrayList$DelegateIterator(Iterator<E> paramIterator)
  {
    Object localObject;
    this.b = localObject;
  }
  
  public boolean hasNext()
  {
    return this.b.hasNext();
  }
  
  public E next()
  {
    Object localObject = this.b.next();
    int i = this.c;
    this.c = (i - 1);
    this.d = (this.a.size() - i);
    return localObject;
  }
  
  public void remove()
  {
    this.b.remove();
    if (DynamicArrayList.access$100(this.a) != null) {
      DynamicArrayList.access$100(this.a).a(this.d);
    }
    this.d = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.model.DynamicArrayList.DelegateIterator
 * JD-Core Version:    0.7.0.1
 */