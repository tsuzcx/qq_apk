package com.tencent.qqmini.sdk.report;

import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Process;
import bgxv;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;

public final class MiniProgramLpReportDC04902$1
  implements Runnable
{
  public void run()
  {
    Debug.MemoryInfo localMemoryInfo = DeviceInfoUtil.getProcessMemory(Process.myPid());
    long l2;
    if (localMemoryInfo != null)
    {
      l1 = localMemoryInfo.getTotalPss() / 1024;
      bgxv.a((bgxv.a() + l1) / 2L);
      if (l1 > bgxv.b()) {
        bgxv.b(l1);
      }
      l1 = localMemoryInfo.nativePss / 1024;
      l2 = localMemoryInfo.otherPss / 1024;
      if (bgxv.c() != 0L) {
        break label112;
      }
      bgxv.c(l1);
      if (bgxv.d() != 0L) {
        break label125;
      }
    }
    label112:
    label125:
    for (long l1 = l2;; l1 = (bgxv.d() + l2) / 2L)
    {
      bgxv.d(l1);
      ThreadManager.a().postDelayed(this, 1000L);
      return;
      l1 = (l1 + bgxv.c()) / 2L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04902.1
 * JD-Core Version:    0.7.0.1
 */