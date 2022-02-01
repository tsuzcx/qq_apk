package com.tencent.qqperf.monitor.backgroundcpu;

import com.tencent.qphone.base.util.QLog;
import mqq.app.MainService;

public class BackgroundCpuMonitor$BgCpuTotalCost
{
  long a = 0L;
  long b = 0L;
  
  public void a()
  {
    long l1 = MainService.sReceiverCpuTime;
    long l2 = BackgroundCpuMonitor.a;
    if (this.a == 0L)
    {
      QLog.d("BatteryStats.BgCpu", 1, new Object[] { "bgPrintCpuStart msfrecv=", Long.valueOf(l1), "[", Integer.valueOf(MainService.sNativeTidOfReceiver), "], ", "  fts=", Long.valueOf(l2), "[", Integer.valueOf(BackgroundCpuMonitor.b), "]" });
      this.a = l1;
      this.b = l2;
      return;
    }
    c();
  }
  
  public void b()
  {
    c();
    this.a = 0L;
    this.b = 0L;
  }
  
  void c()
  {
    long l1 = MainService.sReceiverCpuTime;
    long l2 = BackgroundCpuMonitor.a;
    QLog.d("BatteryStats.BgCpu", 1, new Object[] { "bgPrintCpuCostSofar msfrecv=", Long.valueOf(l1 - this.a), "[", Integer.valueOf(MainService.sNativeTidOfReceiver), "], ", "  fts=", Long.valueOf(l2 - this.b), "[", Integer.valueOf(BackgroundCpuMonitor.b), "]" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.backgroundcpu.BackgroundCpuMonitor.BgCpuTotalCost
 * JD-Core Version:    0.7.0.1
 */