package org.hamcrest.internal;

import java.util.Iterator;
import org.hamcrest.SelfDescribing;

public class SelfDescribingValueIterator<T>
  implements Iterator<SelfDescribing>
{
  private Iterator<T> values;
  
  public SelfDescribingValueIterator(Iterator<T> paramIterator)
  {
    this.values = paramIterator;
  }
  
  public boolean hasNext()
  {
    return this.values.hasNext();
  }
  
  public SelfDescribing next()
  {
    return new SelfDescribingValue(this.values.next());
  }
  
  public void remove()
  {
    this.values.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.internal.SelfDescribingValueIterator
 * JD-Core Version:    0.7.0.1
 */