import java.util.ArrayList;
import java.util.List;

public class oib
{
  public static long a;
  public static List<oic> a;
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
  
  public static void a(oic paramoic)
  {
    if (!jdField_a_of_type_JavaUtilList.isEmpty())
    {
      oic localoic = (oic)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
      if (paramoic.b - localoic.b > jdField_a_of_type_Long) {
        a();
      }
    }
    jdField_a_of_type_JavaUtilList.add(paramoic);
    c += paramoic.jdField_a_of_type_Long;
    if (a())
    {
      paramoic = new ArrayList();
      paramoic.addAll(jdField_a_of_type_JavaUtilList);
      jdField_a_of_type_JavaUtilList.clear();
      ohp.a(paramoic);
    }
  }
  
  public static boolean a()
  {
    return c > b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oib
 * JD-Core Version:    0.7.0.1
 */