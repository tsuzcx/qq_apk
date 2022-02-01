package org.apache.commons.lang;

import java.util.Iterator;
import java.util.NoSuchElementException;

class CharRange$CharacterIterator
  implements Iterator
{
  private char current;
  private boolean hasNext;
  private final CharRange range;
  
  private CharRange$CharacterIterator(CharRange paramCharRange)
  {
    this.range = paramCharRange;
    this.hasNext = true;
    if (CharRange.access$100(this.range))
    {
      if (CharRange.access$200(this.range) == 0)
      {
        if (CharRange.access$300(this.range) == 65535)
        {
          this.hasNext = false;
          return;
        }
        this.current = ((char)(CharRange.access$300(this.range) + '\001'));
        return;
      }
      this.current = '\000';
      return;
    }
    this.current = CharRange.access$200(this.range);
  }
  
  CharRange$CharacterIterator(CharRange paramCharRange, CharRange.1 param1)
  {
    this(paramCharRange);
  }
  
  private void prepareNext()
  {
    if (CharRange.access$100(this.range))
    {
      int i = this.current;
      if (i == 65535)
      {
        this.hasNext = false;
        return;
      }
      if (i + 1 == CharRange.access$200(this.range))
      {
        if (CharRange.access$300(this.range) == 65535)
        {
          this.hasNext = false;
          return;
        }
        this.current = ((char)(CharRange.access$300(this.range) + '\001'));
        return;
      }
      this.current = ((char)(this.current + '\001'));
      return;
    }
    if (this.current < CharRange.access$300(this.range))
    {
      this.current = ((char)(this.current + '\001'));
      return;
    }
    this.hasNext = false;
  }
  
  public boolean hasNext()
  {
    return this.hasNext;
  }
  
  public Object next()
  {
    if (this.hasNext)
    {
      char c = this.current;
      prepareNext();
      return new Character(c);
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.CharRange.CharacterIterator
 * JD-Core Version:    0.7.0.1
 */