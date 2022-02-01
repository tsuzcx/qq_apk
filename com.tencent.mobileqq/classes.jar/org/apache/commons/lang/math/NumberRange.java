package org.apache.commons.lang.math;

import java.io.Serializable;
import org.apache.commons.lang.text.StrBuilder;

public final class NumberRange
  extends Range
  implements Serializable
{
  private static final long serialVersionUID = 71849363892710L;
  private transient int hashCode = 0;
  private final Number max;
  private final Number min;
  private transient String toString = null;
  
  public NumberRange(Number paramNumber)
  {
    if (paramNumber != null)
    {
      if ((paramNumber instanceof Comparable))
      {
        if (((paramNumber instanceof Double)) && (((Double)paramNumber).isNaN())) {
          throw new IllegalArgumentException("The number must not be NaN");
        }
        if (((paramNumber instanceof Float)) && (((Float)paramNumber).isNaN())) {
          throw new IllegalArgumentException("The number must not be NaN");
        }
        this.min = paramNumber;
        this.max = paramNumber;
        return;
      }
      throw new IllegalArgumentException("The number must implement Comparable");
    }
    throw new IllegalArgumentException("The number must not be null");
  }
  
  public NumberRange(Number paramNumber1, Number paramNumber2)
  {
    if ((paramNumber1 != null) && (paramNumber2 != null))
    {
      if (paramNumber1.getClass() == paramNumber2.getClass())
      {
        if ((paramNumber1 instanceof Comparable))
        {
          if ((paramNumber1 instanceof Double))
          {
            if ((((Double)paramNumber1).isNaN()) || (((Double)paramNumber2).isNaN())) {
              throw new IllegalArgumentException("The number must not be NaN");
            }
          }
          else if (((paramNumber1 instanceof Float)) && ((((Float)paramNumber1).isNaN()) || (((Float)paramNumber2).isNaN()))) {
            throw new IllegalArgumentException("The number must not be NaN");
          }
          int i = ((Comparable)paramNumber1).compareTo(paramNumber2);
          if (i == 0)
          {
            this.min = paramNumber1;
            this.max = paramNumber1;
            return;
          }
          if (i > 0)
          {
            this.min = paramNumber2;
            this.max = paramNumber1;
            return;
          }
          this.min = paramNumber1;
          this.max = paramNumber2;
          return;
        }
        throw new IllegalArgumentException("The numbers must implement Comparable");
      }
      throw new IllegalArgumentException("The numbers must be of the same type");
    }
    throw new IllegalArgumentException("The numbers must not be null");
  }
  
  public boolean containsNumber(Number paramNumber)
  {
    boolean bool2 = false;
    if (paramNumber == null) {
      return false;
    }
    if (paramNumber.getClass() == this.min.getClass())
    {
      int i = ((Comparable)this.min).compareTo(paramNumber);
      int j = ((Comparable)this.max).compareTo(paramNumber);
      boolean bool1 = bool2;
      if (i <= 0)
      {
        bool1 = bool2;
        if (j >= 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    throw new IllegalArgumentException("The number must be of the same type as the range numbers");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof NumberRange)) {
      return false;
    }
    paramObject = (NumberRange)paramObject;
    return (this.min.equals(paramObject.min)) && (this.max.equals(paramObject.max));
  }
  
  public Number getMaximumNumber()
  {
    return this.max;
  }
  
  public Number getMinimumNumber()
  {
    return this.min;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0)
    {
      this.hashCode = 17;
      this.hashCode = (this.hashCode * 37 + getClass().hashCode());
      this.hashCode = (this.hashCode * 37 + this.min.hashCode());
      this.hashCode = (this.hashCode * 37 + this.max.hashCode());
    }
    return this.hashCode;
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
 * Qualified Name:     org.apache.commons.lang.math.NumberRange
 * JD-Core Version:    0.7.0.1
 */