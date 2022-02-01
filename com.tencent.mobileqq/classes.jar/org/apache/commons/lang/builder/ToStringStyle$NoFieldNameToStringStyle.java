package org.apache.commons.lang.builder;

final class ToStringStyle$NoFieldNameToStringStyle
  extends ToStringStyle
{
  private static final long serialVersionUID = 1L;
  
  ToStringStyle$NoFieldNameToStringStyle()
  {
    setUseFieldNames(false);
  }
  
  private Object readResolve()
  {
    return ToStringStyle.NO_FIELD_NAMES_STYLE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.builder.ToStringStyle.NoFieldNameToStringStyle
 * JD-Core Version:    0.7.0.1
 */