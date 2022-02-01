package org.apache.commons.lang.time;

import java.util.Calendar;
import java.util.Iterator;
import java.util.NoSuchElementException;

class DateUtils$DateIterator
  implements Iterator
{
  private final Calendar endFinal;
  private final Calendar spot;
  
  DateUtils$DateIterator(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    this.endFinal = paramCalendar2;
    this.spot = paramCalendar1;
    this.spot.add(5, -1);
  }
  
  public boolean hasNext()
  {
    return this.spot.before(this.endFinal);
  }
  
  public Object next()
  {
    if (!this.spot.equals(this.endFinal))
    {
      this.spot.add(5, 1);
      return this.spot.clone();
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.DateUtils.DateIterator
 * JD-Core Version:    0.7.0.1
 */