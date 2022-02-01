package external.org.apache.commons.lang3.builder;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     external.org.apache.commons.lang3.builder.ToStringStyle.NoFieldNameToStringStyle
 * JD-Core Version:    0.7.0.1
 */