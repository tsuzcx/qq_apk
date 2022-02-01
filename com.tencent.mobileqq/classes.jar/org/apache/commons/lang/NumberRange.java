package org.apache.commons.lang;

import org.apache.commons.lang.text.StrBuilder;

public final class NumberRange
{
  private final Number max;
  private final Number min;
  
  public NumberRange(Number paramNumber)
  {
    if (paramNumber != null)
    {
      this.min = paramNumber;
      this.max = paramNumber;
      return;
    }
    throw new NullPointerException("The number must not be null");
  }
  
  public NumberRange(Number paramNumber1, Number paramNumber2)
  {
    if (paramNumber1 != null)
    {
      if (paramNumber2 != null)
      {
        if (paramNumber2.doubleValue() < paramNumber1.doubleValue())
        {
          this.max = paramNumber1;
          this.min = paramNumber1;
          return;
        }
        this.min = paramNumber1;
        this.max = paramNumber2;
        return;
      }
      throw new NullPointerException("The maximum value must not be null");
    }
    throw new NullPointerException("The minimum value must not be null");
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
  
  public Number getMaximum()
  {
    return this.max;
  }
  
  public Number getMinimum()
  {
    return this.min;
  }
  
  public int hashCode()
  {
    return (629 + this.min.hashCode()) * 37 + this.max.hashCode();
  }
  
  public boolean includesNumber(Number paramNumber)
  {
    boolean bool2 = false;
    if (paramNumber == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (this.min.doubleValue() <= paramNumber.doubleValue())
    {
      bool1 = bool2;
      if (this.max.doubleValue() >= paramNumber.doubleValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean includesRange(NumberRange paramNumberRange)
  {
    boolean bool2 = false;
    if (paramNumberRange == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (includesNumber(paramNumberRange.min))
    {
      bool1 = bool2;
      if (includesNumber(paramNumberRange.max)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean overlaps(NumberRange paramNumberRange)
  {
    boolean bool = false;
    if (paramNumberRange == null) {
      return false;
    }
    if ((paramNumberRange.includesNumber(this.min)) || (paramNumberRange.includesNumber(this.max)) || (includesRange(paramNumberRange))) {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    StrBuilder localStrBuilder = new StrBuilder();
    if (this.min.doubleValue() < 0.0D) {
      localStrBuilder.append('(').append(this.min).append(')');
    } else {
      localStrBuilder.append(this.min);
    }
    localStrBuilder.append('-');
    if (this.max.doubleValue() < 0.0D) {
      localStrBuilder.append('(').append(this.max).append(')');
    } else {
      localStrBuilder.append(this.max);
    }
    return localStrBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.NumberRange
 * JD-Core Version:    0.7.0.1
 */