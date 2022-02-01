package org.apache.commons.lang.math;

import java.io.Serializable;
import org.apache.commons.lang.text.StrBuilder;

public final class DoubleRange
  extends Range
  implements Serializable
{
  private static final long serialVersionUID = 71849363892740L;
  private transient int hashCode = 0;
  private final double max;
  private transient Double maxObject = null;
  private final double min;
  private transient Double minObject = null;
  private transient String toString = null;
  
  public DoubleRange(double paramDouble)
  {
    if (!Double.isNaN(paramDouble))
    {
      this.min = paramDouble;
      this.max = paramDouble;
      return;
    }
    throw new IllegalArgumentException("The number must not be NaN");
  }
  
  public DoubleRange(double paramDouble1, double paramDouble2)
  {
    if ((!Double.isNaN(paramDouble1)) && (!Double.isNaN(paramDouble2)))
    {
      if (paramDouble2 < paramDouble1)
      {
        this.min = paramDouble2;
        this.max = paramDouble1;
        return;
      }
      this.min = paramDouble1;
      this.max = paramDouble2;
      return;
    }
    throw new IllegalArgumentException("The numbers must not be NaN");
  }
  
  public DoubleRange(Number paramNumber)
  {
    if (paramNumber != null)
    {
      this.min = paramNumber.doubleValue();
      this.max = paramNumber.doubleValue();
      if ((!Double.isNaN(this.min)) && (!Double.isNaN(this.max)))
      {
        if ((paramNumber instanceof Double))
        {
          paramNumber = (Double)paramNumber;
          this.minObject = paramNumber;
          this.maxObject = paramNumber;
        }
        return;
      }
      throw new IllegalArgumentException("The number must not be NaN");
    }
    throw new IllegalArgumentException("The number must not be null");
  }
  
  public DoubleRange(Number paramNumber1, Number paramNumber2)
  {
    if ((paramNumber1 != null) && (paramNumber2 != null))
    {
      double d1 = paramNumber1.doubleValue();
      double d2 = paramNumber2.doubleValue();
      if ((!Double.isNaN(d1)) && (!Double.isNaN(d2)))
      {
        if (d2 < d1)
        {
          this.min = d2;
          this.max = d1;
          if ((paramNumber2 instanceof Double)) {
            this.minObject = ((Double)paramNumber2);
          }
          if ((paramNumber1 instanceof Double)) {
            this.maxObject = ((Double)paramNumber1);
          }
        }
        else
        {
          this.min = d1;
          this.max = d2;
          if ((paramNumber1 instanceof Double)) {
            this.minObject = ((Double)paramNumber1);
          }
          if ((paramNumber2 instanceof Double)) {
            this.maxObject = ((Double)paramNumber2);
          }
        }
        return;
      }
      throw new IllegalArgumentException("The numbers must not be NaN");
    }
    throw new IllegalArgumentException("The numbers must not be null");
  }
  
  public boolean containsDouble(double paramDouble)
  {
    return (paramDouble >= this.min) && (paramDouble <= this.max);
  }
  
  public boolean containsNumber(Number paramNumber)
  {
    if (paramNumber == null) {
      return false;
    }
    return containsDouble(paramNumber.doubleValue());
  }
  
  public boolean containsRange(Range paramRange)
  {
    boolean bool2 = false;
    if (paramRange == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (containsDouble(paramRange.getMinimumDouble()))
    {
      bool1 = bool2;
      if (containsDouble(paramRange.getMaximumDouble())) {
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
    if (!(paramObject instanceof DoubleRange)) {
      return false;
    }
    paramObject = (DoubleRange)paramObject;
    return (Double.doubleToLongBits(this.min) == Double.doubleToLongBits(paramObject.min)) && (Double.doubleToLongBits(this.max) == Double.doubleToLongBits(paramObject.max));
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
      this.maxObject = new Double(this.max);
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
      this.minObject = new Double(this.min);
    }
    return this.minObject;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0)
    {
      this.hashCode = 17;
      this.hashCode = (this.hashCode * 37 + getClass().hashCode());
      long l = Double.doubleToLongBits(this.min);
      this.hashCode = (this.hashCode * 37 + (int)(l ^ l >> 32));
      l = Double.doubleToLongBits(this.max);
      this.hashCode = (this.hashCode * 37 + (int)(l ^ l >> 32));
    }
    return this.hashCode;
  }
  
  public boolean overlapsRange(Range paramRange)
  {
    boolean bool = false;
    if (paramRange == null) {
      return false;
    }
    if ((paramRange.containsDouble(this.min)) || (paramRange.containsDouble(this.max)) || (containsDouble(paramRange.getMinimumDouble()))) {
      bool = true;
    }
    return bool;
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
 * Qualified Name:     org.apache.commons.lang.math.DoubleRange
 * JD-Core Version:    0.7.0.1
 */