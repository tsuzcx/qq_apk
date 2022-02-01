package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;

final class FinalDataTarget$4
  implements Runnable
{
  FinalDataTarget$4(FinalData paramFinalData) {}
  
  public void run()
  {
    ReusablePool.recycle(this.a, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.FinalDataTarget.4
 * JD-Core Version:    0.7.0.1
 */