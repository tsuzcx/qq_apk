package external.org.apache.commons.lang3.builder;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     external.org.apache.commons.lang3.builder.ToStringStyle.SimpleToStringStyle
 * JD-Core Version:    0.7.0.1
 */