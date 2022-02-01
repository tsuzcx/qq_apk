package com.tencent.mobileqq.mini.report;

import android.os.Debug.MemoryInfo;
import android.os.Process;
import bgln;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

final class MiniProgramLpReportDC04902$1
  implements Runnable
{
  public void run()
  {
    Debug.MemoryInfo localMemoryInfo = bgln.a(Process.myPid());
    long l2;
    if (localMemoryInfo != null)
    {
      l1 = localMemoryInfo.getTotalPss() / 1024;
      MiniProgramLpReportDC04902.access$002((MiniProgramLpReportDC04902.access$000() + l1) / 2L);
      if (l1 > MiniProgramLpReportDC04902.access$100()) {
        MiniProgramLpReportDC04902.access$102(l1);
      }
      l1 = localMemoryInfo.nativePss / 1024;
      l2 = localMemoryInfo.otherPss / 1024;
      if (MiniProgramLpReportDC04902.access$200() != 0L) {
        break label112;
      }
      MiniProgramLpReportDC04902.access$202(l1);
      if (MiniProgramLpReportDC04902.access$300() != 0L) {
        break label125;
      }
    }
    label112:
    label125:
    for (long l1 = l2;; l1 = (MiniProgramLpReportDC04902.access$300() + l2) / 2L)
    {
      MiniProgramLpReportDC04902.access$302(l1);
      ThreadManager.getSubThreadHandler().postDelayed(this, 1000L);
      return;
      l1 = (l1 + MiniProgramLpReportDC04902.access$200()) / 2L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04902.1
 * JD-Core Version:    0.7.0.1
 */