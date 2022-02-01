package org.apache.commons.lang.mutable;

public class MutableInt
  extends Number
  implements Comparable, Mutable
{
  private static final long serialVersionUID = 512176391864L;
  private int value;
  
  public MutableInt() {}
  
  public MutableInt(int paramInt)
  {
    this.value = paramInt;
  }
  
  public MutableInt(Number paramNumber)
  {
    this.value = paramNumber.intValue();
  }
  
  public MutableInt(String paramString)
  {
    this.value = Integer.parseInt(paramString);
  }
  
  public void add(int paramInt)
  {
    this.value += paramInt;
  }
  
  public void add(Number paramNumber)
  {
    this.value += paramNumber.intValue();
  }
  
  public int compareTo(Object paramObject)
  {
    int i = ((MutableInt)paramObject).value;
    int j = this.value;
    if (j < i) {
      return -1;
    }
    if (j == i) {
      return 0;
    }
    return 1;
  }
  
  public void decrement()
  {
    this.value -= 1;
  }
  
  public double doubleValue()
  {
    return this.value;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof MutableInt;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (this.value == ((MutableInt)paramObject).intValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public float floatValue()
  {
    return this.value;
  }
  
  public Object getValue()
  {
    return new Integer(this.value);
  }
  
  public int hashCode()
  {
    return this.value;
  }
  
  public void increment()
  {
    this.value += 1;
  }
  
  public int intValue()
  {
    return this.value;
  }
  
  public long longValue()
  {
    return this.value;
  }
  
  public void setValue(int paramInt)
  {
    this.value = paramInt;
  }
  
  public void setValue(Object paramObject)
  {
    setValue(((Number)paramObject).intValue());
  }
  
  public void subtract(int paramInt)
  {
    this.value -= paramInt;
  }
  
  public void subtract(Number paramNumber)
  {
    this.value -= paramNumber.intValue();
  }
  
  public Integer toInteger()
  {
    return new Integer(intValue());
  }
  
  public String toString()
  {
    return String.valueOf(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.mutable.MutableInt
 * JD-Core Version:    0.7.0.1
 */