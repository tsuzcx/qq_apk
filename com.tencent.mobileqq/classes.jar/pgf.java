import java.util.ArrayList;
import java.util.List;

public class pgf
{
  public static long a;
  public static List<pgg> a;
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
  
  public static void a(pgg parampgg)
  {
    if (!jdField_a_of_type_JavaUtilList.isEmpty())
    {
      pgg localpgg = (pgg)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
      if (parampgg.b - localpgg.b > jdField_a_of_type_Long) {
        a();
      }
    }
    jdField_a_of_type_JavaUtilList.add(parampgg);
    c += parampgg.jdField_a_of_type_Long;
    if (a())
    {
      parampgg = new ArrayList();
      parampgg.addAll(jdField_a_of_type_JavaUtilList);
      jdField_a_of_type_JavaUtilList.clear();
      pfs.a(parampgg);
    }
  }
  
  public static boolean a()
  {
    return c > b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgf
 * JD-Core Version:    0.7.0.1
 */