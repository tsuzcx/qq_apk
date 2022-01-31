package com.tencent.qqmini.sdk.report;

import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Process;
import bdew;
import bdsm;
import bdym;

public final class MiniProgramLpReportDC04902$1
  implements Runnable
{
  public void run()
  {
    Debug.MemoryInfo localMemoryInfo = bdym.a(Process.myPid());
    long l2;
    if (localMemoryInfo != null)
    {
      l1 = localMemoryInfo.getTotalPss() / 1024;
      bdsm.a((bdsm.a() + l1) / 2L);
      if (l1 > bdsm.b()) {
        bdsm.b(l1);
      }
      l1 = localMemoryInfo.nativePss / 1024;
      l2 = localMemoryInfo.otherPss / 1024;
      if (bdsm.c() != 0L) {
        break label112;
      }
      bdsm.c(l1);
      if (bdsm.d() != 0L) {
        break label125;
      }
    }
    label112:
    label125:
    for (long l1 = l2;; l1 = (bdsm.d() + l2) / 2L)
    {
      bdsm.d(l1);
      bdew.a().postDelayed(this, 1000L);
      return;
      l1 = (l1 + bdsm.c()) / 2L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04902.1
 * JD-Core Version:    0.7.0.1
 */