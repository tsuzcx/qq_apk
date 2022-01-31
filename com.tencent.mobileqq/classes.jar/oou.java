public class oou
  implements Cloneable
{
  public double a;
  public int a;
  public String a;
  public int b = -1;
  public String b;
  public int c = -1;
  public String c;
  public int d;
  public String d;
  public int e = -1;
  public String e;
  public int f;
  public String f;
  public int g = 1;
  
  public oou(String paramString)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_Double = -1.0D;
    this.jdField_f_of_type_JavaLangString = "0";
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public oou a()
  {
    return (oou)super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oou
 * JD-Core Version:    0.7.0.1
 */