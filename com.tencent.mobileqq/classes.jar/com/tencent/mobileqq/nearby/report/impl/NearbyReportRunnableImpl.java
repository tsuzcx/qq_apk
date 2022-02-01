package com.tencent.mobileqq.nearby.report.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.report.INearbyReportRunnable;
import com.tencent.mobileqq.statistics.ReportTask;

public class NearbyReportRunnableImpl
  implements INearbyReportRunnable, Runnable
{
  private QQAppInterface app;
  private INearbyCardManager cardManager;
  private String[] extraValues;
  private int method;
  
  private void reportNearbyEntryClkRed()
  {
    int i = this.cardManager.b();
    String[] arrayOfString = this.extraValues;
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {
      arrayOfString[1] = String.valueOf(i);
    }
    new ReportTask(this.app).a("dc00899").b("grp_lbs").c("entry").d("clk_red").a(this.extraValues).a();
  }
  
  private void reportNearbyEntryExp()
  {
    int i = this.cardManager.b();
    new ReportTask(this.app).a("dc00899").b("grp_lbs").c("entry").d("exp").a(new String[] { "", String.valueOf(i), "", "" }).a();
  }
  
  public void init(Object paramObject, int paramInt)
  {
    this.app = ((QQAppInterface)paramObject);
    this.method = paramInt;
  }
  
  public void run()
  {
    int i = this.method;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      reportNearbyEntryClkRed();
      return;
    }
    reportNearbyEntryExp();
  }
  
  public void setCardManager(INearbyCardManager paramINearbyCardManager)
  {
    this.cardManager = paramINearbyCardManager;
  }
  
  public void setExtraValues(String[] paramArrayOfString)
  {
    this.extraValues = paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.report.impl.NearbyReportRunnableImpl
 * JD-Core Version:    0.7.0.1
 */