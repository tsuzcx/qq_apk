package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.kandian.repo.feeds.IForeBackGroundCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReadinjoySPEventReport$ForeBackGround
{
  public static int a = 0;
  public static long a = 0L;
  private static List<IForeBackGroundCallback> jdField_a_of_type_JavaUtilList;
  private static Map<Integer, IForeBackGroundCallback> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private static int b = -1;
  public static long b;
  public static long c;
  public static long d;
  
  static
  {
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
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 25) {
            return;
          }
          c = System.currentTimeMillis();
          return;
        }
        d = System.currentTimeMillis();
        return;
      }
      jdField_b_of_type_Long = System.currentTimeMillis();
      return;
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public static void a(IForeBackGroundCallback paramIForeBackGroundCallback)
  {
    if (paramIForeBackGroundCallback == null) {
      return;
    }
    try
    {
      if (!jdField_a_of_type_JavaUtilList.contains(paramIForeBackGroundCallback)) {
        jdField_a_of_type_JavaUtilList.add(paramIForeBackGroundCallback);
      }
      return;
    }
    finally
    {
      paramIForeBackGroundCallback = finally;
      throw paramIForeBackGroundCallback;
    }
  }
  
  private static boolean a()
  {
    int i = jdField_b_of_type_Int;
    return (i > 0) && ((i == 2) || (i == 3) || (i == 4) || (i == 25));
  }
  
  public static void b()
  {
    try
    {
      jdField_a_of_type_Int = 1;
      ReadinjoySPEventReport.e(System.currentTimeMillis());
      if (a())
      {
        localObject1 = (IForeBackGroundCallback)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(jdField_b_of_type_Int));
        if (localObject1 != null) {
          ((IForeBackGroundCallback)localObject1).a();
        }
      }
      Object localObject1 = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        IForeBackGroundCallback localIForeBackGroundCallback = (IForeBackGroundCallback)((Iterator)localObject1).next();
        if (localIForeBackGroundCallback != null) {
          localIForeBackGroundCallback.a();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static void b(IForeBackGroundCallback paramIForeBackGroundCallback)
  {
    if (paramIForeBackGroundCallback != null) {}
    try
    {
      jdField_a_of_type_JavaUtilList.remove(paramIForeBackGroundCallback);
    }
    finally {}
  }
  
  public static void c()
  {
    try
    {
      jdField_a_of_type_Int = 2;
      if (a())
      {
        localObject1 = (IForeBackGroundCallback)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(jdField_b_of_type_Int));
        if (localObject1 != null) {
          ((IForeBackGroundCallback)localObject1).ax_();
        }
      }
      Object localObject1 = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        IForeBackGroundCallback localIForeBackGroundCallback = (IForeBackGroundCallback)((Iterator)localObject1).next();
        if (localIForeBackGroundCallback != null) {
          localIForeBackGroundCallback.ax_();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private static void d()
  {
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2), new ReadinjoySPEventReport.ForeBackGround.1());
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(3), new ReadinjoySPEventReport.ForeBackGround.2());
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(25), new ReadinjoySPEventReport.ForeBackGround.3());
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(4), new ReadinjoySPEventReport.ForeBackGround.4());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ForeBackGround
 * JD-Core Version:    0.7.0.1
 */