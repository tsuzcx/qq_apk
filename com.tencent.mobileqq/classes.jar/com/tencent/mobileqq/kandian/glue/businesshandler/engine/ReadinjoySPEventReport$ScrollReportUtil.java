package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import java.util.ArrayList;
import java.util.List;

public class ReadinjoySPEventReport$ScrollReportUtil
{
  public static long a = -1L;
  public static long b = -1L;
  public static long c;
  public static List<ReadinjoySPEventReport.ScrollStep> d = new ArrayList();
  
  public static void a(ReadinjoySPEventReport.ScrollStep paramScrollStep)
  {
    if (!d.isEmpty())
    {
      Object localObject = d;
      localObject = (ReadinjoySPEventReport.ScrollStep)((List)localObject).get(((List)localObject).size() - 1);
      if (paramScrollStep.c - ((ReadinjoySPEventReport.ScrollStep)localObject).c > a) {
        b();
      }
    }
    d.add(paramScrollStep);
    c += paramScrollStep.b;
    if (a())
    {
      paramScrollStep = new ArrayList();
      paramScrollStep.addAll(d);
      d.clear();
      ReadinjoySPEventReport.a(paramScrollStep);
    }
  }
  
  public static boolean a()
  {
    return c > b;
  }
  
  public static void b()
  {
    d.clear();
    c = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ScrollReportUtil
 * JD-Core Version:    0.7.0.1
 */