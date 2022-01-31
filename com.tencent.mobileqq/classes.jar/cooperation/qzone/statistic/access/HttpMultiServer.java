package cooperation.qzone.statistic.access;

public abstract class HttpMultiServer
{
  protected String a;
  protected boolean a;
  
  public HttpMultiServer()
  {
    this(null);
  }
  
  public HttpMultiServer(String paramString)
  {
    this(paramString, false);
  }
  
  public HttpMultiServer(String paramString, boolean paramBoolean)
  {
    a(paramString);
    a(paramBoolean);
  }
  
  public abstract String a();
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return null;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String d()
  {
    if (a()) {
      return a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.statistic.access.HttpMultiServer
 * JD-Core Version:    0.7.0.1
 */