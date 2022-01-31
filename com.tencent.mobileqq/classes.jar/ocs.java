import java.util.ArrayList;

public class ocs
{
  public int a;
  public long a;
  public String a;
  public ArrayList<ocs> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c = "";
  public int d;
  public String d = "";
  public String e = "";
  public String f = "";
  
  public ocs()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public boolean a(long paramLong)
  {
    return (paramLong - this.jdField_a_of_type_Long > 0L) && (paramLong - this.jdField_a_of_type_Long < 25200L);
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    return (paramLong1 - this.jdField_a_of_type_Long > 0L) && (paramLong1 - this.jdField_a_of_type_Long < paramLong2);
  }
  
  public String toString()
  {
    return "VidUrl {\n vid: " + this.jdField_b_of_type_JavaLangString + "\n url: " + this.jdField_a_of_type_JavaLangString + "\n isH265: " + this.jdField_a_of_type_Boolean + "\n fileBitRate: " + this.c + "\n isHWCodec: " + this.jdField_b_of_type_Boolean + "\n videoReportInfo:" + this.d + "\n speedList:" + this.e + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ocs
 * JD-Core Version:    0.7.0.1
 */