package org.apache.commons.lang;

public class IllegalClassException
  extends IllegalArgumentException
{
  private static final long serialVersionUID = 8063272569377254819L;
  
  public IllegalClassException(Class paramClass1, Class paramClass2)
  {
    super(localStringBuffer.toString());
  }
  
  public IllegalClassException(Class paramClass, Object paramObject)
  {
    super(localStringBuffer.toString());
  }
  
  public IllegalClassException(String paramString)
  {
    super(paramString);
  }
  
  private static final String safeGetClassName(Class paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    return paramClass.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.IllegalClassException
 * JD-Core Version:    0.7.0.1
 */