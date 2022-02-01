import android.text.TextUtils;

public class mzh
{
  public int a;
  public String a;
  public String b = null;
  
  public mzh()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.b);
  }
  
  public boolean b()
  {
    return (a()) && (this.jdField_a_of_type_Int == 1);
  }
  
  public String toString()
  {
    return "{redPoint: " + this.jdField_a_of_type_Int + ", iconUrl: " + this.jdField_a_of_type_JavaLangString + ", jumpUrl: " + this.b + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mzh
 * JD-Core Version:    0.7.0.1
 */