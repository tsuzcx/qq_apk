import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class pwf
{
  public static int a;
  public static long a;
  private static List<pwk> jdField_a_of_type_JavaUtilList;
  private static Map<Integer, pwk> jdField_a_of_type_JavaUtilMap;
  private static int b;
  public static long b;
  public static long c;
  public static long d;
  
  static
  {
    jdField_b_of_type_Int = -1;
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_Int = 2;
    d();
  }
  
  public static void a()
  {
    jdField_b_of_type_Int = -1;
  }
  
  public static void a(int paramInt)
  {
    jdField_b_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    case 3: 
      jdField_b_of_type_Long = System.currentTimeMillis();
      return;
    case 25: 
      c = System.currentTimeMillis();
      return;
    }
    d = System.currentTimeMillis();
  }
  
  public static void a(pwk parampwk)
  {
    if (parampwk == null) {}
    for (;;)
    {
      return;
      try
      {
        if (jdField_a_of_type_JavaUtilList.contains(parampwk)) {
          continue;
        }
        jdField_a_of_type_JavaUtilList.add(parampwk);
      }
      finally {}
    }
  }
  
  private static boolean a()
  {
    if (jdField_b_of_type_Int > 0) {}
    switch (jdField_b_of_type_Int)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static void b()
  {
    try
    {
      jdField_a_of_type_Int = 1;
      pwb.e(System.currentTimeMillis());
      if (a())
      {
        localObject1 = (pwk)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(jdField_b_of_type_Int));
        if (localObject1 != null) {
          ((pwk)localObject1).l();
        }
      }
      Object localObject1 = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        pwk localpwk = (pwk)((Iterator)localObject1).next();
        if (localpwk != null) {
          localpwk.l();
        }
      }
    }
    finally {}
  }
  
  public static void b(pwk parampwk)
  {
    if (parampwk != null) {}
    try
    {
      jdField_a_of_type_JavaUtilList.remove(parampwk);
      return;
    }
    finally
    {
      parampwk = finally;
      throw parampwk;
    }
  }
  
  public static void c()
  {
    try
    {
      jdField_a_of_type_Int = 2;
      if (a())
      {
        localObject1 = (pwk)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(jdField_b_of_type_Int));
        if (localObject1 != null) {
          ((pwk)localObject1).m();
        }
      }
      Object localObject1 = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        pwk localpwk = (pwk)((Iterator)localObject1).next();
        if (localpwk != null) {
          localpwk.m();
        }
      }
    }
    finally {}
  }
  
  private static void d()
  {
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2), new pwg());
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(3), new pwh());
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(25), new pwi());
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(4), new pwj());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwf
 * JD-Core Version:    0.7.0.1
 */