package external.org.apache.commons.lang3.builder;

final class ToStringStyle$DefaultToStringStyle
  extends ToStringStyle
{
  private static final long serialVersionUID = 1L;
  
  private Object readResolve()
  {
    return ToStringStyle.DEFAULT_STYLE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     external.org.apache.commons.lang3.builder.ToStringStyle.DefaultToStringStyle
 * JD-Core Version:    0.7.0.1
 */