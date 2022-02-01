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
    if (paramJumpInfo != null)
    {
      int i = paramJumpInfo.a;
      if (i != 100)
      {
        if (i != 103)
        {
          if (i != 105)
          {
            if (i != 107) {
              switch (i)
              {
              default: 
                i = 0;
                break;
              case 114: 
                i = 10;
                break;
              case 113: 
                i = 9;
                break;
              case 112: 
                i = 8;
                break;
              case 111: 
                i = 6;
                break;
              case 110: 
                i = 5;
                break;
              }
            } else {
              i = 12;
            }
          }
          else {
            i = 11;
          }
        }
        else {
          i = 13;
        }
      }
      else {
        i = 7;
      }
      if (i > 0) {
        ReportController.b(null, "dc00898", "", "", "0X800B177", "0X800B177", i, 0, "", "", "", "");
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.util.ReportUtils
 * JD-Core Version:    0.7.0.1
 */