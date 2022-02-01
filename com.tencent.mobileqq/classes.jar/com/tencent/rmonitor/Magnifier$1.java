package com.tencent.rmonitor;

import com.tencent.rmonitor.manager.RMonitorLauncher;

final class Magnifier$1
  implements Runnable
{
  Magnifier$1(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = this.a;
    if (i == 1)
    {
      RMonitorLauncher.a.a();
      RMonitorLauncher.a.a(this.b);
      return;
    }
    if (i == 2)
    {
      RMonitorLauncher.a.b(this.b);
      return;
    }
    if (i == 3) {
      RMonitorLauncher.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.Magnifier.1
 * JD-Core Version:    0.7.0.1
 */