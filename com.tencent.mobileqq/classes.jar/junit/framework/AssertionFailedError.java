package junit.framework;

public class AssertionFailedError
  extends AssertionError
{
  private static final long serialVersionUID = 1L;
  
  public AssertionFailedError() {}
  
  public AssertionFailedError(String paramString)
  {
    super(defaultString(paramString));
  }
  
  private static String defaultString(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     junit.framework.AssertionFailedError
 * JD-Core Version:    0.7.0.1
 */