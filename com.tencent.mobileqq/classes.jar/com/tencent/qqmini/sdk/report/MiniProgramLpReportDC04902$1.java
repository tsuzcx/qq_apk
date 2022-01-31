package com.tencent.qqmini.sdk.report;

import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Process;
import bejn;
import beza;
import bfgj;

public final class MiniProgramLpReportDC04902$1
  implements Runnable
{
  public void run()
  {
    Debug.MemoryInfo localMemoryInfo = bfgj.a(Process.myPid());
    long l2;
    if (localMemoryInfo != null)
    {
      l1 = localMemoryInfo.getTotalPss() / 1024;
      beza.a((beza.a() + l1) / 2L);
      if (l1 > beza.b()) {
        beza.b(l1);
      }
      l1 = localMemoryInfo.nativePss / 1024;
      l2 = localMemoryInfo.otherPss / 1024;
      if (beza.c() != 0L) {
        break label112;
      }
      beza.c(l1);
      if (beza.d() != 0L) {
        break label125;
      }
    }
    label112:
    label125:
    for (long l1 = l2;; l1 = (beza.d() + l2) / 2L)
    {
      beza.d(l1);
      bejn.a().postDelayed(this, 1000L);
      return;
      l1 = (l1 + beza.c()) / 2L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04902.1
 * JD-Core Version:    0.7.0.1
 */