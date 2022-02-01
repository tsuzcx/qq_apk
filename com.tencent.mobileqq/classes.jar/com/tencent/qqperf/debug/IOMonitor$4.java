package com.tencent.qqperf.debug;

import mqq.app.MobileQQ;

class IOMonitor$4
  implements Runnable
{
  public void run()
  {
    if (IOMonitor.a() != null)
    {
      IOMonitor.a().a();
      IOMonitor.b = true;
    }
    if (IOMonitor.a() != null)
    {
      IOMonitor.a().a();
      IOMonitor.a = true;
    }
    if (1 == MobileQQ.sProcessId) {
      IOMonitor.a(900, 80);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.debug.IOMonitor.4
 * JD-Core Version:    0.7.0.1
 */