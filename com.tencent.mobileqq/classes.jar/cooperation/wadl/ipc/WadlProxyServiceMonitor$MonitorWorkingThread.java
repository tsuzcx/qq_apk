package cooperation.wadl.ipc;

import bdoe;
import bibr;
import com.tencent.qphone.base.util.QLog;

class WadlProxyServiceMonitor$MonitorWorkingThread
  extends Thread
{
  public volatile boolean a = true;
  
  private WadlProxyServiceMonitor$MonitorWorkingThread(WadlProxyServiceMonitor paramWadlProxyServiceMonitor) {}
  
  public void run()
  {
    try
    {
      while (this.a)
      {
        Thread.sleep(WadlProxyServiceMonitor.a(this.this$0));
        long l = System.currentTimeMillis();
        if ((WadlProxyServiceMonitor.b(this.this$0) != 0L) && (l - WadlProxyServiceMonitor.b(this.this$0) > 30000L) && (WadlProxyServiceMonitor.a(this.this$0)) && (WadlProxyServiceMonitor.a(this.this$0) != null))
        {
          if (QLog.isColorLevel()) {
            bdoe.b(WadlProxyServiceMonitor.a(), "##@<<<MonitorWorkingThread: check ipc service status...");
          }
          WadlProxyServiceMonitor.a(this.this$0).a();
        }
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyServiceMonitor.MonitorWorkingThread
 * JD-Core Version:    0.7.0.1
 */