package external.org.apache.commons.lang3.builder;

final class ToStringStyle$ShortPrefixToStringStyle
  extends ToStringStyle
{
  private static final long serialVersionUID = 1L;
  
  ToStringStyle$ShortPrefixToStringStyle()
  {
    setUseShortClassName(true);
    setUseIdentityHashCode(false);
  }
  
  private Object readResolve()
  {
    return ToStringStyle.SHORT_PREFIX_STYLE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     external.org.apache.commons.lang3.builder.ToStringStyle.ShortPrefixToStringStyle
 * JD-Core Version:    0.7.0.1
 */