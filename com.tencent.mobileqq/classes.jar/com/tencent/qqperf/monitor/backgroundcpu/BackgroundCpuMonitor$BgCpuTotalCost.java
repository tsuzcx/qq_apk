package com.tencent.qqperf.monitor.backgroundcpu;

import com.tencent.qphone.base.util.QLog;
import mqq.app.MainService;

public class BackgroundCpuMonitor$BgCpuTotalCost
{
  long a;
  long b = 0L;
  
  public BackgroundCpuMonitor$BgCpuTotalCost()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a()
  {
    long l1 = MainService.sReceiverCpuTime;
    long l2 = BackgroundCpuMonitor.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_Long == 0L)
    {
      QLog.d("BatteryStats.BgCpu", 1, new Object[] { "bgPrintCpuStart msfrecv=", Long.valueOf(l1), "[", Integer.valueOf(MainService.sNativeTidOfReceiver), "], ", "  fts=", Long.valueOf(l2), "[", Integer.valueOf(BackgroundCpuMonitor.jdField_a_of_type_Int), "]" });
      this.jdField_a_of_type_Long = l1;
      this.b = l2;
      return;
    }
    c();
  }
  
  public void b()
  {
    c();
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
  }
  
  void c()
  {
    long l1 = MainService.sReceiverCpuTime;
    long l2 = BackgroundCpuMonitor.jdField_a_of_type_Long;
    QLog.d("BatteryStats.BgCpu", 1, new Object[] { "bgPrintCpuCostSofar msfrecv=", Long.valueOf(l1 - this.jdField_a_of_type_Long), "[", Integer.valueOf(MainService.sNativeTidOfReceiver), "], ", "  fts=", Long.valueOf(l2 - this.b), "[", Integer.valueOf(BackgroundCpuMonitor.jdField_a_of_type_Int), "]" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.backgroundcpu.BackgroundCpuMonitor.BgCpuTotalCost
 * JD-Core Version:    0.7.0.1
 */