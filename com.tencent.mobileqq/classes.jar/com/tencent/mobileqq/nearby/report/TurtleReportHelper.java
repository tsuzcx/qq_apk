package com.tencent.mobileqq.nearby.report;

import android.content.Context;
import com.tencent.mobileqq.utils.NetworkUtil;

public class TurtleReportHelper
{
  public static int a(Context paramContext)
  {
    int i = NetworkUtil.b(paramContext);
    if (i == 1) {
      return 2;
    }
    if (i == 2) {
      return 3;
    }
    if (i == 3) {
      return 4;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.report.TurtleReportHelper
 * JD-Core Version:    0.7.0.1
 */