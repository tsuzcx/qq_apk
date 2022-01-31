package org.hamcrest.internal;

import org.hamcrest.Description;
import org.hamcrest.SelfDescribing;

public class SelfDescribingValue<T>
  implements SelfDescribing
{
  private T value;
  
  public SelfDescribingValue(T paramT)
  {
    this.value = paramT;
  }
  
  public void describeTo(Description paramDescription)
  {
    paramDescription.appendValue(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.internal.SelfDescribingValue
 * JD-Core Version:    0.7.0.1
 */