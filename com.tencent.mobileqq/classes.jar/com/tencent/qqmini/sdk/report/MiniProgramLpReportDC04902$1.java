package com.tencent.qqmini.sdk.report;

import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Process;
import beiw;
import beyj;
import bffs;

public final class MiniProgramLpReportDC04902$1
  implements Runnable
{
  public void run()
  {
    Debug.MemoryInfo localMemoryInfo = bffs.a(Process.myPid());
    long l2;
    if (localMemoryInfo != null)
    {
      l1 = localMemoryInfo.getTotalPss() / 1024;
      beyj.a((beyj.a() + l1) / 2L);
      if (l1 > beyj.b()) {
        beyj.b(l1);
      }
      l1 = localMemoryInfo.nativePss / 1024;
      l2 = localMemoryInfo.otherPss / 1024;
      if (beyj.c() != 0L) {
        break label112;
      }
      beyj.c(l1);
      if (beyj.d() != 0L) {
        break label125;
      }
    }
    label112:
    label125:
    for (long l1 = l2;; l1 = (beyj.d() + l2) / 2L)
    {
      beyj.d(l1);
      beiw.a().postDelayed(this, 1000L);
      return;
      l1 = (l1 + beyj.c()) / 2L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04902.1
 * JD-Core Version:    0.7.0.1
 */