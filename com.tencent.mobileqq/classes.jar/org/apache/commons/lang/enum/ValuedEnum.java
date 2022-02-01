package org.apache.commons.lang.enum;

import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.ClassUtils;

public abstract class ValuedEnum
  extends Enum
{
  private static final long serialVersionUID = -7129650521543789085L;
  private final int iValue;
  
  protected ValuedEnum(String paramString, int paramInt)
  {
    super(paramString);
    this.iValue = paramInt;
  }
  
  protected static Enum getEnum(Class paramClass, int paramInt)
  {
    if (paramClass != null)
    {
      paramClass = Enum.getEnumList(paramClass).iterator();
      while (paramClass.hasNext())
      {
        ValuedEnum localValuedEnum = (ValuedEnum)paramClass.next();
        if (localValuedEnum.getValue() == paramInt) {
          return localValuedEnum;
        }
      }
      return null;
    }
    paramClass = new IllegalArgumentException("The Enum Class must not be null");
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public int compareTo(Object paramObject)
  {
    return this.iValue - ((ValuedEnum)paramObject).iValue;
  }
  
  public final int getValue()
  {
    return this.iValue;
  }
  
  public String toString()
  {
    if (this.iToString == null)
    {
      String str = ClassUtils.getShortClassName(getEnumClass());
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(str);
      localStringBuffer.append("[");
      localStringBuffer.append(getName());
      localStringBuffer.append("=");
      localStringBuffer.append(getValue());
      localStringBuffer.append("]");
      this.iToString = localStringBuffer.toString();
    }
    return this.iToString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.enum.ValuedEnum
 * JD-Core Version:    0.7.0.1
 */