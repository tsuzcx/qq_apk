package com.tencent.qav.monitor;

import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.qphone.base.util.QLog;

class CallingStateMonitor$1
  implements Runnable
{
  CallingStateMonitor$1(CallingStateMonitor paramCallingStateMonitor) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CallingStateMonitor", 2, "begin init PhoneStatusMonitor");
    }
    if (CallingStateMonitor.a(this.this$0) == null) {
      CallingStateMonitor.a(this.this$0, new PhoneStatusMonitor(CallingStateMonitor.a(this.this$0), this.this$0));
    }
    if (QLog.isColorLevel()) {
      QLog.i("CallingStateMonitor", 2, "end init PhoneStatusMonitor");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qav.monitor.CallingStateMonitor.1
 * JD-Core Version:    0.7.0.1
 */