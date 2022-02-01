package external.org.apache.commons.lang3.builder;

import external.org.apache.commons.lang3.SystemUtils;

final class ToStringStyle$MultiLineToStringStyle
  extends ToStringStyle
{
  private static final long serialVersionUID = 1L;
  
  ToStringStyle$MultiLineToStringStyle()
  {
    setContentStart("[");
    setFieldSeparator(SystemUtils.LINE_SEPARATOR + "  ");
    setFieldSeparatorAtStart(true);
    setContentEnd(SystemUtils.LINE_SEPARATOR + "]");
  }
  
  private Object readResolve()
  {
    return ToStringStyle.MULTI_LINE_STYLE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     external.org.apache.commons.lang3.builder.ToStringStyle.MultiLineToStringStyle
 * JD-Core Version:    0.7.0.1
 */