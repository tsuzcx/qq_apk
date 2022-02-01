import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class qvn
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private List<URL> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String jdField_b_of_type_JavaLangString = "";
  private List<svs> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  private qvn(qvo paramqvo)
  {
    this.jdField_a_of_type_JavaUtilList = qvo.a(paramqvo);
    this.jdField_a_of_type_JavaLangString = qvo.a(paramqvo);
    this.jdField_b_of_type_JavaLangString = qvo.b(paramqvo);
    this.jdField_b_of_type_JavaUtilList = qvo.b(paramqvo);
    this.jdField_a_of_type_Int = qvo.a(paramqvo);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<svs> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public List<URL> b()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qvn
 * JD-Core Version:    0.7.0.1
 */