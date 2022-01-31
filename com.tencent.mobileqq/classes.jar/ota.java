import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ota
{
  public static int a;
  public static long a;
  private static List<otf> jdField_a_of_type_JavaUtilList;
  private static Map<Integer, otf> jdField_a_of_type_JavaUtilMap;
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
  
  public static void a(otf paramotf)
  {
    if (paramotf == null) {}
    for (;;)
    {
      return;
      try
      {
        if (jdField_a_of_type_JavaUtilList.contains(paramotf)) {
          continue;
        }
        jdField_a_of_type_JavaUtilList.add(paramotf);
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
      osx.e(System.currentTimeMillis());
      if (a())
      {
        localObject1 = (otf)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(jdField_b_of_type_Int));
        if (localObject1 != null) {
          ((otf)localObject1).l();
        }
      }
      Object localObject1 = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        otf localotf = (otf)((Iterator)localObject1).next();
        if (localotf != null) {
          localotf.l();
        }
      }
    }
    finally {}
  }
  
  public static void b(otf paramotf)
  {
    if (paramotf != null) {}
    try
    {
      jdField_a_of_type_JavaUtilList.remove(paramotf);
      return;
    }
    finally
    {
      paramotf = finally;
      throw paramotf;
    }
  }
  
  public static void c()
  {
    try
    {
      jdField_a_of_type_Int = 2;
      if (a())
      {
        localObject1 = (otf)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(jdField_b_of_type_Int));
        if (localObject1 != null) {
          ((otf)localObject1).m();
        }
      }
      Object localObject1 = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        otf localotf = (otf)((Iterator)localObject1).next();
        if (localotf != null) {
          localotf.m();
        }
      }
    }
    finally {}
  }
  
  private static void d()
  {
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2), new otb());
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(3), new otc());
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(25), new otd());
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(4), new ote());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ota
 * JD-Core Version:    0.7.0.1
 */