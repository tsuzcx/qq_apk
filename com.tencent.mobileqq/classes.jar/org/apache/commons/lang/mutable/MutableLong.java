package org.apache.commons.lang.mutable;

public class MutableLong
  extends Number
  implements Comparable, Mutable
{
  private static final long serialVersionUID = 62986528375L;
  private long value;
  
  public MutableLong() {}
  
  public MutableLong(long paramLong)
  {
    this.value = paramLong;
  }
  
  public MutableLong(Number paramNumber)
  {
    this.value = paramNumber.longValue();
  }
  
  public MutableLong(String paramString)
  {
    this.value = Long.parseLong(paramString);
  }
  
  public void add(long paramLong)
  {
    this.value += paramLong;
  }
  
  public void add(Number paramNumber)
  {
    this.value += paramNumber.longValue();
  }
  
  public int compareTo(Object paramObject)
  {
    long l1 = ((MutableLong)paramObject).value;
    long l2 = this.value;
    if (l2 < l1) {
      return -1;
    }
    if (l2 == l1) {
      return 0;
    }
    return 1;
  }
  
  public void decrement()
  {
    this.value -= 1L;
  }
  
  public double doubleValue()
  {
    return this.value;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof MutableLong;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (this.value == ((MutableLong)paramObject).longValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public float floatValue()
  {
    return (float)this.value;
  }
  
  public Object getValue()
  {
    return new Long(this.value);
  }
  
  public int hashCode()
  {
    long l = this.value;
    return (int)(l ^ l >>> 32);
  }
  
  public void increment()
  {
    this.value += 1L;
  }
  
  public int intValue()
  {
    return (int)this.value;
  }
  
  public long longValue()
  {
    return this.value;
  }
  
  public void setValue(long paramLong)
  {
    this.value = paramLong;
  }
  
  public void setValue(Object paramObject)
  {
    setValue(((Number)paramObject).longValue());
  }
  
  public void subtract(long paramLong)
  {
    this.value -= paramLong;
  }
  
  public void subtract(Number paramNumber)
  {
    this.value -= paramNumber.longValue();
  }
  
  public Long toLong()
  {
    return new Long(longValue());
  }
  
  public String toString()
  {
    return String.valueOf(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.mutable.MutableLong
 * JD-Core Version:    0.7.0.1
 */