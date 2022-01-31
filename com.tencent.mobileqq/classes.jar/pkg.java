import java.io.File;

public class pkg
{
  public final long a;
  public final String a;
  public final boolean a;
  public final String b;
  
  public pkg(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1, paramString2);
    this.jdField_a_of_type_JavaLangString = paramString1.getPath();
    this.b = paramString2;
    this.jdField_a_of_type_Long = paramString1.lastModified();
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pkg
 * JD-Core Version:    0.7.0.1
 */