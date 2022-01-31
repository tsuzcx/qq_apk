import java.util.ArrayList;
import java.util.List;

public class otm
{
  public static long a;
  public static List<otn> a;
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
  
  public static void a(otn paramotn)
  {
    if (!jdField_a_of_type_JavaUtilList.isEmpty())
    {
      otn localotn = (otn)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
      if (paramotn.b - localotn.b > jdField_a_of_type_Long) {
        a();
      }
    }
    jdField_a_of_type_JavaUtilList.add(paramotn);
    c += paramotn.jdField_a_of_type_Long;
    if (a())
    {
      paramotn = new ArrayList();
      paramotn.addAll(jdField_a_of_type_JavaUtilList);
      jdField_a_of_type_JavaUtilList.clear();
      ota.a(paramotn);
    }
  }
  
  public static boolean a()
  {
    return c > b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     otm
 * JD-Core Version:    0.7.0.1
 */