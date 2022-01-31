import java.util.ArrayList;
import java.util.List;

public class oyb
{
  public static long a;
  public static List<oyc> a;
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
  
  public static void a(oyc paramoyc)
  {
    if (!jdField_a_of_type_JavaUtilList.isEmpty())
    {
      oyc localoyc = (oyc)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
      if (paramoyc.b - localoyc.b > jdField_a_of_type_Long) {
        a();
      }
    }
    jdField_a_of_type_JavaUtilList.add(paramoyc);
    c += paramoyc.jdField_a_of_type_Long;
    if (a())
    {
      paramoyc = new ArrayList();
      paramoyc.addAll(jdField_a_of_type_JavaUtilList);
      jdField_a_of_type_JavaUtilList.clear();
      oxp.a(paramoyc);
    }
  }
  
  public static boolean a()
  {
    return c > b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oyb
 * JD-Core Version:    0.7.0.1
 */