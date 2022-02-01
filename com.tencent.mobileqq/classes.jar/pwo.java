import java.util.ArrayList;
import java.util.List;

public class pwo
{
  public static long a;
  public static List<pwp> a;
  public static long b;
  public static long c;
  
  static
  {
    jdField_a_of_type_Long = -1L;
    b = -1L;
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilList.clear();
    c = 0L;
  }
  
  public static void a(pwp parampwp)
  {
    if (!jdField_a_of_type_JavaUtilList.isEmpty())
    {
      pwp localpwp = (pwp)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
      if (parampwp.b - localpwp.b > jdField_a_of_type_Long) {
        a();
      }
    }
    jdField_a_of_type_JavaUtilList.add(parampwp);
    c += parampwp.jdField_a_of_type_Long;
    if (a())
    {
      parampwp = new ArrayList();
      parampwp.addAll(jdField_a_of_type_JavaUtilList);
      jdField_a_of_type_JavaUtilList.clear();
      pwb.a(parampwp);
    }
  }
  
  public static boolean a()
  {
    return c > b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwo
 * JD-Core Version:    0.7.0.1
 */