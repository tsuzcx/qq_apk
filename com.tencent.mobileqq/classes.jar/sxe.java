import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class sxe
{
  private String jdField_a_of_type_JavaLangString = "";
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private boolean jdField_a_of_type_Boolean = true;
  private String b = "utf-8";
  
  public sxe(String paramString)
  {
    this(paramString, "utf-8");
  }
  
  public sxe(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    a();
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a()
  {
    if (!this.jdField_a_of_type_JavaLangString.endsWith("?")) {
      this.jdField_a_of_type_JavaLangString += "?";
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangStringBuilder.toString();
  }
  
  public sxe a(String paramString1, String paramString2)
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaLangStringBuilder.append("&");
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramString1);
      this.jdField_a_of_type_JavaLangStringBuilder.append("=");
      this.jdField_a_of_type_JavaLangStringBuilder.append(URLEncoder.encode(paramString2, this.b));
      return this;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sxe
 * JD-Core Version:    0.7.0.1
 */