package com.tencent.qqperf.repoter;

import com.tencent.qqperf.MagnifierSDK;

class ReporterMachine$InsertRunnable
  implements Runnable
{
  private ResultObject a;
  
  public ReporterMachine$InsertRunnable(ResultObject paramResultObject)
  {
    this.a = paramResultObject;
  }
  
  public void run()
  {
    if (MagnifierSDK.e != null) {
      MagnifierSDK.e.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.repoter.ReporterMachine.InsertRunnable
 * JD-Core Version:    0.7.0.1
 */