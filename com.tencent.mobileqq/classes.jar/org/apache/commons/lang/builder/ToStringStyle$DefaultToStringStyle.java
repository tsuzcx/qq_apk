package org.apache.commons.lang.builder;

final class ToStringStyle$DefaultToStringStyle
  extends ToStringStyle
{
  private static final long serialVersionUID = 1L;
  
  private Object readResolve()
  {
    return ToStringStyle.DEFAULT_STYLE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.builder.ToStringStyle.DefaultToStringStyle
 * JD-Core Version:    0.7.0.1
 */