package com.tencent.mobileqq.filemanager.fileviewer;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class QFileBrowserUtils
{
  public static int a(int paramInt)
  {
    int i = 4;
    if (paramInt != 2) {
      if (paramInt != 4) {
        if (paramInt == 13) {
          break label79;
        }
      }
    }
    switch (paramInt)
    {
    default: 
      i = 9;
      break;
    case 10: 
      i = 5;
      break;
    case 7: 
    case 8: 
    case 9: 
      i = 6;
      break;
      i = 8;
      break;
    case 6: 
      label79:
      i = 7;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getVideoQRReportFromType: reportFromType[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      QLog.i("QFileBrowserUtils", 1, localStringBuilder.toString());
    }
    return i;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.QFileBrowserUtils
 * JD-Core Version:    0.7.0.1
 */