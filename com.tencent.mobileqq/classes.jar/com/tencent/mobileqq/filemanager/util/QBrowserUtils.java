package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.statistics.ReportController;

public class QBrowserUtils
{
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 8: 
    default: 
      return 10;
    case 10: 
      return 5;
    case 9: 
      return 4;
    case 7: 
      return 3;
    case 6: 
      return 2;
    case 4: 
      return 6;
    case 3: 
      return 1;
    case 2: 
      return 8;
    case 1: 
      return 9;
    }
    return 7;
  }
  
  public static String a(long paramLong)
  {
    if (paramLong <= 0L) {
      return "00:00:00";
    }
    paramLong /= 1000L;
    long l = paramLong / 3600L;
    if (l > 9L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("");
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(l);
    }
    String str1 = ((StringBuilder)localObject).toString();
    paramLong %= 3600L;
    l = paramLong / 60L;
    if (l > 9L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("");
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(l);
    }
    String str2 = ((StringBuilder)localObject).toString();
    paramLong %= 60L;
    if (paramLong > 9L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("");
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(paramLong);
    }
    Object localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(":");
    localStringBuilder.append(str2);
    localStringBuilder.append(":");
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public static void a(long paramLong)
  {
    int i;
    if (paramLong < 51200L) {
      i = 1;
    } else if (paramLong < 102400L) {
      i = 2;
    } else if (paramLong < 512000L) {
      i = 3;
    } else if (paramLong < 1024000L) {
      i = 4;
    } else if (paramLong < 3072000L) {
      i = 5;
    } else if (paramLong < 10240000L) {
      i = 6;
    } else {
      i = 7;
    }
    ReportController.b(null, "dc00898", "", "", "0X800ADC0", "0X800ADC0", i, 0, "", "", "", "");
  }
  
  public static int b(int paramInt)
  {
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 6)
        {
          if (paramInt != 7)
          {
            if (paramInt != 9) {
              return 6;
            }
            return 4;
          }
          return 2;
        }
        return 3;
      }
      return 5;
    }
    return 1;
  }
  
  public static int c(int paramInt)
  {
    if (paramInt != 13) {
      switch (paramInt)
      {
      default: 
        return -1;
      case 5: 
      case 6: 
        return 3000;
      case 1: 
      case 2: 
        return 0;
      }
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QBrowserUtils
 * JD-Core Version:    0.7.0.1
 */