import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class qob
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private List<URL> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String jdField_b_of_type_JavaLangString = "";
  private List<smv> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  private qob(qoc paramqoc)
  {
    this.jdField_a_of_type_JavaUtilList = qoc.a(paramqoc);
    this.jdField_a_of_type_JavaLangString = qoc.a(paramqoc);
    this.jdField_b_of_type_JavaLangString = qoc.b(paramqoc);
    this.jdField_b_of_type_JavaUtilList = qoc.b(paramqoc);
    this.jdField_a_of_type_Int = qoc.a(paramqoc);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<smv> a()
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
 * Qualified Name:     qob
 * JD-Core Version:    0.7.0.1
 */