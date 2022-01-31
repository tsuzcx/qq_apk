import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class pjt
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private List<URL> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String jdField_b_of_type_JavaLangString = "";
  private List<qvs> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  private pjt(pju parampju)
  {
    this.jdField_a_of_type_JavaUtilList = pju.a(parampju);
    this.jdField_a_of_type_JavaLangString = pju.a(parampju);
    this.jdField_b_of_type_JavaLangString = pju.b(parampju);
    this.jdField_b_of_type_JavaUtilList = pju.b(parampju);
    this.jdField_a_of_type_Int = pju.a(parampju);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<qvs> a()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pjt
 * JD-Core Version:    0.7.0.1
 */