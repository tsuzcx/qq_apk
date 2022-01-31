public class kqz
{
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private final String jdField_a_of_type_JavaLangString;
  
  public kqz(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
  }
  
  public Boolean a()
  {
    return this.jdField_a_of_type_JavaLangBoolean;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     kqz
 * JD-Core Version:    0.7.0.1
 */