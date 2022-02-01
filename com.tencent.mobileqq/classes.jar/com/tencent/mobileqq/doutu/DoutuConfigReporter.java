package com.tencent.mobileqq.doutu;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AIOSingleReporter;

public class DoutuConfigReporter
{
  public static void a()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B547", "0X800B547", 0, 0, "", "", "", "");
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!AIOSingleReporter.a().a(paramMessageRecord, "0X800B547")))
    {
      a();
      AIOSingleReporter.a().a(paramMessageRecord, "0X800B547");
    }
  }
  
  public static void b()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B548", "0X800B548", 0, 0, "", "", "", "");
  }
  
  public static void c()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B549", "0X800B549", 0, 0, "", "", "", "");
  }
  
  public static void d()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B54A", "0X800B54A", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuConfigReporter
 * JD-Core Version:    0.7.0.1
 */