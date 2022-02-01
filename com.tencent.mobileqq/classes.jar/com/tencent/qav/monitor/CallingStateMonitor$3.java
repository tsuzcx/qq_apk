package com.tencent.qav.monitor;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.av.service.IQQServiceForAV.Stub;
import com.tencent.qav.log.AVLog;

class CallingStateMonitor$3
  implements ServiceConnection
{
  CallingStateMonitor$3(CallingStateMonitor paramCallingStateMonitor) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AVLog.c("CallingStateMonitor", String.format("onServiceConnected name=%s service=%s", new Object[] { paramComponentName, paramIBinder }));
    CallingStateMonitor.a(this.a, IQQServiceForAV.Stub.a(paramIBinder));
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    AVLog.c("CallingStateMonitor", String.format("onServiceDisconnected name=%s", new Object[] { paramComponentName }));
    CallingStateMonitor.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qav.monitor.CallingStateMonitor.3
 * JD-Core Version:    0.7.0.1
 */