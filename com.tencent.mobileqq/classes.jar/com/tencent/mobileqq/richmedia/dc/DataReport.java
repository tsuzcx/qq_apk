package com.tencent.mobileqq.richmedia.dc;

import android.os.Handler;
import android.os.HandlerThread;

public class DataReport
{
  private static HandlerThread a = new HandlerThread("Reportor-Tasker");
  private static DataReport b = new DataReport();
  private Handler c = new Handler(a.getLooper());
  
  static
  {
    a.start();
  }
  
  public static DataReport a()
  {
    return b;
  }
  
  public void a(DataReport.ReportTask paramReportTask)
  {
    if (paramReportTask == null) {
      return;
    }
    this.c.post(paramReportTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DataReport
 * JD-Core Version:    0.7.0.1
 */