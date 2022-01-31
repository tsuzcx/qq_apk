import android.util.Log;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class rnx
{
  private static String jdField_a_of_type_JavaLangString = "TimeUtil";
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(new HashMap(8));
  
  public static long a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      long l1 = System.currentTimeMillis();
      long l2 = l1 - ((Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
      Log.d(jdField_a_of_type_JavaLangString, paramString + " end spent time : " + l2 + "      end time " + l1);
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      return l2;
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
    Log.d(jdField_a_of_type_JavaLangString, paramString + " start time : " + System.currentTimeMillis());
    return -1L;
  }
  
  public static long b(String paramString)
  {
    paramString = (Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
    if (paramString == null) {
      return -1L;
    }
    return paramString.longValue();
  }
  
  public static long c(String paramString)
  {
    long l = -1L;
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      l = ((Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString)).longValue();
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rnx
 * JD-Core Version:    0.7.0.1
 */