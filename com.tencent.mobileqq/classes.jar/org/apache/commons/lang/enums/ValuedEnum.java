package org.apache.commons.lang.enums;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
  
  private int getValueInOtherClassLoader(Object paramObject)
  {
    try
    {
      int i = ((Integer)paramObject.getClass().getMethod("getValue", null).invoke(paramObject, null)).intValue();
      return i;
    }
    catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException paramObject)
    {
      label24:
      break label24;
    }
    throw new IllegalStateException("This should not happen");
  }
  
  public int compareTo(Object paramObject)
  {
    if (paramObject == this) {
      return 0;
    }
    int i;
    if (paramObject.getClass() != getClass()) {
      if (paramObject.getClass().getName().equals(getClass().getName())) {
        i = this.iValue;
      }
    }
    for (int j = getValueInOtherClassLoader(paramObject);; j = ((ValuedEnum)paramObject).iValue)
    {
      return i - j;
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Different enum class '");
      localStringBuffer.append(ClassUtils.getShortClassName(paramObject.getClass()));
      localStringBuffer.append("'");
      throw new ClassCastException(localStringBuffer.toString());
      i = this.iValue;
    }
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
 * Qualified Name:     org.apache.commons.lang.enums.ValuedEnum
 * JD-Core Version:    0.7.0.1
 */