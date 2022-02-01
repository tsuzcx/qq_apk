import java.util.ArrayList;
import java.util.List;

public class plr
{
  public static long a;
  public static List<pls> a;
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
  
  public static void a(pls parampls)
  {
    if (!jdField_a_of_type_JavaUtilList.isEmpty())
    {
      pls localpls = (pls)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
      if (parampls.b - localpls.b > jdField_a_of_type_Long) {
        a();
      }
    }
    jdField_a_of_type_JavaUtilList.add(parampls);
    c += parampls.jdField_a_of_type_Long;
    if (a())
    {
      parampls = new ArrayList();
      parampls.addAll(jdField_a_of_type_JavaUtilList);
      jdField_a_of_type_JavaUtilList.clear();
      ple.a(parampls);
    }
  }
  
  public static boolean a()
  {
    return c > b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     plr
 * JD-Core Version:    0.7.0.1
 */