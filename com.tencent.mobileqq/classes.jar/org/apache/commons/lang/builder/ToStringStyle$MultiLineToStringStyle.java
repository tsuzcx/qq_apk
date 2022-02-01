package org.apache.commons.lang.builder;

import org.apache.commons.lang.SystemUtils;

final class ToStringStyle$MultiLineToStringStyle
  extends ToStringStyle
{
  private static final long serialVersionUID = 1L;
  
  ToStringStyle$MultiLineToStringStyle()
  {
    setContentStart("[");
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(SystemUtils.LINE_SEPARATOR);
    localStringBuffer.append("  ");
    setFieldSeparator(localStringBuffer.toString());
    setFieldSeparatorAtStart(true);
    localStringBuffer = new StringBuffer();
    localStringBuffer.append(SystemUtils.LINE_SEPARATOR);
    localStringBuffer.append("]");
    setContentEnd(localStringBuffer.toString());
  }
  
  private Object readResolve()
  {
    return ToStringStyle.MULTI_LINE_STYLE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.builder.ToStringStyle.MultiLineToStringStyle
 * JD-Core Version:    0.7.0.1
 */