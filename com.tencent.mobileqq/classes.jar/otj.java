import java.util.ArrayList;
import java.util.List;

public class otj
{
  public static long a;
  public static List<otk> a;
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
  
  public static void a(otk paramotk)
  {
    if (!jdField_a_of_type_JavaUtilList.isEmpty())
    {
      otk localotk = (otk)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
      if (paramotk.b - localotk.b > jdField_a_of_type_Long) {
        a();
      }
    }
    jdField_a_of_type_JavaUtilList.add(paramotk);
    c += paramotk.jdField_a_of_type_Long;
    if (a())
    {
      paramotk = new ArrayList();
      paramotk.addAll(jdField_a_of_type_JavaUtilList);
      jdField_a_of_type_JavaUtilList.clear();
      osx.a(paramotk);
    }
  }
  
  public static boolean a()
  {
    return c > b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     otj
 * JD-Core Version:    0.7.0.1
 */