package com.tencent.qqmini.sdk.report;

import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Process;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;

final class MiniProgramLpReportDC04902$1
  implements Runnable
{
  public void run()
  {
    Debug.MemoryInfo localMemoryInfo = DeviceInfoUtil.getProcessMemory(Process.myPid());
    long l3;
    long l2;
    if (localMemoryInfo != null)
    {
      l3 = localMemoryInfo.getTotalPss() / 1024;
      MiniProgramLpReportDC04902.access$002((MiniProgramLpReportDC04902.access$000() + l3) / 2L);
      if (l3 > MiniProgramLpReportDC04902.access$100()) {
        MiniProgramLpReportDC04902.access$102(l3);
      }
      l1 = localMemoryInfo.nativePss / 1024;
      l2 = localMemoryInfo.otherPss / 1024;
      if (MiniProgramLpReportDC04902.access$200() != 0L) {
        break label177;
      }
      MiniProgramLpReportDC04902.access$202(l1);
      if (MiniProgramLpReportDC04902.access$300() != 0L) {
        break label190;
      }
    }
    label177:
    label190:
    for (long l1 = l2;; l1 = (MiniProgramLpReportDC04902.access$300() + l2) / 2L)
    {
      MiniProgramLpReportDC04902.access$302(l1);
      if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
        QMLog.d("MiniProgramLpReportDC04902", "MemoryInfo current:" + l3 + ", avg:" + MiniProgramLpReportDC04902.access$000() + ", max:" + MiniProgramLpReportDC04902.access$100());
      }
      ThreadManager.getSubThreadHandler().postDelayed(this, 1000L);
      return;
      l1 = (l1 + MiniProgramLpReportDC04902.access$200()) / 2L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04902.1
 * JD-Core Version:    0.7.0.1
 */