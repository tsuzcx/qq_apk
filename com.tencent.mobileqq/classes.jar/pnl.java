import java.util.ArrayList;
import java.util.List;

public class pnl
{
  public static long a;
  public static List<pnm> a;
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
  
  public static void a(pnm parampnm)
  {
    if (!jdField_a_of_type_JavaUtilList.isEmpty())
    {
      pnm localpnm = (pnm)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
      if (parampnm.b - localpnm.b > jdField_a_of_type_Long) {
        a();
      }
    }
    jdField_a_of_type_JavaUtilList.add(parampnm);
    c += parampnm.jdField_a_of_type_Long;
    if (a())
    {
      parampnm = new ArrayList();
      parampnm.addAll(jdField_a_of_type_JavaUtilList);
      jdField_a_of_type_JavaUtilList.clear();
      pmy.a(parampnm);
    }
  }
  
  public static boolean a()
  {
    return c > b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pnl
 * JD-Core Version:    0.7.0.1
 */