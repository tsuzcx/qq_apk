package com.tencent.mobileqq.qassistant.util;

import com.tencent.mobileqq.qassistant.data.JumpInfo;
import com.tencent.mobileqq.statistics.ReportController;

public class ReportUtils
{
  public static void a()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B16E", "0X800B16E", 0, 0, "", "", "", "");
  }
  
  public static void a(int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B171", "0X800B171", paramInt, 0, "", "", "", "");
  }
  
  public static void a(int paramInt, float paramFloat)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B891", "0X800B891", paramInt, 0, "", "", String.valueOf(paramFloat), "");
  }
  
  public static void a(int paramInt, String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B6B2", "0X800B6B2", paramInt, 0, "", "", paramString, "");
  }
  
  public static void a(JumpInfo paramJumpInfo)
  {
    int i;
    if (paramJumpInfo != null) {
      switch (paramJumpInfo.a)
      {
      case 101: 
      case 102: 
      case 104: 
      case 106: 
      case 108: 
      case 109: 
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      if (i > 0) {
        ReportController.b(null, "dc00898", "", "", "0X800B177", "0X800B177", i, 0, "", "", "", "");
      }
      return;
      i = 5;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
      continue;
      i = 9;
      continue;
      i = 10;
      continue;
      i = 11;
      continue;
      i = 12;
      continue;
      i = 13;
    }
  }
  
  public static void a(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B6B3", "0X800B6B3", 0, 0, "", "", paramString, "");
  }
  
  public static void b()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B16B", "0X800B16B", 0, 0, "", "", "", "");
  }
  
  public static void b(int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B170", "0X800B170", paramInt, 0, "", "", "", "");
  }
  
  public static void b(int paramInt, float paramFloat)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B893", "0X800B893", paramInt, 0, "", "", String.valueOf(paramFloat), "");
  }
  
  public static void c()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B169", "0X800B169", 0, 0, "", "", "", "");
  }
  
  public static void c(int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B16F", "0X800B16F", paramInt, 0, "", "", "", "");
  }
  
  public static void d()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B88F", "0X800B88F", 0, 0, "", "", "", "");
  }
  
  public static void d(int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B16C", "0X800B16C", paramInt, 0, "", "", "", "");
  }
  
  public static void e()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B892", "0X800B892", 0, 0, "", "", "", "");
  }
  
  public static void e(int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B168", "0X800B168", paramInt, 0, "", "", "", "");
  }
  
  public static void f(int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B890", "0X800B890", paramInt, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.util.ReportUtils
 * JD-Core Version:    0.7.0.1
 */