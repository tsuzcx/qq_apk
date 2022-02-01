package org.apache.commons.lang.mutable;

public class MutableByte
  extends Number
  implements Comparable, Mutable
{
  private static final long serialVersionUID = -1585823265L;
  private byte value;
  
  public MutableByte() {}
  
  public MutableByte(byte paramByte)
  {
    this.value = paramByte;
  }
  
  public MutableByte(Number paramNumber)
  {
    this.value = paramNumber.byteValue();
  }
  
  public MutableByte(String paramString)
  {
    this.value = Byte.parseByte(paramString);
  }
  
  public void add(byte paramByte)
  {
    this.value = ((byte)(this.value + paramByte));
  }
  
  public void add(Number paramNumber)
  {
    this.value = ((byte)(this.value + paramNumber.byteValue()));
  }
  
  public byte byteValue()
  {
    return this.value;
  }
  
  public int compareTo(Object paramObject)
  {
    int i = ((MutableByte)paramObject).value;
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
    this.value = ((byte)(this.value - 1));
  }
  
  public double doubleValue()
  {
    return this.value;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof MutableByte;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (this.value == ((MutableByte)paramObject).byteValue()) {
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
    return new Byte(this.value);
  }
  
  public int hashCode()
  {
    return this.value;
  }
  
  public void increment()
  {
    this.value = ((byte)(this.value + 1));
  }
  
  public int intValue()
  {
    return this.value;
  }
  
  public long longValue()
  {
    return this.value;
  }
  
  public void setValue(byte paramByte)
  {
    this.value = paramByte;
  }
  
  public void setValue(Object paramObject)
  {
    setValue(((Number)paramObject).byteValue());
  }
  
  public void subtract(byte paramByte)
  {
    this.value = ((byte)(this.value - paramByte));
  }
  
  public void subtract(Number paramNumber)
  {
    this.value = ((byte)(this.value - paramNumber.byteValue()));
  }
  
  public Byte toByte()
  {
    return new Byte(byteValue());
  }
  
  public String toString()
  {
    return String.valueOf(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.mutable.MutableByte
 * JD-Core Version:    0.7.0.1
 */