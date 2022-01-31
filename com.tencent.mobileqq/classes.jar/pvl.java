import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class pvl
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private List<URL> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String jdField_b_of_type_JavaLangString = "";
  private List<rib> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  private pvl(pvm parampvm)
  {
    this.jdField_a_of_type_JavaUtilList = pvm.a(parampvm);
    this.jdField_a_of_type_JavaLangString = pvm.a(parampvm);
    this.jdField_b_of_type_JavaLangString = pvm.b(parampvm);
    this.jdField_b_of_type_JavaUtilList = pvm.b(parampvm);
    this.jdField_a_of_type_Int = pvm.a(parampvm);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<rib> a()
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
 * Qualified Name:     pvl
 * JD-Core Version:    0.7.0.1
 */