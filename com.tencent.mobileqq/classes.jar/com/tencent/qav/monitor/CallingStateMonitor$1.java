package com.tencent.qav.monitor;

import bjct;
import com.tencent.qphone.base.util.QLog;
import msb;

public class CallingStateMonitor$1
  implements Runnable
{
  public CallingStateMonitor$1(bjct parambjct) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CallingStateMonitor", 2, "begin init PhoneStatusMonitor");
    }
    if (bjct.a(this.this$0) == null) {
      bjct.a(this.this$0, new msb(bjct.a(this.this$0), this.this$0));
    }
    if (QLog.isColorLevel()) {
      QLog.i("CallingStateMonitor", 2, "end init PhoneStatusMonitor");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qav.monitor.CallingStateMonitor.1
 * JD-Core Version:    0.7.0.1
 */