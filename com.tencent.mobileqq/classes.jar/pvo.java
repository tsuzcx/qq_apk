import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class pvo
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private List<URL> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String jdField_b_of_type_JavaLangString = "";
  private List<rie> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  private pvo(pvp parampvp)
  {
    this.jdField_a_of_type_JavaUtilList = pvp.a(parampvp);
    this.jdField_a_of_type_JavaLangString = pvp.a(parampvp);
    this.jdField_b_of_type_JavaLangString = pvp.b(parampvp);
    this.jdField_b_of_type_JavaUtilList = pvp.b(parampvp);
    this.jdField_a_of_type_Int = pvp.a(parampvp);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<rie> a()
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
 * Qualified Name:     pvo
 * JD-Core Version:    0.7.0.1
 */