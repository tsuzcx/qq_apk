package com.tencent.open.agent.report;

import com.tencent.mobileqq.app.AppConstants;

public class ReportDef$RepUtil
{
  public static int a(int paramInt)
  {
    int j = 2;
    int i = j;
    if (paramInt != 1)
    {
      i = j;
      if (paramInt != 2)
      {
        if (paramInt == 4) {
          return 2;
        }
        if (paramInt == 5) {
          return 1;
        }
        i = 3;
      }
    }
    return i;
  }
  
  public static int a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 3000) {
      return 2;
    }
    if (AppConstants.QZONE_UIN.equals(paramString)) {
      return 3;
    }
    if (AppConstants.FAVORITES_UIN.equals(paramString)) {
      return 4;
    }
    if (AppConstants.DATALINE_IPAD_UIN.equals(paramString)) {
      return 5;
    }
    return -1;
  }
  
  public static int b(int paramInt)
  {
    int i = 4;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 9) {
              return -1;
            }
          }
          else {
            return 3;
          }
        }
        else {
          return 2;
        }
      }
      else {
        return 1;
      }
    }
    else {
      i = 0;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportDef.RepUtil
 * JD-Core Version:    0.7.0.1
 */