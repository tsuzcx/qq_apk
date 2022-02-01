public class sve
{
  public String a;
  public suz a;
  public String b;
  
  public sve(String paramString, suz paramsuz, boolean paramBoolean)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Suz = paramsuz;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sve
 * JD-Core Version:    0.7.0.1
 */