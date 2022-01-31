public class rpw
{
  public String a;
  public rpr a;
  public String b;
  
  public rpw(String paramString, rpr paramrpr, boolean paramBoolean)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Rpr = paramrpr;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rpw
 * JD-Core Version:    0.7.0.1
 */