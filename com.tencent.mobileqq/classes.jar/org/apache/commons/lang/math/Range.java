package org.apache.commons.lang.math;

import org.apache.commons.lang.text.StrBuilder;

public abstract class Range
{
  public boolean containsDouble(double paramDouble)
  {
    int i = NumberUtils.compare(getMinimumDouble(), paramDouble);
    int j = NumberUtils.compare(getMaximumDouble(), paramDouble);
    return (i <= 0) && (j >= 0);
  }
  
  public boolean containsDouble(Number paramNumber)
  {
    if (paramNumber == null) {
      return false;
    }
    return containsDouble(paramNumber.doubleValue());
  }
  
  public boolean containsFloat(float paramFloat)
  {
    int i = NumberUtils.compare(getMinimumFloat(), paramFloat);
    int j = NumberUtils.compare(getMaximumFloat(), paramFloat);
    return (i <= 0) && (j >= 0);
  }
  
  public boolean containsFloat(Number paramNumber)
  {
    if (paramNumber == null) {
      return false;
    }
    return containsFloat(paramNumber.floatValue());
  }
  
  public boolean containsInteger(int paramInt)
  {
    return (paramInt >= getMinimumInteger()) && (paramInt <= getMaximumInteger());
  }
  
  public boolean containsInteger(Number paramNumber)
  {
    if (paramNumber == null) {
      return false;
    }
    return containsInteger(paramNumber.intValue());
  }
  
  public boolean containsLong(long paramLong)
  {
    return (paramLong >= getMinimumLong()) && (paramLong <= getMaximumLong());
  }
  
  public boolean containsLong(Number paramNumber)
  {
    if (paramNumber == null) {
      return false;
    }
    return containsLong(paramNumber.longValue());
  }
  
  public abstract boolean containsNumber(Number paramNumber);
  
  public boolean containsRange(Range paramRange)
  {
    boolean bool2 = false;
    if (paramRange == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (containsNumber(paramRange.getMinimumNumber()))
    {
      bool1 = bool2;
      if (containsNumber(paramRange.getMaximumNumber())) {
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
    if (paramObject != null)
    {
      if (paramObject.getClass() != getClass()) {
        return false;
      }
      paramObject = (Range)paramObject;
      return (getMinimumNumber().equals(paramObject.getMinimumNumber())) && (getMaximumNumber().equals(paramObject.getMaximumNumber()));
    }
    return false;
  }
  
  public double getMaximumDouble()
  {
    return getMaximumNumber().doubleValue();
  }
  
  public float getMaximumFloat()
  {
    return getMaximumNumber().floatValue();
  }
  
  public int getMaximumInteger()
  {
    return getMaximumNumber().intValue();
  }
  
  public long getMaximumLong()
  {
    return getMaximumNumber().longValue();
  }
  
  public abstract Number getMaximumNumber();
  
  public double getMinimumDouble()
  {
    return getMinimumNumber().doubleValue();
  }
  
  public float getMinimumFloat()
  {
    return getMinimumNumber().floatValue();
  }
  
  public int getMinimumInteger()
  {
    return getMinimumNumber().intValue();
  }
  
  public long getMinimumLong()
  {
    return getMinimumNumber().longValue();
  }
  
  public abstract Number getMinimumNumber();
  
  public int hashCode()
  {
    return ((629 + getClass().hashCode()) * 37 + getMinimumNumber().hashCode()) * 37 + getMaximumNumber().hashCode();
  }
  
  public boolean overlapsRange(Range paramRange)
  {
    boolean bool = false;
    if (paramRange == null) {
      return false;
    }
    if ((paramRange.containsNumber(getMinimumNumber())) || (paramRange.containsNumber(getMaximumNumber())) || (containsNumber(paramRange.getMinimumNumber()))) {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    StrBuilder localStrBuilder = new StrBuilder(32);
    localStrBuilder.append("Range[");
    localStrBuilder.append(getMinimumNumber());
    localStrBuilder.append(',');
    localStrBuilder.append(getMaximumNumber());
    localStrBuilder.append(']');
    return localStrBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.math.Range
 * JD-Core Version:    0.7.0.1
 */