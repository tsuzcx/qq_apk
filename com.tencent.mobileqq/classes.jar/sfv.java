public class sfv
{
  public String a;
  public sfq a;
  public String b;
  
  public sfv(String paramString, sfq paramsfq, boolean paramBoolean)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Sfq = paramsfq;
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    this.b = paramString;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      return this.b;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sfv
 * JD-Core Version:    0.7.0.1
 */