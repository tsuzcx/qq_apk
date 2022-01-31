import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class pdz
{
  public static int a;
  public static long a;
  public static long b;
  public static long c;
  
  public static void a(int paramInt, sfg paramsfg)
  {
    if ((pdy.a()) && (paramsfg != null))
    {
      if (paramInt != 1) {
        break label23;
      }
      paramsfg.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    label23:
    while (paramsfg.jdField_a_of_type_Long == 0L) {
      return;
    }
    switch (paramInt)
    {
    default: 
      QLog.d("RIJImageOptReport", 1, "unknown type: " + paramInt + " " + paramsfg);
      return;
    case 2: 
      paramsfg.b = System.currentTimeMillis();
      return;
    case 3: 
      paramsfg.c = System.currentTimeMillis();
      return;
    case 4: 
      paramsfg.jdField_d_of_type_Long = System.currentTimeMillis();
      return;
    case 5: 
      paramsfg.g = System.currentTimeMillis();
      return;
    }
    paramsfg.h = System.currentTimeMillis();
  }
  
  private static void a(sfg paramsfg)
  {
    long l2 = paramsfg.c;
    long l3 = paramsfg.b;
    long l4 = paramsfg.jdField_d_of_type_Long - paramsfg.c;
    long l5 = paramsfg.jdField_e_of_type_Long;
    long l6 = paramsfg.f;
    if (paramsfg.g > 0L) {}
    for (long l1 = paramsfg.h - paramsfg.g;; l1 = 0L)
    {
      long l7 = paramsfg.h - paramsfg.jdField_a_of_type_Long;
      int i = paramsfg.jdField_d_of_type_Int;
      int j = paramsfg.jdField_e_of_type_Int;
      paramsfg = paramsfg.jdField_a_of_type_JavaLangString;
      HashMap localHashMap = new HashMap();
      localHashMap.put("subThreadWaitTime", l2 - l3 + "");
      localHashMap.put("threadPoolWaitTime", l4 + "");
      localHashMap.put("downloadAndWriteFileTime", l5 + "");
      localHashMap.put("decodeTime", l6 + "");
      localHashMap.put("mainThreadWaitTime", l1 + "");
      localHashMap.put("cacheType", i + "");
      localHashMap.put("errMsg", paramsfg);
      szp.a(j, 6, l7, localHashMap);
      if (QLog.isColorLevel())
      {
        jdField_a_of_type_Int += 1;
        jdField_a_of_type_Long += l7;
        b += l4;
        c = l1 + c;
        if (jdField_a_of_type_Int == 100)
        {
          QLog.d("RIJImageOptReport", 2, "average  total: " + (float)jdField_a_of_type_Long / jdField_a_of_type_Int + " threapool: " + (float)b / jdField_a_of_type_Int + " mainthread: " + (float)c / jdField_a_of_type_Int);
          jdField_a_of_type_Int = 0;
        }
      }
      return;
    }
  }
  
  public static void a(sfg paramsfg, boolean paramBoolean, String paramString)
  {
    if (a(paramsfg))
    {
      a(6, paramsfg);
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int i = 0;; i = -1)
    {
      paramsfg.jdField_e_of_type_Int = i;
      paramsfg.jdField_a_of_type_JavaLangString = paramString;
      a(paramsfg);
      return;
    }
  }
  
  private static boolean a(sfg paramsfg)
  {
    return (pdy.a()) && (paramsfg != null) && (paramsfg.jdField_a_of_type_Long != 0L);
  }
  
  public static void b(int paramInt, sfg paramsfg)
  {
    if (a(paramsfg)) {
      paramsfg.jdField_d_of_type_Int = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pdz
 * JD-Core Version:    0.7.0.1
 */