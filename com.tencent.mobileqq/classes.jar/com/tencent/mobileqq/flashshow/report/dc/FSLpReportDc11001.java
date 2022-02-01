package com.tencent.mobileqq.flashshow.report.dc;

import android.os.Handler;
import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.qphone.base.util.QLog;

public class FSLpReportDc11001
{
  public static void a(DataBuilder paramDataBuilder)
  {
    if (paramDataBuilder == null)
    {
      QLog.e("FSLpReportDc11001", 1, "DataBuilder == null");
      return;
    }
    FSReporter.a().c().post(new FSLpReportDc11001.1(paramDataBuilder));
  }
  
  private static int b()
  {
    return 11001;
  }
  
  private static boolean b(int paramInt1, int paramInt2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001
 * JD-Core Version:    0.7.0.1
 */