package org.apache.commons.lang.math;

import java.io.Serializable;
import org.apache.commons.lang.text.StrBuilder;

public final class IntRange
  extends Range
  implements Serializable
{
  private static final long serialVersionUID = 71849363892730L;
  private transient int hashCode = 0;
  private final int max;
  private transient Integer maxObject = null;
  private final int min;
  private transient Integer minObject = null;
  private transient String toString = null;
  
  public IntRange(int paramInt)
  {
    this.min = paramInt;
    this.max = paramInt;
  }
  
  public IntRange(int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1)
    {
      this.min = paramInt2;
      this.max = paramInt1;
      return;
    }
    this.min = paramInt1;
    this.max = paramInt2;
  }
  
  public IntRange(Number paramNumber)
  {
    if (paramNumber != null)
    {
      this.min = paramNumber.intValue();
      this.max = paramNumber.intValue();
      if ((paramNumber instanceof Integer))
      {
        paramNumber = (Integer)paramNumber;
        this.minObject = paramNumber;
        this.maxObject = paramNumber;
      }
      return;
    }
    throw new IllegalArgumentException("The number must not be null");
  }
  
  public IntRange(Number paramNumber1, Number paramNumber2)
  {
    if ((paramNumber1 != null) && (paramNumber2 != null))
    {
      int i = paramNumber1.intValue();
      int j = paramNumber2.intValue();
      if (j < i)
      {
        this.min = j;
        this.max = i;
        if ((paramNumber2 instanceof Integer)) {
          this.minObject = ((Integer)paramNumber2);
        }
        if ((paramNumber1 instanceof Integer)) {
          this.maxObject = ((Integer)paramNumber1);
        }
      }
      else
      {
        this.min = i;
        this.max = j;
        if ((paramNumber1 instanceof Integer)) {
          this.minObject = ((Integer)paramNumber1);
        }
        if ((paramNumber2 instanceof Integer)) {
          this.maxObject = ((Integer)paramNumber2);
        }
      }
      return;
    }
    throw new IllegalArgumentException("The numbers must not be null");
  }
  
  public boolean containsInteger(int paramInt)
  {
    return (paramInt >= this.min) && (paramInt <= this.max);
  }
  
  public boolean containsNumber(Number paramNumber)
  {
    if (paramNumber == null) {
      return false;
    }
    return containsInteger(paramNumber.intValue());
  }
  
  public boolean containsRange(Range paramRange)
  {
    boolean bool2 = false;
    if (paramRange == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (containsInteger(paramRange.getMinimumInteger()))
    {
      bool1 = bool2;
      if (containsInteger(paramRange.getMaximumInteger())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof IntRange)) {
      return false;
    }
    paramObject = (IntRange)paramObject;
    return (this.min == paramObject.min) && (this.max == paramObject.max);
  }
  
  public double getMaximumDouble()
  {
    return this.max;
  }
  
  public float getMaximumFloat()
  {
    return this.max;
  }
  
  public int getMaximumInteger()
  {
    return this.max;
  }
  
  public long getMaximumLong()
  {
    return this.max;
  }
  
  public Number getMaximumNumber()
  {
    if (this.maxObject == null) {
      this.maxObject = new Integer(this.max);
    }
    return this.maxObject;
  }
  
  public double getMinimumDouble()
  {
    return this.min;
  }
  
  public float getMinimumFloat()
  {
    return this.min;
  }
  
  public int getMinimumInteger()
  {
    return this.min;
  }
  
  public long getMinimumLong()
  {
    return this.min;
  }
  
  public Number getMinimumNumber()
  {
    if (this.minObject == null) {
      this.minObject = new Integer(this.min);
    }
    return this.minObject;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0)
    {
      this.hashCode = 17;
      this.hashCode = (this.hashCode * 37 + getClass().hashCode());
      this.hashCode = (this.hashCode * 37 + this.min);
      this.hashCode = (this.hashCode * 37 + this.max);
    }
    return this.hashCode;
  }
  
  public boolean overlapsRange(Range paramRange)
  {
    boolean bool = false;
    if (paramRange == null) {
      return false;
    }
    if ((paramRange.containsInteger(this.min)) || (paramRange.containsInteger(this.max)) || (containsInteger(paramRange.getMinimumInteger()))) {
      bool = true;
    }
    return bool;
  }
  
  public int[] toArray()
  {
    int[] arrayOfInt = new int[this.max - this.min + 1];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = (this.min + i);
      i += 1;
    }
    return arrayOfInt;
  }
  
  public String toString()
  {
    if (this.toString == null)
    {
      StrBuilder localStrBuilder = new StrBuilder(32);
      localStrBuilder.append("Range[");
      localStrBuilder.append(this.min);
      localStrBuilder.append(',');
      localStrBuilder.append(this.max);
      localStrBuilder.append(']');
      this.toString = localStrBuilder.toString();
    }
    return this.toString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.math.IntRange
 * JD-Core Version:    0.7.0.1
 */