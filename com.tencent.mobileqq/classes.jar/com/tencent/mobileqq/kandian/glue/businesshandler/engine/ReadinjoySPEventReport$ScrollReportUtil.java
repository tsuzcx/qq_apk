package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import java.util.ArrayList;
import java.util.List;

public class ReadinjoySPEventReport$ScrollReportUtil
{
  public static long a = -1L;
  public static List<ReadinjoySPEventReport.ScrollStep> a;
  public static long b = -1L;
  public static long c;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilList.clear();
    c = 0L;
  }
  
  public static void a(ReadinjoySPEventReport.ScrollStep paramScrollStep)
  {
    if (!jdField_a_of_type_JavaUtilList.isEmpty())
    {
      Object localObject = jdField_a_of_type_JavaUtilList;
      localObject = (ReadinjoySPEventReport.ScrollStep)((List)localObject).get(((List)localObject).size() - 1);
      if (paramScrollStep.b - ((ReadinjoySPEventReport.ScrollStep)localObject).b > jdField_a_of_type_Long) {
        a();
      }
    }
    jdField_a_of_type_JavaUtilList.add(paramScrollStep);
    c += paramScrollStep.jdField_a_of_type_Long;
    if (a())
    {
      paramScrollStep = new ArrayList();
      paramScrollStep.addAll(jdField_a_of_type_JavaUtilList);
      jdField_a_of_type_JavaUtilList.clear();
      ReadinjoySPEventReport.a(paramScrollStep);
    }
  }
  
  public static boolean a()
  {
    return c > b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ScrollReportUtil
 * JD-Core Version:    0.7.0.1
 */