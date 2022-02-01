package com.tencent.qqperf.repoter;

import com.tencent.qqperf.MagnifierSDK;

final class ReporterMachine$1
  implements IReporter.ReportResultCallback
{
  public void a(int paramInt)
  {
    if (MagnifierSDK.e != null) {
      MagnifierSDK.e.a("result_objects", paramInt, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.repoter.ReporterMachine.1
 * JD-Core Version:    0.7.0.1
 */