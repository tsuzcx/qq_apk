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
    Object localObject = DeviceInfoUtil.getProcessMemory(Process.myPid());
    if (localObject != null)
    {
      long l3 = ((Debug.MemoryInfo)localObject).getTotalPss() / 1024;
      MiniProgramLpReportDC04902.access$002((MiniProgramLpReportDC04902.access$000() + l3) / 2L);
      if (l3 > MiniProgramLpReportDC04902.access$100()) {
        MiniProgramLpReportDC04902.access$102(l3);
      }
      long l1 = ((Debug.MemoryInfo)localObject).nativePss / 1024;
      long l2 = ((Debug.MemoryInfo)localObject).otherPss / 1024;
      if (MiniProgramLpReportDC04902.access$200() != 0L) {
        l1 = (MiniProgramLpReportDC04902.access$200() + l1) / 2L;
      }
      MiniProgramLpReportDC04902.access$202(l1);
      if (MiniProgramLpReportDC04902.access$300() == 0L) {
        l1 = l2;
      } else {
        l1 = (MiniProgramLpReportDC04902.access$300() + l2) / 2L;
      }
      MiniProgramLpReportDC04902.access$302(l1);
      if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MemoryInfo current:");
        ((StringBuilder)localObject).append(l3);
        ((StringBuilder)localObject).append(", avg:");
        ((StringBuilder)localObject).append(MiniProgramLpReportDC04902.access$000());
        ((StringBuilder)localObject).append(", max:");
        ((StringBuilder)localObject).append(MiniProgramLpReportDC04902.access$100());
        QMLog.d("MiniProgramLpReportDC04902", ((StringBuilder)localObject).toString());
      }
    }
    ThreadManager.getSubThreadHandler().postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04902.1
 * JD-Core Version:    0.7.0.1
 */