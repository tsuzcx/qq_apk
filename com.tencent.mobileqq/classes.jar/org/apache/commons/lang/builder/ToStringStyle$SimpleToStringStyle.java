package org.apache.commons.lang.builder;

final class ToStringStyle$SimpleToStringStyle
  extends ToStringStyle
{
  private static final long serialVersionUID = 1L;
  
  ToStringStyle$SimpleToStringStyle()
  {
    setUseClassName(false);
    setUseIdentityHashCode(false);
    setUseFieldNames(false);
    setContentStart("");
    setContentEnd("");
  }
  
  private Object readResolve()
  {
    return ToStringStyle.SIMPLE_STYLE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.builder.ToStringStyle.SimpleToStringStyle
 * JD-Core Version:    0.7.0.1
 */