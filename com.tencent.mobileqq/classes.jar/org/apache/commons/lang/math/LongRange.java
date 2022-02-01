package org.apache.commons.lang.math;

import java.io.Serializable;
import org.apache.commons.lang.text.StrBuilder;

public final class LongRange
  extends Range
  implements Serializable
{
  private static final long serialVersionUID = 71849363892720L;
  private transient int hashCode = 0;
  private final long max;
  private transient Long maxObject = null;
  private final long min;
  private transient Long minObject = null;
  private transient String toString = null;
  
  public LongRange(long paramLong)
  {
    this.min = paramLong;
    this.max = paramLong;
  }
  
  public LongRange(long paramLong1, long paramLong2)
  {
    if (paramLong2 < paramLong1)
    {
      this.min = paramLong2;
      this.max = paramLong1;
      return;
    }
    this.min = paramLong1;
    this.max = paramLong2;
  }
  
  public LongRange(Number paramNumber)
  {
    if (paramNumber != null)
    {
      this.min = paramNumber.longValue();
      this.max = paramNumber.longValue();
      if ((paramNumber instanceof Long))
      {
        paramNumber = (Long)paramNumber;
        this.minObject = paramNumber;
        this.maxObject = paramNumber;
      }
      return;
    }
    throw new IllegalArgumentException("The number must not be null");
  }
  
  public LongRange(Number paramNumber1, Number paramNumber2)
  {
    if ((paramNumber1 != null) && (paramNumber2 != null))
    {
      long l1 = paramNumber1.longValue();
      long l2 = paramNumber2.longValue();
      if (l2 < l1)
      {
        this.min = l2;
        this.max = l1;
        if ((paramNumber2 instanceof Long)) {
          this.minObject = ((Long)paramNumber2);
        }
        if ((paramNumber1 instanceof Long)) {
          this.maxObject = ((Long)paramNumber1);
        }
      }
      else
      {
        this.min = l1;
        this.max = l2;
        if ((paramNumber1 instanceof Long)) {
          this.minObject = ((Long)paramNumber1);
        }
        if ((paramNumber2 instanceof Long)) {
          this.maxObject = ((Long)paramNumber2);
        }
      }
      return;
    }
    throw new IllegalArgumentException("The numbers must not be null");
  }
  
  public boolean containsLong(long paramLong)
  {
    return (paramLong >= this.min) && (paramLong <= this.max);
  }
  
  public boolean containsNumber(Number paramNumber)
  {
    if (paramNumber == null) {
      return false;
    }
    return containsLong(paramNumber.longValue());
  }
  
  public boolean containsRange(Range paramRange)
  {
    boolean bool2 = false;
    if (paramRange == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (containsLong(paramRange.getMinimumLong()))
    {
      bool1 = bool2;
      if (containsLong(paramRange.getMaximumLong())) {
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
    if (!(paramObject instanceof LongRange)) {
      return false;
    }
    paramObject = (LongRange)paramObject;
    return (this.min == paramObject.min) && (this.max == paramObject.max);
  }
  
  public double getMaximumDouble()
  {
    return this.max;
  }
  
  public float getMaximumFloat()
  {
    return (float)this.max;
  }
  
  public int getMaximumInteger()
  {
    return (int)this.max;
  }
  
  public long getMaximumLong()
  {
    return this.max;
  }
  
  public Number getMaximumNumber()
  {
    if (this.maxObject == null) {
      this.maxObject = new Long(this.max);
    }
    return this.maxObject;
  }
  
  public double getMinimumDouble()
  {
    return this.min;
  }
  
  public float getMinimumFloat()
  {
    return (float)this.min;
  }
  
  public int getMinimumInteger()
  {
    return (int)this.min;
  }
  
  public long getMinimumLong()
  {
    return this.min;
  }
  
  public Number getMinimumNumber()
  {
    if (this.minObject == null) {
      this.minObject = new Long(this.min);
    }
    return this.minObject;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0)
    {
      this.hashCode = 17;
      this.hashCode = (this.hashCode * 37 + getClass().hashCode());
      int i = this.hashCode;
      long l = this.min;
      this.hashCode = (i * 37 + (int)(l ^ l >> 32));
      i = this.hashCode;
      l = this.max;
      this.hashCode = (i * 37 + (int)(l ^ l >> 32));
    }
    return this.hashCode;
  }
  
  public boolean overlapsRange(Range paramRange)
  {
    boolean bool = false;
    if (paramRange == null) {
      return false;
    }
    if ((paramRange.containsLong(this.min)) || (paramRange.containsLong(this.max)) || (containsLong(paramRange.getMinimumLong()))) {
      bool = true;
    }
    return bool;
  }
  
  public long[] toArray()
  {
    long[] arrayOfLong = new long[(int)(this.max - this.min + 1L)];
    int i = 0;
    while (i < arrayOfLong.length)
    {
      arrayOfLong[i] = (this.min + i);
      i += 1;
    }
    return arrayOfLong;
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
 * Qualified Name:     org.apache.commons.lang.math.LongRange
 * JD-Core Version:    0.7.0.1
 */